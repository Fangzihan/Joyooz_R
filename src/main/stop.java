package main;

public class stop extends Thread{
	public void run() {
		main.UI.buffer=false;
		int turns=main.UI.random.nextInt(5+main.end_speed);
		for(int i=0;i<turns;i++) {
			main.UI.number++;
			if(main.UI.number==main.UI.max+1) {
				main.UI.number=1;
				
			}
			
			
			try {
			Thread.sleep(i*500/turns);
			}
			catch(Exception e)
			{}
			synchronized(this) {
				main.UI.setT(""+main.UI.number);
			}
		}
		for(int a=0;a<2;a++) {
			main.UI.setT(""+main.UI.number);
			try {Thread.sleep(main.tick);}catch(Exception e) {}
			main.UI.setT("");
			try {Thread.sleep(main.tick);}catch(Exception e) {}

		}
		main.UI.setT(""+main.UI.number);
		main.UI.buffer=true;
		try {Thread.sleep(main.tick);}catch(Exception e) {}
		
		this.stop();
    }
}
