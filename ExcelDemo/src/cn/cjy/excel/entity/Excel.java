package cn.cjy.excel.entity;

public class Excel {
	public Integer eid;
	public String path;
	public String name;
	public String date;
	
	public Excel() {
	
	}
	
	public Excel(Integer eid, String path, String name, String date) {
		this.path = path;
		this.name = name;
		this.date = date;
	}

	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
