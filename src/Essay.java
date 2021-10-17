import java.util.Scanner;

public class Essay extends Question {
    public Essay(String prompt){
        super(prompt);
    }

    public String askAnswer(Scanner myObj){
        String answer = "";
        String input = "null";

        display();
        System.out.print("Press enter twice to end essay.\nAnswer: ");
        while(!input.isBlank()){

            input = myObj.nextLine();
            answer = answer.concat(" " + input);
        }

        return answer;
    }

}
