public class MakeRobotMove {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.UP);
        moveRobot(robot, 1, 4);
    }
 
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public enum Axis {
        X,
        Y
    }
 
    public static class Robot {
        int x;
        int y;
        Direction dir;
 
        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
 
        public Direction getDirection() {return dir;}
 
        public int getX() {return x;}
 
        public int getY() {return y;}
 
        public void turnLeft() {
            System.out.println("TURN LEFT");
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }
 
        public void turnRight() {
            System.out.println("TURN RIGHT");
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }
 
        public void stepForward() {
            //System.out.println(dir);
            System.out.println("STEP FORWARD");
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }
 
    public static void moveRobot(Robot robot, int toX, int toY) {
        makeMovesAlongAxis(robot, toX, Axis.X);
        makeMovesAlongAxis(robot, toY, Axis.Y);
    }

    public static void makeMovesAlongAxis(Robot robot, int toAxis, Axis ax) {
        Direction firstDir = (ax == Axis.X) ? Direction.RIGHT : Direction.UP;
        Direction secondDir = (ax == Axis.X) ? Direction.LEFT : Direction.DOWN;
        int coordinate = (ax == Axis.X) ? robot.getX() : robot.getY();
        if (toAxis > coordinate) {
            while (robot.getDirection() != firstDir) {robot.turnRight();}

        } else if (toAxis < coordinate) {
            while (robot.getDirection() != secondDir) {robot.turnRight();}
        }
        while (toAxis != coordinate) {
            robot.stepForward();
            coordinate = (ax == Axis.X) ? robot.getX() : robot.getY();
        }
    }
}