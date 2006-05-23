import java.util.ArrayList;


public class Monitoring {

	public static ArrayList measuredThreadValues = new ArrayList();
	public static ArrayList measuredCallValues = new ArrayList();
	
	public static void addThreadMeasurement(long time){
		measuredThreadValues.add(time);
	}

	public static void addCallMeasurement(long time){
		measuredCallValues.add(time);
	}

	public static void printResults(){
		for (int i=0; i<measuredThreadValues.size(); i++){
			System.out.print(measuredThreadValues.get(i)+" ");
			if((i+1)%5==0) {
				System.out.println("Call: "+measuredCallValues.get(i/5));
			}
		}
		
		
	}

}
