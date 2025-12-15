package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiarushetuanMapper;
import com.entity.Jiarushetuan;
import com.server.JiarushetuanServer;
@Service
public class JiarushetuanServerImpi implements JiarushetuanServer {
   @Resource
   private JiarushetuanMapper gdao;
	@Override
	public int add(Jiarushetuan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiarushetuan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiarushetuan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiarushetuan> getsyjiarushetuan1(Map<String, Object> map) {
		return gdao.getsyjiarushetuan1(map);
	}
	public List<Jiarushetuan> getsyjiarushetuan2(Map<String, Object> map) {
		return gdao.getsyjiarushetuan2(map);
	}
	public List<Jiarushetuan> getsyjiarushetuan3(Map<String, Object> map) {
		return gdao.getsyjiarushetuan3(map);
	}
	
	@Override
	public Jiarushetuan quchongJiarushetuan(Map<String, Object> account) {
		return gdao.quchongJiarushetuan(account);
	}

	@Override
	public List<Jiarushetuan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiarushetuan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiarushetuan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

