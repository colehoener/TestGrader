import java.util.ArrayList;
import java.util.Scanner;

public class Matching extends Question implements java.io.Serializable{
    private int numChoices;
    public ArrayList<String> leftChoices = new ArrayList<String>();
    public ArrayList<String> rightChoices = new ArrayList<String>();

    public Matching(String prompt){
        super(prompt);
    }

    public void display(){
        System.out.println(this.getPrompt());

        for(int i = 0; i < this.numChoices; i++){
            System.out.print(leftChoices.get(i) + "    ");
            System.out.println(rightChoices.get(i));
        }
    }

    public void promptChoices(Scanner myScan){
        this.numChoices = numChoices;
        Boolean correctInput = false;
        int tempNumChoices = 1;
        String choice;

        while(!correctInput) {
            try {
                System.out.print("\nEnter the number of matches for your matching question: ");
                tempNumChoices = Integer.parseInt(myScan.nextLine());
                this.numChoices = tempNumChoices;
                correctInput = true;
            } catch (Exception e) {
                System.out.println("\nInvalid input. try again.");
            }
        }

        for(int i = 0; i < tempNumChoices; i++){
            System.out.print("Enter left side match #" + (i + 1) + ": ");
            choice = myScan.nextLine();
            addLeftChoice(choice);
        }

        for(int i = 0; i < tempNumChoices; i++){
            System.out.print("Enter right side match #" + (i + 1) + ": ");
            choice = myScan.nextLine();
            addRightChoice(choice);
        }
    }

    protected void addLeftChoice(String choice){
        this.leftChoices.add(choice);
    }

    protected void addRightChoice(String choice){
        this.rightChoices.add(choice);
    }

    public String askAnswer(Scanner myScan){
        String answer = "";
        String input = "null";

        display();
        System.out.print("Leave answer blank after last choice. Format such that it is \'LeftAnswer\'\'RightAnswer\'\nAnswer(s): ");
        while(!input.isBlank()){
            input = myScan.nextLine();
            answer = answer.concat(" " + input);
            System.out.print("\n");
        }

        return answer;
    }
}
