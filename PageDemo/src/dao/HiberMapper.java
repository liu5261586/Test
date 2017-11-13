package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Hiber;

public interface HiberMapper {
	
	/*
	 * mySql的分页查询方法
	 * 1.begin起点   2.每页显示条数
	 */
	public List<Hiber> getAll(@Param("b")int begin,@Param("s")int size);
	
	
	/*
	 * 获得数据库的总条数  
	 * 方便求得分页的总页数
	 */
	public int count();
	
	/*
	 * 根据id查询对象信息
	 */
	public Hiber findById(int id);
	
	
	/*
	 * 修改方法传对象
	 */
	public int updateHiber(Hiber h);
}
