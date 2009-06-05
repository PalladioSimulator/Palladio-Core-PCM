/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * Copyright (c) 1997,1998 Sun Microsystems, Inc. All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.benchmarks.scimark.lu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import deprecated.spec.benchmarks.scimark.utils.Constants;
import deprecated.spec.benchmarks.scimark.utils.Random;
import deprecated.spec.benchmarks.scimark.utils.Stopwatch;
import deprecated.spec.benchmarks.scimark.utils.kernel;


/**
 * LU matrix factorization. (Based on TNT implementation.)
 * Decomposes a matrix A  into a triangular lower triangular
 * factor (L) and an upper triangular factor (U) such that
 * A = L*U.  By convention, the main diagonal of L consists
 * of 1's so that L and U can be stored compactly in
 * a NxN matrix.
 *
 */
public class LU {
    
    private static final String SERIALISATION_FILENAME = "MatrixesArrayList.ser";
	private static final int NR_OF_MATRIXES = 2;
	private static final int LU_size_default = 100;
    private static final PrintStream o = System.out;
    private int id;
    private double LU_[][];
    private int pivot_[];
    private Random R;
    private ArrayList<double[][]> matrixes;
	private int LU_size;
   
    protected static final void insert_copy(double B[][], double A[][]) {
        int M = A.length;
        int N = A[0].length;
        
        int remainder = N & 3;		 // N mod 4;
        
        for (int i=0; i<M; i++) {
            double Bi[] = B[i];
            double Ai[] = A[i];
            for (int j=0; j<remainder; j++)
                Bi[j] = Ai[j];
            for (int j=remainder; j<N; j+=4) {
                Bi[j] = Ai[j];
                Bi[j+1] = Ai[j+1];
                Bi[j+2] = Ai[j+2];
                Bi[j+3] = Ai[j+3];
            }
        }
    }
    
    /**
     * Returns a <em>copy</em> of the compact LU factorization.
     * (useful mainly for debugging.)
     *
     * Retrieves the compact LU factorization. The U factor
     * is stored in the upper triangular portion, and the L
     * factor is stored in the lower triangular portion.
     * The main diagonal of L consists (by convention) of
     * ones, and is not explicitly stored.
     * @deprecated because not used by us ;-)
     */
    public static void main(int id) {
        LU lu = new LU(id);
        lu.run();
    }
    
	public static void main(String[] args){
    	Integer lu_size;
    	if(args.length==1){
    		try{
    			lu_size = new Integer(args[0]);
	    	}catch(NumberFormatException nfe){
	    		System.out.println("Parameter given to LU.main was not a number;" +
	    				"taking default value of "+LU_size_default);
	    		nfe.printStackTrace();
	    		lu_size = LU_size_default;
	    	}
    	} else{
    		lu_size = LU_size_default;
    	}
    	int lu_id = (new Long(System.currentTimeMillis()%Integer.MAX_VALUE)).intValue();
    	LU lu = new LU(lu_id, lu_size);
    	lu.run_MK();
    }
	
	protected static double[] new_copy(double x[]) {
        int N = x.length;
        double T[] = new double[N];
        for (int i=0; i<N; i++)
            T[i] = x[i];
        return T;
    }
	
	protected static double[][] new_copy(double A[][]) {
        int M = A.length;
        int N = A[0].length;
        
        double T[][] = new double[M][N];
        
        for (int i=0; i<M; i++) {
            double Ti[] = T[i];
            double Ai[] = A[i];
            for (int j=0; j<N; j++)
                Ti[j] = Ai[j];
        }
        
        return T;
    }
	
	public static int[] new_copy(int x[]) {
        int N = x.length;
        int T[] = new int[N];
        for (int i=0; i<N; i++)
            T[i] = x[i];
        return T;
    }
    
    public static final double num_flops(int N) {
        // rougly 2/3*N^3
        
        double Nd = (double) N;
        
        return (2.0 * Nd *Nd *Nd/ 3.0);
    }
    
