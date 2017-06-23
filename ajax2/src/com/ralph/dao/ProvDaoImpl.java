package com.ralph.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ralph.domain.Province;
import com.ralph.util.JdbcUtil;

public class ProvDaoImpl implements ProvDao
{

	@Override
	public List<Province> findAllProv()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Province> list = new ArrayList<Province>();
		try{
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement("select * from tt_prov");
			rs = ps.executeQuery();
			while(rs.next())
			{
				Province p = new Province();
				p.setpId(rs.getInt("p_id"));
				p.setpName(rs.getString("p_name"));
				list.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(ps, rs, conn);
		}
		return list;
	}

}
