/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package RegEx.impl;

import RegEx.DistributionFunction;
import RegEx.Expression;
import RegEx.RegExPackage;
import RegEx.Sequence;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link RegEx.impl.SequenceImpl#getDistributionFunction <em>Distribution Function</em>}</li>
 *   <li>{@link RegEx.impl.SequenceImpl#getDistributionFunctionFreq <em>Distribution Function Freq</em>}</li>
 *   <li>{@link RegEx.impl.SequenceImpl#getPre <em>Pre</em>}</li>
 *   <li>{@link RegEx.impl.SequenceImpl#getPost <em>Post</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceImpl extends EObjectImpl implements Sequence {
	/**
	 * The cached value of the '{@link #getDistributionFunction() <em>Distribution Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributionFunction()
	 * @generated
	 * @ordered
	 */
	protected DistributionFunction distributionFunction = null;

	/**
	 * The cached value of the '{@link #getDistributionFunctionFreq() <em>Distribution Function Freq</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistributionFunctionFreq()
	 * @generated
	 * @ordered
	 */
	protected DistributionFunction distributionFunctionFreq = null;

	/**
	 * The cached value of the '{@link #getPre() <em>Pre</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPre()
	 * @generated
	 * @ordered
	 */
	protected Expression pre = null;

	/**
	 * The cached value of the '{@link #getPost() <em>Post</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPost()
	 * @generated
	 * @ordered
	 */
	protected Expression post = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RegExPackage.Literals.SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionFunction getDistributionFunction() {
		return distributionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDistributionFunction(DistributionFunction newDistributionFunction, NotificationChain msgs) {
		DistributionFunction oldDistributionFunction = distributionFunction;
		distributionFunction = newDistributionFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION, oldDistributionFunction, newDistributionFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistributionFunction(DistributionFunction newDistributionFunction) {
		if (newDistributionFunction != distributionFunction) {
			NotificationChain msgs = null;
			if (distributionFunction != null)
				msgs = ((InternalEObject)distributionFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION, null, msgs);
			if (newDistributionFunction != null)
				msgs = ((InternalEObject)newDistributionFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION, null, msgs);
			msgs = basicSetDistributionFunction(newDistributionFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION, newDistributionFunction, newDistributionFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionFunction getDistributionFunctionFreq() {
		return distributionFunctionFreq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDistributionFunctionFreq(DistributionFunction newDistributionFunctionFreq, NotificationChain msgs) {
		DistributionFunction oldDistributionFunctionFreq = distributionFunctionFreq;
		distributionFunctionFreq = newDistributionFunctionFreq;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION_FREQ, oldDistributionFunctionFreq, newDistributionFunctionFreq);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistributionFunctionFreq(DistributionFunction newDistributionFunctionFreq) {
		if (newDistributionFunctionFreq != distributionFunctionFreq) {
			NotificationChain msgs = null;
			if (distributionFunctionFreq != null)
				msgs = ((InternalEObject)distributionFunctionFreq).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			if (newDistributionFunctionFreq != null)
				msgs = ((InternalEObject)newDistributionFunctionFreq).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION_FREQ, null, msgs);
			msgs = basicSetDistributionFunctionFreq(newDistributionFunctionFreq, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION_FREQ, newDistributionFunctionFreq, newDistributionFunctionFreq));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getPre() {
		return pre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPre(Expression newPre, NotificationChain msgs) {
		Expression oldPre = pre;
		pre = newPre;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.SEQUENCE__PRE, oldPre, newPre);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPre(Expression newPre) {
		if (newPre != pre) {
			NotificationChain msgs = null;
			if (pre != null)
				msgs = ((InternalEObject)pre).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SEQUENCE__PRE, null, msgs);
			if (newPre != null)
				msgs = ((InternalEObject)newPre).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SEQUENCE__PRE, null, msgs);
			msgs = basicSetPre(newPre, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.SEQUENCE__PRE, newPre, newPre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getPost() {
		return post;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPost(Expression newPost, NotificationChain msgs) {
		Expression oldPost = post;
		post = newPost;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegExPackage.SEQUENCE__POST, oldPost, newPost);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPost(Expression newPost) {
		if (newPost != post) {
			NotificationChain msgs = null;
			if (post != null)
				msgs = ((InternalEObject)post).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SEQUENCE__POST, null, msgs);
			if (newPost != null)
				msgs = ((InternalEObject)newPost).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegExPackage.SEQUENCE__POST, null, msgs);
			msgs = basicSetPost(newPost, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.SEQUENCE__POST, newPost, newPost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION:
				return basicSetDistributionFunction(null, msgs);
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION_FREQ:
				return basicSetDistributionFunctionFreq(null, msgs);
			case RegExPackage.SEQUENCE__PRE:
				return basicSetPre(null, msgs);
			case RegExPackage.SEQUENCE__POST:
				return basicSetPost(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION:
				return getDistributionFunction();
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION_FREQ:
				return getDistributionFunctionFreq();
			case RegExPackage.SEQUENCE__PRE:
				return getPre();
			case RegExPackage.SEQUENCE__POST:
				return getPost();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)newValue);
				return;
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)newValue);
				return;
			case RegExPackage.SEQUENCE__PRE:
				setPre((Expression)newValue);
				return;
			case RegExPackage.SEQUENCE__POST:
				setPost((Expression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION:
				setDistributionFunction((DistributionFunction)null);
				return;
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION_FREQ:
				setDistributionFunctionFreq((DistributionFunction)null);
				return;
			case RegExPackage.SEQUENCE__PRE:
				setPre((Expression)null);
				return;
			case RegExPackage.SEQUENCE__POST:
				setPost((Expression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION:
				return distributionFunction != null;
			case RegExPackage.SEQUENCE__DISTRIBUTION_FUNCTION_FREQ:
				return distributionFunctionFreq != null;
			case RegExPackage.SEQUENCE__PRE:
				return pre != null;
			case RegExPackage.SEQUENCE__POST:
				return post != null;
		}
		return super.eIsSet(featureID);
	}

} //SequenceImpl