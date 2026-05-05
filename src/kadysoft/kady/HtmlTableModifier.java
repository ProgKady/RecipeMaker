package kadysoft.kady;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlTableModifier {
    public static void main(String[] args) {
        try {
            // 1. Load HTML file
            File input = new File("C:\\Users\\Ahmed.ElKady\\Desktop\\test\\501.ks"); // change to your file path
            
            
            Document doc = Jsoup.parse(input, "UTF-8");
            // 2. Select all tables
            Elements tables = doc.select("table");
            for (Element table : tables) {
                
                
                // Apply dotted border style to the table
                table.attr("style", "border-collapse: collapse; border: 1px dotted black;");
                // Select all rows
                Elements rows = table.select("tr");
                for (Element row : rows) {
                    Elements cells = row.select("td, th");
                    for (Element cell : cells) {
                        // Apply dotted border style to each cell
                        String existingStyle = cell.attr("style");
                        cell.attr("style", existingStyle + "border:1px dotted black; padding:4px;");
                        // Check text for highlighting
                        String text = cell.text().trim().toLowerCase();
                        if (text.equals("chemical") || text.contains("lot")) {
                            cell.attr("style", cell.attr("style") + " background-color:yellow;");
                        }
                    }
                    if (!cells.isEmpty()) {
                        // Get last cell (before the one we add)
                        Element lastCell = cells.last();
                        String text = lastCell.text().trim();
                        // Create new cell
                        Element newCell = row.appendElement("td");
                        // Apply dotted border style
                        newCell.attr("style", "border:1px dotted black; padding:4px;");
                        // Fill new cell based on last cell
                        if (text.isEmpty()) {
                            newCell.text(""); // leave empty
                        } else if (text.equalsIgnoreCase("ahmed")) {
                            newCell.text("elkady");
                        } else {
                            newCell.text("Processed: " + text);
                        }
                        // Highlight if matches condition
                        String newText = newCell.text().toLowerCase();
                        if (newText.equals("chemical") || newText.contains("lot")) {
                            newCell.attr("style", newCell.attr("style") + " background-color:yellow;");
                        }
                    }
                }
                
                
                
            }

            // 3. Save modified HTML
            try (FileWriter writer = new FileWriter("C:\\Users\\Ahmed.ElKady\\Desktop\\test\\output.ks")) {
                writer.write(doc.outerHtml());
            }

            System.out.println("✅ Done! Modified HTML saved to output.html");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
