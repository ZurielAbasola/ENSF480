import src.utility.*;

public class DatabaseConnector extends Singleton {
	static DatabaseConnector instance = null;
	public static DatabaseConnector getInstance() {
		if(instance == null) {
			instance = new DatabaseConnector();
		}
		return instance;
	}
}