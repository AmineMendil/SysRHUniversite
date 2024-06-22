/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmnguniversity;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author RSservices
 */
public class MessageAlerte {
    
    private Alert alerte;
    
    public void messageReussie(String message){
        alerte = new Alert(Alert.AlertType.INFORMATION);
        alerte.setTitle("Information message");
        alerte.setHeaderText(null);
        alerte.setContentText(message);
        alerte.show();
    }
    
    public void messageErreur(String message){
        alerte = new Alert(Alert.AlertType.ERROR);
        alerte.setTitle("Information message");
        alerte.setHeaderText(null);
        alerte.setContentText(message);
        alerte.show();
    }
    
    public boolean confirmeMessage(String message){
        alerte = new Alert(Alert.AlertType.CONFIRMATION);
        alerte.setTitle("Information message");
        alerte.setHeaderText(null);
        alerte.setContentText(message);
        
        Optional<ButtonType> option = alerte.showAndWait();
        
        return option.get().equals(ButtonType.OK);
    }
    
}
