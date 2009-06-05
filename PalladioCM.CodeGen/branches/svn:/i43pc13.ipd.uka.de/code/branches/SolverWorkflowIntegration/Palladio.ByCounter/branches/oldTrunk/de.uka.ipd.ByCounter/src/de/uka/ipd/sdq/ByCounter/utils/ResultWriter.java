package de.uka.ipd.sdq.ByCounter.utils;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.JFreeChart;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.FontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Utility for exporting JFreeChart objects as .pdf files. Uses itext.
 * @author Michael Kuperberg (?)
 * @author Martin Krogmann (?)
 * @since 0.1
 * @version 0.1
 */
public class ResultWriter {

	/**
	 * Save a JFreeChart to a File as a .pdf.
	 * From JFreeChart Developer guide.
	 * @param file File to write to.
	 * @param chart JFreeChart object to draw.
	 * @param width Width of the object.
	 * @param height Height of the object.
	 * @param mapper Fontmapper to interface with itext. (Try DefaultFontMapper).
	 * @throws IOException Thrown when errors happen while writing.
	 */
	public static void saveChartAsPDF(File file, JFreeChart chart, int width,
			int height, FontMapper mapper) throws IOException {
		OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		writeChartAsPDF(out, chart, width, height, mapper);
		out.close();
	}

	/**
	 * Writes a JFreeChart object to a <code>OutputStream</code>.
	 * From JFreeChart Developer guide.
	 * @param out Output stream.
	 * @param chart Chart to write.
	 * @param width Width of the graphic.
	 * @param height Height of the graphic.
	 * @param mapper Fontmapper to interface with itext.
	 * @throws IOException Is thrown by the OutputStream.
	 */
	public static void writeChartAsPDF(OutputStream out, JFreeChart chart,
			int width, int height, FontMapper mapper) throws IOException {
		// variable document size; for A4 size change this
		Rectangle pagesize = new Rectangle(width, height);
		Document document = new Document(pagesize, 50, 50, 50, 50);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, out);
			// these show up in the document properties - should be changed for use outside this project
			document.addAuthor(IByCounterConstants.PRODUCT_NAME+" V"+IByCounterConstants.PRODUCT_VERSION);
			document.addSubject("Performance Results"); //TODO MK add method parameters for more precise description passing 
			document.open();
			// draw to the pdf
			PdfContentByte cb = writer.getDirectContent();
			PdfTemplate tp = cb.createTemplate(width, height);
			Graphics2D g2 = tp.createGraphics(width, height, mapper);
			Rectangle2D r2D = new Rectangle2D.Double(0, 0, width, height);
			chart.draw(g2, r2D);
			g2.dispose();
			cb.addTemplate(tp, 0, 0);
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}
		document.close();
	}

}
