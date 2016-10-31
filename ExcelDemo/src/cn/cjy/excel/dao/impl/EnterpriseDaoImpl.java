package cn.cjy.excel.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.cjy.excel.dao.IEnterpriseDao;
import cn.cjy.excel.entity.Enterprise;

public class EnterpriseDaoImpl extends HibernateDaoSupport implements IEnterpriseDao{
	
	@Override
	public void save(Enterprise enterprise) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(enterprise);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Enterprise> findAll() {
		Session sesson = this.getSession();
		List<Enterprise> dockList = (List<Enterprise>)sesson.createCriteria(Enterprise.class)
		.list();
		return dockList;
	}

}
