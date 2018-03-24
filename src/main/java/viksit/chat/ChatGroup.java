package viksit.chat;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="chat_group")
public class ChatGroup {
	private Integer id;
	private String name;
	private Set<User> users=new HashSet<User>(0);
	public ChatGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatGroup(Integer id, String name, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
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
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "group_user",  joinColumns = {
			@JoinColumn(name = "group_id", nullable = true) }, inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = true) })
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
}
