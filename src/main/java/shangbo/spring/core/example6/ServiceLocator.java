package shangbo.spring.core.example6;

public class ServiceLocator {
	private static OutPutService outPutService = new OutPutService();

	private ServiceLocator() {
	}

	// 工厂方法
	public OutPutService createOutPutServiceInstance() {
		return outPutService;
	}

}
