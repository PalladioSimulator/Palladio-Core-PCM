package de.uka.ipd.sdq.BySuite.counting;

import com.bestcode.mathparser.IMathParser;
import com.bestcode.mathparser.MathParserFactory;

import de.uka.ipd.sdq.BySuite.mathparser.IfThen;
import de.uka.ipd.sdq.BySuite.mathparser.IfThenElse;

public class PalladioFileShareLearnedBytecode {
	
	public static int[] LEARNED_BYTECODES = {
		//1, //ACONST_NULL 
		2,   //ICONST_M1 //TODO add benchmark
		3,   //ICONST_0
		4,   //ICONST_1
		17,  //SIPUSH
		21,  //ILOAD
		
		25,  //ALOAD
		50,  //AALOAD
		51,  //BALOAD
		//54, //ISTORE
		58,  //ASTORE
		//83,  //AASTORE
		//84,  //BASTORE
		//85,  //CASTORE
		//87, //POP
		132, //IINC
		
		160, //IF_ICMPNE
		161, //IC_ICMPLT
		//167, //GOTO
		188, //NEWARRAY
		//189, //ANEWARRAY
		190, //ARRAYLENGTH
		};

	public static void main(String[] args) {
										//file / compr / BC
		System.out.println( new PalladioFileShareLearnedBytecode().getLearnedData(12000, 1, 50) );
	}
	
	private IMathParser parser = MathParserFactory.create();
	
	public PalladioFileShareLearnedBytecode() {
		// init only once
		initParser();
	}
	
