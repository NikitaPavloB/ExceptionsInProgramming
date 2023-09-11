package HomeWork2.Task2;

public class Main {
  public static void main(String[] args) {
    try {
      int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      int d = 0;
      double catchedRes1 = (double) intArray[8] / d;
      System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException e) {
      System.out.println("Catching exception: " + e);
    }
  }
}
