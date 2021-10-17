import java.util.ArrayList;
import java.util.List;

public class SurveyDisplayer {
    public SurveyDisplayer(){

    }

    public void displaySurvey(Survey s){
        List<Object> questions = new ArrayList<Object>();
        questions = s.getQuestions();

        for(int i = 0; i < questions.size(); i++){
            System.out.print("\n" + String.valueOf(i + 1) + ". ");

            if(questions.get(i) instanceof TrueFalse){
                ((TrueFalse) questions.get(i)).display();
            }
            else if(questions.get(i) instanceof MultipleChoice){
                ((MultipleChoice) questions.get(i)).display();
            }
            else if(questions.get(i) instanceof Date){
                ((Date) questions.get(i)).display();
            }
            else if(questions.get(i) instanceof Essay){
                ((Essay) questions.get(i)).display();
            }
            else if(questions.get(i) instanceof ShortAnswer){
                ((ShortAnswer) questions.get(i)).display();
            }
            else if(questions.get(i) instanceof Matching){
                ((Matching) questions.get(i)).display();
            }
        }
    }
}
