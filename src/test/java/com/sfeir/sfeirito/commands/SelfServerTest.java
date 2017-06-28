package com.sfeir.sfeirito.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;

import com.sfeir.sfeirito.ExecutionScriptTest;
import com.sfeir.sfeirito.Sfeirito;
import com.sfeir.sfeirito.enums.APIEnum;
import com.sfeir.sfeirito.utils.ExecutionScript;
import com.sfeir.sfeirito.ws.PostJson;

public class SelfServerTest extends ExecutionScriptTest{

	private static Server server;

	@Before
	public void initTest() throws Exception{
		// Create Server
		server = new Server(8081);

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);

		context.addServlet(new ServletHolder(new RequestServlet()),"/*");
		context.addServlet(new ServletHolder(new RequestServlet("Buongiorno Mondo")),"/it/*");
		context.addServlet(new ServletHolder(new RequestServlet("Bonjour le Monde")),"/fr/*");
		context.addServlet(new ServletHolder(new RequestServlet()),	"/allowNext");
		context.addServlet(new ServletHolder(new MockServlet()),	"/getMockResult");


		// Start Server
		server.start();
		//		server.join(); //handle external call ,lock test process
	}

	@AfterClass
	public static void stopJetty()
	{
		try{
			server.stop();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void testRunOk() throws Exception {

		//		Process proc = Sfeirito.executeApi(APIEnum.MOBILE_REQUEST);
		//		List<String> readConsole = ExecutionScript.readConsole(proc);
		//		Assert.assertNotNull(readConsole);
		//		Assert.assertFalse(readConsole.isEmpty());
		//			
		//		System.out.println("ok");
		//		

		PostJson postJson = new PostJson("com.example.ws.WebserviceAPI","getCountries");
		postJson.addArgument("java.lang.String", "FRANCE");

		Process proc = Sfeirito.mock(APIEnum.MOCK_METHOD, postJson);
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.test("com.sfeir.testant.tests.TestWebserviceAPIClass");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());


		List<PostJson> postArray = new ArrayList<PostJson>();

		postJson = new PostJson("com.example.Operation","addition");
		postArray.add(postJson);

		postJson = new PostJson("com.example.Operation","substraction");
		postArray.add(postJson);

		proc = Sfeirito.mock(APIEnum.MOCK_METHOD, postArray);
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		Thread.sleep(1000);

		proc = Sfeirito.test("com.sfeir.testant.tests.TestOperationClass");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}


	public class RequestServlet extends HttpServlet{

		private String greeting="Hello World";

		public RequestServlet(){}

		public RequestServlet(String greeting){
			this.greeting=greeting;
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("<h1>"+greeting+"</h1>");
			response.getWriter().println("session=" + request.getSession(true).getId());
		}
	}

	public class MockServlet extends HttpServlet{

		private String greeting="Hello World";

		public MockServlet(){}

		public MockServlet(String greeting){
			this.greeting=greeting;
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);

			Map<String, String[]> params = request.getParameterMap();

			StringBuilder sb = new StringBuilder();

			if(params.containsKey("method")){
				String[] test = params.get("method");

				if(test.length >0){
					switch (test[0]) {
					case "getCountries":
						
						String complexResultObject =  "{\"classname\":\"com.example.ws.Response\",\"value\":\"{\\\"name\\\": \\\"United States of America\\\", \\\"alpha2_code\\\":\\\"US\\\",\\\"alpha3_code\\\":\\\"USA\\\"}\"}";

						sb.append(complexResultObject);
						break;
						
					case "addition":
						sb.append("{ classname : \"java.lang.Integer\", value : \"6\" }");
						break;

					case "substraction":
						sb.append("{ classname : \"java.lang.Integer\", value : \"1\" }");
						break;
						
					default:
						sb.append("<h1>"+greeting+"</h1>");
						sb.append("session=" + request.getSession(true).getId());
						break;
					}
				}
			}
			response.getWriter().println(sb);

		}
	}



}
