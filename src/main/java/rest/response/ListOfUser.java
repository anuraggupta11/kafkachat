package rest.response;

public class ListOfUser {
	private int id;
	private String name;
	private String profile_image;
	
	public ListOfUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListOfUser(int id, String name, String profile_image) {
		super();
		this.id = id;
		this.name = name;
		this.profile_image = profile_image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	
	
}
