package harrypotter.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import harrypotter.controller.GameControl;

public class AllDead extends JFrame implements ActionListener{
	GameControl Listener;
	 public AllDead() {
		 setExtendedState(MAXIMIZED_BOTH);
			setUndecorated(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			BufferedImage img = null;
			try {
				img =ImageIO.read(new File("Death.jpg"));		
				} catch (IOException e1) {
				e1.printStackTrace();
			}
			Image h = img.getScaledInstance(getSize().width, getSize().height, img.SCALE_SMOOTH);
			JLabel background= new JLabel(new ImageIcon(h));
			background.setSize(getSize());
			background.setVisible(true);
			this.setContentPane(background);
			JButton exit =new JButton();
			exit.setText("EXIT");
			exit.setBounds(getWidth()/2-200, getHeight()-60, 400, 50);
			getContentPane().add(exit);
			exit.addActionListener(this);
			repaint();
			revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn.getText().equals("EXIT")){
			Listener.onExit();
    			}
	}

	public static void main(String[]args) throws IOException{
		new AllDead();
	}
	public GameControl getListener() {
		return Listener;
	}

	public void setListener(GameControl listener) {
		Listener = listener;
	}

}
