package object;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;

public class OBJ_Door extends SuperObject{
	String path="/objects/opened_door.png";
	public OBJ_Door() {
		
		name = "Door";
		collision = true;
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
}
	 public void  uniqueObjectsiInteraction(Player player) {
		 if(collision==true)
		 {
			 if(isSelectedAKey(player)) {
				 try {
						image = ImageIO.read(getClass().getResourceAsStream(path));
					} catch (IOException e) {
						e.printStackTrace();
					}
					 this.collision = false;
					 player.inventory.deleteItem(player.inventory.selected);
			 }
		 
		 }
	 }
	 
	 
}