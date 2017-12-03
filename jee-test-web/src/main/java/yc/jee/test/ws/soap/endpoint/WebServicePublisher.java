package yc.jee.test.ws.soap.endpoint;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {

	public static void main(String[] args) {
		 Endpoint.publish("http://localhost:9991/ws/SumService", new WebServiceSum());
	}

}
