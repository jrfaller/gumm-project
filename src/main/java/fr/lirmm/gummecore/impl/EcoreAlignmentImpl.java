/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.lirmm.gummecore.impl;

import fr.lirmm.gummecore.EClassMapping;
import fr.lirmm.gummecore.EDataTypeMapping;
import fr.lirmm.gummecore.EEnumMapping;
import fr.lirmm.gummecore.EcoreAlignment;
import fr.lirmm.gummecore.GummecorePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecore Alignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.lirmm.gummecore.impl.EcoreAlignmentImpl#getEClassMappings <em>EClass Mappings</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.impl.EcoreAlignmentImpl#getEEnumMappings <em>EEnum Mappings</em>}</li>
 *   <li>{@link fr.lirmm.gummecore.impl.EcoreAlignmentImpl#getEDataTypeMappings <em>EData Type Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EcoreAlignmentImpl extends EObjectImpl implements EcoreAlignment {
	/**
	 * The cached value of the '{@link #getEClassMappings() <em>EClass Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<EClassMapping> eClassMappings;

	/**
	 * The cached value of the '{@link #getEEnumMappings() <em>EEnum Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEEnumMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<EEnumMapping> eEnumMappings;

	/**
	 * The cached value of the '{@link #getEDataTypeMappings() <em>EData Type Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDataTypeMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<EDataTypeMapping> eDataTypeMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreAlignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GummecorePackage.Literals.ECORE_ALIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClassMapping> getEClassMappings() {
		if (eClassMappings == null) {
			eClassMappings = new EObjectContainmentEList<EClassMapping>(EClassMapping.class, this, GummecorePackage.ECORE_ALIGNMENT__ECLASS_MAPPINGS);
		}
		return eClassMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EEnumMapping> getEEnumMappings() {
		if (eEnumMappings == null) {
			eEnumMappings = new EObjectContainmentEList<EEnumMapping>(EEnumMapping.class, this, GummecorePackage.ECORE_ALIGNMENT__EENUM_MAPPINGS);
		}
		return eEnumMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDataTypeMapping> getEDataTypeMappings() {
		if (eDataTypeMappings == null) {
			eDataTypeMappings = new EObjectContainmentEList<EDataTypeMapping>(EDataTypeMapping.class, this, GummecorePackage.ECORE_ALIGNMENT__EDATA_TYPE_MAPPINGS);
		}
		return eDataTypeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GummecorePackage.ECORE_ALIGNMENT__ECLASS_MAPPINGS:
				return ((InternalEList<?>)getEClassMappings()).basicRemove(otherEnd, msgs);
			case GummecorePackage.ECORE_ALIGNMENT__EENUM_MAPPINGS:
				return ((InternalEList<?>)getEEnumMappings()).basicRemove(otherEnd, msgs);
			case GummecorePackage.ECORE_ALIGNMENT__EDATA_TYPE_MAPPINGS:
				return ((InternalEList<?>)getEDataTypeMappings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GummecorePackage.ECORE_ALIGNMENT__ECLASS_MAPPINGS:
				return getEClassMappings();
			case GummecorePackage.ECORE_ALIGNMENT__EENUM_MAPPINGS:
				return getEEnumMappings();
			case GummecorePackage.ECORE_ALIGNMENT__EDATA_TYPE_MAPPINGS:
				return getEDataTypeMappings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GummecorePackage.ECORE_ALIGNMENT__ECLASS_MAPPINGS:
				getEClassMappings().clear();
				getEClassMappings().addAll((Collection<? extends EClassMapping>)newValue);
				return;
			case GummecorePackage.ECORE_ALIGNMENT__EENUM_MAPPINGS:
				getEEnumMappings().clear();
				getEEnumMappings().addAll((Collection<? extends EEnumMapping>)newValue);
				return;
			case GummecorePackage.ECORE_ALIGNMENT__EDATA_TYPE_MAPPINGS:
				getEDataTypeMappings().clear();
				getEDataTypeMappings().addAll((Collection<? extends EDataTypeMapping>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GummecorePackage.ECORE_ALIGNMENT__ECLASS_MAPPINGS:
				getEClassMappings().clear();
				return;
			case GummecorePackage.ECORE_ALIGNMENT__EENUM_MAPPINGS:
				getEEnumMappings().clear();
				return;
			case GummecorePackage.ECORE_ALIGNMENT__EDATA_TYPE_MAPPINGS:
				getEDataTypeMappings().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GummecorePackage.ECORE_ALIGNMENT__ECLASS_MAPPINGS:
				return eClassMappings != null && !eClassMappings.isEmpty();
			case GummecorePackage.ECORE_ALIGNMENT__EENUM_MAPPINGS:
				return eEnumMappings != null && !eEnumMappings.isEmpty();
			case GummecorePackage.ECORE_ALIGNMENT__EDATA_TYPE_MAPPINGS:
				return eDataTypeMappings != null && !eDataTypeMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EcoreAlignmentImpl
