package fr.lirmm.gumm.plugins.ecore.importers;

import java.io.IOException;
import java.util.Iterator;

import com.googlecode.gumm.viz.GraphToDot;
import org.eclipse.emf.ecore.*;

import com.googlecode.gumm.graph.*;

public class BasicEcoreImporter extends EcoreImporter {

	public static void main(String[] args) throws IOException {
		BasicEcoreImporter i = new BasicEcoreImporter((EPackage) loadMetamodel(args[0]).getContents().get(0));
		ModelGraph g = i.getGraph();
		GraphToDot doter = new GraphToDot(g);
		doter.toFile("tmp/graph.dot");
	}

	public BasicEcoreImporter(String path) {
		this((EPackage) loadMetamodel(path).getContents().get(0));
	}

	public BasicEcoreImporter(EPackage model) {
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

		String elementID = "#" + qualifiedName(ne);
		String elementLabel = ne.getName();

		LabeledNode elementLabelNode;
		if ( nameNodes.get(elementLabel) != null )
			elementLabelNode = nameNodes.get(elementLabel);
		else {
			elementLabelNode = graph.createValueNode(elementLabel, ValueNode.TYPE_STRING);
			nameNodes.put(elementLabel, elementLabelNode);
		}


		LabeledNode n = graph.createValueNode(elementID, ValueNode.TYPE_STRING); //FIXME: maybe object node?

		graph.createEdge(n,elementLabelNode,"label");

		eltNodes.put(ne, n);

		return n;
	}

}
