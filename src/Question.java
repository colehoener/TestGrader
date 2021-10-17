import java.util.Scanner;

public class Question implements java.io.Serializable {
    public String prompt;

    public Question(String prompt){
        this.prompt = prompt;
    }

    public void setPrompt(String newPrompt){
        this.prompt = newPrompt;
    }

    public String getPrompt(){
        return prompt;
    }

    public void display() {
        System.out.println(this.getPrompt());
    }

    public String askAnswer(Scanner myScan){
        String answer;

        display();
        System.out.print("Answer: ");
        answer = myScan.nextLine();

        return answer;
    }
}