    /**
     * TODO
     */
    public LU() {
        this.id = (new Long(System.currentTimeMillis()%Integer.MAX_VALUE)).intValue();
        this.LU_size = LU_size_default; //MK because of OutOfMemoryError (used to be spec.benchmarks.scimark.utils.kernel.CURRENT_LU_SIZE;)
        this.matrixes = new ArrayList<double[][]>();
        this.R = new Random(Constants.RANDOM_SEED);
//        double min_time = Constants.RESOLUTION_DEFAULT;
//        double res = 0.0;
        
        o.println("spec.benchmarks.scimark.utils.Random created with seed "+Constants.RANDOM_SEED);
        o.println("Problem size (aka matrix size or \"LU_size\"): "+this.LU_size);
    }
    
    /**
     * TODO
     */
    public LU(int id, int size) {
        this.id = id;
        this.LU_size = size; //MK because of OutOfMemoryError (used to be spec.benchmarks.scimark.utils.kernel.CURRENT_LU_SIZE;)
        this.matrixes = new ArrayList<double[][]>();
        this.R = new Random(Constants.RANDOM_SEED);
//        double min_time = Constants.RESOLUTION_DEFAULT;
//        double res = 0.0;
        
        o.println("spec.benchmarks.scimark.utils.Random created with seed "+Constants.RANDOM_SEED);
        o.println("Problem size (aka matrix size or \"LU_size\"): "+this.LU_size);
    }
    
