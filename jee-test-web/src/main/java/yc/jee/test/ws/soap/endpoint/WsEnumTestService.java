package yc.jee.test.ws.soap.endpoint;

import javax.json.bind.annotation.JsonbProperty;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import fr.jee.api.WsAbstractEnum;

@WebService
public class WsEnumTestService {

	@XmlType
	@XmlEnum(String.class)
	public enum Status1 implements WsAbstractEnum{
		@XmlEnumValue(value = "good")
		@JsonbProperty(value = "good")
		OK("good"), 
		@XmlEnumValue(value = "bad")
		@JsonbProperty(value = "bad")
		ERROR("bad"), 
		@XmlEnumValue(value = "warn")
		@JsonbProperty(value = "warn")
		KO("warn");
		private final String id;
		Status1(String id){
			this.id = id;
		}
		@Override
		public String getId() {
			return id;
		}
	}
	@XmlType
	@XmlEnum(String.class)
	public enum Status2 implements WsAbstractEnum{
		GOOD, 
		BAD;

		@Override
		public String getId() {
			return name();
		}
	}

	@WebMethod
	public Status1 status(@WebParam(name="stat") Status2 s) {
		if(s != null) {
			switch (s) {
			case BAD:
				return Status1.KO;
			case GOOD:
				return Status1.OK;
			default:
				break;
			}
		}
		return Status1.ERROR;
	}
	

}
