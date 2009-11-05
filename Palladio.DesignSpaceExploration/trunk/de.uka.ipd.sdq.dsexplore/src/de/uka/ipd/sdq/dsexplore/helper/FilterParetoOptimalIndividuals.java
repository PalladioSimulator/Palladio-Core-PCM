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
					.println("You need to specify the number of columns to be read and compared as first argument and the cvs file(s) as second and optional further arguments");
		}


		int noColumns = Integer.parseInt(args[0]);
		
		List<List<Individual>> allIndividuals = new ArrayList<List<Individual>>();
		List<File> files = new ArrayList<File>();

		for (int i = 1; i < args.length; i++) {
			String filename = args[i];
			File file = new File(filename);
			files.add(file);
			List<Individual> values = readInDoubles(file, noColumns);
			allIndividuals.add(values);
			
			List<Individual> optimal = filterPareto(values);
			
			System.out.println("Input: "+file.getAbsolutePath());
			writeResults("results", file, optimal);
			
			
		}
		
		//Filter the overall optimals and put them in the lists.
		List<Individual> overallList = new ArrayList<Individual>();
		for (List<Individual> list : allIndividuals) {
			overallList.addAll(list);
		}
		List<Individual> overallOptimal = filterPareto(overallList);
		
		//remove non-optimal from list and then print the remaining ones to see how many were optimal. 
		for (List<Individual> list : allIndividuals) {
			List<Individual> toBeRemoved = new ArrayList<Individual>();
			for (Individual individual : list) {
				if (!overallOptimal.contains(individual)){
					toBeRemoved.add(individual);
				}
			}
			list.removeAll(toBeRemoved);
			System.out.println("Input: "+files.get(allIndividuals.indexOf(list)).getAbsolutePath());
			writeResults("resultsComparedWithOthers", files.get(allIndividuals.indexOf(list)), list);
			
		}
	}
	

	@SuppressWarnings("unchecked")
	private static void writeResults(String filenamePrefix, File oldFile, List<Individual> optimalIndividuals) {
		
		File file = new File(oldFile.getParentFile(),filenamePrefix+oldFile.getName());
		try {
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(file)));
			
			for (Individual indiv : optimalIndividuals) {
				for (Value double1 : indiv.getObjectives().getValues()) {
					w.write(double1.getDouble()+";");
				}
				w.newLine();
			}
			
			w.flush();
			
			w.close();
			
			System.out.println("Written results to "+file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			System.out.println("Writing failed.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Writing failed.");
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @param individuals The list is not modified
	 * @return A copy of the given list with all non-optimal Individuals removed.
	 */
	public static List<Individual> filterPareto(final List<Individual> individuals) {
		
		List<Individual> toBeRemoved = new ArrayList<Individual>();
		List<Individual> result = new ArrayList<Individual>();
		
		result.addAll(individuals);
		
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
		
		result.removeAll(toBeRemoved);
		
		return result;

	}

	/**
	 * Reads in Individuals from a file having the objectives in the first columns. 
	 * Must contain headlines. 
	 * @param filename
	 * @param noColumns The number of first columns that contain the objectives to be analysed. 
	 * @return
	 */
	private static List<Individual> readInDoubles(File file,
			int noColumns) {
		
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
				
				if (lineArray.length == 0){
					//lines of the form ";;;;;;;" result in an empty array and should be skipped. 
					continue;
				}

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
