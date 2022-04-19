package benify;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


class Resultt {

    /*
     * Complete the 'generateFiles' function below.
     *
     * The function accepts STRING input_file_name as parameter.
     */

    public static void generateFiles(String input_file_name) {
        String line = "";
        List<String> products = new ArrayList<>();
        Map<String, Integer> prodTotalQuantity = new HashMap<>();
        Map<String, Integer> prodOrdersAmount = new HashMap<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\40119330\\Documents\\ajuda.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] product = line.split(",");
                String productName = product[2];
                Integer productQuantity = Integer.parseInt(product[3]);
                String productBrand = product[4];

                // concatenating the product name and brand to avoid duplicity of names
                products.add(productName + "__" + productBrand);

                // adding product to the hashmaps in case it doesn't exist
                if (!prodTotalQuantity.containsKey(productName)) {
                    prodTotalQuantity.put(productName, productQuantity);
                    prodOrdersAmount.put(productName, 1);
                }

                // updating product total quantity and order in which it appeared
                else {
                    prodTotalQuantity.put(productName, prodTotalQuantity.get(productName) + productQuantity);
                    prodOrdersAmount.put(productName, prodOrdersAmount.get(productName) + 1);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // creating the first csv file
        try (PrintWriter writer = new PrintWriter("0_" + input_file_name + ".csv")) {

            prodTotalQuantity.forEach((key, value) -> {
                writer.write(key + ", " + value/prodOrdersAmount.get(key) + "\n");
            });
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


        // creating the second csv file
        Map<String, Long> popularBrands = products.stream().collect(Collectors.groupingBy(
                                        Function.identity(), Collectors.counting()));

        try (PrintWriter writer = new PrintWriter("1_" + input_file_name + ".csv")) {

            popularBrands.forEach((key, value) -> {
                String productName = key.split("__")[0];
                String brandName = key.split("__")[1];
                writer.write(productName + ", " + brandName + "\n");
            });
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input_file_name = bufferedReader.readLine();

        Resultt.generateFiles(input_file_name);

        bufferedReader.close();
    }
}
