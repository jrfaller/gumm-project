/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.googlecode.gumm.gummecore;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EData Type Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.googlecode.gumm.gummecore.EDataTypeMapping#getSource <em>Source</em>}</li>
 *   <li>{@link com.googlecode.gumm.gummecore.EDataTypeMapping#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.googlecode.gumm.gummecore.GummecorePackage#getEDataTypeMapping()
 * @model
 * @generated
 */
public interface EDataTypeMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EDataType)
	 * @see com.googlecode.gumm.gummecore.GummecorePackage#getEDataTypeMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	EDataType getSource();

	/**
	 * Sets the value of the '{@link com.googlecode.gumm.gummecore.EDataTypeMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EDataType value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EDataType)
	 * @see com.googlecode.gumm.gummecore.GummecorePackage#getEDataTypeMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EDataType getTarget();

	/**
	 * Sets the value of the '{@link com.googlecode.gumm.gummecore.EDataTypeMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EDataType value);

} // EDataTypeMapping
