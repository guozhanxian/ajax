package com.ralph.dao;

import java.util.List;

import com.ralph.domain.Car;

public interface CarDao
{
	public List<Car> findAllCars();
}
