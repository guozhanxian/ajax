package com.ralph.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/findAllCar.do")
public class FindAllCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDao carDao = new CarDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> list = carDao.findAllCars();
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		out.print(gson.toJson(list));
		out.flush();
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
