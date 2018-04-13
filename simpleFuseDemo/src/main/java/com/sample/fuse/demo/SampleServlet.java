package com.sample.fuse.demo;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.ContextName;

@WebServlet(name = "SampleServlet", urlPatterns = {"/*"}, loadOnStartup = 1)
public class SampleServlet extends HttpServlet {
	
	@Inject
	@ContextName("sample-context")
	private CamelContext camelContext;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		ServletOutputStream out = response.getOutputStream();
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		String result = producerTemplate.requestBody("direct:start", name, String.class);
		out.print(result);
	}

}
