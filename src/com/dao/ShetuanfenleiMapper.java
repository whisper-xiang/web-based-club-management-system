package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shetuanfenlei;

public interface ShetuanfenleiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shetuanfenlei record);

    int insertSelective(Shetuanfenlei record);

    Shetuanfenlei selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shetuanfenlei record);
	
    int updateByPrimaryKey(Shetuanfenlei record);
	public Shetuanfenlei quchongShetuanfenlei(Map<String, Object> shetuanleixing);
	public List<Shetuanfenlei> getAll(Map<String, Object> map);
	public List<Shetuanfenlei> getsyshetuanfenlei1(Map<String, Object> map);
	public List<Shetuanfenlei> getsyshetuanfenlei3(Map<String, Object> map);
	public List<Shetuanfenlei> getsyshetuanfenlei2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shetuanfenlei> getByPage(Map<String, Object> map);
	public List<Shetuanfenlei> select(Map<String, Object> map);
//	所有List
}

