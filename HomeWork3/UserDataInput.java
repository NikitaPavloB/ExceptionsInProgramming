package HomeWork3;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;

// 1-й вариант. Соответсвует заданному ТЗ, но по моему мнению, функицонал приложения очень неудобный. Так что ниже
// закоментирован код с намного удобным функионалом (на мой взгляд).

public class UserDataInput {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Введите Фамилия Имя Отчество Дату рождения Номер телефона пол: ");
      String input = scanner.nextLine();
      String[] userData = input.split(" ");
      if (userData.length == 6) {
        if (isValidDate(userData[3]) && isValidPhoneNumber(userData[4]) && isValidGender(userData[5])) {
          displayUserData(userData);
        } else {
          System.out.println("Ошибка: Некорректные данные. Пожалуйста, введите данные в правильном формате.");
        }
      } else {
        if (userData.length < 6) {
          System.out.println("Ошибка: Введено меньше данных, чем требуется.");
        } else {
          System.out.println("Ошибка: Введено больше данных, чем требуется.");
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
      System.out.println("Ошибка при записи в файл: " + ex.getMessage());
    }
  }

  public static void displayUserData(String[] userData) throws IOException {
    String combinedData = String.join(" ", userData);
    System.out.println(combinedData);

    String fileName = userData[0] + ".txt"; // Формируем имя файла по фамилии
    try (FileWriter writer = new FileWriter(fileName, true)) {
      writer.write(combinedData + "\n");
    }

    System.out.println("Данные сохранены в файле: " + fileName);
  }

  public static boolean isValidDate(String date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(date);
      return true;
    } catch (ParseException e) {
      return false;
    }
  }

  public static boolean isValidPhoneNumber(String phoneNumber) {
    return phoneNumber.matches("\\d{11}");
  }

  public static boolean isValidGender(String gender) {
    return gender.equals("m") || gender.equals("f");
  }
}

// 2-вариант! После распаковки поравить надписи и все заработает.

// public class UserDataInput {

// public static void main(String[] args) {
// try (Scanner scanner = new Scanner(System.in)) {
// String[] userData = readUserData(scanner);
// if (userData != null) {
// displayUserData(userData);
// }
// } catch (IOException ex) {
// ex.printStackTrace();
// System.out.println("Ошибка при записи в файл: " + ex.getMessage());
// }
// }

// public static String[] readUserData(Scanner scanner) {
// System.out.print("Введите ФИО (Фамилия Имя Отчество): ");
// String fullName = scanner.nextLine();

// // Разбиваем строку ФИО на компоненты
// String[] nameParts = fullName.split(" ");
// if (nameParts.length != 3) {
// System.out.println("Ошибка: Неверный формат ФИО. Введите Фамилию, Имя и
// Отчество через пробел.");
// return null;
// }

// String[] userData = new String[6];

// userData[0] = nameParts[0]; // Фамилия
// userData[1] = nameParts[1]; // Имя
// userData[2] = nameParts[2]; // Отчество

// System.out.print("Дата рождения (дд.мм.гггг): ");
// userData[3] = scanner.nextLine();
// System.out.print("Номер телефона (11 цифр): ");
// userData[4] = scanner.nextLine();
// System.out.print("Пол (m/f): ");
// userData[5] = scanner.nextLine();

// try {
// if (!isValidDate(userData[3])) {
// throw new UserDataFormatException("Неверный формат даты рождения.");
// }

// if (!isValidPhoneNumber(userData[4])) {
// throw new UserDataFormatException("Неверный формат номера телефона. Номер
// должен содержать 11 цифр.");
// }

// if (!isValidGender(userData[5])) {
// throw new UserDataFormatException("Неверный формат пола. Пол должен быть 'm'
// или 'f'.");
// }

// return userData;
// } catch (ParseException | UserDataFormatException e) {
// System.out.println("Ошибка: " + e.getMessage());
// return null;
// }
// }

// public static void displayUserData(String[] userData) throws IOException {
// String combinedData = String.join(" ", userData);
// System.out.println(combinedData);

// String fileName = userData[0] + ".txt"; // Формируем имя файла по фамилии
// try (FileWriter writer = new FileWriter(fileName, true)) {
// writer.write(combinedData + "\n");
// }

// System.out.println("Данные сохранены в файле: " + fileName);
// }

// public static boolean isValidDate(String date) throws ParseException {
// SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
// dateFormat.setLenient(false);
// dateFormat.parse(date);
// return true;
// }

// public static boolean isValidPhoneNumber(String phoneNumber) {
// // Проверка на числовой формат и длину номера
// return phoneNumber.matches("\\d{11}");
// }

// public static boolean isValidGender(String gender) {
// return gender.equals("m") || gender.equals("f");
// }
// }
