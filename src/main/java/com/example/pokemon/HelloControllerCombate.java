package com.example.pokemon;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;


public class HelloControllerCombate {

    public static Pokemon pokemonPagina1;
    private HelloController HelloController;
    ButtonType salir = new ButtonType("SALIR", ButtonBar.ButtonData.FINISH);
    ButtonType volver = new ButtonType("ELEGIR POKEMON", ButtonBar.ButtonData.BACK_PREVIOUS);


    Foto foto = new Foto(new File("src\\main\\java\\com\\example\\pokemon\\fotos\\fondo.png"));
    PokemonMalo aleatorio;
    PokemonMalo m1 = new PokemonMalo("Mewtwo", 80, 100, 100, new File("src\\main\\java\\com\\example\\pokemon\\fotos\\mewtwo.png"));
    PokemonMalo m2 = new PokemonMalo("Dragonite", 73, 100, 100, new File("src\\main\\java\\com\\example\\pokemon\\fotos\\dragonite.png"));
    PokemonMalo m3 = new PokemonMalo("Gyarados", 90, 100, 100, new File("src\\main\\java\\com\\example\\pokemon\\fotos\\gyarados.png"));
    PokemonMalo m4 = new PokemonMalo("Onix", 80, 100, 100, new File("src\\main\\java\\com\\example\\pokemon\\fotos\\onix.png"));

    float lifeMalo;
    float vidaBarraMalo;
    float life;
    float vidaBarra;

    @FXML
    Label atacar;
    @FXML
    Label curar;

    @FXML
    ImageView fotoMuerto;
    @FXML
    Label nombreMuerto;

    @FXML
    Label nombrePokemon;
    @FXML
    Label nivelPokemon;
    @FXML
    ProgressBar vidaPokemon;
    @FXML
    Label vidaNumPokemon;
    @FXML
    ImageView pokemonBueno;

    @FXML
    Label nombreEnemy;
    @FXML
    Label nivelEnemy;
    @FXML
    Label vidaNumEnemy;
    @FXML
    ProgressBar vidaEnemy;
    @FXML
    ImageView PokemonMalo;
    @FXML
    ImageView fondo;
    @FXML
    BorderPane ataques;
    @FXML
    AnchorPane menuSalir;



    Pokemon pokemonSeleccionado;


    @FXML
    public void initialize(Pokemon pokemonSeleccionado) {


        this.pokemonSeleccionado = pokemonSeleccionado;
        Random r = new Random();
        int n = r.nextInt(5) + 1;


        switch (n) {
            case 1 -> aleatorio = m1;
            case 2 -> aleatorio = m2;
            case 3 -> aleatorio = m3;
            case 4 -> aleatorio = m4;
        }

        lifeMalo = aleatorio.vidaRestante;
        vidaBarraMalo = (lifeMalo / aleatorio.vida);
        Image fotomalo = new Image(aleatorio.foto.toURI().toString());
        PokemonMalo.setImage(fotomalo);
        nombreEnemy.setText(aleatorio.nombre);
        nivelEnemy.setText(String.valueOf(aleatorio.nivel));
        vidaEnemy.setProgress(vidaBarraMalo);
        vidaNumEnemy.setText(String.valueOf(aleatorio.vida));

        life = pokemonSeleccionado.vidaRestante;
        vidaBarra = (life / pokemonSeleccionado.vida);
        Image fotobueno = new Image(pokemonSeleccionado.fotodetras.toURI().toString());
        pokemonBueno.setImage(fotobueno);
        nombrePokemon.setText(pokemonSeleccionado.nombre);
        nivelPokemon.setText(String.valueOf(pokemonSeleccionado.nivel));
        vidaPokemon.setProgress(vidaBarra);
        vidaNumPokemon.setText(String.valueOf(pokemonSeleccionado.vidaRestante));
        ataques.setVisible(false);

        Image image = new Image(foto.foto.toURI().toString());
        fondo.setImage(image);
    }

    public void ataque() {
        ataques.setVisible(true);
        atacar.setDisable(true);
        curar.setDisable(true);
    }

    public void curar(javafx.scene.input.MouseEvent event) {
        Random g = new Random();
        int a = g.nextInt(76) + 25;
        pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vidaRestante + a;
        if (pokemonSeleccionado.vidaRestante > pokemonSeleccionado.vida) {
            pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vida;
        }
        vidaBarra = (pokemonSeleccionado.vidaRestante / pokemonSeleccionado.vida);
        vidaPokemon.setProgress(vidaBarra);
        vidaNumPokemon.setText(String.valueOf(pokemonSeleccionado.vidaRestante));
        HelloController.actualizar(event);

        Random h = new Random();
        int b = h.nextInt(76) + 25;
        lifeMalo = lifeMalo + b;
        if (lifeMalo > aleatorio.vida) {
            lifeMalo = aleatorio.vida;
        }
        vidaBarraMalo = (lifeMalo / aleatorio.vida);
        vidaEnemy.setProgress(vidaBarraMalo);
        vidaNumEnemy.setText(String.valueOf(lifeMalo));

    }

