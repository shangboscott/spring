package shangbo.spring.core.example30;

public class MessageServiceImpl implements MessageService {
	private int times = 0;

	public String getMessage() {
		times++;
		return "Hello World-" + times;
	}

}
