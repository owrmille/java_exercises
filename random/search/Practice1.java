import java.util.*;

class Item {
    String name;
    int score;

    Item(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }
}

public class Practice1 {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("RequestBuilder", 10));
        items.add(new Item("ResponseBuilder", 5));
        items.add(new Item("ConfigParser", 2));
        items.add(new Item("RequestHandler", 6));

        items.sort((a,b) -> {
            if (a.score != b.score) {
                return Integer.compare(a.score, b.score);
            }
            return a.name.compareToIgnoreCase(b.name);
        });

        System.out.println(items);
    }
}

// sort is O(n log n)
