import uscenario.impl.UScenario;
import de.uka.ipd.sdq.simucomframework.ExperimentRunner;
import de.uka.ipd.sdq.simucomframework.IUsageScenario;
import de.uka.ipd.sdq.simucomframework.SimuComFactory;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;


/**
 * 
 */

/**
 * @author Snowball
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimuComModel model = 
			SimuComFactory.getSimuComModel( 
                "SimuCom Model", true, true);
//		model.setUsageScenarios(new IUsageScenario[]{
//				new QoSA_Upload_Usage(model)});
		model.setUsageScenarios(new IUsageScenario[]{
				new UScenario(model)});
		ExperimentRunner.run(model, 150000);
	}
}
