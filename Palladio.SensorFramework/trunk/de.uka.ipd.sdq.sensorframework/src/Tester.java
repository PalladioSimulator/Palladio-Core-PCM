import com.db4o.Db4o;
import com.db4o.ObjectContainer;


/**
 * TODO It is not clear what is being tested and how, and what the expected results ought to be.
 * TODO Not part of a JUnit test suite. 
 * @author Steffen Becker
 *
 */
public class Tester {
	private static final int PAGE_COUNT = 1000;

	public static void main(String[] args){
		ObjectContainer db = Db4o.openFile("C:/temp/tester.db");//TODO test whether this file exists...
		long start = System.nanoTime();
		double[][] data = new double[2][PAGE_COUNT]; 
		int j = 0;
		for (int i = 0; i < 1000000; i++) {
			//TimeSpanMeasurement tsm = new TimeSpanMeasurementImpl(null);
			//tsm.setEventTime(0);
			//tsm.setTimeSpan(44);
			data[0][j]=0;
			data[0][j]=44;
			j++;
			db.set(data);
			if (i%PAGE_COUNT == 0) {
				System.out.println((System.nanoTime()-start)/Math.pow(10,9));
				db.commit();
				j=0;
				db.ext().purge(data);
			}
		}
		System.out.println((System.nanoTime()-start)/Math.pow(10,9));
		db.commit();
		System.out.println((System.nanoTime()-start)/Math.pow(10,9));
	}
}
