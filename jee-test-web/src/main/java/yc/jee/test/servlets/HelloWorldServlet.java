package yc.jee.test.servlets;

import java.io.IOException;
import java.util.Set;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jee.ejb.MyEjbRemote;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String LEFT_OPERAND_INPUT_NAME="left_operand"; 
	private static final String RIGHT_OPERAND_INPUT_NAME="right_operand"; 
	private static final String OPERATOR_INPUT_NAME="operator"; 
	private static final String IMPLEMENTED_OPERATORS_INPUT_NAME = "available_operatros";
	private static final String RESULT_MESSAGE_INPUT_NAME = "results";
	private static final String RESULT_HEAP_INFO = "heapInfo";

	
	@EJB(lookup="java:app/jee-test-ejb/add!fr.jee.ejb.MyEjbRemote")
//	@EJB(name="add", beanName="add")
	private  MyEjbRemote addBean;
	
	@EJB(lookup="java:app/jee-test-ejb/multi!fr.jee.ejb.MyEjbRemote")
//	@EJB(name="multi", beanName="multi")
	private  MyEjbRemote multiBean;
	
	@EJB(lookup="java:app/jee-test-ejb/hello!fr.jee.ejb.MyEjbRemote")
//	@EJB(name="hello",beanName="hello")
	private  MyEjbRemote helloBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorldServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(RESULT_MESSAGE_INPUT_NAME, "");
		setView(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String leftOperand = request.getParameter(LEFT_OPERAND_INPUT_NAME);
		String operator = request.getParameter(OPERATOR_INPUT_NAME);
		String rightOperand = request.getParameter(RIGHT_OPERAND_INPUT_NAME);

		request.setAttribute(LEFT_OPERAND_INPUT_NAME, leftOperand);
		request.setAttribute(OPERATOR_INPUT_NAME, operator);
		request.setAttribute(RIGHT_OPERAND_INPUT_NAME, rightOperand);

		request.setAttribute(RESULT_MESSAGE_INPUT_NAME, calculate(operator, leftOperand, rightOperand ));
		setView(request, response);
	}

	private int calculate(String operator, String leftOperand, String rightOperand) {
		int a = Integer.parseInt(leftOperand);
		int b = Integer.parseInt(rightOperand);
		if(addBean == null) {
			System.out.println("hola");
		}

		switch (operator) {
		case "add":	  return addBean.doit(a, b);
		case "multi": return multiBean.doit(a, b);
		case "hello": return helloBean.doit(a, b);
		default:
			break;
		}
		return 0;
	}
	
	protected void doLookup() {
		try {
//			Properties props = new Properties();
//			props.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
//			props.setProperty("java.naming.provider.url","localhost");
//			props.setProperty("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");

			InitialContext ctx = new InitialContext();
			addBean = (MyEjbRemote)ctx.lookup("ejb:jee-test/jee-test-ejb/add!fr.jee.ejb.MyEjbRemote");
			addBean.doit(2, 4);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * set the view
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void setView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Runtime runtime = Runtime.getRuntime();
		String heapInfo = formatSize(runtime.maxMemory())+" "+ formatSize(runtime.totalMemory())+" "+formatSize(runtime.freeMemory());
		
		heapInfo += "<br/>";
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		
		for (Thread t : threadSet) {
			//heapInfo += t.getName()+", "+t.getState() +"<br/>";
		}
		
		request.setAttribute(RESULT_HEAP_INFO, heapInfo);
		request.setAttribute(IMPLEMENTED_OPERATORS_INPUT_NAME, getImplementedOperator());
		this.getServletContext().getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
	}

	/**
	 * get the available operations
	 * @return
	 */
	private String [] getImplementedOperator(){
		return new String[] {"add", "multi","hello"};
	}
	
	public static String formatSize(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double)v / (1L << (z*10)), " KMGTPE".charAt(z));
    }



}
