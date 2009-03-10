/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.extractors.java.recoder;
import java.io.PrintWriter;
import java.util.List;

import recoder.java.CompilationUnit;
import recoder.java.ProgramElement;
import recoder.service.ChangeHistoryEvent;
import recoder.service.ChangeHistoryListener;
import recoder.service.ModelUpdateListener;
import recoder.service.TreeChange;
import recoder.util.ProgressEvent;
import recoder.util.ProgressListener;

/**
   Simple change history, model update and progress listener,
   writing out progress messages and change reports.
*/
public class ConsoleReports
	implements ChangeHistoryListener, ModelUpdateListener, ProgressListener {

	private PrintWriter out;
	private int count = 0;
	private boolean printCompUnits = false;
	
	public ConsoleReports(PrintWriter out) {
		if (out == null) {
			throw new NullPointerException("No output");
		}
		this.out = out;
	}

	public ConsoleReports(PrintWriter out, boolean printCompUnits) {
		if (out == null) {
			throw new NullPointerException("No output");
		}
		this.out = out;
		this.printCompUnits = printCompUnits;
	}

	public void modelChanged(ChangeHistoryEvent changes) {
		if (printCompUnits) {
			List<TreeChange> news = changes.getChanges();
			for (int i = 0, s = news.size(); i < s; i += 1) {
				ProgramElement pe = news.get(i).getChangeRoot();
				if (pe instanceof CompilationUnit) {
					count += 1;
					out.println(
						"[" + count + "] " + ((CompilationUnit) pe).getName());
					out.flush();
				}
			}
		}
	}

	private long updateBeginTime;

	public void modelUpdating(java.util.EventObject event) {
		out.println("Model Update Starts...");
		out.flush();
		updateBeginTime = System.currentTimeMillis();
	}

	public void modelUpdated(java.util.EventObject event) {
		long updateTime = System.currentTimeMillis() - updateBeginTime;
		out.println("...Model Updated in " + updateTime + "ms");
		out.flush();
	}

	private int oldpercentage = -1;
	private Object oldstate = null;
	private long lastDisplayTime = 0L;

	static final long MIN_DELAY = 200; // ms

	static final int MAX_LINE_WIDTH = 77;

	public void workProgressed(ProgressEvent pe) {
		int max = pe.getWorkToDoCount();
		int val = pe.getWorkDoneCount();
		if (val == max) {
			val = 0;
			oldpercentage = -1;
			oldstate = null;
			StringBuffer output = new StringBuffer("\r100% (done)");
			for (int i = output.length(); i < ConsoleReports.MAX_LINE_WIDTH; i++) {
				output.append(' ');
			}
			out.println(output);
			out.flush();
			// no need to reset lastDisplayTime
			return;
		}
		if (val > max) {
			max = val;
		}
		if (System.currentTimeMillis() - lastDisplayTime > ConsoleReports.MIN_DELAY) {
			int p = 100 * val / max;
			Object state = pe.getState();
			if (p != oldpercentage || state != oldstate) {
				StringBuffer output = new StringBuffer("\r");
				if (p < 10) {
					output.append("  ");
				} else if (p < 100) {
					output.append(" ");
				}
				output.append(p);
				output.append('%');
				if (state != null) {
					output.append(' ');
					String msg = state.toString();
					int msglength = msg.length();
					int oversize = msglength - (ConsoleReports.MAX_LINE_WIDTH - 5);
					if (oversize > 0) {
						int middle = (msglength - oversize - 3 + 1) / 2;
						output.append(msg.substring(0, middle));
						output.append("...");
						output.append(
							msg.substring(msglength - middle, msglength));
					} else {
						output.append(msg);
					}
				}
				for (int i = output.length(); i < ConsoleReports.MAX_LINE_WIDTH; i++) {
					output.append(' ');
				}
				out.println(output);
				out.flush();
				lastDisplayTime = System.currentTimeMillis();
				oldpercentage = p;
				oldstate = state;
			}
		}
	}
}
