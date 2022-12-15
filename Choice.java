// 1.Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// 2.Создать множество ноутбуков.
// 3.Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
// Критерии фильтрации можно хранить в Map.
// Например: “Введите цифру, соответствующую необходимому критерию:
//     1 - ОЗУ
//     2 - Объем ЖД
//     3 - Операционная система
//     4 - Цвет …

// 5.Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

// 6.Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.*;

public class Choice {
    public static Integer enterFilter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для поиска: ");
        System.out.println(
                "1 по оперативной памяти\n2 по жесткому диску\n3 по операционной системе\n4 по цвету\n");
        System.out.println("Ваш выбор: ");
        return scanner.nextInt();
    }

    public static void showResult(Map<String, Laptop> result) {
        for (var laptop : result.entrySet()) {
            System.out.printf("%s\n%s\n\n", laptop.getKey(), laptop.getValue().toString());
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> filter = new HashMap<>();
        Map<String, Laptop> result = new LinkedHashMap<>();
        Set<Laptop> laptops = new HashSet<>();
        Laptop laptop1 = new Laptop("2 Gb", "2 Tb", "Windows 10", "Black");
        Laptop laptop2 = new Laptop("2 Gb", "1 Tb", "Windows 10", "White");
        Laptop laptop3 = new Laptop("4 Gb", "2 Tb", "Mac OS", "Green");
        Laptop laptop4 = new Laptop("4 Gb", "1 Tb", "Mac OS", "White");
        Laptop laptop5 = new Laptop("3 Gb", "1 Tb", "Windows 11", "Black");
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        Scanner scanner = new Scanner(System.in);
        filter.put(1, "ram");
        filter.put(2, "hdd");
        filter.put(3, "os");
        filter.put(4, "color");
        Integer choice = enterFilter();
        if (filter.containsKey(choice)) {
            switch (choice) {
                case 1: {
                    System.out.println("Введите объем ОЗУ: ");
                    String input = scanner.next();
                    Laptop.byRam(laptops, input, result);
                    showResult(result);
                    break;
                }
                case 2: {
                    System.out.println("Введите объем SSD : ");
                    String input = scanner.next();
                    Laptop.bySSD(laptops, input, result);
                    showResult(result);
                    break;
                }
                case 3: {
                    System.out.println("Введите название оперативной системы : ");
                    String input = scanner.next();
                    Laptop.byOs(laptops, input, result);
                    showResult(result);
                    break;
                }
                case 4: {
                    System.out.println("Введите цвет : ");
                    String input = scanner.next();
                    Laptop.byColor(laptops, input, result);
                    showResult(result);
                    break;
                }
                default:
                    break;
            }
        }
        scanner.close();
    }
}
