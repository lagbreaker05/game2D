package inventory;

import java.awt.image.BufferedImage;

import object.SuperObject;

public class Slot {
	
	public SuperObject superObject;
	private boolean contains = false; 
	private int numOfObjects = 0;
	
	public void addObject (SuperObject superObject) {
		
		this.superObject = superObject;
		contains = true;
		
	}
	
	public boolean contains() {
		return contains;
	}
	public void setContains(boolean contains) {
		this.contains = contains;
	}

	public BufferedImage getImage() {
		return superObject.image;
	}

	
	
	

}
