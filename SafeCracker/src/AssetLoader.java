
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AssetLoader{
	
	public static ImageIcon COMBO_LOCK_I;
	public static ImageIcon RED_ARROW;
	
	public static void LoadAssets() throws IOException{
		File IFile1 = new File("/Assets/images/Combination%20Lock%20PNG%20Images%20Transparent%20Background.png");
		File IFile2 = new File("/Assets/images/undefined.png");
		
		//===================================
		
		COMBO_LOCK_I = new ImageIcon(ImageIO.read(IFile1));
		RED_ARROW = new ImageIcon(ImageIO.read(IFile2));
	}

}
;