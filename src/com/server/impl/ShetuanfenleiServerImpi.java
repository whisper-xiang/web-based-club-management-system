package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShetuanfenleiMapper;
import com.entity.Shetuanfenlei;
import com.server.ShetuanfenleiServer;
@Service
public class ShetuanfenleiServerImpi implements ShetuanfenleiServer {
   @Resource
   private ShetuanfenleiMapper gdao;
	@Override
	public int add(Shetuanfenlei po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shetuanfenlei po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shetuanfenlei> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shetuanfenlei> getsyshetuanfenlei1(Map<String, Object> map) {
		return gdao.getsyshetuanfenlei1(map);
	}
	public List<Shetuanfenlei> getsyshetuanfenlei2(Map<String, Object> map) {
		return gdao.getsyshetuanfenlei2(map);
	}
	public List<Shetuanfenlei> getsyshetuanfenlei3(Map<String, Object> map) {
		return gdao.getsyshetuanfenlei3(map);
	}
	
	@Override
	public Shetuanfenlei quchongShetuanfenlei(Map<String, Object> account) {
		return gdao.quchongShetuanfenlei(account);
	}

	@Override
	public List<Shetuanfenlei> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shetuanfenlei> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shetuanfenlei getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

