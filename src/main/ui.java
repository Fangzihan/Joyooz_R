package main;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class ui extends JFrame implements MouseListener,MouseMotionListener,ActionListener,ComponentListener{
	//全局变量
	boolean buffer;	//当还未倒计时结束时不能点击
	Dimension screenSize ;
	ComponentListener cpl;
	
	//组件
	floatUI FU;
	JLabel numberScreen;
	//JButton option;
	JLabel version;
	
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
	public Random random;
	int max;
	int number;
	int condition;
	
	//公共版特有的更新检测器
	Update UpdateWindow;
	
	public ui() {
		image.init();
		FU=new floatUI();
		number=1;
		condition=0;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		numberScreen=new 	JLabel("--",JLabel.CENTER);
		//option=new JButton("设置");
		logo_label=new JLabel();
		
		
		instruction=new JLabel("请输入最大学号");
		input=new JTextField(10);
		check=new JButton();
		
		speed_choose_instruction=new JLabel("请选择速度");
		slow_button=new JButton();
		normal_button=new JButton();
		fast_button=new JButton();
		
		border1_label=new JLabel();
		border2_label=new JLabel();
		border3_label=new JLabel();
		border4_label=new JLabel();
		random=new Random();
		
		//inst objects
		
		numberScreen.setFont(new Font("微软雅黑",Font.BOLD,150));
		numberScreen.setBorder(null);
		
		instruction.setForeground(new Color(51,153,255));
		instruction.setFont(new Font("微软雅黑",0,40));
		input.setFont(new Font("微软雅黑",0,40));
		check.setIcon(image.check);
		
		speed_choose_instruction.setFont(new Font("微软雅黑",0,40));
		speed_choose_instruction.setForeground(new Color(51,153,255));
		slow_button.setIcon(image.slow);
		normal_button.setIcon(image.normal);
		fast_button.setIcon(image.fast);
		
		//初始化边框
		border1_label.setIcon(image.border1);
		border2_label.setIcon(image.border2);
		border3_label.setIcon(image.border3);
		border4_label.setIcon(image.border4);
	
		

		
		//set objects
		
		this.getContentPane().setBackground(Color.WHITE);

		this.setTitle("Joyooz学号机");

		this.setIconImage(image.icon.getImage());
		this.setSize(400, 400);
		this.setLocation(screenSize.width/2-200, screenSize.height/2-200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		//初始化界面
		
		this.setLayout(null);
		this.add(logo_label);
		
		///以下注释是因为暂时有一些边框用不到
		//this.add(border1_label);
		//this.add(border2_label);
		//this.add(border3_label);
		//this.add(border4_label);
		
		//border1_label.setBounds(0,0,400,50);
		//border2_label.setBounds(0,320,400,50);
		//border3_label.setBounds(0,50,50,300);
		//border4_label.setBounds(350,50,50,300);
		
		//==========版本号===========
		version=new JLabel("Version:"+main.version);
		version.setHorizontalAlignment(SwingConstants.RIGHT);
		version.setFont(new Font("微软雅黑",0,10));
		version.setForeground(Color.DARK_GRAY);
		this.add(version);
		version.setBounds(200,345,180,25);
		//==========版本号===========
		
		
		logo_label.setBounds(0, -30,400,400);
		
		//开始开头动画
		try{
			for(int i=1;i<=120;i++) {
				logo_label.setIcon(image.begin[i]);
				Thread.sleep(25);
			}
		}catch(Exception e) {}
		
		
		//结束开头动画
		
		this.input_number_ui();
		
		
		
	}
	
	//输入数字的界面
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
		//---公共版特有的检测更新界面
		UpdateWindow=new Update();
		if(UpdateWindow.checkUpdate()) {
			UpdateWindow.instWindow();
		}
		//公共版特有的检测更新界面---
		
	} 
	
	public void choose_speed_ui() {
		//添加窗口拖动检测器，拖动到边缘自动开启悬浮窗
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
			
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				int x=getX();
				int y=getY();
				if(screenSize.getWidth()-x<400||screenSize.getHeight()-y<400) {
					setVisible(false);
					FU.setVisible(true);
				}
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				
				
			}
			});
		//setInvisible
		instruction.setVisible(false);
		input.setVisible(false);
		check.setVisible(false);
		//remove
		this.remove(instruction);
		this.remove(input);
		this.remove(check);
		//add
		this.add(speed_choose_instruction);
		this.add(slow_button);
		this.add(normal_button);
		this.add(fast_button);
		
		speed_choose_instruction.setBounds(75,80,300,50);
		slow_button.setBounds(75, 150, 80, 50);
		normal_button.setBounds(160,150 , 80, 50);
		fast_button.setBounds(245, 150, 80, 50);
		
		slow_button.addActionListener(this);
		slow_button.setActionCommand("slow");
		normal_button.addActionListener(this);
		normal_button.setActionCommand("normal");
		fast_button.addActionListener(this);
		fast_button.setActionCommand("fast");
	}
	
	public void number_ui() {
		//buffer
		buffer=true;
		//setInvisible
		border1_label.setBounds(0,0,400,50);
		speed_choose_instruction.setVisible(false);
		slow_button.setVisible(false);
		normal_button.setVisible(false);
		fast_button.setVisible(false);
		//remove
		this.remove(speed_choose_instruction);
		this.remove(slow_button);
		this.remove(normal_button);
		this.remove(fast_button);
		
		//add
		this.add(numberScreen);
		numberScreen.setBounds(40, 75, 300, 200);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
			if(arg0.getButton()==MouseEvent.BUTTON1)
			{
				
					if(condition==0&&buffer) {
						Stop=null;
						this.numberTool=new number_tool();
						this.numberTool.start();
						condition=1;
					}else if(condition==1) {
						numberTool.stop();
						numberTool=null;
						this.Stop=new stop();
						Stop.start();
						condition=0;
					}
			
				
			}else if(arg0.getButton()==MouseEvent.BUTTON3) 
			{
				this.setVisible(false);
				FU.setVisible(true);
		
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
			if(!input.getText().equals("")) {
				try{
					this.max=(Integer.parseInt(input.getText()));
					this.choose_speed_ui();
				}catch(Exception e) {
				}
			}else{
				instruction.setForeground(Color.red);
			}
			
		}else if(act.getActionCommand().equals("slow")) {
			main.roll_speed=20;
			main.end_speed=1;
			main.tick=600;
			this.number_ui();
			
		}else if(act.getActionCommand().equals("normal")) {
			main.roll_speed=8;
			main.end_speed=3;
			main.tick=450;
			this.number_ui();
			
		}else if(act.getActionCommand().equals("fast")) {
			main.roll_speed=3;
			main.end_speed=5;
			main.tick=300;
			this.number_ui();
			
		}
		
	}
	public void setT(String t) {
		this.numberScreen.setText(t);
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO 自动生成的方法存根
		
	}

}
