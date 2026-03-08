

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiddlePanel extends JPanel{
	
	private int xLock = 204;
	private int yLock = 200;
	
	private ComboLock lock;
	private int currentTick = 0;
	
	double degrees = 0;
	private final double degreePerTick = 8.825;
	
	public MiddlePanel(ComboLock lock) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(this.getWidth(), 575));
		this.lock = lock;
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(AssetLoader.SAFE.getImage(),0,0,null);
		
		g2D.drawImage(AssetLoader.RED_ARROW.getImage(), 313, 0,null);
		
		
		g2D.rotate(Math.toRadians(degrees), xLock + AssetLoader.COMBO_LOCK_I.getImage().getWidth(null)-160, yLock + AssetLoader.COMBO_LOCK_I.getImage().getHeight(null)-160);
		
		g2D.drawImage(AssetLoader.COMBO_LOCK_I.getImage(), xLock, yLock, null);
		
	}
	
	public void rotateByTick(boolean isRight) {
		int change = lock.getcurrentNumber()-currentTick;
		System.out.println("change "+change);
		int temp = 1;
		if(isRight) {
			temp*=-1;
		}

		degrees += Math.abs(change)*temp*degreePerTick;
		currentTick = lock.getcurrentNumber();
		this.repaint();
	}
	
	public void resetDegrees() {
		degrees = 0;
		this.repaint();
		currentTick = lock.getcurrentNumber();
	}

}
