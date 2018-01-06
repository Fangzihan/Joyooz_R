package main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class floatUI extends JFrame  implements MouseListener{
	


	public floatUI() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JLabel img=new JLabel("  R");
		img.setFont(new java.awt.Font("微软雅黑",0,40));
		//img.setIcon(image.floatUI_image);
		this.setUndecorated(true);
		this.setSize(70,70);
		this.setLocation(screenSize.width-70,screenSize.height/8);
		this.setAlwaysOnTop(true);
		this.setLayout(null);
		this.add(img);
		img.setBounds(0,0,70,70);
		this.setVisible(false);
		this.addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		main.UI.setVisible(true);
		this.setVisible(false);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}


}
