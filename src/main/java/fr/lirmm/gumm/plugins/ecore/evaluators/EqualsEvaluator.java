package fr.lirmm.gumm.plugins.ecore.evaluators;

public class EqualsEvaluator extends EcoreEvaluator {
	
	public EqualsEvaluator() {
		super();
	}

	@Override
	protected float getSimilarity(String s1, String s2) {
		if ( s1.equals(s2) )
			return 1.0F;
		else
			return 0.0F;
	}
	
}
