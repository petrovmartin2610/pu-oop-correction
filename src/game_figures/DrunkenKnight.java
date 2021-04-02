package game_figures;
import board.GameBoardLayout;
import java.awt.*;

/**
 * @author Martin Petrov
 * Клас, дефиниращ характеристиките за Drunken Knight фигурките, негов конструктор и рендериращ метод
 */
public class DrunkenKnight extends GameBoardLayout{
    private int AP;
    private int DP;
    private int MP;
    private int S;
    Color color;


    public DrunkenKnight(int row, int col, int AP, int DP, int MP, int S, Color color){
        super(row,col,color);
        this.AP=AP;
        this.DP=DP;
        this.MP=MP;
        this.S=S;
        this.color=color;
    }

    public void render(Graphics g) {
        g.drawString("DrKn",10,10);
        g.setColor(color);
    }
}
