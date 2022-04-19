package arrays;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class fdfgdg {
    public static void main(String[] args) throws IOException {
        //System.out.println("Ola");
                        /* List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);
                        *\
                        *
                        */

        String fileName = "";
        BufferedReader reader;
        int count = 0 ;
        int amount = 0;


        Map<String, Integer> prod = new HashMap<>();
        Map<String, Integer> prodAmount = new HashMap<>();
        List<String> items = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\40119330\\Documents\\ajuda.txt"));
            String line = "";
            while ((line= reader.readLine()) != null) {
                System.out.println(line);
                count++;

                String record[] = line.split(",");

                //System.out.println("PRD :: " + record[2]);

                items.add(record[2] + "-" + record[4]);

                if (!prod.containsKey(record[2])) {
                    //System.out.println(" NEW :: " + record[2]);
                    prod.put(record[2], Integer.parseInt(record[3]));
                    prodAmount.put(record[2], 1);

                } else {
                    //System.out.print("UPDATE :: " + record[2]);
                    //System.out.print(" NEW :: " + record[3]);

                    prod.put(record[2], Integer.parseInt(record[3]) + prod.get(record[2]));
                    prodAmount.put(record[2], 1 + prodAmount.get(record[2]) );
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("----------------------" );

            prod.forEach((key, value) -> {
                System.out.println(key + ", " + value/prodAmount.get(key));
                System.out.println(key + value);

            });

        System.out.println("----------------------" );


        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );




        result.forEach((key, value) -> {


            System.out.println(key + "=" + value  );
            System.out.println((key.split("-"))[0]);
            System.out.println((key.split("-"))[1]);
        });
    }
}
