package dao;

import java.util.List;

import javax.persistence.Query;

import viksit.chat.ChatMessage;
import viksit.chat.User;

public class ChatMessageDAO extends BaseHibernateDAO{
	public ChatMessage findById(Integer id) {
		ChatMessage chatMessage = (ChatMessage)getSession().get(ChatMessage.class, id);
        return chatMessage;
    }

public List<ChatMessage> findAll() {
	 
	try {
		String queryString = "from ChatMessage";
		Query queryObject = getSession().createQuery(queryString);
		return queryObject.getResultList();
	} catch (RuntimeException re) {
		 
		throw re;
	} finally {
		
	}
}
}
