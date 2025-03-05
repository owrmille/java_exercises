public class FindOdd {

    public static void bubbleSort(int[] a) {
        int temp;
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i + 1] < a[i]) {
                    temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static int findIt(int[] a) {
        int count = 0;
        int lastVal = a[0];
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] == lastVal) {
                count++;
            }
            else if (count % 2 != 0) {
                return lastVal;
            }
            else {
                count = 1;
                lastVal = a[i];
            }
        }
        return lastVal;
    }

    public static int alternFindIt(int[] a) {
        int xor = 0;
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
            //System.out.println(xor);
        }
        return xor;
    }

    public static void main(String[] args) {
        int a[] = {20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};
        //System.out.println(findIt(a));

        int b[] = {1, 1, 2, 3, 3};
        System.out.println(alternFindIt(b));
        /*for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }*/
        //System.out.println(findIt(a));
    }
}