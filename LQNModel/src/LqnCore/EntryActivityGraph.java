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
 * A representation of the model object '<em><b>Entry Activity Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.EntryActivityGraph#getReplyActivity <em>Reply Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getEntryActivityGraph()
 * @model extendedMetaData="name='EntryActivityGraph' kind='elementOnly'"
 * @generated
 */
public interface EntryActivityGraph extends ActivityGraphBase {
	/**
	 * Returns the value of the '<em><b>Reply Activity</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ReplyActivityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reply Activity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reply Activity</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getEntryActivityGraph_ReplyActivity()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='reply-activity' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ReplyActivityType> getReplyActivity();

} // EntryActivityGraph
