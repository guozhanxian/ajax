package com.ralph.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ralph.domain.Page;
import com.ralph.domain.Student;
import com.ralph.util.DataAccessException;
import com.ralph.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao
{

	@Override
	public Page<Student> findStudentByPage(int currentPage, int pagesize)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		Page p = new Page();
		try{
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement("select * from students offset ? limit ?");
			
			ps.setInt(1, (currentPage-1)*pagesize);
			ps.setInt(2, pagesize);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				Student s = new Student();
				s.setStudId(rs.getInt("stud_id"));
				s.setStudName(rs.getString("stud_name"));
				s.setStudBirth(new Date(rs.getDate("stud_birth").getTime()));
				list.add(s);
			}
			
			ps = conn.prepareStatement("select count(*) from students");
			rs = ps.executeQuery();
			int totalNum = 0;
			while(rs.next())
			{
				totalNum = rs.getInt(1);
			}
			int totalPage = (int)Math.ceil(totalNum*1.0/pagesize);
			
			p.setCurrentPage(currentPage);
			p.setPagesize(pagesize);
			p.setTotalPage(totalPage);
			p.setTotalNum(totalNum);
			p.setResult(list);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(ps, rs, conn);
		}
		return p;
	}

	@Override
	public void insertStudent(Student s)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement("insert into students values(?,?,?)");
			ps.setInt(1, s.getStudId());
			ps.setString(2, s.getStudName());
			ps.setDate(3, new java.sql.Date(s.getStudBirth().getTime()));
			
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException("保存学生信息失败！", e);
		}finally{
			JdbcUtil.closeAll(ps, conn);
		}
	}

	@Override
	public void deleteStudentById(Integer id)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement("delete from students where stud_id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException("删除学生信息失败！", e);
		}finally{
			JdbcUtil.closeAll(ps, conn);
		}
	}

}
