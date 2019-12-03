package com.googlecode.gumm.gummecore.framework.io.out;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import com.googlecode.gumm.gummecore.EClassMapping;
import com.googlecode.gumm.gummecore.EEnumMapping;
import com.googlecode.gumm.gummecore.EcoreAlignment;
import com.googlecode.gumm.gummecore.framework.io.GummEcoreIO;


public class EcoreAlignmentToDot {
	public List<String> nodeDefs;
	public List<String> relDefs;
	
	public List<Integer> hashCodes;
	
	public String outputFile;
	public EPackage mm1;
	public EPackage mm2;
	
	private static final String CLASS_NODE_PRELUDE = " [shape=record,";
	private static final String ABSTRACT_CLASS_NODE_PRELUDE = " [shape=record,style=filled,fillcolor=\".1 1.0 1.0\",";
	private static final String ENUM_PRELUDE = " [shape=record,style=filled,fillcolor=\".6 .8 1.0\",";
	private static final String REFERENCE_PRELUDE = " [color=red,arrowtail=none,arrowhead=normal,";
	private static final String AGGREGATION_PRELUDE = " [color=red,arrowtail=diamond,arrowhead=none,";
	private static final String MAPPING_PRELUDE = " [color=green,arrowtail=normal,arrowhead=normal]";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EcoreAlignmentToDot dot = new EcoreAlignmentToDot((EcoreAlignment) GummEcoreIO.fromXMI(args[0]),args[1]);
		try {
			dot.toDotFile();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public EcoreAlignmentToDot(EcoreAlignment alignment,String outputFile) {
		mm1 = (EPackage) alignment.getEClassMappings().get(0).getSource().eContainer();
		mm2 = (EPackage) alignment.getEClassMappings().get(0).getTarget().eContainer();
		System.out.println(mm1.getName());System.out.println(mm2.getName());
		nodeDefs = new ArrayList<String>();
		relDefs = new ArrayList<String>();
		hashCodes = new ArrayList<Integer>();
		this.outputFile = outputFile;
		drawEPackage(mm1);
		drawEPackage(mm2);
		drawEcoreAlignment(alignment);
	}
	
	private String header() {
		return "digraph G {\n rankdir=BT;\n";
	}

	private String footer() {
		return "}";
	}
	
	private void drawEcoreAlignment(EcoreAlignment alignment) {
		for( EClassMapping clm: alignment.getEClassMappings() )
			relDefs.add(clm.getSource().hashCode() + " -> " + clm.getTarget().hashCode() + MAPPING_PRELUDE);
		for( EEnumMapping enm: alignment.getEEnumMappings() )
			relDefs.add(enm.getSource().hashCode() + " -> " + enm.getTarget().hashCode() + MAPPING_PRELUDE);
	}
	
	public String toDot() {
		String dot = header();
		for(String nodeDef: nodeDefs) {
			dot += nodeDef + "\n";
		}
		for(String relDef: relDefs) {
			dot += relDef + "\n";
		}
		dot += footer();
		return dot;
	}
	
	private void toDotFile(String output) throws IOException {
		FileWriter fw = new FileWriter(output);
		fw.append(toDot());
		fw.close();
	}
	
	public void toDotFile() throws IOException {
		toDotFile(outputFile);
	}
	
	private void drawEPackage(EPackage p) {
		nodeDefs.add("subgraph cluster_" + p.hashCode() + " {\n");
		nodeDefs.add("label=\"" + p.getName() + "\";\n");
		for ( EClassifier clsf : p.getEClassifiers() ) {
			if(clsf instanceof EClass )
				drawEClass((EClass)clsf);
			if ( clsf instanceof EEnum )
				drawEEnum((EEnum)clsf);
		}
		for ( EPackage sp : p.getESubpackages() )
			drawEPackage(sp);
		nodeDefs.add("}\n");
	}
	
	private void drawEEnum(EEnum enm) {
		if ( hashCodes.contains(enm.hashCode()))
			return;
		
		String nodeDef = Integer.toString(enm.hashCode()) + ENUM_PRELUDE;
		nodeDef += "label=\"{" + enm.getName() + "|";
		for(EEnumLiteral lit: enm.getELiterals() ) {
			nodeDef += lit.getLiteral() + "\\n";
		}
		nodeDef += "}\"];";
		nodeDefs.add(nodeDef);
	}
	
private void drawEClass(EClass cls) {
		if ( hashCodes.contains(cls.hashCode()))
			return;
		
		hashCodes.add(cls.hashCode());
		
		String nodeDef = Integer.toString(cls.hashCode());
		
		if( !cls.isAbstract() )
			nodeDef += CLASS_NODE_PRELUDE;
		else
			nodeDef += ABSTRACT_CLASS_NODE_PRELUDE;
		
		nodeDef += "label=\"{" + cls.getName() + "|";
		
		for(EStructuralFeature feature: cls.getEStructuralFeatures()) {
			
			EClassifier type = feature.getEType();
			if ( type!= null ) {
				if ( type instanceof EDataType && !(type instanceof EEnum) ) {
					nodeDef += feature.getName() + "[" + cardinality(feature) + "]";
					nodeDef += ": " + feature.getEType().getName();
					nodeDef += "\\n";
				}
				else if ( type instanceof EEnum ) {
					String relDef = Integer.toString(cls.hashCode()) + " -> " + Integer.toString(type.hashCode()) + AGGREGATION_PRELUDE + "headlabel=\"" + cardinality(feature) + "\",label=\""+ feature.getName() + "\"]";
					relDefs.add(relDef);
				}
				else if ( type instanceof EClass) {
					EReference ref = (EReference) feature;
					drawEClass((EClass) type);
					String relDef; 
					if ( ref.isContainment() )
						relDef = Integer.toString(cls.hashCode()) + " -> " + Integer.toString(type.hashCode()) + AGGREGATION_PRELUDE + "headlabel=\""+ cardinality(feature) + "\",label=\""+ feature.getName() + "\"]";
					else 
						relDef = Integer.toString(cls.hashCode()) + " -> " + Integer.toString(type.hashCode()) + REFERENCE_PRELUDE + "headlabel=\""+ cardinality(feature) + "\",label=\""+ feature.getName() + "\"]";
					relDefs.add(relDef);
				}
			}
		}
		nodeDef += "|";
		for(EOperation operation: cls.getEOperations() ) {
			nodeDef += operation.getName() + "(";
			for(EParameter param: operation.getEParameters() )
				nodeDef += param.getName() + ": " + param.getEType().getName() + ",";
			if ( operation.getEParameters().size() > 0 )
				nodeDef = nodeDef.substring(0, nodeDef.length() - 1);
			nodeDef += ")";
			if( operation.getEType() != null )
				nodeDef += ": " + operation.getEType().getName();
			nodeDef += "\\n";
		}
		nodeDef += "}\"];";
		nodeDefs.add(nodeDef);
		
		for(EClass supCls: cls.getESuperTypes() ) {
			drawEClass(supCls);
			String relDef = Integer.toString(cls.hashCode()) + " -> " + Integer.toString(supCls.hashCode());
			relDefs.add(relDef);
		}
	}
	
	private String cardinality(ETypedElement te) {
		String c = Integer.toString(te.getLowerBound());
		c += "..";
		if ( te.getUpperBound() == -1 )
			c += "*";
		else
			c += Integer.toString(te.getUpperBound());
		return c;
	}
	
	public static Resource loadMetamodel(String metamodelPath) {
		ResourceSet metamodelSet = new ResourceSetImpl();
		metamodelSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new EcoreResourceFactoryImpl());
		URI metamodelURI = URI.createFileURI(new File(metamodelPath).getAbsolutePath());
		return metamodelSet.getResource(metamodelURI, true);
	}
}
