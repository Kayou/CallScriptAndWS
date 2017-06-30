package com.sfeir.sfeirito.ws;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class PostJson {

	private String classname;
	private String method;
	private List<PostArgument> in = new ArrayList<PostJson.PostArgument>();
	private PostArgument out;
	private List<PostArgument> listOut = new ArrayList<>();


	public PostJson(String classname, String method){
		this.classname = classname;
		this.method = method;
	}

	public void addArgument(String classname, String value){
		in.add(new PostArgument(classname, value));
	}

	public void addResult(String classname, String value){
		listOut.add(new PostArgument(classname, value));
	}

	public void setResult(String classname, String value){
		out = new PostArgument(classname, value);
	}

	public String toJsonString(){
		Gson gson = new Gson();
		return gson.toJson(this);
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

	public Object getOut() {
		return out;
	}

	public void setOut(PostArgument out) {
		this.out = out;
	}

	public List<PostArgument> getListOut() {
		return listOut;
	}

	public void setListOut(List<PostArgument> listOut) {
		this.listOut = listOut;
	}

}
