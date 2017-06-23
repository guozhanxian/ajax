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
import com.ralph.domain.Province;
import com.ralph.service.CommonService;
import com.ralph.service.CommonServiceImpl;


@WebServlet("/findAllProv.do")
public class FindAllProv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommonService commonService = new CommonServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<Province> list = commonService.getAllProv();
		Gson gson = new Gson();
		String str = gson.toJson(list);
		
		out.println(str);
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
