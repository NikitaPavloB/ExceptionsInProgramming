package HomeWork1.Task1;

class Answer {
  public static void arrayOutOfBoundsException() {
    int[] arr = { 1, 2, 3 };
    // Попробуем обратиться к четвертому элементу массива (индекс 3, так как
    // индексация начинается с 0)
    int element = arr[3];
  }

  public static void divisionByZero() {
    int a = 5;
    int b = 0;
    // Попробуем выполнить деление на ноль
    int result = a / b;
  }

  public static void numberFormatException() {
    String str = "abc";
    // Попробуем преобразовать строку в число, что вызовет исключение
    // NumberFormatException
    int number = Integer.parseInt(str);
  }
}

public class Printer {
  public static void main(String[] args) {
    Answer ans = new Answer();
    try {
      ans.arrayOutOfBoundsException();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Выход за пределы массива");
    }

    try {
      ans.divisionByZero();
    } catch (ArithmeticException e) {
      System.out.println("Деление на ноль");
    }

    try {
      ans.numberFormatException();
    } catch (NumberFormatException e) {
      System.out.println("Ошибка преобразования строки в число");
    }
  }
}
