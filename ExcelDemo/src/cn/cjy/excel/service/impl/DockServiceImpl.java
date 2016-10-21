package cn.cjy.excel.service.impl;

import java.util.List;

import cn.cjy.excel.dao.IDockDao;
import cn.cjy.excel.entity.DockExcel;
import cn.cjy.excel.service.IDockService;

public class DockServiceImpl implements IDockService {
	public IDockDao dockDao;
	
	public IDockDao getDockDao() {
		return dockDao;
	}

	public void setDockDao(IDockDao dockDao) {
		this.dockDao = dockDao;
	}

	@Override
	public void save(DockExcel DockExcel) {
		dockDao.save(DockExcel);

	}

	@Override
	public void delete(DockExcel DockExcel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(DockExcel DockExcel) {
		// TODO Auto-generated method stub

	}

	@Override
	public DockExcel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DockExcel> findAll() {
		return dockDao.findAll();
	}

}
