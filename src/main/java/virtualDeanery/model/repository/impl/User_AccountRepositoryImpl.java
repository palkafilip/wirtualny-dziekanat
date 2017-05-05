package virtualDeanery.model.repository.impl;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import virtualDeanery.model.User_Account;
import virtualDeanery.model.repository.User_AccountRepository;

@Repository
public class User_AccountRepositoryImpl implements User_AccountRepository
{

	@Autowired
	DataSource datasource;
	
	private SessionFactory sessionFactory;

	@Autowired
	public User_AccountRepositoryImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public User_Account getUser_AccountByNiu(int niu)
	{
		User_Account user_acc = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();  //zmiana sposobu transakcji zeby testy chodzily
		user_acc = (User_Account) session.get(User_Account.class, niu);
		trans.commit();
		System.out.println(user_acc);
		return user_acc;
	}
}
