import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner; 

public class Cards implements MouseMotionListener {

    private int x, y;
    private ImageIcon cardtest;
    private int health = 0, attack = 0;
    private int ambrosiaCost = 0;
    private int ambrosiaGive = 0;
    private int vulnerableStacks = 0;
    private int originalX, originalY;
    private int selectionIndex = -1;
    private Scanner filesc;
    private int cardDataPoints = 15;  // the number of different pieces of data stored in a card template
    private String cardDataArray[] = new String[cardDataPoints];
    private int rand; // index of a randomly chosen card
    private int count = 0;
    private String[] description;
    private String name;
    public static final int CARDWIDTH = 120;
    public static final int CARDHIGHT = 220;
    
    
    public Cards(int x, int y) {
        cardtest = new ImageIcon("card.png");

        this.x = x;
        this.y = y;
        this.originalX = x;
        this.originalY = y;

        // randomly generate a card
        rand = (int) (Math.random() * 4 + 1);

        try {
            // get card details from file
            filesc = new Scanner (new File("cards/card00"+ rand +".txt"));
            
            while (filesc.hasNextLine()) {                                    
                cardDataArray[count] = (filesc.nextLine()); 
                count++;	
            }	
        }
        catch(Exception e) {
            System.out.print(e);
        }

        System.out.println("card: " + rand);
        //for(int i = 0; i < cardDataArray.length; i++) {
            //System.out.println(cardDataArray[i]);
        //}
        
        // assign the data from the file to variables in the class
        description = cardDataArray[1].split(":");
        name = cardDataArray[4].substring(5);
        attack = Integer.parseInt(cardDataArray[5].substring(7));
        ambrosiaCost = Integer.parseInt(cardDataArray[6].substring(13));
        ambrosiaGive = Integer.parseInt(cardDataArray[7].substring(13));
        vulnerableStacks = Integer.parseInt(cardDataArray[12].substring(17));
    }

    public Cards(int x, int y, int health, int attack, int originalX, int originalY, int selectionIndex) {

        cardtest = new ImageIcon("card.png");

        this.x = x;
        this.y = y;
        this.health = health;
        this.attack = attack;
        this.originalX = originalX;
        this.originalY = originalY;
        this.selectionIndex = selectionIndex;
    }

    public Cards makeCopy() {

        return new Cards(x, y, health, attack, originalX, originalY, selectionIndex);
    }

    public boolean isInside(int mx, int my) {
        return (x - 10 < mx && y - 10 < my && x + 110 > mx && y + 210 > my);
    }

    public void setHealth(int newHealth) {

        health = newHealth;
    }

    public int getHealth() {

        return health;
    }

    public int getAttack() {

        return attack;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOriginalX() {
        return originalX;
    }

    public int getOriginalY() {
        return originalY;
    }

    public int getAmbrosiaCost() {
        return ambrosiaCost;
    }

    public int getAmbrosia() {
        return ambrosiaGive;
    }

    public int getVulnerableStacks() {
        return vulnerableStacks;
    }
    public int getSelectionIndex() {
        return selectionIndex;
    }

    public void setSelectionIndex(int index) {
        selectionIndex = index;
    }

    public void myDraw(Graphics g) {
        // enables antialiasing on the font which makes it look way better
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // cardtest.paintIcon(null, g, x - 60, y - 100);
        g.drawImage(cardtest.getImage(), x, y, null);

        // Draw the health and attack values
        g.setColor(Color.BLACK);
        g.setFont(Main.Lexend12);
        
        // write the description of the card
        count = 50;
        for (String line : description) {    
            //System.out.println("count: " + count);
            g.drawString(line, getX() + 15, getY() + count);
            count = count+20;
        }

        if (ambrosiaCost > 0) {
            g.drawString(""+ambrosiaCost, getX() + 8, getY() + 17);

        }

        //g.drawString(description[0], getX() + 15, getY() + 50);
        //g.drawString("Attack: " + getAttack(), getX() + 15, getY() + 70);
    }

    public void mouseDragged(MouseEvent e) {
        /*
         * * x = e.getX();
         * y = e.getY();
         * System.out.println(x);
         * System.out.println(y);
         * 
         * this.myDraw(g);
         */
    }

    public void mouseMoved(MouseEvent e) {
    }

    public Image getImage() {
        return cardtest.getImage();
    }
}