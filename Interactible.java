import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Interactible {

    protected int tileX, tileY;
    protected final int WIDTH, HEIGHT;
    protected BufferedImage image;

    public Interactible(int tileX, int tileY, int width, int height) {

        this.tileX = tileX;
        this.tileY = tileY;
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    public void loadImages(String imagePath) {

        try {

            image = ImageIO.read(getClass().getResourceAsStream(imagePath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphic, PlayerMovable player, InteractivePanel gamePanel) {

        graphic.drawImage(image, tileX * InteractivePanel.getTileSize() - player.x + player.getDrawX(),
                tileY * InteractivePanel.getTileSize() - player.y + player.getDrawY(),
                InteractivePanel.getTileSize() * WIDTH,
                InteractivePanel.getTileSize() * HEIGHT, null);
    }
}
