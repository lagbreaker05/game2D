package inventory;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;
import main.GamePanel;
import main.KeyHandler;
import main.UI;

public class InventoryManager {

	public Inventory inventory;
	BufferedImage imgSelectedSlot, imgNotSelectedSlot;
	GamePanel gp;
	UI ui;
	int x = 12, y = 12;
	int identation = 12;
	int objectIdentation = 4;
	int fontSize = 16;
	Font font = new Font("SANS_SERIF", Font.BOLD, fontSize);
	
	
	
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
	
	public InventoryManager(Inventory inventory, GamePanel gp, UI ui) {
		this.inventory = inventory;
		this.gp = gp;
		this.ui = ui;
		prepareImages();
	}
	
	public void draw(Graphics2D g2, boolean isActive) {
		
		if(isActive == true) {
			drawActiveInventory(g2);
		}
		else {
			drawInactiveInventory(g2);
			drawCooldown(g2);
		}
		
	}
	
	private void drawActiveInventory( Graphics2D g2) {
	    
		
		
	}
	
	public void drawCooldown(Graphics2D g2) {
		
		int screenX = x + inventory.slotSize-fontSize+4, screenY = y + inventory.slotSize-6;
		
		for(int i = 0; i<inventory.cols; i++) {
			
			if(inventory.slots[0][i].contains())
			if(!inventory.slots[0][i].superObject.allowedToUse&&!inventory.slots[0][i].superObject.isOn) {
				g2.drawString(Integer.toString(inventory.slots[0][i].superObject.getCooldown()+1), screenX, screenY);
			}
			screenX+=identation+inventory.slotSize;
			
		}
		
	}
	
	private void drawInactiveInventory(Graphics2D g2) {
		
		int screenX = x, screenY = y;
		
		
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
