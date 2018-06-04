package shangbo.spring.core.example5;

public class OutPutService {
	private static OutPutService outPutService = new OutPutService();

	private OutPutService() {
	}

	// 静态工厂
	public static OutPutService createInstance() {
		return outPutService;
	}

	public void outPut() {
		System.out.println("Hello World");
	}

}
