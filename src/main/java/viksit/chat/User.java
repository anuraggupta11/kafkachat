package viksit.chat;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity

public class User {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Integer age;
	private Set<ChatGroup> chatGroups=new HashSet<ChatGroup>(0);
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String email, String password, Integer age, Set<ChatGroup> chatGroups) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.chatGroups = chatGroups;
	}
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name" ,nullable = false, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="email" ,nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password" ,nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="age" ,nullable = false)
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
	public Set<ChatGroup> getchatGroups() {
		return chatGroups;
	}
	public void setchatGroups(Set<ChatGroup> chatGroups) {
		this.chatGroups = chatGroups;
	}
	
}
