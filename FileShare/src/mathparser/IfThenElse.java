package mathparser;

import com.bestcode.mathparser.IFunction;
import com.bestcode.mathparser.IParameter;

public class IfThenElse implements IFunction {
   
    public double run(IParameter[] p){
    	if(p[0].getValue() > 0.0) {
		   return p[1].getValue();
	   	} else {
		   return p[2].getValue();
	   	}	   
    }

	@Override
	public int getNumberOfParams() {
		return 3;
	}   

}
