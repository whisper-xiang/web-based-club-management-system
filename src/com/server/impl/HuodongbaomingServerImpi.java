package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HuodongbaomingMapper;
import com.entity.Huodongbaoming;
import com.server.HuodongbaomingServer;
@Service
public class HuodongbaomingServerImpi implements HuodongbaomingServer {
   @Resource
   private HuodongbaomingMapper gdao;
	@Override
	public int add(Huodongbaoming po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Huodongbaoming po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Huodongbaoming> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Huodongbaoming> getsyhuodongbaoming1(Map<String, Object> map) {
		return gdao.getsyhuodongbaoming1(map);
	}
	public List<Huodongbaoming> getsyhuodongbaoming2(Map<String, Object> map) {
		return gdao.getsyhuodongbaoming2(map);
	}
	public List<Huodongbaoming> getsyhuodongbaoming3(Map<String, Object> map) {
		return gdao.getsyhuodongbaoming3(map);
	}
	
	@Override
	public Huodongbaoming quchongHuodongbaoming(Map<String, Object> account) {
		return gdao.quchongHuodongbaoming(account);
	}

	@Override
	public List<Huodongbaoming> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Huodongbaoming> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Huodongbaoming getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

