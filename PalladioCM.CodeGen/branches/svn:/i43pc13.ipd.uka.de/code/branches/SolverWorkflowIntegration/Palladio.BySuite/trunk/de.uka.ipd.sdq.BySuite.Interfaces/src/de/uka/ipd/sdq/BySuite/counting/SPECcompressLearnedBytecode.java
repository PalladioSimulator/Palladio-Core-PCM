package de.uka.ipd.sdq.BySuite.counting;

import com.bestcode.mathparser.IMathParser;
import com.bestcode.mathparser.MathParserFactory;

import de.uka.ipd.sdq.BySuite.mathparser.IfThen;
import de.uka.ipd.sdq.BySuite.mathparser.IfThenElse;

//IF(A) THEN (B) ELSE (C) --> MyIfThenElse(A,B,C)
//
//IF( --> MyIfThenElse(
//) THEN ( --> ,
//) ELSE ( --> ,


public class SPECcompressLearnedBytecode {
	
	public static int[] LEARNED_BYTECODES = {
		//1, //ACONST_NULL 
		2,   //ICONST_M1 //TODO add benchmark
		3,   //ICONST_0
		4,   //ICONST_1
		//17,  //SIPUSH
		18,
		21,  //ILOAD		
		25,  //ALOAD
		//50,  //AALOAD
		//51,  //BALOAD
		54, //ISTORE
		//58,  //ASTORE
		//83,  //AASTORE
		//84,  //BASTORE
		//85,  //CASTORE
		//87, //POP
		89,
		90,
		96,
		100,
		120,
		130,		
		//132, //IINC
		153,
		154,
		155,
		156,
		157,
		160, //IF_ICMPNE
		161, //IC_ICMPLT
		162,		
		167, //GOTO
		180,
		181,
		182,
		183,
		//188, //NEWARRAY
		//189, //ANEWARRAY
		//190, //ARRAYLENGTH
		};

	public static void main(String[] args) {
										//file / compr / BC
		System.out.println( new SPECcompressLearnedBytecode().getLearnedData(12000, 1, 100) );
	}
	
	private IMathParser parser = MathParserFactory.create();
	
	public SPECcompressLearnedBytecode() {
		// init only once
		initParser();
	}
	
