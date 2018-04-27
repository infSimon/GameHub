import java.util.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;

/**
 * Die Klasse Spielsteuerung
 */
public class Spielsteuerung
{
    // Attribute
    private Timer timer;
    private Zeichenflaeche flaeche;
    private Schiff schiff;
    private Kugel kugel;
    private Alien[] aliens;
    private int alienzahl = 22;
    private int lebendeAliens = alienzahl;
    public int Respawnzahl = 0;

    /**NEU*/
    private Score score;
    private ImageView symbol;
    private int alienSchussTimer;
    private AlienSchuss[] alienSchuss;
    private int alienSchusszahl = alienzahl;
    private int hitCounter = 0;
    private int Schiffschusstimer;
    private int cheatcodetimer;

    // Konstruktor
    public Spielsteuerung()
    {

        flaeche = new Zeichenflaeche();
        timer = new Timer(this);
        schiff = new Schiff(flaeche, 300,350);  
        kugel = new Kugel(flaeche, schiff.getX()+ schiff.getBreite()/2,schiff.getY());
        aliens = new Alien[22];
        alienSchuss = new AlienSchuss[22];
        hitCounter = 0;
        score = new Score(flaeche,0,400,0);
        cheatcodetimer = 0;

        for (int i = 0; i < 8 ; i++)
        {
            aliens[i] = new Alien(flaeche, 100 + i*50, 100);
        }

        for (int i = 0; i < 7 ; i++)
        {
            aliens[i+8] = new Alien(flaeche, 125 + i*50, 150);
        }
        for (int i = 0; i < 7 ; i++)
        {
            aliens[i+15] = new Alien(flaeche, 125 + i*50, 50);
        }

        for(int i = 0; i < 22 ; i++)
        {
            alienSchuss[i] = new AlienSchuss(flaeche,0,0);
        }

    }

    /**NEU*/
    //der GameoverScreen
    private void symbolErstellen()
    {
        symbol = new ImageView(new Image("GameOverScreen.png"));
        symbol.relocate(0,0);
        flaeche.hinzufuegen(symbol);
    }

    public void start()
    {
        timer.start();
    }

    public void stop()
    {
        timer.stop();
    }

