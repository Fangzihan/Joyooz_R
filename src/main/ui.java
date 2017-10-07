package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class ui extends JFrame {
	
	JLabel numberScreen;
	JButton option;

	ImageIcon logo;
	JLabel logo_label;
	public ui() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		numberScreen=new 	JLabel("30",JLabel.CENTER);
		option=new JButton("设置");

		URL url=ui.class.getResource("/assets/logo.png");
		logo=new ImageIcon(url);
		logo_label=new JLabel(logo);
		//inst objects
		
		numberScreen.setFont(new Font("微软雅黑",Font.BOLD,150));
		numberScreen.setBorder(null);
		//set objects
		
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("奉贤中学抽学号软件");
		this.setSize(400, 400);
		this.setLocation(screenSize.width/2-200, screenSize.height/2-200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//初始化界面
		
		this.setLayout(null);
		this.add(logo_label);
		logo_label.setBounds(0, -30,400,400);
		
		try {
		Thread.sleep(3000);
		}catch(Exception e) {
			
		}
		logo_label.setIcon(null);
		logo_label.setVisible(false);
		
		this.add(numberScreen);
		numberScreen.setBounds(40, 75, 300, 200);
		//add objects
		
		
	}
}
