package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product(3128874119L, "Banana", LocalDate.parse("2023-01-24"), 124, 0.55),
                new Product(2927458265L, "Apple", LocalDate.parse("2022-12-09"), 18, 1.09),
                new Product(9189927460L, "Carrot", LocalDate.parse("2023-03-31"), 89, 2.99)
        };

        printProducts(products);
    }

    static void printProducts(Product[] products) {
        List<Product> sortedProducts = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName))
                .toList();

        String json = sortedProducts.stream().map(Product::toJSON)
                .collect(Collectors.joining(",\n", "[\n", "\n]"));
        System.out.println("Printed in json format");
        System.out.println(json);

        System.out.println("--------------------------");
        String xml = sortedProducts.stream().map(Product::toXML)
                .collect(Collectors.joining("\n", "<products>\n", "\n</products>"));
        System.out.println("Printed in XML format");
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println(xml);

        System.out.println("--------------------------");
        String csv = sortedProducts.stream().map(Product::toCSV)
                .collect(Collectors.joining("\n"));
        System.out.println("Printed in CSV format");
        System.out.println(csv);
    }
}
