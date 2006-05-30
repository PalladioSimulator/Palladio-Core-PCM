package Example;

import java.util.Arrays;

import RegEx.Complex;
import RegEx.impl.FFT;
import RegEx.impl.RegExFactoryImpl;

public class ServerComponent {

	//static int counter = 0;
	
	public void providedMethod1(){
		
		// not memory intensive:
		// int[] primes = findPrime(10000000, 1700); // ~50 ms
		// drawMandelbrot(0.0066); // ~50 ms
		
		// memory intensive:
		// sortRandomNumbers(100000); // ~50 ms
		// fft(8192); // ~70 ms
	
	}
	

	private void sortRandomNumbers(int amountOfNumbers) {
		double[] lotsOfDoubles = new double[amountOfNumbers];
		for (int i=0; i<amountOfNumbers; i++){
			lotsOfDoubles[i] = Math.random();
		}
		Arrays.sort(lotsOfDoubles);
	}
	
	private long countNumbers() {
		long k=0;
		for (long j=0; j<7000000; j++){
			if (k>100000){
				k=0;
			}
			k+=j;
		}
		return k;
	}
	
	private void passiveWaiting() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
	
	// find smallest prime number larger than x
	private int[] findPrime(int x, int numberOfPrimes){
		int[] primes = new int[numberOfPrimes];
		for (int i=0; i<primes.length; i++){
			while (!isPrime(x)) {
	            x++;
	        }
			primes[i] = x;
			x++;
		}
		return primes;
	}
	
	static boolean isPrime(int n) {
	    if (n <= 2) return n == 2;
        // even numbers other than 2 are not prime
        if (n % 2 == 0) return false;

        // check odd divisors from 3
        // to the square root of n
        for (int i = 3, end = (int)Math.sqrt(n);
        i <= end; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
	
    private int checkC(double reC,double imC) {
        double reZ=0,imZ=0,reZ_minus1=0,imZ_minus1=0;
        int i=0;
        for (i=0;i<30;i++) {
            imZ=2*reZ_minus1*imZ_minus1+imC;
            reZ=reZ_minus1*reZ_minus1-imZ_minus1*imZ_minus1+reC;
            if (reZ*reZ+imZ*imZ>4) return i;
            reZ_minus1=reZ;
            imZ_minus1=imZ;
        }
        return i;
    }

    private void drawMandelbrot(double init) {
        double reC, imC, zelle=init; //Ein Pixel = 0.00625
        int x,y;
        //Color colAppleman = new Color(0,129,190); //Farbe Apfelmännchen

        imC=-1.1; //oberer Rand
        for (y=0;y<350;y++) {
            reC=-2.1; //linker Rand
            for (x=0;x<440;x++) {
                if(checkC(reC,imC)==30) {
                    //g.setColor(colAppleman);
                    //g.drawLine(x,y,x,y);
                }
                reC=reC+zelle; //nächste Spalte
            }
            imC=imC+zelle; //nächste Zeile
        }
    }
    
    private void fft(int lengthOfDistFunc){
    	
    	RegExFactoryImpl regExFact = new RegExFactoryImpl();
    	Complex[] points = new Complex[lengthOfDistFunc];
    	for (int i=0; i<lengthOfDistFunc; i++){
    		Complex point = regExFact.createComplex();
			point.setRe(Math.random());
			point.setIm(0.0);
			points[i] = point;
    	}
    	
    	FFT.fft(points);
    }

}
