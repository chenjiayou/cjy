package cn.cjy.excel.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.cjy.excel.dao.ICompanyDao;
import cn.cjy.excel.entity.Company;

public class CompanyDaoImpl extends HibernateDaoSupport implements ICompanyDao{
	
	@Override
	public void save(Company Company) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Company);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAll() {
		Session sesson = this.getSession();
		List<Company> dockList = (List<Company>)sesson.createCriteria(Company.class)
		.list();
		return dockList;
	}

}
