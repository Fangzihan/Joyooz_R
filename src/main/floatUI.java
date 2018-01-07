package main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class floatUI extends JFrame  implements MouseListener,MouseMotionListener{
		Point p;
		int oy;


	public floatUI() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JLabel img=new JLabel("R",JLabel.CENTER);
		img.setFont(new java.awt.Font("微软雅黑",Font.BOLD,50));
		img.setForeground(new Color(51,153,255));
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
		this.addMouseMotionListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		main.UI.setVisible(true);
		this.setVisible(false);
		
	}

	@Override
	public void mousePressed(MouseEvent e_press) {
		p=this.getLocation();
		oy=e_press.getY();
		
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

	@Override
	public void mouseDragged(MouseEvent e_drag) {
		this.setLocation(p.x,p.y+(e_drag.getY()-oy));
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}


}
