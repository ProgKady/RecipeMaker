import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import java.io.*;
import java.util.*;
import org.jsoup.select.Elements;

public class TemperatureCalculator {
    public static void main(String[] args) {
        try {
            // Reading timer temperature from file
//            int temp=0;
//            int temp2=0;
//            int temp3=0;
//            int temp4=0;
int temp = 0, temp2 = 0, temp3 = 0, temp4 = 0; 

            BufferedReader buf = new BufferedReader(new FileReader(System.getProperty("user.home") + "\\Timer_Temp.kady"));
            String timer_temprature = buf.readLine();
            buf.close();
            int timer_temp = Integer.parseInt(timer_temprature);

            // Parsing the input file
            File inputFile = new File(System.getProperty("user.home") + "\\r.ks");
            org.jsoup.nodes.Document doc = Jsoup.parse(inputFile, "UTF-8");

            List<Integer> tempCountsPerShot = new ArrayList<>();
            List<String> shots = new ArrayList<>();
            int overallTempCount = 0;

            // Process rows to calculate temperatures for each shot
            int currentShotTempCount = 0;
            for (Element table : doc.select("table")) {
                for (Element row : table.select("tr")) {
                    Elements tds = row.select("td");

                    // Skip invalid rows
                    if (tds.get(3).text().isEmpty() || 
                        tds.get(3).text().contains("/") || 
                        tds.get(3).text().contains("\\") || 
                        tds.get(3).text().contains("TEMP") || 
                        tds.get(3).text().contains("temp") || 
                        tds.get(3).text().contains("OPERATOR") || 
                        tds.get(3).text().contains("operator")) {
                        continue;
                    }

                    String tempo = tds.get(3).text().replaceAll("[a-zA-Z_ _&_.]+", "");
                    if (tempo.matches("\\d+")) {
                        int temperature = Integer.parseInt(tempo);

                        if (temperature > timer_temp) {
                            currentShotTempCount++;
                            overallTempCount++;
                        }
                    }

                    // Identify the start of a new shot
                    if (tds.get(3).text().contains("EXTRACT") || tds.get(3).text().contains("extract")) {
                        shots.add(tds.get(3).text()); // Save shot information
                        tempCountsPerShot.add(currentShotTempCount); // Save count for the previous shot
                        currentShotTempCount = 0; // Reset for the next shot
                    }
                }
            }

            // Handle the last shot
            if (currentShotTempCount > 0) {
                tempCountsPerShot.add(currentShotTempCount);
            }

            // Output results
         //   System.out.println("Total shots (bathnum): " + shots.size());
            
         // Initialize the temp variables before the loop

// Iterate through tempCountsPerShot to assign values to temp, temp2, temp3, temp4
for (int i = 0; i < tempCountsPerShot.size(); i++) {
    // Get the count for the current shot
    int tempCount = tempCountsPerShot.get(i);
    
    // Assign values to temp, temp2, temp3, temp4 based on the index
    if (i == 0) {
        temp = tempCount; // First shot count goes to temp
    } else if (i == 1) {
        temp2 = tempCount; // Second shot count goes to temp2
    } else if (i == 2) {
        temp3 = tempCount; // Third shot count goes to temp3
    } else {
        temp4 = tempCount; // Any further shots, assign to temp4
    }
}

// Print the values of temp, temp2, temp3, temp4 after the loop finishes
System.out.println("temp: " + temp);
System.out.println("temp2: " + temp2);
System.out.println("temp3: " + temp3);
System.out.println("temp4: " + temp4);

            
            

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid temperature value: " + e.getMessage());
        }
    }
}
