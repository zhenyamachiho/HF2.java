import java.util.*;
import java.io.*;

public class Toy {
    String id;
    String name;
    int frequency;

    public Toy(String id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Toy> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.frequency));
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> frequencies = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите ID игрушки, название и частоту выпадения:");
            String id = scanner.next();
            String name = scanner.next();
            int frequency = scanner.nextInt();

            ids.add(id);
            names.add(name);
            frequencies.add(frequency);

            queue.add(new Toy(id, name, frequency));
        }

        try {
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < 10; i++) {
                if (!queue.isEmpty()) {
                    Toy toy = queue.poll();
                    writer.write("ID: " + toy.id + ", Название: " + toy.name + ", Частота: " + toy.frequency + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
