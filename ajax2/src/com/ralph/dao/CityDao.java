package com.ralph.dao;

import java.util.List;

import com.ralph.domain.City;

public interface CityDao
{
	public List<City> findCityByProvId(Integer pId);
}
