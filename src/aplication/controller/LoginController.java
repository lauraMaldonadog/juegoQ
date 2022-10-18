package aplication.controller;

import java.net.URL;
import java.util.ResourceBundle;

import aplication.Main;
import aplication.exception.DatosInvalidosException;
import aplication.exception.ModoClasicoNoEncontradoException;
import aplication.exception.modoDueloNoEncontradoException;
import aplication.model.Utilidades;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

	Main main;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbContrasena;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Label lbUsuario;

    @FXML
    private Label lbBienvenido;

    @FXML
    private RadioButton rbtDuelo;

    @FXML
    private Label lblCrearCuenta;

    @FXML
    private RadioButton rbtClasico;

    @FXML
    private TextField txtUsuario;

    @FXML
    void IniciarSesionAction(ActionEvent event) {
    	iniciarSesion();

    }

    
	@FXML
    void elergirModoClasicoAction(ActionEvent event) {

		rbtClasico.setSelected(true);
		rbtDuelo.setSelected(false);
    }
	

    @FXML
    void elegirModoDueloAction(ActionEvent event) {

    	rbtClasico.setSelected(false);
    	rbtDuelo.setSelected(true);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblCrearCuenta.setOnMouseClicked(e->{
			main.mostrarVentanaFormuladrioRegistro();
		});
		}

		
	

	
	 private void iniciarSesion() {


			try {
				if(validarDatos()){
					String user=txtUsuario.getText();
					String passwd=txtContrasenia.getText();

					if(!user.isEmpty() && !passwd.isEmpty()){
						if(rbtClasico.isSelected())
							
							//FALTA TERMINAR EL METODO cargarModoClasico
							main.cargarModoClasico(user,passwd);
						if(rbtDuelo.isSelected())
							//FALTA TERMINAR EL METODO cargarModoDuelo
							main.cargarModoDuelo(user,passwd);
					}				
					}
		}catch ( DatosInvalidosException | ModoClasicoNoEncontradoException | modoDueloNoEncontradoException e) {
			Utilidades.mostrarMensaje("Error", " Error al iniciar sesion", "msm :" +e.getMessage(), AlertType.ERROR);
		}

		}
	/*
     * METODO QUE VALIDA LAS CASILLAS DE LA INTERFAZ PARA SABER SI ALGUNA ESTA VACIA 
     */
	private boolean validarDatos() throws DatosInvalidosException {
		String mensaje= " ";
		if(txtUsuario ==null || txtUsuario.getText().isEmpty())
			mensaje+="Se debe ingresar un usuario\n";
		if(txtUsuario == null || txtUsuario.getText().isEmpty())
			mensaje+="Se debe ingresar una contraseña\n";
		if(!mensaje.isEmpty())
			throw new DatosInvalidosException(mensaje);
		
		return true;
	}

}


