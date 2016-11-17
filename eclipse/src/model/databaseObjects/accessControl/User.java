package model.databaseObjects.accessControl;
import model.databaseObjects.DatabaseObject;

/*
 * Struct-like object Class for Users
 */
public class User extends DatabaseObject {
	public final String username;
	public final String firstName;
	public final String name;
	public String passwordHash;
	public Boolean passwordChanged;
	
	public User(int id, String username, String firstname, String name, String passwordHash, Boolean passwordChanged) {
		super(id);
		this.username = username;
		this.firstName = firstname;
		this.name = name;
		this.passwordHash = passwordHash;
		this.passwordChanged = passwordChanged;
	}
}