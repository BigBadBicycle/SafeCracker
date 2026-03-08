
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ComboFrame extends JFrame implements ActionListener{
	
	private static final int FRAME_SIZE = 700;
	private final Font font = new Font("serif",Font.PLAIN, 10);
	
	private ComboLock lock;
	private int ts1 = 13;
	private int ts2 = 25;
	private int ts3 = 31;
	
	private JPanel bottomP;
	private MiddlePanel middleP;
	private JPanel topP;
	
	private JButton submit;
	private int buttonClicks = 0;
	
	private JLabel status;
	
	private JSlider slider;
	
	public ComboFrame() {
		
		//loads assets
		try {
			AssetLoader.LoadAssets();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lock = new ComboLock(ts1, ts2, ts3);
		
		//creates jComponents
		slider = new JSlider(1,40);
		status = new JLabel();
		submit = new JButton();
		bottomP = new JPanel();
		middleP = new MiddlePanel(lock);
		topP = new JPanel();
		
		slider.setValue(1);
		//slider.setPreferredSize(new Dimension(this.getWidth(), 50));
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setFont(font);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		status.setPreferredSize(new Dimension(50, 50));
		status.setFont(font);
		status.setText("Right ->");
		
		submit.setPreferredSize(new Dimension(50, 50));
		submit.setFocusable(false);
		submit.setBackground(Color.yellow);
		submit.addActionListener(this);

		bottomP.setLayout(new FlowLayout());
		bottomP.setBackground(new Color(156, 161, 160));
		bottomP.setPreferredSize(new Dimension(this.getWidth(), 75));
		
		topP.setLayout(new BorderLayout());
		topP.setPreferredSize(new Dimension(this.getWidth(), 50));
		topP.add(slider, BorderLayout.CENTER);
		topP.add(status,BorderLayout.WEST);
		topP.add(submit, BorderLayout.EAST);

		
		//creates JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(getFrameSize(),getFrameSize());
		this.setLayout(new BorderLayout());
		this.setResizable(false);
	
		this.add(topP, BorderLayout.NORTH);
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
		if(e.getSource().equals(submit)) {
			buttonClicks++;
			switch(buttonClicks) {
			case 1:
				lock.turnRight(slider.getValue());
				middleP.rotateByTick(true);
				slider.setValue(1);
				status.setText("<- Left");
				break;
			
			case 2:
				lock.turnLeft(slider.getValue());
				middleP.rotateByTick(false);
				slider.setValue(1);
				status.setText("Right ->");
				break;
				
			case 3:
				lock.turnRight(slider.getValue());
				middleP.rotateByTick(true);
				slider.setValue(1);
				status.setText("Open");
				break;
			case 4:
				if(lock.open()) {
					submit.disable();
					submit.setBackground(Color.green);
					status.setText("Unlocked");
				} else {
					try {
						wrong();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					buttonClicks = 0;
					middleP.resetDegrees();
					slider.setValue(1);
					status.setText("Right ->");
					submit.setBackground(Color.yellow);
				}
			}
		}
		
	}
	
	private void wrong() throws InterruptedException {
		submit.setBackground(Color.red);
		status.setText("WRONG");
		this.update(getGraphics());
		Thread.sleep(1000);
	}

}
