package board;
import game_figures.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * @author Martin Petrov
 * Клас, дефиниращ всички обекти и методи, които се използват от приложението (инициализиране и рисуване на игрална дъска и фигурки);
 * съдържащ правила за определяне на ходове и разпределяне на фигурки по игралната дъска
 */
public class GameBoardRenderer extends JFrame implements MouseListener {
    private GameBoardLayout[][] gameBoardTiles;                                  //обект масив съдържащ всички игрални полета и игрови фигурки
    public int row=0;
    public int col=0;
    Color color = null;
    public boolean player1HasPlacedTheFigures=false;                             //булева променлива, използвана за определяне дали единия от играчите е сложил фигурките си по дъската
    public boolean figurePlacementHasEnded=false;                                //булева променлива, използвана за определяне дали всички играчи са разпределили фигурките си


    /**
     * Инициализация на фигурките за Player 1
     */
    //PLAYER 1 FIGURES------------------------------------------------------------------------------------------------//
    DrunkenKnight Pl1DK1 = new DrunkenKnight(row,col,5,5,5,5,Color.BLUE);
    DrunkenKnight Pl1DK2 = new DrunkenKnight(row,col,5,5,5,5,Color.BLUE);
    DrunkenKnight Pl1DK3 = new DrunkenKnight(row,col,5,5,5,5,Color.BLUE);
    MagicCat Pl1MCat1 = new MagicCat(row,col,8,5,10,1,Color.RED);
    MagicCat Pl1MCat2 = new MagicCat(row,col,8,5,10,1,Color.RED);
    MagicCat Pl1MCat3 = new MagicCat(row,col,8,5,10,1,Color.RED);
    RecklessCanibal Pl1DRCan1 = new RecklessCanibal(row,col,4,6,8,10,Color.BLACK);
    RecklessCanibal Pl1DRCan2 = new RecklessCanibal(row,col,4,6,8,10,Color.BLACK);
    RecklessCanibal Pl1DRCan3 = new RecklessCanibal(row,col,4,6,8,10,Color.BLACK);
    SandTurtle Pl1STurt1 = new SandTurtle(row,col,5,10,1,4,Color.GREEN);
    SandTurtle Pl1STurt2 = new SandTurtle(row,col,5,10,1,4,Color.GREEN);
    SandTurtle Pl1STurt3 = new SandTurtle(row,col,5,10,1,4,Color.GREEN);
    SofisticatedSam Pl1SSam1 = new SofisticatedSam(row,col,10,5,4,1,Color.GRAY);
    SofisticatedSam Pl1SSam2 = new SofisticatedSam(row,col,10,5,4,1,Color.GRAY);
    SofisticatedSam Pl1SSam3 = new SofisticatedSam(row,col,10,5,4,1,Color.GRAY);
    DogEatingBug Pl1DEBug1 = new DogEatingBug(row,col,10,2,8,5,Color.WHITE);
    DogEatingBug Pl1DEBug2 = new DogEatingBug(row,col,10,2,8,5,Color.WHITE);
    DogEatingBug Pl1DEBug3 = new DogEatingBug(row,col,10,2,8,5,Color.WHITE);
    //----------------------------------------------------------------------------------------------------------------//


    /**
     * Инициализация на фигурките за Player 2
     */
    //PLAYER 2 FIGURES------------------------------------------------------------------------------------------------//
    DrunkenKnight Pl2DK1 = new DrunkenKnight(row,col,5,5,5,5,Color.WHITE);
    DrunkenKnight Pl2DK2 = new DrunkenKnight(row,col,5,5,5,5,Color.WHITE);
    DrunkenKnight Pl2DK3 = new DrunkenKnight(row,col,5,5,5,5,Color.WHITE);
    MagicCat Pl2MCat1 = new MagicCat(row,col,8,5,10,1,Color.GRAY);
    MagicCat Pl2MCat2 = new MagicCat(row,col,8,5,10,1,Color.GRAY);
    MagicCat Pl2MCat3 = new MagicCat(row,col,8,5,10,1,Color.GRAY);
    RecklessCanibal Pl2DRCan1 = new RecklessCanibal(row,col,4,6,8,10,Color.GREEN);
    RecklessCanibal Pl2DRCan2 = new RecklessCanibal(row,col,4,6,8,10,Color.GREEN);
    RecklessCanibal Pl2DRCan3 = new RecklessCanibal(row,col,4,6,8,10,Color.GREEN);
    SandTurtle Pl2STurt1 = new SandTurtle(row,col,5,10,1,4,Color.BLACK);
    SandTurtle Pl2STurt2 = new SandTurtle(row,col,5,10,1,4,Color.BLACK);
    SandTurtle Pl2STurt3 = new SandTurtle(row,col,5,10,1,4,Color.BLACK);
    SofisticatedSam Pl2SSam1 = new SofisticatedSam(row,col,10,5,4,1,Color.RED);
    SofisticatedSam Pl2SSam2 = new SofisticatedSam(row,col,10,5,4,1,Color.RED);
    SofisticatedSam Pl2SSam3 = new SofisticatedSam(row,col,10,5,4,1,Color.RED);
    DogEatingBug Pl2DEBug1 = new DogEatingBug(row,col,10,2,8,5,Color.BLUE);
    DogEatingBug Pl2DEBug2 = new DogEatingBug(row,col,10,2,8,5,Color.BLUE);
    DogEatingBug Pl2DEBug3 = new DogEatingBug(row,col,10,2,8,5,Color.BLUE);
    //----------------------------------------------------------------------------------------------------------------//

