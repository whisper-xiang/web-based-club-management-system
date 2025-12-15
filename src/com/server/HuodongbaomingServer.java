package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Huodongbaoming;

public interface HuodongbaomingServer {

  public int add(Huodongbaoming po);

  public int update(Huodongbaoming po);
  
  
  
  public int delete(int id);

  public List<Huodongbaoming> getAll(Map<String,Object> map);
  public List<Huodongbaoming> getsyhuodongbaoming1(Map<String,Object> map);
  public List<Huodongbaoming> getsyhuodongbaoming2(Map<String,Object> map);
  public List<Huodongbaoming> getsyhuodongbaoming3(Map<String,Object> map);
  public Huodongbaoming quchongHuodongbaoming(Map<String, Object> acount);

  public Huodongbaoming getById( int id);

  public List<Huodongbaoming> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Huodongbaoming> select(Map<String, Object> map);
}
//	所有List
