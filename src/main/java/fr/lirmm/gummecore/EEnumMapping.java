/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lirmm.gummecore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEnum Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lirmm.gummecore.EEnumMapping#getSource <em>Source</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.EEnumMapping#getTarget <em>Target</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.EEnumMapping#getEEnumLiteralMappings <em>EEnum Literal Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lirmm.gummecore.GummecorePackage#getEEnumMapping()
 * @model
 * @generated
 */
public interface EEnumMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EEnum)
	 * @see fr.lirmm.gummecore.GummecorePackage#getEEnumMapping_Source()
	 * @model required="true"
	 * @generated
	 */
	EEnum getSource();

	/**
	 * Sets the value of the '{@link fr.lirmm.gummecore.EEnumMapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EEnum value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EEnum)
	 * @see fr.lirmm.gummecore.GummecorePackage#getEEnumMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	EEnum getTarget();

	/**
	 * Sets the value of the '{@link fr.lirmm.gummecore.EEnumMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EEnum value);

	/**
	 * Returns the value of the '<em><b>EEnum Literal Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link fr.lirmm.gummecore.EEnumLiteralMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EEnum Literal Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EEnum Literal Mappings</em>' containment reference list.
	 * @see fr.lirmm.gummecore.GummecorePackage#getEEnumMapping_EEnumLiteralMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EEnumLiteralMapping> getEEnumLiteralMappings();

} // EEnumMapping
