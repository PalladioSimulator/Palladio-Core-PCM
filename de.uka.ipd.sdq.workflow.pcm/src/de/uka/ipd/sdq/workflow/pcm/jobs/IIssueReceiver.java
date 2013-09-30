package de.uka.ipd.sdq.workflow.pcm.jobs;

import java.util.List;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;

/**Interface to describe that issues can be added to an implementing class.
 * Used for error reporting.
 * @author groenda
 *
 */
public interface IIssueReceiver {

	/**Makes issues known.
	 * @param issues List of issues.
	 */
	public void addIssues(List<SeverityAndIssue> issues);
}
