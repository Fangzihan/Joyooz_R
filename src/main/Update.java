package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

//这是更新窗口
public class Update extends JFrame implements ActionListener{
	JLabel title;					//"发现更新"
	JTextArea article;			//"正文"
	JButton confirm;			//"现在更新"
	URL checkLog;
	String newVersion;
	URI dlAddress;
	InputStream is;
	InputStreamReader isr;
	BufferedReader br;
	
	public Update() {
		
	}

	//一个判断是否有更新的方法,返回结果
	public boolean checkUpdate(){
		//初始化各种对象,如果出现异常直接返回false
		try{
			checkLog=new URL("http://joyooz.com/r/update.log");
			is=checkLog.openStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			
			String temp;//temp是br读取用的临时字符串,text是整个字符
			String text="";
			//-----使用缓冲流获取内容-----
			temp=br.readLine();
			while(temp!=null) {
				text=text+temp;
				temp=br.readLine();
			}
			
			//-----使用缓冲流获取内容-----
			//字符串切割
			String[] CutText=text.split("#");
			newVersion=CutText[1];
			dlAddress=new URI(CutText[2]);
			//检测到有更新
			if(!newVersion.equals(main.version)) {
				//返回true
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;				//出现异常返回false
		}
		
	}
	
	//生成窗口
	public void instWindow() {
		title=new JLabel();
		article=new JTextArea();
		confirm=new JButton();
		//标题属性设置
		title.setText("发现更新");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("微软雅黑",1,30));
		title.setForeground(new Color(255,153,0));
		//正文属性设置
		article.setText("    我们发现了Joyooz学号机的全新版本,新版本为"+newVersion+",当前运行的版本为"+main.version+",您可以选择是否立即更新,如暂时不想更新,可以点击关闭按钮.");
		article.setEditable(false);
		article.setLineWrap(true);
		article.setFont(new Font("微软雅黑",0,20));
		article.setForeground(new Color(255,153,0));
		//按钮设置
		confirm.setIcon(image.update);
		confirm.setBackground(Color.white);
		confirm.setBorder(null);
		confirm.addActionListener(this);
		confirm.setActionCommand("UPDATE");
		
		//初始化窗口
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Joyooz学号机更新");
		this.getContentPane().setBackground(Color.WHITE);
		this.setIconImage(image.icon.getImage());
		this.setLocation(screenSize.width/2-150, screenSize.height/2-205);
		this.setAlwaysOnTop(true);
		this.setSize(315,415);
		this.setLayout(null);
		
		this.add(title);
		this.add(article);
		this.add(confirm);
		
		title.setBounds(80,10,140,40);
		article.setBounds(15,70,270,180);
		confirm.setBounds(40,320,220,40);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//单机确认按钮动作
		if(e.getActionCommand().equals("UPDATE")) {
			try {
				Desktop.getDesktop().browse(dlAddress);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.setVisible(false);;
		}
		
	}
	
	
	
}
