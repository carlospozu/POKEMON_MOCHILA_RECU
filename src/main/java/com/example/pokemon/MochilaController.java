package com.example.pokemon;



import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class MochilaController {

    static ButtonType volver = new ButtonType("SALIR", ButtonBar.ButtonData.BACK_PREVIOUS);
    private HelloController HelloController;
    Pokemon pokemonSeleccionado;
    Mochila mochila = new Mochila("OBJETO A", "CURA 10 pùntos de la vida del pokemon", "OBJETO B", "Cura 20 puntos de vida del pokemon", "OBJETO C", "Cura 10% de la vida del pokemon","OBJETO D", "Cura 20% de la vida del pokemon" ,new File("src\\main\\java\\com\\example\\pokemon\\fotos\\objeto1.png"), new File("src\\main\\java\\com\\example\\pokemon\\fotos\\objeto2.png"), new File("src\\main\\java\\com\\example\\pokemon\\fotos\\objeto3.png"), new File("src\\main\\java\\com\\example\\pokemon\\fotos\\objeto4.png"));
    Fondo fondox = new Fondo(new File("src\\main\\java\\com\\example\\pokemon\\fotos\\back.png"), new File("src\\main\\java\\com\\example\\pokemon\\fotos\\fondo1.png"), new File("src\\main\\java\\com\\example\\pokemon\\fotos\\fondo2.png"));
    @FXML
    Label titulo;
    @FXML
    Label descripcion;
    @FXML
    Label objeto1;
    @FXML
    Label objeto2;
    @FXML
    Label objeto3;
    @FXML
    Label objeto4;
    @FXML
    Label desc1;
    @FXML
    Label desc2;
    @FXML
    Label desc3;
    @FXML
    Label desc4;
    @FXML
    ImageView foto1;
    @FXML
    ImageView foto2;
    @FXML
    ImageView foto3;
    @FXML
    ImageView foto4;
    @FXML
    ImageView fondo1;
    @FXML
    ImageView fondo2;


    @FXML
    public void initialize(Pokemon pokemonSeleccionado) {
        this.pokemonSeleccionado = pokemonSeleccionado;
        titulo.setText("MOCHILA POKEMON");
        descripcion.setText("Puedes usar estos objetos tantas veces como quieras para curarte");
        objeto1.setText(mochila.objeto1);
        desc1.setText(mochila.desc1);
        objeto2.setText(mochila.objeto2);
        desc2.setText(mochila.desc2);
        objeto3.setText(mochila.objeto3);
        desc3.setText(mochila.desc3);
        objeto4.setText(mochila.objeto4);
        desc4.setText(mochila.desc4);
        Image imagen = new Image(mochila.foto1.toURI().toString());
        foto1.setImage(imagen);
        Image imagen2 = new Image(mochila.foto2.toURI().toString());
        foto2.setImage(imagen2);
        Image imagen3 = new Image(mochila.foto3.toURI().toString());
        foto3.setImage(imagen3);
        Image imagen4 = new Image(mochila.foto4.toURI().toString());
        foto4.setImage(imagen4);
        Image imagen6 = new Image(fondox.fondo1.toURI().toString());
        fondo1.setImage(imagen6);
        Image imagen7 = new Image(fondox.fondo2.toURI().toString());
        fondo2.setImage(imagen7);
    }



    public void usar1(javafx.scene.input.MouseEvent event) {
        if (pokemonSeleccionado.vidaRestante< pokemonSeleccionado.vida){
        pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vidaRestante + 10;
        if (pokemonSeleccionado.vidaRestante> pokemonSeleccionado.vida){
            pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vida;
        }
        HelloController.actualizar(event);
        }
    }

    public void usar2(javafx.scene.input.MouseEvent event) {
        if (pokemonSeleccionado.vidaRestante< pokemonSeleccionado.vida) {
            pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vidaRestante + 20;
            if (pokemonSeleccionado.vidaRestante > pokemonSeleccionado.vida) {
                pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vida;
            }
            HelloController.actualizar(event);
        }
    }

    public void usar3(javafx.scene.input.MouseEvent event) {
        if (pokemonSeleccionado.vidaRestante< pokemonSeleccionado.vida) {
            float cont = (float) (pokemonSeleccionado.vidaRestante * 0.1);
            pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vidaRestante + cont;
            if (pokemonSeleccionado.vidaRestante > pokemonSeleccionado.vida) {
                pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vida;
            }
            HelloController.actualizar(event);
        }

    }

    public void usar4(javafx.scene.input.MouseEvent event) {
        if (pokemonSeleccionado.vidaRestante< pokemonSeleccionado.vida) {
            float cont1 = (float) (pokemonSeleccionado.vidaRestante * 0.2);
            pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vidaRestante + cont1;
            if (pokemonSeleccionado.vidaRestante > pokemonSeleccionado.vida) {
                pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vida;
            }
            HelloController.actualizar(event);
        }
    }

    @FXML
    static void menu(javafx.scene.input.MouseEvent event) {

        Alert customAlert = new Alert(Alert.AlertType.NONE);
        customAlert.setTitle("ENHORABUENA");
        customAlert.setContentText("Todos los POKEMON CURADOS");
        customAlert.getDialogPane().getButtonTypes().addAll(volver);
        showAlert(customAlert, event);


    }
    private static void showAlert(Alert alert, javafx.scene.input.MouseEvent event) {

        Optional<ButtonType> resultado = alert.showAndWait();
        if(resultado.get() == volver) {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }





    public void pokemonPasado(HelloController Hellocontroller) {
        this.HelloController= Hellocontroller;
    }
}
