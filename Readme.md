# Projekt Name
Kleiner AI Übersetzer für Latein und Altgriechisch mit dem Framework LangChain4j

(java maven projekt, spring)
Anstatt des OpenAiChatModel wird das OllamaChatModel verwendet (keine API-Kosten).

## 🚀 Features
Übersetzer für Latein und Altgriechisch ins Deutsche (und umgekehrt)

Anweisung an AI:
Du bist ein Philologe für Latein und Altgriechisch. 
Übersetze diesen Text
Strukturiere deine Antwort exakt so:
### 1. Übersetzung[Hier die Übersetzung
### 2. Grammatikalische Analyse
Erstelle eine Markdown-Tabelle mit den Spalten:
Wort | Grundform | Grammatik (Fall/Zeit/Person) | Bedeutung
WICHTIG: Antworte NUR auf Deutsch. Nutze keine englischen Phrasen.

## 📦 Installation

Ollama herunterladen (für Windows): https://ollama.com/download/windows
in powershell: ollama pull llama3

Baue das Maven Projekt:
mvn clean install
mvn clean compile

Starte Spring Applikation:
mvn spring-boot:run
http://localhost:8080/

http://localhost:11434