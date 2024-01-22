package inventory;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;
import main.GamePanel;
import main.KeyHandler;

public class InventoryManager {

	Inventory inventory;
	BufferedImage imgSelectedSlot, imgNotSelectedSlot;
	GamePanel gp;
	
	
	private void prepareImages() {
		try {
			imgNotSelectedSlot = ImageIO.read(getClass().getResourceAsStream("/inventory/selected.png"));
			imgSelectedSlot = ImageIO.read(getClass().getResourceAsStream("/inventory/notselected.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//checks and, if necessary, executes whether the abilities of items in the inventory interact with the timer.
	public void checkTimers(Player player) {
		for(int i = 0; i<inventory.cols; i++) {
			if(inventory.slots[0][i].contains()) {
				inventory.slots[0][i].superObject.timerAbility(player);
			}
		}
	}
	
	public InventoryManager(Inventory inventory, GamePanel gp) {
		this.inventory = inventory;
		this.gp = gp;
		prepareImages();
	}
	
	public void draw(Graphics2D g2, boolean isActive) {
		
		if(isActive == true) {
			drawActiveInventory(g2);
		}
		else {
			drawInactiveInventory(g2);
		}
		
	}
	
	private void drawActiveInventory( Graphics2D g2) {
	    
		
		
	}
	
	private void drawInactiveInventory(Graphics2D g2) {
		
		int screenX = 12, screenY = 12;
		int identation = 12;
		int objectIdentation = 4;
		for(int i = 0; i<inventory.cols; i++) {
			if(i == inventory.selected) {
				g2.drawImage(imgSelectedSlot, screenX, screenY, inventory.slotSize ,inventory.slotSize, null );
			}
			else {
				g2.drawImage(imgNotSelectedSlot, screenX, screenY, inventory.slotSize ,inventory.slotSize, null );
			}
			
			if(inventory.slots[0][i].superObject!=null)
			if(inventory.slots[0][i].contains()==true) {
			g2.drawImage(inventory.slots[0][i].getImage(), screenX+objectIdentation, screenY, gp.tileSize ,gp.tileSize, null );
			}
			screenX+=identation+inventory.slotSize;
		}
		
	}
	
	
	
}
