package com.ralph.domain;

import java.io.Serializable;

public class Car implements Serializable
{
	private String carId;
	private String carBand;
	private double carPrice;
	private double carX;
	private double carY;
	private String carType;

	public String getCarId()
	{
		return carId;
	}

	public void setCarId(String carId)
	{
		this.carId = carId;
	}

	public String getCarBand()
	{
		return carBand;
	}

	public void setCarBand(String carBand)
	{
		this.carBand = carBand;
	}

	public double getCarPrice()
	{
		return carPrice;
	}

	public void setCarPrice(double carPrice)
	{
		this.carPrice = carPrice;
	}

	public double getCarX()
	{
		return carX;
	}

	public void setCarX(double carX)
	{
		this.carX = carX;
	}

	public double getCarY()
	{
		return carY;
	}

	public void setCarY(double carY)
	{
		this.carY = carY;
	}

	public String getCarType()
	{
		return carType;
	}

	public void setCarType(String carType)
	{
		this.carType = carType;
	}

}
