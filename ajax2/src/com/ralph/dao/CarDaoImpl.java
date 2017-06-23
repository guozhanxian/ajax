package com.ralph.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ralph.domain.Car;
import com.ralph.util.JdbcUtil;

public class CarDaoImpl implements CarDao
{

	@Override
	public List<Car> findAllCars()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try{
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement("select * from car_info");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Car c = new Car();
				c.setCarId(rs.getString("car_id"));
				c.setCarBand(rs.getString("car_band"));
				c.setCarPrice(rs.getDouble("car_price"));
				c.setCarX(rs.getDouble("car_x"));
				c.setCarY(rs.getDouble("car_y"));
				c.setCarType(rs.getString("car_type"));
				list.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(ps, rs, conn);
		}
		return list;
	}

}
