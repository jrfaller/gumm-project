/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.googlecode.gumm.gummecore.impl;

import com.googlecode.gumm.gummecore.EAttributeMapping;
import com.googlecode.gumm.gummecore.EClassMapping;
import com.googlecode.gumm.gummecore.EReferenceMapping;
import com.googlecode.gumm.gummecore.GummecorePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EClass Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.googlecode.gumm.gummecore.impl.EClassMappingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.googlecode.gumm.gummecore.impl.EClassMappingImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.googlecode.gumm.gummecore.impl.EClassMappingImpl#getEAttributeMappings <em>EAttribute Mappings</em>}</li>
 *   <li>{@link com.googlecode.gumm.gummecore.impl.EClassMappingImpl#getEReferenceMappings <em>EReference Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EClassMappingImpl extends EObjectImpl implements EClassMapping {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EClass source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EClass target;

	/**
	 * The cached value of the '{@link #getEAttributeMappings() <em>EAttribute Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEAttributeMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<EAttributeMapping> eAttributeMappings;

	/**
	 * The cached value of the '{@link #getEReferenceMappings() <em>EReference Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReferenceMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<EReferenceMapping> eReferenceMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClassMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GummecorePackage.Literals.ECLASS_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (EClass)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GummecorePackage.ECLASS_MAPPING__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(EClass newSource) {
		EClass oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GummecorePackage.ECLASS_MAPPING__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (EClass)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GummecorePackage.ECLASS_MAPPING__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EClass newTarget) {
		EClass oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GummecorePackage.ECLASS_MAPPING__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAttributeMapping> getEAttributeMappings() {
		if (eAttributeMappings == null) {
			eAttributeMappings = new EObjectContainmentEList<EAttributeMapping>(EAttributeMapping.class, this, GummecorePackage.ECLASS_MAPPING__EATTRIBUTE_MAPPINGS);
		}
		return eAttributeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReferenceMapping> getEReferenceMappings() {
		if (eReferenceMappings == null) {
			eReferenceMappings = new EObjectContainmentEList<EReferenceMapping>(EReferenceMapping.class, this, GummecorePackage.ECLASS_MAPPING__EREFERENCE_MAPPINGS);
		}
		return eReferenceMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GummecorePackage.ECLASS_MAPPING__EATTRIBUTE_MAPPINGS:
				return ((InternalEList<?>)getEAttributeMappings()).basicRemove(otherEnd, msgs);
			case GummecorePackage.ECLASS_MAPPING__EREFERENCE_MAPPINGS:
				return ((InternalEList<?>)getEReferenceMappings()).basicRemove(otherEnd, msgs);
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
			case GummecorePackage.ECLASS_MAPPING__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case GummecorePackage.ECLASS_MAPPING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case GummecorePackage.ECLASS_MAPPING__EATTRIBUTE_MAPPINGS:
				return getEAttributeMappings();
			case GummecorePackage.ECLASS_MAPPING__EREFERENCE_MAPPINGS:
				return getEReferenceMappings();
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
			case GummecorePackage.ECLASS_MAPPING__SOURCE:
				setSource((EClass)newValue);
				return;
			case GummecorePackage.ECLASS_MAPPING__TARGET:
				setTarget((EClass)newValue);
				return;
			case GummecorePackage.ECLASS_MAPPING__EATTRIBUTE_MAPPINGS:
				getEAttributeMappings().clear();
				getEAttributeMappings().addAll((Collection<? extends EAttributeMapping>)newValue);
				return;
			case GummecorePackage.ECLASS_MAPPING__EREFERENCE_MAPPINGS:
				getEReferenceMappings().clear();
				getEReferenceMappings().addAll((Collection<? extends EReferenceMapping>)newValue);
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
			case GummecorePackage.ECLASS_MAPPING__SOURCE:
				setSource((EClass)null);
				return;
			case GummecorePackage.ECLASS_MAPPING__TARGET:
				setTarget((EClass)null);
				return;
			case GummecorePackage.ECLASS_MAPPING__EATTRIBUTE_MAPPINGS:
				getEAttributeMappings().clear();
				return;
			case GummecorePackage.ECLASS_MAPPING__EREFERENCE_MAPPINGS:
				getEReferenceMappings().clear();
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
			case GummecorePackage.ECLASS_MAPPING__SOURCE:
				return source != null;
			case GummecorePackage.ECLASS_MAPPING__TARGET:
				return target != null;
			case GummecorePackage.ECLASS_MAPPING__EATTRIBUTE_MAPPINGS:
				return eAttributeMappings != null && !eAttributeMappings.isEmpty();
			case GummecorePackage.ECLASS_MAPPING__EREFERENCE_MAPPINGS:
				return eReferenceMappings != null && !eReferenceMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EClassMappingImpl
