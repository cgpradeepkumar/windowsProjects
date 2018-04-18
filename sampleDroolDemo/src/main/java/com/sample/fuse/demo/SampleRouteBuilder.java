package com.sample.fuse.demo;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

@Startup
@ApplicationScoped
@ContextName("sample-context")
public class SampleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start").process(new RuleProcessor()).beanRef("helloBean");
	}

}
