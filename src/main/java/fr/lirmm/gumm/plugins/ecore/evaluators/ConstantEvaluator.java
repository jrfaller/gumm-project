package fr.lirmm.gumm.plugins.ecore.evaluators;

public class ConstantEvaluator extends EcoreEvaluator {
	
	public ConstantEvaluator() {
		super();
	}

	@Override
	protected float getSimilarity(String s1, String s2) {
		// TODO Auto-generated method stub
		return 1.0F;
	}
	
	public String getName() {
		return "Constant Weight Evaluator";
	}
	
	public String getDescription() {
		return "Puts constants weight on every edges.";
	}

}
