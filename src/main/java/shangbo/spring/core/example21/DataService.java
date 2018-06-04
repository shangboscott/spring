package shangbo.spring.core.example21;

import java.util.Properties;

public class DataService {
	private Properties dbconfig;

	public void setDbconfig(Properties dbconfig) {
		this.dbconfig = dbconfig;
	}

	public String toString() {
		return dbconfig.toString();
	}

}
