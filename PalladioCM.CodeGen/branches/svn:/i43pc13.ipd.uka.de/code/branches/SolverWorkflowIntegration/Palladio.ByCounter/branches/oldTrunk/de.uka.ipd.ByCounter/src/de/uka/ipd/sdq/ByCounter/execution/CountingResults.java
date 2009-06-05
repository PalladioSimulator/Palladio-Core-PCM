
class CountingResults {
    
    ByCounterResultCollector myCollector;
    
    ByCounterMap myMap;
    
    Map<Integer,Long> instCounts;
    
    //assumption: we ignore parameters...
    Map<String,Long>  methCounts;
    
    //for future
    Map<BytecodeSectionDescription,Map<Integer,Long>> sectionInstCounts;
    
    //for future
    Map<BytecodeSectionDescription,Map<String,Long>> sectionMethCounts;

}
