package fr.lirmm.gumm.plugins.ecore.evaluators;

public class SubstringEvaluator extends EcoreEvaluator {

	public SubstringEvaluator() {
		super();
	}
	
	@Override
	protected float getSimilarity(String s1, String s2) {
		if ( s1.contains(s2) )
			return 1.0F;
		else if ( s2.contains(s1) )
			return 1.0F;
		else
			return 0.0F;
	}
}
