import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.*;
/**
 * Die Klasse Zeichenflaeche
 */
public class Zeichenflaeche extends Pane
{
    // Attribute

    // Konstruktor
    public Zeichenflaeche()
    {
        setStyle("-fx-background-color: black;");
        setPrefSize(800,400);
    }

    // Methoden
    public void hinzufuegen(Node node)
    {
        getChildren().add(node);
    }

    public void loeschen(Node node)
    {
        getChildren().remove(node);
    }
    
}
