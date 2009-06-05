
class DummyReportingClass {
    ByCounterResultCollector myCollector;
    
    public DummyReportingClass(ByCounterResultCollector collector){
        this.myCollector = collector;
    }
    
    public int pseudeInstrumentedMethod(int prm){
        long start = System.currentTimeMillis();
        int ret = prm*prm;
        
        long stop = System.currentTimeMillis();
        myCollector.collect(start,stop);
        return ret;
    }
}
