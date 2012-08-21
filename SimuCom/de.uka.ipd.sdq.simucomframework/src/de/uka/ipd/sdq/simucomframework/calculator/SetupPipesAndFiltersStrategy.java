package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.IRawWriteStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.RawRecorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.Recorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderExtensionHelper;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorListener;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SetupPipesAndFiltersStrategy implements ISetupDataSinkStrategy {

    /** Logger for this class. */
	private static final Logger logger = Logger.getLogger(SetupPipesAndFiltersStrategy.class);

	/**
	 * Reference to the class implementing the write strategy whose instances will be used to 
	 * finally persist recorded data. 
	 */
	private final Class<? extends IRawWriteStrategy> rawWriteStrategyClass;

	public SetupPipesAndFiltersStrategy(final SimuComModel model) {
	    super();
	    
		this.rawWriteStrategyClass = getRawWriteStrategyClass(model);
	}

    public PipesAndFiltersManager setupDataSink(Calculator calculator, MetaDataInit metaData) {

		Recorder recorder = new RawRecorder(instanciateWriteStrategy());
		final PipesAndFiltersManager pipeManager = new PipesAndFiltersManager(recorder);
		pipeManager.initialize(metaData);

		calculator.addCalculatorListener(createCalculatorListener(pipeManager));

		return pipeManager;
	}

    /** Create the calculator listener used to recieve calculator events. The returned calculator listener
     * has to hand over received data to its pipe and filter structure.
     * 
     * @param pipeManager
     * @return
     */
    protected ICalculatorListener createCalculatorListener(final PipesAndFiltersManager pipeManager) {
        return new ICalculatorListener() {

			public void calculated(Vector<Measure<?, ? extends Quantity>> resultTuple) {
				pipeManager.processData(new PipeData(resultTuple));
			}
		};
    }

    @SuppressWarnings("unchecked")
    private Class<IRawWriteStrategy> getRawWriteStrategyClass(SimuComModel model) {
        try {
            String writeStrategyClass = RecorderExtensionHelper
                    .getWriteStrategyClassNameForName(model.getConfiguration().getRecorderName());
            return (Class<IRawWriteStrategy>) Class.forName(writeStrategyClass);
        } catch (CoreException e) {
            if(logger.isEnabledFor(Level.ERROR)) {
                logger.error("Could not create write strategy.", e);
            }
        } catch (ClassNotFoundException e) {
            if(logger.isEnabledFor(Level.ERROR)) {
                logger.error("Could not create write strategy.", e);
            }
        }
        throw new RuntimeException("Could not find write strategy class");
    }

	private IRawWriteStrategy instanciateWriteStrategy() {
		try {
		    return this.rawWriteStrategyClass.newInstance();
		} catch (InstantiationException e) {
			if(logger.isEnabledFor(Level.ERROR)) {
				logger.error("Could not create write strategy.", e);
			}
		} catch (IllegalAccessException e) {
			if(logger.isEnabledFor(Level.ERROR)) {
				logger.error("Could not create write strategy.", e);
			}
		}
        throw new RuntimeException("Could not instanciate write strategy class");
	}
}
