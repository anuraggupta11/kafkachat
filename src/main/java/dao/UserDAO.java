package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import viksit.chat.User;

public class UserDAO extends BaseHibernateDAO {
	 
	 
	 public User findById(Integer id) {
		         User user = (User)getSession().get(User.class, id);
		         return user;
		     }

		public List<User> findAll() {
			 
			try {
				String queryString = "from User";
				Query queryObject = getSession().createQuery(queryString);
				return queryObject.getResultList();
			} catch (RuntimeException re) {
				 
				throw re;
			} finally {
				
			}
		}


}
