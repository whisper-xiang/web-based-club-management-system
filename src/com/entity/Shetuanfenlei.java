package com.entity;

public class Shetuanfenlei {
    private Integer id;
	private String shetuanleixing;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShetuanleixing() {
        return shetuanleixing;
    }
    public void setShetuanleixing(String shetuanleixing) {
        this.shetuanleixing = shetuanleixing == null ? null : shetuanleixing.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
