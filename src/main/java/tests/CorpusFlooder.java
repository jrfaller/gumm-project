package tests;

import com.googlecode.gumm.flood.Sigma0Evaluator;
import com.googlecode.gumm.flood.WeightEvaluator;
import com.googlecode.gumm.graph.GraphImporter;

public class CorpusFlooder {
	
	private String[][] corpus;

	public CorpusFlooder(String[][] corpus) {
		this.corpus = corpus;
		
	}
	
	public void align(String[] scenario, GraphImporter importer, WeightEvaluator weightEvaluator, Sigma0Evaluator sigmaEvaluator, String outputDir) {
	}
	
}
