package jsp0001;

import java.util.Random;
import java.util.Scanner;

public class JSP0001 {

    public static void main(String[] args) {

        //1. User enter a positive number decimal
        int size_array = inputPositiveNumber("Enter number of array:");
        //2. Create array by generate random integer in range
        int[] array = createArray(size_array);
        boolean test = false;
        // test algorithm
        // int[] array = {5, 1, 12, -5, 16};
        // boolean test = true;
        //3. Display before sort
        display(array, "Unsorted array: ");
        //4. Sort by Bubble sort
        BubbleSort(array, test);
        //5. Display after sort
        display(array, "Sorted array: ");
    }

    private static int inputPositiveNumber(String enterNumberOfArray) {
        Scanner sc = new Scanner(System.in);
        double size_array;
        String input;
        do {
            System.out.println(enterNumberOfArray);
            input = sc.nextLine();
            if (input.isEmpty()) { //check empty
                System.out.println("Input could not be empty. Please enter a positive integer number");
                continue;
            }
            try {
                size_array = Double.parseDouble(input);
                //check value of size must be a positive number
                if (size_array <= 0) {
                    throw new Exception();
                }
                //Compare float value of input with size_array catch input be a rational number
                if ((int) size_array != size_array) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input could not be a string. Please enter a positive integer number");
                continue;
            } catch (Exception NegaError) {
                System.out.println("Input could not be less than zero. Please enter a positive integer number");
                continue;
            } catch (Error RealNumError) {
                System.out.println("Input could not be a real number. Please enter a positive integer number");
                continue;
            }
        } while (true);
        return (int) size_array;
    }

    private static int[] createArray(int sizeArray) {
        int[] array = new int[sizeArray];
        Random rd = new Random();
        //Loop use to random each element of array
        for (int i = 0; i < sizeArray; i++) {
            array[i] = rd.nextInt(sizeArray);
        }
        return array;
    }

    private static void display(int[] array, String enterNumberOfArray) {
        System.out.print(enterNumberOfArray);
        System.out.print("[");
        //Loop use to accessed each element of array and display
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //Check index to Display comma
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        if (enterNumberOfArray.equals("Unsorted array: ")) {
            System.out.println("]");
        } else {
            System.out.print("]");
        }
    }

    private static void BubbleSort(int[] array, boolean test) {
        //Loop use to accessed from the first to last element of array, after each loop, one element is sorted
        for (int i = 0; i < array.length; i++) {
            //Loop use to accessed first unsorted element to the element stand before the last unsorted element
            for (int j = 0; j < array.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (array[j] > array[j + 1]) {
                    //Display each step in sorting process in test case
                    if (test == true) {
                        display(array, "");
                        System.out.println("    " + array[j] + ">" + array[j + 1] + ", " + "swap");//test algorithm
                    }
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else if (test == true) { //Display each step in sorting process in test case
                    display(array, "");//testalgorithm
                    System.out.println("    " + array[j] + "<" + array[j + 1] + ", " + "ok");
                }
            }
        }
    }

}
