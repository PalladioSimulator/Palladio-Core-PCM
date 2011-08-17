package de.uka.ipd.sdq.simucomframework.usage;

/**
 * Interface implemented by all users. Users have a behaviour as specified by
 * IScenarioRunner and additionally contain a start method which informs them
 * about their "birth"
 * 
 * @author Steffen Becker
 * 
 */
public interface IUser extends IScenarioRunner {

	/**
	 * Called by the framework to tell the user that he just was born and that
	 * he is now ready to conquer the world.
	 */
	void startUserLife();
}
