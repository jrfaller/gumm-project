/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.googlecode.gumm.gummecore.impl;

import com.googlecode.gumm.gummecore.EAttributeMapping;
import com.googlecode.gumm.gummecore.EClassMapping;
import com.googlecode.gumm.gummecore.EDataTypeMapping;
import com.googlecode.gumm.gummecore.EEnumLiteralMapping;
import com.googlecode.gumm.gummecore.EEnumMapping;
import com.googlecode.gumm.gummecore.EReferenceMapping;
import com.googlecode.gumm.gummecore.EcoreAlignment;
import com.googlecode.gumm.gummecore.GummecoreFactory;
import com.googlecode.gumm.gummecore.GummecorePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GummecorePackageImpl extends EPackageImpl implements GummecorePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecoreAlignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClassMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAttributeMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eReferenceMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEnumMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEnumLiteralMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDataTypeMappingEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.googlecode.gumm.gummecore.GummecorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GummecorePackageImpl() {
		super(eNS_URI, GummecoreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GummecorePackage init() {
		if (isInited) return (GummecorePackage)EPackage.Registry.INSTANCE.getEPackage(GummecorePackage.eNS_URI);

		// Obtain or create and register package
		GummecorePackageImpl theGummecorePackage = (GummecorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof GummecorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new GummecorePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGummecorePackage.createPackageContents();

		// Initialize created meta-data
		theGummecorePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGummecorePackage.freeze();

		return theGummecorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcoreAlignment() {
		return ecoreAlignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcoreAlignment_EClassMappings() {
		return (EReference)ecoreAlignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcoreAlignment_EEnumMappings() {
		return (EReference)ecoreAlignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcoreAlignment_EDataTypeMappings() {
		return (EReference)ecoreAlignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClassMapping() {
		return eClassMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassMapping_Source() {
		return (EReference)eClassMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassMapping_Target() {
		return (EReference)eClassMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassMapping_EAttributeMappings() {
		return (EReference)eClassMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassMapping_EReferenceMappings() {
		return (EReference)eClassMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAttributeMapping() {
		return eAttributeMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAttributeMapping_Source() {
		return (EReference)eAttributeMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAttributeMapping_Target() {
		return (EReference)eAttributeMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEReferenceMapping() {
		return eReferenceMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReferenceMapping_Source() {
		return (EReference)eReferenceMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReferenceMapping_Target() {
		return (EReference)eReferenceMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEEnumMapping() {
		return eEnumMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEnumMapping_Source() {
		return (EReference)eEnumMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEnumMapping_Target() {
		return (EReference)eEnumMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEnumMapping_EEnumLiteralMappings() {
		return (EReference)eEnumMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEEnumLiteralMapping() {
		return eEnumLiteralMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEnumLiteralMapping_Source() {
		return (EReference)eEnumLiteralMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEnumLiteralMapping_Target() {
		return (EReference)eEnumLiteralMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDataTypeMapping() {
		return eDataTypeMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDataTypeMapping_Source() {
		return (EReference)eDataTypeMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDataTypeMapping_Target() {
		return (EReference)eDataTypeMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GummecoreFactory getGummecoreFactory() {
		return (GummecoreFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		ecoreAlignmentEClass = createEClass(ECORE_ALIGNMENT);
		createEReference(ecoreAlignmentEClass, ECORE_ALIGNMENT__ECLASS_MAPPINGS);
		createEReference(ecoreAlignmentEClass, ECORE_ALIGNMENT__EENUM_MAPPINGS);
		createEReference(ecoreAlignmentEClass, ECORE_ALIGNMENT__EDATA_TYPE_MAPPINGS);

		eClassMappingEClass = createEClass(ECLASS_MAPPING);
		createEReference(eClassMappingEClass, ECLASS_MAPPING__SOURCE);
		createEReference(eClassMappingEClass, ECLASS_MAPPING__TARGET);
		createEReference(eClassMappingEClass, ECLASS_MAPPING__EATTRIBUTE_MAPPINGS);
		createEReference(eClassMappingEClass, ECLASS_MAPPING__EREFERENCE_MAPPINGS);

		eAttributeMappingEClass = createEClass(EATTRIBUTE_MAPPING);
		createEReference(eAttributeMappingEClass, EATTRIBUTE_MAPPING__SOURCE);
		createEReference(eAttributeMappingEClass, EATTRIBUTE_MAPPING__TARGET);

		eReferenceMappingEClass = createEClass(EREFERENCE_MAPPING);
		createEReference(eReferenceMappingEClass, EREFERENCE_MAPPING__SOURCE);
		createEReference(eReferenceMappingEClass, EREFERENCE_MAPPING__TARGET);

		eEnumMappingEClass = createEClass(EENUM_MAPPING);
		createEReference(eEnumMappingEClass, EENUM_MAPPING__SOURCE);
		createEReference(eEnumMappingEClass, EENUM_MAPPING__TARGET);
		createEReference(eEnumMappingEClass, EENUM_MAPPING__EENUM_LITERAL_MAPPINGS);

		eEnumLiteralMappingEClass = createEClass(EENUM_LITERAL_MAPPING);
		createEReference(eEnumLiteralMappingEClass, EENUM_LITERAL_MAPPING__SOURCE);
		createEReference(eEnumLiteralMappingEClass, EENUM_LITERAL_MAPPING__TARGET);

		eDataTypeMappingEClass = createEClass(EDATA_TYPE_MAPPING);
		createEReference(eDataTypeMappingEClass, EDATA_TYPE_MAPPING__SOURCE);
		createEReference(eDataTypeMappingEClass, EDATA_TYPE_MAPPING__TARGET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(ecoreAlignmentEClass, EcoreAlignment.class, "EcoreAlignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEcoreAlignment_EClassMappings(), this.getEClassMapping(), null, "eClassMappings", null, 0, -1, EcoreAlignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcoreAlignment_EEnumMappings(), this.getEEnumMapping(), null, "eEnumMappings", null, 0, -1, EcoreAlignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcoreAlignment_EDataTypeMappings(), this.getEDataTypeMapping(), null, "eDataTypeMappings", null, 0, -1, EcoreAlignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eClassMappingEClass, EClassMapping.class, "EClassMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEClassMapping_Source(), theEcorePackage.getEClass(), null, "source", null, 1, 1, EClassMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassMapping_Target(), theEcorePackage.getEClass(), null, "target", null, 1, 1, EClassMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassMapping_EAttributeMappings(), this.getEAttributeMapping(), null, "eAttributeMappings", null, 0, -1, EClassMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEClassMapping_EReferenceMappings(), this.getEReferenceMapping(), null, "eReferenceMappings", null, 0, -1, EClassMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAttributeMappingEClass, EAttributeMapping.class, "EAttributeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAttributeMapping_Source(), theEcorePackage.getEAttribute(), null, "source", null, 1, 1, EAttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAttributeMapping_Target(), theEcorePackage.getEAttribute(), null, "target", null, 1, 1, EAttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eReferenceMappingEClass, EReferenceMapping.class, "EReferenceMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEReferenceMapping_Source(), theEcorePackage.getEReference(), null, "source", null, 1, 1, EReferenceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEReferenceMapping_Target(), theEcorePackage.getEReference(), null, "target", null, 1, 1, EReferenceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eEnumMappingEClass, EEnumMapping.class, "EEnumMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEEnumMapping_Source(), theEcorePackage.getEEnum(), null, "source", null, 1, 1, EEnumMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEnumMapping_Target(), theEcorePackage.getEEnum(), null, "target", null, 1, 1, EEnumMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEnumMapping_EEnumLiteralMappings(), this.getEEnumLiteralMapping(), null, "eEnumLiteralMappings", null, 0, -1, EEnumMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eEnumLiteralMappingEClass, EEnumLiteralMapping.class, "EEnumLiteralMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEEnumLiteralMapping_Source(), theEcorePackage.getEEnumLiteral(), null, "source", null, 1, 1, EEnumLiteralMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEnumLiteralMapping_Target(), theEcorePackage.getEEnumLiteral(), null, "target", null, 1, 1, EEnumLiteralMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDataTypeMappingEClass, EDataTypeMapping.class, "EDataTypeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDataTypeMapping_Source(), theEcorePackage.getEDataType(), null, "source", null, 1, 1, EDataTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEDataTypeMapping_Target(), theEcorePackage.getEDataType(), null, "target", null, 1, 1, EDataTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GummecorePackageImpl
