import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Cole Hoener
 * @version 1.0
 * @since 1.0
 */
public class SurveyCreator {
    private List<Object> questions = new ArrayList<Object>();
    private Scanner myObj = new Scanner(System.in);

    public SurveyCreator()
    {
    }

    public Survey createSurvey(){
        String input = "0";


        while(!input.equals("7")){
            input = promptQuestionType();

            if(input.equals("1")){
                TrueFalse tf = new TrueFalse(promptQuestion("True/False"));
                tf.addChoice("True");
                tf.addChoice("False");
                questions.add(tf);
            }
            else if(input.equals("2")){
                MultipleChoice mc = new MultipleChoice(promptQuestion("multiple choice"));
                mc.promptChoices(myObj);
                questions.add(mc);
            }
            else if(input.equals("3")){
                ShortAnswer sa = new ShortAnswer(promptQuestion("short answer"));
                questions.add(sa);
            }
            else if(input.equals("4")){
                Essay e = new Essay(promptQuestion("essay"));
                questions.add(e);
            }
            else if(input.equals("5")){
                Date d = new Date(promptQuestion("date"));
                questions.add(d);
            }
            else if(input.equals("6")){
                Matching m = new Matching((promptQuestion("matching")));
                m.promptChoices(myObj);
                questions.add(m);
            }
            else if(input.equals("7")){
               //Do nothing
            }
            else{
                System.out.println("\nInvalid selection. Try again.\n");
            }



        }
        Survey s = new Survey();
        s.setQuestions(questions);
        return s;
    }

    public String promptQuestion(String questionType){
        System.out.println("\nEnter the prompt for your " + questionType + " question:");
        return myObj.nextLine();  // Read user input
    }


    public String promptQuestionType(){
        System.out.print("\n1) Add a new T/F question\n" +
                "2) Add a new multiple-choice question\n" +
                "3) Add a new short answer question\n" +
                "4) Add a new essay question\n" +
                "5) Add a new date question\n" +
                "6) Add a new matching question\n" +
                "7) Return to previous menu\n" +
                "Selection: ");
        return myObj.nextLine();  // Read user input
    }

}
