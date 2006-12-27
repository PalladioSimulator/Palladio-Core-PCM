
public aspect LoggingAspect {
    protected static int callDepth = 0;
    
    protected static String getSpace(int depth)
    {
    	String result = "";
    	for (int i=0; i < depth; i++) result += "  ";
    	return result;
    }
    
    pointcut myClass(): within(*.impkkl.*);
    pointcut myRunner(): execution(* scenarioRunner(..));
	/**
     * The methods of those classes.
     */
    pointcut myMethod(): myClass() && execution(* *(..)) && cflowbelow(myRunner());

    /**
     * Prints trace messages before and after executing constructors.
     */
    before (): myMethod() {
    	callDepth++;
        System.out.println(getSpace(callDepth)+"Entering: "+thisJoinPointStaticPart.getSignature());
    }
    after(): myMethod() {
        System.out.println(getSpace(callDepth)+"Leaving: "+thisJoinPointStaticPart.getSignature());
    	callDepth--;
    }	
}
