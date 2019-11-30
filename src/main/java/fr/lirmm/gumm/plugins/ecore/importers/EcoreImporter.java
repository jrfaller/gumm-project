package fr.lirmm.gumm.plugins.ecore.importers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.googlecode.gumm.graph.ModelGraph;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import com.googlecode.gumm.graph.*;

public abstract class EcoreImporter implements GraphImporter {
	
	protected ModelGraph graph;
	
	protected EPackage model;
	
	protected LabeledNode classNode;
	
	protected LabeledNode attrNode;
	
	protected LabeledNode refNode;
	
	protected LabeledNode dtNode;
	
	protected LabeledNode enmNode;
	
	protected LabeledNode enmLitNode;
	
	protected LabeledNode trueNode;
	
	protected LabeledNode falseNode;
	
	protected LabeledNode node0;
	
	protected LabeledNode node1;
	
	protected LabeledNode nodeN;
	
	protected Map<EObject,LabeledNode> eltNodes = new HashMap<EObject, LabeledNode>();
	
	protected Map<String,LabeledNode> nameNodes = new HashMap<String, LabeledNode>();
	
	public String getInputFormat() {
		return "Ecore";
	}
	
	public static Resource loadMetamodel(String metamodelPath) {
		ResourceSet metamodelSet = new ResourceSetImpl();
		metamodelSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new EcoreResourceFactoryImpl());
		URI metamodelURI = URI.createFileURI(new File(metamodelPath).getAbsolutePath());
		return metamodelSet.getResource(metamodelURI, true);
	}
	
	public String qualifiedName(ENamedElement ne) {
		String s = ne.getName();
		while( ne.eContainer() != null ) {
			ne = (ENamedElement) ne.eContainer();
			s = ne.getName() + "::" + s; 
		}
		return s;
	}
	
	public Map<LabeledNode,EObject> getEnvironment() {
		Map<LabeledNode,EObject> environment = new HashMap<LabeledNode, EObject>();
		for(Entry<EObject, LabeledNode> entry: eltNodes.entrySet() )
			environment.put(entry.getValue(),entry.getKey());
		
		return environment;
	}
}
