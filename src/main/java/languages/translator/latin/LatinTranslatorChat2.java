package languages.translator.latin;

import dev.langchain4j.model.ollama.OllamaChatModel;

public class LatinTranslatorChat2 {
    public static void main(String[] args) {
        // Verbindung zum LOKALEN Ollama-Modell
        OllamaChatModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3") // Dein installiertes Modell
                .build();

        // Der restliche Chat-Code bleibt identisch...
        String prompt = "Übersetze ins Lateinische: Wie geht es dir?";
        System.out.println("Latein: " + model.generate(prompt));
    }
}
