package cn.cjy.excel.entity;

public class DockExcel {
	private Integer id;
	private String ename;  //企业名
	private String eadderss;//企业地址
	private String belongTown;//所属街镇
	private String industry;//所属行业
	private String emanagePeople;//企业节能负责人
	private String emanagePhone;//企业管理人电话
	private String emanageMail;//企业管理人电子邮箱
	private String econtactPeople;//企业联系人
	private String econtactPhone;//企业联系人电话
	private String econtactMail;//企业联系人电子邮箱
	private String serviceEnterprise;//服务公司
	private String serviceContact;//服务公司联系人
	private String serviceContactPhone;//服务联系人电话
	private String serviceContactMail;//服务联系人电子邮箱
	private String projectStartAndStopTime;//项目起止时间
	private double projectInvestmentTotal;//项目投资金额
	private double systemAmount;//系统开发金额
	private double equipmentAmount;//设备采购金额
	private double fixAmount;//工程安装金额
	private double otherAmount;//维护及其他金额
	private Integer FirstPoint;//进出用能单位监测点数
	private Integer secondPoint;//进出主要次级用能单位监测点数
	private Integer equipmentPoint;//主要用能设备监测点数
	private Integer dockMode;//对接方式
	private String dockAccount;//对接账号
	private String dockPassword;//对接密码
	
	public DockExcel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEadderss() {
		return eadderss;
	}
	public void setEadderss(String eadderss) {
		this.eadderss = eadderss;
	}
	public String getBelongTown() {
		return belongTown;
	}
	public void setBelongTown(String belongTown) {
		this.belongTown = belongTown;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getEmanagePeople() {
		return emanagePeople;
	}
	public void setEmanagePeople(String emanagePeople) {
		this.emanagePeople = emanagePeople;
	}
	public String getEmanagePhone() {
		return emanagePhone;
	}
	public void setEmanagePhone(String emanagePhone) {
		this.emanagePhone = emanagePhone;
	}
	public String getEmanageMail() {
		return emanageMail;
	}
	public void setEmanageMail(String emanageMail) {
		this.emanageMail = emanageMail;
	}
	public String getEcontactPeople() {
		return econtactPeople;
	}
	public void setEcontactPeople(String econtactPeople) {
		this.econtactPeople = econtactPeople;
	}
	public String getEcontactPhone() {
		return econtactPhone;
	}
	public void setEcontactPhone(String econtactPhone) {
		this.econtactPhone = econtactPhone;
	}
	public String getEcontactMail() {
		return econtactMail;
	}
	public void setEcontactMail(String econtactMail) {
		this.econtactMail = econtactMail;
	}
	public String getServiceEnterprise() {
		return serviceEnterprise;
	}
	public void setServiceEnterprise(String serviceEnterprise) {
		this.serviceEnterprise = serviceEnterprise;
	}
	public String getServiceContact() {
		return serviceContact;
	}
	public void setServiceContact(String serviceContact) {
		this.serviceContact = serviceContact;
	}
	public String getServiceContactPhone() {
		return serviceContactPhone;
	}
	public void setServiceContactPhone(String serviceContactPhone) {
		this.serviceContactPhone = serviceContactPhone;
	}
	public String getServiceContactMail() {
		return serviceContactMail;
	}
	public void setServiceContactMail(String serviceContactMail) {
		this.serviceContactMail = serviceContactMail;
	}
	public String getProjectStartAndStopTime() {
		return projectStartAndStopTime;
	}
	public void setProjectStartAndStopTime(String projectStartAndStopTime) {
		this.projectStartAndStopTime = projectStartAndStopTime;
	}
	public double getProjectInvestmentTotal() {
		return projectInvestmentTotal;
	}
	public void setProjectInvestmentTotal(double projectInvestmentTotal) {
		this.projectInvestmentTotal = projectInvestmentTotal;
	}
	public double getSystemAmount() {
		return systemAmount;
	}
	public void setSystemAmount(double systemAmount) {
		this.systemAmount = systemAmount;
	}
	public double getEquipmentAmount() {
		return equipmentAmount;
	}
	public void setEquipmentAmount(double equipmentAmount) {
		this.equipmentAmount = equipmentAmount;
	}
	public double getFixAmount() {
		return fixAmount;
	}
	public void setFixAmount(double fixAmount) {
		this.fixAmount = fixAmount;
	}
	public double getOtherAmount() {
		return otherAmount;
	}
	public void setOtherAmount(double otherAmount) {
		this.otherAmount = otherAmount;
	}
	public Integer getFirstPoint() {
		return FirstPoint;
	}
	public void setFirstPoint(Integer firstPoint) {
		FirstPoint = firstPoint;
	}
	public Integer getSecondPoint() {
		return secondPoint;
	}
	public void setSecondPoint(Integer secondPoint) {
		this.secondPoint = secondPoint;
	}
	public Integer getEquipmentPoint() {
		return equipmentPoint;
	}
	public void setEquipmentPoint(Integer equipmentPoint) {
		this.equipmentPoint = equipmentPoint;
	}
	public Integer getDockMode() {
		return dockMode;
	}
	public void setDockMode(Integer dockMode) {
		this.dockMode = dockMode;
	}
	public String getDockAccount() {
		return dockAccount;
	}
	public void setDockAccount(String dockAccount) {
		this.dockAccount = dockAccount;
	}
	public String getDockPassword() {
		return dockPassword;
	}
	public void setDockPassword(String dockPassword) {
		this.dockPassword = dockPassword;
	}
	@Override
	public String toString() {
		return "DockExcel [id=" + id + ", ename=" + ename + ", eadderss=" + eadderss + ", belongTown=" + belongTown
				+ ", industry=" + industry + ", emanagePeople=" + emanagePeople + ", emanagePhone=" + emanagePhone
				+ ", emanageMail=" + emanageMail + ", econtactPeople=" + econtactPeople + ", econtactPhone="
				+ econtactPhone + ", econtactMail=" + econtactMail + ", serviceEnterprise=" + serviceEnterprise
				+ ", serviceContact=" + serviceContact + ", serviceContactPhone=" + serviceContactPhone
				+ ", serviceContactMail=" + serviceContactMail + ", projectStartAndStopTime=" + projectStartAndStopTime
				+ ", projectInvestmentTotal=" + projectInvestmentTotal + ", systemAmount=" + systemAmount
				+ ", equipmentAmount=" + equipmentAmount + ", fixAmount=" + fixAmount + ", otherAmount=" + otherAmount
				+ ", FirstPoint=" + FirstPoint + ", secondPoint=" + secondPoint + ", equipmentPoint=" + equipmentPoint
				+ ", dockMode=" + dockMode + ", dockAccount=" + dockAccount + ", dockPassword=" + dockPassword + "]";
	}
	
}
