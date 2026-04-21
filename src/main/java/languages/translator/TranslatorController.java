package languages.translator;

import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.*;
import java.time.Duration;

@RestController
@CrossOrigin // Erlaubt den Zugriff vom Browser
public class TranslatorController {

    private final OllamaChatModel model = OllamaChatModel.builder()
        .baseUrl("http://localhost:11434")
        .modelName("llama3")
        .timeout(Duration.ofMinutes(3)) // Hier den Timeout deutlich erhöhen
        .build();

 @GetMapping("/translate")
public String translate(
    @RequestParam("text") String text, 
    @RequestParam("target") String target
) {
    try {
        String targetLangName = target.equalsIgnoreCase("german") ? "Deutsch" : 
                               (target.equalsIgnoreCase("greek") ? "Altgriechisch" : "Latein");

        String prompt = String.format(
            "Du bist ein Philologe für Latein und Altgriechisch. " +
            "Übersetze diesen Text ins %s: \"%s\".\n\n" +
            "Strukturiere deine Antwort exakt so:\n" +
            "### 1. Übersetzung\n[Hier die Übersetzung]\n\n" +
            "### 2. Grammatikalische Analyse\n" +
            "Erstelle eine Markdown-Tabelle mit den Spalten: " +
            "Wort | Grundform | Grammatik (Fall/Zeit/Person) | Bedeutung\n" +
            "|---|---|---|---|\n\n" +
            "WICHTIG: Antworte NUR auf Deutsch. Nutze keine englischen Phrasen.",
            targetLangName, text
        );

        return model.generate(prompt);
    } catch (Exception e) {
        return "Fehler: " + e.getMessage();
    }
}




}
 