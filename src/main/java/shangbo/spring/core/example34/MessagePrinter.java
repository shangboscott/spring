package shangbo.spring.core.example34;

public class MessagePrinter {

    private MessageService service;

    public void setService(MessageService service) {
		this.service = service;
	}

	public void printMessage() {
        System.out.println(service.getMessage());
    }
}
