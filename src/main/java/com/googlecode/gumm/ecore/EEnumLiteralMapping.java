/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.googlecode.gumm.ecore;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEnum Literal Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.googlecode.gumm.ecore.EEnumLiteralMapping#getSource <em>Source</em>}</li>
 *   <li>{@link com.googlecode.gumm.ecore.EEnumLiteralMapping#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.googlecode.gumm.ecore.GummecorePackage#getEEnumLiteralMapping()
 * @model
 * @generated
 */
public interface EEnumLiteralMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EEnumLiteral)
	 * @see com.googlecode.gumm.ecore.GummecorePackage#getEEnumLiteralMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	EEnumLiteral getSource();

	/**
	 * Sets the value of the '{@link com.googlecode.gumm.ecore.EEnumLiteralMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EEnumLiteral value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EEnumLiteral)
	 * @see com.googlecode.gumm.ecore.GummecorePackage#getEEnumLiteralMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EEnumLiteral getTarget();

	/**
	 * Sets the value of the '{@link com.googlecode.gumm.ecore.EEnumLiteralMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EEnumLiteral value);

} // EEnumLiteralMapping
