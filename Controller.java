/**
 * Sample Skeleton for 'view.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import java.util.*;
public class Controller {
    private boolean spge;
    private ArrayList<Spiel> spiele;
    
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane1"
    private Pane pane1; // Value injected by FXMLLoader

    @FXML // fx:id="pane2"
    private Pane pane2; // Value injected by FXMLLoader

    @FXML // fx:id="pane3"
    private Pane pane3; // Value injected by FXMLLoader

    @FXML // fx:id="pane4"
    private Pane pane4; // Value injected by FXMLLoader

    @FXML
    void startSpiel1(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane1 != null : "fx:id=\"pane1\" was not injected: check your FXML file 'view.fxml'.";
        assert pane2 != null : "fx:id=\"pane2\" was not injected: check your FXML file 'view.fxml'.";
        assert pane3 != null : "fx:id=\"pane3\" was not injected: check your FXML file 'view.fxml'.";
        assert pane4 != null : "fx:id=\"pane4\" was not injected: check your FXML file 'view.fxml'.";
        spiele  = new ArrayList<Spiel>();
        spiele.add(new SpaceInvadR());
        spiele.add(new PacDude());        
        pane1.setOnMouseClicked(e -> starteSpiel(spiele.get(0)));
        pane2.setOnMouseClicked(e -> starteSpiel(spiele.get(1)));
        spge = false ; 
        
    }

    public void starteSpiel(Spiel spiel)
    {   if(spge == false){   
            try{

               FXMLLoader loader = new FXMLLoader(getClass().getResource("SI.fxml"));
               Parent root = loader.load();
               ControllerSp1 cosp = loader.getController();
               cosp.setSpiel(spiel);
                Stage stage2 = new Stage();                                    
                Scene scene = new Scene(root);           
                stage2.setTitle(spiel.getName());
                stage2.setScene(scene);
                stage2.show();
                stage2.setResizable(false);                
                spge = false;
                stage2.setOnShowing(new EventHandler<WindowEvent>(){
                    public void handle(WindowEvent we) {
                            spge = true;
                        }
                });
                
            } catch(Exception ex)
            {
                System.out.println("Problem beim Starten des Fensters");
            }
        }       
    }
    
    /*public void starteSpiel(int spNU){
        boolean spge = true;
        switch(spNU){
         case 1 : spge = sp1ge;
         break;
         case 2 : spge = sp2ge;
         break;
         case 3 : spge = sp3ge;
         break;
         case 4 : spge = sp4ge;
         break;   
        }
        
        if(spge == false){   
            try{
               Spiel sp = new Spiel(spNU);
               FXMLLoader loader = new FXMLLoader(getClass().getResource("SI.fxml"));
               Parent root = loader.load();
             
                Stage stage2 = new Stage();                                    
                Scene scene = new Scene(root);           
                stage2.setTitle(sp.getName());
                stage2.setScene(scene);
                stage2.show();
                stage2.setResizable(false);                
                spge = false;
                stage2.setOnShowing(new EventHandler<WindowEvent>(){
                    public void handle(WindowEvent we) {
                            spge = true;
                            
                        }
                });
                
            } catch(Exception ex)
            {
                System.out.println("Problem beim Starten des Fensters");
            }
        }  
        switch(spNU){
         case 1 : sp1ge = spge;
         break;
         case 2 : sp2ge = spge;
         break;
         case 3 : sp3ge = spge;
         break;
         case 4 : sp4ge = spge;
         break;   
        }
    }*/
}
