package com.example.zadanie1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField mmField, cmField, mField, kmField;

    @FXML private void convert(){
        if (!mmField.getText().isEmpty()) {
            double mm = Double.parseDouble(mmField.getText());
            cmField.setText(String.valueOf(mm/10));
            mField.setText(String.valueOf(mm/1000));
            kmField.setText(String.valueOf(mm/1000000));
        } else if (!cmField.getText().isEmpty()) {
            double cm = Double.parseDouble(cmField.getText());
            mField.setText(String.valueOf(cm/100));
            mmField.setText(String.valueOf(cm*10));
            kmField.setText(String.valueOf(cm/100000));
        } else if (!mField.getText().isEmpty()) {
            double m = Double.parseDouble(mField.getText());
            cmField.setText(String.valueOf(m*100));
            kmField.setText(String.valueOf(m/1000));
            mmField.setText(String.valueOf(m*1000));
        } else if (!kmField.getText().isEmpty()) {
            double km = Double.parseDouble(kmField.getText());
            mField.setText(String.valueOf(km*1000));
            cmField.setText(String.valueOf(km*100000));
            mmField.setText(String.valueOf(km*1000000));
        }
    }

}
