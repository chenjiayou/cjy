package cn.cjy.excel.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.cjy.excel.dao.IDockDao;
import cn.cjy.excel.entity.DockExcel;

public class DockDaoImpl extends HibernateDaoSupport implements IDockDao{
	
	@Override
	public void save(DockExcel DockExcel) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(DockExcel);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
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
	@SuppressWarnings("unchecked")
	@Override
	public List<DockExcel> findAll() {
		Session sesson = this.getSession();
		List<DockExcel> dockList = (List<DockExcel>)sesson.createCriteria(DockExcel.class)
		.list();
		return dockList;
	}

}
