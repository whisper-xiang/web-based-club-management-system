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

import com.entity.Shetuanxinxi;
import com.server.ShetuanxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShetuanxinxiController {
	@Resource
	private ShetuanxinxiServer shetuanxinxiService;


   
	@RequestMapping("addShetuanxinxi.do")
	public String addShetuanxinxi(HttpServletRequest request,Shetuanxinxi shetuanxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shetuanxinxi.setAddtime(time.toString().substring(0, 19));
		shetuanxinxiService.add(shetuanxinxi);
		db dbo = new db();
		
		//kuabiaogaizhi
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shetuanxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shetuanxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShetuanxinxi.do")
	public String doUpdateShetuanxinxi(int id,ModelMap map,Shetuanxinxi shetuanxinxi){
		shetuanxinxi=shetuanxinxiService.getById(id);
		map.put("shetuanxinxi", shetuanxinxi);
		return "shetuanxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shetuanxinxiDetail.do")
	public String shetuanxinxiDetail(int id,ModelMap map,Shetuanxinxi shetuanxinxi){
		shetuanxinxi=shetuanxinxiService.getById(id);
		map.put("shetuanxinxi", shetuanxinxi);
		return "shetuanxinxi_detail";
	}
//	前台详细
	@RequestMapping("stxxDetail.do")
	public String stxxDetail(int id,ModelMap map,Shetuanxinxi shetuanxinxi){
		shetuanxinxi=shetuanxinxiService.getById(id);
		map.put("shetuanxinxi", shetuanxinxi);
		return "shetuanxinxidetail";
	}
//	
	@RequestMapping("updateShetuanxinxi.do")
	public String updateShetuanxinxi(int id,ModelMap map,Shetuanxinxi shetuanxinxi,HttpServletRequest request,HttpSession session){
		shetuanxinxiService.update(shetuanxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shetuanxinxiList.do";
	}

//	分页查询
	@RequestMapping("shetuanxinxiList.do")
	public String shetuanxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String tupian, String dizhi, String gaiyao, String jianjie, String issh){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gaiyao==null||gaiyao.equals("")){pmap.put("gaiyao", null);}else{pmap.put("gaiyao", gaiyao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_list";
	}
	
	@RequestMapping("shetuanxinxi_yanben1.do")
	public String shetuanxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String tupian, String dizhi, String gaiyao, String jianjie, String issh){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gaiyao==null||gaiyao.equals("")){pmap.put("gaiyao", null);}else{pmap.put("gaiyao", gaiyao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben1";
	}
	@RequestMapping("shetuanxinxi_yanben2.do")
	public String shetuanxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String tupian, String dizhi, String gaiyao, String jianjie, String issh){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gaiyao==null||gaiyao.equals("")){pmap.put("gaiyao", null);}else{pmap.put("gaiyao", gaiyao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben2";
	}
	@RequestMapping("shetuanxinxi_yanben3.do")
	public String shetuanxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String tupian, String dizhi, String gaiyao, String jianjie, String issh){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gaiyao==null||gaiyao.equals("")){pmap.put("gaiyao", null);}else{pmap.put("gaiyao", gaiyao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben3";
	}
	@RequestMapping("shetuanxinxi_yanben4.do")
	public String shetuanxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String tupian, String dizhi, String gaiyao, String jianjie, String issh){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gaiyao==null||gaiyao.equals("")){pmap.put("gaiyao", null);}else{pmap.put("gaiyao", gaiyao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben4";
	}
	@RequestMapping("shetuanxinxi_yanben5.do")
	public String shetuanxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String tupian, String dizhi, String gaiyao, String jianjie, String issh){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gaiyao==null||gaiyao.equals("")){pmap.put("gaiyao", null);}else{pmap.put("gaiyao", gaiyao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben5";
	}
	
	@RequestMapping("shetuanxinxiList2.do")
	public String shetuanxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String tupian, String dizhi, String gaiyao, String jianjie, String issh,HttpServletRequest request){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gaiyao==null||gaiyao.equals("")){pmap.put("gaiyao", null);}else{pmap.put("gaiyao", gaiyao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_list2";
	}
	
	
	@RequestMapping("stxxList.do")
	public String stxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String tupian, String dizhi, String gaiyao, String jianjie, String issh){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gaiyao==null||gaiyao.equals("")){pmap.put("gaiyao", null);}else{pmap.put("gaiyao", gaiyao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxilist";
	}
	@RequestMapping("stxxListtp.do")
	public String stxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String yonghuming, String xingming, String shetuanmingcheng, String shetuanleixing, String tupian, String dizhi, String gaiyao, String jianjie, String issh){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(gaiyao==null||gaiyao.equals("")){pmap.put("gaiyao", null);}else{pmap.put("gaiyao", gaiyao);}
		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}
		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxilisttp";
	}
	
	@RequestMapping("deleteShetuanxinxi.do")
	public String deleteShetuanxinxi(int id,HttpServletRequest request){
		shetuanxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shetuanxinxiList.do";
	}
	
	
}
