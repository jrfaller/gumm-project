/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lirmm.gummecore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EAttribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lirmm.gummecore.EAttributeMapping#getSource <em>Source</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.EAttributeMapping#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lirmm.gummecore.GummecorePackage#getEAttributeMapping()
 * @model
 * @generated
 */
public interface EAttributeMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EAttribute)
	 * @see fr.lirmm.gummecore.GummecorePackage#getEAttributeMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getSource();

	/**
	 * Sets the value of the '{@link fr.lirmm.gummecore.EAttributeMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EAttribute)
	 * @see fr.lirmm.gummecore.GummecorePackage#getEAttributeMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getTarget();

	/**
	 * Sets the value of the '{@link fr.lirmm.gummecore.EAttributeMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EAttribute value);

} // EAttributeMapping
