import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.Bounds;

public class Alien
{
    //Attribute
    private double x;
    private double y;

    private double v;

    private double breite = 48;
    private double hoehe = 48;

    private Zeichenflaeche flaeche;
    private ImageView symbol;

    private int zaehler;

    private boolean sichtbar;

    //Konstruktor
    public Alien(Zeichenflaeche flaeche_,double x_,double y_)
    {
        x = x_;
        y = y_;
        flaeche = flaeche_;
        symbolErstellen();
        v = 0.4;
        zaehler = 0;
        sichtbar = true;
    }
    //Methoden
    public void symbolErstellen()
    {
        symbol = new ImageView(new Image("alien1.png"));
        symbol.relocate(x,y);
        flaeche.hinzufuegen(symbol);
    }
    public void symbolErstellen2()
    {
        symbol = new ImageView(new Image("alien2.png"));
        symbol.relocate(x,y);
        flaeche.hinzufuegen(symbol);
    }
     public void symbolErstellen3()
    {
        symbol = new ImageView(new Image("alien3.png"));
        symbol.relocate(x,y);
        flaeche.hinzufuegen(symbol);
    }
    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getBreite()
    {
        return breite;
    }
    
    public double getHoehe()
    {
        return hoehe;
    }

    public void setPosition(double x_, double y_)
    {
        x = x_;
        y = y_;
        symbol.relocate(x,y);
    }

    public void update()
    {
        zaehler = zaehler + 1;
        x = x + v;
        symbol.relocate(x,y);
        if (zaehler == 400)
        {
            v = v * (-1);
            zaehler = 0;
        }
    }

    /**ICH glaube NEU*/
    
    // liefert die Maße wieder damit man das SChiff sterben lassen kann
    public Bounds gebeBounds()
    {
        return symbol.getBoundsInParent();
    }

    public void sichtbarMachen()
    {
        symbol.setVisible(true);
        sichtbar = true;
    }

    public void unsichtbarMachen()
    {
        symbol.setVisible(false);
        sichtbar = false;
    }

    public boolean istSichtbar()
    {
        return sichtbar;
    }
}

