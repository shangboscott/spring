package shangbo.spring.core.example39;

public class MessagePrinter {

    private MessageService service;

    public void setService(MessageService service) {
		this.service = service;
	}

	public void printMessage() {
        System.out.println(service.getMessage());
    }
}
