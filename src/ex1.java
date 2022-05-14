import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ex1 {
    static ArrayList<Integer> FirstShip = new ArrayList<>(4);
    static ArrayList<Integer> container = new ArrayList<>(30);
    static ArrayList<Integer> SecondShip = new ArrayList<>(4);
    static ArrayList<Integer> ThirdShip = new ArrayList<>(4);


    public static void main(String[] args) throws InterruptedException {
        Thread th2 = new Thread(() -> {
            try {
                Loading();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread th1 = new Thread(() -> {
            try {
                Stock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        th1.start();
        th2.start();
    }


    public static void Stock() throws InterruptedException {
        container.add(1);
        while (container.size() <= 30) {
            System.out.println("На складе: " + container + " контейнеров с товаром.");
            container.add(+1);
            System.out.println("Пришел товар.На складе: " + container + " контейнеров с товаром.");
            sleep(5000);
        }// замораживает программу на 500 миллисекунд
    }

    public static void Loading() throws InterruptedException {
        System.out.println("Прибыл первый корабль");
        System.out.println("Корабль готов к погрузке");
        sleep(5000);
        while (FirstShip.size() <= 3) {
            FirstShip.add(1);
            container.remove(1);
            System.out.println("Ушел товар со склада.На складе: " + container + " контейнеров с товаром.");
            System.out.println("Корабль грузится" + FirstShip);
            sleep(5000);
        }
        System.out.println("Корабль загружен товаром" + FirstShip);
        System.out.println("Первый корабль убывает");

        System.out.println("Прибыл второй корабль");
        System.out.println("Второй корабль готов к погрузке");
        sleep(5000);
        while (SecondShip.size() <= 3) {
            SecondShip.add(1);
            container.remove(1);
            System.out.println("Ушел товар со склада.На складе: " + container + " контейнеров с товаром.");
            System.out.println("Корабль грузится" + SecondShip);
            sleep(5000);
        }
        System.out.println("Корабль загружен товаром" + SecondShip);
        System.out.println("Второй корабль убывает");

        System.out.println("Прибыл третий корабль");
        System.out.println("Третий корабль готов к погрузке");
        sleep(5000);
        while (ThirdShip.size() <= 3) {
            ThirdShip.add(1);
            container.remove(1);
            System.out.println("Ушел товар со склада.На складе: " + container + " контейнеров с товаром.");
            System.out.println("Корабль грузится" + ThirdShip);
            sleep(5000);
        }
        System.out.println("Корабль загружен товаром" + ThirdShip);
        System.out.println("Третий корабль убывает");

    }
}

