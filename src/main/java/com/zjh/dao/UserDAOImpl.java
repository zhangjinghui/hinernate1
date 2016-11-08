package com.zjh.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.zjh.po.HibernateSessionFactory;
import com.zjh.po.User;

public class UserDAOImpl {
	public static void main(String[] args) {
		new UserDAOImpl().queryAll();
	}
	public void add(){
		Session session=null;
		Transaction trans=null;
		try {
			session=HibernateSessionFactory.getSessionFactory().openSession();
			trans=session.beginTransaction();
			
			User user=new User();
			user.setUsername("中文");
			user.setPassword("123");
			session.save(user);//增加
			
			trans.commit();
			HibernateSessionFactory.getSessionFactory().close();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}	
	}
	public void del(){
		Session session=null;
		Transaction trans=null;
		try {
			session=HibernateSessionFactory.getSessionFactory().openSession();
			trans=session.beginTransaction();
			
			User user=(User)session.load(User.class, 1);//定位到指定记录
			session.delete(user);//删除
			
			trans.commit();
			HibernateSessionFactory.getSessionFactory().close();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}	
	}
	public void update(){
		Session session=null;
		Transaction trans=null;
		try {
			session=HibernateSessionFactory.getSessionFactory().openSession();
			trans=session.beginTransaction();
			
			User user=(User)session.load(User.class, 2);
			user.setUsername("修改");
			session.update(user);//修改
			
			trans.commit();
			HibernateSessionFactory.getSessionFactory().close();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}	
	}
	public void queryAll(){
		Session session=null;
		Transaction trans=null;
		try {
			session=HibernateSessionFactory.getSessionFactory().openSession();
			
			Query q=session.createQuery("from User");//User是类,不是表user
			List<User> list=q.list();
			for(User u:list){
				System.out.println(u.getUsername());
			}
			
			HibernateSessionFactory.getSessionFactory().close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
