package jsp0001;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JSP0001 {
    
    public static void main(String[] args) {
        /* Step 1. User enter a positive number decimal */
        int range = inputNumber("Enter number of array: ");
        /* Step 2. Create array by generate random integer in range */
        int arr[] = randomArray(range);
        /* If you want to use the test set isTest = true */
        boolean isTest = true;
        /* Step 3. Display before sort */
        display("Unsorted array: ", arr);
        /* Step 4. Sort by Bubble sort */
        bubbleSort(arr, isTest);
        /* Step 5.  Display after sort */
        display("Sorted array: ", arr);
    }

    private static int inputNumber(String message) {
        Scanner sc = new Scanner(System.in);
        double number = 0;
        while (true) {
            try {
                /* Display message */
                System.out.println(message);
                /* Convert string was enter from the keyboard to double */
                number = Double.parseDouble(sc.nextLine());
                /* Check value of size must be a positive number */
                if (number <= 0) {
                    throw new Exception("Input could not be less than zero. Please enter a positive integer number");
                }
                /* Compare float value of input with size_array catch input be a rational number */
                if ((int) number != number) {
                    throw new Error("Input could not be a real number. Please enter a positive integer number");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input could not be a string. Please enter a positive integer number");
                continue;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                continue;
            } catch (Error error) {
                System.out.println(error.getMessage());
                continue;
            }
        }
        return (int) number;
    }
    
    private static int[] randomArray(int range) {
        Random random = new Random();
        int arr[] = new int[range];
        /* Loop use to random each element of array */
        for (int i = 0; i < range; i++) {
            arr[i] = random.nextInt(range);
        }
        return arr;
    }

    private static void bubbleSort(int arr[], boolean isTest) {
        /* Loop use to accessed from the first to last element of array, after each loop, one element is sorted */
        for (int i = 0; i < arr.length - 1; i++) {
            /* Loop use to accessed first unsorted element to the element stand before the last unsorted element */
            for (int j = 0; j < arr.length - i - 1; j++) {
                /* Compare each pair adjacent elements */
                if (arr[j] > arr[j + 1]) {
                    /* isTest == true -> Display each step in sorting process in test case */
                    if (isTest) {
                        display("", arr);
                        /* Test algorithm */
                        System.out.printf("(a[%d]=%d) > (a[%d]=%d) -> swap\n", j, arr[j], j + 1, arr[j + 1]);
                    }
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else if (isTest == true) {
                    /* Display each step in sorting process in test case */
                    display("", arr);
                    /* Test algorithm */
                    System.out.printf("(a[%d]=%d) < (a[%d]=%d) -> ok\n", j, arr[j], j + 1, arr[j + 1]);
                }
            }
        }
    }

    public static void display(String message, int arr[]) {
        System.out.println(message + Arrays.toString(arr));
    }
}
