
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ComboFrame extends JFrame implements ActionListener{
	
	private static final int FRAME_SIZE = 700;;
	
	private JPanel bottomP;
	private MiddlePanel middleP;
	
	private JSlider slider;
	
	public ComboFrame() {
		
		//loads assets
		try {
			AssetLoader.LoadAssets();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//creates jComponents
		slider = new JSlider(0,36);
		bottomP = new JPanel();
		middleP = new MiddlePanel();
		
		slider.setValue(0);
		slider.setPreferredSize(new Dimension(this.getWidth(), 50));
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		bottomP.setLayout(new FlowLayout());
		bottomP.setBackground(new Color(156, 161, 160));
		bottomP.setPreferredSize(new Dimension(this.getWidth(), 75));

		
		//creates JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(getFrameSize(),getFrameSize());
		this.setLayout(new BorderLayout());
		this.setResizable(false);
	
		this.add(slider, BorderLayout.NORTH);
		this.add(middleP);
		this.add(bottomP, BorderLayout.SOUTH);
		//this.add(sliderValue, BorderLayout.NORTH);
		
		this.setVisible(true);
	}

	public static int getFrameSize() {
		return FRAME_SIZE;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
