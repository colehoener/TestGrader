import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestGrader {
    private Scanner myObj = new Scanner(System.in);

    public TestGrader(){

    }

    public void gradeTest(Test t){
        List<String> responses = new ArrayList<>();
        File directory=new File("./TestResponses");
        Boolean loaded = false;
        String filename;
        //Code adapted from https://stackabuse.com/java-list-files-in-a-directory/
        String[] pathnames;
        // Populates the array with names of files and directories
        pathnames = directory.list();
        String regex = "\\s++$";

        System.out.println("\nAvailable responses.\n");
        // For each pathname in the pathnames array
        for (String pathname : pathnames) {
            // Print the names of files and directories
            System.out.println(pathname);
        }


        while(loaded == false) {
            System.out.print("\nEnter the test response you would like to load (full file name): ");
            String surveyToLoad = myObj.nextLine();

            if(surveyToLoad.equals("Quit")){
                break;
            }
            filename = directory + "/" + surveyToLoad;

            //Code adapted from https://www.baeldung.com/java-file-to-arraylist
            try (FileReader f = new FileReader(filename)) {
                StringBuffer sb = new StringBuffer();
                while (f.ready()) {
                    char c = (char) f.read();
                    if (c == '\n') {
                        String correct = sb.toString().trim();
                        responses.add(correct);
                        sb = new StringBuffer();
                    } else {
                        sb.append(c);
                    }
                }
                if (sb.length() > 0) {
                    String correct = sb.toString().trim();

                    responses.add(correct);
                }

                loaded = true;
            } catch (FileNotFoundException e) {
                System.out.println("Test file not found. Try again or type \"Quit\"");
            } catch (IOException e) {
                System.out.println("Critical error. Try again or type \"Quit\"");
            }
        }

        int totalTrueQuestion = (t.getQuestions()).size();
        int totalQuestions = responses.size();
        double totalEssay = (double)totalTrueQuestion - (double)totalQuestions;
        double totalPointsNoEssay = ((double) totalTrueQuestion - (totalEssay)) / totalTrueQuestion * 100.0;
        int totalRight = 0;
        List<String> answers = new ArrayList<>();
        answers = t.getAnswers();
        for(int i = 0; i < responses.size(); i++) {
            if (responses.get(i).equals(answers.get(i))) {
                totalRight++;
            }
        }
        double percent = (double)totalRight / (double)totalQuestions * 100.0;
        System.out.format("You received an %.2f on the test. The test was worth 100 points, but only %.2f of those points could be auto graded because there was %.0f essay question(s).\n", percent, totalPointsNoEssay, totalEssay);

    }
}
