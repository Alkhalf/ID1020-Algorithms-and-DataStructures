package task5;

public class Stopwatch {
		private final long start;
		public Stopwatch() {
			//använt nanoTime  metod för att få mer exakta värde
	        start = System.nanoTime();
	        		//currentTimeMillis();
	    } 
	    public double elapsedTime() {
	        long now = System.nanoTime();
	        //multblicera med 10E-9 för att få tiden på sekunder
	        return (now - start)*(0.000000001);
	    }
}
