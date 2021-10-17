import java.util.Scanner;

public class Date extends Question{
    public Date(String prompt){
        super(prompt);
    }

    public void display(){
        System.out.println(this.getPrompt());
    }

    public String askAnswer(Scanner myScan){
        String answer = "";
        display();
        System.out.print("Answer (MM-DD-YYY): ");

        try {
            answer = myScan.nextLine();
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        return answer;
    }
}
