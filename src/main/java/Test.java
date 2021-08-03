import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.recognizer.Recognizer;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    private static String res = null;
    private static Scanner sc;
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("file:C:\\Users\\Csőri Kornél\\IdeaProjects\\libs\\sphinx4-master\\sphinx4-data\\src\\main\\resources\\edu\\cmu\\sphinx\\models\\en-us\\en-us");
        configuration.setDictionaryPath("file:C:\\Users\\Csőri Kornél\\IdeaProjects\\libs\\sphinx4-master\\sphinx4-data\\src\\main\\resources\\edu\\cmu\\sphinx\\models\\en-us\\cmudict-en-us.dict");
        configuration.setLanguageModelPath("file:C:\\Users\\Csőri Kornél\\IdeaProjects\\libs\\sphinx4-master\\sphinx4-data\\src\\main\\resources\\edu\\cmu\\sphinx\\models\\en-us\\en-us.lm.bin");

        LiveSpeechRecognizer recognizer = null;
        try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start recognition process pruning previously cached data.
        recognizer.startRecognition(true);
        System.out.println("--------------------Start Recording-----------------------");
        SpeechResult result;
        while (true) {
            result = recognizer.getResult();
            if (result == null) {
                res = result.getHypothesis();
                System.out.println("result: " + result.getHypothesis());
                // Pause recognition process. It can be resumed then with startRecognition(false).

                recognizer.stopRecognition();
                System.out.println("--------------------Stop Recording-----------------------");
                return;
            }

            if (result.getHypothesis().equals("bye")) {
                System.out.println("asd");
                return;
            }
        }





    }
}
