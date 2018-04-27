import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;

public class AppSpace extends Application {

    private Scene scene;
    private Spielsteuerung spielSteuerung;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        spielSteuerung = new Spielsteuerung();
        scene = new Scene(spielSteuerung.getFlaeche());
        steuerungEinrichten();
        stage.setTitle("Space Invaders");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public void steuerungEinrichten(){
        scene.setOnKeyPressed((KeyEvent ke) -> {
                spielSteuerung.gedrueckt(ke);
            });

        scene.setOnKeyReleased((KeyEvent ke) -> {
                spielSteuerung.losgelassen(ke);
            });

    }

}