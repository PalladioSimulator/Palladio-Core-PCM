package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.util.Collection;

import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.AbstractPie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.PieEntity;

public class JFreeChartPieViewer extends AbstractJFreeChartChart<AbstractPie> {

	DefaultPieDataset pieDataset=null;
	
	public JFreeChartPieViewer(Composite parent, int style) {
		super(parent, style);
	}

	protected void initChart() {
		if(pieDataset != null)
			chart = ChartFactory.createPieChart3D("Pie", pieDataset, true, true, true);
		else
			chart = ChartFactory.createPieChart3D("Pie", new DefaultPieDataset(), true, true, true);
	}

	public void setData(Collection<AbstractPie> data){
		assert((data.size() == 1) && (data.iterator().next() instanceof AbstractPie));
		
		AbstractPie pie = (AbstractPie)data.iterator().next();
		
		pieDataset = new DefaultPieDataset();
		for (PieEntity pe : pie.getEntities(40)){
			pieDataset.setValue(pe.getLabel(), pe.getValue());
		}
		initChart();
		chart.setTitle(pie.getLabel());
		this.setChart(chart);

		this.forceRedraw();
	}
}
