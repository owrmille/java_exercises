import java.util.Map;

public class PeteBaker {
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        int currentCapacity = 0;
        int totalCapacity = Integer.MAX_VALUE;
      
        for (Map.Entry<String, Integer> item : recipe.entrySet()) {
            currentCapacity = available.getOrDefault(item.getKey(), 0) / item.getValue();
            totalCapacity = Math.min(totalCapacity, currentCapacity);
        }
      
        return totalCapacity;
    }

    public static boolean basicTest() {
        Map<String, Integer> recipe = Map.of(
            "flour", 500,
            "sugar", 200,
            "eggs", 1);
        Map<String, Integer> available = Map.of(
            "flour", 1200,
            "sugar", 1200,
            "eggs", 5,
            "milk", 200);
        
        return 2 == cakes(recipe, available);
    }

    public static void main(String[] args) {
        System.out.println(basicTest());
    }
}