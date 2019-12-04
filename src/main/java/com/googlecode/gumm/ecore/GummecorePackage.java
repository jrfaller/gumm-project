/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.googlecode.gumm.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.googlecode.gumm.ecore.GummecoreFactory
 * @model kind="package"
 * @generated
 */
public interface GummecorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gummecore";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.lirmm.fr/gumm/1.0.0/gummecore.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gummecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GummecorePackage eINSTANCE = com.googlecode.gumm.ecore.impl.GummecorePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.googlecode.gumm.ecore.impl.EcoreAlignmentImpl <em>Ecore Alignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.googlecode.gumm.ecore.impl.EcoreAlignmentImpl
	 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEcoreAlignment()
	 * @generated
	 */
	int ECORE_ALIGNMENT = 0;

	/**
	 * The feature id for the '<em><b>EClass Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_ALIGNMENT__ECLASS_MAPPINGS = 0;

	/**
	 * The feature id for the '<em><b>EEnum Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_ALIGNMENT__EENUM_MAPPINGS = 1;

	/**
	 * The feature id for the '<em><b>EData Type Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_ALIGNMENT__EDATA_TYPE_MAPPINGS = 2;

	/**
	 * The number of structural features of the '<em>Ecore Alignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_ALIGNMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.googlecode.gumm.ecore.impl.EClassMappingImpl <em>EClass Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.googlecode.gumm.ecore.impl.EClassMappingImpl
	 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEClassMapping()
	 * @generated
	 */
	int ECLASS_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_MAPPING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_MAPPING__TARGET = 1;

	/**
	 * The feature id for the '<em><b>EAttribute Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_MAPPING__EATTRIBUTE_MAPPINGS = 2;

	/**
	 * The feature id for the '<em><b>EReference Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_MAPPING__EREFERENCE_MAPPINGS = 3;

	/**
	 * The number of structural features of the '<em>EClass Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_MAPPING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.googlecode.gumm.ecore.impl.EAttributeMappingImpl <em>EAttribute Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.googlecode.gumm.ecore.impl.EAttributeMappingImpl
	 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEAttributeMapping()
	 * @generated
	 */
	int EATTRIBUTE_MAPPING = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_MAPPING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_MAPPING__TARGET = 1;

	/**
	 * The number of structural features of the '<em>EAttribute Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.googlecode.gumm.ecore.impl.EReferenceMappingImpl <em>EReference Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.googlecode.gumm.ecore.impl.EReferenceMappingImpl
	 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEReferenceMapping()
	 * @generated
	 */
	int EREFERENCE_MAPPING = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_MAPPING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_MAPPING__TARGET = 1;

	/**
	 * The number of structural features of the '<em>EReference Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EREFERENCE_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.googlecode.gumm.ecore.impl.EEnumMappingImpl <em>EEnum Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.googlecode.gumm.ecore.impl.EEnumMappingImpl
	 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEEnumMapping()
	 * @generated
	 */
	int EENUM_MAPPING = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_MAPPING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_MAPPING__TARGET = 1;

	/**
	 * The feature id for the '<em><b>EEnum Literal Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_MAPPING__EENUM_LITERAL_MAPPINGS = 2;

	/**
	 * The number of structural features of the '<em>EEnum Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_MAPPING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.googlecode.gumm.ecore.impl.EEnumLiteralMappingImpl <em>EEnum Literal Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.googlecode.gumm.ecore.impl.EEnumLiteralMappingImpl
	 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEEnumLiteralMapping()
	 * @generated
	 */
	int EENUM_LITERAL_MAPPING = 5;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_MAPPING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_MAPPING__TARGET = 1;

	/**
	 * The number of structural features of the '<em>EEnum Literal Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_MAPPING_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link com.googlecode.gumm.ecore.impl.EDataTypeMappingImpl <em>EData Type Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.googlecode.gumm.ecore.impl.EDataTypeMappingImpl
	 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEDataTypeMapping()
	 * @generated
	 */
	int EDATA_TYPE_MAPPING = 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_MAPPING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_MAPPING__TARGET = 1;

	/**
	 * The number of structural features of the '<em>EData Type Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDATA_TYPE_MAPPING_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link com.googlecode.gumm.ecore.EcoreAlignment <em>Ecore Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Alignment</em>'.
	 * @see com.googlecode.gumm.ecore.EcoreAlignment
	 * @generated
	 */
	EClass getEcoreAlignment();

	/**
	 * Returns the meta object for the containment reference list '{@link com.googlecode.gumm.ecore.EcoreAlignment#getEClassMappings <em>EClass Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EClass Mappings</em>'.
	 * @see com.googlecode.gumm.ecore.EcoreAlignment#getEClassMappings()
	 * @see #getEcoreAlignment()
	 * @generated
	 */
	EReference getEcoreAlignment_EClassMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link com.googlecode.gumm.ecore.EcoreAlignment#getEEnumMappings <em>EEnum Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EEnum Mappings</em>'.
	 * @see com.googlecode.gumm.ecore.EcoreAlignment#getEEnumMappings()
	 * @see #getEcoreAlignment()
	 * @generated
	 */
	EReference getEcoreAlignment_EEnumMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link com.googlecode.gumm.ecore.EcoreAlignment#getEDataTypeMappings <em>EData Type Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EData Type Mappings</em>'.
	 * @see com.googlecode.gumm.ecore.EcoreAlignment#getEDataTypeMappings()
	 * @see #getEcoreAlignment()
	 * @generated
	 */
	EReference getEcoreAlignment_EDataTypeMappings();

	/**
	 * Returns the meta object for class '{@link com.googlecode.gumm.ecore.EClassMapping <em>EClass Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClass Mapping</em>'.
	 * @see com.googlecode.gumm.ecore.EClassMapping
	 * @generated
	 */
	EClass getEClassMapping();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EClassMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.googlecode.gumm.ecore.EClassMapping#getSource()
	 * @see #getEClassMapping()
	 * @generated
	 */
	EReference getEClassMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EClassMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.googlecode.gumm.ecore.EClassMapping#getTarget()
	 * @see #getEClassMapping()
	 * @generated
	 */
	EReference getEClassMapping_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link com.googlecode.gumm.ecore.EClassMapping#getEAttributeMappings <em>EAttribute Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EAttribute Mappings</em>'.
	 * @see com.googlecode.gumm.ecore.EClassMapping#getEAttributeMappings()
	 * @see #getEClassMapping()
	 * @generated
	 */
	EReference getEClassMapping_EAttributeMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link com.googlecode.gumm.ecore.EClassMapping#getEReferenceMappings <em>EReference Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EReference Mappings</em>'.
	 * @see com.googlecode.gumm.ecore.EClassMapping#getEReferenceMappings()
	 * @see #getEClassMapping()
	 * @generated
	 */
	EReference getEClassMapping_EReferenceMappings();

	/**
	 * Returns the meta object for class '{@link com.googlecode.gumm.ecore.EAttributeMapping <em>EAttribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAttribute Mapping</em>'.
	 * @see com.googlecode.gumm.ecore.EAttributeMapping
	 * @generated
	 */
	EClass getEAttributeMapping();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EAttributeMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.googlecode.gumm.ecore.EAttributeMapping#getSource()
	 * @see #getEAttributeMapping()
	 * @generated
	 */
	EReference getEAttributeMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EAttributeMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.googlecode.gumm.ecore.EAttributeMapping#getTarget()
	 * @see #getEAttributeMapping()
	 * @generated
	 */
	EReference getEAttributeMapping_Target();

	/**
	 * Returns the meta object for class '{@link com.googlecode.gumm.ecore.EReferenceMapping <em>EReference Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EReference Mapping</em>'.
	 * @see com.googlecode.gumm.ecore.EReferenceMapping
	 * @generated
	 */
	EClass getEReferenceMapping();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EReferenceMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.googlecode.gumm.ecore.EReferenceMapping#getSource()
	 * @see #getEReferenceMapping()
	 * @generated
	 */
	EReference getEReferenceMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EReferenceMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.googlecode.gumm.ecore.EReferenceMapping#getTarget()
	 * @see #getEReferenceMapping()
	 * @generated
	 */
	EReference getEReferenceMapping_Target();

	/**
	 * Returns the meta object for class '{@link com.googlecode.gumm.ecore.EEnumMapping <em>EEnum Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEnum Mapping</em>'.
	 * @see com.googlecode.gumm.ecore.EEnumMapping
	 * @generated
	 */
	EClass getEEnumMapping();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EEnumMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.googlecode.gumm.ecore.EEnumMapping#getSource()
	 * @see #getEEnumMapping()
	 * @generated
	 */
	EReference getEEnumMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EEnumMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.googlecode.gumm.ecore.EEnumMapping#getTarget()
	 * @see #getEEnumMapping()
	 * @generated
	 */
	EReference getEEnumMapping_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link com.googlecode.gumm.ecore.EEnumMapping#getEEnumLiteralMappings <em>EEnum Literal Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EEnum Literal Mappings</em>'.
	 * @see com.googlecode.gumm.ecore.EEnumMapping#getEEnumLiteralMappings()
	 * @see #getEEnumMapping()
	 * @generated
	 */
	EReference getEEnumMapping_EEnumLiteralMappings();

	/**
	 * Returns the meta object for class '{@link com.googlecode.gumm.ecore.EEnumLiteralMapping <em>EEnum Literal Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEnum Literal Mapping</em>'.
	 * @see com.googlecode.gumm.ecore.EEnumLiteralMapping
	 * @generated
	 */
	EClass getEEnumLiteralMapping();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EEnumLiteralMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.googlecode.gumm.ecore.EEnumLiteralMapping#getSource()
	 * @see #getEEnumLiteralMapping()
	 * @generated
	 */
	EReference getEEnumLiteralMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EEnumLiteralMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.googlecode.gumm.ecore.EEnumLiteralMapping#getTarget()
	 * @see #getEEnumLiteralMapping()
	 * @generated
	 */
	EReference getEEnumLiteralMapping_Target();

	/**
	 * Returns the meta object for class '{@link com.googlecode.gumm.ecore.EDataTypeMapping <em>EData Type Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EData Type Mapping</em>'.
	 * @see com.googlecode.gumm.ecore.EDataTypeMapping
	 * @generated
	 */
	EClass getEDataTypeMapping();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EDataTypeMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.googlecode.gumm.ecore.EDataTypeMapping#getSource()
	 * @see #getEDataTypeMapping()
	 * @generated
	 */
	EReference getEDataTypeMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link com.googlecode.gumm.ecore.EDataTypeMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.googlecode.gumm.ecore.EDataTypeMapping#getTarget()
	 * @see #getEDataTypeMapping()
	 * @generated
	 */
	EReference getEDataTypeMapping_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GummecoreFactory getGummecoreFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.googlecode.gumm.ecore.impl.EcoreAlignmentImpl <em>Ecore Alignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.googlecode.gumm.ecore.impl.EcoreAlignmentImpl
		 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEcoreAlignment()
		 * @generated
		 */
		EClass ECORE_ALIGNMENT = eINSTANCE.getEcoreAlignment();

		/**
		 * The meta object literal for the '<em><b>EClass Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_ALIGNMENT__ECLASS_MAPPINGS = eINSTANCE.getEcoreAlignment_EClassMappings();

		/**
		 * The meta object literal for the '<em><b>EEnum Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_ALIGNMENT__EENUM_MAPPINGS = eINSTANCE.getEcoreAlignment_EEnumMappings();

		/**
		 * The meta object literal for the '<em><b>EData Type Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_ALIGNMENT__EDATA_TYPE_MAPPINGS = eINSTANCE.getEcoreAlignment_EDataTypeMappings();

		/**
		 * The meta object literal for the '{@link com.googlecode.gumm.ecore.impl.EClassMappingImpl <em>EClass Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.googlecode.gumm.ecore.impl.EClassMappingImpl
		 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEClassMapping()
		 * @generated
		 */
		EClass ECLASS_MAPPING = eINSTANCE.getEClassMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_MAPPING__SOURCE = eINSTANCE.getEClassMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_MAPPING__TARGET = eINSTANCE.getEClassMapping_Target();

		/**
		 * The meta object literal for the '<em><b>EAttribute Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_MAPPING__EATTRIBUTE_MAPPINGS = eINSTANCE.getEClassMapping_EAttributeMappings();

		/**
		 * The meta object literal for the '<em><b>EReference Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_MAPPING__EREFERENCE_MAPPINGS = eINSTANCE.getEClassMapping_EReferenceMappings();

		/**
		 * The meta object literal for the '{@link com.googlecode.gumm.ecore.impl.EAttributeMappingImpl <em>EAttribute Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.googlecode.gumm.ecore.impl.EAttributeMappingImpl
		 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEAttributeMapping()
		 * @generated
		 */
		EClass EATTRIBUTE_MAPPING = eINSTANCE.getEAttributeMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EATTRIBUTE_MAPPING__SOURCE = eINSTANCE.getEAttributeMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EATTRIBUTE_MAPPING__TARGET = eINSTANCE.getEAttributeMapping_Target();

		/**
		 * The meta object literal for the '{@link com.googlecode.gumm.ecore.impl.EReferenceMappingImpl <em>EReference Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.googlecode.gumm.ecore.impl.EReferenceMappingImpl
		 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEReferenceMapping()
		 * @generated
		 */
		EClass EREFERENCE_MAPPING = eINSTANCE.getEReferenceMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_MAPPING__SOURCE = eINSTANCE.getEReferenceMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EREFERENCE_MAPPING__TARGET = eINSTANCE.getEReferenceMapping_Target();

		/**
		 * The meta object literal for the '{@link com.googlecode.gumm.ecore.impl.EEnumMappingImpl <em>EEnum Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.googlecode.gumm.ecore.impl.EEnumMappingImpl
		 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEEnumMapping()
		 * @generated
		 */
		EClass EENUM_MAPPING = eINSTANCE.getEEnumMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_MAPPING__SOURCE = eINSTANCE.getEEnumMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_MAPPING__TARGET = eINSTANCE.getEEnumMapping_Target();

		/**
		 * The meta object literal for the '<em><b>EEnum Literal Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_MAPPING__EENUM_LITERAL_MAPPINGS = eINSTANCE.getEEnumMapping_EEnumLiteralMappings();

		/**
		 * The meta object literal for the '{@link com.googlecode.gumm.ecore.impl.EEnumLiteralMappingImpl <em>EEnum Literal Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.googlecode.gumm.ecore.impl.EEnumLiteralMappingImpl
		 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEEnumLiteralMapping()
		 * @generated
		 */
		EClass EENUM_LITERAL_MAPPING = eINSTANCE.getEEnumLiteralMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_LITERAL_MAPPING__SOURCE = eINSTANCE.getEEnumLiteralMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_LITERAL_MAPPING__TARGET = eINSTANCE.getEEnumLiteralMapping_Target();

		/**
		 * The meta object literal for the '{@link com.googlecode.gumm.ecore.impl.EDataTypeMappingImpl <em>EData Type Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.googlecode.gumm.ecore.impl.EDataTypeMappingImpl
		 * @see com.googlecode.gumm.ecore.impl.GummecorePackageImpl#getEDataTypeMapping()
		 * @generated
		 */
		EClass EDATA_TYPE_MAPPING = eINSTANCE.getEDataTypeMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDATA_TYPE_MAPPING__SOURCE = eINSTANCE.getEDataTypeMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDATA_TYPE_MAPPING__TARGET = eINSTANCE.getEDataTypeMapping_Target();

	}

} //GummecorePackage
