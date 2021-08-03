package cucc;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TranscriberDemo {
  public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("file:C:\\Users\\Csőri Kornél\\IdeaProjects\\libs\\sphinx4-master\\sphinx4-data\\src\\main\\resources\\edu\\cmu\\sphinx\\models\\en-us\\en-us");
        configuration.setDictionaryPath("file:C:\\Users\\Csőri Kornél\\IdeaProjects\\libs\\sphinx4-master\\sphinx4-data\\src\\main\\resources\\edu\\cmu\\sphinx\\models\\en-us\\cmudict-en-us.dict");
        configuration.setLanguageModelPath("file:C:\\Users\\Csőri Kornél\\IdeaProjects\\libs\\sphinx4-master\\sphinx4-data\\src\\main\\resources\\edu\\cmu\\sphinx\\models\\en-us\\en-us.lm.bin");

        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
        InputStream stream = new FileInputStream(new File("C:\\Users\\Csőri Kornél\\IdeaProjects\\libs\\sphinx4-master\\sphinx4-samples\\src\\main\\resources\\edu\\cmu\\sphinx\\demo\\speakerid\\test.wav"));

        recognizer.startRecognition(stream);
        SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Hypothesis: %s\n", result.getHypothesis());
        }
        recognizer.stopRecognition();
    }


}
