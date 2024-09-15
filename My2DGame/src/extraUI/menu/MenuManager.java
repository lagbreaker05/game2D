package extraUI.menu;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class MenuManager {
  BufferedImage menu;
  GamePanel gp;
  int invWidth = 288, invHeight = 384;
  int invX;
  int invY;
  
  
  public MenuManager(GamePanel gp) {
	  this.gp = gp;
	  invX = (gp.screenWidth-invWidth)/2;
	   invY = (gp.screenHeight-invHeight)/2;
	   prepareImages();
  }
  
  private void prepareImages() {
	  
	  try {
		 menu = ImageIO.read(getClass().getResourceAsStream("/menu/menu.png"));
	  }catch(IOException e) {
		  e.printStackTrace();
	  }
  }
  
  
  
  
  public void drawMenu(Graphics2D g2) {
	  g2.drawImage(menu, invX, invY, invWidth ,invHeight, null );
	
  }
  
}
