package com.ralph.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

/**
 * Servlet implementation class AutoComplete
 */
@WebServlet("/autoComplete2.do")
public class AutoComplete2 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private List<String> list = new ArrayList<String>();

	public AutoComplete2()
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String str = request.getParameter("key");

		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		if (str != null && str.length() > 0)
		{
			for (String s : list)
			{
				if (s.startsWith(str))
				{
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", s);
					map.put("name", s);
					res.add(map);
				}
			}
		} else
		{
			for (String s : list)
			{

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", s);
				map.put("name", s);
				res.add(map);
			}
		}

		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		out.print(gson.toJson(res));
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
