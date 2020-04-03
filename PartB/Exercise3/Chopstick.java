import java.lang.*;
public class Chopstick {
	private int ID;
// hint: use a local variable to indicate whether the chopstick is free
//                        (lying on the table), e.g.  private boolean free;
	private boolean free;


	Chopstick(int ID) {
		  this.ID = ID;
			free = true;
	}

	synchronized void take() {
		try{
			if(free){
				free = false;
				notifyAll();
				System.out.println("Chopstick: " + getID() + "is taken");

			}
			else{
				wait();
			}

		}
		catch(InterruptedException e){
			System.out.println("Error 1");
		}
	}


	synchronized void release(){
		try{
			if(!free){
				free = true;
				notifyAll();
				System.out.println("Chopstick" + getID() + "is Free");
			}
			else{
				wait();
			}
		}
		catch(InterruptedException e){
			System.out.println("Error 2");
		}

	}

	public int getID() {
	    return(ID);
	}
}
