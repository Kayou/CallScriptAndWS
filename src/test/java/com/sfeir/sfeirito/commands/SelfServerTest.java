package com.sfeir.sfeirito.commands;

import java.io.IOException;
import java.net.InetAddress;
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
	private static final int port = 8081;

	@Before
	public void initTest() throws Exception{

		server = new Server(port);

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);

		context.addServlet(new ServletHolder(new MockResponseServlet()), "/*");
		context.addServlet(new ServletHolder(new MockResponseServlet()), "/"+MockResponseServlet.servletName);

		server.start();
		//server.join(); //handle external call ,lock test process
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

		String ipAddr = InetAddress.getLocalHost().getHostAddress();


		PostJson postJson = new PostJson("com.example.ws.WebserviceAPI","getCountries");
		postJson.addArgument("java.lang.String", "FRANCE");
		postJson.setResult("com.sfeir.testant.server.RequestServerResponse", "{urlResponse : \"http://"+ipAddr+":"+port+"/"+MockResponseServlet.servletName+"?method=getCountries\"}");

		Process proc = Sfeirito.mock(APIEnum.MOCK_CALLBACK, postJson);
		List<String> readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());

		proc = Sfeirito.test("com.sfeir.testant.tests.TestWebserviceAPIClass");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());


		List<PostJson> postArray = new ArrayList<PostJson>();

		postJson = new PostJson("com.example.Operation","addition");
		postJson.setResult("com.sfeir.testant.server.RequestServerResponse", "{urlResponse : \"http://"+ipAddr+":"+port+"/"+MockResponseServlet.servletName+"?method=addition\"}");
		postArray.add(postJson);

		postJson = new PostJson("com.example.Operation","substraction");
		postJson.setResult("com.sfeir.testant.server.RequestServerResponse", "{urlResponse : \"http://"+ipAddr+":"+port+"/"+MockResponseServlet.servletName+"?method=substraction\"}");
		postArray.add(postJson);

		proc = Sfeirito.mock(APIEnum.MOCK_CALLBACK, postArray);
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());


		proc = Sfeirito.test("com.sfeir.testant.tests.TestOperationClass");
		readConsole = ExecutionScript.readConsole(proc);
		Assert.assertNotNull(readConsole);
		Assert.assertFalse(readConsole.isEmpty());
	}



	public class MockResponseServlet extends HttpServlet{

		public static final String servletName = "getMockResult";

		private String greeting="Hello World";

		public MockResponseServlet(){}

		public MockResponseServlet(String greeting){
			this.greeting=greeting;
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);

			Map<String, String[]> params = request.getParameterMap();

			StringBuilder sb = new StringBuilder();

			if(params.containsKey("method")){
				String[] methodName = params.get("method");

				if(methodName.length >0){
					switch (methodName[0]) {
					case "getCountries":

						String complexResultObject =  "[{"
								+ "\"classname\":\"com.example.ws.Response\","
								+ "\"value\":\"{"
								+ "\\\"name\\\": \\\"United States of America\\\", "
								+ "\\\"alpha2_code\\\":\\\"US\\\","
								+ "\\\"alpha3_code\\\":\\\"USA\\\""
								+ "}\""
								+ "}]";

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
