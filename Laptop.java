import java.util.Map;
import java.util.Set;

public class Laptop {
    String ram;
    String ssd;
    String os;
    String color;

    public Laptop(String ram, String ssd, String os, String color) {
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
    }

    public static void byRam(Set<Laptop> laptops, String input, Map<String, Laptop> result) {
        Integer count = 1;
        for (Laptop laptop : laptops) {
            if (laptop.ram.contains(input)) {
                result.put(String.format("Ноутбук № %d", count), laptop);
                count++;
            }
        }
    }

    public static void bySSD(Set<Laptop> laptops, String input, Map<String, Laptop> result) {
        Integer count = 1;
        for (Laptop laptop : laptops) {
            if (laptop.ssd.contains(input)) {
                result.put(String.format("Ноутбук № %d", count), laptop);
                count++;
            }
        }
    }

    public static void byOs(Set<Laptop> laptops, String input, Map<String, Laptop> result) {
        Integer count = 1;
        for (Laptop laptop : laptops) {
            if (laptop.os.contains(input)) {
                result.put(String.format("Ноутбук № %d", count), laptop);
                count++;
            }
        }
    }

    public static void byColor(Set<Laptop> laptops, String input, Map<String, Laptop> result) {
        Integer count = 1;
        for (Laptop laptop : laptops) {
            if (laptop.color.contains(input)) {
                result.put(String.format("Ноутбук № %d", count), laptop);
                count++;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Ноутбук: \nRAM: %s\nSSD: %s\nos: %s\ncolor: %s", ram, ssd, os, color);
    }
}

