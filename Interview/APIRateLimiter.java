package Interview;
// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.Timer;  
import java.util.*; 

class APIRateLimiter{

	//Uber Phone
	
    public ArrayList<Long> q = new ArrayList<Long>();
    public int limit = 3;
    
    public void sayHi() {
        //if called more than N (N=3) times in 1 second raise an error, other wise print 'Hi!'.
        //LocalDateTime.now();
        long curtime= System.currentTimeMillis();
        //if sayHi() called && size < n, add time to q
        if(q.size() >= limit){
            long diff = curtime-q.get(0);
            if(diff < 1000){
                System.out.println("Error!");
                return;
            }
        }
        System.out.println("Hi!");
        q.add(curtime);
    }
    

    
    public static void main(String[] args){
        APIRateLimiter foo = new APIRateLimiter();
        //foo.sayHi();
        foo.sayHi();
        foo.sayHi();
        foo.sayHi();
        foo.sayHi();
       // Timer timer = new Timer();  
    //    timer.schedule(sayHi(), 1000, 1000);  //once per second
      //  timer.schedule(sayHi(), 1000, 500);  //once per 0.5second

    }
}