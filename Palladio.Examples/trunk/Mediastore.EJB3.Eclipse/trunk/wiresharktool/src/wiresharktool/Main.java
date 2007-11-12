package wiresharktool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import wiresharktool.capture.CaptureLine;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

public class Main {

	static int pos = 0;
	private static List<CaptureLine> lines;
	private static FileDAOFactory daoFactory;
	private static Experiment exp;
	private static ExperimentRun expRun;
	private static TimeSpanSensor tss;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		daoFactory = new FileDAOFactory("/home/snowball/workspace_j2ee/store/rmi");
		exp = daoFactory.createExperimentDAO().addExperiment("Server Network Capture");
		expRun = daoFactory.createExperimentRunDAO().addExperimentRun(new Date().toString());
		exp.addExperimentRun(expRun);
		tss = exp.addTimeSpanSensor("Roundtrip");
		try {
			lines = readFile("/rmi.csv");
			//lines = readFile("z:/temp/test.csv");
			while (pos < lines.size()){
				CaptureLine start, end;
				start = findLineByInfoFragment("Request");
				end = findLineByInfoFragment("Reply");
				if (start == null || end == null)
					break;
				expRun.addTimeSpanMeasurement(tss, end.getTime() , end.getTime()-start.getTime());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		daoFactory.createExperimentDAO().store(exp);
		daoFactory.finalizeAndClose();
	}

	private static CaptureLine findLineByInfoFragment(String fragment) {
		while (pos < lines.size() && !lines.get(pos).getInfo().toLowerCase().contains(fragment.toLowerCase()))
			pos++;
		if (pos >= lines.size())
			return null;
		return lines.get(pos);
	}

	private static List<CaptureLine> readFile(String file) throws IOException {
		ArrayList<CaptureLine> result = new ArrayList<CaptureLine>();
		FileInputStream fis = new FileInputStream(file);
		Reader fisReader = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(fisReader);
		reader.readLine(); // skip header line
		String line;
		while((line = reader.readLine()) != null)
			result.add(new CaptureLine(line));
		reader.close();
		return result;
	}

}
