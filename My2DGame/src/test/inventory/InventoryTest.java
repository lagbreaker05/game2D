package test.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import inventory.Inventory;
import object.OBJ_Key;

class InventoryTest {

	 private Inventory inventory;
	 private OBJ_Key key;
	
	@Before
	public void setUp() {
		inventory = new Inventory();
		key = new OBJ_Key();
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	

}
