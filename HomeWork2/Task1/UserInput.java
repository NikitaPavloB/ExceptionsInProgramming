package HomeWork2.Task1;

import java.util.Scanner;

public class UserInput {
  public static void main(String[] args) {
    float userInput = readFloatFromUser();
    System.out.println("Вы ввели: " + userInput);
  }

  public static float readFloatFromUser() {
    Scanner scanner = new Scanner(System.in);
    float result = 0.0f;
    boolean isValidInput = false;

    while (!isValidInput) {
      try {
        System.out.print("Введите дробное число (типа float): ");
        String input = scanner.nextLine();
        input = input.replace(",", "."); // Заменяем запятую на точку

        if (input.contains(".")) {
          // Проверяем, содержит ли строка точку (десятичный разделитель)
          result = Float.parseFloat(input);
          isValidInput = true;
        } else {
          // Если в строке нет точки, то это не дробное число
          throw new NumberFormatException();
        }
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: Некорректный ввод. Пожалуйста, введите дробное число.");
      }
    }

    scanner.close();
    return result;
  }
}
