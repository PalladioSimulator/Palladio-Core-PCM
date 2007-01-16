import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.SubstanceLookAndFeel;

import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.TimeSpanSensorToDatasetAdapterFactory;
import de.uka.ipd.sdq.sensorframework.gui.MainGUI;


public class Main {
	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {
			System.out.println("The substance GUI lib is required for execution but was not found in the classpath!");
			e1.printStackTrace();
			System.exit(-1);
		}

		AdapterRegistry.singleton().addAdapterFactory(new TimeSpanSensorToDatasetAdapterFactory());
		MainGUI frame = new MainGUI();
		frame.setVisible(true);
	}
}
