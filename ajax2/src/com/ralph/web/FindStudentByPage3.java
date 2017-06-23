package com.ralph.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ralph.domain.Page;
import com.ralph.domain.Student;
import com.ralph.service.CommonService;
import com.ralph.service.CommonServiceImpl;

/**
 * Servlet implementation class FindStudentByPage
 */
@WebServlet("/findStudentByPage3.do")
public class FindStudentByPage3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommonService commService = new CommonServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String page = request.getParameter("page");
		String pagelength = request.getParameter("pagesize");
		String sortname = request.getParameter("sortname");
		String sortorder = request.getParameter("sortorder");
		System.out.println(sortname+"<<<"+sortorder);
		
		int currentPage = 1;
		int pagesize = 3;
		if(page!=null && page.length()>0)
			currentPage = Integer.parseInt(page);
		if(pagelength!=null && pagelength.length()>0)
			pagesize = Integer.parseInt(pagelength);
		
		Page<Student> p = commService.getStudentByPage(currentPage, pagesize);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String str = gson.toJson(p);
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
