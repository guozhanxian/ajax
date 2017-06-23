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
import com.ralph.dao.StudentDao;
import com.ralph.dao.StudentDaoImpl;
import com.ralph.domain.Student;

@WebServlet("/addStudent.do")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studDao = new StudentDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String str = request.getParameter("str");
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Student s = gson.fromJson(str, Student.class);
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();

		Map<String, Object> map = new HashMap<String,Object>();
		try{
			studDao.insertStudent(s);
			map.put("code", "200");
			map.put("msg", "学生信息保存成功！");
		}catch(Exception e){
			map.put("code", "500");
			map.put("msg", "学生信息保存失败！");
		}
		
		out.print(gson.toJson(map));
		out.println();
		out.flush();
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
