import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyTaker {
    public ResponseSaver  rs = new ResponseSaver();
    protected Scanner myScan = new Scanner(System.in);

    public SurveyTaker(){

    }

    void takeSurvey(Survey s){
        List<Object> questions = new ArrayList<Object>();
        questions = s.getQuestions();
        String answer = "";

        for(int i = 0; i < questions.size(); i++){
            System.out.print(String.valueOf(i + 1) + ". ");

            ((Question) questions.get(i)).getPrompt();

            answer = answer.concat(((Question) questions.get(i)).askAnswer(myScan) + "\n");

        }

        rs.saveResponse(answer);

    }
}
