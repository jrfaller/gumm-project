/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.googlecode.gumm.gummecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EReference Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.googlecode.gumm.gummecore.EReferenceMapping#getSource <em>Source</em>}</li>
 *   <li>{@link com.googlecode.gumm.gummecore.EReferenceMapping#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.googlecode.gumm.gummecore.GummecorePackage#getEReferenceMapping()
 * @model
 * @generated
 */
public interface EReferenceMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EReference)
	 * @see com.googlecode.gumm.gummecore.GummecorePackage#getEReferenceMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	EReference getSource();

	/**
	 * Sets the value of the '{@link com.googlecode.gumm.gummecore.EReferenceMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EReference value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EReference)
	 * @see com.googlecode.gumm.gummecore.GummecorePackage#getEReferenceMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EReference getTarget();

	/**
	 * Sets the value of the '{@link com.googlecode.gumm.gummecore.EReferenceMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EReference value);

} // EReferenceMapping
