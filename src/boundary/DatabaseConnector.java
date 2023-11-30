import src.utility.*;

public class DatabaseConnector extends Singleton {
	public static DatabaseConnector getInstance() {
		return (DatabaseConnector) Singleton.getInstance();
	}
}