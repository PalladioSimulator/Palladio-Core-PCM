package de.uka.ipd.sdq.dsexplore.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.opt4j.core.Criterion;
import org.opt4j.core.DoubleValue;
import org.opt4j.core.Value;
import org.opt4j.start.Opt4JTask;

import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.dsexplore.analysis.AbstractPerformanceAnalysisResult;
import de.uka.ipd.sdq.dsexplore.exception.ExceptionHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEObjectives;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEProblem;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.dsexplore.qml.reader.QMLDimensionReader;
import de.uka.ipd.sdq.pcm.designdecision.Candidate;
import de.uka.ipd.sdq.pcm.designdecision.Candidates;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

public class GenotypeReader {
	
	/**QUICKHACK need to inject objectives!!!**/
	private static Opt4JTask task;
	public static void setTask(Opt4JTask t){
		task = t;
	}
	
	private static final String SEPARATOR = ";";
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.helper.GenotypeReader");

	/**
	 * Reads the genotypes from the specified files. 
	 * If the file contains pretty printed genotypes and 
	 * objectives are given, reads them and updates the DSEEvaluator cache
	 * by calling DSEEvaluator.addToPhenotypeCache(..). Requires confidence intervals
	 * to be available for all objectives with statistical evaluators. 
	 * Reading in of objectives and confidence values is not supported for raw genotype files.
	 * Note that this method changes the internal objectives and deletes all objectives that are not
	 * found in the file.  
	 */
	public static List<DesignDecisionGenotype> getGenotypes(String filename)
			throws CoreException {
		File file = new File(filename);

		if (filename.contains("csv")) {
			try {

				List<DSEIndividual> individuals = readInPrettyPrintedIndividuals(getReaderFor(file));
				List<DesignDecisionGenotype> results = new ArrayList<DesignDecisionGenotype>(
						individuals.size());
				for (DSEIndividual individual : individuals) {
					results.add(individual.getGenotype());
				}

				return results;

			} catch (Exception ex) {
				throw ExceptionHelper.createNewCoreException(
						"Could not evaluate predefined instances. See nested Exceptions for cause. "
								+ ex.getMessage(), ex);
			}
		} else if (filename.contains("designdecision")) {
			return loadGenotypesFromEMF(filename);

		} else
			throw ExceptionHelper
					.createNewCoreException("Genotype file to read must must be of type csv or designdecision.");
	}

	/**
	 * Load complete Individuals from the file (with objectives and utilisation info, if present). 
	 * @param filename
	 * @return
	 * @throws CoreException
	 */
	public static List<DSEIndividual> getIndividuals(String filename) throws CoreException{
		File file = new File(filename);
		
		if (filename.contains("csv")) {
	    try {
	    	
	    	List<DSEIndividual> individuals = readInPrettyPrintedIndividuals(getReaderFor(file));
	        return individuals;
	        
	      } catch( Exception ex ) {
	        throw ExceptionHelper.createNewCoreException("Could not evaluate predefined instances. See nested Exceptions for cause. "+ex.getMessage(), ex);
	      }
		} else if (filename.contains("designdecision")) {
			List<DesignDecisionGenotype> genotypes = loadGenotypesFromEMF(filename);
			List<DSEIndividual> individuals = new ArrayList<DSEIndividual>(genotypes.size());
			for (DesignDecisionGenotype designDecisionGenotype : genotypes) {
				DSEIndividualBuilder builder = Opt4JStarter.getIndividualBuilder();
				DSEIndividual individual = builder.build(designDecisionGenotype);
				individuals.add(individual);
			}
			return individuals;

		} else
			throw ExceptionHelper
					.createNewCoreException("Genotype file to read must must be of type csv or designdecision.");
	}
	
	/**
	 * Note that this method changes the internal objectives and deletes all objectives that are not
	 * found in the file.
	 * @param filename
	 * @return
	 * @throws CoreException
	 */
	public static List<DSEObjectives> getObjectives (String filename) throws CoreException{
		File file = new File(filename);
		
	    try {
	    	
	    	List<DSEObjectives> results = readInPrettyPrintedObjectives(getReaderFor(file));
	        
	        return results;
	        
	      } catch( Exception ex ) {
	        throw ExceptionHelper.createNewCoreException("Could not evaluate predefined instances. Leave field blank for evolutionary search or type \"random\" for a random search. "+ex.getMessage(), ex);
	      }
	}
	
