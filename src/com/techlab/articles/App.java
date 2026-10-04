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
    public static boolean create(List<Article> articles, Article newArticle) {
        return articles.add(newArticle);
    }
    public static boolean isExists(List<Article> articles, String articleToSearh) {
        return articles.stream().anyMatch(article -> article.getName().equalsIgnoreCase(articleToSearh.trim()));
    }
    public static void listArticles(List<Article> articles) {
        if (articles.isEmpty()) {
            System.out.println("No ha articulos por mostrar. Empiece por crear 1");
        } else {
            System.out.println("----- Tus productos -----");
            System.out.println();
            for (Article article : articles) {
                System.out.println(article.toString());
                System.out.println();
            }
        }
    }
    public static boolean delete(List<Article> articles, String articleToRemove) {
        return articles.removeIf(article -> article.getName().equalsIgnoreCase(articleToRemove));
    }
    public static void main(String[] args) throws Exception {
        List<Article> articles = new ArrayList<>();
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            showMenu();
            System.out.print("Ingrese su opción: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 0 -> System.out.println("Gracias por venir. Vuelva pronto");
                case 1 -> {
                    System.out.print("Ingrese el nombre del artículo: ");
                    String name = sc.nextLine();
                    System.out.print("Ingrese la descripción del artículo (opcional): ");
                    String description = sc.nextLine();
                    System.out.print("Ingrese el precio del artículo (mayor a cero): ");
                    double price = sc.nextDouble();
                    Article newArticle = new Article(name, description, price);
                    boolean result = create(articles, newArticle);
                    if (result) {
                        System.out.println("Artículo creado correctamente");
                    }
                }
                case 2 -> {
                    System.out.print("Que artículo desea consular? ");
                    String articleToSearch = sc.nextLine();
                    boolean result = isExists(articles, articleToSearch);
                    if (result) {
                        System.out.println("El artículo solicitado existe");
                    } else {
                        System.out.println("El artículo solicitado no existe");
                    }
                }
                case 3 -> listArticles(articles);
                case 4 -> System.out.println("función modificar en construcción....");
                case 5 -> {
                    System.out.print("Que artículo desea eliminar? ");
                    String articleToRemove = sc.nextLine();
                    boolean result = delete(articles, articleToRemove);
                    if (result) {
                        System.out.println("El artículo fue eliminado correctamente");
                    } else {
                        System.out.println("El artículo solicitado no existe");
                    }
                }
                default -> System.out.println("Opción no válida");
            }
            System.out.println();
        } while (option != 0);
        sc.close();
    }
}
