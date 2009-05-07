/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.harness.results;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoopResult extends TestResult {
    
    private int bmThreadId;  // Benchmark Thread ID.
    private int loopCnt;
    private long startTime;
    private long endTime;
    
    public int getBmThreadId() {
        return bmThreadId;
    }
    public void setBmThreadId(int threadID) {
        this.bmThreadId = threadID;
    }
    
    public int getLoopCnt() {
        return loopCnt;
    }
    public void setLoopCnt(int loopCnt) {
        this.loopCnt = loopCnt;
    }
    
    public long getStartTime() {
        return startTime;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    
    public long getEndTime() {
        return endTime;
    }
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
    public long getLoopTime() {
        return endTime - startTime;
    }
    
    public void toXml(PrintStream ps, int indent) {
        ptxElementStartOpen(ps, indent, "loop-result", false);
        ptxAttrib(ps, 0, "bmThreadId", bmThreadId, true, " ");
        ptxAttrib(ps, 0, "loopCnt", loopCnt, true, " ");
        ptxAttrib(ps, 0, "startTime", startTime, true, " ");
        if (hasErrors()) {
            ptxAttrib(ps, 0, "endTime", endTime, true, ">\n");
            printErrorsToXml(ps, indent + TAB);
            ptxElementClose(ps, (hasErrors() ? indent : 0), "loop-result");
        } else {
            ptxAttrib(ps, 0, "endTime", endTime, true, "/>\n");
        }
    }
    
    public boolean isValid() {
        return !hasErrors();
    }
    
    public List<String> getAllErrors(String tag) {
        List<String> tmp = new LinkedList<String>();
        if (errors != null) {
            for (Iterator eit = errors.iterator(); eit.hasNext();) {
                tmp.add(tag + " " + eit.next());
            }
        }
        return tmp;
    }
}
