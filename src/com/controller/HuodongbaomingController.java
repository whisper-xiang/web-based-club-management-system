package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Huodongbaoming;
import com.server.HuodongbaomingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HuodongbaomingController {
	@Resource
	private HuodongbaomingServer huodongbaomingService;


   
	@RequestMapping("addHuodongbaoming.do")
	public String addHuodongbaoming(HttpServletRequest request,Huodongbaoming huodongbaoming,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		huodongbaoming.setAddtime(time.toString().substring(0, 19));
		huodongbaomingService.add(huodongbaoming);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "huodongbaomingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:huodongbaomingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHuodongbaoming.do")
	public String doUpdateHuodongbaoming(int id,ModelMap map,Huodongbaoming huodongbaoming){
		huodongbaoming=huodongbaomingService.getById(id);
		map.put("huodongbaoming", huodongbaoming);
		return "huodongbaoming_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("huodongbaomingDetail.do")
	public String huodongbaomingDetail(int id,ModelMap map,Huodongbaoming huodongbaoming){
		huodongbaoming=huodongbaomingService.getById(id);
		map.put("huodongbaoming", huodongbaoming);
		return "huodongbaoming_detail";
	}
//	前台详细
	@RequestMapping("hdbmDetail.do")
	public String hdbmDetail(int id,ModelMap map,Huodongbaoming huodongbaoming){
		huodongbaoming=huodongbaomingService.getById(id);
		map.put("huodongbaoming", huodongbaoming);
		return "huodongbaomingdetail";
	}
//	
	@RequestMapping("updateHuodongbaoming.do")
	public String updateHuodongbaoming(int id,ModelMap map,Huodongbaoming huodongbaoming,HttpServletRequest request,HttpSession session){
		huodongbaomingService.update(huodongbaoming);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:huodongbaomingList.do";
	}

//	分页查询
	@RequestMapping("huodongbaomingList.do")
	public String huodongbaomingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaoming_list";
	}
	
	@RequestMapping("huodongbaoming_yanben1.do")
	public String huodongbaoming_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaoming_yanben1";
	}
	@RequestMapping("huodongbaoming_yanben2.do")
	public String huodongbaoming_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaoming_yanben2";
	}
	@RequestMapping("huodongbaoming_yanben3.do")
	public String huodongbaoming_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaoming_yanben3";
	}
	@RequestMapping("huodongbaoming_yanben4.do")
	public String huodongbaoming_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaoming_yanben4";
	}
	@RequestMapping("huodongbaoming_yanben5.do")
	public String huodongbaoming_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaoming_yanben5";
	}
	
	@RequestMapping("huodongbaomingList3.do")
	public String huodongbaomingList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("yonghuming", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaoming_list3";
	}	@RequestMapping("huodongbaomingList2.do")
	public String huodongbaomingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("baomingren", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaoming_list2";
	}	
	
	@RequestMapping("hdbmList.do")
	public String hdbmList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaominglist";
	}
	@RequestMapping("hdbmListtp.do")
	public String hdbmListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongbaoming huodongbaoming, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String baomingren, String baomingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}		if(baomingren==null||baomingren.equals("")){pmap.put("baomingren", null);}else{pmap.put("baomingren", baomingren);}		if(baomingliyou==null||baomingliyou.equals("")){pmap.put("baomingliyou", null);}else{pmap.put("baomingliyou", baomingliyou);}		
		int total=huodongbaomingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongbaoming> list=huodongbaomingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongbaominglisttp";
	}
	
	@RequestMapping("deleteHuodongbaoming.do")
	public String deleteHuodongbaoming(int id,HttpServletRequest request){
		huodongbaomingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:huodongbaomingList.do";
	}
	
	
}
