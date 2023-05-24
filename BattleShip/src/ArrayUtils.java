public class ArrayUtils {
    public static void main(String[] args) {
        Utilities.clrscrn();
        int numbers[] = { 5, 7, 2, 7, 8, 9, 3 };
        printArray(numbers);

        double numbers2[] = { 23.54, 76.53, 22.2222, 8976543.32, 75.334 };
        printArray(numbers2);

        double[] array = createFilledArray(5, 88.8);
        printArray(array);
    }
    /**
     * Overloaded versions of printArray
     * Prints specified array, one item per line 
     */
    public static void printArray(int input[]) {
        for (int i = 0; i < input.length; i++) {
            Utilities.prn(input[i]);
        }
    }

    public static void printArrays(int input[]) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void printArray(double input[]) {
        for (int i = 0; i < input.length; i++) {
            Utilities.prn(input[i]);
        }
    }

    public static void printArray(long input[]) {
        for (int i = 0; i < input.length; i++) {
            Utilities.prn(input[i]);
        }
    }

    public static void printArray(float input[]) {
        for (int i = 0; i < input.length; i++) {
            Utilities.prn(input[i]);
        }
    }

    public static void printArray(char input[]) {
        for (int i = 0; i < input.length; i++) {
            Utilities.prn(input[i]);
        }
    }

    public static void printArray(boolean input[]) {
        for (int i = 0; i < input.length; i++) {
            Utilities.prn(input[i]);
        }
    }

    public static void printArray(String input[]) {
        for (int i = 0; i < input.length; i++) {
            Utilities.prn(input[i]);
        }
    }
    /**
     * Overloaded versions of create filled array
     * Creates and returns an array of specified size, filled with specified value
     */
    public static double[] createFilledArray(int size, double value) {
        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            array[i] = value;
        }

        return array;

    }

    public static float[] createFilledArray(int size, float value) {
        float[] array = new float[size];

        for (int i = 0; i < size; i++) {
            array[i] = value;
        }

        return array;

    }

    public static long[] createFilledArray(int size, long value) {
        long[] array = new long[size];

        for (int i = 0; i < size; i++) {
            array[i] = value;
        }

        return array;

    }

    public static int[] createFilledArray(int size, int value) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = value;
        }

        return array;

    }

    public static char[] createFilledArray(int size, char value) {
        char[] array = new char[size];

        for (int i = 0; i < size; i++) {
            array[i] = value;
        }

        return array;

    }

    public static boolean[] createFilledArray(int size, boolean value) {
        boolean[] array = new boolean[size];

        for (int i = 0; i < size; i++) {
            array[i] = value;
        }

        return array;

    }
}
