package com.ralph.service;

import java.util.List;

import com.ralph.domain.City;
import com.ralph.domain.Page;
import com.ralph.domain.Province;
import com.ralph.domain.Student;

public interface CommonService
{
	public List<Province> getAllProv();
	
	public List<City> getCityByProvId(Integer pId);
	
	public Page<Student> getStudentByPage(int currentPage,int pagesize);
	
	public void deleteStudentsByIds(List<String> ids);
}
