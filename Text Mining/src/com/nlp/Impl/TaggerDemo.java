package com.nlp.Impl;

import edu.stanford.nlp.util.logging.Redwood;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class TaggerDemo  {

  /** A logger for this class */
//  private static Redwood.RedwoodChannels log = Redwood.channels(TaggerDemo.class);

  public TaggerDemo() {}

  public static void main(String[] args) throws Exception {
	  TaggerDemo tags = new TaggerDemo();
	  
	  String data = "In the last decade, data mining techniques have been applied to sensor data in a wide range of application domains, such as healthcare monitoring systems, manufacturing processes, intrusion detection, database management, and others good work.";
	  String path = System.getProperty("user.dir");
	  path = path+File.separator+"nlp"+File.separator+"models"+File.separator+"wsj-0-18-bidirectional-distsim.tagger";
	  
    System.out.println(tags.extractNouns(path, data));
  }
  
  public ArrayList<String> extractNouns(String path,String words){
	  ArrayList<String> nouns = new ArrayList<String>();
	  String out = null;
	  MaxentTagger tagger = new MaxentTagger(path);
	    List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new StringReader(words));
	    for (List<HasWord> sentence : sentences) {
	      List<TaggedWord> tSentence = tagger.tagSentence(sentence);
//	      Iterator<TaggedWord> itr = tSentence.iterator();
//	      while(itr.hasNext()){
//	    	  String tag = itr.next().tag();
//	    	  String word = itr.next().value();
//	    	  if(tag.equalsIgnoreCase("NN") || tag.equalsIgnoreCase("NNS"))
//	    	  System.out.println("Tag = "+tag+">>>"+word);
//	      }
	      out = SentenceUtils.listToString(tSentence, false);
	      String[] o = out.split(" ");
	      for(String i:o){
	      String[] temp = i.split("/");
	      if(temp[1].equalsIgnoreCase("NN")||temp[1].equalsIgnoreCase("NNS")){
	    	  nouns.add(temp[0]);
	      }
	      }
	    }
	    return nouns;
  }

}
