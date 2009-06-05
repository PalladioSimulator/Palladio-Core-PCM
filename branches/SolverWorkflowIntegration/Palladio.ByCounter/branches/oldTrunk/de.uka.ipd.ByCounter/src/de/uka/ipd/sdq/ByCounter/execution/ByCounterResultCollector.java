
public class ByCounterResultCollector {
    
    boolean lazyEvaluation;
    
    //TODO replace this by a database --> HSQL? Fouad's experience and table?
    ByCounterMap<CountingInformation, CountingResults> countingResults;
    ByCounterMap<String, List<CountingInformation>>    countingInformation;
    
    //assumption: synhcronised time if distributed VMs...
    //use of timestamps eliminates the problem with time units...
    ByCounterMap<Timestamp, List<CountingInformation>> countingEvents; //multiples: may be events...
    
    public static void main(String[] args) {
        
    }
    
    public void report(
        List<ParameterRepresentation> inputPrms,
        Timestamp invocationReceivedTimestamp,
        boolean isInstrumented,
        Map<Integer,Long> instCounts,
        Map<String,Long>  methCounts,
        Map<int[],Map<Integer,Long>> sectionInstCounts,
        Map<int[],Map<String,Long>> sectionMethCounts,
        boolean logWrittenToDisk,
        List<ParameterRepresentation> outputPrms){
            //TODO
    }
    
    public void report
    
        boolean isPrimitive;
    
    boolean isArray;
    
    String classType;
    
    Object value;
    
    String toStringRepresentation;
    
    long dataStructureCharacterisation;
    
    List<Long> innerElementCharacterisation;


    public ByCounterResultCollector() {
    
    }   
    
    public ByCounterMap<CountingInformation, CountingResults> getEvaluatedCountsByName(String name){
        
        
        return null;
    }
    
    public ByCounterMap<CountingInformation, CountingResults> getEvaluatedCountsBySignature(String signature){
        return null;
    }
    
    public ByCounterMap<CountingInformation, CountingResults> getEvaluatedCountsByStartTimeInterval(Timestamp intervalLeftBound, Timestamp intervalRightBound){
        return null;
    }
    
    
}
