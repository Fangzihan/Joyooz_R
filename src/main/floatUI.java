package main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class floatUI extends JFrame  implements MouseListener,MouseMotionListener{
	//拖拽时获取
	Point timePoint;
	
	int originY,newY;
	
	int oy;


	public floatUI() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JLabel img=new JLabel("R",JLabel.CENTER);
		img.setFont(new java.awt.Font("微软雅黑",Font.BOLD,50));
		img.setForeground(new Color(255,255,255));
		//img.setIcon(image.floatUI_image);
		this.setTitle("Joyooz学号机悬浮窗");
		this.setIconImage(image.icon.getImage());
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
		this.getContentPane().setBackground(new Color(255,153,0));
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		main.UI.setVisible(true);
		this.setVisible(false);
		
	}

	@Override
	public void mousePressed(MouseEvent e_press) {
		//获取初始单击点坐标(窗口内)
		originY=e_press.getY();
		
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
		//第二次获取窗口位置
		timePoint=this.getLocation();
		newY=e_drag.getY();
		
		this.setLocation(timePoint.x,timePoint.y+newY-originY);
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}


}
