package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ui extends JFrame {
	
	JLabel numberScreen;
	JButton option;
	public ui() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		numberScreen=new 	JLabel("30",JLabel.CENTER);
		option=new JButton("设置");
		//inst objects
		
		numberScreen.setBackground(new Color(0,0,0,0));
		numberScreen.setFont(new Font("微软雅黑",Font.BOLD,150));
		numberScreen.setBorder(null);
		//set objects
		
		this.setLayout(null);
		this.add(numberScreen);
		numberScreen.setBounds(40, 75, 300, 200);
		//add objects
		
		this.setTitle("奉贤中学抽学号软件");
		this.setSize(400, 400);
		this.setLocation(screenSize.width/2-200, screenSize.height/2-200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
}
