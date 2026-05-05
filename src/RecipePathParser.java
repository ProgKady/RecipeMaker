import java.nio.file.Path;
import java.nio.file.Paths;

public class RecipePathParser {
   

    public static void main(String[] args) {
        
        Path path = Paths.get("X:\\Recipe_System\\Recipes\\BLANKET\\Lefis\\ahmed.ks");
        String productionType = path.getName(2).toString().toUpperCase(); // PRODUCTION
        String customer = path.getName(3).toString().toUpperCase();       // LCW
        
        System.out.println(productionType);
        System.out.println(customer);
        
      
    }
}
