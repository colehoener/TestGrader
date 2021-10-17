import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SurveySaver {
    public SurveySaver(){

    }

    public void saveSurvey(Survey s){

        File directory=new File("./Surveys");
        int fileCount=directory.list().length;
        String[] pathnames = directory.list();
        String fileName = "temp";
        Boolean foundFile = false;

        System.out.println(s.getName());
        for(int i = 0; i < pathnames.length; i++){
            System.out.println(pathnames[i]);
            if((s.getName()).equals(pathnames[i])){
                fileName = s.getName();
                foundFile = true;
            }
        }

        if(!foundFile){
            fileName = "Survey" + String.valueOf(fileCount + 1) + ".ser";
        }

        try {
            s.setName(fileName);
            FileOutputStream fileOut = new FileOutputStream("./Surveys/" + fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(s);
            out.close();
            fileOut.close();
            System.out.println("\nSurvey saved successfully as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
