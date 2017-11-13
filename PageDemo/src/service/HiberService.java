package service;

import java.util.List;

import pojo.Hiber;

public interface HiberService {
	
	public List<Hiber> getAll(int begin,int size);
	
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
