package com.ralph.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.ralph.domain.City;
import com.ralph.service.CommonService;
import com.ralph.service.CommonServiceImpl;

/**
 * Servlet implementation class FindCityByProv
 */
@WebServlet("/findCityByProv.do")
public class FindCityByProv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommonService commonService = new CommonServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pid = request.getParameter("pid");
		
		String str = "";
		if(pid!=null && pid.length()>0)
		{
			List<City> list = commonService.getCityByProvId(Integer.parseInt(pid));
			Gson gson = new Gson();
			str = gson.toJson(list);
		}
		
		response.setContentType("application/javascript;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
