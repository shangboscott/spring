package shangbo.spring.core.example36;

import org.springframework.beans.factory.annotation.Qualifier;

public class MessagePrinter {

    private MessageService service;

    // 使用限定符
    @Qualifier("DB")
    public void setService(MessageService service) {
		this.service = service;
	}

	public void printMessage() {
        System.out.println(service.getMessage());
    }
}
