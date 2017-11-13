package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Hiber;

import service.HiberService;

@Controller
public class HiberController {
	
	//重复 service层对dao层做过的事情
	@Autowired
	private HiberService hs;
	
	public HiberService getHs() {
		return hs;
	}

	public void setHs(HiberService hs) {
		this.hs = hs;
	}



	@RequestMapping("/getAll")
	public String getAll(@RequestParam(defaultValue="1")int pageindex,HttpServletRequest request){
		//调用分页查询   所有的第几页、第几条开始、每页显示几条全部在这里搞定
		//每页显示条数 直接固定 为5条
		//最上一页也只能点到第一页
		if(pageindex <1){
			return "index.jsp";
		}else{
			//第一步： 一定要根据当前页码算出 起始条数
			int begin = (pageindex-1)*5;
		
			List<Hiber> list = hs.getAll(begin, 5);
			
			//1.存查出来的结果集
			request.getSession().setAttribute("hiberlist", list);
		
			//2.存当前页码  也要存到作用域。  不然前台页面上一页 下一页就没法点
			request.getSession().setAttribute("pageindex", pageindex);
			
			//********************************************************
			//根据总条数 算出总页数
			int count = hs.count();
			
			int countpage = count%5==0?count/5:count/5+1;
			
//			if(count%5==0){
//				countpage = count/5;
//			}else{
//				countpage = count/5+1;
//			}
			//3.总页数   （可以用于实现末页跳转）
			request.getSession().setAttribute("countpage", countpage);
			
			
			return "index.jsp";
		}
		
	}


	/*
	 * 根据id查询的方法
	 */
	@RequestMapping("/findById")
	public String findById(int id,HttpServletRequest request){
		Hiber h = hs.findById(id);
	
		request.getSession().setAttribute("h", h);
		
		return "detail.jsp";
	}
	
	
	@RequestMapping("/update")
	public String update(Hiber h){
		hs.updateHiber(h);
		
		
		return "getAll";
	}
}
