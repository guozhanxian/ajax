package com.ralph.domain;

import java.io.Serializable;

public class Province implements Serializable
{
	private Integer pId;
	private String pName;

	public Integer getpId()
	{
		return pId;
	}

	public void setpId(Integer pId)
	{
		this.pId = pId;
	}

	public String getpName()
	{
		return pName;
	}

	public void setpName(String pName)
	{
		this.pName = pName;
	}

}
