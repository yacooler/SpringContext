import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vyazankin.spring.repository.ProductRepository;
import ru.vyazankin.spring.service.ProductService;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ru.vyazankin.spring.AppConfig.class);
        test(context);
        context.close();
    }

    public static void test(AnnotationConfigApplicationContext context){
        ProductService productService = context.getBean("productService", ProductService.class);

    }


}
