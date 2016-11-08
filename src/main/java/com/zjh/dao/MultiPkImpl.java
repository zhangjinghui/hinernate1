package com.zjh.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zjh.po.HibernateSessionFactory;
import com.zjh.po.Multipk;
import com.zjh.po.MultipkId;

public class MultiPkImpl {
	public static void main(String[] args) {
		new MultiPkImpl().update();
	}
	public void add(){
		Session session=null;
		Transaction trans=null;
		try {
			session=HibernateSessionFactory.getSessionFactory().openSession();
			trans=session.beginTransaction();
			
			Multipk mp=new Multipk();//mp抽象类
			MultipkId mpi=new MultipkId();//mpi抽象联合主键类
			
			mpi.setId(888);
			mpi.setUsername("shot");
			
			mp.setId(mpi);//将mpi抽象主键set到mp抽象类中
			mp.setPassword("password");
			session.save(mp);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.getSessionFactory().close();
		}
	}
	public void del(){
		Session session=null;
		Transaction trans=null;
		try {
			session=HibernateSessionFactory.getSessionFactory().openSession();
			trans=session.beginTransaction();
			
			MultipkId mpi=new MultipkId();
			mpi.setId(999);
			mpi.setUsername("nice");
			
			Multipk mp=(Multipk)session.load(Multipk.class, mpi);
			session.delete(mp);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.getSessionFactory().close();
		}
	}
	public void update(){
		Session session=null;
		Transaction trans=null;
		try {
			session=HibernateSessionFactory.getSessionFactory().openSession();
			trans=session.beginTransaction();
			
			MultipkId mpi=new MultipkId();
			mpi.setId(888);
			mpi.setUsername("shot");
			
			Multipk mp=(Multipk)session.load(Multipk.class, mpi);
			mp.setPassword("updatepassword");
			session.update(mp);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.getSessionFactory().close();
		}
	}
}
