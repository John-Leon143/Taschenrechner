package taschenrechner.taschenrechner;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label display;

    private String currentInput = ""; // aktuell Zahl
    private String operator = "";     // operator
    private double firstNumber = 0;   // erste Zahl

    // Zahl wurde gedrückt
    @FXML
    private void onNumberClick(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        currentInput += value;
        display.setText(currentInput);
    }

    // Operator (+, -, *, /)
    @FXML
    private void onOperatorClick(javafx.event.ActionEvent event) {
        if (!currentInput.isEmpty()) {
            firstNumber = Double.parseDouble(currentInput);
            currentInput = "";
            operator = ((javafx.scene.control.Button) event.getSource()).getText();
            display.setText(operator);
        }
    }

    // Gleichheitszeichen (=)
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
