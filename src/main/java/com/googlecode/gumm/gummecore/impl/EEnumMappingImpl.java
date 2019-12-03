/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.googlecode.gumm.gummecore.impl;

import com.googlecode.gumm.gummecore.EEnumLiteralMapping;
import com.googlecode.gumm.gummecore.EEnumMapping;
import com.googlecode.gumm.gummecore.GummecorePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EEnum Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.googlecode.gumm.gummecore.impl.EEnumMappingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.googlecode.gumm.gummecore.impl.EEnumMappingImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.googlecode.gumm.gummecore.impl.EEnumMappingImpl#getEEnumLiteralMappings <em>EEnum Literal Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EEnumMappingImpl extends EObjectImpl implements EEnumMapping {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EEnum source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EEnum target;

	/**
	 * The cached value of the '{@link #getEEnumLiteralMappings() <em>EEnum Literal Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEEnumLiteralMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<EEnumLiteralMapping> eEnumLiteralMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EEnumMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GummecorePackage.Literals.EENUM_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (EEnum)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GummecorePackage.EENUM_MAPPING__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(EEnum newSource) {
		EEnum oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GummecorePackage.EENUM_MAPPING__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (EEnum)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GummecorePackage.EENUM_MAPPING__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EEnum newTarget) {
		EEnum oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GummecorePackage.EENUM_MAPPING__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EEnumLiteralMapping> getEEnumLiteralMappings() {
		if (eEnumLiteralMappings == null) {
			eEnumLiteralMappings = new EObjectContainmentEList<EEnumLiteralMapping>(EEnumLiteralMapping.class, this, GummecorePackage.EENUM_MAPPING__EENUM_LITERAL_MAPPINGS);
		}
		return eEnumLiteralMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GummecorePackage.EENUM_MAPPING__EENUM_LITERAL_MAPPINGS:
				return ((InternalEList<?>)getEEnumLiteralMappings()).basicRemove(otherEnd, msgs);
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
			case GummecorePackage.EENUM_MAPPING__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case GummecorePackage.EENUM_MAPPING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case GummecorePackage.EENUM_MAPPING__EENUM_LITERAL_MAPPINGS:
				return getEEnumLiteralMappings();
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
			case GummecorePackage.EENUM_MAPPING__SOURCE:
				setSource((EEnum)newValue);
				return;
			case GummecorePackage.EENUM_MAPPING__TARGET:
				setTarget((EEnum)newValue);
				return;
			case GummecorePackage.EENUM_MAPPING__EENUM_LITERAL_MAPPINGS:
				getEEnumLiteralMappings().clear();
				getEEnumLiteralMappings().addAll((Collection<? extends EEnumLiteralMapping>)newValue);
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
			case GummecorePackage.EENUM_MAPPING__SOURCE:
				setSource((EEnum)null);
				return;
			case GummecorePackage.EENUM_MAPPING__TARGET:
				setTarget((EEnum)null);
				return;
			case GummecorePackage.EENUM_MAPPING__EENUM_LITERAL_MAPPINGS:
				getEEnumLiteralMappings().clear();
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
			case GummecorePackage.EENUM_MAPPING__SOURCE:
				return source != null;
			case GummecorePackage.EENUM_MAPPING__TARGET:
				return target != null;
			case GummecorePackage.EENUM_MAPPING__EENUM_LITERAL_MAPPINGS:
				return eEnumLiteralMappings != null && !eEnumLiteralMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EEnumMappingImpl