	private static List<DesignDecisionGenotype> loadGenotypesFromEMF(
			String filename) {
		PCMInstance pcm = Opt4JStarter.getProblem().getInitialInstance();
		ResourceSet pcmResourceSet = pcm.getAllocation().eResource().getResourceSet();
				
		EObject eCandidates = EMFHelper.loadFromXMIFile(filename, pcmResourceSet);
		//FixDesignDecisionReferenceSwitch refSwitch = new FixDesignDecisionReferenceSwitch(Opt4JStarter.getProblem().getInitialInstance());
		//refSwitch.doSwitch(eCandidates);
		
		if (!(eCandidates instanceof Candidates)){
			throw new RuntimeException("Cannot read candidate model file "+filename+". Please create a new one.", null);
		 }
		Candidates candidates = (Candidates)eCandidates ;
		EcoreUtil.resolveAll(candidates);
		
		List<DesignDecisionGenotype> genotypeList = new ArrayList<DesignDecisionGenotype>(candidates.getCandidate().size());
		for (Candidate candidate : candidates.getCandidate()) {
			DesignDecisionGenotype genotype = new DesignDecisionGenotype(candidate, candidates.getProblem(), Opt4JStarter.getProblem().getGenotypeOfInitialPCMInstance());
			genotypeList.add(genotype);
		}
				
		return genotypeList;
	}

	//FIXME: copied from readInPrettyPrintedGenotypes. Refactor to use a proper serialisation!!
	private static List<DSEObjectives> readInPrettyPrintedObjectives(BufferedReader in) throws CoreException, IOException {
		List<DSEObjectives> results = new ArrayList<DSEObjectives>();
		
		//order design decisions
		String headline = in.readLine();
		if (headline == null){
			throw ExceptionHelper.createNewCoreException("Predefined instances file could not be read because it is empty. Specify a valid file or \"random\" or leave the field blank for an evolutionary search.");
		} 
		String[] headlineArray = headline.split(SEPARATOR);
		
		List<CriterionAndEvaluator> objectiveList = Opt4JStarter.getDSEEvaluator().getCriterionAndEvaluatorList();
		
		//Empty list if no objectives are specified. 
		List<List<CriterionAndEvaluator>> orderedObjectives = getOrderedObjectiveCollection(headlineArray, objectiveList);
		
		//count confidence intervals to determine boundaries of areas in file (objectives, confidences, genotype)
		int numberOfConfidenceIntervals = countConfidenceIntervals(orderedObjectives);
		
		int startIndexOfConfidence = orderedObjectives.size();
		if( orderedObjectives.size() == 0){
			ExceptionHelper.createNewCoreException("Tried to read in Pareto front that has no objectives in it. Fix your file.");
		}
		
		int expectedLineArrayLength = headlineArray.length;
		
		String line;
		while ( null != (line = in.readLine()) ) {
			String[] lineArray = line.split(SEPARATOR);
			//Check minimum length, a last semicolon is ok that makes the line array one longer than the list.
			if (lineArray.length < expectedLineArrayLength){
				throw ExceptionHelper.createNewCoreException("A line in the predefined instances file has not the right length");
			}
			DSEObjectives objectives = readInObjectivesAndConfidence(
					orderedObjectives, startIndexOfConfidence,
					numberOfConfidenceIntervals, lineArray);
			results.add(objectives);
		}
		in.close();
		
		return results;
	}

	private static BufferedReader getReaderFor(File file) throws FileNotFoundException {
    	InputStreamReader ir = new InputStreamReader(
                new FileInputStream( file ) );
        BufferedReader in = new BufferedReader(ir);
		return in;
	}

