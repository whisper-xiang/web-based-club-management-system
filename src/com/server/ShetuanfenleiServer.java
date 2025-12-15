package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shetuanfenlei;

public interface ShetuanfenleiServer {

  public int add(Shetuanfenlei po);

  public int update(Shetuanfenlei po);
  
  
  
  public int delete(int id);

  public List<Shetuanfenlei> getAll(Map<String,Object> map);
  public List<Shetuanfenlei> getsyshetuanfenlei1(Map<String,Object> map);
  public List<Shetuanfenlei> getsyshetuanfenlei2(Map<String,Object> map);
  public List<Shetuanfenlei> getsyshetuanfenlei3(Map<String,Object> map);
  public Shetuanfenlei quchongShetuanfenlei(Map<String, Object> acount);

  public Shetuanfenlei getById( int id);

  public List<Shetuanfenlei> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shetuanfenlei> select(Map<String, Object> map);
}
//	所有List
