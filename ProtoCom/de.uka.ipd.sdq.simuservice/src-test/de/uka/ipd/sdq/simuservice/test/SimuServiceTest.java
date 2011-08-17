/**
 * 
 */
package de.uka.ipd.sdq.simuservice.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

import org.eclipse.core.runtime.CoreException;
import org.junit.Test;

import de.uka.ipd.sdq.simuservice.SimuService;
import de.uka.ipd.sdq.simuservice.types.SimuServiceParams;
import de.uka.ipd.sdq.simuservice.types.SimuServiceResultStatus;
import de.uka.ipd.sdq.simuservice.types.SimulationResult;

/**
 * @author brosch
 * 
 */
public class SimuServiceTest {

	/**
	 * Test the SimuService execution and print the results.
	 * This test is a functional test to ensure the service can be executed in general.
	 * There is no validation of the service results.
	 * 
	 * @throws Exception Any kind of exception was thrown during the execution.
	 */
	@Test
	public void testSimuService() throws Exception {
			// Create service object:
			SimuService service = new SimuService();

			// Create parameters for simulation:
			SimuServiceParams params = createSimuServiceParams();

			// Trigger the simulation:
			SimuServiceResultStatus status = service.simulate(params);

			// Print results:
			printResults(status);
	}

	/**
	 * Test the simu service multiple times in a row.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSimuServiceRepeated() throws Exception {
		int maxExecution = 1;
		for (int i = 0; i < maxExecution; i++) {
			this.testSimuService();
		}
	}

	/**
	 * Build up the service parameter container for the test run.
	 * Default values are defined that should ensure a valid simulation run.
	 * 
	 * @return The configured SimuServiceParams object.
	 * 
	 * @throws FileNotFoundException
	 * @throws CoreException
	 * @throws IOException
	 */
	private SimuServiceParams createSimuServiceParams()
			throws FileNotFoundException, CoreException, IOException {

		// Initialize result object:
		SimuServiceParams result = new SimuServiceParams();

		// The repository model serialized into a String:
		result
				.setRepositoryModelXMIs(
						new String[] {
								SampleModelLoaderHelper.getSampleModelXMI(SampleModelLoaderHelper.REPOSITORYEXTENSION)
						});
		result
				.setRepositoryModelFileNames(
						new String[] {
								SampleModelLoaderHelper.getSampleModelFileName(SampleModelLoaderHelper.REPOSITORYEXTENSION)
						});

		// System.out.print(result.getRespositoryModelXMI());

		// The system model serialized into a String:
		result.setSystemModelXMI(SampleModelLoaderHelper
				.getSampleModelXMI(SampleModelLoaderHelper.SYSTEMEXTENSION));
		result
				.setSystemModelFileName(SampleModelLoaderHelper
						.getSampleModelFileName(SampleModelLoaderHelper.SYSTEMEXTENSION));

		// System.out.print(result.getSystemModelXMI());

		// The resource environment model serialized into a String:
		result
				.setResourceEnvironmentModelXMI(SampleModelLoaderHelper
						.getSampleModelXMI(SampleModelLoaderHelper.RESOURCEENVIRONMENTEXTENSION));
		result
				.setResourceEnvironmentFileName(SampleModelLoaderHelper
						.getSampleModelFileName(SampleModelLoaderHelper.RESOURCEENVIRONMENTEXTENSION));

		// System.out.print(result.getResourceEnvironmentModelXMI());

		// The allocation model serialized into a String:
		result
				.setAllocationModelXMI(SampleModelLoaderHelper
						.getSampleModelXMI(SampleModelLoaderHelper.ALLOCATIONEXTENSION));
		result
				.setAllocationModelFileName(SampleModelLoaderHelper
						.getSampleModelFileName(SampleModelLoaderHelper.ALLOCATIONEXTENSION));

		// System.out.print(result.getAllocationModelXMI());

		// The usage model serialized into a String:
		result.setUsageModelXMI(SampleModelLoaderHelper
				.getSampleModelXMI(SampleModelLoaderHelper.USAGEEXTENSION));
		result
				.setUsageModelFileName(SampleModelLoaderHelper
						.getSampleModelFileName(SampleModelLoaderHelper.USAGEEXTENSION));

		// System.out.print(result.getUsageModelXMI());

		// Clears the prediction server console before starting the new
		// simulation:
		result.setClearLogging(true);

		// Suppresses verbose logging on prediction server console:
		result.setVerboseLogging(false);

		// Sets the measurement count stop condition:
		result.setMaxMeasurementsCount(10000);

		// Sets the simulation time stop condition:
		result.setMaxSimTime(100000);

		// Currently unused:
		// result.setModelArchive();

		// Deprecated:
		// result.setResultsDirectory();

		// Return the result:
		return result;
	}

	/**
	 * 
	 * @param status
	 */
	private void printResults(SimuServiceResultStatus status) {

		DecimalFormat specFormat = new DecimalFormat("#0.00");
		DecimalFormat percFormat = new DecimalFormat("#0.000000");

		System.out.println("*** Simulation Results ***");
		System.out.println("Workflow created:               "
				+ status.isWorkflowCreated());
		System.out.println("Workflow parameters configured: "
				+ status.isWorkflowParamsConfigured());
		System.out.println("Workflow successfully executed: "
				+ status.isWorkflowSuccessful());
		if ((status.getException() != null)
				&& (!status.getException().isEmpty())) {
			System.out.println("Exception: " + status.getException());
		}
		for (SimulationResult result : status.getSimulationResults()) {
			System.out.println("Simulation result: " + result.getSensorName());
			for (double specification = 0.05; specification < 1.0; specification += 0.05) {
				System.out.println("Percentile: "
						+ specFormat.format(specification)
						+ "; Value: "
						+ percFormat.format(result.getPercentiles().get(
								specification)));
			}
		}
		System.out.println("*** End Simulation Results ***");
	}
}
