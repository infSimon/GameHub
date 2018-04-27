import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.Bounds;

public class AlienSchuss
{
    //Attribute
    private double x;
    private double y;

    private double v;
    private boolean sichtbar;

    private Zeichenflaeche flaeche;
    private ImageView symbol;

    //Konstruktor
    public AlienSchuss(Zeichenflaeche flaeche_,double x_,double y_)
    {
        x = x_;
        y = y_;
        flaeche = flaeche_;
        symbolErstellen1();
        v = 3;
        unsichtbarMachen();
        sichtbar = false;
    }
    //Methoden
    public void symbolErstellen1()
    {
        symbol = new ImageView(new Image("AlienSchuss1.png"));
        symbol.relocate(x,y);
        flaeche.hinzufuegen(symbol);
    }
    
    public void symbolErstellen2()
    {
        symbol = new ImageView(new Image("AlienSchuss2.png"));
        symbol.relocate(x,y);
        flaeche.hinzufuegen(symbol);
    }
    public void symbolErstellen3()
    {
        symbol = new ImageView(new Image("AlienSchuss3.png"));
        symbol.relocate(x,y);
        flaeche.hinzufuegen(symbol);
    }

    public void update()
    {
        if (sichtbar)
        {
            y = y + v;
            symbol.relocate(x,y);
        }
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
        symbol.relocate(x,y);
    }
    
    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public boolean trifft(Schiff schiff)
    {
        Bounds kugelBounds = symbol.getBoundsInParent();
        Bounds schiffBounds = schiff.gebeBounds();
        if (kugelBounds.intersects(schiffBounds))
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
    
    public boolean istUnten()
    {
        if(x >= 400)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

