package com.ralph.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AutoComplete
 */
@WebServlet("/autoComplete.do")
public class AutoComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<String> list = new ArrayList<String>();
	
	public AutoComplete()
	{
		list.add("abcd");
		list.add("abbd");
		list.add("abbf");
		list.add("acd");
		list.add("afc");
		list.add("bad");
		list.add("bbs");
		list.add("bbc");
		list.add("bbq");
		list.add("bbt");
		list.add("cca");
		list.add("ccd");
		list.add("ccf");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String str = request.getParameter("str");
		
		List<String> res = new ArrayList<String>();
		for(String s:list)
		{
			if(s.startsWith(str))
			{
				res.add(s);
			}
		}
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		out.print(gson.toJson(res));
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
