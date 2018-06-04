package shangbo.spring.core.example4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 需要告诉 Spring 扫描组件的位置
@ComponentScan(basePackages = "shangbo.spring.core.example4")
public class AppConfig {
	// 此处没有定义创建 bean 的细节
}
