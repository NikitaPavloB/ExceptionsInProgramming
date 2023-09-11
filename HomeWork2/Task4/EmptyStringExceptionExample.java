package HomeWork2.Task4;

import java.util.Scanner;

public class EmptyStringExceptionExample {
  public static void main(String[] args) {
    try {
      String input = readNonEmptyStringFromUser();
      System.out.println("Вы ввели: " + input);
    } catch (EmptyStringException ex) {
      System.out.println("Ошибка: Пустые строки вводить нельзя.");
    }
  }

  public static String readNonEmptyStringFromUser() throws EmptyStringException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите строку: ");
    String input = scanner.nextLine();
    scanner.close();

    if (input.isEmpty()) {
      throw new EmptyStringException();
    }

    return input;
  }
}

class EmptyStringException extends Exception {
  // Пустое исключение для обозначения ситуации с пустой строкой.
}
