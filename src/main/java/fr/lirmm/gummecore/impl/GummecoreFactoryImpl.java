/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lirmm.gummecore.impl;

import fr.lirmm.gummecore.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GummecoreFactoryImpl extends EFactoryImpl implements GummecoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GummecoreFactory init() {
		try {
			GummecoreFactory theGummecoreFactory = (GummecoreFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.lirmm.fr/gumm/1.0.0/gummecore.ecore"); 
			if (theGummecoreFactory != null) {
				return theGummecoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GummecoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GummecoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GummecorePackage.ECORE_ALIGNMENT: return createEcoreAlignment();
			case GummecorePackage.ECLASS_MAPPING: return createEClassMapping();
			case GummecorePackage.EATTRIBUTE_MAPPING: return createEAttributeMapping();
			case GummecorePackage.EREFERENCE_MAPPING: return createEReferenceMapping();
			case GummecorePackage.EENUM_MAPPING: return createEEnumMapping();
			case GummecorePackage.EENUM_LITERAL_MAPPING: return createEEnumLiteralMapping();
			case GummecorePackage.EDATA_TYPE_MAPPING: return createEDataTypeMapping();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreAlignment createEcoreAlignment() {
		EcoreAlignmentImpl ecoreAlignment = new EcoreAlignmentImpl();
		return ecoreAlignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassMapping createEClassMapping() {
		EClassMappingImpl eClassMapping = new EClassMappingImpl();
		return eClassMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttributeMapping createEAttributeMapping() {
		EAttributeMappingImpl eAttributeMapping = new EAttributeMappingImpl();
		return eAttributeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReferenceMapping createEReferenceMapping() {
		EReferenceMappingImpl eReferenceMapping = new EReferenceMappingImpl();
		return eReferenceMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumMapping createEEnumMapping() {
		EEnumMappingImpl eEnumMapping = new EEnumMappingImpl();
		return eEnumMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteralMapping createEEnumLiteralMapping() {
		EEnumLiteralMappingImpl eEnumLiteralMapping = new EEnumLiteralMappingImpl();
		return eEnumLiteralMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataTypeMapping createEDataTypeMapping() {
		EDataTypeMappingImpl eDataTypeMapping = new EDataTypeMappingImpl();
		return eDataTypeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GummecorePackage getGummecorePackage() {
		return (GummecorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GummecorePackage getPackage() {
		return GummecorePackage.eINSTANCE;
	}

} //GummecoreFactoryImpl
