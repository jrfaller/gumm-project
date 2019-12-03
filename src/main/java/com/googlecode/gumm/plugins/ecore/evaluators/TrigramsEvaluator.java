package com.googlecode.gumm.plugins.ecore.evaluators;
import java.util.Vector;



public class TrigramsEvaluator  extends EcoreEvaluator {
    
	public TrigramsEvaluator() {
		super();
	}
	
	@Override
	protected float getSimilarity(String s1, String s2) {
		return computeSim(s1,s2);
	}
	
	public float computeSim(String element1, String element2) {
	    float res = 0.0F;
	    Vector<String> triS1 = new Vector<String>();
		Vector<String> triS2 = new Vector<String>();
	    int compteur=0;

	    while(element1.substring(compteur).length()>2)
		{
			triS1.add(element1.substring(compteur, compteur+3));
			compteur++;
		}
		compteur = 0;
		while(element2.substring(compteur).length()>2)
		{
			triS2.add(element2.substring(compteur, compteur+3));
			compteur++;
		}

		int nbCommonTriGr = 0;
		for(int i=0;i<triS1.size();i++)
		    for(int j=0;j<triS2.size();j++)
		    {
		        if(triS1.get(i).equals(triS2.get(j))) nbCommonTriGr++;
		    }

		res = (1.0F / (1.0F + (float)triS1.size() + (float)triS2.size() - (float)(2*nbCommonTriGr)));
		return res;
	}
}