import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DatasetSummarizer{
    static int DATASETMAXSIZE = 5;
    public static void main(String[] args) {
        Scanner scan_obj = new Scanner(System.in);
        Float user_input;
        List<Float> dataset = new ArrayList<>();
        int err_iter = 0;

        System.out.println("Launching DatasetSummarizer...\n");
        do {
            System.out.print("Input data_point " + (dataset.size() + 1) + ":");
            try {
                user_input = Float.parseFloat(scan_obj.next());
                dataset.add(user_input);
            } catch (NumberFormatException e) {
                if (err_iter < 5) {
                    System.out.println(
                        "The attempted input wasn't convertible to Float\ntry again..."
                    );
                    err_iter ++;
                }
                else {System.out.print("Too many retries; Quitting..."); break;}
            }
        } while (dataset.size() < DATASETMAXSIZE);
        if (err_iter < 5) {
            scan_obj.close();
            System.out.println("All inputs gathered. Printing output...\n");
            Float total = (float) 0.0;
            for (Float item: dataset){total += item;}
            System.out.println("Total:                 " + total);
            System.out.println("Average:               " + (total / dataset.size()));
            Float max = dataset.get(0);
            for (Float item: dataset) {max = (item > max) ? item : max;}
            System.out.println("Maximum:               " + max);
            Float min = dataset.get(0);
            for (Float item: dataset) {min = (item < min) ? item : min;}
            System.out.println("Minimum:               " + min);
            System.out.println("20% interest on total: " + (total / 5));
        }
    }
}