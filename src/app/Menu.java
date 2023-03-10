package app;

import app.product.Product;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }
    public void printMenu() {
        System.out.println("[๐ป] ๋ฉ๋ด");
        System.out.println("-". repeat(60));

        System.out.println("๐ ํ๋ฒ๊ฑฐ");
        printHamburgers();
        System.out.println();

        System.out.println("๐ ์ฌ์ด๋");
        printSide();
        System.out.println();

        System.out.println("๐ฅค๐ฅค ์๋ฃ");
        printDrink();
        System.out.println();

        System.out.println();
        System.out.println("๐งบ (0) ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("๐งบ (+) ์ฃผ๋ฌธํ๊ธฐ");
        System.out.println("-".repeat(60));
        System.out.println("[๐ฃ] ๋ฉ๋ด๋ฅผ ์ ํํด์ฃผ์ธ์ : ");


    }

    private static void printDrink() {
        for (Product product : products) {
            if ( product instanceof Drink) {
                printEachMenu(product);            }
        }
    }

    private static void printSide() {
        for (Product product : products) {
            if ( product instanceof Side) {
                printEachMenu(product);            }
        }
    }

    private static void printHamburgers() {
        for (Product product : products) {
            if ( product instanceof Hamburger) {
                printEachMenu(product);
            }
        }
    }

    private static void printEachMenu(Product product) {
        System.out.printf("(%d) %s %5dKcal %5d์\n", product.getId(), product.getName(), product.getKcal(), product.getPrice());
    }
}
