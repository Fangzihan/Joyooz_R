package main;
import java.util.*;

public class number_tool {
	Random ran;
	private int max;
	public number_tool(){
		ran=new Random();
		
	}
	
	public void setMax(int max) {
		this.max=max;
		
	}
	public int getNumber() {
		int number=ran.nextInt(this.max);
		return number+1;
		
	}
}
