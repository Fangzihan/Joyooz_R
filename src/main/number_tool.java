package main;
import java.util.*;

public class number_tool extends Thread{
	int i;
	public void run() {
		i=500;
		for(int a=0;;a++) {
			main.UI.setT(""+main.UI.number);
			main.UI.number++;
			if(main.UI.number==main.UI.max+1) {
				main.UI.number=1;
				
			}
			if(i>40) {
				i=i-50;
				
			}else if(i<=40) {
				i=4;
				
			}
			
			try {
			Thread.sleep(i);
			}catch(Exception e) {
				
			}
		}
		
	}
	
}
