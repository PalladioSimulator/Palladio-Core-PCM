package de.uka.ipd.sdq.probfunction.math.util;

import java.io.BufferedWriter;
import java.io.FileWriter;

import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

public class StoreHistogramCSV {
	
	public static void store(ManagedPDF pdf, String fileName){
		ISamplePDF sPDF = pdf.getSamplePdfTimeDomain();
		FileWriter writer;
		BufferedWriter bufferedWriter;
		
		try {
			writer = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(writer);
			double pos = 0;
			for( Double d : sPDF.getValuesAsDouble()){
				bufferedWriter.write( pos + "; " + d + "\n");
				pos += sPDF.getDistance();
			}
			bufferedWriter.close();
			writer.close();
		} catch(Exception e) {
		}
	}
}
