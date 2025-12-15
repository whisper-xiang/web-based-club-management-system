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

import com.entity.Shetuanhuodong;
import com.server.ShetuanhuodongServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShetuanhuodongController {
	@Resource
	private ShetuanhuodongServer shetuanhuodongService;


   
	@RequestMapping("addShetuanhuodong.do")
	public String addShetuanhuodong(HttpServletRequest request,Shetuanhuodong shetuanhuodong,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shetuanhuodong.setAddtime(time.toString().substring(0, 19));
		shetuanhuodongService.add(shetuanhuodong);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shetuanhuodongList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shetuanhuodongList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShetuanhuodong.do")
	public String doUpdateShetuanhuodong(int id,ModelMap map,Shetuanhuodong shetuanhuodong){
		shetuanhuodong=shetuanhuodongService.getById(id);
		map.put("shetuanhuodong", shetuanhuodong);
		return "shetuanhuodong_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shetuanhuodongDetail.do")
	public String shetuanhuodongDetail(int id,ModelMap map,Shetuanhuodong shetuanhuodong){
		shetuanhuodong=shetuanhuodongService.getById(id);
		map.put("shetuanhuodong", shetuanhuodong);
		return "shetuanhuodong_detail";
	}
//	前台详细
	@RequestMapping("sthdDetail.do")
	public String sthdDetail(int id,ModelMap map,Shetuanhuodong shetuanhuodong){
		shetuanhuodong=shetuanhuodongService.getById(id);
		map.put("shetuanhuodong", shetuanhuodong);
		return "shetuanhuodongdetail";
	}
//	
	@RequestMapping("updateShetuanhuodong.do")
	public String updateShetuanhuodong(int id,ModelMap map,Shetuanhuodong shetuanhuodong,HttpServletRequest request,HttpSession session){
		shetuanhuodongService.update(shetuanhuodong);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shetuanhuodongList.do";
	}

//	分页查询
	@RequestMapping("shetuanhuodongList.do")
	public String shetuanhuodongList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String haibao, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}
		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}
		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}
		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}
		if(haibao==null||haibao.equals("")){pmap.put("haibao", null);}else{pmap.put("haibao", haibao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_list";
	}
	
	@RequestMapping("shetuanhuodong_yanben1.do")
	public String shetuanhuodong_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String haibao, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}
		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}
		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}
		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}
		if(haibao==null||haibao.equals("")){pmap.put("haibao", null);}else{pmap.put("haibao", haibao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben1";
	}
	@RequestMapping("shetuanhuodong_yanben2.do")
	public String shetuanhuodong_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String haibao, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}
		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}
		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}
		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}
		if(haibao==null||haibao.equals("")){pmap.put("haibao", null);}else{pmap.put("haibao", haibao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben2";
	}
	@RequestMapping("shetuanhuodong_yanben3.do")
	public String shetuanhuodong_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String haibao, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}
		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}
		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}
		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}
		if(haibao==null||haibao.equals("")){pmap.put("haibao", null);}else{pmap.put("haibao", haibao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben3";
	}
	@RequestMapping("shetuanhuodong_yanben4.do")
	public String shetuanhuodong_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String haibao, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}
		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}
		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}
		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}
		if(haibao==null||haibao.equals("")){pmap.put("haibao", null);}else{pmap.put("haibao", haibao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben4";
	}
	@RequestMapping("shetuanhuodong_yanben5.do")
	public String shetuanhuodong_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String haibao, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}
		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}
		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}
		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}
		if(haibao==null||haibao.equals("")){pmap.put("haibao", null);}else{pmap.put("haibao", haibao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben5";
	}
	
	@RequestMapping("shetuanhuodongList2.do")
	public String shetuanhuodongList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String haibao, String jianjie, String issh,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}
		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}
		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}
		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}
		if(haibao==null||haibao.equals("")){pmap.put("haibao", null);}else{pmap.put("haibao", haibao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_list2";
	}
	
	
	@RequestMapping("sthdList.do")
	public String sthdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String haibao, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		pmap.put("issh", '是');

		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}
		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}
		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}
		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}
		if(haibao==null||haibao.equals("")){pmap.put("haibao", null);}else{pmap.put("haibao", haibao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodonglist";
	}
	@RequestMapping("sthdListtp.do")
	public String sthdListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String huodongzhuti, String huodongdidian, String huodongshijian, String haibao, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		pmap.put("issh", '是');

		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}
		if(huodongzhuti==null||huodongzhuti.equals("")){pmap.put("huodongzhuti", null);}else{pmap.put("huodongzhuti", huodongzhuti);}
		if(huodongdidian==null||huodongdidian.equals("")){pmap.put("huodongdidian", null);}else{pmap.put("huodongdidian", huodongdidian);}
		if(huodongshijian==null||huodongshijian.equals("")){pmap.put("huodongshijian", null);}else{pmap.put("huodongshijian", huodongshijian);}
		if(haibao==null||haibao.equals("")){pmap.put("haibao", null);}else{pmap.put("haibao", haibao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodonglisttp";
	}
	
	@RequestMapping("deleteShetuanhuodong.do")
	public String deleteShetuanhuodong(int id,HttpServletRequest request){
		shetuanhuodongService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shetuanhuodongList.do";
	}
	
	
}
