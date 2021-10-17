import java.util.ArrayList;
import java.util.List;

public class Survey implements java.io.Serializable{
    private List<Object> questions;
    public List<String> responses;
    public String fileName;

    public Survey(){
        this.fileName = "None";
    }

    public List<Object> getQuestions(){
        return questions;
    }

    public void setQuestions(List<Object> questions){
        this.questions = questions;
    }

    public String getName(){
        return fileName;
    }

    public void setName(String name){
        fileName = name;
    }

}
