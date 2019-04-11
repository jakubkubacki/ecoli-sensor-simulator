package edu.pwr.ecolisensorsimulator.gui.home;

import edu.pwr.ecolisensorsimulator.math.FrequencyTemperatureCalculator;
import edu.pwr.ecolisensorsimulator.math.FrequencyToCompoundsCalculator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField inputF;
    @FXML
    private TextField inputT;
    @FXML
    private Label resultText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller initialized");
        System.out.println(this.inputF.getText());
    }

    public void clearInput() {
        this.inputF.setText("");
        this.inputT.setText("");
    }

    public void start() {
        double freq = this.getNumericalInput(this.inputF, "Częstotliwość");
        double temp = this.getNumericalInput(this.inputT, "Temperatura");

        double normalizedFreq = FrequencyTemperatureCalculator.normalizeTemperature(freq, temp);
        double compartments = FrequencyToCompoundsCalculator.transform(normalizedFreq);

        this.resultText.setText(this.resultText.getText().split(":")[0] + ": " + compartments);
    }


    private double getNumericalInput(TextField textField, String textName) {
        String text = textField.getText();
        try {
            double parsed = Double.parseDouble(text);
            return parsed;
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Niepoprawna wartość");
            alert.setContentText(textName + " musi być liczbą");
            alert.showAndWait();
        }

        return 0;
    }


}
