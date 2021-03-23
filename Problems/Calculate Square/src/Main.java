import java.io.IOException;

class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        try {
            System.out.println(array[index] * array[index]);
        } catch (NullPointerException e) {
            System.out.println("Exception!");
        } catch (ArrayIndexOutOfBoundsException A) {
            System.out.println("Exception!");
        } catch (RuntimeException re) {
            System.out.println("Exception!");
        }
    }
}