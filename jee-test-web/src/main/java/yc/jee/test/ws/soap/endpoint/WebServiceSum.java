package yc.jee.test.ws.soap.endpoint;

import javax.jws.WebService;

@WebService(endpointInterface="yc.jee.test.ws.soap.endpoint.IWebServiceSum", serviceName="SumService", portName="SumServicePort")
public class WebServiceSum implements IWebServiceSum{
	
	@Override
	public Integer sum(Integer a, Integer b){
		a = (a==null ? 0 : a);
		b = (b==null ? 0 : b);
		return a+b;
	}

	@Override
	public Integer multi(Integer a, Integer b) {
		a = (a==null ? 0 : a);
		b = (b==null ? 0 : b);
		return a*b;
	}

}