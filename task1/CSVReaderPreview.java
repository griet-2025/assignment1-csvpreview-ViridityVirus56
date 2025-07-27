package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        // TO DO: Write your code below 
        String filePath = "dataset/dataset.csv";
        String line = "";
        System.out.println("=== Data Preview === \n\n");
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String idLine = br.readLine();
            String[] columnNames = idLine.split(",");
            System.out.println("Columns: ");
            for(String cName: columnNames) {
                System.out.print(cName + "  ");
            }
            System.out.println();
            int recordCount = 0;
            int limit = 5;
            int count = 0;
            System.out.println("Total Columns: " + columnNames.length);
            System.out.println("\n\nFirst " + limit + " records: \n\n");
            while(((line = br.readLine()) != null)) {
                String[] values = line.split(",");
                if(count < limit) {
                    for(String value: values) {
                        System.out.print(value + "  ");
                    }
                    System.out.println();
                }
                recordCount++;
                count++;
            }
            System.out.println("\n\nTotal Records (excluding header): " + recordCount);
            br.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