    @SuppressWarnings("unchecked")
	private boolean performSerialisation(int LU_size) {
        ArrayList<double[][]> writtenArrayList = this.matrixes;
		ArrayList<double[][]> readArrayList = null;
		FileInputStream fis = null;;
		FileOutputStream fos = null;;
		ObjectInputStream ois = null;;
		ObjectOutputStream oos = null;;

		String serialisationFileName = SERIALISATION_FILENAME; /*"ArrayList_double_"+LU_size+"_"+LU_size
        	+System.currentTimeMillis()+".ser"*/;
        try {
        	fos = new FileOutputStream(serialisationFileName);
        	oos = new ObjectOutputStream(fos);
        	oos.writeObject(writtenArrayList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			fis = new FileInputStream(serialisationFileName);
			ois = new ObjectInputStream(fis);
			readArrayList = (ArrayList<double[][]>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		boolean equal = true;
		if(readArrayList == null || writtenArrayList == null){
			return false;
		}
		if(readArrayList.size()!=writtenArrayList.size()){
			return false;
		}
//		o.println("readArrayList.length: "+readArrayList.size());
		if(readArrayList.equals(writtenArrayList)){
			o.println("Read ArrayList equals original ArrayList");
		}else{
			o.println("Read ArrayList !equals original ArrayList");
		}
//		int temp_origXSize = matrixes.get(0).length; 
//		int temp_origYSize = matrixes.get(0)[0].length; 
//		int diagLength;
//		if(temp_origXSize<=temp_origYSize){
//			diagLength = temp_origXSize;
//		}else{
//			diagLength = temp_origYSize;
//		}
		double[][] readMatrix;
		double[] readLine;
		double[][] writtenMatrix;
		double[] writtenLine;
		o.println("Read data: "+readArrayList.size()+" matrixes  "+readArrayList.get(0).length+"x"+readArrayList.get(0)[0].length);
		o.println("Written data: "+writtenArrayList.size()+" matrixes  "+writtenArrayList.get(0).length+"x"+writtenArrayList.get(0)[0].length);

		double epsilon = 0.000001;
		double diff;
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<NR_OF_MATRIXES){
			o.print("Starting matrix "+i+", rows: ");
			readMatrix = readArrayList.get(i);
			writtenMatrix = writtenArrayList.get(i);
            if(readMatrix.length != writtenMatrix.length){
            	return false;
//            	equal = false;
//            	i = NR_OF_MATRIXES;
            }
            j=0;
            while(j<writtenMatrix.length){
            	o.print(j+" ");
            	readLine = readMatrix[j];
            	writtenLine = writtenMatrix[j];
            	if(readLine.length!=writtenLine.length){
            		o.println("DIFFERENT LENGTHS in line "+(j+1));
            		return false;
//            		equal = false;
//            		j = writtenMatrix.length;
//            		i =NR_OF_MATRIXES;
            	}else{
            		for(k=0; k<readLine.length; k++){
            			diff = (writtenLine[k]-readLine[k])*(writtenLine[k]-readLine[k]);
            			if(diff>epsilon){
                    		o.println("DIFF>EPSILON in line "+(j+1)+" at position "+(k+1));
                    		return false;
//            				equal = false;
//            				k = readLine.length;
//                    		j = writtenMatrix.length;
//                    		i =NR_OF_MATRIXES;
            			}
//            			else{
//            				o.print("OK["+i+"]["+j+"]["+k+"]");
//            			}
            		}
            	}
            	j++;
            }
            o.println("done.");
            i++;
        }
		return equal;
	}
	
	public LU(int id) {
        this.id = id;
    }
    
    /**
     * Initalize LU factorization from matrix.
     *
     * @param A (in) the matrix to associate with this
     * factorization.
     */
   /* public LU( double A[][] )
    {
        int M = A.length;
        int N = A[0].length;
    
        //if ( LU_ == null || LU_.length != M || LU_[0].length != N)
            LU_ = new double[M][N];
    
        insert_copy(LU_, A);
    
        //if (pivot_.length != M)
            pivot_ = new int[M];
    
        factor(LU_, pivot_);
    }*/
    
    private String arrayToString(double[] arr){
    	StringBuffer sb = new StringBuffer();
    	sb.append("[");
    	for(int i=0; i<arr.length-1; i++){
    		sb.append(arr[i]+",");
    	}
    	sb.append(arr[arr.length-1]+"]");
    	return sb.toString();
    }
    
//    private String arrayToString(int[] arr){
//    	StringBuffer sb = new StringBuffer();
//    	sb.append("[");
//    	for(int i=0; i<arr.length-1; i++){
//    		sb.append(arr[i]+",");
//    	}
//    	sb.append(arr[arr.length-1]+"]");
//    	return sb.toString();
//    }
    
    
    /**
     * LU factorization (in place).
     *
     * @param A (in/out) On input, the matrix to be factored.
     * On output, the compact LU factorization.
     *
     * @param pivot (out) The pivot vector records the
     * reordering of the rows of A during factorization.
     *
     * @return 0, if OK, nozero value, othewise.
     */
    public int factor(double A[][],  int pivot[]) {
        
        int N = A.length;
        int M = A[0].length;
        
        int minMN = Math.min(M,N);
        
        for (int j=0; j<minMN; j++) {
            // find pivot in column j and  test for singularity.
            
            int jp=j;
            
            double t = Math.abs(A[j][j]);
            for (int i=j+1; i<M; i++) {
                double ab = Math.abs(A[i][j]);
                if ( ab > t) {
                    jp = i;
                    t = ab;
                }
            }
            
            pivot[j] = jp;
            
            // jp now has the index of maximum element
            // of column j, below the diagonal
            
            if ( A[jp][j] == 0 )
                return 1;       // factorization failed because of zero pivot
            
            
            if (jp != j) {
                // swap rows j and jp
                double tA[] = A[j];
                A[j] = A[jp];
                A[jp] = tA;
            }
            
            if (j<M-1)                // compute elements j+1:M of jth column
            {
                // note A(j,j), was A(jp,p) previously which was
                // guarranteed not to be zero (Label #1)
                //
                double recp =  1.0 / A[j][j];
                
                for (int k=j+1; k<M; k++)
                    A[k][j] *= recp;
            }
            
            
            if (j < minMN-1) {
                // rank-1 update to trailing submatrix:   E = E - x*y;
                //
                // E is the region A(j+1:M, j+1:N)
                // x is the column vector A(j+1:M,j)
                // y is row vector A(j,j+1:N)
                
                
                for (int ii=j+1; ii<M; ii++) {
                    double Aii[] = A[ii];
                    double Aj[] = A[j];
                    double AiiJ = Aii[j];
                    for (int jj=j+1; jj<N; jj++)
                        Aii[jj] -= AiiJ * Aj[jj];
                    
                }
            }
        }
        
        return 0;
    }
    
    public double[][] getLU() {
        return new_copy(LU_);
    }
    
    /**
     * Returns a <em>copy</em> of the pivot vector.
     *
     * @return the pivot vector used in obtaining the
     * LU factorzation.  Subsequent solutions must
     * permute the right-hand side by this vector.
     *
     */
    public int[] getPivot() {
        return new_copy(pivot_);
    }

    public double measureLU(int N, double min_time, Random R) {
        // compute approx Mlfops, or O if LU yields large errors
        double A[][] = kernel.RandomMatrix(N, N, R);
        double lu[][] = new double[N][N];
        int pivot[] = new int[N];
        o.println("Random matrix A:");
        for(int i=0; i<A.length; i++){
        	o.println(arrayToString(A[i]));
        }
        
        Stopwatch Q = new Stopwatch();
        
        o.println("Executing just 1 cycle, not 2...");
        int cycles=1 /*MK 2*/;
        //while(true)
        //{
        Q.start();
        //MK for (int i=0; i<cycles; i++) {
        	o.println("Copying matrix A to LU");
            kernel.CopyMatrix(lu, A);
            long start = System.nanoTime();
            int success = factor(lu, pivot);
            long stop = System.nanoTime();
            o.println("======================");
            o.println((stop-start)+" ns for factorisation (success: "+(1-success)+")");
        //MK }
        Q.stop();
        //	if (Q.read() >= min_time) break;
        
        
        // verify that LU is correct
        double b[] = kernel.RandomVector(N, R);
        o.println("Random vector b: "+arrayToString(b));
        double x[] = kernel.NewVectorCopy(b);
        
        start = System.nanoTime();
        solve(lu, pivot, x);
        stop = System.nanoTime();
        o.println((stop-start)+" ns for solving");
        
        final double EPS = 1.0e-12;
        kernel.checkResults(kernel.CURRENT_LU_RESULT,
                "" +  kernel.normabs(b, kernel.matvec(A,x)), id);
        
        if ( kernel.normabs(b, kernel.matvec(A,x)) / N > EPS )
            return 0.0;
        
        
        // else return approx Mflops
        //
        return LU.num_flops(N) * cycles / Q.read() * 1.0e-6;
    }
    
    /**
     * @param matrixIndex here: select the matrix from the list of random matrixes
     * @param min_time not used...
     * @param R SPEC-own random number generator
     * @return TODO
     */
    public double measureLU_MK(int matrixIndex, double min_time, Random R) { // compute approx Mlfops, or O if LU yields large errors
        double A[][] = this.matrixes.get(matrixIndex);//MK kernel.RandomMatrix(N, N, R);
        double lu[][] = new double[A.length][A.length];
        int pivot[] = new int[A.length];
//        o.println("Matrix A (from pre-random-generated collection):");
//        for(int i=0; i<A.length; i++){
//        	o.println(this.arrayToString(A[i]));
//        }
        
        Stopwatch Q = new Stopwatch();
        
        o.println("Executing just 1 cycle, not 2...");
        int cycles=1 /*MK 2*/;
        //while(true)
        //{
        Q.start();
        //MK for (int i=0; i<cycles; i++) {
        	o.println("Copying matrix A to LU");
            kernel.CopyMatrix(lu, A);
            long start = System.nanoTime();
            int success = factor(lu, pivot);
            long stop = System.nanoTime();
            o.println("======================");
            o.println((stop-start)+" ns for factorisation (success: "+(1-success)+")");
        //MK }
        Q.stop();
        //	if (Q.read() >= min_time) break;
        
        
        // verify that LU is correct
        double b[] = kernel.RandomVector(A.length, R);
//        o.println("Random vector b: "+arrayToString(b));
        double x[] = kernel.NewVectorCopy(b);
        
        start = System.nanoTime();
        solve(lu, pivot, x);
        stop = System.nanoTime();
        o.println((stop-start)+" ns for solving");
        
        final double EPS = 1.0e-12;
        kernel.checkResults(kernel.CURRENT_LU_RESULT,
                "" +  kernel.normabs(b, kernel.matvec(A,x)), id);
        
        if ( kernel.normabs(b, kernel.matvec(A,x)) / A.length > EPS )
            return 0.0;
        
        
        // else return approx Mflops
        //
        return LU.num_flops(A.length) * cycles / Q.read() * 1.0e-6;
    }
    
    /**
     * SPEC-own, untouched
     */
    public void run() {
        
        double min_time = Constants.RESOLUTION_DEFAULT;
        int LU_size = kernel.CURRENT_LU_SIZE;
        // run the benchmark
        
        double res = 0.0; //this variable is indeed never read in the original SPEC version
        Random R = new Random(Constants.RANDOM_SEED);
        o.println("min_time: "+min_time);
        o.println("LU_size: "+LU_size);
        o.println("Random created with seed "+Constants.RANDOM_SEED);
        
        res = measureLU( LU_size, min_time, R);
        o.println("Result in run(): "+res);
    }
    
    public void run_MK() {
        double res = 0D;
        String serialisationFileName = SERIALISATION_FILENAME;
        File f = new File(serialisationFileName);
        FileInputStream fis = null;
    	ObjectInputStream ois = null;
    	ArrayList<double[][]> readArrayList = null;
    	
    	boolean serialisationToBeCreated = true;
    	serialisationToBeCreated = deserialiseDataStructure(
				serialisationFileName, 
				f, 
				fis, 
				ois, 
				readArrayList,
				serialisationToBeCreated);
    	if(serialisationToBeCreated){
        	o.println("Creating "+NR_OF_MATRIXES+" random matrixes " +
        		"(each "+this.LU_size+"*"+this.LU_size+")");
        	for(int i=0; i<NR_OF_MATRIXES; i++){
        		this.matrixes.add(kernel.RandomMatrix(this.LU_size, this.LU_size, this.R));
        	}
        	boolean serisalisationSuccess = this.performSerialisation(this.LU_size);
        	o.println("Serialisation success: "+serisalisationSuccess);
        }
    	res = measureLU_MK( 0, -1, this.R);
        o.println("Result from measureLU_MK: "+res);
    }

	@SuppressWarnings("unchecked")
	private boolean deserialiseDataStructure(String serialisationFileName,
			File f, FileInputStream fis, ObjectInputStream ois,
			ArrayList<double[][]> readArrayList,
			boolean serialisationToBeCreated) {
		if(f.exists() && f.isFile()){
        	o.println("Serialised data exists");
        	try {
				fis = new FileInputStream(serialisationFileName);
				ois = new ObjectInputStream(fis);
				readArrayList = (ArrayList<double[][]>) ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally{
				if(ois!=null){
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(fis!=null){
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}	
			if(readArrayList!=null && readArrayList.size()>0){
	        	this.matrixes = readArrayList;
	        	serialisationToBeCreated = false;
	    		o.println("Read data: "+readArrayList.size()+" matrixes  "+readArrayList.get(0).length+"x"+readArrayList.get(0)[0].length);
	        }
        }
		return serialisationToBeCreated;
	}
    
    /**
     * Solve a linear system, with pre-computed factorization.
     *
     * @param b (in) the right-hand side.
     * @return solution vector.
     */
    public double[] solve(double b[]) {
        double x[] = new_copy(b);
        
        solve(LU_, pivot_, x);
        return x;
    }
    
    /**
     * Solve a linear system, using a prefactored matrix
     * in LU form.
     *
     * @param LU (in) the factored matrix in LU form.
     * @param pvt (in) the pivot vector which lists
     * the reordering used during the factorization
     * stage.
     * @param b    (in/out) On input, the right-hand side.
     * On output, the solution vector.
     */
    public void solve(double LU[][], int pvt[], double b[]) {
        int M = LU.length;
        int N = LU[0].length;
        int ii=0;
        
        for (int i=0; i<M; i++) {
            int ip = pvt[i];
            double sum = b[ip];
            
            b[ip] = b[i];
            if (ii==0)
                for (int j=ii; j<i; j++)
                    sum -= LU[i][j] * b[j];
            else
                if (sum == 0.0)
                    ii = i;
            b[i] = sum;
        }
        
        for (int i=N-1; i>=0; i--) {
            double sum = b[i];
            for (int j=i+1; j<N; j++)
                sum -= LU[i][j] * b[j];
            b[i] = sum / LU[i][i];
        }
    }
}
