package com.entity;

public class Jiarushetuan {
    private Integer id;
	private String yonghuming;	private String xingming;	private String shetuanmingcheng;	private String shetuanleixing;	private String shenqingren;	private String shenqingliyou;	private String issh;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming == null ? null : yonghuming.trim();
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }	public String getShetuanmingcheng() {
        return shetuanmingcheng;
    }
    public void setShetuanmingcheng(String shetuanmingcheng) {
        this.shetuanmingcheng = shetuanmingcheng == null ? null : shetuanmingcheng.trim();
    }	public String getShetuanleixing() {
        return shetuanleixing;
    }
    public void setShetuanleixing(String shetuanleixing) {
        this.shetuanleixing = shetuanleixing == null ? null : shetuanleixing.trim();
    }	public String getShenqingren() {
        return shenqingren;
    }
    public void setShenqingren(String shenqingren) {
        this.shenqingren = shenqingren == null ? null : shenqingren.trim();
    }	public String getShenqingliyou() {
        return shenqingliyou;
    }
    public void setShenqingliyou(String shenqingliyou) {
        this.shenqingliyou = shenqingliyou == null ? null : shenqingliyou.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
