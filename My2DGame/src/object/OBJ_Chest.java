package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;

public class OBJ_Chest extends SuperObject{

	public OBJ_Chest() {
		name = "Chest";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
}
    public void uniqueObjectsiInteraction(Player player) {
		
    	if(isSelectedAKey(player)) {
			
    		player.inventory.deleteItem(player.inventory.selected);
    		player.inventory.addItem(new OBJ_Lightning_Boots());
		 }
	}
}
