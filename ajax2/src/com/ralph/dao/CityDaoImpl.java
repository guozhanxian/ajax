package com.ralph.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ralph.domain.City;
import com.ralph.util.JdbcUtil;

public class CityDaoImpl implements CityDao
{

	@Override
	public List<City> findCityByProvId(Integer pId)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<City> list = new ArrayList<City>();
		try{
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement("select * from tt_city where p_id=?");
			ps.setInt(1, pId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				City c = new City();
				c.setcId(rs.getInt("c_id"));
				c.setcName(rs.getString("c_name"));
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
