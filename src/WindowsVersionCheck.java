public class WindowsVersionCheck {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        
        System.out.println("OS Name: " + osName);
        System.out.println("OS Version: " + osVersion);

        // Check if the OS is Windows and parse version details
        if (osName.toLowerCase().contains("windows")) {
            if (osVersion.startsWith("10.0")) {
                // Get the build number from Windows registry (for more accuracy)
                String buildNumber = System.getenv("SYSTEMBUILD");
                if (buildNumber != null && Integer.parseInt(buildNumber) >= 22000) {
                    System.out.println("The operating system is Windows 11.");
                } else {
                    System.out.println("The operating system is Windows 10.");
                }
            } else {
                System.out.println("The operating system is Windows, but not 10 or 11.");
            }
        } else {
            System.out.println("The operating system is not Windows.");
        }
    }
}

