package languages.translator.latin;

import dev.langchain4j.model.openai.OpenAiChatModel;
import java.util.Scanner;

public class LatinTranslatorChat {
    public static void main(String[] args) {
        // 1. Verbindung zum KI-Modell herstellen (API-Key erforderlich)
        OpenAiChatModel model = OpenAiChatModel.withApiKey("DEIN_API_KEY");

        // 2. Chat-Schleife
        Scanner scanner = new Scanner(System.in);
        System.out.println("Latein-Übersetzer bereit! (Schreibe 'exit' zum Beenden)");

        while (true) {
            System.out.print("Deutsch: ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) break;

            // 3. Prompt an die KI senden
            String prompt = "Übersetze den folgenden deutschen Text präzise ins Lateinische: " + input;
            String latinTranslation = model.generate(prompt);

            System.out.println("Latein: " + latinTranslation);
        }
        scanner.close();
    }
}

