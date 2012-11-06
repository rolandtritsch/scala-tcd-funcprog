package ie.tcd.sccs.funcprog.josephus;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Iterator;

public final class Josephus {
    public static int findSurvivor(int numOfSoldiers, int skipping) {
	assert(numOfSoldiers >= 1);
	assert(skipping >= 0);

        Collection theRing = new LinkedList();
        for(int i = 1; i <= numOfSoldiers; i++) theRing.add(new Integer(i));

        Iterator itr = theRing.iterator();
        System.out.println("1");
        while(numOfSoldiers-- != 1) {
          System.out.println("2");
	       for(int i = 0; i <= skipping; i++) {
	        if(!itr.hasNext()) itr = theRing.iterator(); // wrap over
		      itr.next();
          System.out.println("3");
	       }           
         System.out.println("4");    
	       itr.remove();    
	     }
        System.out.println("5");
        itr = theRing.iterator();
        return ((Integer) itr.next()).intValue();
    }

    public static void main(String[] args) {
	assert(args.length == 2);

	int numOfSoldiers = Integer.parseInt(args[0]);
	int killingEvery = Integer.parseInt(args[1]);

	System.out.println(findSurvivor(numOfSoldiers, killingEvery-1));
    }
}
