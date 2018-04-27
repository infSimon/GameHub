import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.Bounds;
public class Schiff
{
    //Attribute
    private double x;
    private double y;

    private double v;
    private double v2;

    private double breite = 48;
    private double hoehe = 48;
    
    private boolean sichtbar;

    private Zeichenflaeche flaeche;
    private ImageView symbol;
    private ImageView symbol2;
    
    //Konstruktor
    public Schiff(Zeichenflaeche flaeche_,double x_,double y_)
    {
        x = x_;
        y = y_;
        flaeche = flaeche_;
        symbolErstellen();
        v = 0;
        v2 = 0;
    }
    //Methoden
    private void symbolErstellen()
    {

        symbol = new ImageView(new Image("schiff.png"));
        symbol.relocate(x,y);
        flaeche.hinzufuegen(symbol);

    }

    /**NEU          Funktioniert Aber Noch NICHtT*/
    // Macht ein Neues Image Für das Schiff
    
    public void symbolÄndern()
    {
        unsichtbarMachen();
        symbol = new ImageView(new Image("schiff_broken.png"));
        symbol.relocate(x,y);
        flaeche.hinzufuegen(symbol);
        sichtbarMachen();
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

    public void setPosition(double x_, double y_)
    {
        x = x_;
        y = y_;
        symbol.relocate(x,y);
    }

    public void nachRechts()
    {
        v = 2;
    }

    public void nachLinks()
    {
        v = -2;
    }
    
    public void nachOben()
    {
        v2 = -2;
    }
    
    public void nachUnten()
    {
        v2 = 2;
    }

    public void stoppen()
    {
        v = 0;
        v2 = 0;
    }

    public void update()
    {
        if(x + v >= 10 && x + v <= flaeche.getWidth()-35) {
            x = x + v;
        }
        
        
        
        
        y = y + v2;
        /*if ( x >= flaeche.getWidth()-35)
        {
            x = x - v;
        }
        if ( x >= 35)
        {
            x = x + v;
        }
        if ( y >= flaeche.getHeight()-35)
        {
            x = x - v2;
        }
        if ( y >= 35)
        {
            x = x + v2;
        }*/
        symbol.relocate(x,y);
    }

    public Bounds gebeBounds()
    {
        return symbol.getBoundsInParent();
    }
    
    public void unsichtbarMachen()
    {
        symbol.setVisible(false);
        sichtbar = false;
    }
    public void sichtbarMachen()
    {
        symbol.setVisible(true);
        sichtbar = true; 
    }
    
    /**NEU*/
    //Wenn das Schiff in das Alien Reinfliegt dann Stirbt er
    
    public boolean trifft(Alien alien)
    {
        Bounds schiffBounds = symbol.getBoundsInParent();
        Bounds alienBounds = alien.gebeBounds();
        if (schiffBounds.intersects(alienBounds))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