    /**
     * Метод, определящ размера на игралната дъска и задаващ цветовете на отделните поленца
     */
    public void gameBoardRender() {
        this.gameBoardTiles = new GameBoardLayout[12][12];         //определяне размерността на обект масива

        for (row = 0; row < 12; row++) {
            if(row%2==0) {
                for (col = 0; col < 12; col++) {
                    if(col%2==0) {
                        this.gameBoardTiles[row][col] = new GameBoardLayout(row, col, Color.YELLOW);
                    } else {
                        this.gameBoardTiles[row][col] = new GameBoardLayout(row, col, Color.ORANGE);
                    }
                }
            } else {
                for (col = 0; col < 12; col++) {
                    if(col%2==0) {
                        this.gameBoardTiles[row][col] = new GameBoardLayout(row, col, Color.ORANGE);
                    } else {
                        this.gameBoardTiles[row][col] = new GameBoardLayout(row, col, Color.YELLOW);
                    }
                }
            }
        }
        /**
         * характеристики на прозореца в който се помещава играта
         */
            this.setSize(800, 800);
            this.setVisible(true);
            this.setTitle("Egyptian Game");
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.addMouseListener(this);
        }


//метод рисуващ игралната дъска
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 12; col++) {
                GameBoardLayout gbl1 = (GameBoardLayout) this.getBoardTile(row, col);
                gbl1.render(g);
            }
        }
    }

    //метод взимащ отделен обект от обект-масива съхраняващ игралната дъска и фигурките
    private Object getBoardTile(int row, int col) {
        return this.gameBoardTiles[row][col];
    }

    //метод взимащ координатите на отделните обекти
    private int tileCoordinates(int coordinates) {
        return coordinates / GameBoardLayout.tileSize;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        //TODO: не успях да дебъгна проблема с фигурките които се визуализират ''бели'', а не със съответно зададения им цвят
            System.out.println("PLAYER 1:");
            System.out.println("Choose a square of the first two upper rows you'd like to place your figures in with the following order: " +
                    "Drunken Knight, Magic Cat, Reckless Canibal, Sand Turtle, Sofisticated Sam");
            int row = this.tileCoordinates(e.getY());
            int col = this.tileCoordinates(e.getX());

            System.out.println("row-->" + row);
            System.out.println("col-->" + col);

        /**метод, отчитащ реда на разполагане на фигурите на съответните играчи по игралното поле с помощ на булеви променливи и определящ игрови полета от два възможни реда за
         * слагане на фигурите на всеки играч, като Player 1 разполага с горните два реда да разположи фигурите си, а Player 2 - само с долните два реда
         */
        if (player1HasPlacedTheFigures == false) {
            if (row > 1 || col > 7) {
                System.out.println("You can't choose a column bigger than 7 and/or a row bigger than 2 since figures would exit the allowed space, try again with lower numbers");
            } else {
                this.gameBoardTiles[row][col] = Pl1DK1;
                this.gameBoardTiles[row][col + 1] = Pl1MCat1;
                this.gameBoardTiles[row][col + 2] = Pl1DRCan1;
                this.gameBoardTiles[row][col + 3] = Pl1STurt1;
                this.gameBoardTiles[row][col + 4] = Pl1SSam1;
                this.repaint();
                player1HasPlacedTheFigures = true;
            }
        } else {
            System.out.println("PLAYER 2:");
            System.out.println("Choose a square of the first two lower rows you'd like to place your figures in with the following order: " +
                    "Drunken Knight, Magic Cat, Reckless Canibal, Sofisticated Sam, Dog Eating Bug");
            row = this.tileCoordinates(e.getY());
            col = this.tileCoordinates(e.getX());

            System.out.println("row-->" + row);
            System.out.println("col-->" + col);

            if (row < 6 || col > 7) {
                System.out.println("You can't choose a column bigger than 7 and/or a row lower than 6 since figures would exit the allowed space, try again with lower numbers");
            } else {
                this.gameBoardTiles[row][col] = Pl2DK1;
                this.gameBoardTiles[row][col + 1] = Pl2MCat1;
                this.gameBoardTiles[row][col + 2] = Pl2DRCan1;
                this.gameBoardTiles[row][col + 3] = Pl2SSam1;
                this.gameBoardTiles[row][col + 4] = Pl2DEBug1;
                this.repaint();
                figurePlacementHasEnded=true;
            }
        }

        /**метод, отчитащ дали е приключило разпределянето на фигурите и ако да хвърля зар да провери кой играч е на ход
         */
        if(figurePlacementHasEnded==true){
            Random identifier = new Random();
            int player1DiceRoll1=identifier.nextInt(6);
            int player2DiceRoll2=identifier.nextInt(6);
            if(player1DiceRoll1>player2DiceRoll2){
                System.out.println("It's Player 1's turn to play");
            } else {
                System.out.println("It's Player 2's turn to play");
            }
        }


    }






//излишни методи
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
