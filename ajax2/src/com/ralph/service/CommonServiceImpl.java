package com.ralph.service;

import java.util.List;

import com.ralph.dao.CityDao;
import com.ralph.dao.CityDaoImpl;
import com.ralph.dao.ProvDao;
import com.ralph.dao.ProvDaoImpl;
import com.ralph.dao.StudentDao;
import com.ralph.dao.StudentDaoImpl;
import com.ralph.domain.City;
import com.ralph.domain.Page;
import com.ralph.domain.Province;
import com.ralph.domain.Student;

public class CommonServiceImpl implements CommonService
{
	private ProvDao provDao = new ProvDaoImpl();

	private CityDao cityDao = new CityDaoImpl();

	private StudentDao studDao = new StudentDaoImpl();

	@Override
	public List<Province> getAllProv()
	{
		return provDao.findAllProv();
	}

	@Override
	public List<City> getCityByProvId(Integer pId)
	{
		return cityDao.findCityByProvId(pId);
	}

	@Override
	public Page<Student> getStudentByPage(int currentPage, int pagesize)
	{
		return studDao.findStudentByPage(currentPage, pagesize);
	}

	@Override
	public void deleteStudentsByIds(List<String> ids)
	{
		for (String id : ids)
		{
			studDao.deleteStudentById(Integer.parseInt(id));
		}
	}

}
