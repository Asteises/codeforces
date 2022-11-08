package ru.asteises.year_2022.ComparableSort;

class Product implements Comparable<Product> {
    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product anotherProduct) {
        return this.price.compareTo(anotherProduct.price);
    }

    @Override
    public String toString() {
        return name + " (" + price + " р.)";
    }
}

