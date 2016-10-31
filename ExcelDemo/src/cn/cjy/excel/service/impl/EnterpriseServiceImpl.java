package cn.cjy.excel.service.impl;

import java.util.List;

import cn.cjy.excel.dao.IEnterpriseDao;
import cn.cjy.excel.entity.Enterprise;
import cn.cjy.excel.service.IEnterpriseService;

public class EnterpriseServiceImpl implements IEnterpriseService {
	public IEnterpriseDao enterpriseDao;
	
	public IEnterpriseDao getEnterpriseDao() {
		return enterpriseDao;
	}

	public void setEnterpriseDao(IEnterpriseDao enterpriseDao) {
		this.enterpriseDao = enterpriseDao;
	}

	@Override
	public void save(Enterprise enterprise) {
		enterpriseDao.save(enterprise);

	}

	@Override
	public void delete(Enterprise enterprise) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Enterprise enterprise) {
		// TODO Auto-generated method stub

	}

	@Override
	public Enterprise findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enterprise> findAll() {
		return enterpriseDao.findAll();
	}

}
