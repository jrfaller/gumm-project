package com.googlecode.gumm.plugins.ecore.importers;

import java.io.IOException;
import java.util.Iterator;

import com.googlecode.gumm.graph.LabeledNode;
import com.googlecode.gumm.graph.ModelGraph;
import com.googlecode.gumm.graph.ValueNode;
import com.googlecode.gumm.viz.GraphToDot;
import org.eclipse.emf.ecore.*;

public class MinimalEcoreImporter extends EcoreImporter {

	public static void main(String[] args) throws IOException {
		MinimalEcoreImporter i = new MinimalEcoreImporter((EPackage) loadMetamodel(args[0]).getContents().get(0));
		ModelGraph g = i.getGraph();
		GraphToDot dot = new GraphToDot(g);
		dot.toFile("tmp/graph.dot");
	}

	public MinimalEcoreImporter(String path) {
		this((EPackage) loadMetamodel(path).getContents().get(0));
	}

	public MinimalEcoreImporter(EPackage model) {
		this.model = model;
		graph = new ModelGraph();
	}

	public ModelGraph getGraph() {
		Iterator<EObject> it = model.eAllContents();

		while(it.hasNext()) {
			EObject o = it.next();
			if ( o instanceof EClass )
				dumpEClass((EClass)o);
			else if ( o instanceof EEnum )
				dumpEEnum((EEnum) o);
			else if ( o instanceof EDataType )
				dumpEDataType((EDataType) o);
		}

		return graph;
	}
	
	public LabeledNode dumpEEnum(EEnum enm) {
		if ( eltNodes.get(enm) != null )
			return eltNodes.get(enm);
		
		LabeledNode n = dumpENamedElement(enm);
		eltNodes.put(enm,n);
		
		for( EEnumLiteral lit: enm.getELiterals() ) {
			graph.createEdge(n, dumpEEnumLiteral(lit), "literal");
		}
		
		return n;
	}
	
	public LabeledNode dumpEEnumLiteral(EEnumLiteral lit) {
		if ( eltNodes.get(lit) != null )
			return eltNodes.get(lit);
		
		LabeledNode n = dumpENamedElement(lit);
		eltNodes.put(lit, n);
		
		return n;	
	}

	public LabeledNode dumpEClass(EClass cls) {
		if ( eltNodes.get(cls) != null )
			return eltNodes.get(cls);

		LabeledNode n = dumpENamedElement(cls);
		eltNodes.put(cls,n);
		
		for( EClass scls: cls.getESuperTypes() )
			graph.createEdge(n, dumpEClass(scls), "supertype");
		
		for( EStructuralFeature sf: cls.getEStructuralFeatures() ) {
			if ( sf.isDerived() == false ) {
				if ( sf instanceof EAttribute )
					graph.createEdge(n,dumpEAttribute((EAttribute) sf),"own");
				else if ( sf instanceof EReference )
					graph.createEdge(n,dumpEReference((EReference) sf),"ref");
			}
		}

		return n;
	}

	public LabeledNode dumpEAttribute(EAttribute attr) {
		if ( eltNodes.get(attr) != null)
			return eltNodes.get(attr);

		LabeledNode n = dumpEStructuralFeature(attr);
		eltNodes.put(attr,n);
		
		EDataType dtype = attr.getEAttributeType();
		LabeledNode dtypeNode;
		if ( dtype instanceof EEnum )
			dtypeNode = dumpEEnum((EEnum)dtype);
		else
			dtypeNode = dumpEDataType(dtype);
		
		graph.createEdge(n,dtypeNode,"datatype");

		return n;
	}

	public LabeledNode dumpEReference(EReference ref) {
		if ( eltNodes.get(ref) != null)
			return eltNodes.get(ref);

		LabeledNode n = dumpEStructuralFeature(ref);
		eltNodes.put(ref,n);
		
		graph.createEdge(n,dumpEClass(ref.getEReferenceType()), "type");

		return n;
	}
	
	public LabeledNode dumpEStructuralFeature(EStructuralFeature sf) {
		if ( eltNodes.get(sf) != null)
			return eltNodes.get(sf);
		
		LabeledNode n = dumpENamedElement(sf);
		eltNodes.put(sf, n);
			
		return n;
	}

	public LabeledNode dumpEDataType(EDataType dt) {
		if (  eltNodes.get(dt) != null )
			return eltNodes.get(dt);

		LabeledNode n = dumpENamedElement(dt);
		eltNodes.put(dt,n);

		return n;
	}
	
	public LabeledNode dumpENamedElement(ENamedElement ne) {
		if ( eltNodes.get(ne) != null )
			return eltNodes.get(ne);

		LabeledNode n = graph.createValueNode(ne.getName(), ValueNode.TYPE_STRING); // FIXME: maybe an object node?

		eltNodes.put(ne, n);
		
		return n;
	}

}
