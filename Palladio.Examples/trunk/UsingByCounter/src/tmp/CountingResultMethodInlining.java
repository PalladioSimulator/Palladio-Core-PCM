package tmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.utils.ASMOpcodesMapper;
public class CountingResultMethodInlining {
	
	public static void main(String[] args){
		CountingResultMethodInlining scra = new CountingResultMethodInlining();
		@SuppressWarnings("unused")
		List<CountingResult> results = scra.readSerialisedCountingResults();
	}
	
	private final static String DEFAULT_PATH_WITH_SERIALISED_RESULTS = 
		"."+File.separator+"input";
	
	public List<CountingResult> inlineCounts(List<CountingResult> results) {
		return results; //TODO		
	}
	
	public CountingResult inlineCounts(CountingResult inputResultCounts, BCounts methodCounts) {
		CountingResult returnResult = (CountingResult) inputResultCounts.clone();
		//TODO: set flag for returnResult
		
		Iterator<String>methodCallIterator = returnResult.getMethodCallCounts().keySet().iterator();
		while(methodCallIterator.hasNext()) { //loop called methods (Callees)
			String currentMethod = methodCallIterator.next();
			long currentMethodCounts = returnResult.getMethodCount(currentMethod);
			
			Iterator<Integer> bytecodeListIterator = 
				ASMOpcodesMapper.getInstance().getAllOpcodes().iterator();
			while(bytecodeListIterator.hasNext()) { //loop for each bytecode
				Integer currentBytecodeInt = bytecodeListIterator.next();
				String currentBytecodeString = 
					ASMOpcodesMapper.getInstance().getOpcodeString(currentBytecodeInt);
				
				Integer currentBytecodeCount = 
					methodCounts.getCounts().get(new BytecodePos(currentMethod, currentBytecodeString));
				if(currentBytecodeCount == null) { //if null returned no bytecode have been counted
					currentBytecodeCount = 0;
				}
				
				long a = returnResult.getOpcodeCount(currentBytecodeInt) +
					currentMethodCounts * currentBytecodeCount;
				//TODO: write a back to returnResult				
			}
		}		
		return returnResult;		
	}

	
	public List<CountingResult> readSerialisedCountingResults(){		
		List<CountingResult> deserialisedResults = new ArrayList<CountingResult>();		
		File currDir = new File(DEFAULT_PATH_WITH_SERIALISED_RESULTS);
		System.out.println("Current dir: "+currDir.getAbsolutePath());
		File currSCResultFile;
		String[] currDirContents = currDir.list();
		System.out.println(currDirContents.length+" files found.");
		for (int i = 0; i < currDirContents.length; i++) {
			if(currDirContents[i].endsWith(".SCResult")){				
				currSCResultFile = new File(currDir+File.separator+currDirContents[i]);
				if(!currSCResultFile.isDirectory()){
					FileInputStream fis;
					ObjectInputStream ois;
					try {
						fis = new FileInputStream(currSCResultFile);
						ois = new ObjectInputStream(fis);
						CountingResult result = (CountingResult) ois.readObject();
						deserialisedResults.add(result);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Error! "+currSCResultFile.getAbsolutePath());
				}
			}
		}
		return deserialisedResults;
	}
}
