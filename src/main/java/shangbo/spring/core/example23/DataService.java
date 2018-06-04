package shangbo.spring.core.example23;

import java.util.Map;

public class DataService {
	private Map<String, String> dbconfig;

	public void setDbconfig(Map<String, String> dbconfig) {
		this.dbconfig = dbconfig;
	}

	public String toString() {
		return dbconfig.toString();
	}

}
