package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Huodongbaoming;

public interface HuodongbaomingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huodongbaoming record);

    int insertSelective(Huodongbaoming record);

    Huodongbaoming selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huodongbaoming record);
	
    int updateByPrimaryKey(Huodongbaoming record);
	public Huodongbaoming quchongHuodongbaoming(Map<String, Object> baomingren);
	public List<Huodongbaoming> getAll(Map<String, Object> map);
	public List<Huodongbaoming> getsyhuodongbaoming1(Map<String, Object> map);
	public List<Huodongbaoming> getsyhuodongbaoming3(Map<String, Object> map);
	public List<Huodongbaoming> getsyhuodongbaoming2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Huodongbaoming> getByPage(Map<String, Object> map);
	public List<Huodongbaoming> select(Map<String, Object> map);
//	所有List
}

