package simurex;

import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.spa.SPAModel;
import de.uka.ipd.sdq.spa.util.EMFTools;
import desmoj.core.dist.RealDistEmpirical;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimTime;
import flanagan.complex.Complex;

public class QueueingModel extends Model {

	private static final double EPSILON = 0.0001;

	protected Monitoring queueLength;

	protected Monitoring sojournTime;

	private RealDistEmpirical serviceTime;

	private RealDistEmpirical thinkTime;

	protected ProcessQueue resourceQueue;

	protected ProcessQueue idleServerQueue;

	private int numCustomers;

	private int numServer;

	public QueueingModel(Model owner, String name, boolean showInReport,
			boolean showIntrace) {
		super(owner, name, showInReport, showIntrace);
		// TODO Auto-generated constructor stub

		queueLength = new Monitoring();
		sojournTime = new Monitoring();

		numCustomers = 20;
		numServer = 1;
	}

	public QueueingModel() {
		this(null, "Queueing Model", true, true);
	}

	@Override
	public String description() {
		return "Simple Queueing Network Model.";
	}

	@Override
	public void doInitialSchedules() {

		Server server = null;
		for (int i = 0; i < numServer; i++) {
			server = new Server(this, "Server", true);
			server.activate(new SimTime(0));
		}

		Customer customer = null;
		for (int i = 0; i < numCustomers; i++) {
			customer = new Customer(this, "Customer", true);
			customer.activate(new SimTime(i*4));
		}
	}

	public double getServiceTime() {
		return serviceTime.sample();
	}

	public double getThinkTime() {
		return thinkTime.sample();
	}

	@Override
	public void init() {

		SPAModel model = (SPAModel) EMFTools.loadFromXMI("Simple.model");

//		Behaviour customer = (Behaviour) model.getProcesses().get(0);
//		Semaphore queue = (Semaphore) model.getResources().get(0);

//		serviceTime = getEmpirical(FixIt.getServiceTime(customer, queue),
//				"serviceTime");
//		thinkTime = getEmpirical(FixIt.getThinkTime(customer), "thinkTime");

		resourceQueue = new ProcessQueue(this, "resourceQueue", true, false);
		idleServerQueue = new ProcessQueue(this, "idleQueue", true, false);

	}

	private RealDistEmpirical getEmpirical(ISamplePDF pdf, String name) {
		RealDistEmpirical result = new RealDistEmpirical(this, name, true,
				false);

		double freq = 0;
		double pos = pdf.getDistance() / 2;
		for (Complex point : pdf.getValues()) {
			if (point.getReal() > EPSILON) {
				if (freq == 0) {
					double zeroPos = Math.max(pos - pdf.getDistance(), 0);
					result.addEntry(zeroPos, 0.0);
				}
				freq += point.getReal();
				result.addEntry(pos, freq);
			}
			pos += pdf.getDistance();
		}
		if (freq < 1.0) {
			result.addEntry(1.0, pos);
		}
		return result;
	}

	public static void main(java.lang.String[] args) {

		Experiment exp = new Experiment("Q");

		QueueingModel queueingModel = new QueueingModel(null, "Q", true, false);
		queueingModel.connectToExperiment(exp);

		exp.stop(new SimTime(1500000));
		exp.setShowProgressBar(true);
		exp.start();
		exp.report();
		exp.finish();
		
		
//		Visualization vis = new Visualization(1,"Simulation Results");
//		vis.addDistributionFunction(queueingModel.queueLength.getDistFunc(1), "QueueLength");
//		vis.addDistributionFunction(queueingModel.sojournTime.getDistFunc(1), "Sojourn Time");
//		vis.visualizeOverlay();
		
		exp = null;
		queueingModel = null;
		System.out.println("Total: "
				+ Runtime.getRuntime().totalMemory()
				+ "\tFree: "
				+ Runtime.getRuntime().freeMemory()
				+ "\tUsed: "
				+ (Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
						.freeMemory()));
	}

}
