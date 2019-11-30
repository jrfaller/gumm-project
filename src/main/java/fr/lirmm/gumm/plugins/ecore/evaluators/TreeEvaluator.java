package fr.lirmm.gumm.plugins.ecore.evaluators;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.googlecode.gumm.flood.Sigma;
import com.googlecode.gumm.flood.graph.CompatibilityNode;
import com.googlecode.gumm.graph.LabeledNode;
import fr.lirmm.nlpse.dependencies.EnglishDependencyBuilder;
import fr.lirmm.nlpse.distance.SimpleTreeSimilarity;
import fr.lirmm.nlpse.segmenters.GlobalSegmenter;
import fr.lirmm.treetagger.TreeTaggerParser;

public class TreeEvaluator extends EcoreEvaluator {

	private Map<Integer, CompatibilityNode> nodeMap;

	public TreeEvaluator() {
		super();
	}

	public void initSigma0() {
		// removeWrongNodes(propagationGraph); FIXME

		GlobalSegmenter s = new GlobalSegmenter();

		nodeMap = new HashMap<Integer, CompatibilityNode>();

		List<List<String>> srcAllTokens = new LinkedList<List<String>>();		
		List<List<String>> tgtAllTokens = new LinkedList<List<String>>();

		for(CompatibilityNode cn: propagationGraph.getNodes()) {
			LabeledNode sn = cn.getSourceNode();
			LabeledNode tn = cn.getTargetNode();

			if ( !sn.getLabel().startsWith("#") && !tn.getLabel().startsWith("#") ) {
				// if (sigma0.getSimilarity(cn.getId()) == Sigma.INVALID_ENTRY ) {
					srcAllTokens.add( s.getSegments( sn.getLabel() ) );
					tgtAllTokens.add( s.getSegments( tn.getLabel() ) );
					nodeMap.put(srcAllTokens.size()-1,cn);
				//} FIXME
			}
			else {
				sigma0.setSimilarity(cn.getId(),0.0F);
			}
		}
		try {
			TreeTaggerParser p = new TreeTaggerParser("/home/falleri/Travail/tools/taln/tree-tagger-install/cmd/tree-tagger-english");

			List<List<String>> srcAllPos = p.tagUsingFiles(srcAllTokens,"/tmp/tokensA","/tmp/posA");
			List<List<String>> tgtAllPos = p.tagUsingFiles(tgtAllTokens,"/tmp/tokensB","/tmp/posB");

			System.out.println(srcAllTokens.size());
			System.out.println(srcAllPos.size());
			
			EnglishDependencyBuilder sdp = new EnglishDependencyBuilder(srcAllTokens,srcAllPos);
			sdp.buildNodes();

			System.out.println(sdp.getRootNodes().size());
			
			EnglishDependencyBuilder tdp = new EnglishDependencyBuilder(tgtAllTokens,tgtAllPos);
			tdp.buildNodes();

			for(int i = 0; i < srcAllTokens.size() ; i++ ) {
				CompatibilityNode cn = nodeMap.get(i);
				sigma0.setSimilarity(cn.getId(),SimpleTreeSimilarity.getSimilarity(sdp.getRootNodes().get(i), tdp.getRootNodes().get(i)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected float getSimilarity(String s1, String s2) {
		return 0.0F;
	}

}
