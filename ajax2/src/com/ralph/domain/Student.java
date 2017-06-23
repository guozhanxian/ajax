package com.ralph.domain;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable
{
	private Integer studId;
	private String studName;
	private Date studBirth;

	public Integer getStudId()
	{
		return studId;
	}

	public void setStudId(Integer studId)
	{
		this.studId = studId;
	}

	public String getStudName()
	{
		return studName;
	}

	public void setStudName(String studName)
	{
		this.studName = studName;
	}

	public Date getStudBirth()
	{
		return studBirth;
	}

	public void setStudBirth(Date studBirth)
	{
		this.studBirth = studBirth;
	}

}
