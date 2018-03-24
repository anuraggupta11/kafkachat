package viksit.chat;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="chat_message")
public class ChatMessage {
	private Integer id;
	private Integer senderId;
	private Integer receiverId;
	private String msgType;
	private String message;
	private Timestamp createdAt;
	public ChatMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatMessage(Integer id, Integer senderId, Integer receiverId, String msgType, String message,
			Timestamp createdAt) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.msgType = msgType;
		this.message = message;
		this.createdAt = createdAt;
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
	@Column(name="sender_id")
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	@Column(name="receiver_id")
	public Integer getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}
	@Column(name="msg_type")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	@Column(name="message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Column(name="created_at")
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
