package com.ralph.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<E> implements Serializable
{
	private int currentPage;
	private int totalPage;
	private int pagesize;
	private int totalNum;
	private List<E> result = new ArrayList<E>();

	public int getTotalNum()
	{
		return totalNum;
	}

	public void setTotalNum(int totalNum)
	{
		this.totalNum = totalNum;
	}

	public int getPagesize()
	{
		return pagesize;
	}

	public void setPagesize(int pagesize)
	{
		this.pagesize = pagesize;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

	public List<E> getResult()
	{
		return result;
	}

	public void setResult(List<E> result)
	{
		this.result = result;
	}

}
