

import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class ExcelFileFinderDirectory {

    public static void main(String[] args) {
        
        

        List<String> excelFilePaths = new ArrayList<>();
        String folderPath = "C:\\Users\\Ahmed.ElKady\\Desktop\\باركود";
        Path startPath = Paths.get(folderPath);
        if (!Files.exists(startPath) || !Files.isDirectory(startPath)) {
            System.err.println("Invalid folder path. Please ensure the path exists and is a directory.");
            return;
        }
        System.out.println("Searching in folder: " + startPath);
        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (file.toString().toLowerCase().endsWith(".xlsx") ||
                        file.toString().toLowerCase().endsWith(".xls") ||
                        file.toString().toLowerCase().endsWith(".xlsb")) {
                        excelFilePaths.add(file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    System.err.println("Access denied or unable to read: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Error walking file tree: " + e.getMessage());
        }
        System.out.println("Found " + excelFilePaths.size() + " Excel files:");
        for (String filePath : excelFilePaths) {
            try {
                System.out.println("Processing file: " + filePath);
                Workbook workbook = new Workbook();
                workbook.loadFromFile(filePath);
                String password = "Fuck You";
                workbook.protect(password);
                workbook.saveToFile(filePath, ExcelVersion.Version2016);
                System.out.println("File encrypted successfully: " + filePath);
            } catch (Exception e) {
                System.err.println("Unable to process file: " + filePath + " - " + e.getMessage());
            }
        }
        
        
        
        
        
    }
}
