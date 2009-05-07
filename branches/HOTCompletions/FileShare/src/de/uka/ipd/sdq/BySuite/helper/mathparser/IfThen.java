package de.uka.ipd.sdq.BySuite.helper.mathparser;

import com.bestcode.mathparser.IFunction;
import com.bestcode.mathparser.IParameter;

public class IfThen implements IFunction {
   
    public double run(IParameter[] p){
    	if(p[0].getValue() > 0.0) {
		   return p[1].getValue();
	   	} else {
		   return 0;
	   	}	   
    }

	public int getNumberOfParams() {
		return 2;
	}   

}
