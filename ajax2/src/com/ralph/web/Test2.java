package com.ralph.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ralph.domain.Student;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/test2.do")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		System.out.println(request.getRemoteAddr()+"<<<访问");
		
		String funName = request.getParameter("callback");
		
		Student s = new Student();
		s.setStudId(1);
		s.setStudName("张三");
		s.setStudBirth(new Date());

		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		if(funName!=null && funName.length()>0)
		{
			out.print(funName+"("+gson.toJson(s)+")");
		}else{
			out.println("");
		}
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