	private double bc100(long X1, int X2) {
		String exp = "(MyIf((295.0 * (X1 - 30000.0) * 65.0) >= (1.0 + 1.0 + 1.3),((X1 * 1.1) - 30000.0))) + (MyIfThenElse((103.0 * 100.0 * 0.28353673) >= (Exp(196.0)),((" +
				"MyIf(" +
					"(1.9 ^ X1) >= (" +
						"(1.0 + 1.0 + 1.3) - (sin(400000.0)))," +
					"(X1 - (sin(400000.0))))) * (X1 * 1.1) * 0.0),X1)) + ((X1 - 30000.0) - X1)";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc120(long X1, int X2) {
		String exp = "(10.0 - 12.0) + X1 + X1";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc130(long X1, int X2) {
		String exp = "X1 - 1.0";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc153(long X1, int X2) {
		String exp = "X1 / (1.0 * 4.0 * 30000.0)";				
  		return evalExpression(X1, X2, exp);
	}

	private double bc154(long X1, int X2) {
		String exp = "(X1 - (1.3 + (Exp(1.0)) + ((Exp((Exp(1.0)))) + (14.0 + 0.5) + (1.1 * (Exp((MyIfThenElse(0.9 >= 0.0,10.0)))))))) / (Exp(1.0))";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc155(long X1, int X2) {
		String exp = "0.5 + ((231.0 + (MyIfThenElse((1.9 * 10.0) >= 0.5,(X1 / 1.3))) + (231.0 * (MyIfThenElse((Exp(0.7859266)) >= 0.7,(2.0 * 30.0 * 1.0),((MyIfThenElse(231.0 >= 1.3,(0.5 / 1.3))) / 1.5))))) / 1.7)";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc156(long X1, int X2) {
		String exp = "(((0.6223183 + 0.3 + (X1 / (0.3 + ((0.3 + ((sine (267.0 - 267.0)) - 267.0) + (sine (0.6223183 - (sine (0.3 - 267.0))))) - (267.0 + 30.0 + (sine ((sine 70.0) - 4.0)))) + (1.7 - 267.0)))) * 267.0) + (0.9203097 * (((sine (267.0 - 267.0)) - 267.0) - 267.0) * ((sine (267.0 - (267.0 - (0.6223183 + (sine 4.0) + (((sine ((sine (1.7 - 267.0)) - (sine (267.0 / ((sine (1.7 - 267.0)) - 267.0))))) - 267.0) - (1.7 - 267.0)))))) + 30.0 + 70.0)) + X1) + X1 + 4.0";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc157(long X1, int X2) {
		String exp = "MyIfThenElse((X1 - 2.0) >= 1.9,(MyIfThenElse((X1 * 1.0 * 1.5) >= ((200.0 + 400000.0) + 0.3),(X1 * 1.0 * 1.5),(sine (X1 * 1.0 * 1.5)))),((((X1 * 1.0 * 1.5) - 0.9) - 2.0) - 2.0))";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc16(long X1, int X2) {
		return 1;
	}
	
	private double bc160(long X1, int X2) {
		String exp = "X1 + ((MyIfThenElse(30.0 >= (1000.0 - (X1 - (400000.0 - 1.0))),((sine 1.0) * X1),((sine 100.0) - (((1.0 * 1.1 * (Exp(5.0))) + ((sine 1.0) * ((sine 1.0) * X1))) + 2.0)))) + X1 + ((sine 1.0) * X1))";				
  		return evalExpression(X1, X2, exp);
	}	
	
	private double bc161(long X1, int X2) {
		String exp = "(MyIfThenElse((10.0 * 318.0) >= (X1 / 277.0),(0.7983187 / 0.552802),((X1 / 277.0) + (X1 / 277.0)))) + (X1 / 277.0)";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc162(long X1, int X2) {
		String exp = "(0.0 + (((0.0 / 30000.0) + (30000.0 - ((1.1 * X1) / 2.0))) / 2.0)) - ((X1 / (30000.0 - (sine (X1 / 2.0)))) - (X1 / 2.0))";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc167(long X1, int X2) {
		String exp = "(0.83118 * X1) / (sine 1.0)";				
  		return evalExpression(X1, X2, exp);
	}	
	
	private double bc18(long X1, int X2) {
		return 1;
	}
	
	private double bc180(long X1, int X2) {
		String exp = "(((0.7 + X1 + (30000.0 + ((sine 1.0) * (MyIfThenElse(0.3 >= 0.0,X1))) + (10.0 + X1 + X1))) + 0.1) + X1 + 10.0) + (X1 + X1 + X1)";				
  		return evalExpression(X1, X2, exp);
	}	
	
	private double bc181(long X1, int X2) {
		String exp = "((MyIfThenElse((170.0 + 10.0) >= (1.3 + 10.0 + (0.0 * 10.0)),1.3,X1)) * 1.0 * ([(0.1) >= (0.0)])) + (30000.0 + 10.0) + (MyIfThenElse((X1 ^ (0.7 + 10.0)) >= (1.0 / 0.7),(X1 / 0.7),(4.0 + 275.0)))";				
  		return evalExpression(X1, X2, exp);
	}	
	
	private double bc182(long X1, int X2) {
		String exp = "((((X1 - 30000.0) - (sine 2.0)) + X1) + (X1 + (1.9 + 0.7) + X1) + (254.0 * (sine (X1 * (((0.1 + 4.0 + 4.0) + 1.9) + 0.024692059 + (4.0 + ((1.9 + 0.7) * 4.0 * 1.9) + (1.9 + 0.7))) * ((((4.0 + ((1.9 + 0.7) * 4.0 * (X1 - 30000.0)) + X1) + 0.7) - (sine 254.0)) - (sine (((1.9 + 0.7) + 0.7) + 0.7))))) * (((1.9 + (sine X1)) * 4.0 * 1.0) * 4.0 * 4.0))) + X1 + 1.9";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc183(long X1, int X2) {
		String exp = "(X1 / (Exp(1.5))) + 200.0 + (4.0 * ((10.0 ^ 1.0) * (1.5 + (344.0 - 1.5) + ((344.0 - 1.5) ^ 1.0))))";				
  		return evalExpression(X1, X2, exp);
	}

	private double bc2(long X1, int X2) {
		String exp = "1.0 + X1";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc21(long X1, int X2) {
		String exp = "(X1 + ((X1 + 30000.0) - 30000.0)) + (((X1 + X1 + (X1 + ((X1 / 1.3) + X1 + (X1 + X1 + (X1 + (X1 + ((X1 / 1.3) + X1 + (0.3 + X1))) + (((X1 + (X1 + X1 + 1.3)) / 1.3) + (0.3 + ([(100.0) >= (100.0)])) + ([(100.0) >= ((MyIfThenElse(1000.0 >= 0.5595126,20000.0,X1)))]))))))) + ((X1 + ([(100.0) >= ((((X1 + ((X1 + X1) + (X1 + X1 + X1) + 1.3)) + ((X1 - 30000.0) + ((X1 + 30000.0) - 30000.0))) - 30000.0))])) - 1.3)) + ((X1 + X1 + 1.3) + X1 + X1)) + (((X1 + (X1 + (X1 + X1 + 1.3))) - 30000.0) - (MyIfThenElse((X1 + X1) >= (0.5 * 396.0 * 30000.0),(X1 + X1 + 1.3),(MyIfThenElse(1000.0 >= 0.5595126,20000.0,(X1 + X1 + ([(100.0) >= (100.0)])))))))";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc25(long X1, int X2) {
		String exp = "1.7 + (X1 + ((20000.0 + X1 + X1) + ((((20000.0 + X1 + X1) + X1 + X1) + ((X1 / 192.0) * (Exp(1.0)))) + 1.7 + X1)))";				
  		return evalExpression(X1, X2, exp);
	}	
	
	private double bc3(long X1, int X2) {
		return 2;
	}
	
	private double bc4(long X1, int X2) {
		String exp = "(X1 + (100.0 + ((1.1 * 309.0 * 30.0) + 0.0 + ((((X1 * 0.42640978) + 0.0 + 185.0) + 0.0 + 185.0) + 0.0 + (185.0 + (1.1 * 309.0 * 30.0) + 185.0))) + 0.0) + 100.0) + (185.0 + (1.1 * 309.0 * 30.0) + 185.0)";				
  		return evalExpression(X1, X2, exp);
	}	
	
	private double bc54(long X1, int X2) {
		String exp = "MyIfThenElse((400000.0 - 0.0) >= (X1 - 30.0),((X1 + 0.0) + ((X1 + 0.0) + ((X1 + (X1 + 0.0)) + 0.0) + (X1 + 1.0)) + X1),(X1 + (X1 + 1.0) + (X1 + (X1 + ((X1 + 1.0) + (((400000.0 + 0.9) + 0.0) + 0.0) + X1) + ((X1 + 1.0) + (((X1 + 1.0) + 1.0) * 0.7) + X1)) + (X1 + 0.0))))";				
  		return evalExpression(X1, X2, exp);
	}
	
	private double bc89(long X1, int X2) {
		String exp = "(MyIfThenElse((MyIfThenElse((1.5 + 400000.0 + (((X1 + 1.1 + (238.0 / (0.5456474 + 0.46368748 + 1.0))) / 75.0) + 1.5 + 1.5)) >= 0.82976496,((X1 + (X1 / 75.0) + 1.1) + X1 + 0.0))) >= ((X1 + X1 + 1.1) + (X1 / 75.0)),((1.1 + (X1 + 1.1 + ((((X1 / 75.0) + (0.1 + (X1 / 75.0) + X1) + X1) + (X1 + (((1.5 + 0.1 + ((1.5 + (X1 / 75.0) + X1) + (X1 + ((X1 / 75.0) + 3.0 + (X1 / 75.0)) + 1.5) + X1)) / 75.0) + (X1 + (3.0 / 3.0) + 1.5) + X1) + X1) + (3.0 / 3.0)) / 75.0)) + 75.0) + 5.0 + (sine 30.0)),X1)) + (0.9 + (X1 / 75.0) + (X1 / 75.0)) + (((X1 + (X1 / 75.0) + 1.1) + X1 + 0.0) + (X1 + (X1 / 75.0)))";				
  		return evalExpression(X1, X2, exp);
	}	
	
	private double bc90(long X1, int X2) {
		String exp = "(1000.0 + ((400000.0 + 0.75368357 + (((((X1 / 2.0) + X1 + X1) + (2.0 * 20000.0 * 0.33040345) + 30000.0) + X1 + X1) + X1 + ((X1 / 30.0) - 200.0))) + 30.0 + X1)) / 30.0";				
  		return evalExpression(X1, X2, exp);
	}	
	
	private double bc96(long X1, int X2) {
		String exp = "1.1 * ((1.1 * X1) + X1 + (1.1 * X1))";				
  		return evalExpression(X1, X2, exp);
	}	

	private double evalExpression(long X1, int X2, String exp) {	
		double result = 0;							
		
		parser.setExpression(exp);
		try {
//			parser.setX(X1);
//			parser.setY(X2);
			parser.setVariable("X1", X1);
			parser.setVariable("X2", X2);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		try {
			result = parser.getValue();			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
      	return result;	
	}

	public double getLearnedData(long filesize, int isCompressed, int bytecode) {
		
		switch (bytecode) {
			case 2: return bc2(filesize, isCompressed);
			case 3: return bc3(filesize, isCompressed);
			case 4: return bc4(filesize, isCompressed);
			case 16: return bc16(filesize, isCompressed); //NEW
			//case 17: return bc17(filesize, isCompressed);
			case 18: return bc18(filesize, isCompressed); //NEW
			case 21: return bc21(filesize, isCompressed);
			case 25: return bc25(filesize, isCompressed);
			//case 50: return bc50(filesize, isCompressed);
			case 54: return bc54(filesize, isCompressed); // NEW
			//case 58: return bc58(filesize, isCompressed);
			case 89: return bc89(filesize, isCompressed); //NEW
			case 90: return bc90(filesize, isCompressed); //NEW
			case 96: return bc96(filesize, isCompressed); //NEW
			case 100: return bc100(filesize, isCompressed); //NEW
			case 120: return bc120(filesize, isCompressed); //NEW
			case 130: return bc130(filesize, isCompressed); //NEW
			//case 132: return bc132(filesize, isCompressed);
			case 153: return bc153(filesize, isCompressed); //NEW
			case 154: return bc154(filesize, isCompressed); //NEW
			case 155: return bc155(filesize, isCompressed); //NEW
			case 156: return bc156(filesize, isCompressed); //NEW
			case 157: return bc157(filesize, isCompressed); //NEW
			case 160: return bc160(filesize, isCompressed);
			case 161: return bc161(filesize, isCompressed);
			case 162: return bc162(filesize, isCompressed); //NEW
			case 167: return bc167(filesize, isCompressed); //NEW
			case 180: return bc180(filesize, isCompressed); //NEW
			case 181: return bc181(filesize, isCompressed); //NEW
			case 182: return bc182(filesize, isCompressed); //NEW
			case 183: return bc183(filesize, isCompressed); //NEW
			//case 188: return bc188(filesize, isCompressed);
			//case 190: return bc190(filesize, isCompressed);
		}
				
		// no function learned:
		System.err.println("BC not supported");
		return -1;
	}
	
	private void initParser() {
		try {
			parser.createFunc("MyIfThenElse", new IfThenElse());
			parser.createFunc("MyIf", new IfThen());
			parser.setExpression("sin");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		parser.setOptimizationOn(true);
	}
	
}
