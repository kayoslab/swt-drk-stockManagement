package model.databaseObjects.environment;
import model.databaseObjects.DatabaseObject;

public class Location extends DatabaseObject {
	public final String title;	
	public Location(int id, String title) {
		super(id);
		this.title = title;
	}

}
