package de.uka.ipd.sdq.codegen.simudatavisualization.actions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.ModelPackage;
import org.eclipse.birt.chart.model.attribute.DataType;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.TextDataSet;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.TextDataSetImpl;
import org.eclipse.birt.chart.ui.swt.interfaces.IDataServiceProvider;
import org.eclipse.birt.chart.ui.swt.interfaces.IUIServiceProvider;
import org.eclipse.birt.chart.ui.swt.wizard.ChartWizard;
import org.eclipse.birt.chart.ui.swt.wizard.ChartWizardContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class CallChartDialogAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public CallChartDialogAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		// Use workbench shell to open the dialog
		Shell parentShell = null;
		if ( PlatformUI.isWorkbenchRunning( ) )
		{
			parentShell = PlatformUI.getWorkbench( )
					.getDisplay( )
					.getActiveShell( );
		}
		ChartWithAxes cwa = (ChartWithAxes) loadFromXMI("D:/studienarbeit/resource/defalutconfig.xml");
		// CUSTOMIZE THE X-AXIS
		Axis xAxisPrimary = cwa.getPrimaryBaseAxes()[0];

		// CUSTOMIZE THE Y-AXIS
		Axis yAxisPrimary = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);

		// INITIALIZE A COLLECTION WITH THE X-SERIES DATA
		TextDataSet categoryValues = TextDataSetImpl.create(new String[]{"1","3","2"});

		// Series seCategory = SeriesImpl.create();
		// seCategory.setDataSet(categoryValues);

		// WRAP THE BASE SERIES IN THE X-AXIS SERIES DEFINITION
		Series seriesX = (Series) (((SeriesDefinition) xAxisPrimary
				.getSeriesDefinitions().get(0)).getSeries().get(0));
		//seriesX.setDataSet(categoryValues);
		//
		// INITIALIZE A COLLECTION WITH THE Y-SERIES DATA
		NumberDataSet orthoValues1 = null;
		for (int i=0; i<2; i++){
			orthoValues1 = NumberDataSetImpl.create(new double[]{1,2,3});
			Series series = (Series) (((SeriesDefinition) yAxisPrimary
						.getSeriesDefinitions().get(i)).getSeries().get(0));
			//series.setDataSet(orthoValues1);
		}
		ChartWizard wiz = new ChartWizard(parentShell);
		ChartWizardContext ctx = new ChartWizardContext(null);
		ctx.setModel(cwa);
		ctx.setDataServiceProvider( new IDataServiceProvider(){

			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public String[] getAllDataSets() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String[] getAllStyleDisplayNames() {
				return new String[]{"None"};
			}

			@Override
			public String[] getAllStyles() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getBoundDataSet() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getCurrentStyle() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] getDataForColumns(String[] expressions,
					int maxRecords, boolean byRow) throws ChartException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public DataType getDataType(String expression) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List getPreviewData() throws ChartException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String[] getPreviewHeader() throws ChartException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getReportDataSet() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int invoke(int command) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isInvokingSupported() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isLivePreviewEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setContext(Object context) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setDataSet(String datasetName) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setStyle(String styleName) {
				// TODO Auto-generated method stub
				
			}
			
		} );
		ctx.setUIServiceProvider(new IUIServiceProvider(){

			@Override
			public double getConvertedValue(double originalValue,
					String fromUnits, String toUnits) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List getRegisteredKeys() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getValue(String key) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String invoke(String expression, Object Context, String title) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String invoke(String expression, Object Context,
					String title, boolean isChartProvider) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String invoke(int command, String value, Object context,
					String title) throws ChartException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isInvokingSupported() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String[] validate(Chart chartModel, Object context) {
				// TODO Auto-generated method stub
				return null;
			}});
		wiz.open(ctx);
		try {
			ctx.getModel().eResource().save(System.out, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static EObject loadFromXMI(String fileName) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extentions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI,
				ModelPackage.eINSTANCE);

		// Construct the URI for the instance file.
		// The argument is treated as a file path only if it denotes an existing
		// file. Otherwise, it's directly treated as a URL.
		File file = new File(fileName);
		URI uri = file.isFile()
				? URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(fileName);

		// Demand load resource for this file.
		Resource resource = resourceSet.getResource(uri, true);
		// System.out.println("Loaded " + uri);

		EObject eObject = (EObject) resource.getContents().get(0);
		return EcoreUtil.getRootContainer(eObject);
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}