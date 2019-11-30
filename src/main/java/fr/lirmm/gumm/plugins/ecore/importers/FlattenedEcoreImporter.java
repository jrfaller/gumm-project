package fr.lirmm.gumm.plugins.ecore.importers;

import java.io.IOException;
import java.util.Iterator;

import com.googlecode.gumm.viz.GraphToDot;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;

import com.googlecode.gumm.graph.*;

public class FlattenedEcoreImporter extends EcoreImporter {

	public static void main(String[] args) throws IOException {
		FlattenedEcoreImporter i = new FlattenedEcoreImporter((EPackage) loadMetamodel(args[0]).getContents().get(0));
		ModelGraph g = i.getGraph();
		GraphToDot dot = new GraphToDot(g);
		dot.toFile("tmp/graph.dot");
	}

	public FlattenedEcoreImporter(String path) {
		this((EPackage) loadMetamodel(path).getContents().get(0));
	}

	public FlattenedEcoreImporter(EPackage model) {
		this.model = model;
		graph = new ModelGraph();
		trueNode = graph.createValueNode("true", ValueNode.TYPE_STRING);
		falseNode = graph.createValueNode("false", ValueNode.TYPE_STRING);
		node0 = graph.createValueNode("0", ValueNode.TYPE_STRING);
		node1 = graph.createValueNode("1", ValueNode.TYPE_STRING);
		nodeN = graph.createValueNode("n", ValueNode.TYPE_STRING);
		attrNode = graph.createValueNode("AttributeElement", ValueNode.TYPE_STRING);
		refNode = graph.createValueNode("ReferenceElement", ValueNode.TYPE_STRING);
		classNode = graph.createValueNode("ClassElement", ValueNode.TYPE_STRING);
		dtNode = graph.createValueNode("DataTypeElement", ValueNode.TYPE_STRING);
		enmNode = graph.createValueNode("EnumElement", ValueNode.TYPE_STRING);
		enmLitNode = graph.createValueNode("EnumLiteralElement", ValueNode.TYPE_STRING);
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

		graph.createEdge(n, enmNode, "kind");

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

		graph.createEdge(n, enmLitNode, "kind");

		return n;	
	}

	public LabeledNode dumpEClass(EClass cls) {
		if ( eltNodes.get(cls) != null )
			return eltNodes.get(cls);

		if ( cls.isAbstract() == true )
			return null;

		LabeledNode n = dumpENamedElement(cls);
		eltNodes.put(cls,n);

		graph.createEdge(n,classNode,"kind");

		for( EStructuralFeature sf: cls.getEAllStructuralFeatures() ) {
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

		graph.createEdge(n,attrNode,"kind");

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

		graph.createEdge(n,refNode,"kind");

		if ( ref.isContainment() )
			graph.createEdge(n,trueNode,"containment");
		else
			graph.createEdge(n, falseNode,"containment");

		EClass type = ref.getEReferenceType();
		if ( type.isAbstract() == false )
			graph.createEdge(n,dumpEClass(type), "type");
		else
			for(EClass leafClass: leafClasses(type) )
				graph.createEdge(n,dumpEClass(leafClass), "type");


		return n;
	}

	public LabeledNode dumpEStructuralFeature(EStructuralFeature sf) {
		if ( eltNodes.get(sf) != null)
			return eltNodes.get(sf);

		LabeledNode n = dumpENamedElement(sf);
		eltNodes.put(sf, n);

		if ( sf.getUpperBound() == 0 )
			graph.createEdge(n,node0,"upper");
		else if ( sf.getUpperBound() == 1 )
			graph.createEdge(n,node1,"upper");
		else if ( sf.getUpperBound() == -1 )
			graph.createEdge(n,nodeN,"upper");

		if ( sf.getLowerBound() == 0 )
			graph.createEdge(n,node0,"lower");
		else if ( sf.getLowerBound() == 1 )
			graph.createEdge(n,node1,"lower");
		else if ( sf.getLowerBound() == -1 )
			graph.createEdge(n,nodeN,"lower");	

		return n;
	}

	public LabeledNode dumpEDataType(EDataType dt) {
		if (  eltNodes.get(dt) != null )
			return eltNodes.get(dt);

		LabeledNode n = dumpENamedElement(dt);
		eltNodes.put(dt,n);
		graph.createEdge(n,dtNode,"kind");

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

	public EList<EClass> leafClasses(EClass cls) {
		EList<EClass> lClasses = new BasicEList<EClass>();
		Iterator<EObject> it = model.eAllContents();
		while(it.hasNext()) {
			EObject o = it.next();
			if ( o instanceof EClass ) {
				EClass tCls = (EClass) o;
				if ( cls.isSuperTypeOf(tCls) && tCls.isAbstract() == false )
					lClasses.add(tCls);
			}
		}

		return lClasses;
	}

}
