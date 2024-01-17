package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;

public class OBJ_Lightning_Boots extends SuperObject{

	private boolean isOn = false;
	public OBJ_Lightning_Boots() {
		name = "lightning_boots";
		canBePickedUp = true;
try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/lightning_boots.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void uniqueObjectsiAbility(Player player) {
		if(player.inventory.slots[0][player.inventory.selected].superObject!=null)
			if(OBJ_Lightning_Boots.class.equals(player.inventory.slots[0][player.inventory.selected].superObject.getClass()) && player.readyToPickUp) {

				if(isOn==false) {
				player.speed =6;
				isOn = true;
				}
				else
					{
					player.speed =4;
					isOn = false;
					}
			}
			else player.speed = 4;
		else player.speed=4;
			
	}
	
}
