package vcmodel_gui;

import java.util.Map;

import desmoj.core.simulator.SimTime;
import desmoj.extensions.experimentation.ui.ExperimentStarterApplication;
import desmoj.extensions.experimentation.ui.GraphicalObserverContext;
import desmoj.extensions.experimentation.ui.HistogramPlotter;
import desmoj.extensions.experimentation.ui.TimeSeriesPlotter;
import desmoj.extensions.experimentation.util.AccessUtil;
import desmoj.extensions.experimentation.util.ExperimentRunner;
import desmoj.core.util.SimRunListener;
// import desmoj.gui.
// import desmoj.gui.TimeSeriesPlotter;

/**
 * @author Nicolas Knaak
 * @author Philip Joschko
 *
 * A demo experiment runner
 */
public class VCExperimentRunner extends ExperimentRunner {
	
	public VCExperimentRunner() {
		super();
	}
	
	public VCExperimentRunner(Vancarrier_1st_p_model m) {
		super(m);
	}
	
	public SimRunListener[] createSimRunListeners(GraphicalObserverContext c) {
		Vancarrier_1st_p_model model = (Vancarrier_1st_p_model)getModel();
		TimeSeriesPlotter tp1 = new TimeSeriesPlotter("Trucks",c, model.trucksArrived, 360,360);
		tp1.addTimeSeries(model.trucksServiced);
		HistogramPlotter hp = new HistogramPlotter("Truck Wait Times", c, model.waitTimeHistogram,"h", 360,360, 365,0);
		return new SimRunListener[] {tp1, hp};
	}
	
	public Map createParameters() {
		Map pm = super.createParameters();
		AccessUtil.setValue(pm, "stopTime", new SimTime(2800.0));
		return pm;
	}
	
	public static void main(String[] args) throws Exception {
		new ExperimentStarterApplication(Vancarrier_1st_p_model.class, VCExperimentRunner.class).setVisible(true);
	}
}
