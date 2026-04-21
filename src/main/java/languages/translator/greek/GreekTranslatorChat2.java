package languages.translator.greek;

import dev.langchain4j.model.ollama.OllamaChatModel;
import java.util.Scanner;

public class GreekTranslatorChat2 {
    public static void main(String[] args) {
        try {
    System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
} catch (java.io.UnsupportedEncodingException e) {
    System.err.println("UTF-8 wird nicht unterstützt: " + e.getMessage());
}

        // 1. Verbindung zum lokalen Ollama-Modell
        OllamaChatModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3") // "mistral" funktioniert oft auch sehr gut für Sprachen
                .build();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Altgriechisch-Übersetzer bereit! ===");
        System.out.println("(Tippe 'exit' zum Beenden)");

        while (true) {
            System.out.print("\nDeutsch: ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) break;

            // 2. Der System-Prompt ist hier entscheidend für die Genauigkeit
            String prompt = "Übersetze den Text '" + input + "' ins Altgriechische. " +
                "Gib zuerst die griechischen Wörter mit Akzenten aus und " +
                "darunter in Klammern die Aussprache (Transliteration).";

            try {
                String translation = model.generate(prompt);
                System.out.println("Altgriechisch: " + translation);
            } catch (Exception e) {
                System.err.println("Fehler: Stelle sicher, dass Ollama läuft! " + e.getMessage());
            }
        }
        scanner.close();
    }
}
