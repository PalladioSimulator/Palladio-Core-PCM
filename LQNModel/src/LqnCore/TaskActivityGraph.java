/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Activity Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.TaskActivityGraph#getReplyEntry <em>Reply Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getTaskActivityGraph()
 * @model extendedMetaData="name='TaskActivityGraph' kind='elementOnly'"
 * @generated
 */
public interface TaskActivityGraph extends ActivityGraphBase {
	/**
	 * Returns the value of the '<em><b>Reply Entry</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ReplyEntryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reply Entry</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reply Entry</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getTaskActivityGraph_ReplyEntry()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='reply-entry' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ReplyEntryType> getReplyEntry();

} // TaskActivityGraph
