package shangbo.spring.core.example29;

public class MessagePrinter {

    final private MessageService service;

    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}
