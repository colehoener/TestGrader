import java.util.Scanner;

public class ShortAnswer extends Essay implements java.io.Serializable{
    private transient Scanner myObj = new Scanner(System.in);

    public ShortAnswer(String prompt){
        super(prompt);
    }

    public String askAnswer(){
        String answer = "";
        String input = "null";
        int blankCount = 0;
        display();
        System.out.print("Press enter twice to end short answer.\nAnswer: ");
        while(!(blankCount >= 2)){

            input = myObj.nextLine();
            if(input.isBlank()){
                blankCount++;
            }
            else{
                answer = answer.concat(" " + input);
                blankCount = 0;
            }
        }

        return answer;
    }
}
