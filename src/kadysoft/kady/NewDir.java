package kadysoft.kady;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NewDir {
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////   
        public static String getValueByKey(String filePath, String key) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("=")) {
                    continue;
                }
                String[] parts = line.split("=", 2);
                String currentKey = parts[0].trim();
                if (currentKey.equals(key)) {
                    return parts[1].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   public static String file_dir = getValueByKey("lib\\setto.cfg", "Recipes");
   public static String file_dirr = getValueByKey("lib\\setto.cfg", "Mod_Recipes");
   public static String file_dirrr = getValueByKey("lib\\setto.cfg", "Models");
   public static String file_dirrrr = getValueByKey("lib\\setto.cfg", "Recipe_System");
   public static String file_di = getValueByKey("lib\\setto.cfg", "New_Recipes");
    
//   public static String file_dir = "X:\\Recipe_System\\Recipes";
//   public static String file_dirr = "X:\\Models\\Recipes";
//   public static String file_dirrr = "X:\\Models";
//   public static String file_dirrrr = "X:\\Recipe_System";
//   public static String file_di = "X:\\Don't_Touch";
   
   
   
   
   
   public static String file_dirrrrr = getValueByKey("lib\\setto.cfg", "Signs");  //Still Z, don't change
   
   //public static String file_dirrrrr = "Z:\\Models";  //Still Z, don't change
   
   
   //Just Info To Remember
   public static String kady_pc="X";
   public static String production="Z";
   public static String development="X";
   public static String mr_kamal="W";
   public static String mr_mohamed="V";
   public static String amrorecipepc="Y";
   
}
