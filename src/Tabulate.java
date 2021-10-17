import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Tabulate {

    private Scanner myObj = new Scanner(System.in);

    public Tabulate(){

    }

    public void TabulateSurvey(Survey s){
        List<Object> questions = new ArrayList<Object>();
        questions = s.getQuestions();
        String filename;
        File directory=new File("./Responses");
        Boolean loaded = false;
        List<String> responses = new ArrayList<>();
        List<String> allResponses = new ArrayList<>();
        String[] pathnames = directory.list();
        String responseToLoad = "Response";
        String regex = "\\s++$";


        for(int i = 0; i < questions.size(); i++){
            System.out.println("\nQuestion:");
            ((Question) questions.get(i)).display();
            System.out.println("\nResponses:");


                for(int b = 1; b <= pathnames.length; b++) {
                    filename = directory + "/" + responseToLoad + String.valueOf(b) + ".txt";

                    try (FileReader f = new FileReader(filename)) {
                        StringBuffer sb = new StringBuffer();
                        while (f.ready()) {
                            char c = (char) f.read();
                            if (c == '\n') {
                                String correct = sb.toString().trim();
                                responses.add(correct);
                                sb = new StringBuffer();
                            } else {
                                sb.append(c);
                            }
                        }
                        if (sb.length() > 0) {
                            String correct = sb.toString().trim();
                            responses.add(correct);
                            allResponses.add(correct);
                        }

                        loaded = true;
                    } catch (FileNotFoundException e) {

                    } catch (IOException e) {

                    }
                    System.out.println(responses.get(i));
                    allResponses.add(responses.get(i));
                    responses.clear();
                }

            System.out.println("\nTabulation:");
            Set<String> distinct = new HashSet<>(allResponses);
            for (String q: distinct) {
                System.out.println(q + ": " + Collections.frequency(allResponses, q));
            }
            allResponses.clear();
        }
    }

    public void TabulateTest(Test t) {
        List<Object> questions = new ArrayList<Object>();
        questions = t.getQuestions();
        String filename;
        File directory = new File("./TestResponses");
        Boolean loaded = false;
        List<String> responses = new ArrayList<>();
        List<String> allResponses = new ArrayList<>();
        String[] pathnames = directory.list();
        String responseToLoad = "Response";
        String regex = "\\s++$";
        try {
            for (int i = 0; i < questions.size(); i++) {
                System.out.println("\nQuestion:");
                ((Question) questions.get(i)).display();
                System.out.println("\nResponses:");


                for (int b = 1; b <= pathnames.length; b++) {
                    filename = directory + "/" + responseToLoad + String.valueOf(b) + ".txt";

                    try (FileReader f = new FileReader(filename)) {
                        StringBuffer sb = new StringBuffer();
                        while (f.ready()) {
                            char c = (char) f.read();
                            if (c == '\n') {
                                String correct = sb.toString().trim();
                                responses.add(correct);
                                sb = new StringBuffer();
                            } else {
                                sb.append(c);
                            }
                        }
                        if (sb.length() > 0) {
                            String correct = sb.toString().trim();
                            responses.add(correct);
                            allResponses.add(correct);
                        }

                        loaded = true;
                    } catch (FileNotFoundException e) {

                    } catch (IOException e) {

                    }
                    System.out.println(responses.get(i));
                    allResponses.add(responses.get(i));
                    responses.clear();
                }

                System.out.println("\nTabulation:");
                Set<String> distinct = new HashSet<>(allResponses);
                for (String q : distinct) {
                    System.out.println(q + ": " + Collections.frequency(allResponses, q));
                }
                allResponses.clear();
            }
        }catch (IndexOutOfBoundsException ie){
            System.out.println("Some sort of error occurred...\n");
        }
    }
}
