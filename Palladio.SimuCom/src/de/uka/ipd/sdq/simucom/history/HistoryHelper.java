package de.uka.ipd.sdq.simucom.history;

import java.util.ArrayList;

public class HistoryHelper {

	public static void dumpHistory(String entity, ArrayList<HistoryElement> history)
	{
		System.out.println("Dumping history of "+entity);
		for (HistoryElement h : history)
		{
			System.out.println(h.getWhat());
		}
	}
}
