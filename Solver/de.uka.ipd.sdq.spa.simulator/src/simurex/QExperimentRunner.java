package simurex;

import java.util.Map;

import desmoj.core.simulator.SimTime;
import desmoj.core.util.SimRunListener;
import desmoj.extensions.experimentation.ui.ExperimentStarterApplication;
import desmoj.extensions.experimentation.ui.GraphicalObserverContext;
import desmoj.extensions.experimentation.ui.HistogramPlotter;
import desmoj.extensions.experimentation.util.AccessUtil;
import desmoj.extensions.experimentation.util.ExperimentRunner;

public class QExperimentRunner extends ExperimentRunner {
	public QExperimentRunner() {
		super();
	}

	public QExperimentRunner(QueueingModel m) {
		super(m);
	}

	public SimRunListener[] createSimRunListeners(GraphicalObserverContext c) {
		QueueingModel model = (QueueingModel) getModel();
//		HistogramPlotter ql = new HistogramPlotter("QueueLength", c,
//				model.queueLength, "length", 360, 360);
//		HistogramPlotter st = new HistogramPlotter("Sojourn Time", c,
//				model.sojournTime, "time", 360, 360);
//		return new SimRunListener[] { ql, st };
		return null;
	}

	public Map createParameters() {
		Map pm = super.createParameters();
		AccessUtil.setValue(pm, "stopTime", new SimTime(280000.0));
		return pm;
	}

	public static void main(String[] args) throws Exception {
		new ExperimentStarterApplication(QueueingModel.class,
				QExperimentRunner.class).setVisible(true);
	}
}
