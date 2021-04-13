package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btmAnagrammi;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btmReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	this.txtCorretti.clear();
    	String parola= this.txtParola.getText();
    	List <String> risultatoCorretti= new ArrayList <String>();
    	risultatoCorretti= this.model.anagrammiCorretti(parola);
    	for(String s: risultatoCorretti) {
    		this.txtCorretti.appendText(s+"\n");
    		
    	}
    	List <String> risultatoSbagliato= new ArrayList <String>();
    	risultatoSbagliato= this.model.anagrammiSbagliati(parola);
    	for(String s: risultatoSbagliato) {
    		this.txtErrati.appendText(s+"\n");
    		
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCorretti.clear();
    }
    
    public void setModel( Model m) {
    	this.model=m;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmAnagrammi != null : "fx:id=\"btmAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmReset != null : "fx:id=\"btmReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
