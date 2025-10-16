# Taschenrechner

Ein einfacher **Taschenrechner** in JavaFX, der sowohl per **Maus** als auch per **Tastatur** bedient werden kann. Das Projekt dient als Übung für GUI-Programmierung, Event-Handling und JavaFX-Grundlagen.

---

## Funktionen

- Addition, Subtraktion, Multiplikation, Division  
- Tastatursteuerung: Zahlen, Operatoren, `C` für Clear  
- Dezimalpunkt-Eingabe (`.`)  
- Clear-Funktion zum Zurücksetzen  
- GUI in JavaFX mit FXML und CSS-Styling  

---

## Projektstruktur

```
Taschenrechner/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── taschenrechner/
│   │   │       └── taschenrechner/
│   │   │           ├── HelloApplication.java
│   │   │           ├── HelloController.java
│   │   │           └── Launcher.java
│   │   └── resources/
│   │       └── taschenrechner/
│   │           └── taschenrechner/
│   │               └── hello-view.fxml
├── .gitignore
├── pom.xml
└── README.md
```

---

## Installation & Start

1. **Repository klonen:**

```bash
git clone https://github.com/deinBenutzername/Taschenrechner.git
```

2. **Projekt in IntelliJ IDEA öffnen**  
   - Modul sollte automatisch erkannt werden  
   - Falls nicht: `File → Project Structure → Modules → Import Module`

3. **Starten**  
   - Run-Konfiguration: `Launcher` (Main-Class: `taschenrechner.taschenrechner.Launcher`)  
   - Tastatursteuerung funktioniert sofort nach Start

---

## Bedienung

- **Maus**: Klick auf Zahlen und Operatoren, `=` für Ergebnis, `C` zum Löschen  
- **Tastatur**:
  - Zahlen 0–9  
  - `+`, `-`, `*`, `/` für Operatoren  
  - `Enter` für `=`  
  - `C` oder `Escape` für Clear  
  - `.` für Dezimalpunkt  

---

## Hinweise

- Division durch 0 gibt `NaN` aus  
- Das Projekt dient als Übungsprojekt und Beispiel für JavaFX GUI-Anwendungen  

---

## Lizenz

Dieses Projekt ist für Lernzwecke erstellt und frei nutzbar.  
