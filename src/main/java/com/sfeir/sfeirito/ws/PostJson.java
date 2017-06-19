package com.sfeir.sfeirito.ws;

import java.util.ArrayList;
import java.util.List;

public class PostJson {
	
	private String classname;
	private String method;
	private List<PostArgument> in = new ArrayList<PostJson.PostArgument>();
	private List<PostArgument> out = new ArrayList<PostJson.PostArgument>();
	
	public PostJson(String classname, String method){
		this.classname = classname;
		this.method = method;
	}
	
	public void addArgument(String classname, String value){
		in.add(new PostArgument(classname, value));
	}

	public void addResult(String classname, String value){
		out.add(new PostArgument(classname, value));
	}
	
	public class PostArgument{
		
		private String classname;
		private String value;
		
		public PostArgument(String classname, String value){
			this.classname = classname;
			this.value = value;
		}
		
		public String getClassname() {
			return classname;
		}
		public void setClassname(String classname) {
			this.classname = classname;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<PostArgument> getIn() {
		return in;
	}

	public void setIn(List<PostArgument> in) {
		this.in = in;
	}

	public List<PostArgument> getOut() {
		return out;
	}

	public void setOut(List<PostArgument> out) {
		this.out = out;
	}

}