    public void atacarSeguro(javafx.scene.input.MouseEvent event) {
        if (!(lifeMalo <= 0 || pokemonSeleccionado.vidaRestante <= 0)) {
            lifeMalo = lifeMalo - 20;
            vidaBarraMalo = (lifeMalo / aleatorio.vida);
            vidaEnemy.setProgress(vidaBarraMalo);
            vidaNumEnemy.setText(String.valueOf(lifeMalo));
            if (lifeMalo > 0) {
                pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vidaRestante - 20;
                vidaBarra = (pokemonSeleccionado.vidaRestante / pokemonSeleccionado.vida);
                vidaPokemon.setProgress(vidaBarra);
                vidaNumPokemon.setText(String.valueOf(pokemonSeleccionado.vidaRestante));
                HelloController.actualizar(event);
            } else {
                menu(event);
            }if (pokemonSeleccionado.vidaRestante <= 0){
                menu(event);
            }
        }
    }

    public void atacarArriesgado(javafx.scene.input.MouseEvent event) {
        if (!(lifeMalo <= 0 || pokemonSeleccionado.vidaRestante <= 0)) {
            Random c = new Random();
            int a = c.nextInt(26) + 10;
            lifeMalo = lifeMalo - a;
            vidaBarraMalo = (lifeMalo / aleatorio.vida);
            vidaEnemy.setProgress(vidaBarraMalo);
            vidaNumEnemy.setText(String.valueOf(lifeMalo));
            if (lifeMalo > 0) {
                Random d = new Random();
                int b = d.nextInt(26) + 10;
                pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vidaRestante - b;
                vidaBarra = (pokemonSeleccionado.vidaRestante / pokemonSeleccionado.vida);
                vidaPokemon.setProgress(vidaBarra);
                vidaNumPokemon.setText(String.valueOf(pokemonSeleccionado.vidaRestante));
                HelloController.actualizar(event);
            }
            else {
                menu(event);
            }
            if (pokemonSeleccionado.vidaRestante <= 0){
                menu(event);
            }
        }
        }


    public void atacarMuyArriesgado(javafx.scene.input.MouseEvent event) {
        if (!(lifeMalo <= 0 || life <= 0)) {
            Random e = new Random();
            int a = e.nextInt(51);
            lifeMalo = lifeMalo - a;
            vidaBarraMalo = (lifeMalo / aleatorio.vida);
            vidaEnemy.setProgress(vidaBarraMalo);
            vidaNumEnemy.setText(String.valueOf(lifeMalo));
            if (lifeMalo > 0) {
                Random f = new Random();
                int b = f.nextInt(51);
                pokemonSeleccionado.vidaRestante = pokemonSeleccionado.vidaRestante - b;
                vidaBarra = (pokemonSeleccionado.vidaRestante / pokemonSeleccionado.vida);
                vidaPokemon.setProgress(vidaBarra);
                vidaNumPokemon.setText(String.valueOf((pokemonSeleccionado.vidaRestante)));
                HelloController.actualizar(event);
            } else {menu(event);}
            if (pokemonSeleccionado.vidaRestante <= 0){
                menu(event);
            }
        }
    }

    public void cancelar() {
        ataques.setVisible(false);
        atacar.setDisable(false);
        curar.setDisable(false);
    }

    public void salirBoton() {
        System.exit(0);
    }

    public void continuarBoton() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Ventana1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 663, 400);
        stage.setTitle("ESCOGE POKEMON");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }

    public void pokemonPasado(HelloController Hellocontroller) {
        this.HelloController= Hellocontroller;
    }

/*
    public void menu() {
        menuSalir.setVisible(true);
        if (lifeMalo <= 0) {
            Image fotomuerto = new Image(aleatorio.foto.toURI().toString());
            fotoMuerto.setImage(fotomuerto);
            nombreMuerto.setText(aleatorio.nombre);
        } else {
            Image fotomuerto1 = new Image(pokemonSeleccionado.foto.toURI().toString());
            fotoMuerto.setImage(fotomuerto1);
            nombreMuerto.setText(pokemonSeleccionado.nombre);
        }
    }

 */ @FXML
    private void menu(javafx.scene.input.MouseEvent event) {
        Alert customAlert = new Alert(Alert.AlertType.NONE);
        if (lifeMalo<=0){
            customAlert.setTitle("POKEMON MUERTO");
            customAlert.setContentText(aleatorio.nombre);
            Image fotomuerto = new Image(aleatorio.foto.toURI().toString());
            ImageView imageView1 = new ImageView(fotomuerto);
            customAlert.setGraphic(imageView1);
            imageView1.setFitWidth(120);
            imageView1.setFitHeight(120);
            customAlert.getDialogPane().getButtonTypes().addAll(volver, salir);
            showAlert(customAlert, event);
        }else{
            customAlert.setTitle("POKEMON MUERTO");
            customAlert.setContentText(pokemonSeleccionado.nombre);
            Image fotovivo = new Image(pokemonSeleccionado.foto.toURI().toString());
            ImageView imageView2 = new ImageView(fotovivo);
            customAlert.setGraphic(imageView2);
            imageView2.setFitWidth(120);
            imageView2.setFitHeight(120);
            customAlert.getDialogPane().getButtonTypes().addAll(volver, salir);
            showAlert(customAlert, event);
        }
    }
    private void showAlert(Alert alert, javafx.scene.input.MouseEvent event) {
        Optional<ButtonType> resultado = alert.showAndWait();
        if(resultado.get() == salir) {
            System.exit(0);
        }
        if(resultado.get() == volver) {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }



}













