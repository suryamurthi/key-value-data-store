
public class Input {
	 public static void main(String[] args) throws InterruptedException {
	    	DataStore store = new DataStore();
	    	store.create("surya", 25);
	    	store.create("ravi",30,1000);
	    	store.create("priya", 23);
	    	store.create("swathi",26,2000);
	    	Thread.sleep(1500);
	    	System.out.println(store.read("surya"));
	    	System.out.println(store.read("ravi"));
	    	System.out.println(store.read("priya"));
	    	System.out.println(store.read("swathi"));
	    	store.create("priya", 25);
	    	store.delete("ravi");
	    }

}
