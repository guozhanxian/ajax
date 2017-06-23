package com.ralph.dao;

import com.ralph.domain.Page;
import com.ralph.domain.Student;

public interface StudentDao
{
	public Page<Student> findStudentByPage(int currentPage,int pagesize);
	
	public void insertStudent(Student s);
	
	public void deleteStudentById(Integer id);
}
