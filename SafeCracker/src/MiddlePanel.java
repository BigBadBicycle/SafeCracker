

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiddlePanel extends JPanel{
	
	public MiddlePanel() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(this.getWidth(), 575));
		this.add(new JLabel(AssetLoader.COMBO_LOCK_I),BorderLayout.CENTER);
		this.add(new JLabel(AssetLoader.RED_ARROW),BorderLayout.NORTH);
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(AssetLoader.SAFE.getImage(),0,0,null);
		
	}

}
