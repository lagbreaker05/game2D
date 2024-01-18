package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Lightning_Boots;
import object.SuperObject;

public class ObjectsManipulator {

	private int size = 10;
	public SuperObject obj[] = new SuperObject[size];
	GamePanel gp;
	public ObjectsManipulator(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		obj[0] = new OBJ_Key();
		obj[0].worldX = 20*gp.tileSize;
		obj[0].worldY = 9 * gp.tileSize;
		
		obj[1] = new OBJ_Key();
		obj[1].worldX = 25 *gp.tileSize;
		obj[1].worldY = 40*gp.tileSize;
		
		obj[2] = new OBJ_Door();
		obj[2].worldX = 25 *gp.tileSize;
		obj[2].worldY = 36*gp.tileSize;
		
		
		obj[3] = new OBJ_Chest();
		obj[3].worldX = 23 *gp.tileSize;
		obj[3].worldY = 37*gp.tileSize;
		
		
		
		
				}
	
	public int searchFreeCell() {
		for(int i =0; i<size; i++) {
			if(obj[i]!=null) {
				return i;
			}
			
		}
		return -1;
	}
	
	public void setCoordinates(int index, int x, int y) {
		if(index>=0&&index<size) {
		obj[index].worldX = x;
		obj[index].worldY = y;
		}
	}
	
}
