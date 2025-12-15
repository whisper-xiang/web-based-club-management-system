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

import com.entity.Jiarushetuan;
import com.server.JiarushetuanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiarushetuanController {
	@Resource
	private JiarushetuanServer jiarushetuanService;


   
	@RequestMapping("addJiarushetuan.do")
	public String addJiarushetuan(HttpServletRequest request,Jiarushetuan jiarushetuan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiarushetuan.setAddtime(time.toString().substring(0, 19));
		jiarushetuanService.add(jiarushetuan);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiarushetuanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiarushetuanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiarushetuan.do")
	public String doUpdateJiarushetuan(int id,ModelMap map,Jiarushetuan jiarushetuan){
		jiarushetuan=jiarushetuanService.getById(id);
		map.put("jiarushetuan", jiarushetuan);
		return "jiarushetuan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jiarushetuanDetail.do")
	public String jiarushetuanDetail(int id,ModelMap map,Jiarushetuan jiarushetuan){
		jiarushetuan=jiarushetuanService.getById(id);
		map.put("jiarushetuan", jiarushetuan);
		return "jiarushetuan_detail";
	}
//	前台详细
	@RequestMapping("jrstDetail.do")
	public String jrstDetail(int id,ModelMap map,Jiarushetuan jiarushetuan){
		jiarushetuan=jiarushetuanService.getById(id);
		map.put("jiarushetuan", jiarushetuan);
		return "jiarushetuandetail";
	}
//	
	@RequestMapping("updateJiarushetuan.do")
	public String updateJiarushetuan(int id,ModelMap map,Jiarushetuan jiarushetuan,HttpServletRequest request,HttpSession session){
		jiarushetuanService.update(jiarushetuan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiarushetuanList.do";
	}

//	分页查询
	@RequestMapping("jiarushetuanList.do")
	public String jiarushetuanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuan_list";
	}
	
	@RequestMapping("jiarushetuan_yanben1.do")
	public String jiarushetuan_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuan_yanben1";
	}
	@RequestMapping("jiarushetuan_yanben2.do")
	public String jiarushetuan_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuan_yanben2";
	}
	@RequestMapping("jiarushetuan_yanben3.do")
	public String jiarushetuan_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuan_yanben3";
	}
	@RequestMapping("jiarushetuan_yanben4.do")
	public String jiarushetuan_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuan_yanben4";
	}
	@RequestMapping("jiarushetuan_yanben5.do")
	public String jiarushetuan_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuan_yanben5";
	}
	
	@RequestMapping("jiarushetuanList3.do")
	public String jiarushetuanList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuan_list3";
	}	@RequestMapping("jiarushetuanList2.do")
	public String jiarushetuanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh,HttpServletRequest request){
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
		
		pmap.put("shenqingren", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuan_list2";
	}	
	
	@RequestMapping("jrstList.do")
	public String jrstList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuanlist";
	}
	@RequestMapping("jrstListtp.do")
	public String jrstListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiarushetuan jiarushetuan, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String shenqingren, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(shetuanleixing==null||shetuanleixing.equals("")){pmap.put("shetuanleixing", null);}else{pmap.put("shetuanleixing", shetuanleixing);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=jiarushetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiarushetuan> list=jiarushetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiarushetuanlisttp";
	}
	
	@RequestMapping("deleteJiarushetuan.do")
	public String deleteJiarushetuan(int id,HttpServletRequest request){
		jiarushetuanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiarushetuanList.do";
	}
	
	
}
