package main;

public class stop extends Thread{
	public void run() {
		int i=0;
		while(i<470) {
			main.UI.number++;
			if(main.UI.number==main.UI.max+1) {
				main.UI.number=1;
				
			}
			
			System.out.println(main.UI.number+","+i);
			i=i+70;
			
			try {
			Thread.sleep(i);
			}
			catch(Exception e)
			{}
			main.UI.setT(""+main.UI.number);
		}
		for(int a=0;a<3;a++) {
			main.UI.setT(""+main.UI.number);
			try {Thread.sleep(500);}catch(Exception e) {}
			main.UI.setT("");
			try {Thread.sleep(500);}catch(Exception e) {}

		}
		main.UI.setT(""+main.UI.number);
		try {Thread.sleep(500);}catch(Exception e) {}
		System.out.println("Stop!");
		
		this.stop();
    }
}
