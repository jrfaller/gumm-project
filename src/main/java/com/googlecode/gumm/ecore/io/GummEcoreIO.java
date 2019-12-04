package com.googlecode.gumm.ecore.io;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.googlecode.gumm.ecore.GummecorePackage;

public class GummEcoreIO {
	
	public static EObject fromXMI(String path) {
		ResourceSet resourceSet = getGalateaResourceSet();
		URI uri = URI.createFileURI(new File(path).getAbsolutePath());
		Resource resource = resourceSet.getResource(uri, true);
		return ((EObject) resource.getContents().get(0));
	}
	
	public static void toXMI(EObject object,String path) {
		ResourceSet resourceSet = getGalateaResourceSet();
		URI uri = URI.createFileURI(new File(path).getAbsolutePath());
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(object);
		try {
			resource.save(null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ResourceSet getGalateaResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(GummecorePackage.eNS_URI,GummecorePackage.eINSTANCE);
		return resourceSet;
	}
}
