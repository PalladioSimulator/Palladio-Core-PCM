package mediastorerepository.impl.ports;


// Port class for ISound_DigitalWatermarking
public class ISound_DigitalWatermarking implements mediastorerepository.ISound {
    protected mediastorerepository.impl.IDigitalWatermarking myComponent = null;

    public ISound_DigitalWatermarking() {
    }

    public ISound_DigitalWatermarking(
        mediastorerepository.impl.IDigitalWatermarking myComponent) {
        this.myComponent = myComponent;
    }

    public byte[] watermark(byte[] fileToMark) {
    	//byte[] result;
    	//System.out.println("Port Watermark start: "+System.nanoTime());
        return myComponent.iSound_watermark(fileToMark);
    	//System.out.println("Port Watermark stop: "+System.nanoTime());
        // return result;
    }
}
