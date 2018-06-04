package shangbo.spring.core.example33;

import org.springframework.beans.factory.annotation.Autowired;

public class MessagePrinter {

    private MessageService service;

    // 自动注入
    @Autowired
    public void setService(MessageService service) {
		this.service = service;
	}

	public void printMessage() {
        System.out.println(service.getMessage());
    }
}
