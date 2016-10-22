package cn.cjy.excel.service;

import java.util.List;

import cn.cjy.excel.entity.Company;

public interface ICompanyService {
	public void save(Company Company);
	public void delete(Company Company);
	public void update(Company Company);
	public Company findById(Integer id);
	public List<Company> findAll();
}
