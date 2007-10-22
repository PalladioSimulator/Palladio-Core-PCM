package de.uka.ipd.sdq.pcmsolver.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;

import junit.framework.JUnit4TestAdapter;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import LqnCore.ActivityMakingCallType;
import LqnCore.ActivityPhasesType;
import LqnCore.EntryType;
import LqnCore.LqnCoreFactory;
import LqnCore.LqnModelType;
import LqnCore.PhaseActivities;
import LqnCore.ProcessorType;
import LqnCore.SchedulingType;
import LqnCore.SolverParamsType;
import LqnCore.TaskSchedulingType;
import LqnCore.TaskType;
import LqnCore.TypeType;


public class LQNTest {

	private static Logger logger = Logger.getLogger(LQNTest.class.getName());
	private static final String FILENAME_INPUT = "C:\\Temp\\test.xml";
	private static final String FILENAME_RESULT = "C:\\Temp\\test.out";
	private static final String FILENAME_LQN = "C:\\Temp\\test.lqn";;
	


	@Before
	public void setUp(){
		
		
	}
	
	@Test
	public void handle(){
		
		LqnCoreFactory fac = LqnCoreFactory.eINSTANCE;
		LqnModelType lmt = fac.createLqnModelType();
		lmt.setName("cmpdesign");
		
		SolverParamsType spt = fac.createSolverParamsType();
		spt.setComment("Design Comparison Heiko");
		spt.setConvVal("1e-005");
		spt.setItLimit(50);
		spt.setPrintInt(10);
		spt.setUnderrelaxCoeff("0.5");
		lmt.setSolverParams(spt);

		getProcessor1(fac, lmt);
		getProcessor2(fac, lmt);
		getProcessor3(fac, lmt);
		
		saveToXMIFile(lmt, FILENAME_INPUT);
		fixFile(FILENAME_INPUT);
		runLqnTools();
		
		printResultToConsole();
		
	}

		
	private void printResultToConsole() {
		FileInputStream fis = null;
		byte b[]= null;
		try {
			fis = new FileInputStream(FILENAME_RESULT);
			int x = 0;
			x = fis.available();
			b= new byte[x];
			fis.read(b);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String content = new String(b);
		System.out.println(content);
	}

	private void runLqnTools() {
		try {
			Runtime.getRuntime().exec( "lqn2xml -o"+FILENAME_LQN+" -Olqn "+FILENAME_INPUT );
			Thread.sleep(500);
			Runtime.getRuntime().exec( "lqns -o"+FILENAME_RESULT+" "+FILENAME_LQN );
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void fixFile(String filename) {
		FileInputStream fis = null;
		byte b[]= null;
		try {
			fis = new FileInputStream(filename);
			int x = 0;
			x = fis.available();
			b= new byte[x];
			fis.read(b);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String content = new String(b);
		content = content.replaceAll("LqnModelType", "lqn-model");
		content = content.replaceAll("entryPhaseActivities", "entry-phase-activities");
		content = content.replaceAll("solverParams", "solver-params");
		content = content.replaceAll("synchCall", "synch-call");
		content = content.replaceAll("convVal", "conv_val");
		content = content.replaceAll("itLimit", "it_limit");
		content = content.replaceAll("printInt", "print_int");
		content = content.replaceAll("underrelaxCoeff", "underrelax_coeff");
		content = content.replaceAll("hostDemandMean", "host-demand-mean");
		content = content.replaceAll("callsMean", "calls-mean");
		content = content.replaceAll("xmlns=\"file:/C:/Program%20Files/LQN%20Solvers/lqn-core.xsd\"", "xsi:noNamespaceSchemaLocation=\"file:///C:/Program Files/LQN Solvers/lqn.xsd\"");
		content = content.replaceAll("xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\"", "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filename);
			fos.write(content.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void getProcessor3(LqnCoreFactory fac, LqnModelType lmt) {

		ProcessorType pt = fac.createProcessorType();
		pt.setName("FileServer");
		pt.setScheduling(SchedulingType.FCFS);		
		lmt.getProcessor().add(pt);
		
		TaskType tt = fac.createTaskType();
		tt.setName("FileServer");
		tt.setScheduling(TaskSchedulingType.FCFS);
		pt.getTask().add(tt);
		
		EntryType et = fac.createEntryType();
		et.setName("FileServer_Screen");
		et.setType(TypeType.PH1PH2);
		tt.getEntry().add(et);
		
		PhaseActivities pa = fac.createPhaseActivities();
		et.setEntryPhaseActivities(pa);
		
		ActivityPhasesType apt = fac.createActivityPhasesType();
		apt.setName("FileServer_Screen_ph1");
		apt.setPhase(new BigInteger("1"));
		apt.setHostDemandMean("0.4");
		pa.getActivity().add(apt);

		ActivityPhasesType apt2 = fac.createActivityPhasesType();
		apt2.setName("FileServer_Screen_ph2");
		apt2.setPhase(new BigInteger("2"));
		apt2.setHostDemandMean("0.1");
		pa.getActivity().add(apt2);
		
		
		EntryType et2 = fac.createEntryType();
		et2.setName("FileServer_Data");
		et2.setType(TypeType.PH1PH2);
		tt.getEntry().add(et2);
		
		PhaseActivities pa2 = fac.createPhaseActivities();
		et2.setEntryPhaseActivities(pa2);
		
		ActivityPhasesType apt3 = fac.createActivityPhasesType();
		apt3.setName("FileServer_Data_ph1");
		apt3.setPhase(new BigInteger("1"));
		apt3.setHostDemandMean("0.4");
		pa2.getActivity().add(apt3);

		ActivityPhasesType apt4 = fac.createActivityPhasesType();
		apt4.setName("FileServer_Data_ph1");
		apt4.setPhase(new BigInteger("2"));
		apt4.setHostDemandMean("0.1");
		pa2.getActivity().add(apt4);
	}

			
	
	
	private void getProcessor2(LqnCoreFactory fac, LqnModelType lmt) {
		ProcessorType pt2 = fac.createProcessorType();
		pt2.setName("Application");
		pt2.setScheduling(SchedulingType.FCFS);		
		lmt.getProcessor().add(pt2);
		
		TaskType tt2 = fac.createTaskType();
		tt2.setName("Application");
		tt2.setScheduling(TaskSchedulingType.FCFS);
		pt2.getTask().add(tt2);
		
		EntryType et2 = fac.createEntryType();
		et2.setName("Application_Rqst");
		et2.setType(TypeType.PH1PH2);
		tt2.getEntry().add(et2);
		
		PhaseActivities pa2 = fac.createPhaseActivities();
		et2.setEntryPhaseActivities(pa2);
		
		ActivityPhasesType apt2 = fac.createActivityPhasesType();
		apt2.setName("Application_Rqst_ph1");
		apt2.setPhase(new BigInteger("1"));
		apt2.setHostDemandMean("0.7");
		pa2.getActivity().add(apt2);
		
		ActivityMakingCallType amct3 = fac.createActivityMakingCallType();
		amct3.setCallsMean("1");
		amct3.setDest("FileServer_Data");
		apt2.getSynchCall().add(amct3);
		
		ActivityPhasesType apt3 = fac.createActivityPhasesType();
		apt3.setName("Application_Rqst_ph2");
		apt3.setPhase(new BigInteger("2"));
		apt3.setHostDemandMean("0.3");
		pa2.getActivity().add(apt3);
	}

	private void getProcessor1(LqnCoreFactory fac, LqnModelType lmt) {
		ProcessorType pt = fac.createProcessorType();
		pt.setName("Clients");
		pt.setMultiplicity(new BigInteger("0"));
		pt.setScheduling(SchedulingType.FCFS);
		lmt.getProcessor().add(pt);
		
		TaskType tt = fac.createTaskType();
		tt.setName("Clients");
		tt.setMultiplicity(new BigInteger("4"));
		tt.setScheduling(TaskSchedulingType.REF);
		pt.getTask().add(tt);
		
		EntryType et = fac.createEntryType();
		et.setName("Clients");
		et.setType(TypeType.PH1PH2);
		tt.getEntry().add(et);
		
		PhaseActivities pa = fac.createPhaseActivities();
		et.setEntryPhaseActivities(pa);
		
		ActivityPhasesType apt = fac.createActivityPhasesType();
		apt.setName("Clients_ph2");
		apt.setPhase(new BigInteger("2"));
		apt.setHostDemandMean("10");
		pa.getActivity().add(apt);
		
		ActivityMakingCallType amct = fac.createActivityMakingCallType();
		amct.setCallsMean("5");
		amct.setDest("FileServer_Screen");
		apt.getSynchCall().add(amct);
		
		ActivityMakingCallType amct2 = fac.createActivityMakingCallType();
		amct2.setCallsMean("2");
		amct2.setDest("Application_Rqst");
		apt.getSynchCall().add(amct2);
	}
	
	
	private void saveToXMIFile(EObject modelToSave, String fileName) {
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		URI fileURI = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(modelToSave);
		
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	
	
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(LQNTest.class);
	}
}