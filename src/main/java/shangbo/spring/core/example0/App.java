package shangbo.spring.core.example0;

public class App {
	public static void main(String[] args) {
		// 传统方式是自己 new 对象
		OutPutService printer = new OutPutService();

		// 使用对象
		printer.outPut();
	}
}
