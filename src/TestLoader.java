import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestLoader {
    private Scanner myObj = new Scanner(System.in);

    public TestLoader(){

    }

    public Test loadTest(){
        List<Object> questions = new ArrayList<Object>();
        Test s = new Test();
        File directory=new File("./Tests");
        Boolean loaded = false;
        //Code adapted from https://stackabuse.com/java-list-files-in-a-directory/
        String[] pathnames;
        // Populates the array with names of files and directories
        pathnames = directory.list();

        System.out.println("\nAvailable tests.\n");
        // For each pathname in the pathnames array
        for (String pathname : pathnames) {
            // Print the names of files and directories
            System.out.println(pathname);
        }


        while(loaded == false) {
            System.out.print("\nEnter the test you would like to load (full file name): ");
            String surveyToLoad = myObj.nextLine();

            if(surveyToLoad.equals("Quit")){
                break;
            }

            try {
                FileInputStream fileIn = new FileInputStream("./Tests/" + surveyToLoad);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                s = (Test) in.readObject();
                in.close();
                fileIn.close();
                loaded = true;
            } catch (IOException i) {
                System.out.println("Test file not found. Try again or type \"Quit\"");
            } catch (ClassNotFoundException c) {
                System.out.println("Test class not found. File corrupted.");
                c.printStackTrace();
            }
        }

        System.out.println("\nSuccessfully loaded test.");

        return s;
    }
}
