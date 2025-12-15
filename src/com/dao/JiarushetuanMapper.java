package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiarushetuan;

public interface JiarushetuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiarushetuan record);

    int insertSelective(Jiarushetuan record);

    Jiarushetuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiarushetuan record);
	
    int updateByPrimaryKey(Jiarushetuan record);
	public Jiarushetuan quchongJiarushetuan(Map<String, Object> shenqingren);
	public List<Jiarushetuan> getAll(Map<String, Object> map);
	public List<Jiarushetuan> getsyjiarushetuan1(Map<String, Object> map);
	public List<Jiarushetuan> getsyjiarushetuan3(Map<String, Object> map);
	public List<Jiarushetuan> getsyjiarushetuan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiarushetuan> getByPage(Map<String, Object> map);
	public List<Jiarushetuan> select(Map<String, Object> map);
//	所有List
}

