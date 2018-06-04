package shangbo.spring.core.example32;

public class MessagePrinter {

    private MessageService service;

    public void setService(MessageService service) {
		this.service = service;
	}

	public void printMessage() {
        System.out.println(service.getMessage());
    }
}
