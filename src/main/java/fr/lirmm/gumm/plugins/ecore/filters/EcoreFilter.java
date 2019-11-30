package fr.lirmm.gumm.plugins.ecore.filters;

import com.googlecode.gumm.flood.Filter;
import com.googlecode.gumm.flood.Mapping;

public class EcoreFilter extends Filter {

	public EcoreFilter() {}
	
	@Override
	public void filter() {
		if ( isMinimal() )
			return;
		
		for(int i = 0 ; i < alignment.getMappings().size() ; i++ ) {
			if ( alignment.getMapping(i) != null ) {
				Mapping m = alignment.getMapping(i);
				if ( !m.getSourceNode().getLabel().startsWith("#") && !m.getTargetNode().getLabel().startsWith("#"))
					alignment.removeMapping(i);
			}
		}
	}

	public String getDescription() {
		return "Filters everything except EClass, EReference, EAttribute and EDataType";
	}

	public String getName() {
		return "Ecore Filter";
	}
	
	private boolean isMinimal() {
		for(int i = 0 ; i < alignment.getMappings().size() ; i++ ) {
			if ( alignment.getMapping(i) != null ) {
				Mapping m = alignment.getMapping(i);
				if (m.getSourceNode().getLabel().startsWith("#") || m.getTargetNode().getLabel().startsWith("#"))
					return false;
			}
		}
		
		return true;
	}

}
