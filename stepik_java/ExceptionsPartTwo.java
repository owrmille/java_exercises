public class ExceptionsPartTwo {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        firstMethod();
    }
    
    public static void firstMethod() {
        System.out.println(getCallerClassAndMethodName());
        secondMethod();
    }

    public static void secondMethod() {
        System.out.println(getCallerClassAndMethodName());
        thirdMethod();
    }
    public static void thirdMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] info = new Throwable().getStackTrace();
        if (info.length > 2) { // 2 elements: getCallerClassAndMethodName() + main()
            return info[2].getClassName() + "#" + info[2].getMethodName();
        }
        return null;
    }
}
