import java.io.*;

public class ResponseSaver {
    public ResponseSaver(){

    }

    public void saveResponse(String answers){
        File directory=new File("./Responses");
        int fileCount=directory.list().length;
        String fileName = "temp";

        fileName = "Response" + String.valueOf(fileCount + 1) + ".txt";


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./Responses/" + fileName));
            writer.write(answers);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAnswers(String answers){
        File directory=new File("./TestResponses");
        int fileCount=directory.list().length;
        String fileName = "temp";

        fileName = "Response" + String.valueOf(fileCount + 1) + ".txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./TestResponses/" + fileName));
            writer.write(answers);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
