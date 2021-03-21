package codingSites.educative.Arrays;

import java.util.Arrays;

public class ProductArray {
  // incorrect solution,  few test cases are failing like when there is zero
  public static int[] findProduct(int arr[]) {
    int totalElement = arr.length;
    if (totalElement == 0)
      return new int[] {};
    if (totalElement == 1)
      return arr;

    int[] result = new int[totalElement];
    int[] prefixMultiplication = new int[totalElement];
    int[] suffixMultiplication = new int[totalElement];

    prefixMultiplication[0] = arr[0];
    suffixMultiplication[totalElement - 1] = arr[totalElement - 1];

    for (int index = 1; index < totalElement; index++) {
      prefixMultiplication[index] = prefixMultiplication[index - 1] * arr[index];
      suffixMultiplication[totalElement - index - 1] = suffixMultiplication[totalElement - index]
          * arr[totalElement - index - 1];
    }
    printArray(prefixMultiplication);
    printArray(suffixMultiplication);
    for (int index = 0; index < totalElement; index++) {
      if (arr[index] == 0) {
        result[index] = 0;
      } else {
        result[index] = (suffixMultiplication[index] / arr[index]) * (prefixMultiplication[index] / arr[index]);
      }
    }

    return result;
  }

  // correct solution but algorithm is tricky to understand.
  public static int[] findProductAnotherSolution(int arr[]) {
    int n = arr.length;
    int i, temp = 1;

    // Allocation of result array
    int result[] = new int[n];

    // Product of elements on left side excluding arr[i]
    for (i = 0; i < n; i++) {
      result[i] = temp;
      temp *= arr[i];
    }
    printArray(result);
    // Initializing temp to 1 for product on right side
    temp = 1;

    // Product of elements on right side excluding arr[i]
    for (i = n - 1; i >= 0; i--) {
      result[i] *= temp;
      temp *= arr[i];
    }
    printArray(result);
    return result;
  }

  public static String arrayToString(int arr[]) {
    if (arr.length > 0) {
      String result = "";
      for (int i = 0; i < arr.length; i++) {
        result += arr[i] + " ";
      }
      return result;
    } else {
      return "Empty Array!";
    }
  }

  public static void main(String[] args) {
    // int input[] = new int[] { 1, 2, 3, 4 };
    int input[] = new int[] { 0, 1 , 2 };
    //int result[] = findProduct(input);
    int result[] = findProductAnotherSolution(input);
    printArray(result);
  }

  public static void printArray(int[] input) {
    System.out.println(Arrays.toString(input));
  }
}
