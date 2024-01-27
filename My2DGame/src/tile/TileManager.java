package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[] [];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[10];
		
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		
		getTileImage();
		
			loadMap("/maps/world_01.csv");
		
	}
	
	public void loadMap(String filePath) {
	    try {
	        InputStream is = getClass().getResourceAsStream(filePath);
	        Scanner scanner = new Scanner(new InputStreamReader(is));

	        int row = 0;

	        while (scanner.hasNextLine() && row < gp.maxWorldRow) {
	            String line = scanner.nextLine();
	            String[] numbers = line.split(",");

	            for (int col = 0; col < Math.min(numbers.length, gp.maxWorldCol); col++) {
	                int num = Integer.parseInt(numbers[col].trim()); // trim to remove leading/trailing whitespaces

	                mapTileNum[col][row] = num;
	            }

	            row++;
	        }

	        scanner.close();

	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	}
	
	public void getTileImage()
	{
		    setup(0, "grass", false);
			setup(1, "sand", false);
			setup(2, "tree", true);
			setup(3, "wall", true);
			setup(4, "wooden_plank", false);
			setup(5, "dirt", false);
	}
	
	public void setup(int index, String imagePath, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
		
		tile[index] = new Tile();
		try {
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imagePath+".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics2D g2)
	{
		
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while(worldCol < gp.maxWorldCol && worldRow <gp.maxWorldRow)
		{
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY +gp.player.screenY;
			
			if(worldX + gp.tileSize >gp.player.worldX - gp.player.screenX && 
			   worldX- gp.tileSize< gp.player.worldX +gp.player.screenX &&
			   worldY+ gp.tileSize >gp.player.worldY - gp.player.screenY && 
			   worldY- gp.tileSize< gp.player.worldY +gp.player.screenY) {
			g2.drawImage(tile[tileNum].image, screenX, screenY, null );
			}
			
			worldCol++;
			
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;	
			}
		}
		
	}
	
}
