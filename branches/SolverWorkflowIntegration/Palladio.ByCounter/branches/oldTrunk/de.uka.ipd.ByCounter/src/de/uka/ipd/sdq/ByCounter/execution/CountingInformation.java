//assumption: collected only if no uncaught exceptions...
class CountingInformation {
    
    ByCounterResultCollector myCollector;
    
    ByCounterMap myCountsMap;
    
    ByCounterMap myEventsMap;
    
    List myEventsList;
    
    ByCounterMap myInformationMap;
    
    List myInformationList;
    
    
    //TODO replace through exception-obtained stack information
    CallerInformation caller;
    
    List<ParameterRepresentation> inputPrms;

    //TODO this is not equal to invocationSentTimestamp -> "epsilon" solution?
    Timestamp invocationReceivedTimestamp;
   
    boolean isInstrumented;
    
    CountingResults ownCounts;
    
    boolean countsAssembled;
    
    CountingResults assembledCounts;

    boolean logWrittenToDisk;
    
    Timestamp exitingTimestamp;
    
    Timestamp resultsReceivedByCollectorTimestamp;
    
    List<ParameterRepresentation> outputPrms;
    
    
}
