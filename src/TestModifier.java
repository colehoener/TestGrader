import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestModifier {
    private Scanner myObj = new Scanner(System.in);

    public TestModifier(){

    }

    public void modifyTest(Test s){
        List<Object> questions = new ArrayList<Object>();
        List<String> answers = new ArrayList<>();
        questions = s.getQuestions();
        answers = s.getAnswers();
        int qToModify = 10000;

        while(qToModify > questions.size() && qToModify > 0 ) {
            System.out.print("\nWhat question do you want to modify? (Enter number): ");

            try {
                qToModify = Integer.valueOf(myObj.nextLine());
            } catch(NumberFormatException e){

            }

            if(qToModify > questions.size()){
                System.out.println("Question does not exist, try again.");
            }
        }

        if (questions.get(qToModify - 1) instanceof MultipleChoice && !(questions.get(qToModify - 1) instanceof TrueFalse)) {
            System.out.print("\nDo you wish to modify the prompt(Yes or No)?: ");
            String selection = myObj.nextLine();

            if (selection.equals("Yes") || selection.equals("yes")) {
                System.out.print("\nEnter in the new prompt: ");
                String newPrompt = myObj.nextLine();
                ((Question) questions.get(qToModify - 1)).setPrompt(newPrompt);
            }

            System.out.print("\nDo you wish to modify the choices(Yes or No)?: ");
            selection = myObj.nextLine();

            if (selection.equals("Yes") || selection.equals("yes")) {
                ArrayList choices = ((MultipleChoice) questions.get(qToModify - 1)).getChoices();
                System.out.println("\nWhich choice do you wish to modify?");
                for (int i = 0; i < choices.size(); i++) {
                    System.out.print(String.valueOf(i + 1) + ". " + choices.get(i) + "    ");
                }
                qToModify = 10000;

                while (qToModify >= choices.size() && qToModify > 0) {
                    qToModify = Integer.valueOf(myObj.nextLine());
                    if (qToModify - 1 > questions.size()) {
                        System.out.println("Question does not exist, try again.");
                    }
                }
                System.out.print("\nEnter the new choice: ");
                String newChoice = myObj.nextLine();
                ((MultipleChoice) questions.get(qToModify - 1)).changeChoice(qToModify - 1, newChoice);
            }

            System.out.print("\nDo you wish to modify the answer(Yes or No)?: ");
            selection = myObj.nextLine();

            if (selection.equals("Yes") || selection.equals("yes")) {
                System.out.print("\nEnter the new answer: ");
                String newChoice = myObj.nextLine();
                answers.set(qToModify - 1, newChoice);
            }
        } else {
            System.out.print("\nDo you wish to modify the prompt(Yes or No)?: ");
            String selection = myObj.nextLine();
            if (selection.equals("Yes") || selection.equals("yes")) {
                System.out.print("\nEnter in the new prompt: ");
                String newPrompt = myObj.nextLine();
                ((Question) questions.get(qToModify - 1)).setPrompt(newPrompt);
            }

            System.out.print("\nDo you wish to modify the answer(Yes or No)?: ");
            selection = myObj.nextLine();

            if (selection.equals("Yes") || selection.equals("yes")) {
                System.out.print("\nEnter the new answer: ");
                String newChoice = myObj.nextLine();
                answers.set(qToModify - 1, newChoice);
            }
        }

        s.setAnswers(answers);
    }
}
