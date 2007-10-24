package mediastorerepository.impl;

public class DigitalWatermarking implements mediastorerepository.impl.IDigitalWatermarking {
    protected mediastorerepository.impl.ports.ISound_DigitalWatermarking m_portISound =
        new mediastorerepository.impl.ports.ISound_DigitalWatermarking(this);
    protected mediastorerepository.impl.contexts.IDigitalWatermarkingContext myContext =
        null;

    public mediastorerepository.ISound getPortISound() {
        return m_portISound;
    }

    public void setContext(
        mediastorerepository.impl.contexts.IDigitalWatermarkingContext myContext) {
        this.myContext = myContext;
    }

    public static int step = 1;
    public byte[] iSound_watermark(byte[] fileToMark) {
        /*PROTECTED REGION ID(watermark__V8B2w6YFEduWZfldHy3B1Q__R63R9KYGEduWZfldHy3B1Q) ENABLED START*/

        // Internal calculation <>
        // TODO: Implement me!

        // Hint: Here should be an action which has a ResourceDemand of type CPU_AppServer
        //       => DoublePDF(unit="unit")[ (10.0; 0.8) (11.0; 0.1) (12.0; 0.1) ]
    	byte[] result = new byte[fileToMark.length];
    	for (int j=0; j<2; j++){
	    	for (int i=0; i<fileToMark.length; i++){
	    		result[i] = (byte)((int)fileToMark[i] ^ 0x4);
	    	}
    	}
    	return result;
        /*PROTECTED REGION END*/
    }
}