	/**
	 * Reads the genotypes from the specified files. 
	 * If objectives are given, reads them and updates the DSEEvaluator cache
	 * by calling DSEEvaluator.addToPhenotypeCache(..). Requires confidence intervals
	 * to be available for all objectives with statistical evaluators. 
	 * @param in Is used and modify and closed 
	 * @return
	 * @throws CoreException
	 * @throws IOException
	 */
	private static List<DSEIndividual> readInPrettyPrintedIndividuals(BufferedReader in) throws CoreException, IOException {
		List<DSEIndividual> results = new LinkedList<DSEIndividual>();
		
		DSEProblem problem = Opt4JStarter.getProblem();
		List<DegreeOfFreedom> decisionList = problem.getDesignDecisions();
		
		//order design decisions
		String headline = in.readLine();
		if (headline == null){
			throw ExceptionHelper.createNewCoreException("Predefined instances file could not be read because it is empty. Specify a valid file or \"random\" or leave the field blank for an evolutionary search.");
		} 
		String[] headlineArray = headline.split(SEPARATOR);
		
		List<CriterionAndEvaluator> objectiveList = Opt4JStarter.getDSEEvaluator().getCriterionAndEvaluatorList();
		
		// Empty list if no objectives are specified. 
		// The inner lists must not be empty.
		List<List<CriterionAndEvaluator>> orderedObjectives = getOrderedObjectiveCollection(headlineArray, objectiveList);
		
		boolean hasObjectives = orderedObjectives.size() != 0;
		
		//adjust evaluators.
		if (hasObjectives && objectiveList.size() > orderedObjectives.size()){
			Opt4JStarter.getDSEEvaluator().retainOnlyEvaluatorsFor(orderedObjectives);
			
		} 
		
		// special case: find one performance criterion to determine whether confidence intervals are required.   
		Criterion performance = null;
		if (hasObjectives){
			for (List<CriterionAndEvaluator> objectiveAndEvaluatorList : orderedObjectives) {
				
				if (objectiveAndEvaluatorList.size()>0){
					CriterionAndEvaluator first = objectiveAndEvaluatorList.get(0);
					//XXX: Read the dimension name from definition rather than the constants container
					if (ResultsWriter.getDimensionName(first.getCriterion()).contains(new QMLDimensionReader().getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH).getEntityName())){
						performance = first.getCriterion();
						break;
					}
				}
			}
			
		}
		
		//count confidence intervals to determine boundaries of areas in file (objectives, confidences, genotype)
		int numberOfConfidenceIntervals = countConfidenceIntervals(orderedObjectives);
		
		int startIndexOfConfidence = orderedObjectives.size();
				
		//Its always three columns per objective that has confidence
		int startIndexOfGenotype =  orderedObjectives.size() + numberOfConfidenceIntervals*3; 
		
		//order the design decision in the problem based on the found order. 
		List<DegreeOfFreedom> orderedDesignDecisions = getOrderedDesignDecisions(
				decisionList, headlineArray, startIndexOfGenotype, problem);
		
		int minExpectedLineArrayLength = startIndexOfGenotype + orderedDesignDecisions.size();
		
		List<ProcessingResourceSpecification> processorsWithUtilResults = getProcessorsWithUtilisation(headlineArray, minExpectedLineArrayLength, problem);
		
		String line;
		while ( null != (line = in.readLine()) ) {
			String[] lineArray = line.split(SEPARATOR);
			//Check minimum length, a last semicolon is ok that makes the line array one longer than the list.
			if (lineArray.length < minExpectedLineArrayLength){
				throw ExceptionHelper.createNewCoreException("A line in the predefined instances file has not the right length");
			}
			DesignDecisionGenotype genotype = extractGenotypeAndAddToList(startIndexOfGenotype,
					orderedDesignDecisions, lineArray);
			
	
			DSEIndividualBuilder builder = Opt4JStarter.getIndividualBuilder();
			DSEIndividual individual = builder.build(genotype);
			results.add(individual);

			if (hasObjectives){
				DSEObjectives objectives = readInObjectivesAndConfidence(
						orderedObjectives, startIndexOfConfidence,
						numberOfConfidenceIntervals, lineArray);
			
				//has utilisations?
				if (processorsWithUtilResults.size() > 0 && performance != null){
					objectives.addResultDecoratorFor(performance, getResultDecorator(lineArray, minExpectedLineArrayLength, processorsWithUtilResults));
					
					//if the processor list is non-empty, but no utilisations were found, warn because the read in values might be old versions
					if (objectives.getResultDecoratorFor(performance).getUtilisationResults_ResultDecoratorRepository().size() == 0 && !objectives.getValueForCriterion(performance).equals(new DoubleValue(Double.POSITIVE_INFINITY))){
						logger.warn("Empty utilisation values for non-infinity objectives encountered when reading in individuals, check that this is ok.");
					}
				}
				
				if (Opt4JStarter.getDSEWorkflowConfig().getUseAntipatternKnowledge()){
					
					//solve dependencies for performance
					Opt4JStarter.getDSEDecoder().decode(genotype);
					PCMInstance model = Opt4JStarter.getProblem().getInitialInstance(); 
					AbstractPerformanceAnalysisResult.solveDependencies(model);
					ComputedAggregatedUsage computedAggregatedUsage = model.getComputedAggregatedUsage();
					if (computedAggregatedUsage != null){
						objectives.addComputedAggregatedUsage(performance, computedAggregatedUsage);
					}
				}
				
				//add objective to phenotype cache with genotype string
				Opt4JStarter.getDSEEvaluator().addToPhenotypeCache(DSEDecoder.getGenotypeString(genotype), objectives);
				
				//add objectives to individual
				individual.setObjectives(objectives);
			}
			
		}
		in.close();
		
