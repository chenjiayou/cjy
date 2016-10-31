package cn.cjy.excel.service;

import java.util.List;

import cn.cjy.excel.entity.Enterprise;

public interface IEnterpriseService {
	public void save(Enterprise enterprise);
	public void delete(Enterprise enterprise);
	public void update(Enterprise enterprise);
	public Enterprise findById(Integer id);
	public List<Enterprise> findAll();
}
