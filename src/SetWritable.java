

import java.io.File;

public class SetWritable {
    public static void main(String[] args) {
        // Specify the file or directory you want to make writable
        File file = new File("D:/testfile.txt");
        
        // Set the file writable for the owner only or for everyone
        boolean result = file.setWritable(true, false); // false means writable for everyone

        if (result) {
            System.out.println("File is now writable.");
        } else {
            System.out.println("Failed to change the file permission.");
        }
    }
}
