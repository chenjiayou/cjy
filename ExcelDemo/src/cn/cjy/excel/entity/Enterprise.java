package cn.cjy.excel.entity;

public class Enterprise {
	public Integer id;
	public String name;
	public double dn;   //电能
	public double ym;   //原煤
	public double cy;   //柴油
	public double tr;   //天然气
	public double zq;  //蒸汽
	public String date; //时间戳
	public Enterprise() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDn() {
		return dn;
	}
	public void setDn(double dn) {
		this.dn = dn;
	}
	public double getYm() {
		return ym;
	}
	public void setYm(double ym) {
		this.ym = ym;
	}
	public double getCy() {
		return cy;
	}
	public void setCy(double cy) {
		this.cy = cy;
	}
	public double getTr() {
		return tr;
	}
	public void setTr(double tr) {
		this.tr = tr;
	}
	public double getZq() {
		return zq;
	}
	public void setZq(double zq) {
		this.zq = zq;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Enterprise [name=" + name + ", dn=" + dn + ", ym=" + ym + ", cy=" + cy + ", tr=" + tr + ", zq=" + zq
				+ ", date=" + date + "]";
	}

	
	
}
