package shangbo.spring.core.example30;

public abstract class MessagePrinter {

    public void printMessage() {
    	MessageService service = createMessageService();
        System.out.println(service.getMessage());
    }
    
    // 注意，这是传说中的 lookup 方法
    protected abstract MessageService createMessageService();
}
