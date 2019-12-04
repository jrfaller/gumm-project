/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.googlecode.gumm.ecore;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.googlecode.gumm.ecore.GummecorePackage
 * @generated
 */
public interface GummecoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GummecoreFactory eINSTANCE = com.googlecode.gumm.ecore.impl.GummecoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ecore Alignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecore Alignment</em>'.
	 * @generated
	 */
	EcoreAlignment createEcoreAlignment();

	/**
	 * Returns a new object of class '<em>EClass Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClass Mapping</em>'.
	 * @generated
	 */
	EClassMapping createEClassMapping();

	/**
	 * Returns a new object of class '<em>EAttribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EAttribute Mapping</em>'.
	 * @generated
	 */
	EAttributeMapping createEAttributeMapping();

	/**
	 * Returns a new object of class '<em>EReference Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EReference Mapping</em>'.
	 * @generated
	 */
	EReferenceMapping createEReferenceMapping();

	/**
	 * Returns a new object of class '<em>EEnum Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EEnum Mapping</em>'.
	 * @generated
	 */
	EEnumMapping createEEnumMapping();

	/**
	 * Returns a new object of class '<em>EEnum Literal Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EEnum Literal Mapping</em>'.
	 * @generated
	 */
	EEnumLiteralMapping createEEnumLiteralMapping();

	/**
	 * Returns a new object of class '<em>EData Type Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EData Type Mapping</em>'.
	 * @generated
	 */
	EDataTypeMapping createEDataTypeMapping();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GummecorePackage getGummecorePackage();

} //GummecoreFactory
