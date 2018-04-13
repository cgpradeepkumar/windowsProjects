package com.sample.fuse.demo;

import javax.inject.Named;

@Named("helloBean")
public class HelloBean {

	public String sayHello(String name) {
		return "Hello " + name;
	}

}
