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
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("A");
		}
		free = false;
	}


	synchronized void release() {
		try {
			notify();
		} catch (IllegalMonitorStateException e) {
			System.out.println("B");
		}
		free = true;
	}

	public int getID() {
	    return(ID);
	}
}
