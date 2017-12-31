package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class ui extends JFrame implements MouseListener,MouseMotionListener,ActionListener{
	JLabel numberScreen;
	//JButton option;
	
	number_tool numberTool;
	stop Stop;

	ImageIcon logo;
	JLabel logo_label;
	
	ImageIcon ad1;
	JLabel ad1_label;
	
	JLabel instruction;
	JTextField input;
	JButton check;

	JLabel speed_choose_instruction;
	JButton slow_button;
	JButton normal_button;
	JButton fast_button;
	
	
	JLabel border1_label;
	JLabel border2_label;
	JLabel border3_label;
	JLabel border4_label;
	int max;
	int number;
	int condition;
	public ui() {
		image.init();
		number=1;
		condition=0;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		numberScreen=new 	JLabel("--",JLabel.CENTER);
		//option=new JButton("设置");
		logo_label=new JLabel(image.begin);
		
		
		instruction=new JLabel("请输入最大学号");
		input=new JTextField(10);
		check=new JButton();
		
		speed_choose_instruction=new JLabel();
		slow_button=new JButton();
		normal_button=new JButton();
		fast_button=new JButton();
		
		border1_label=new JLabel();
		border2_label=new JLabel();
		border3_label=new JLabel();
		border4_label=new JLabel();
		
		//inst objects
		
		numberScreen.setFont(new Font("微软雅黑",Font.BOLD,150));
		numberScreen.setBorder(null);
		
		instruction.setForeground(new Color(51,153,255));
		instruction.setFont(new Font("微软雅黑",0,40));
		input.setFont(new Font("微软雅黑",0,40));
		check.setIcon(image.check);
		
	
		

		
		//set objects
		
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("Joyooz学号机"+main.version);
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
		Thread.sleep(2500);
		}catch(Exception e) {
			
		}
		
		this.input_number_ui();
		
		
		
		
		
	}
	
	public void input_number_ui() {
		logo_label.setIcon(null);
		logo_label.setVisible(false);
		//将开头图片设为不可见
		this.add(instruction);
		this.add(input);
		this.add(check);
		check.addActionListener(this);
		check.setActionCommand("check");
		
		instruction.setBounds(50, 100, 300, 50);
		input.setBounds(50, 175, 250, 50);
		check.setBounds(300, 175, 50, 50);
		
	} 
	
	public void choose_speed_ui() {
		//setInvisible
		instruction.setVisible(false);
		input.setVisible(false);
		check.setVisible(false);
		//remove
		this.remove(instruction);
		this.remove(input);
		this.remove(check);
		//add
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(((arg0.getX()>40)&&(arg0.getX()<340))&&((arg0.getY()>75)&&(arg0.getY()<275))) {
			if(condition==0) {
				Stop=null;
				this.numberTool=new number_tool();
				this.numberTool.start();
				System.out.println("Start");
				condition=1;
			}else if(condition==1) {
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
				this.add(ad1_label);
				ad1_label.setBounds(0,325,400,50);
				this.addMouseListener(this);
				this.addMouseMotionListener(this);
				//System.out.println("添加");
				
				//add objects
			}catch(Exception e) {
				System.out.println("Error!");
			}
			
		}else if(act.getActionCommand().equals("close_ad")) {
			ad1_label.setVisible(false);
			
			
		}
		
	}
	public void setT(String t) {
		this.numberScreen.setText(t);
		System.out.println(this.numberScreen.getText());
		
	}
}
