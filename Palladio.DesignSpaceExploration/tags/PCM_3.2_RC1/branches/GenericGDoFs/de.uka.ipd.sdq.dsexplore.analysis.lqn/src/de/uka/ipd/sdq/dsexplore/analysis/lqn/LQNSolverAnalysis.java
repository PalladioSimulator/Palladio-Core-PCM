package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.runtime.CoreException;

import LqnCore.LqnModelType;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedCriterion;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedObjective;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;

/**
 * Starts a LQN Solver Analysis for the design space exploration.
 * 
 * @author pmerkle
 *
 */
public class LQNSolverAnalysis extends AbstractLQNAnalysis {
	
	boolean hasConverged = true;

	/**
	 * try to handle the exception or throw it back. 
	 * @param e
	 * @return
	 */
	@Override
	protected IAnalysisResult handleException(RuntimeException e, PCMInstance pcm) {
		if (e.getMessage() != null && e.getMessage().contains("exited with 1: The model failed to converge.")){
			hasConverged = false;
			return new LQNNotConvergedResult(pcm);
//		} else if (e.getMessage() != null && e.getMessage().contains("invalid input")){
//			 String inputFileName = Pcm2LqnStrategy.FILENAME_INPUT_XML;
//			 copyfile(inputFileName, inputFileName+"-invalidInput"+iteration);
//			 throw e;
//		} else if (e.getMessage() != null && e.getMessage().contains(" returned an unrecognised exit value")){
//			 String inputFileName = Pcm2LqnStrategy.FILENAME_INPUT_XML;
//			 copyfile(inputFileName, inputFileName+"-unrecognizedExit"+iteration);
//			 throw e;
		} else {
			throw e;
		}
		
	}
	
	@Override
	protected String getSolverMessageString() {
		return MessageStrings.LQNS_SOLVER;
	}

	@Override
	public boolean hasStatisticResults() throws CoreException {
		return false;
	}
	
	@Override
	protected ILQNResult retrieveResult(PCMInstance pcm,
			LqnModelType model,UsageScenarioBasedCriterion criterion) throws AnalysisFailedException {
		ILQNResult result;
		if (hasConverged){
			result = new LQNSolverAnalysisResult(model, pcm, criterion);
		} else {
			result = new LQNNotConvergedResult(pcm);
			hasConverged = true;
		}
		return result;
	}
	
	/** FIXME: just copied from the web for debugging, delete later.
	 * http://www.roseindia.net/java/beginners/CopyFile.shtml
	 * @param srFile
	 * @param dtFile
	 */
	private static void copyfile(String srFile, String dtFile){
	    try{
	      File f1 = new File(srFile);
	      File f2 = new File(dtFile);
	      InputStream in = new FileInputStream(f1);
	      
	      //For Append the file.
//	      OutputStream out = new FileOutputStream(f2,true);

	      //For Overwrite the file.
	      OutputStream out = new FileOutputStream(f2);

	      byte[] buf = new byte[1024];
	      int len;
	      while ((len = in.read(buf)) > 0){
	        out.write(buf, 0, len);
	      }
	      in.close();
	      out.close();
	      logger.info("File copied.");
	    }
	    catch(FileNotFoundException ex){
	      logger.error(ex.getMessage() + " in the specified directory.");
	    }
	    catch(IOException e){
	      logger.error(e.getMessage());      
	    }
	  }

	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		return true;
	}

	
	
}
