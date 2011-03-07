package de.uka.ipd.sdq.sensorframework.visualisation.statistics.views;

import java.util.Collection;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views.AbstractHtmlReportView;
import de.uka.ipd.sdq.statistics.PhiMixingBatchAlgorithm;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;
import de.uka.ipd.sdq.statistics.estimation.SampleMeanEstimator;
import de.uka.ipd.sdq.statistics.independence.RunUpTest;

/**
 * Report that calls {@link PhiMixingBatchAlgorithm} to determine the confidence intervals, 
 * also considering independence of the observations. The {@link RunUpTest} is used
 * as the default to test the data sequence for independence. 
 * @author martens
 * @see PhiMixingBatchAlgorithm
 * @see RunUpTest
 */
public class ConfidenceIntervalsHtmlReportView extends AbstractHtmlReportView {

	@Override
	public void setInput(Collection<SensorAndMeasurements> c) {
		if (c.isEmpty()) {
			browser.setText("<html><body><h1>Error! </h1>At least "
					+ "the measurements for one sensor must be "
					+ "available!</body></html>");
		} else {
			String browserText = "<html><body><h1>Confidence intervals for mean values of sensors</h1>";
			
			// TODO: make alpha configurable. 
			double alpha = 0.9;
			
			for (SensorAndMeasurements sensorAndMeasurements : c) {
				Sensor sensor = sensorAndMeasurements.getSensor();
				if (sensor instanceof TimeSpanSensor){
					PhiMixingBatchAlgorithm statisticChecker = new PhiMixingBatchAlgorithm();
								
					for (Measurement m : sensorAndMeasurements.getMeasurements()) {
						TimeSpanMeasurement t = (TimeSpanMeasurement)m;
						statisticChecker.offerSample(t.getTimeSpan());
					}
					ConfidenceInterval ci;
					browserText += "<h3>Sensor "+sensor.getSensorName()+"</h3>";
					browserText += "<p>Number of observations: "+sensorAndMeasurements.getMeasurements().size()+"<br>";
					
					if (statisticChecker.hasValidBatches()){
						ci = new SampleMeanEstimator().estimateConfidence(statisticChecker.getBatchMeans(),alpha);
						
						browserText += "Mean value: "+ci.getMean() +"<br>"+
							" Confidence value alpha: "+ci.getLevel()+"<br>"+
							" Upper bound: "+ci.getUpperBound()+"<br>"+
							" Lower bound: "+ci.getLowerBound()+"<br>"+
							" </p>";
					} else {
						// calculate mean manually
						double sum = 0;
						for (Measurement m : sensorAndMeasurements.getMeasurements()) {
							TimeSpanMeasurement t = (TimeSpanMeasurement)m;
							sum += t.getTimeSpan();
						}
						double mean = sum / sensorAndMeasurements.getMeasurements().size();
						browserText += "Mean value: "+mean +"</p><p>";
						
						browserText += "Not enough information to calulate confidence interval: No valid batches could be determined to calculate the confidence interval. Maybe warmup effects influence the results.</p>";
					}

				}
			}
			browserText += "<small><p>PhiMixingBatchAlgorithm: Implements a batch means procedure based on phi-mixing conditions as described in [1]. " +
					"Appropriate batch sizes and the number of batches are determined automatically.</p>" +
			        "<p>The procedure utilizes an independence test in order to build a so-called \"quasi " +
			        "independent\" (QI) sample sequence. By default the RunUpTest will be used. \"The aim " +
			        "of the QI method is to continue the simulation run  until we have obtained a pre-specified " +
			        "number of essentially independent random samples by skipping highly correlated observations.\" [1] " +
			        "As soon as the QI sequence appears to be independent, the computed batches can be considered as valid. " +
			        "Samples in the QI sequence are only used to determine appropriate batch sizes. " +
			        "They are not used to compute the batch means! Instead, the batch means consist of all samples, " +
			        "regardless of statistical dependence.</p>"+
			        "<p>The RunUpTest is implemented as described in [Donald E. Knuth: The Art of Computer Programming. Seminumerical Algorithms].</p>"+
					"<p>[1] E. Chen, W. Kelton: A Stopping Procedure based on Phi-Mixing Conditions. Proceedings of the 2000 Winter Simulation Conference.</p>" +
					"</small></body></html>";
			browser.setText(browserText);
		}
		
	}
	


}
