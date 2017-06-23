package com.ralph.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ralph.service.CommonService;
import com.ralph.service.CommonServiceImpl;

/**
 * Servlet implementation class DeleteStudents
 */
@WebServlet("/deleteStudents.do")
public class DeleteStudents extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private CommonService commService = new CommonServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String str = request.getParameter("str");

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<String> list = gson.fromJson(str, List.class);

		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();

		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
			commService.deleteStudentsByIds(list);
			map.put("code", "200");
			map.put("msg", "学生信息删除成功！");
		} catch (Exception e)
		{
			map.put("code", "500");
			map.put("msg", "学生信息删除失败！");
		}

		out.print(gson.toJson(map));
		out.println();
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
