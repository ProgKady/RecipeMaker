
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 *
 * @author ahmed.elkady
 */
public class IIIIIIIIIIIIIII {

    public static String windowsversion,MachineID;
   
    public static void main(String[] args) throws IOException {
       
        
        
          //////////////////////////////////////////////////
          
          String batchcode="@echo off\n" +
"for /f \"tokens=3\" %%a in ('reg query \"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\" /v CurrentBuild') do (\n" +
"    if %%a geq 22000 (\n" +
"        echo Windows 11\n" +
"    ) else (\n" +
"        echo Windows 10\n" +
"    )\n" +
")\n" +
"";
          String pathofbat=System.getProperty("user.home")+"\\kadinio.bat";
          File fafa=new File (pathofbat);
          //fafa.deleteOnExit();
          PrintWriter paq=new PrintWriter (new FileWriter (fafa));
          paq.println(batchcode);
          paq.close();
          
            try {
            ProcessBuilder processBuilder = new ProcessBuilder(pathofbat);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            windowsversion=line;
            
            
            
            }
            int exitCode = process.waitFor();
            //System.out.println("Batch file executed with exit code: " + exitCode);
            } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            }
 
            if (windowsversion.equals("Windows 10")) {
                
                //Windows10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   
                System.out.println(MachineID);
                
            }
            
            else if (windowsversion.equals("Windows 11")) {
                
                //Windows11
                
              String command="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
                
                System.out.println(MachineID);
            }
            
            else {
                
                //Windows7 or less like windows 10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                
                 System.out.println(MachineID);
            }
            
             
        
        
        
        
    }
    
}
