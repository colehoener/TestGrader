import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestSaver {
    public TestSaver(){

    }

    public void saveTest(Test s){

        File directory=new File("./Tests");
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
            fileName = "Test" + String.valueOf(fileCount + 1) + ".tst";
        }

        try {
            s.setName(fileName);
            FileOutputStream fileOut = new FileOutputStream("./Tests/" + fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(s);
            out.close();
            fileOut.close();
            System.out.println("\nTest saved successfully as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
