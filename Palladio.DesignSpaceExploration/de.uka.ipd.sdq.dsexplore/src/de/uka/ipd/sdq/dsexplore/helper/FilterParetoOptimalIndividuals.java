package de.uka.ipd.sdq.dsexplore.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.core.Individual.State;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.NonListenableIndividual;

public class FilterParetoOptimalIndividuals {

	public static void main(String args[]) {

		if (args.length < 2) {
			System.out
					.println("You need to specify a cvs file as first argument and the number of columns to be read and compared as second argument");
		}

		String filename = args[0];

		int noColumns = Integer.parseInt(args[1]);

		List<Individual> values = readInDoubles(filename, noColumns);
		
		List<Individual> optimal = filterPareto(values);
		
		writeResults("results"+filename, optimal);

	}

	@SuppressWarnings("unchecked")
	private static void writeResults(String filename, List<Individual> optimalIndividuals) {
		try {
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(filename)));
			
			for (Individual indiv : optimalIndividuals) {
				for (Value double1 : indiv.getObjectives().getValues()) {
					w.write(double1.getDouble()+";");
				}
				w.newLine();
			}
			
			w.flush();
			
			w.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static List<Individual> filterPareto(List<Individual> individuals) {
		
		List<Individual> toBeRemoved = new ArrayList<Individual>();
		
		for (int i = 0; i < individuals.size(); i++) {
			Individual indiv1 = individuals.get(i);
			for (int j = i + 1; j < individuals.size(); j++){
				Individual indiv2 = individuals.get(j);
				if (indiv1.getObjectives().dominates(indiv2.getObjectives())){
					toBeRemoved.add(indiv2);
				} else if (indiv2.getObjectives().dominates(indiv1.getObjectives())){
					toBeRemoved.add(indiv1);
				}
			}
			
		}
		
		individuals.removeAll(toBeRemoved);
		
		return individuals;

	}

	private static List<Individual> readInDoubles(String filename,
			int noColumns) {
		File file = new File(filename);

		try {

			List<Individual> results = new ArrayList<Individual>();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			
			String[] headLineArray = in.readLine().split(";");
			
			List<Objective> objectiveList = new ArrayList<Objective>();
			
			for (int i = 0; i < noColumns; i++) {
				Objective o = new Objective(headLineArray[i]);
				objectiveList.add(o);
			}
			
			
			int noOfLine = 1;

			String line = "";
			while (null != (line = in.readLine())) {
				Objectives lineList = new Objectives();
				String[] lineArray = line.split(";");

				for (int i = 0; i < noColumns; i++) {
					try {
						Double value = Double.parseDouble(lineArray[i]);
						lineList.add(objectiveList.get(i), value);
					} catch (NumberFormatException e) {
						System.out.println("Line " + noOfLine + " column " + i
								+ " is no double value, exiting");
						throw new Exception(e);
					}
				}
				lineList.submit();
				Individual indiv = new NonListenableIndividual();
				indiv.setObjectives(lineList);
				indiv.setState(State.EVALUATED);
				results.add(indiv);
				noOfLine++;
			}
			in.close();

			return results;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
