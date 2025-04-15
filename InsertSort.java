import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
/**.
 * This is a class that implements the insertion sort algorithm. *
 * @author Tony Tran
 * @version 1.0
 * @since 2025-04-10
 */
final class InsertSort {
    /**
     * This is a private constructor to satisfy style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private InsertSort() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This is the main method to run the program.
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        // Create a Scanner object to read from the input file
        Scanner input = new Scanner(new File(args[0]));
        FileWriter writer = new FileWriter("output.txt");
        // Read the exchange rate from the first line of the input file
        int[] insertArr = new int[5];
        // Inserted Arrary
        for (int i = 0; i < insertArr.length; i++) {
            insertArr[i] = input.nextInt();
        }
        // Insertion sort algorithm
        for (int i = 1; i < insertArr.length; i++) {
            int key = insertArr[i];
            int j = i - 1;
            // Move elements of insertArr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && insertArr[j] > key) {
                insertArr[j + 1] = insertArr[j];
                j = j - 1;
            }
            insertArr[j + 1] = key;
        }
        // Write the sorted array to the output file
        for (int i = 0; i < insertArr.length; i++) {
            writer.write(insertArr[i] + " ");
        }
        // Close the Scanner and FileWriter objects
        input.close();
        writer.close();
    }
}
