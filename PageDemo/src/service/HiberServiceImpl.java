package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HiberMapper;

import pojo.Hiber;
@Service("hsi")
public class HiberServiceImpl implements HiberService {

	//业务逻辑层 调用dao层接口对象
	//Autowired按照类型注入    自动注入对应接口的实现类对象
	@Autowired
	HiberMapper hm;
	
	public HiberMapper getHm() {
		return hm;
	}

	public void setHm(HiberMapper hm) {
		this.hm = hm;
	}

	public List<Hiber> getAll(int begin, int size) {
		// TODO Auto-generated method stub
		return hm.getAll(begin, size);
	}

	public int count() {
		// TODO Auto-generated method stub
		return hm.count();
	}

	public Hiber findById(int id) {
		// TODO Auto-generated method stub
		return hm.findById(id);
	}

	public int updateHiber(Hiber h) {
		// TODO Auto-generated method stub
		return hm.updateHiber(h);
	}

}
