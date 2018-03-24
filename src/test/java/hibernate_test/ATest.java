package hibernate_test;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.github.javafaker.Faker;

import dao.UserDAO;
import util.HibernateSessionFactory;
import viksit.chat.ChatGroup;
import viksit.chat.ChatMessage;
import viksit.chat.User;

public class ATest {
	public static void main(String[] args) {
	//	test();
		//chatMessageTest();
		creatMessage();
	}

	private static void creatMessage() {
		  Faker faker=new Faker();
		Session session = HibernateSessionFactory.getSession();
		 session.getTransaction().begin();
		 List<User> users=	new UserDAO().findAll();
		for (User user : users) {
			for(User user2:users) {
				if(user.getId().intValue() != user2.getId().intValue()) {
					for(int i=0;i<=10;i++) {
						ChatMessage chatMessage=new ChatMessage();
						chatMessage.setCreatedAt(new Timestamp(System.currentTimeMillis()));
						chatMessage.setMsgType("USER");
						chatMessage.setSenderId(user2.getId());
						chatMessage.setReceiverId(user.getId());
						chatMessage.setMessage(faker.witcher().quote());
						session.save(chatMessage);
						
					}
				}
			}
		}

	
		 session.getTransaction().commit();
		 session.close();
	
		System.exit(0);
	}

	private static void chatMessageTest() {
		  Faker faker=new Faker();
		Session session = HibernateSessionFactory.getSession();
		 session.getTransaction().begin();
		ChatMessage chatMessage=new ChatMessage();
		chatMessage.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		chatMessage.setMsgType("USER");
		chatMessage.setSenderId(1);
		chatMessage.setReceiverId(2);
		chatMessage.setMessage(faker.witcher().quote());
		
		
		session.save(chatMessage);
		 session.getTransaction().commit();
		 session.close();
	
		System.exit(0);
	}

	private static void test() {
		Session session = HibernateSessionFactory.getSession();
		 session.getTransaction().begin();
		  Faker faker=new Faker();
		 ChatGroup chatGroup=new ChatGroup();
		 chatGroup.setName("Group2");
		 
		 Set<ChatGroup> chatGroups=new HashSet<ChatGroup>();
		 chatGroups.add(chatGroup);
		 Set<User> users=new HashSet<User>();

		 for(int i=1;i<=10;i++) {
			 String name=faker.artist().name();
		 	User user=new User();
		 	user.setEmail(name+"@gmail.com");
		 	user.setName(name);
		 	user.setPassword("test123");
		 	user.setAge(11);
		 	session.save(user);
		 	
		 	user.setchatGroups(chatGroups);
		 	 users.add(user);
		 }
		 
	 	chatGroup.setUsers(users);
	 	session.save(chatGroup);
		 chatGroup.setUsers(users);

		 	
		 	
		 	
		 	/* HashSet<User> users=new HashSet<User>();
			 users.add(user);
		 	 ChatGroup chatGroup=new ChatGroupDAO().findById(1);
		 	 
		 	 chatGroup.getUsers().add(user);
		 	Set<ChatGroup> chatGroups=new HashSet<ChatGroup>();
		 	chatGroups.add(chatGroup);
			user.setchatGroups(chatGroups);
		 	 
		 	 
		 	session.saveOrUpdate(chatGroup);*/
		
		 /*ChatMessage chatMessage=new ChatMessage();
		 chatMessage.setId(1);
		 chatMessage.setSenderId(senderId);*/
		 
		 session.getTransaction().commit();
		 session.close();
	/*	UserDAO userDAO=new UserDAO();
		User user=userDAO.findById(1);
		System.out.println("us"+user.getName());*/
		
		System.exit(0);
	}
}
