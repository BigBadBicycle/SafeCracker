
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AssetLoader{
	
	public static ImageIcon SAFE;
	public static ImageIcon COMBO_LOCK_I;
	public static ImageIcon RED_ARROW;
	
	public static void LoadAssets() throws IOException{		
		
		ImageIcon t1 = new ImageIcon(ImageIO.read(AssetLoader.class.getResource("res/images/lock.png")));
		ImageIcon t2 = new ImageIcon(ImageIO.read(AssetLoader.class.getResource("res/images/arrow.png")));
		ImageIcon t3 = new ImageIcon(ImageIO.read(AssetLoader.class.getResource("res/images/safe.png")));
		
		//=======================
		//Altered image
		Image ti1 = t1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		Image ti2 = t2.getImage().getScaledInstance(75,200 ,Image.SCALE_SMOOTH);
		Image ti3 = t3.getImage().getScaledInstance(ComboFrame.getFrameSize(), 575, Image.SCALE_SMOOTH);
		
		COMBO_LOCK_I = new ImageIcon(ti1);
		RED_ARROW = new ImageIcon(ti2);
		SAFE = new ImageIcon(ti3);
	}

}
;