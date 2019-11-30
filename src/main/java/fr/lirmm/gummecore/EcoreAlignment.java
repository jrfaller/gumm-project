/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lirmm.gummecore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecore Alignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lirmm.gummecore.EcoreAlignment#getEClassMappings <em>EClass Mappings</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.EcoreAlignment#getEEnumMappings <em>EEnum Mappings</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.EcoreAlignment#getEDataTypeMappings <em>EData Type Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lirmm.gummecore.GummecorePackage#getEcoreAlignment()
 * @model
 * @generated
 */
public interface EcoreAlignment extends EObject {
	/**
	 * Returns the value of the '<em><b>EClass Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link fr.lirmm.gummecore.EClassMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClass Mappings</em>' containment reference list.
	 * @see fr.lirmm.gummecore.GummecorePackage#getEcoreAlignment_EClassMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EClassMapping> getEClassMappings();

	/**
	 * Returns the value of the '<em><b>EEnum Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link fr.lirmm.gummecore.EEnumMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EEnum Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EEnum Mappings</em>' containment reference list.
	 * @see fr.lirmm.gummecore.GummecorePackage#getEcoreAlignment_EEnumMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EEnumMapping> getEEnumMappings();

	/**
	 * Returns the value of the '<em><b>EData Type Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link fr.lirmm.gummecore.EDataTypeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EData Type Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EData Type Mappings</em>' containment reference list.
	 * @see fr.lirmm.gummecore.GummecorePackage#getEcoreAlignment_EDataTypeMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EDataTypeMapping> getEDataTypeMappings();

} // EcoreAlignment
