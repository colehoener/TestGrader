import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Cole Hoener
 * @version 1.0
 * @since 1.0
 */
public class SurveySystem
{
    public static void main(String[] args) {
        Survey s = new Survey();
        String input = "0";
        Scanner myObj = new Scanner(System.in);
        SurveyCreator surveyCreate = new SurveyCreator();
        SurveyDisplayer sd = new SurveyDisplayer();
        SurveySaver ss = new SurveySaver();
        SurveyTaker st = new SurveyTaker();
        SurveyModifier sm = new SurveyModifier();

        System.out.println("\n  ~Welcome to the survey system~");
        while(!input.equals("3")){
            System.out.println("\nEnter the number of your menu selection.");
            System.out.println("1) Survey\n" +
                    "2) Test\n" +
                    "3) Quit\n");
            System.out.print("Selection: ");
            input = myObj.nextLine();  // Read user input

            if(input.equals("1")){
                surveyMenu();
            }
            else if(input.equals("2")){
                testMenu();
            }
            else if(input.equals("3")) {
                System.out.println("\n  ~Goodbye~");
            }
            else{
                System.out.println("\nInvalid selection. Try again.\n");
            }
        }


    }

    public static void surveyMenu() {
        Survey s = new Survey();
        String input = "0";
        Scanner myObj = new Scanner(System.in);
        SurveyCreator surveyCreate = new SurveyCreator();
        SurveyDisplayer sd = new SurveyDisplayer();
        SurveySaver ss = new SurveySaver();
        SurveyTaker st = new SurveyTaker();
        SurveyModifier sm = new SurveyModifier();
        Tabulate tb = new Tabulate();

        while (!input.equals("8")) {
            System.out.println("\nEnter the number of your menu selection.");
            System.out.println("1) Create a new Survey\n" +
                    "2) Display an existing Survey\n" +
                    "3) Load an existing Survey\n" +
                    "4) Save the current Survey\n" +
                    "5) Take the current Survey\n" +
                    "6) Modifying the current Survey\n" +
                    "7) Tabulate a survey\n" +
                    "8) Return to the previous menu\n" +
                    "Survey currently loaded = " + s.getName());
            System.out.print("Selection: ");
            input = myObj.nextLine();  // Read user input

            if (input.equals("1")) {
                s = surveyCreate.createSurvey();
                s.setName("Unsaved New Survey");
            } else if (input.equals("2")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a survey loaded in order to display it.");
                } else {
                    sd.displaySurvey(s);
                }
            } else if (input.equals("3")) {
                SurveyLoader sl = new SurveyLoader();
                s = sl.loadSurvey();
            } else if (input.equals("4")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a survey loaded in order to save it.");
                } else {
                    ss.saveSurvey(s);
                }
            } else if (input.equals("5")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a survey loaded in order to take it.");
                } else {
                    st.takeSurvey(s);
                }
            } else if (input.equals("6")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a survey loaded in order to modify it.");
                } else {
                    sm.modifySurvey(s);
                }
            } else if(input.equals("7")){
                if (s.getName().equals("None")) {
                    System.out.println("You must have a survey loaded in order to modify it.");
                } else {
                    tb.TabulateSurvey(s);
                }
            } else if (input.equals("8")) {
                System.out.println("\n");
            } else {
                System.out.println("\nInvalid selection. Try again.\n");
            }
        }
    }

    public static void testMenu(){
        Test s = new Test();
        String input = "0";
        Scanner myObj = new Scanner(System.in);
        TestCreator testCreate = new TestCreator();
        TestDisplayer td = new TestDisplayer();
        SurveyDisplayer sd = new SurveyDisplayer();
        TestSaver ss = new TestSaver();
        TestTaker st = new TestTaker();
        TestModifier sm = new TestModifier();
        TestGrader tg = new TestGrader();
        Tabulate tb = new Tabulate();
        while (!input.equals("10")) {
            System.out.println("\nEnter the number of your menu selection.");
            System.out.println("1) Create a new Test\n" +
                    "2) Display an existing Test without correct answers\n" +
                    "3) Display an existing Test with correct answers\n" +
                    "4) Load an existing Test\n" +
                    "5) Save the current Test\n" +
                    "6) Take the current Test\n" +
                    "7) Modifying the current Test\n" +
                    "8) Tabulate a Test\n" +
                    "9) Grade a Test\n" +
                    "10) Return to the previous menu\n" +
                    "Survey currently loaded = " + s.getName());
            System.out.print("Selection: ");
            input = myObj.nextLine();  // Read user input

            if (input.equals("1")) {
                s = testCreate.createTest();
                s.setName("Unsaved New Test");
            } else if (input.equals("2")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a test loaded in order to display it.");
                } else {
                    sd.displaySurvey(s);
                }

            } else if (input.equals("3")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a test loaded in order to display it.");
                } else {
                    td.displayTest(s);
                }
            }else if (input.equals("4")) {
                TestLoader sl = new TestLoader();
                s = sl.loadTest();
            } else if (input.equals("5")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a test loaded in order to save it.");
                } else {
                    ss.saveTest(s);
                }
            } else if (input.equals("6")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a test loaded in order to take it.");
                } else {
                    st.takeTest(s);
                }
            } else if (input.equals("7")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a test loaded in order to modify it.");
                } else {
                    sm.modifyTest(s);
                }
            } else if (input.equals("8")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a survey loaded in order to modify it.");
                } else {
                    tb.TabulateTest(s);
                }
            } else if (input.equals("9")) {
                if (s.getName().equals("None")) {
                    System.out.println("You must have a survey loaded in order to modify it.");
                } else {
                    tg.gradeTest(s);
                }
            } else if (input.equals("10")) {
                System.out.println("\n");
            } else {
                System.out.println("\nInvalid selection. Try again.\n");
            }
        }
    }
}