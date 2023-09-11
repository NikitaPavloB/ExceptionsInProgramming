package HomeWork1.Task3;

import java.util.Arrays;

class Answer {
  public int[] divArrays(int[] a, int[] b) {
    int lenA = a.length;
    int lenB = b.length;

    // Если длины массивов не равны или массив b пуст, вернем пустой массив длины 1
    if (lenA != lenB || lenB == 0) {
      return new int[] { 0 };
    }

    int[] c = new int[lenA];
    for (int i = 0; i < lenA; i++) {
      if (b[i] == 0) {
        // Если делитель равен нулю, вернем пустой массив длины 1
        return new int[] { 0 };
      }
      c[i] = a[i] / b[i];
    }

    return c;
  }
}

public class Printer {
  public static void main(String[] args) {
    int[] a = {};
    int[] b = {};

    if (args.length == 0) {
      a = new int[] { 12, 8, 16, 25 };
      b = new int[] { 4, 2, 4 };
    } else {
      a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
      b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
    }

    Answer ans = new Answer();
    int[] result = ans.divArrays(a, b);
    System.out.println(Arrays.toString(result));
  }
}
