package board;
import java.awt.*;

public class GameBoardLayout {
    private int row;
    private int col;
    Color color;
    public static int tileSize = 50;

    public GameBoardLayout(int row, int col, Color color){
        this.row=row;
        this.col=col;
        this.color=color;
    }

    public void render(Graphics g) {
        int tileX = this.col * tileSize;
        int tileY = this.row * tileSize;
        g.setColor(this.color);
        g.fillRect(tileX, tileY, tileSize, tileSize);
    }
}
