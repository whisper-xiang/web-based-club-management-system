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

import com.entity.Shetuanfenlei;
import com.server.ShetuanfenleiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShetuanfenleiController {
	@Resource
	private ShetuanfenleiServer shetuanfenleiService;


   
	@RequestMapping("addShetuanfenlei.do")
	public String addShetuanfenlei(HttpServletRequest request,Shetuanfenlei shetuanfenlei,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shetuanfenlei.setAddtime(time.toString().substring(0, 19));
		shetuanfenleiService.add(shetuanfenlei);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shetuanfenleiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shetuanfenleiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShetuanfenlei.do")
	public String doUpdateShetuanfenlei(int id,ModelMap map,Shetuanfenlei shetuanfenlei){
		shetuanfenlei=shetuanfenleiService.getById(id);
		map.put("shetuanfenlei", shetuanfenlei);
		return "shetuanfenlei_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shetuanfenleiDetail.do")
	public String shetuanfenleiDetail(int id,ModelMap map,Shetuanfenlei shetuanfenlei){
		shetuanfenlei=shetuanfenleiService.getById(id);
		map.put("shetuanfenlei", shetuanfenlei);
		return "shetuanfenlei_detail";
	}
//	前台详细
	@RequestMapping("stflDetail.do")
	public String stflDetail(int id,ModelMap map,Shetuanfenlei shetuanfenlei){
		shetuanfenlei=shetuanfenleiService.getById(id);
		map.put("shetuanfenlei", shetuanfenlei);
		return "shetuanfenleidetail";
	}
//	
	@RequestMapping("updateShetuanfenlei.do")
	public String updateShetuanfenlei(int id,ModelMap map,Shetuanfenlei shetuanfenlei,HttpServletRequest request,HttpSession session){
		shetuanfenleiService.update(shetuanfenlei);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shetuanfenleiList.do";
	}

//	分页查询
	@RequestMapping("shetuanfenleiList.do")
	public String shetuanfenleiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanfenlei shetuanfenlei, String shetuanleixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		
		int total=shetuanfenleiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanfenlei> list=shetuanfenleiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanfenlei_list";
	}
	
	@RequestMapping("shetuanfenlei_yanben1.do")
	public String shetuanfenlei_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanfenlei shetuanfenlei, String shetuanleixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		
		int total=shetuanfenleiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanfenlei> list=shetuanfenleiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanfenlei_yanben1";
	}
	@RequestMapping("shetuanfenlei_yanben2.do")
	public String shetuanfenlei_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanfenlei shetuanfenlei, String shetuanleixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		
		int total=shetuanfenleiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanfenlei> list=shetuanfenleiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanfenlei_yanben2";
	}
	@RequestMapping("shetuanfenlei_yanben3.do")
	public String shetuanfenlei_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanfenlei shetuanfenlei, String shetuanleixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		
		int total=shetuanfenleiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanfenlei> list=shetuanfenleiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanfenlei_yanben3";
	}
	@RequestMapping("shetuanfenlei_yanben4.do")
	public String shetuanfenlei_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanfenlei shetuanfenlei, String shetuanleixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		
		int total=shetuanfenleiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanfenlei> list=shetuanfenleiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanfenlei_yanben4";
	}
	@RequestMapping("shetuanfenlei_yanben5.do")
	public String shetuanfenlei_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanfenlei shetuanfenlei, String shetuanleixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		
		int total=shetuanfenleiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanfenlei> list=shetuanfenleiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanfenlei_yanben5";
	}
	
	
	
	@RequestMapping("stflList.do")
	public String stflList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanfenlei shetuanfenlei, String shetuanleixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		
		int total=shetuanfenleiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanfenlei> list=shetuanfenleiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanfenleilist";
	}
	@RequestMapping("stflListtp.do")
	public String stflListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanfenlei shetuanfenlei, String shetuanleixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		
		int total=shetuanfenleiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanfenlei> list=shetuanfenleiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanfenleilisttp";
	}
	
	@RequestMapping("deleteShetuanfenlei.do")
	public String deleteShetuanfenlei(int id,HttpServletRequest request){
		shetuanfenleiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shetuanfenleiList.do";
	}
	
	
}
