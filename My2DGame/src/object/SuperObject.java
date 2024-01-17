package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import entity.Player;
import main.GamePanel;
import main.UtilityTool;

public class SuperObject {

	
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	public boolean canBePickedUp = false;
	UtilityTool uTool = new UtilityTool();
	
	
	
	public void draw(Graphics2D g2, GamePanel gp) {
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY +gp.player.screenY;
		
		if(worldX + gp.tileSize >gp.player.worldX - gp.player.screenX && 
		   worldX- gp.tileSize< gp.player.worldX +gp.player.screenX &&
		   worldY+ gp.tileSize >gp.player.worldY - gp.player.screenY && 
		   worldY- gp.tileSize< gp.player.worldY +gp.player.screenY) {
		g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null );
		}
	}
	
	public void uniqueObjectsiInteraction(Player player) {
		
		
	}
public void uniqueObjectsiAbility(Player player) {
		
		
	}
	protected int searchKeyInInventory(Player player) {
		int index = 999;
		for(int i = 0; i<player.inventory.cols; i++) {
			
				if(player.inventory.slots[0][i].superObject!=null)
			if(OBJ_Key.class.equals(player.inventory.slots[0][i].superObject.getClass()) ) {
				index = i;
				break;
			}
		}
		return index;
	}
	protected boolean isSelectedAKey(Player player) {	
		if(player.inventory.slots[0][player.inventory.selected].superObject!=null)
			if(OBJ_Key.class.equals(player.inventory.slots[0][player.inventory.selected].superObject.getClass()) ) {
				return true;
				
			}
			else return false;
		else return false;		
	}
}
