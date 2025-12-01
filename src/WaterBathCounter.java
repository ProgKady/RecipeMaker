

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;

public class WaterBathCounter {
    public static void main(String[] args) {
        try {
            // Reading the input file
            File inputFile = new File(System.getProperty("user.home") + "\\r.ks"); // Your file path
            org.jsoup.nodes.Document doc = Jsoup.parse(inputFile, "UTF-8");

            // Lists to track the number of water baths for each shot (before EXTRACT)
            List<Integer> waterBathCountsPerShot = new ArrayList<>();
            List<String> shots = new ArrayList<>();
            int overallWaterBathCount = 0;
            int currentWaterBathCount = 0; // Track occurrences of valid water baths

            // Iterate through tables and rows in the document
            for (Element table : doc.select("table")) {
                for (Element row : table.select("tr")) {
                    Elements tds = row.select("td");

                    // Skip rows that don't have enough data
                    if (tds.size() < 5) continue;

                    // Skip rows with invalid data in the 5th column
                    String waterbathText = tds.get(4).text();
                    if (waterbathText.contains("'") || waterbathText.contains("DRYER") || 
                        waterbathText.contains("LITER") || waterbathText.matches("[a-zA-Z_]+")) {
                        continue; // Skip invalid rows
                    }

                    // If EXTRACT is found in the 4th column, it marks the start of a new bath
                    String tempo = tds.get(3).text();
                    if (tempo.contains("EXTRACT") || tempo.contains("extract")) {
                        if (currentWaterBathCount > 0) {
                            waterBathCountsPerShot.add(currentWaterBathCount); // Store the count for the previous bath
                            overallWaterBathCount += currentWaterBathCount; // Add to the overall count
                        }
                        shots.add(tempo); // Save shot information (EXTRACT)
                        currentWaterBathCount = 0; // Reset for the next batch
                    }

                    // If the row contains a valid value in the 5th column, count it as a valid bath occurrence
                    if (waterbathText.matches("[0-9]+")) {
                        currentWaterBathCount++; // Increment for each valid bath found
                    }
                }
            }

            // Handle the last shot (if there's any remaining count)
            if (currentWaterBathCount > 0) {
                waterBathCountsPerShot.add(currentWaterBathCount);
                overallWaterBathCount += currentWaterBathCount;
            }

            // Output results
//            System.out.println("Total shots (bathnum): " + shots.size());
//            for (int i = 0; i < waterBathCountsPerShot.size(); i++) {
//                System.out.println("Shot " + (i + 1) + " - Water Bath Occurrences: " + waterBathCountsPerShot.get(i));
//            }
//            
            
            int waterbath1 = 0, waterbath2 = 0, waterbath3 = 0, waterbath4 = 0; 

// Iterate through tempCountsPerShot to assign values to temp, temp2, temp3, temp4
for (int i = 0; i < waterBathCountsPerShot.size(); i++) {
    // Get the count for the current shot
    int tempCount = waterBathCountsPerShot.get(i);
    
    // Assign values to temp, temp2, temp3, temp4 based on the index
    if (i == 0) {
        waterbath1 = tempCount; // First shot count goes to temp
    } else if (i == 1) {
        waterbath2 = tempCount; // Second shot count goes to temp2
    } else if (i == 2) {
        waterbath3 = tempCount; // Third shot count goes to temp3
    } else {
        waterbath4 = tempCount; // Any further shots, assign to temp4
    }
}

// Print the values of temp, temp2, temp3, temp4 after the loop finishes
System.out.println("temp: " + waterbath1);
System.out.println("temp2: " + waterbath2);
System.out.println("temp3: " + waterbath3);
System.out.println("temp4: " + waterbath4);
            
            
            //System.out.println("Overall water bath occurrences: " + overallWaterBathCount);

        } catch (FileNotFoundException e) {
            //System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            //System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            //System.out.println("Invalid water bath value: " + e.getMessage());
        }
    }
}
