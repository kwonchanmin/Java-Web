package vo;

public class Login {

	private String id;
	private String name;
	private String password;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	public Login(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
