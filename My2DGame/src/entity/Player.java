package entity;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import inventory.Inventory;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	public GamePanel gp;
	KeyHandler keyH;
	public Inventory inventory;
	public boolean readyToPickUp = false;
	private boolean readyToPickUp2 = true;
	
	public final int screenX;
	public final int screenY;
	
	public boolean pressedOnce =false;
	private boolean wasPressed = false;
	
	public Player(GamePanel gp, KeyHandler keyH)
	{
		this.gp = gp;
		this.keyH = keyH;
		inventory = new Inventory();
		screenX=gp.screenWidth/2 - (gp.tileSize/2);
		screenY=gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.height = 32;
		solidArea.width = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues()
	{
		worldX = gp.tileSize*23;
		worldY = gp.tileSize*21;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage()
	{
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void update()
	{
		int objIndex = 999;
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
				|| keyH.rightPressed == true) {
			
		
		if(keyH.upPressed == true)
		{
			direction = "up";
			collisionOn = false;
			gp.cChecker.checkTile(this); 
			objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject( objIndex);
			if(collisionOn == false) worldY -= speed;
		}
		if(keyH.downPressed == true)
		{
			direction = "down";
			collisionOn = false;
			gp.cChecker.checkTile(this);
			objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject( objIndex);
			if(collisionOn == false) worldY+=speed;
		}
		if(keyH.leftPressed == true)
		{
			direction = "left";
			collisionOn = false;
			gp.cChecker.checkTile(this);
     		objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			if(collisionOn == false) worldX-= speed;
		}
		if(keyH.rightPressed == true)
		{
			direction = "right";
			collisionOn = false;
			gp.cChecker.checkTile(this);
			objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject( objIndex);
			if(collisionOn == false) worldX +=speed;
		}
		
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum ==1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		}
		if(keyH.rightPressed == false && keyH.leftPressed == false && keyH.downPressed == false && keyH.upPressed == false ) {
			objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject( objIndex);
			}
	
	}
	public void pickUpObject(int objIndex) {
		
		if(!wasPressed) {
		if(objIndex != 999 && gp.objectsManipulator.obj[objIndex].canBePickedUp==true && this.readyToPickUp) {
			
			if(inventory.addItem(gp.objectsManipulator.obj[objIndex]));
			gp.objectsManipulator.obj[objIndex]=null;
		}
		 if(objIndex != 999 &&this.readyToPickUp) {
			 if(gp.objectsManipulator.obj[objIndex]!=null)
			gp.objectsManipulator.obj[objIndex].uniqueObjectsiInteraction(this);
		}
		 if(this.readyToPickUp) {
			 if(inventory.slots[0][inventory.selected]!=null)
			 if(inventory.slots[0][inventory.selected].contains() == true)
			inventory.slots[0][inventory.selected].superObject.uniqueObjectsiAbility(this);
			 
			
		}
		 wasPressed=true;
		}
		
		if(this.readyToPickUp) {
			if(readyToPickUp!=readyToPickUp2) {
				readyToPickUp2 = readyToPickUp;
				wasPressed = false;
			}
		}
		else
		{
			if(readyToPickUp!=readyToPickUp2) {
				readyToPickUp2 = readyToPickUp;
				wasPressed = false;
			}
		}
		
		
	}
	
	public void draw(Graphics2D g2)
	{		
		BufferedImage image = null;
		switch(direction)
		{
		case "up":
			if(spriteNum==1)
			{
				image = up1;
			}
			if(spriteNum ==2)
			{
				image = up2;
			}
			
			break;
		case "down":
			if(spriteNum==1)
			{
				image = down1;
			}
			if(spriteNum ==2)
			{
				image =  down2;
			}
			break;
		case "left":
			if(spriteNum==1)
			{
				image = left1;
			}
			if(spriteNum ==2)
			{
				image =  left2;
			}
			break;
		case "right":
			if(spriteNum==1)
			{
				image = right1;
			}
			if(spriteNum ==2)
			{
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
