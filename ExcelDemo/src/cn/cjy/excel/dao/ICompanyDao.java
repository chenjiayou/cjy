package cn.cjy.excel.dao;

import java.util.List;

import cn.cjy.excel.entity.Company;
public interface ICompanyDao {
	public void save(Company Company);
	public void delete(Company Company);
	public void update(Company Company);
	public Company findById(Integer id);
	public List<Company> findAll();
}
