/**
 * Die Klasse Kugel
 */

import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.Bounds;

public class Kugel
{
    //Attribute
    private double x;
    private double y;

    private double v;
    private boolean sichtbar;

    private Zeichenflaeche flaeche;
    private Circle symbol;

    //Konstruktor
    public Kugel(Zeichenflaeche flaeche_,double x_,double y_)
    {
        x = x_;
        y = y_;
        flaeche = flaeche_;
        symbolErstellen();
        v = -20;
        unsichtbarMachen();
        sichtbar = false;
    }
    //Methoden
    private void symbolErstellen()
    {
        symbol = new Circle(3,Color.YELLOW);
        symbol.setCenterX(x);
        symbol.setCenterY(y);
        flaeche.hinzufuegen(symbol);
    }

    public void update()
    {
        if (sichtbar)
        {
            y = y + v;
            symbol.setCenterX(x);
            symbol.setCenterY(y);
        }
    }
    
    public void Kugelerstellen()
    {
        symbolErstellen();
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

    public void setPosition(double x_, double y_)
    {
        x = x_;
        y = y_;
        symbol.setCenterX(x);
        symbol.setCenterY(y);
    }

    public boolean trifft(Alien alien)
    {
        Bounds kugelBounds = symbol.getBoundsInParent();
        Bounds alienBounds = alien.gebeBounds();
        if (kugelBounds.intersects(alienBounds))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean istSichtbar()
    {
        return sichtbar;
    }
}
