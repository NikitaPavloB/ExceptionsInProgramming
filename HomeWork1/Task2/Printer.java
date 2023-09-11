package HomeWork1.Task2;

import java.util.Arrays;

class Answer {
  public int[] subArrays(int[] a, int[] b) {
    int lenA = a.length;
    int lenB = b.length;

    // Если длины массивов не равны, вернем пустой массив длины 1
    if (lenA != lenB) {
      return new int[] { 0 };
    }

    int[] c = new int[lenA];
    for (int i = 0; i < lenA; i++) {
      c[i] = a[i] - b[i];
    }

    return c;
  }
}

public class Printer {
  public static void main(String[] args) {
    int[] a = {};
    int[] b = {};

    if (args.length == 0) {
      a = new int[] { 4, 5, 6 };
      b = new int[] { 1, 2, 3 };
    } else {
      a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
      b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
    }

    Answer ans = new Answer();
    int[] result = ans.subArrays(a, b);
    System.out.println(Arrays.toString(result));
  }
}
