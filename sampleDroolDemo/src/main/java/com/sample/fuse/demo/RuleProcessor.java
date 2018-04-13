package com.sample.fuse.demo;

import javax.inject.Inject;
import javax.inject.Named;

import org.kie.api.runtime.KieContainer;

@Named("ruleProcessor")
public class RuleProcessor {

	@Inject
	private KieContainer kieContainer;
	
	
}