		return results;
	}

	private static List<ProcessingResourceSpecification> getProcessorsWithUtilisation(
			String[] headlineArray, int minExpectedLineArrayLength, DSEProblem problem) {
		
		List<ProcessingResourceSpecification> allProcessors = getAllProcessors(problem);
		List<ProcessingResourceSpecification> orderedListOfProcessors = new ArrayList<ProcessingResourceSpecification>(allProcessors.size());
		for (int i = minExpectedLineArrayLength; i < headlineArray.length; i++) {
			String entry = headlineArray[i];
			for (Iterator<ProcessingResourceSpecification> iterator = allProcessors.iterator(); iterator
					.hasNext();) {
				ProcessingResourceSpecification processor = iterator
						.next();
				if ( entry.contains(processor.getResourceContainer_ProcessingResourceSpecification().getEntityName())
						&& entry.contains(processor.getActiveResourceType_ActiveResourceSpecification().getEntityName())){
					orderedListOfProcessors.add(processor);
					iterator.remove();
					break;
				}
			}
		}
		
		
		return orderedListOfProcessors;
	}

	private static List<ProcessingResourceSpecification> getAllProcessors(
			DSEProblem problem) {
		List<ResourceContainer> containers = problem.getInitialInstance().getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		List<ProcessingResourceSpecification> processors = new LinkedList<ProcessingResourceSpecification>();
		for (ResourceContainer resourceContainer : containers) {
			List<ProcessingResourceSpecification> processorsOnContainer = resourceContainer.getActiveResourceSpecifications_ResourceContainer();
			processors.addAll(processorsOnContainer);
		}
		return processors;
	}

	private static ResultDecoratorRepository getResultDecorator(String[] lineArray,
			int minExpectedLineArrayLength, List<ProcessingResourceSpecification> processorsWithUtilResults) {
		
		ResultDecoratorRepository repo = ResultdecoratorFactory.eINSTANCE.createResultDecoratorRepository();
		
		for (int i = 0; i < lineArray.length - minExpectedLineArrayLength && i < processorsWithUtilResults.size(); i++) {
			String entry = lineArray[i+minExpectedLineArrayLength];
			if (entry.length() > 0){
				ProcessingResourceSpecification processor = processorsWithUtilResults.get(i);
				ProcessingResourceSpecificationResult result = ResourceenvironmentdecoratorFactory.eINSTANCE.createProcessingResourceSpecificationResult();

				result.setResourceUtilisation(Double.parseDouble(entry));
				//TODO: implement these if possible.
				result.setDemandedTime(Double.NaN);
				result.setAverageWaitTime(Double.NaN);
				result.setProcessingResourceSpecification_ProcessingResourceSpecificationResult(processor);
				result.setEntityName("Util of "+processor.getResourceContainer_ProcessingResourceSpecification().getEntityName()
						+"_"+processor.getActiveResourceType_ActiveResourceSpecification().getEntityName());
				repo.getUtilisationResults_ResultDecoratorRepository().add(result);
			}
			
		}
		return repo;
		
	}

	private static int countConfidenceIntervals(
			List<List<CriterionAndEvaluator>> orderedObjectives) throws CoreException {
		//now count confidence intervals. 
		int numberOfConfidenceIntervals = 0;
		for (List<CriterionAndEvaluator> objectiveAndEvaluatorList : orderedObjectives) {
			if (objectiveAndEvaluatorList.size() > 0 && objectiveAndEvaluatorList.get(0).getEvaluator().hasStatisticResults()){
				numberOfConfidenceIntervals++;
			}
		}
		return numberOfConfidenceIntervals;
	}

	private static DesignDecisionGenotype extractGenotypeAndAddToList(
		    int startIndexOfGenotype,
			List<DegreeOfFreedom> orderedDesignDecisions, String[] lineArray) throws CoreException {
		
		DesignDecisionGenotype genotype = new DesignDecisionGenotype();
		//read in genotype
		int decisionIndex = 0;
		for (int i = startIndexOfGenotype; i < lineArray.length && decisionIndex < orderedDesignDecisions.size(); i++) {
			Choice gene = DSEDecoder.getChoiceFor(lineArray[i], orderedDesignDecisions.get(decisionIndex));
			genotype.add(gene);
			decisionIndex++;
		}
		return genotype;
	}

	private static DSEObjectives readInObjectivesAndConfidence(
			List<List<CriterionAndEvaluator>> orderedObjectives,
			int startIndexOfConfidence, int numberOfConfidenceIntervals,
			String[] lineArray) throws CoreException {
		//Read in objectives
		DSEObjectives objectives = readInObjectives(lineArray, startIndexOfConfidence, orderedObjectives);

		//read in confidence
		readInConfidenceIntervals(lineArray, startIndexOfConfidence, numberOfConfidenceIntervals, orderedObjectives, objectives);
		return objectives;
	}

	/**
	 * Orders the objectives based on the file and also adjusts the DSEProblem accordingly.  
	 * @param decisionList
	 * @param headlineArray
	 * @param startIndexOfGenotype
	 * @param problem
	 * @return
	 */
	private static List<DegreeOfFreedom> getOrderedDesignDecisions(
			List<DegreeOfFreedom> decisionList, String[] headlineArray,
			int startIndexOfGenotype, DSEProblem problem)  throws CoreException{
		List<DegreeOfFreedom> orderedDesignDecisions = new ArrayList<DegreeOfFreedom>();
		for (int i = startIndexOfGenotype; i < headlineArray.length; i++) {
			String headlineEntry = headlineArray[i];
			for (DegreeOfFreedom decision : decisionList) {
				//We could use an iterator here and directly delete all design decision that have been matched from the list, to make the subsequent steps faster.
				if (DegreeOfFreedomHelper.getDegreeDescription(decision).equals(headlineEntry)){
					orderedDesignDecisions.add(decision);
					break;
				}
			}
		}
		
		//Check that the last colums are only utilisation values.
		int numberOfUtilColumns = 0;
		for (int i = startIndexOfGenotype + orderedDesignDecisions.size(); i < headlineArray.length; i++){
			String headlineString = headlineArray[i];
			if (headlineString.contains("Util") || headlineString.contains("Candidate ID")){
				numberOfUtilColumns++;
			}
		}
		
		// If there were unrecognised headline entries (entries that are not before the genotype and that do 
		// not contain the Substring Util, throw an exception
		if (headlineArray.length - startIndexOfGenotype - numberOfUtilColumns > orderedDesignDecisions.size())
			throw ExceptionHelper.createNewCoreException("Not all design decisions in the file were recognised. Check your file.");
		
		//set the internal design decisions to the same order
		problem.getDesignDecisions().clear();
		problem.getDesignDecisions().addAll(orderedDesignDecisions);
		
		return orderedDesignDecisions;
	}

	/**
	 * Fills the confidence intervals of the passed objective and returns it. 
	 * @param lineArray
	 * @param startIndexOfConfidence
	 * @param numberOfConfidenceIntervals
	 * @param orderedObjectives
	 * @param objectives
	 * @return
	 * @throws CoreException
	 */
	private static DSEObjectives readInConfidenceIntervals(String[] lineArray,
			int startIndexOfConfidence, int numberOfConfidenceIntervals,
			List<List<CriterionAndEvaluator>> orderedObjectives, DSEObjectives objectives) throws CoreException {
		
		//read in confidence 
		int index = startIndexOfConfidence;
		for (List<CriterionAndEvaluator> objectiveAndEvaluatorList : orderedObjectives) {
			if (objectiveAndEvaluatorList.size() > 0){
				
				// only the first evaluator has to be handled because they all point to the same IAnalysis (e.g. SimuCom)
				CriterionAndEvaluator objectiveAndEvaluator = objectiveAndEvaluatorList.get(0);

				if (objectiveAndEvaluator.getEvaluator().hasStatisticResults() && index < lineArray.length - 2){
					String lowerConfidenceString = lineArray[index];
					String upperConfidenceString = lineArray[index+1];
					String alphaConfidenceString = lineArray[index+2];

					Criterion criterion = objectiveAndEvaluator.getCriterion();
					Value<?> value = objectives.getValueForCriterion(criterion);

					ConfidenceInterval ci = readInConfidenceInterval(lowerConfidenceString, upperConfidenceString, alphaConfidenceString, value);
					index = index +3;
					objectives.addConfidence(objectiveAndEvaluator.getCriterion(), ci);
				} else {

				}
			}
		}
		return objectives;
	}
	
	/**
	 * Objective definition must be in the first columns of the file. 
	 *  
	 * @param headline
	 * @param objectiveList: A list of lists. The inner lists contains the {@link Criterion} for one headline entry.
	 * The list is in the same order as the headline, so the values in the lines can be associated with a {@link Criterion} by index.
	 * The inner lists are not empty.   
	 * @return never null, but may be an empty list.
	 */
	private static List<List<CriterionAndEvaluator>> getOrderedObjectiveCollection(String[] headline, List<CriterionAndEvaluator> objectiveList) throws CoreException{
		
		List<List<CriterionAndEvaluator>> orderedObjectives = new ArrayList<List<CriterionAndEvaluator>>(objectiveList.size());
		
		for (int i = 0; i < headline.length; i++) {
			String objectiveString = headline[i];
			List<CriterionAndEvaluator> o = matchObjective(objectiveList, objectiveString);
			if (o.size() == 0){
				//The current entry is not an objective, so the objective columns are done
				break;
			} else {
				orderedObjectives.add(o);
			}
		}
		
		if (objectiveList.size() < orderedObjectives.size()){
			// I cannot have more objectives than evaluators. 
			// throw Exception and notify user that there must be only one column per objective
			throw ExceptionHelper.createNewCoreException("Error reading in objectives: There must be only one column for each objective.");
		}
	
		return orderedObjectives;
	}
	
	
	private static ConfidenceInterval readInConfidenceInterval(
			String lowerConfidenceString, String upperConfidenceString,
			String alphaConfidenceString,
			Value<?> value) throws CoreException {
		
		try {
			double lowerBound = parseToDouble(lowerConfidenceString);
			double upperBound = parseToDouble(upperConfidenceString);
			double level = parseToDouble(alphaConfidenceString);
			return new ConfidenceInterval(value.getDouble(), lowerBound, upperBound, level);
		} catch (NumberFormatException e){
			throw ExceptionHelper.createNewCoreException("Could not read in confidence interval. Expected this to be a confidence interval: "
					+lowerConfidenceString+SEPARATOR+upperConfidenceString+SEPARATOR+alphaConfidenceString, e);
		}
		
		
	}
	
	
	
	private static List<CriterionAndEvaluator> matchObjective(
			List<CriterionAndEvaluator> objectiveList, String objectiveString) {
		List<CriterionAndEvaluator> results = new ArrayList<CriterionAndEvaluator>(objectiveList.size());
		for (CriterionAndEvaluator objective : objectiveList) {
			if (objectiveString.equals(ResultsWriter.getDimensionName(objective.getCriterion()))){
				results.add(objective);
			}
		}
		return results;
	}
	
	/**
	 * Reads in 
	 * @param orderedObjectives 
	 * @param endIndex 
	 * @param 
	 * @return
	 * @throws IOException
	 * @throws CoreException 
	 */
	private static DSEObjectives readInObjectives(String[] objectiveLine, int endIndex, List<List<CriterionAndEvaluator>> orderedObjectives) throws CoreException {
		
		//objective line must have at least the length of the passed list
		if (objectiveLine.length < orderedObjectives.size()){
			throw ExceptionHelper.createNewCoreException("Error when reading in result line: the line is shorter ("+objectiveLine+" entries) than the number of objectives I look for ("+orderedObjectives.size()+"entries).");
		}
		
		//DSEObjectives obj = new DSEObjectives(); //TODO: LEGACY
		DSEObjectives obj = task.getInstance(DSEObjectives.class);//QUICKHACK
				
		int lineIndex = 0;
		for (List<CriterionAndEvaluator> criterionList : orderedObjectives) {
			try {
				double d = parseToDouble(objectiveLine[lineIndex]);
				for (CriterionAndEvaluator criterionAndEvaluator : criterionList) {
					Criterion criterion = criterionAndEvaluator.getCriterion();
					obj.addValueForCriterion(criterion, d);
				}
			} catch (NumberFormatException e){
				throw ExceptionHelper.createNewCoreException("Could not parse objective value "+objectiveLine[lineIndex]+". Fix your input genome file.");
			}
			lineIndex++;
		}
		
		return obj;
	}

	private static double parseToDouble(String number) {
		double d =  Double.parseDouble(number);
		if (Double.isInfinite(d)){
			logger.warn("Read in an infinite objective or confidence interval from predefined file, please check that this is correct and not result of an incomplete previous analysis step.");
		} else if (Double.isNaN(d)){
			logger.warn("Read in an objective or confidence interval with NaN value from predefined file, please check that this is correct and not result of an incomplete previous analysis step.");
		}
		return d;
	}

}

