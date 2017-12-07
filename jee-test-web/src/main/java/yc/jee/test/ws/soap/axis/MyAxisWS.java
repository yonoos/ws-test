package yc.jee.test.ws.soap.axis;

public class MyAxisWS {

	
	public Integer sum(Integer a, Integer b){
		a = (a==null ? 0 : a);
		b = (b==null ? 0 : b);
		return a+b;
	}
	
	
	public Integer multi(Integer a, Integer b) {
		a = (a==null ? 0 : a);
		b = (b==null ? 0 : b);
		return a*b;
	}
	
}
