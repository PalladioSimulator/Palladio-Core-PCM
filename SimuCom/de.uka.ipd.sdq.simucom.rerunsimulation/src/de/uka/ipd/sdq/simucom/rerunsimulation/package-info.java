/**
 * The main purpose of this plug-in is to rerun a SimuCom simulation with the possibility to skip
 * unnecessary steps. When using the SimuBench to simulate a model, those model parts get copied to
 * a newly created project. After validating these models, the code based on those models is
 * created. Other essential steps include the creation of the plugin.xml or MANIFEST.MF. The last
 * steps before the actual simulation is started include jobs such as compiling and building the
 * generated project and moving it to the simulation dock so that the progress of the simulation is
 * visible.</br></br>
 * 
 * When a user only wants to change some of the simulation settings (measurements count, simulation
 * time,...) he would have to delete the generated project and run through every single step again.
 * This plug-in was developed in order to make changes on the simulation settings and rerun the
 * SimuCom simulation without the complete regeneration of the project. In fact, the only jobs that
 * are still executed can be seen in de.uka.ipd.sdq.simucom.rerunsimulation.jobs.RerunSimulationJob
 * Despite the pure resimulation of a generated project it is possible to regenerate code to a
 * certain aspect. A user may want to adjust the allocation, system or usage model which all have
 * influences on the code. When specific boxes in the GUI are checked one of these (or all) models
 * are regenerated.</br></br>
 * 
 * A short presentation on features the plug-in has to offer can be found <a
 * href="presentation.pdf">here</a>. </br></br>
 * 
 * This plug-in is divided as follows:</br></br>
 * 
 * @see de.uka.ipd.sdq.simucom.rerunsimulation.filter
 * 
 * @see de.uka.ipd.sdq.simucom.rerunsimulation.jobs
 * 
 * @see de.uka.ipd.sdq.simucom.rerunsimulation.runconfig
 * 
 * @author Michael Junker
 *
 */
package de.uka.ipd.sdq.simucom.rerunsimulation;