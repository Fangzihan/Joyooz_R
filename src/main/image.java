package main;
import javax.swing.ImageIcon;
import java.net.URL;

public class image {
	//URL
	public static URL url_icon;
	//situation1
	public static URL url_begin;
	public static URL url_check;
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
	public static ImageIcon begin;
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
			url_icon=ui.class.getResource("/res/icon.png");
			url_begin=ui.class.getResource("/res/logo.png");
			url_check=ui.class.getResource("/res/check.png");
			url_slow=ui.class.getResource("/res/slow.png");
			url_normal=ui.class.getResource("/res/normal.png");
			url_fast=ui.class.getResource("/res/fast.png");
			url_border1=ui.class.getResource("/res/border1.png");
			url_border2=ui.class.getResource("/res/border2.png");
			url_border3=ui.class.getResource("/res/border3.png");
			url_border4=ui.class.getResource("/res/border4.png");
			url_floatUI=ui.class.getResource("/res/floatUI.png");
			icon=new ImageIcon(url_icon);
			begin=new ImageIcon(url_begin);
			check=new ImageIcon(url_check);
			slow=new ImageIcon(url_slow);
			normal=new ImageIcon(url_normal);
			fast=new ImageIcon(url_fast);
			border1=new ImageIcon(url_border1);
			border2=new ImageIcon(url_border2);
			border3=new ImageIcon(url_border3);
			border4=new ImageIcon(url_border4);
			floatUI_image=new ImageIcon(url_floatUI);
		}
	
}
