package shangbo.spring.core.example37;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessagePrinter {

    private MessageService service;

    // 限定符
    @Autowired
    @Qualifier("DB")
    public void setService(MessageService service) {
		this.service = service;
	}

	public void printMessage() {
        System.out.println(service.getMessage());
    }
}
