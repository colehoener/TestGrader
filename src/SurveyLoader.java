import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyLoader {
    private Scanner myObj = new Scanner(System.in);

    public SurveyLoader(){

    }

    public Survey loadSurvey(){
        List<Object> questions = new ArrayList<Object>();
        Survey s = new Survey();
        File directory=new File("./Surveys");
        Boolean loaded = false;
        //Code adapted from https://stackabuse.com/java-list-files-in-a-directory/
        String[] pathnames;
        // Populates the array with names of files and directories
        pathnames = directory.list();

        System.out.println("\nAvailable surveys.\n");
        // For each pathname in the pathnames array
        for (String pathname : pathnames) {
            // Print the names of files and directories
            System.out.println(pathname);
        }


        while(loaded == false) {
            System.out.print("\nEnter the survey you would like to load (full file name): ");
            String surveyToLoad = myObj.nextLine();

            if(surveyToLoad.equals("Quit")){
                break;
            }

            try {
                FileInputStream fileIn = new FileInputStream("./Surveys/" + surveyToLoad);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                s = (Survey) in.readObject();
                in.close();
                fileIn.close();
                loaded = true;
            } catch (IOException i) {
                System.out.println("Survey file not found. Try again or type \"Quit\"");
            } catch (ClassNotFoundException c) {
                System.out.println("Survey class not found. File corrupted.");
                c.printStackTrace();
            }
        }

        System.out.println("\nSuccessfully loaded survey.");

        return s;
    }


}
