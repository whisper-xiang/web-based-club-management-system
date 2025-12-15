package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiarushetuan;

public interface JiarushetuanServer {

  public int add(Jiarushetuan po);

  public int update(Jiarushetuan po);
  
  
  
  public int delete(int id);

  public List<Jiarushetuan> getAll(Map<String,Object> map);
  public List<Jiarushetuan> getsyjiarushetuan1(Map<String,Object> map);
  public List<Jiarushetuan> getsyjiarushetuan2(Map<String,Object> map);
  public List<Jiarushetuan> getsyjiarushetuan3(Map<String,Object> map);
  public Jiarushetuan quchongJiarushetuan(Map<String, Object> acount);

  public Jiarushetuan getById( int id);

  public List<Jiarushetuan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiarushetuan> select(Map<String, Object> map);
}
//	所有List
