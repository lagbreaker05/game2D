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
		obj[0].worldX = 23*gp.tileSize;
		obj[0].worldY = 7 * gp.tileSize;
		
		obj[1] = new OBJ_Key();
		obj[1].worldX = 23 *gp.tileSize;
		obj[1].worldY = 40*gp.tileSize;
		
		obj[2] = new OBJ_Key();
		obj[2].worldX = 38 *gp.tileSize;
		obj[2].worldY = 8*gp.tileSize;
		
		obj[3] = new OBJ_Door();
		obj[3].worldX = 10 *gp.tileSize;
		obj[3].worldY = 11*gp.tileSize;
		
		obj[4] = new OBJ_Door();
		obj[4].worldX = 8 *gp.tileSize;
		obj[4].worldY = 28*gp.tileSize;
		
		obj[5] = new OBJ_Door();
		obj[5].worldX = 12 *gp.tileSize;
		obj[5].worldY = 22*gp.tileSize;
		
		obj[6] = new OBJ_Chest();
		obj[6].worldX = 10 *gp.tileSize;
		obj[6].worldY = 7*gp.tileSize;
		
		obj[7] = new OBJ_Key();
		obj[7].worldX = 23 *gp.tileSize;
		obj[7].worldY = 24*gp.tileSize;
		
		obj[8] = new OBJ_Key();
		obj[8].worldX = 23 *gp.tileSize;
		obj[8].worldY = 23*gp.tileSize;
		
		
		
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
