package yc.jee.test.ws.soap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@WebService(name = "SumService", targetNamespace="http://yc.jee.test.ws.soap.endpoint")
public interface IWebServiceSum {

	@WebMethod
	Integer sum(Integer a, Integer b);
	
	@WebMethod
	Integer multi(Integer a, Integer b);
	
	@WebMethod
	public Integer calculate(Integer a, Operator ope, Integer b) ;
	
	@XmlType
	@XmlEnum(String.class)
	public enum Operator {
		ADD,
		MULTI
	}
	
}
