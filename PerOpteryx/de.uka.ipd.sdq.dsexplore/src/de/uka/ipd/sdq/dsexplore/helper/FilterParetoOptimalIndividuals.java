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

import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Value;
import org.opt4j.core.Individual.State;
import org.opt4j.core.domination.ParetoDomination;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEObjectives;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.NonListenableIndividual;
import de.uka.ipd.sdq.pcm.designdecision.DecisionSpace;

public class FilterParetoOptimalIndividuals {

	public static void main(String args[]) throws CoreException {

		if (args.length < 2) {
			System.out
					.println("You need to specify the number of columns to be read and compared as first argument and the cvs file(s) as second and optional further arguments");
		}


		int noColumns = Integer.parseInt(args[0]);
		
		List<List<DSEIndividual>> allIndividuals = new ArrayList<List<DSEIndividual>>();
		List<File> files = new ArrayList<File>();
		
		for (int i = 1; i < args.length; i++) {
			String filename = args[i];
			File file = new File(filename);
			files.add(file);
			
			System.out.println("Input: "+file.getAbsolutePath());
						
			List<DSEIndividual> values = readInDoubles(file, noColumns);
			
			List<DSEIndividual> optimal = filterPareto(values);
			
			writeResults("results", file, optimal);
			
			
		}
		
		//Filter the overall optimals and put them in the lists.
		List<DSEIndividual> overallList = new ArrayList<DSEIndividual>();
		for (List<DSEIndividual> list : allIndividuals) {
			overallList.addAll(list);
		}
		List<DSEIndividual> overallOptimal = filterPareto(overallList);
		
		//remove non-optimal from list and then print the remaining ones to see how many were optimal. 
		for (List<DSEIndividual> list : allIndividuals) {
			List<DSEIndividual> toBeRemoved = new ArrayList<DSEIndividual>();
			for (DSEIndividual individual : list) {
				if (!overallOptimal.contains(individual)){
					toBeRemoved.add(individual);
				}
			}
			list.removeAll(toBeRemoved);
			System.out.println("Input: "+files.get(allIndividuals.indexOf(list)).getAbsolutePath());
			writeResults("resultsComparedWithOthers", files.get(allIndividuals.indexOf(list)), list);
			
		}
	}
	

	private static void writeResults(String filenamePrefix, File oldFile, List<DSEIndividual> optimalIndividuals) {
		
		File file = new File(oldFile.getParentFile(),filenamePrefix+oldFile.getName());
		try {
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(file)));
			
			for (Individual indiv : optimalIndividuals) {
				for (Value<?> double1 : indiv.getObjectives().getValues()) {
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
	 * @param <AnyIndiv>
	 * @param individuals The list is not modified
	 * @return A copy of the given list with all non-optimal Individuals removed.
	 */
	public static final <AnyIndiv extends Individual> List<AnyIndiv> filterPareto(final List<AnyIndiv> individuals) {
		
		List<AnyIndiv> toBeRemoved = new ArrayList<AnyIndiv>(individuals.size());
		List<AnyIndiv> result = new ArrayList<AnyIndiv>(individuals.size());
		
		result.addAll(individuals);
		
		for (int i = 0; i < individuals.size(); i++) {
			AnyIndiv indiv1 = individuals.get(i);
			for (int j = i + 1; j < individuals.size(); j++){
				AnyIndiv indiv2 = individuals.get(j);
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
	private static List<DSEIndividual> readInDoubles(File file,
			int noColumns) {
		
		try {

			List<DSEIndividual> results = new ArrayList<DSEIndividual>();
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

				//Objectives lineList = new Objectives(); //TODO: LEGACY!
				DSEObjectives lineList = new DSEObjectives(new ParetoDomination());

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
				lineList.array();
				DSEIndividual indiv = new DummyDSECandidate(null, ""+noOfLine);
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
	
	static class DummyDSECandidate extends NonListenableIndividual {
	
		private String id;

		public DummyDSECandidate(DecisionSpace problem, String id){
			super(problem);
			this.id = id;
		}
		
		/**
		 * 
		 * @return may be null if this individual does not have a genotype yet. 
		 */
		@Override
		public String getGenotypeString() {
			return id;
		}
	}

}
