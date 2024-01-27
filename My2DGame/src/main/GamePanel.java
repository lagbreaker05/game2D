package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import inventory.Inventory;
import inventory.InventoryManager;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

	//SCREEN SETTINGS
	final int originalTileSize = 16; //16*16 tile
	final int scale = 3;
	public final int tileSize = originalTileSize *scale; //48*48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize*maxScreenCol; //768 px
	public final int screenHeight = tileSize*maxScreenRow; // 576 px
	
	//WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWirdth = tileSize*maxWorldCol;
	public final int worldHeight = tileSize *maxWorldRow;
	
	//FPS
	int FPS = 60;
	public double currentTime=System.nanoTime();
	
	TileManager tileM = new TileManager(this);
	Thread gameThread;
	
	public KeyHandler keyH = new KeyHandler();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public Player player = new Player(this, keyH);
	
	public UI ui = new UI(this);
	public InventoryManager invManager = new InventoryManager(player.inventory, this, ui);
	
	
	public ObjectsManipulator objectsManipulator = new ObjectsManipulator(this);
	
	
	public void setupGame() {
		
		objectsManipulator.setObject();
	}
	public GamePanel()
	{
		keyH.setPlayer(player);
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		double remainingTime;
		while(gameThread != null) {
			
			//long currentTime = System.nanoTime();
             
			update();
			
			repaint();
			
			
			try {
				remainingTime = nextDrawTime - System.nanoTime();
				remainingTime/=1000000;
				if(remainingTime <0)
				{
					remainingTime = 0;
				}
				Thread.sleep((long)remainingTime);
				nextDrawTime +=drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update()
	{
		
		player.update();
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		tileM.draw(g2);
		
		for(int i = 0; i<objectsManipulator.obj.length; i++) {
			if(objectsManipulator.obj[i] != null) {
				objectsManipulator.obj[i].draw(g2, this);
			}
		}
		
	    player.draw(g2);
		invManager.draw(g2, false);
		
		
		g2.dispose();
	}
}
