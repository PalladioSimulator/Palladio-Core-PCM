import de.uka.ipd.sdq.simucomframework.ExperimentRunner;
import de.uka.ipd.sdq.simucomframework.IUsageScenario;
import de.uka.ipd.sdq.simucomframework.SimuComFactory;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import qosa_upload_usage.impl.QoSA_Upload_Usage;

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
		model.setUsageScenarios(new IUsageScenario[]{
				new QoSA_Upload_Usage(model)});
		ExperimentRunner.run(model, 1500);
	}
}
