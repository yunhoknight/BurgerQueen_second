package app;

import app.product.Product;
import app.product.ProductRepository;
import app.product.subproduct.BurgerSet;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];
    private Scanner scanner = new Scanner(System.in);

    private ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void printCart() {
        System.out.println("๐งบ ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("-".repeat(60));

        // ์ฌ๊ธฐ์ ์ฅ๋ฐ๊ตฌ๋ ์ํ๋ค์ ์ต์ ์ ๋ณด์ ํจ๊ป ์ถ๋ ฅ

        System.out.println("-".repeat(60));
        System.out.printf("ํฉ๊ณ : %d์\n", calculateTotalPrice());

        System.out.println("์ด์ ์ผ๋ก ๋์๊ฐ๋ ค๋ฉด ์ํฐ๋ฅผ ๋๋ฅด์ธ์.");
        Scanner.nextLine();
    }

    private void printCarItemDetails(){
        for (Product product : items) {
            if (product instanceof BurgerSet) {
            BurgerSet burgerSet = (BurgerSet) product;
                System.out.printf("%s %6d์ (%s(์ผ์ฐน %d๊ฐ), %s(๋นจ๋ %s))\n",
                        product.getName(),
                        product.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasStraw() ? "์์" : "์์");
            }
            else if (product instanceof Hamburger) {
                System.out.printf("%-8s %6d์ (๋จํ)\n",
                        product.getName(),
                        product.getPrice());
            }
            else if (product instanceof Side) {
                System.out.printf("%-8s %6d์ (์ผ์ฐน %d๊ฐ)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getKetchup());
            }
            else if (product instanceof Drink) {
                System.out.printf("%-8s %6d์ (๋นจ๋ %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).hasStraw() ? "์์" : "์์");
            }
        }
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void addToCart(int productId) {
        Product product;

        for (Product element : productRepository.getAllProducts()) {
            if (element.getId() == productId) product = element;
        }
    }
}
