package entity.npc;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;
import main.UtilityTool;

public class NPC extends Entity {
	
	GamePanel gp = new GamePanel();
	String path;
	
	
	
	private void setPath(String path) {
		this.path = path;
	}
	 
	public BufferedImage setup(String imageName) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage scaledImage = null;
		
		try {
			scaledImage = ImageIO.read(getClass().getResourceAsStream(path+imageName+".png"));
			scaledImage = uTool.scaleImage(scaledImage, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scaledImage;
	}
	

}
