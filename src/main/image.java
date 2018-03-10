package main;
import javax.swing.ImageIcon;
import java.net.URL;

public class image {
	//URL
	public static URL url_icon;
	//situation1
	//开头资源
	public static URL[] url_begin;
	//开头资源
	public static URL url_check;
	//公共版特有---
	public static URL url_update;
	//公共版特有---
	//situation2
	public static URL url_slow;
	public static URL url_normal;
	public static URL url_fast;
	//situation3
	public static URL url_border1;
	public static URL url_border2;
	public static URL url_border3;
	public static URL url_border4;
	
	public static URL url_floatUI;
	
	//imageicon
	public static ImageIcon icon;
	//situation1
	public static ImageIcon[] begin;
	//公共版特有---
	public static ImageIcon update;
	//公共版特有---
	//situation2
	public static ImageIcon check;
	//situation3
	public static ImageIcon slow;
	public static ImageIcon normal;
	public static ImageIcon fast;
	//situation4
	public static ImageIcon border1;
	public static ImageIcon border2;
	public static ImageIcon border3;
	public static ImageIcon border4;
	public static ImageIcon floatUI_image;
	
		public static void init() {
			//========加载开头========
			//共有120张图
			//先初始化数组
			url_begin=new URL[121];
			begin=new ImageIcon[121];
			
			for(int i=1;i<=120;i++) {
				//个位数三个零
				if(i<10) {
					url_begin[i]=ui.class.getResource("/res/start/sta000"+i+".png");
				//十位数两个零
				}else if(i>9&&i<100) {
					url_begin[i]=ui.class.getResource("/res/start/sta00"+i+".png");
				}else if(i>99) {
					url_begin[i]=ui.class.getResource("/res/start/sta0"+i+".png");
				}
			}
			
			for(int i=1;i<=120;i++) {
				begin[i]=new ImageIcon(url_begin[i]);
			}		
			
			//========加载开头========
			url_icon=ui.class.getResource("/res/icon.png");
			url_check=ui.class.getResource("/res/check.png");
			url_slow=ui.class.getResource("/res/slow.png");
			url_normal=ui.class.getResource("/res/normal.png");
			url_fast=ui.class.getResource("/res/fast.png");
			url_border1=ui.class.getResource("/res/border1.png");
			url_border2=ui.class.getResource("/res/border2.png");
			url_border3=ui.class.getResource("/res/border3.png");
			url_border4=ui.class.getResource("/res/border4.png");
			url_floatUI=ui.class.getResource("/res/floatUI.png");
			//公共版特有
			url_update=ui.class.getResource("/res/update_confirm.png");
			//公共版特有
			
			icon=new ImageIcon(url_icon);
			check=new ImageIcon(url_check);
			slow=new ImageIcon(url_slow);
			normal=new ImageIcon(url_normal);
			fast=new ImageIcon(url_fast);
			border1=new ImageIcon(url_border1);
			border2=new ImageIcon(url_border2);
			border3=new ImageIcon(url_border3);
			border4=new ImageIcon(url_border4);
			floatUI_image=new ImageIcon(url_floatUI);
			//公共版特有
			update=new ImageIcon(url_update);
			//公共版特有
		}
	
}
