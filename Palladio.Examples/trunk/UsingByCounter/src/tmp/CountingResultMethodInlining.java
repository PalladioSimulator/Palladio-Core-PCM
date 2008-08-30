package tmp;import java.io.File;
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
		scra.inlineCounts(results, new BCounts());
	}
	
	private final static String DEFAULT_PATH_WITH_SERIALISED_RESULTS = 
		"."+File.separator+"input";
	
	public List<CountingResult> inlineCounts(List<CountingResult> inputResultCounts, BCounts methodCounts) {
		List<CountingResult> returnList = new ArrayList<CountingResult>();
		
		Iterator<CountingResult> inputIterator = inputResultCounts.iterator();
		while(inputIterator.hasNext()) {
			 returnList.add(inlineCounts(inputIterator.next(), methodCounts)); 
		}
		
		return returnList;
	}
	
	/**
	 * Inlining counting results of called methods.
	 * @param inputResultCounts count of caller
	 * @param methodCounts counts of called methods (callee)
	 * @return Copy of inputResultCounts with inlined calle bytecode counts
	 */
	public CountingResult inlineCounts(CountingResult inputResultCounts, BCounts methodCounts) {
		CountingResult returnResult = (CountingResult) inputResultCounts.clone();
		returnResult.setInvariantMethodsAreInlined(true);
		
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
				if(currentBytecodeCount == null) { //if null returned no bytecode has been counted
					currentBytecodeCount = 0;
				}
				
				long oldBytecodeCounts = returnResult.getOpcodeCount(currentBytecodeInt);
//				System.out.println("old count: " + oldBytecodeCounts + " for " + currentMethod);
//				System.out.println("method counts: " + currentMethodCounts + " each with #" + currentBytecodeCount + " bytecodes to inline");
				
				if(oldBytecodeCounts == -1 && currentMethodCounts > 0 && currentBytecodeCount > 0) { //no previous count
					oldBytecodeCounts = 0; //avoid off by 1
				}
				long inlinedCount = oldBytecodeCounts + currentMethodCounts * currentBytecodeCount;
				if(inlinedCount != oldBytecodeCounts) {
					System.out.println("old count: " + oldBytecodeCounts +  " new count: " + inlinedCount + " for " + currentMethod);
				}
				returnResult.setOpcodeCount(currentBytecodeInt, inlinedCount);		
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
