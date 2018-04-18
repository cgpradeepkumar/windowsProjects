package com.sample.fuse.demo;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Named("ruleProcessor")
public class RuleProcessor implements Processor{

//	@Inject
	private KieContainer kieContainer;

	@Override
	public void process(Exchange exchange) throws Exception {
		
		System.out.println("Exchange - " + exchange.getIn().getBody());
		String name = exchange.getIn().getBody().toString();
		KieServices kieServices = KieServices.Factory.get();
		if (kieContainer == null) {
			System.out.println("kieContainer is null, try to create it from Factory!");
			kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		}
		
		System.out.println("kieContainer - " + kieContainer);
		
		KieSession kieSession = kieContainer.newKieSession("ksession-rules");
		
		System.out.println("kieSession - " + kieSession);
		
		kieSession.insert(name);
		
		kieSession.fireAllRules();
	}
}
