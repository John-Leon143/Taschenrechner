package taschenrechner.taschenrechner;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {

    @FXML
    private Label display;

    private String currentInput = ""; // aktuell Zahl
    private String operator = "";     // operator
    private double firstNumber = 0;   // erste Zahl

    // FXML geladen ist
    @FXML
    private void initialize() {
        display.setText("0");
        display.getParent().requestFocus(); // Fokus setzen auf zahlen eingabe
    }

    // Tastatursteuerung
    @FXML
    private void handleKeyInput(KeyEvent event) {
        KeyCode key = event.getCode();

        if (key.isDigitKey()) { // Zahlentasten
            currentInput += event.getText();
            display.setText(currentInput);
        }
        else if (event.getText().equals("+")) {
            handleOperator("+");
        }
        else if (event.getText().equals("-")) {
            handleOperator("-");
        }
        else if (event.getText().equals("*")) {
            handleOperator("*");
        }
        else if (event.getText().equals("/")) {
            handleOperator("/");
        }
        else if (key == KeyCode.ENTER || key == KeyCode.EQUALS) { // Enter oder =
            onEqualClick();
        }
        else if (key == KeyCode.ESCAPE || event.getText().equalsIgnoreCase("c")) { // Esc oder C
            onClear();
        }
        else if (event.getText().equals(".") || event.getText().equals(",")) { // Dezimalpunkt
            if (!currentInput.contains(".")) {
                currentInput += ".";
                display.setText(currentInput);
            }
        }
    }

    // Zahl gedrückt (GUI)
    @FXML
    private void onNumberClick(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        currentInput += value;
        display.setText(currentInput);
    }

    // Operator (+, -, *, /)
    @FXML
    private void onOperatorClick(javafx.event.ActionEvent event) {
        handleOperator(((javafx.scene.control.Button) event.getSource()).getText());
    }

    // Gemeinsame Tastatur und Maus
    private void handleOperator(String op) {
        if (!currentInput.isEmpty()) {
            firstNumber = Double.parseDouble(currentInput);
            currentInput = "";
            operator = op;
            display.setText(operator);
        }
    }

    // =
    @FXML
    private void onEqualClick() {
        if (operator.isEmpty() || currentInput.isEmpty()) return;

        double secondNumber = Double.parseDouble(currentInput);
        double result = switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> secondNumber != 0 ? firstNumber / secondNumber : Double.NaN;
            default -> 0;
        };

        display.setText(String.valueOf(result));
        currentInput = "";
        operator = "";
        firstNumber = result;
    }

    // Alles zurücksetzen
    @FXML
    private void onClear() {
        currentInput = "";
        operator = "";
        firstNumber = 0;
        display.setText("0");
    }
}
