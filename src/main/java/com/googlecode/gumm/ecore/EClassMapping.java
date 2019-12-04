/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.googlecode.gumm.ecore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EClass Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.googlecode.gumm.ecore.EClassMapping#getSource <em>Source</em>}</li>
 *   <li>{@link com.googlecode.gumm.ecore.EClassMapping#getTarget <em>Target</em>}</li>
 *   <li>{@link com.googlecode.gumm.ecore.EClassMapping#getEAttributeMappings <em>EAttribute Mappings</em>}</li>
 *   <li>{@link com.googlecode.gumm.ecore.EClassMapping#getEReferenceMappings <em>EReference Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.googlecode.gumm.ecore.GummecorePackage#getEClassMapping()
 * @model
 * @generated
 */
public interface EClassMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EClass)
	 * @see com.googlecode.gumm.ecore.GummecorePackage#getEClassMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	EClass getSource();

	/**
	 * Sets the value of the '{@link com.googlecode.gumm.ecore.EClassMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EClass value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EClass)
	 * @see com.googlecode.gumm.ecore.GummecorePackage#getEClassMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EClass getTarget();

	/**
	 * Sets the value of the '{@link com.googlecode.gumm.ecore.EClassMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EClass value);

	/**
	 * Returns the value of the '<em><b>EAttribute Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link com.googlecode.gumm.ecore.EAttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EAttribute Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EAttribute Mappings</em>' containment reference list.
	 * @see com.googlecode.gumm.ecore.GummecorePackage#getEClassMapping_EAttributeMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EAttributeMapping> getEAttributeMappings();

	/**
	 * Returns the value of the '<em><b>EReference Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link com.googlecode.gumm.ecore.EReferenceMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference Mappings</em>' containment reference list.
	 * @see com.googlecode.gumm.ecore.GummecorePackage#getEClassMapping_EReferenceMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EReferenceMapping> getEReferenceMappings();

} // EClassMapping
