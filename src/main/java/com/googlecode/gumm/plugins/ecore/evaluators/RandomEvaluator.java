package com.googlecode.gumm.plugins.ecore.evaluators;

public class RandomEvaluator extends EcoreEvaluator {
	
	public RandomEvaluator() {
		super();
	}
	
	@Override
	protected float getSimilarity(String s1, String s2) {
		return (float) Math.random();
	}
	
}
