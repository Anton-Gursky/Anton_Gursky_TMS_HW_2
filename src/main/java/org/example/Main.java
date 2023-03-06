package org.example;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String answer;

        System.out.println("Вы хотите создать новый заказ? (да - 1, нет - 2)");
        answer = scanner.nextLine();

        //Проверка на ввод правильной цифры (1 или 2)
        while (!answer.equals("1") && !answer.equals("2")) {
            System.err.println("Введена неверная цифра." + "\n" + "Если Вы хотите создать новый заказ, нажмите 1." +
                    "\n" + "Если хотите завершить операции - нажмите 2.");
            answer = scanner.nextLine();
        }

        while (answer.equals("1")) {

            Order order = new Order();

            createOrder(order);
            validatePrice(order);
            writeToFile(order, "C:\\Users\\anton\\IdeaProjects\\SecondLogFile.log");

            System.out.println("Заказ добавлен. Хотите внести еще один заказ? (да - 1, нет - 2)");
            answer = scanner.nextLine();
        }
    }

    public static void createOrder(Order order) {

        Scanner scanner = new Scanner(System.in);

        log.info("Начало создания заказа");

        System.out.println("Введите наименование товара:");
        order.setOrderName(scanner.nextLine());
        log.info("Введено наименование товара " + order.getOrderName());

        System.out.println("Введите количество товаров:");
        while (true) {
            try {
                order.setQuantity(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.err.println("Введенные данные не являются числом");
            }
        }
        log.info("Введено количество товаров " + order.getQuantity());

        System.out.println("Введите цену товара в диапазоне от 10 до 100:");
        while (true){
            try{
                order.setPrice(Integer.parseInt(scanner.nextLine()));
                break;
            }catch (NumberFormatException ex){
                System.err.println("Введенные данные не являются числом");
            }
        }
        log.info("Введена цена товара " + order.getPrice());
    }

    public static void validatePrice(Order order) {

        Scanner scanner = new Scanner(System.in);

        while (order.getPrice() < 10 || order.getPrice() > 100) {
            System.err.println("Введено значение вне диапазона. Введите число от 10 до 100:");
            log.error("Введено значение вне диапазона: " + order.getPrice());
            order.setPrice(Integer.parseInt(scanner.nextLine()));
        }
    }

    public static void writeToFile(Order order, String filePath) {

        BufferedWriter bufferedWriter = null;
        File file = new File(filePath);

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            bufferedWriter.append("Создание нового заказа: " + "\n" + "Имя заказа: " + order.getOrderName() + "\n");
            bufferedWriter.append("Товаров в заказе: " + order.getQuantity() + "\n");
            bufferedWriter.append("Цена: " + order.getPrice() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}