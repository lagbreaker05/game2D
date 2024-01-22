package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;

public class OBJ_Lightning_Boots extends SuperObject{

	private boolean isOn = false, allowedToUse = true;
	private int abilityDuration = 180, cooldown = 300; // counting in frames (60 frames per sec)
	private int passedFrames = 0;
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
			if(OBJ_Lightning_Boots.class.equals(player.inventory.slots[0][player.inventory.selected].superObject.getClass()) && player.readyToPickUp && allowedToUse) {

				isOn=true;
				allowedToUse = false;
				player.speed = 7;
				/*
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
		else player.speed=4;*/}
			
	}
	
	public void timerAbility(Player player){
		if(isOn) {
			if(passedFrames<abilityDuration) {
				passedFrames++;
			}
			else {
				player.speed = 4;
				passedFrames = 0;
				isOn=false;
				
			}
		}
		else if(!isOn && !allowedToUse) {
			if(passedFrames<cooldown) {
				passedFrames++;
			}
			else {
				passedFrames=0;
				allowedToUse = true;
				
			}
		}
		
		
	}
	
}
