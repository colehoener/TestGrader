import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoice extends Question implements java.io.Serializable{
    private int numChoices;
    public ArrayList<String> choices = new ArrayList<String>();

    public MultipleChoice(String prompt){
        super(prompt);
        numChoices = 0;
    }

    public void display(){
        System.out.println(this.getPrompt());

        for(int i = 0; i < this.numChoices; i++){
            System.out.println(choices.get(i));
        }
    }

    public void promptChoices(Scanner myScan){
        this.numChoices = numChoices;
        Boolean correctInput = false;
        int tempNumChoices = 1;
        String choice;

        while(!correctInput) {
            try {
                System.out.print("\nEnter the number of choices for your multiple-choice question: ");
                tempNumChoices = Integer.parseInt(myScan.nextLine());
                correctInput = true;
            } catch (Exception e) {
                System.out.println("\nInvalid input. try again.");
            }
        }

        for(int i = 0; i < tempNumChoices; i++){
            System.out.print("Enter choice #" + (i + 1) + ": ");
            choice = myScan.nextLine();
            addChoice(choice);
        }
    }

    protected void addChoice(String choice){
        this.choices.add(choice);
        numChoices++;
    }

    public ArrayList getChoices(){
        return choices;
    }

    public void changeChoice(int choice, String newChoice){
        choices.set(choice, newChoice);
    }

    public String askAnswer(Scanner myScan){
        String answer = "";
        String input = "null";

        display();
        System.out.print("Leave answer blank after last choice.\nAnswer(s): ");
        while(!input.isBlank()){
            input = myScan.nextLine();
            answer = answer.concat(" " + input);
            System.out.print("\n");
        }

        return answer;
    }
}
