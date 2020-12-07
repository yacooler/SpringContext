import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vyazankin.spring.beans.Cart;
import ru.vyazankin.spring.service.ProductService;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ru.vyazankin.spring.AppConfig.class);
        testCart(context);
        context.close();
    }

    public static void testCart(AnnotationConfigApplicationContext context) {
        Scanner scanner = new Scanner(System.in);
        Cart cart;
        int res;
        ProductService productService = context.getBean("productService", ProductService.class);
        while (true) {
            System.out.println("1 - Новая корзина, иное число - выход");
            if (scanner.nextInt() != 1) break;

            //Новая корзина, тип бина - prototype
            cart = context.getBean("cart", Cart.class);

            do {
                System.out.println("-------------------Содержимое корзины----------------------");
                cart.getProductMap().forEach(((product, integer) ->
                {
                    System.out.printf("%s [%d] шт.\n", product, integer);
                }));

                System.out.println("------------------------Товары-----------------------------");
                productService.getAllProducts().forEach(System.out::println);
                System.out.println("-----------------------------------------------------------");

                System.out.println("+N - добавить товар номер N в корзину");
                System.out.println("-N - удалить товар номер N из корзины");
                System.out.println(" 0 - выход");
                res = scanner.nextInt();

                if (res > 0) {
                    cart.addProductByProductID(res);
                } else if (res < 0) {
                    cart.removeProductByProductID(-res);
                }

            } while (res != 0);

        }


    }


}
