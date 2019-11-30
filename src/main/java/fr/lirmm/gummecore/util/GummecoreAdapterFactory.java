/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lirmm.gummecore.util;

import fr.lirmm.gummecore.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.lirmm.gummecore.GummecorePackage
 * @generated
 */
public class GummecoreAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GummecorePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GummecoreAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GummecorePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GummecoreSwitch<Adapter> modelSwitch =
		new GummecoreSwitch<Adapter>() {
			@Override
			public Adapter caseEcoreAlignment(EcoreAlignment object) {
				return createEcoreAlignmentAdapter();
			}
			@Override
			public Adapter caseEClassMapping(EClassMapping object) {
				return createEClassMappingAdapter();
			}
			@Override
			public Adapter caseEAttributeMapping(EAttributeMapping object) {
				return createEAttributeMappingAdapter();
			}
			@Override
			public Adapter caseEReferenceMapping(EReferenceMapping object) {
				return createEReferenceMappingAdapter();
			}
			@Override
			public Adapter caseEEnumMapping(EEnumMapping object) {
				return createEEnumMappingAdapter();
			}
			@Override
			public Adapter caseEEnumLiteralMapping(EEnumLiteralMapping object) {
				return createEEnumLiteralMappingAdapter();
			}
			@Override
			public Adapter caseEDataTypeMapping(EDataTypeMapping object) {
				return createEDataTypeMappingAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.lirmm.gummecore.EcoreAlignment <em>Ecore Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lirmm.gummecore.EcoreAlignment
	 * @generated
	 */
	public Adapter createEcoreAlignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lirmm.gummecore.EClassMapping <em>EClass Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lirmm.gummecore.EClassMapping
	 * @generated
	 */
	public Adapter createEClassMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lirmm.gummecore.EAttributeMapping <em>EAttribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lirmm.gummecore.EAttributeMapping
	 * @generated
	 */
	public Adapter createEAttributeMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lirmm.gummecore.EReferenceMapping <em>EReference Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lirmm.gummecore.EReferenceMapping
	 * @generated
	 */
	public Adapter createEReferenceMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lirmm.gummecore.EEnumMapping <em>EEnum Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lirmm.gummecore.EEnumMapping
	 * @generated
	 */
	public Adapter createEEnumMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lirmm.gummecore.EEnumLiteralMapping <em>EEnum Literal Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lirmm.gummecore.EEnumLiteralMapping
	 * @generated
	 */
	public Adapter createEEnumLiteralMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.lirmm.gummecore.EDataTypeMapping <em>EData Type Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.lirmm.gummecore.EDataTypeMapping
	 * @generated
	 */
	public Adapter createEDataTypeMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GummecoreAdapterFactory
