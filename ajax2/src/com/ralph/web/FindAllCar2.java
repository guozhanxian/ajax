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
import com.ralph.dao.CarDao;
import com.ralph.dao.CarDaoImpl;
import com.ralph.domain.Car;

/**
 * Servlet implementation class FindAllCar
 */
@WebServlet("/findAllCar2.do")
public class FindAllCar2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDao carDao = new CarDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> list = carDao.findAllCars();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Rows", list);
		map.put("Total", list.size());
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		out.print(gson.toJson(map));
		out.flush();
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