    /**
     * Die Methode update wird immer vom Timer aufgerufen.
     */
    public void update()
    {

        // Spielobjekte bewegen

        schiff.update();
        kugel.update();

        for (int i = 0; i < alienzahl; i++)
        {
            aliens[i].update();
        }

        for (int i = 0; i < alienSchusszahl; i++)
        {
            alienSchuss[i].update();
        }

        /**Teile NEU*/
        if (kugel.istSichtbar())
        {
            for (int i = 0; i < alienzahl; i++)
            {
                if (aliens[i].istSichtbar())
                {
                    if (kugel.trifft(aliens[i])== true)//false mit boolean cheatcode ersetzen
                    {
                        //aliens töten und Score erhöhen
                        kugel.unsichtbarMachen();
                        aliens[i].unsichtbarMachen();
                        score.scoreErhöhen();
                        System.out.println(score.getScore());
                        score.ScoreAnzeigen();
                        lebendeAliens--;
                    }
                }
            }
        }

        /**NEU*/
        //Spiel beenden wenn man in Alien fliegt
        for (int i = 0; i < alienzahl; i++)
        {
            if (aliens[i].istSichtbar())
            {
                if (schiff.trifft(aliens[i]))
                {
                    System.out.println("GAME OVER");
                    schiff.unsichtbarMachen();
                    timer.stop();
                    symbolErstellen();
                }
            }
        }

        /**NEU*/ 
        // alien Schuss 
        alienSchussTimer = alienSchussTimer + 1;

        if(score.getScore() >= 440)
        {   if(score.getScore() <= 660)
            {
                if(alienSchussTimer >= 25)
                { 
                    int random =(int)(Math.random()*22); 
                    double ya = aliens[random].getY() + aliens[random].getHoehe();
                    double xa = aliens[random].getX();
                    if(aliens[random].istSichtbar() == true)
                    {
                        if(alienSchuss[random].istSichtbar())
                        {
                            if(alienSchuss[random].istUnten() == true)
                            {
                                alienSchuss[random].setPosition(xa,ya);
                                alienSchussTimer = 0;
                            }
                        }
                        else
                        {
                            alienSchuss[random].setPosition(xa,ya);
                            alienSchuss[random].sichtbarMachen();
                            alienSchussTimer = 0;
                        }
                    }
                }
            }
            else
            {
                if(alienSchussTimer >= 12)
                { 
                    int random =(int)(Math.random()*22); 
                    double ya = aliens[random].getY() + aliens[random].getHoehe();
                    double xa = aliens[random].getX();
                    if(aliens[random].istSichtbar() == true)
                    {
                        if(alienSchuss[random].istSichtbar())
                        {
                            if(alienSchuss[random].istUnten() == true)
                            {
                                alienSchuss[random].setPosition(xa,ya);
                                alienSchussTimer = 0;
                            }
                        }
                        else
                        {
                            alienSchuss[random].setPosition(xa,ya);
                            alienSchuss[random].sichtbarMachen();
                            alienSchussTimer = 0;
                        }
                    }
                }    
            }
        }
        else
        {   if(score.getScore() >= 220)
            {
                if(alienSchussTimer >= 100)
                {
                    int random =(int)(Math.random()*22); 
                    double ya = aliens[random].getY() + aliens[random].getHoehe();
                    double xa = aliens[random].getX();
                    if(aliens[random].istSichtbar() == true)
                    {
                        if(alienSchuss[random].istSichtbar())
                        {
                            if(alienSchuss[random].istUnten() == true)
                            {
                                alienSchuss[random].setPosition(xa,ya);
                                alienSchussTimer = 0;
                            }
                        }
                        else
                        {
                            alienSchuss[random].setPosition(xa,ya);
                            alienSchuss[random].sichtbarMachen();
                            alienSchussTimer = 0;
                        }
                    }   
                }
            }
            else
            {
                if(alienSchussTimer >= 50)
                { 
                    int random =(int)(Math.random()*22); 
                    double ya = aliens[random].getY() + aliens[random].getHoehe();
                    double xa = aliens[random].getX();
                    if(aliens[random].istSichtbar() == true)
                    {
                        if(alienSchuss[random].istSichtbar())
                        {
                            if(alienSchuss[random].istUnten() == true)
                            {
                                alienSchuss[random].setPosition(xa,ya);
                                alienSchussTimer = 0;
                            }
                        }
                        else
                        {
                            alienSchuss[random].setPosition(xa,ya);
                            alienSchuss[random].sichtbarMachen();
                            alienSchussTimer = 0;
                        }
                    }
                }
            }
        }

        /**NEU*/
        //Alienshuss Schiff getroffen ? 

        for(int i = 0; i < 22 ; i++)
        {
            if(alienSchuss[i].trifft(schiff) == true)
            {
                if(alienSchuss[i].istSichtbar() == true)
                {
                    hitCounter += 1;                    
                    // alle Unsichtbar machen?? sozusagen invulnerability timer
                    alienSchuss[i].unsichtbarMachen();
                    schiff.symbolÄndern();

                }
            }
        }
        /**NEU*/
        //hitcounter
        if(hitCounter == 2)
        {
            System.out.println("GAME OVER");
            schiff.unsichtbarMachen();
            timer.stop();
            symbolErstellen();
        }

        //updated den Score auf der Oberfläche
        if (lebendeAliens == 0)
        {
            //updated den Score auf der Oberfläche
            for (int i = 0; i < alienzahl; i++)
            {
                alienSchuss[i].unsichtbarMachen();
                if(Respawnzahl==0)
                {

                    aliens[i].symbolErstellen2();
                    alienSchuss[i].symbolErstellen2();
                    //aliens[i].sichtbarMachen();}
                }

                //for (int i = 0; i < alienzahl; i++)
                //{
                if(Respawnzahl==1)
                {

                    aliens[i].symbolErstellen();
                    //aliens[i].sichtbarMachen();
                    alienSchuss[i].symbolErstellen1();
                }
                // }
                //       for (int i = 0; i < alienzahl; i++)
                //{
                if(Respawnzahl == 2)
                {

                    aliens[i].symbolErstellen3();
                    //aliens[i].sichtbarMachen();
                    alienSchuss[i].symbolErstellen3();
                }
                aliens[i].sichtbarMachen();
            }
            /*for (int i = 0; i < alienzahl; i++)
            {aliens[i].sichtbarMachen();}
             */            lebendeAliens = 22;
            if(Respawnzahl < 2)
            {

                Respawnzahl++;
                //aliens[i].sichtbarMachen();

            }
            else
            {
                Respawnzahl = 0;}
        }

        Schiffschusstimer += 1;
        cheatcodetimer -= 1;
    }

    /**
     * Tastensteuerung
     */
    // wird aufgerufen, wenn eine Taste gedrückt wurde
    public void gedrueckt(KeyEvent ke)
    {
        if (ke.getCode() == KeyCode.X)
        {
            Platform.exit();
        }

        if (ke.getCode() == KeyCode.LEFT)
        {
            schiff.nachLinks();
            //System.out.println("Schiff soll nach links");
        }
        if (ke.getCode() == KeyCode.RIGHT)
        {
            schiff.nachRechts();
            //System.out.println("Schiff soll nach rechts");
        }
        if (ke.getCode() == KeyCode.UP)
        {
            schiff.nachOben();
            cheatcodetimer = 10;
            
            //System.out.println("Schiff soll nach rechts");
        }
        if (ke.getCode() == KeyCode.DOWN)
        {
            schiff.nachUnten();
            //System.out.println("Schiff soll nach rechts");
        }
        if (ke.getCode() == KeyCode.S)
        {
            start();
        }
        if (ke.getCode() == KeyCode.SPACE)
        {
            kugel.sichtbarMachen();/*
            if (Schiffschusstimer == 10)
            {
                Kugel k = new Kugel.Kugelerstellen();
                k.setPosition(schiff.getX() + schiff.getBreite()/2, schiff.getY());
                Schiffschusstimer = 0;
                
            }*/
            kugel.setPosition(schiff.getX() + schiff.getBreite()/2, schiff.getY());
        }

    }

    // wird aufgerufen, wenn eine Taste losgelassen wurde
    public void losgelassen(KeyEvent ke)
    {
        schiff.stoppen();
    }

    public Zeichenflaeche getFlaeche()
    {
        return flaeche;
    }

}
