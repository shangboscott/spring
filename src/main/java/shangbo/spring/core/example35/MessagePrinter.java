package shangbo.spring.core.example35;

import org.springframework.beans.factory.annotation.Autowired;

public class MessagePrinter {

    private MessageService service;

    @Autowired
    public void setService(MessageService service) {
		this.service = service;
	}

	public void printMessage() {
        System.out.println(service.getMessage());
    }
}