	private double bc132(long X1, int X2) {
		String exp = "((X1 + 1.1 + (5.0 + (328.0 * X1 * X2))) + X1) + ((((X1 + 4.0 + (328.0 * X1 * 4.0)) + 223.0 + 121.0) + (X2 + X1) + 223.0) + 223.0 + 121.0) + ((MyIfThenElse(4.0 >= (5.0 + (328.0 * X1 * X2)),(173.0 * 4.0 * 1.5),X2)) + 223.0 + 121.0)";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc160(long X1, int X2) {
		String exp = "4.0 * ((X2 + (0.7 * X1 * 162.0) + (0.7 * X1 * 162.0)) + ((3.0 ^ X2) + (X2 - X2) + ((((0.7 * X1 * 1.5) + (MyIf((76.0 + 200.0 + 0.1) >= 20000.0,X1)) + X1) + (((MyIfThenElse(0.9 >= X1,5.0,(0.7 * X1 * (1000.0 ^ X2)))) + 5.0) - X2) + (MyIfThenElse(X1 >= X1,X1,X1))) + X1 + (4.0 / 0.7841332))) + X1)";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc161(long X1, int X2) {
		String exp = "(1.9 + (X1 + 113.0 + (400000.0 + ((30.0 * 1.1 * 0.34182966) * X1 * 4.0) + (30000.0 / 148.0)))) + 376.0 + ((3.0 + (30000.0 + (X1 - 200.0) + ((113.0 * X2 * X1) + ((113.0 * X1 * 4.0) + 1.3 + (0.7906137 / (30000.0 / 148.0))) + X1)) + (399.0 * X1 * 3.0)) + (((X2 * (X1 + (113.0 * X1 * 4.0) + (X2 - 10.0))) - 10.0) + (0.7906137 / 257.0)) + 376.0)";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc17(long X1, int X2) {
		String exp = "((X1 - X2) - 367.0) * (sin (1.5 ^ X2))";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc188(long X1, int X2) {
		String exp = "X1 + (X1 - ((((X2 + ((X2 + X2 + (((((360.0 + X2 + 360.0) / (Exp(X2))) + (X2 + 28.0 + 5.0) + 360.0) / (Exp(X2))) + X2 + X2)) * 5.0) + X2) / (Exp(X2))) + X2 + X2) + X2 + X2))";				
      	return evalExpression(X1, X2, exp);
	}

	private double bc190(long X1, int X2) {
		String exp = "((((5.0 + (1.1 * X1 * 10.0)) + (MyIfThenElse(93.0 >= 93.0,0.5,93.0))) + X2) + ((1.9 + ((5.0 * X1 * 93.0) + (5.0 + (1.1 * X1 * 10.0)))) + ((((5.0 * X1 * 93.0) + 183.0) + ((((5.0 * X1 * 93.0) + (1.1 * 5.0 * 5.0)) + 100.0) * X2 * 0.1)) + (5.0 * 5.0 * 5.0)))) + 100.0";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc2(long X1, int X2) {
		return X1 + X1 + 3.0;	
	}
	
	private double bc21(long X1, int X2) {
		String exp = "((0.12728024 + 1.7 + X2) * (0.12728024 * X1) * (0.12728024 * 1000.0 * 213.0)) - (Exp((0.12728024 / 0.12728024)))";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc25(long X1, int X2) {
		String exp = "((X1 * 199.0) + (1.3 + 4.0 + ((1.7 ^ X2) * (X1 * 199.0) * (9.0 - X2))) + ((X1 * 199.0) - 199.0)) + ((X1 + X1) + (10.0 * 1000.0) + (X1 * 199.0)) + (X1 * 199.0)";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc3(long X1, int X2) {
		String exp = "315.0 + 315.0 + ((MyIF(0.7244477 >= (71.0 + 0.0),315.0)) + (X1 + (((((71.0 + 0.0) * X1) + (211.0 + (X2 * (0.7244477 + (0.7244477 + (0.7244477 + ((333.0 * (MyIF(0.7244477 >= (MyIF(0.7244477 >= 0.7244477,315.0)),(333.0 * X1)))) * 0.7244477) + (((211.0 * X1) + 315.0 + ((MyIF(0.7244477 >= (MyIF(0.7244477 >= 0.7244477,315.0)),315.0)) + (333.0 * 0.7244477))) + X1)) + (333.0 * X1)) + 333.0)) + X1) + (MyIF(0.7244477 >= (71.0 + 0.0),(333.0 * (348.0 * X1))))) + (0.7244477 + ((X1 + (Exp(X2))) + (348.0 * X1) + 0.7244477) + 333.0) + (0.7244477 + (MyIF(0.7244477 >= (333.0 * 0.7244477),(0.7244477 + (4.0 + 0.37233508) + X1))) + X1)) + (333.0 * X1)) + 4.0))";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc4(long X1, int X2) {
		String exp = "((X1 * 1.1 * 347.0) + (sin (MyIF(93.0 >= (MyIF(20000.0 >= X2,X2)),1000.0))) + (273.0 * X2 * X1)) + (SIN((X2 * 1.9 * 1.9) / (0.7 / 10.0))) + 0.9";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc50(long X1, int X2) {
		String exp = "(X1 * 392.0) + (64.0 + (X1 * (MyIfThenElse(35.0 >= X2,392.0,(1.9 + X1 + 5.0))))) + ((X1 * 30.0) * (4.0 + (MyIf(X2 >= 392.0,(1.9 + (64.0 + (0.53918666 + (4.0 + (4.0 + (MyIfThenElse(139.0 >= 0.026080012,1.1,100.0)) + 2.0) + 2.0)))))) + (Exp(X2))))";				
      	return evalExpression(X1, X2, exp);
	}
	
	private double bc51(long X1, int X2) {
		String exp = "((MyIF((155.0 + (sin(X2)) + 356.0) >= X1,356.0)) + X2 + 356.0) + ((155.0 + X2 + (MyIF((X2 * (400000.0 - 100.0) * X1) >= X1,356.0))) + (X1 * ((0.30710447 + ((MyIF(0.9 >= X1,356.0)) + (MyIF((0.30710447 + X2 + X2) >= 0.9,(MyIF(X1 >= 0.9,51.0)))) + X2) + (X2 * 100.0)) + (155.0 + (MyIF((X2 * 356.0 * X1) >= X1,356.0)) + (MyIF(X1 >= 0.9,51.0))) + (0.30710447 + X2 + X2))) + (155.0 + (MyIF(X1 >= 0.9,51.0)) + (X1 * (155.0 + ((MyIF((155.0 + (0.5 / 0.12519497) + 356.0) >= X1,356.0)) + (MyIF(X1 >= 0.9,51.0)) + 356.0) + X2)))) + X2";				
      	return evalExpression(X1, X2, exp);
	}

	private double bc58(long X1, int X2) {
		String exp = "MyIfThenElse((217.0 * X1) >= X2,((((100.0 * X1 * X2) * (0.7 * 217.0)) / X1) + ((100.0 * X1 * X2) + (217.0 * X1) + (1.3 + (217.0 * X1) + ((268.0 + 203.0) * (MyIf(217.0 >= 0.02760756,X1))))) + (MyIf((X1 + X2 + (X1 / X1)) >= 1.7,0.02760756))),268.0)";				
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
			case 17: return bc17(filesize, isCompressed);
			case 21: return bc21(filesize, isCompressed);
			case 25: return bc25(filesize, isCompressed);
			case 50: return bc50(filesize, isCompressed);
			case 51: return bc51(filesize, isCompressed);
			case 58: return bc58(filesize, isCompressed);
			case 132: return bc132(filesize, isCompressed);
			case 160: return bc160(filesize, isCompressed);
			case 161: return bc161(filesize, isCompressed);
			case 188: return bc188(filesize, isCompressed);
			case 190: return bc190(filesize, isCompressed);
		}
				
		// no function learned:
		System.err.println("BC not supported");
		return -1;
	}
	
	private void initParser() {
		try {
			parser.createFunc("MyIfThenElse", new IfThenElse());
			parser.createFunc("MyIf", new IfThen());
			//parser.setExpression("SIN");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		parser.setOptimizationOn(true);
	}
}
