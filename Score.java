
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.Bounds;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class Score
{
    private int score = 0;
    private double x;
    private double y;
    private Zeichenflaeche flaeche; 
    //private ImageView symbol;
    private boolean sichtbar;
    private final Text text = new Text(10, 20, "Score: ");
    private Text counter = new Text(70, 20, "000");

    public Score(Zeichenflaeche flaeche_,int score_,double x_, double y_)
    {
        flaeche = flaeche_;
        //symbolErstellen();
        text.setFont(new Font(20));
        text.setFill(Color.WHITE);
        counter.setFill(Color.WHITE);
        flaeche.hinzufuegen(text);
        flaeche.hinzufuegen(counter);
    }

    public void scoreErhöhen()
    {
        score += 10;
    }

    public int getScore()
    {
        return score;
    }

    /*private void symbolErstellen()
    {
    symbol = new ImageView(new Image("00.png"));
    symbol.relocate(x,y);
    flaeche.hinzufuegen(symbol);
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
    }*/

    public void ScoreAnzeigen()
    {   
        String gameScore = "" + getScore();
        if(getScore() <= 90) counter.setText("0" + gameScore);
        else {counter.setText(gameScore);

            /*if (score < 100)
            { 
            if(score == 0)
            {
            symbol = new ImageView(new Image("00.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 10)
            {
            symbol = new ImageView(new Image("10.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 20)
            {
            symbol = new ImageView(new Image("20.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 30)
            {
            symbol = new ImageView(new Image("30.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 40)
            {
            symbol = new ImageView(new Image("40.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 50)
            {
            symbol = new ImageView(new Image("50.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }if(score == 60)
            {
            symbol = new ImageView(new Image("60.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }if(score == 70)
            {
            symbol = new ImageView(new Image("70.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 80)
            {
            symbol = new ImageView(new Image("80.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 90)
            {
            symbol = new ImageView(new Image("90.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            }
            if(score <= 1000)
            {
            if(score < 200)
            {
            if(score == 100)
            {
            symbol = new ImageView(new Image("100.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 120)
            {
            symbol = new ImageView(new Image("120.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 130)
            {
            symbol = new ImageView(new Image("130.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 140)
            {
            symbol = new ImageView(new Image("140.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 150)
            {
            symbol = new ImageView(new Image("150.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 160)
            {
            symbol = new ImageView(new Image("160.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 170)
            {
            symbol = new ImageView(new Image("170.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 180)
            {
            symbol = new ImageView(new Image("180.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            if(score == 190)
            {
            symbol = new ImageView(new Image("190.png"));
            symbol.relocate(x,y);
            flaeche.hinzufuegen(symbol);
            }
            }
            if(score >= 200)
            {
            unsichtbarMachen();
            }
            }*/
        }
    }
}
