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
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        // 여기에 장바구니 상품들을 옵션 정보와 함께 출력

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", calculateTotalPrice());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요.");
        Scanner.nextLine();
    }

    private void printCarItemDetails(){
        for (Product product : items) {
            if (product instanceof BurgerSet) {
            BurgerSet burgerSet = (BurgerSet) product;
                System.out.printf("%s %6d원 (%s(케찹 %d개), %s(빨대 %s))\n",
                        product.getName(),
                        product.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasStraw() ? "있음" : "없음");
            }
            else if (product instanceof Hamburger) {
                System.out.printf("%-8s %6d원 (단품)\n",
                        product.getName(),
                        product.getPrice());
            }
            else if (product instanceof Side) {
                System.out.printf("%-8s %6d원 (케찹 %d개)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getKetchup());
            }
            else if (product instanceof Drink) {
                System.out.printf("%-8s %6d원 (빨대 %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).hasStraw() ? "있음" : "없음");
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
