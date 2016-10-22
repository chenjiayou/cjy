package cn.cjy.excel.service.impl;

import java.util.List;

import cn.cjy.excel.dao.ICompanyDao;
import cn.cjy.excel.entity.Company;
import cn.cjy.excel.service.ICompanyService;

public class CompanyServiceImpl implements ICompanyService {
	public ICompanyDao companyDao;
	
	public ICompanyDao getcompanyDao() {
		return companyDao;
	}

	public void setcompanyDao(ICompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public void save(Company Company) {
		companyDao.save(Company);

	}

	@Override
	public void delete(Company Company) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Company Company) {
		// TODO Auto-generated method stub

	}

	@Override
	public Company findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findAll() {
		return companyDao.findAll();
	}

}
