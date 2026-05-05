import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetSerialNumber {
    public static void main(String[] args) {
        try {
          
            
            
                
              String command="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
            
                System.out.println(MachineID);
            

            // Wait for the process to complete
            //process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
