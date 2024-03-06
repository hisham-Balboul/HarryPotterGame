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

public class Victory extends JFrame implements ActionListener{
	JButton next;
	GameControl listener;
    public Victory(){
    	setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		BufferedImage img = null;
		try {
			img =ImageIO.read(new File("vic2.jpg"));		
			} catch (IOException e1) {
			// TODO Auto-generated catch block
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
			listener.onExit();
    	this.dispose();}
	}
	public GameControl getListener() {
		return listener;
	}
	public void setListener(GameControl listener) {
		this.listener = listener;
	}
	public static void main(String[] args) throws IOException {
		new Victory();
	}
	

}
