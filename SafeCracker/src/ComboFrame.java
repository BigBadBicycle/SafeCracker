import java.awt.Dimension;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboFrame extends JFrame {
	
	private static final int FRAME_SIZE = 700;;
	
	public ComboFrame() {
		
		try {
			AssetLoader.LoadAssets();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_SIZE,FRAME_SIZE);
		this.setResizable(false);
		
		JLabel test = new JLabel(AssetLoader.COMBO_LOCK_I);
		this.add(test);
		
		
		this.setVisible(true);
	}

}
