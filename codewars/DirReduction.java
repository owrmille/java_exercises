import java.util.Stack;

public class DirReduction {
    public static boolean cancelsOut(String lastDir, String dir) {
        return (lastDir.equals("NORTH") && dir.equals("SOUTH") ||
            lastDir.equals("SOUTH") && dir.equals("NORTH") ||
            lastDir.equals("EAST") && dir.equals("WEST") ||
            lastDir.equals("WEST") && dir.equals("EAST"));
    }

    public static String[] dirReduc(String[] directions) {
        Stack<String> stack = new Stack<>();
        for (String dir : directions) {
            if (!stack.isEmpty() && cancelsOut(stack.peek(), dir)) {
                stack.pop();
            }
            else stack.push(dir);
        }
        return stack.toArray(new String[0]);
    }

    public static void main(String[] args) {
        //String[] directions = {"NORTH", "WEST", "SOUTH", "EAST"};
        String[] directions = {"NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"};
        String[] optimalDirections = dirReduc(directions);
        for (String elem : optimalDirections) {
            System.out.println(elem);
        }
    }
}
