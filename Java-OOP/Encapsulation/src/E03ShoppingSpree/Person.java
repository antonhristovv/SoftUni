package E03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    //name, money and a bag of products
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        String productName = product.getName();
        double productCost = product.getCost();
        if (this.money < productCost) {
            throw new IllegalArgumentException(name + " can't afford " + productName);
        } else {
            this.products.add(product);
            this.money -= productCost;
            System.out.println(this.name + " bought " + productName);
        }
    }

    @Override
    public String toString() {
        String output = name + " - ";
        if (products.isEmpty()) {
            output += "Nothing bought";
        } else {
            output += products.stream().map(Product::getName).collect(Collectors.joining(", "));
        }
        return output;
    }
}
