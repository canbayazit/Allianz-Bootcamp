import main.GenerateTranscript;

public class Main {
    public static void main(String[] args) {
        GenerateTranscript generateTranscript = new GenerateTranscript();
        generateTranscript.takeInputFromFile("grades.txt");
       // generateTranscript.takeInputFromUser();
    }
}