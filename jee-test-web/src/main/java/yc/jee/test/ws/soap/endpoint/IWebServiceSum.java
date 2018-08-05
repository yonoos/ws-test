package yc.jee.test.ws.soap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "SumService", targetNamespace="http://yc.jee.test.ws.soap.endpoint")
public interface IWebServiceSum {

	@WebMethod
	Integer sum(Integer a, Integer b);
	
	@WebMethod
	Integer multi(Integer a, Integer b);
	
}
