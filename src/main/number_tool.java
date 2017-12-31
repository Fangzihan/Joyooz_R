package main;
import java.util.*;

public class number_tool extends Thread{
	public void run() {
		for(int a=0;;a++) {
			main.UI.setT(""+main.UI.number);
			main.UI.number++;
			if(main.UI.number==main.UI.max+1) {
				main.UI.number=1;
				
			}
			
			try {
			Thread.sleep(main.roll_speed);
			}catch(Exception e) {
				
			}
		}
		
	}
	
}
