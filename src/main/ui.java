package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class ui extends JFrame implements MouseListener,MouseMotionListener,ActionListener{
	JLabel numberScreen;
	JButton option;
	
	number_tool numberTool;
	stop Stop;

	ImageIcon logo;
	JLabel logo_label;
	
	JLabel instruction;
	JTextField input;
	JButton check;
	int x;
	int y;
	int max;
	int number;
	int condition;
	public ui() {
		condition=0;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		numberScreen=new 	JLabel("--",JLabel.CENTER);
		option=new JButton("设置");

		URL url_logo=ui.class.getResource("/res/logo.png");
		logo=new ImageIcon(url_logo);
		logo_label=new JLabel(logo);
		URL url_check=ui.class.getResource("/res/check.png");
		
		instruction=new JLabel("请输入最大学号");
		input=new JTextField(10);
		check=new JButton();
		//inst objects
		
		numberScreen.setFont(new Font("微软雅黑",Font.BOLD,150));
		numberScreen.setBorder(null);
		
		instruction.setForeground(new Color(51,153,255));
		instruction.setFont(new Font("微软雅黑",0,40));
		input.setFont(new Font("微软雅黑",0,40));
		check.setIcon(new ImageIcon(url_check));
		
		//set objects
		
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("奉贤中学抽学号软件");
		this.setSize(400, 400);
		this.setLocation(screenSize.width/2-200, screenSize.height/2-200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		//初始化界面
		
		this.setLayout(null);
		this.add(logo_label);
		logo_label.setBounds(0, -30,400,400);
		
		try {
		Thread.sleep(750);
		}catch(Exception e) {
			
		}
		logo_label.setIcon(null);
		logo_label.setVisible(false);
		
		this.add(instruction);
		this.add(input);
		this.add(check);
		check.addActionListener(this);
		check.setActionCommand("check");
		
		instruction.setBounds(50, 100, 300, 50);
		input.setBounds(50, 175, 250, 50);
		check.setBounds(300, 175, 50, 50);
		
		
		
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		this.x=arg0.getX();
		this.y=arg0.getY();
		//System.out.print("x:"+x);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(((x>40)&&(x<340))&&((y>75)&&(y<275))) {
			if(condition==0) {
				System.out.println("准备Start!");
				Stop=null;
				this.numberTool=new number_tool();
				this.numberTool.start();
				System.out.println("Start");
				condition=1;
			}else if(condition==1) {
				System.out.println("准备Stop!");
				numberTool.stop();
				numberTool=null;
				this.Stop=new stop();
				Stop.start();
				condition=0;
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}
	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals("check")) {
			//System.out.println("点击");
			try{
				this.max=(Integer.parseInt(input.getText()));
				
				instruction.setVisible(false);
				input.setVisible(false);
				check.setVisible(false);
				
				this.add(numberScreen);
				numberScreen.setBounds(40, 75, 300, 200);
				this.addMouseListener(this);
				this.addMouseMotionListener(this);
				//System.out.println("添加");
				
				//add objects
			}catch(Exception e) {
				System.out.println("Error!");
			}
			
		}
		
	}
	public void setT(String t) {
		this.numberScreen.setText(t);
		System.out.println(this.numberScreen.getText());
		
	}
}
