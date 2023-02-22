package org.example;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main
{
    private static final Logger log = Logger.getLogger(Main.class);
    private static final Logger orderLogger = Logger.getLogger("SECOND_LOGGER");

    public static void main( String[] args )
    {
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        log.info("Начало создания заказа");

        System.out.println("Введите наименование товара:");
        order.setOrderName(scanner.nextLine());
        log.info("Введено наименование товара " + order.getOrderName());
        orderLogger.info("Создание нового заказа: " + "\n" + "Имя заказа: " + order.getOrderName());

        System.out.println("Введите количество товаров:");
        order.setQuantity(scanner.nextInt());
        log.info("Введено количество товаров " + order.getQuantity());
        orderLogger.info("Товаров в заказе: " + order.getQuantity());

        System.out.println("Введите цену товара в диапазоне от 10 до 100:");
        order.setPrice(scanner.nextInt());

        while (order.getPrice() < 10 || order.getPrice() > 100){
            System.err.println("Введено значение вне диапазона. Введите число от 10 до 100:");
            log.error("Введено значение вне диапазона: " + order.getPrice());
            order.setPrice(scanner.nextInt());
        }

        log.info("Введена цена товара " + order.getPrice());
        orderLogger.info("Цена: " + order.getPrice());
    }
}