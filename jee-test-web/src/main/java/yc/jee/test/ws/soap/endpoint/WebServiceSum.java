package yc.jee.test.ws.soap.endpoint;

import javax.jws.WebService;

@WebService(endpointInterface="yc.jee.test.ws.soap.endpoint.IWebServiceSum", serviceName="SumService", portName="SumServicePort")
//@HandlerChain(file= MySoapHandler.HANDLER)
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

	@Override
	public Integer calculate(Integer a, Operator ope, Integer b) {
		if(ope ==null) {
			return null;
		}
		switch (ope) {
		case ADD: 
			return (a==null ? 0 : a)+(b==null ? 0 : b);
		case MULTI:
			return (a==null ? 1 : a)*(b==null ? 1 : b);
		default:
			break;
		}
		return null;
	}

}
