package fr.lirmm.gumm.plugins.ecore.evaluators;

import uk.ac.shef.wit.simmetrics.similaritymetrics.Levenshtein;

public class LevenshteinEvaluator extends EcoreEvaluator {
	
	private Levenshtein lev;
	
	public LevenshteinEvaluator() {
		super();
		lev = new Levenshtein();
	}

	@Override
	protected float getSimilarity(String s1, String s2) {
		return lev.getSimilarity(s1,s2);
	}

}
