package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Player;
import inventory.Inventory;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed;
	public int typedNumber = 0;
	public boolean isEnterKeyPressed = false;
	
	Player player;
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	     
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		 
		
		if(code == KeyEvent.VK_W)
		{
			upPressed = true;
		}
		if(code == KeyEvent.VK_S)
		{
			downPressed = true;
		}
		if(code == KeyEvent.VK_A)
		{
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D)
		{
			rightPressed = true;
		}
		if(code == KeyEvent.VK_ENTER && !player.pressedOnce)
		{
			player.readyToPickUp = true;	
			player.pressedOnce = true;
			 System.out.println("printed");
			
		}
		
		
		
		
 //int code = e.getKeyCode();
	     
	     switch(code){
	    	 case KeyEvent.VK_1 :
	    		 player.inventory.selected = 0;
	    		 break;
	    	 case KeyEvent.VK_2:
	    		 player.inventory.selected = 1;
	    		 break;
	    	 case KeyEvent.VK_3:
	    		 player.inventory.selected = 2;
	    		 break;
	    	 case KeyEvent.VK_4:
	    		 player.inventory.selected = 3;
	    		 break;
	    	 case KeyEvent.VK_5:
	    		 player.inventory.selected = 4;
	    		 break;
	     }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W)
		{
			upPressed = false;
		}
		if(code == KeyEvent.VK_S)
		{
			downPressed = false;
		}
		if(code == KeyEvent.VK_A)
		{
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D)
		{
			rightPressed = false;
		}
		if(code == KeyEvent.VK_ENTER )
		{
			player.readyToPickUp = false;
			player.pressedOnce = false;
			 System.out.println("release");
			
		}
	}

}
