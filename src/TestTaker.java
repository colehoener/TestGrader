import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTaker {
    public ResponseSaver  rs = new ResponseSaver();
    protected Scanner myScan = new Scanner(System.in);

    public TestTaker(){

    }

    void takeTest(Test s){
        List<Object> questions = new ArrayList<Object>();
        questions = s.getQuestions();
        String answer = "";

        for(int i = 0; i < questions.size(); i++){
            System.out.print(String.valueOf(i + 1) + ". ");


            ((Question) questions.get(i)).getPrompt();

            if(questions.get(i) instanceof Essay && !(questions.get(i) instanceof ShortAnswer)) {
                ((Question) questions.get(i)).askAnswer(myScan);
            }
            else{
                answer = answer.concat(((Question) questions.get(i)).askAnswer(myScan) + "\n");
            }

        }

        rs.saveAnswers(answer);

    }
}
