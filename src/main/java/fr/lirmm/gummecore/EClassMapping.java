/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lirmm.gummecore;

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
 *   <li>{@link fr.lirmm.gummecore.EClassMapping#getSource <em>Source</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.EClassMapping#getTarget <em>Target</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.EClassMapping#getEAttributeMappings <em>EAttribute Mappings</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.EClassMapping#getEReferenceMappings <em>EReference Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lirmm.gummecore.GummecorePackage#getEClassMapping()
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
	 * @see fr.lirmm.gummecore.GummecorePackage#getEClassMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	EClass getSource();

	/**
	 * Sets the value of the '{@link fr.lirmm.gummecore.EClassMapping#getSource <em>Source</em>}' reference.
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
	 * @see fr.lirmm.gummecore.GummecorePackage#getEClassMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EClass getTarget();

	/**
	 * Sets the value of the '{@link fr.lirmm.gummecore.EClassMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EClass value);

	/**
	 * Returns the value of the '<em><b>EAttribute Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link fr.lirmm.gummecore.EAttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EAttribute Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EAttribute Mappings</em>' containment reference list.
	 * @see fr.lirmm.gummecore.GummecorePackage#getEClassMapping_EAttributeMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EAttributeMapping> getEAttributeMappings();

	/**
	 * Returns the value of the '<em><b>EReference Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link fr.lirmm.gummecore.EReferenceMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference Mappings</em>' containment reference list.
	 * @see fr.lirmm.gummecore.GummecorePackage#getEClassMapping_EReferenceMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EReferenceMapping> getEReferenceMappings();

} // EClassMapping
