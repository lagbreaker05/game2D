package inventory;

import object.OBJ_Chest;
import object.OBJ_Key;
import object.SuperObject;

public class Inventory {

	public final int rows = 3;
	public final int cols = 5;
	public int selected = 0;
	public final int slotSize = 56; //px
	public Slot[][] slots = new Slot[3][5];
	
	
	public Inventory() {
		
		for(int i = 0; i<rows; i++)
		{
			for(int j = 0; j<cols; j++) {
				slots[i][j] = new Slot();
			}
		}
		
	}
	public boolean addItem(SuperObject obj) {
		boolean found = false;
		for(int i = 0; i<cols&&!found ;i++) {
			if(!slots[0][i].contains()) {
				slots[0][i].addObject(obj);
				found = true;
			}
		}
		return found;
		
	}
	public void deleteItem(int index) {
		slots[0][index].setContains(false);
		slots[0][index].superObject=null;
		
	}
	
	
}
