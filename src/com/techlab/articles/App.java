package com.techlab.articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlab.articles.model.Article;


public class App {
    public static void showMenu() {
        System.out.println("----- Bienvenido -----");
        System.out.println("0. Salir");
        System.out.println("1. Crear un artículo nuevo");
        System.out.println("2. Consultar un artículo");
        System.out.println("3. Listar artículos");
        System.out.println("4. Modificar un artículo");
        System.out.println("5. Borrar un artículo");
        System.out.println();
    }
    public static void create(List<Article> articles, Article newArticle) {
        articles.add(newArticle);
    }
    public static void listArticles(List<Article> articles) {
        System.out.println("----- Tus productos -----");
        System.out.println();
        for (Article article : articles) {
            System.out.println("Nombre del artículo: " + article.getName());
            if (article.getDescription() != "") {
                System.out.println("Descripción: " + article.getDescription());
            }
            System.out.println("Precio: " + article.getPrice());
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        List<Article> articles = new ArrayList<>();
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            showMenu();
            System.out.print("Ingrese su opción: ");
            option = sc.nextInt();
            System.out.println();
            switch (option) {
                case 0 -> System.out.println("Gracias por venir. Vuelva pronto");
                case 1 -> {
                    System.out.print("Ingrese el nombre del artículo: ");
                    String name = sc.nextLine();
                    System.out.print("Ingrese la descripción del artículo (opcional): ");
                    String description = sc.nextLine();
                    System.out.print("Ingrese el precio del artículo (mayor a cero): ");
                    Double price = sc.nextDouble();
                    Article newArticle = new Article(name, description, price);
                    create(articles, newArticle);
                    System.out.println("Artículo creado");
                }
                case 2 -> {
                    System.out.println("....");
                }
                case 3 -> listArticles(articles);
                default -> System.out.println("Opción no válida");
            }
        } while (option != 0);
        sc.close();
    }
}
