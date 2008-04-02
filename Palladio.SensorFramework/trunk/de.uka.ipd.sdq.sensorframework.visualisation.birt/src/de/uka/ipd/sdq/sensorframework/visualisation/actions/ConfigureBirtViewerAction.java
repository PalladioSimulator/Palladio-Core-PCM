package de.uka.ipd.sdq.sensorframework.visualisation.actions;

import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.BaseSampleData;
import org.eclipse.birt.chart.model.data.DataFactory;
import org.eclipse.birt.chart.model.data.DataSet;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.OrthogonalSampleData;
import org.eclipse.birt.chart.model.data.Query;
import org.eclipse.birt.chart.model.data.SampleData;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.QueryImpl;
import org.eclipse.birt.chart.model.type.BarSeries;
import org.eclipse.birt.chart.model.type.impl.BarSeriesImpl;
import org.eclipse.birt.chart.ui.swt.wizard.ChartWizard;
import org.eclipse.birt.chart.ui.swt.wizard.ChartWizardContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.sensorframework.visualisation.birt.DataServiceProvider;
import de.uka.ipd.sdq.sensorframework.visualisation.birt.UIServiceProvider;

public class ConfigureBirtViewerAction extends Action implements IAction {

	private ChartWithAxes cwa;

	public ConfigureBirtViewerAction(ChartWithAxes cwa) {
		super();
		this.setText("Configure Birt Viewer...");
		this.cwa = cwa;
	}

	@Override
	public void run() {
		ChartWizard wiz = new ChartWizard(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		ChartWizardContext ctx = new ChartWizardContext(null);
		ctx.setModel(cwa);
		
		Axis xAxisPrimary = cwa.getPrimaryBaseAxes()[0];
		Axis yAxisPrimary = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);		

		DataSet xDs = ((Series)((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).getDataSet();
		DataSet yDs = ((Series)((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).getDataSet();
		((Series)((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).setDataSet(null);
		((Series)((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).setDataSet(null);
		SampleData sdt = DataFactory.eINSTANCE.createSampleData();
		BaseSampleData sdBAse = DataFactory.eINSTANCE.createBaseSampleData();
		sdBAse.setDataSetRepresentation("A");
		sdt.getBaseSampleData().add(sdBAse);
		OrthogonalSampleData sdOrth = DataFactory.eINSTANCE.createOrthogonalSampleData();
		sdOrth.setDataSetRepresentation("1");
		sdOrth.setSeriesDefinitionIndex(0);
		sdt.getOrthogonalSampleData().add(sdOrth);
		cwa.setSampleData(sdt);
		
		ctx.setDataServiceProvider( new DataServiceProvider());
		ctx.setUIServiceProvider(new UIServiceProvider());
		wiz.open(ctx);

		((Series)((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).setDataSet(xDs);
		((Series)((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries().get(0)).setDataSet(yDs);
		
		
		cleanEList(((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries());
		cleanEList(((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries());

		Query q = QueryImpl.create("");
		NumberDataSet categoryValues = NumberDataSetImpl.create(new double[] { 1, 2, 3});

		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(categoryValues);
		seCategory.getDataDefinition().add(q);
		((SeriesDefinition)xAxisPrimary.getSeriesDefinitions().get(0)).getSeries().add(seCategory);
		
		NumberDataSet orthovalues = null;
			orthovalues = NumberDataSetImpl.create(new double[]{0.2,0.3,0.4});
			
			BarSeries series = (BarSeries) BarSeriesImpl.create();
			series.setDataSet(orthovalues);
			series.getDataDefinition().add(q);
			series.getLabel().getCaption().setValue("Sensor");
			series.getLabel().setVisible(true);
			((SeriesDefinition)yAxisPrimary.getSeriesDefinitions().get(0)).getSeries().add(series);

			//series.setSeriesIdentifier(s.getSensorName() + " [ID:"
			//		+ s.getSensorID() + "]");

		
	}
	
	private void cleanEList(EList list){
		while (list.size() > 0)
			list.remove(0);
	}
	
}
