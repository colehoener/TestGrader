import java.util.List;

public class Test extends Survey implements java.io.Serializable {
    public String fileName;
    public List<String> answers;

    public Test () {
        super();
    }

    public List<String> getAnswers(){
        return this.answers;
    }

    public void setAnswers(List<String> newAnswers){
        this.answers = newAnswers;
    }
}
