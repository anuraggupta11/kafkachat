package dao;

import org.hibernate.Session;

import viksit.chat.ChatGroup;
import viksit.chat.User;

public class ChatGroupDAO extends BaseHibernateDAO{
	 public ChatGroupDAO() {
		// TODO Auto-generated constructor stub
	}
	
	 public ChatGroup findById(Integer id) {
		 
		 ChatGroup chatGroup = (ChatGroup) getSession().get("viksit.chat.ChatGroup", id);
		         return chatGroup;
		     }

}
