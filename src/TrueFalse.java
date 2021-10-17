import java.io.IOException;
import java.util.Scanner;

public class TrueFalse extends MultipleChoice implements java.io.Serializable{

    public TrueFalse(String prompt){
        super(prompt);
    }

    public void display(){
        System.out.println(this.getPrompt());
        System.out.println("True\nFalse");
    }

    public String askAnswer(Scanner myScan){
        String answer = "";
        Boolean correctAnswer = false;
        display();
        System.out.print("Answer (\"True\" or \"False\"): ");

        while(!correctAnswer){
            try {
                answer = myScan.nextLine();
            }catch (NullPointerException e)
            {
               System.out.println("Invalid answer, try again");
            }
            if(answer.equals("True") || answer.equals("true")){
                correctAnswer = true;
            }
            else if(answer.equals("False") || answer.equals("false")){
                correctAnswer = true;
            }
            else{
                System.out.println("Invalid answer, try again");
            }
        }


        return answer;
    }

}
