package instantiation.users;

public class UserProfile {

	private String username;
	private String name;
	private String email;
	
	public UserProfile(String username, String name, String email) {
		this.username = username;
		this.name = name;
		this.email = email;
		
		System.out.printf("Creating user : %s (%s), email: %s%n", username, name, email);
	}
	
	public UserProfile(String username, String email) {
		this(username, username, email);
	}
	
}
