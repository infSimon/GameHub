
/**
 * Sample Skeleton for 'SI.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerSp1 {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="highsclist"
    private ListView<?> highsclist; // Value injected by FXMLLoader

    @FXML // fx:id="startbtn"
    private Button startbtn; // Value injected by FXMLLoader

    @FXML // fx:id="bckbtn"
    private Button bckbtn; // Value injected by FXMLLoader
    @FXML
    private Text nametxt;
    @FXML // fx:id="desctxt"
    private Text desctxt; // Value injected by FXMLLoader
    private Spiel sp;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert highsclist != null : "fx:id=\"highsclist\" was not injected: check your FXML file 'SI.fxml'.";
        assert startbtn != null : "fx:id=\"startbtn\" was not injected: check your FXML file 'SI.fxml'.";
        assert bckbtn != null : "fx:id=\"bckbtn\" was not injected: check your FXML file 'SI.fxml'.";
        assert desctxt != null : "fx:id=\"desctxt\" was not injected: check your FXML file 'SI.fxml'.";
        
        bckbtn.setOnMouseReleased(e-> { 
        Stage stage = (Stage) bckbtn.getScene().getWindow();
        stage.close(); 
    });
    
    }
    public void setSpiel(Spiel sp_ ){
        sp = sp_;
        desctxt.setText(sp.getBESCH());
        nametxt.setText(sp.getName());
    }
}
