package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Vector;

public class StopWords {

public static String[] stopWordsofwordnet = {
"~","!","@","#","$","%","^","&","*","(",")","]", "[", "}", "{", "<",">","?","\\", "/", ")", "(","without", "see", "unless", "due", "also", "must", "might", "like","will", "may", "much", "every", "the", "in", "other", "this", "the", "many", "any",  "or", "in", "an", "is", "a", "about", "above", "after", "again", "against", "all", "am",  "and", "any", "aren't", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could",
"couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having",
"he", "he'd", "he'll", "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i ", " i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is",
"isn't", "it", "it's", "its", "itself", "let's", "me", "more", "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "ought", "our", "ours", "ourselves",
"out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such", "than","for",
"that", "that's", "their", "theirs", "them", "themselves", "then", "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've",
"this", "those", "through", "to", "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've",
"were", "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom","application","efficiency",
"why", "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours", "yourself", "yourselves",
"Without", "See", "Unless", "Due", "Also", "Must", "Might", "Like", "Will", "May", "Can", "Much", "Every", "The", "In", "Other", "This", "The", "Many", "Any", "Or", "For", "In", "An", "Is", "A", "About", "Above", "After", "Again", "Against", "All", "Am", "And", "Any", "Are", "Aren't", "As", "At", "Be", "Because", "Been", "Before", "Being", "Below", "Between", "Both", "But", "By", "Can't", "Cannot", "Could",
"Couldn't", "Did", "Didn't", "Do", "Does", "Doesn't", "Doing", "Don't", "Down", "During", "Each", "Few", "From", "Further", "Had", "Hadn't", "Has", "Hasn't", "Have", "Haven't", "Having",
"He", "He'd", "He'll", "He's", "Her", "Here", "Here's", "Hers", "Herself", "Him", "Himself", "His", "How", "How's", "I ", " I", "I'd", "I'll", "I'm", "I've", "If", "In", "Into", "Is",
"Isn't", "It", "It's", "Its", "Itself", "Lets", "Me", "More", "Most", "Mustn't", "My", "Myself", "No", "Nor", "Not", "of", "Off", "On", "Once", "Only", "Ought", "Our", "Ours", "Ourselves",
"Out", "Over", "Own", "Same", "Shan't", "She", "She'd", "She'll", "She's", "Should", "Shouldn't", "So", "Some", "Such", "Than",
"That", "That's", "Their", "Theirs", "Them", "Themselves", "Then", "There", "There's", "These", "They", "They'd", "They'll", "They're", "They've",
"This", "Those", "Through", "To", "Too", "Under", "Until", "Up", "Very", "Was", "Wasn't", "We", "We'd", "We'll", "We're", "We've",
"Were", "Weren't", "What", "What's", "When", "When's", "Where", "Where's", "Which", "While", "Who", "Who's", "Whom",
"Why", "Why's", "With", "Won't", "Would", "Wouldn't", "You", "You'd", "You'll", "You're", "You've", "Your", "Yours", "Yourself", "Yourselves", "able", "about",
"across", "after", "all", "almost", "also", "am", "among",
"and", "any", "are", "as", "at", "be", "because", "been", "but",
"by", "can", "cannot", "could", "dear", "did", "do", "does",
"either", "else", "ever", "every", "from", "get", "got",
"had", "has", "have", "he", "her", "hers", "him", "his", "how","properties","algorithm","algorithms","functions","letters","methods","computing","environment","literature","problem","relations","requirements","technology","system","record","example","improving","problems","person","process","university","system","health","generation","patient","tance",
"however", "i", "if", "in", "into", "is", "it", "its", "just",
"least", "let", "like", "likely", "may", "me", "might", "most",
"must", "my", "neither", "no", "nor", "not", "of", "off", "often",
"on", "only", "or", "other", "our", "own", "rather", "said", "say",
"says", "she", "should", "since", "so", "some", "than", "that",
"the", "their", "them", "then", "there", "these", "they", "this","authors","approach",
"tis", "to", "too", "twas", "us", "wants", "was", "were",
"what", "when", "where", "which", "while", "who", "whom", "why","languages","language","system","systems","customers","trade","aspects","result","results","population","volume","software","increases","order",
"will", "with", "would", "yet", "you", "your","a's","able","about","above","according","accordingly","across","actually","after","afterwards","again ","against ","ain't ","all ","allow","allows","almost","alone","along","already","also","although","always","looking","look","looks","necessary","nearly","anything","introduction","index","age","data","ieee","good","abstract"};

public static LinkedHashSet<String> wordsList = new LinkedHashSet<String>();
public static HashSet<String> wordsList1 = new HashSet<String>();
public static Vector vec = new Vector();
public static int size = 0;
public static boolean flag = false;

public static void main(String[] args){
String s="He was kept off aspirin given his GI bleeding. The patient also has hypertension and was on Isordil and Cardizem for that.";
String k = StopWords.sorting(s);
    System.out.println("sorted= "+k);
StopWords sw = new StopWords();
String out = sw.stopwords_new(k);
    System.out.println("out= "+out);
}

public static String stopwords(String s)
{
    Vector vec = new Vector();
    String out = "";
s=s.trim().replaceAll("\\s+", " ");
String[] words = s.split(" ");

for (String word : words) {
	//System.out.println("checking...."+word);
    
wordsList.add(word);
}
if(flag==false)
{
    size = wordsList.size();
}
for (int i = 0; i <wordsList.size(); i++) {
for (int j = 0; j < stopWordsofwordnet.length; j++) {
   
if (wordsList.contains(stopWordsofwordnet[j])) 
{
	System.out.println("matched= "+wordsList);
        System.out.println("i,j= "+i+","+j);
        wordsList.remove(stopWordsofwordnet[j]);
                
        
}
   
}
}
    System.out.println("len"+wordsList.size());
    if(wordsList.size()>1)
    {
        for (String str : wordsList) {
//System.out.print(str+" ");
out+=str+"-";
}
    }
    else
    {
       String hout = wordsList.toString();
        out = hout.substring(1, hout.length()-1);
    }
    

wordsList.clear();
return out;
}

public void check(int i,int j)
{
    
}

public static String sorting(String s)
{
    String out = "";
    String arr[] = s.split(" ");
    String tmp;
for (int i = 0;i < arr.length;i++)
{
  tmp = arr[i];
  for (int j = 0;j < arr.length;j++)
  {
    if (i == j) continue; // Same place.. Nothing to do.
    int x = tmp.compareTo(arr[j]); // Bigger smaller?!
    if (x < 0) // Need to swap.
    {
      /* Swaping proccess... */
      tmp = arr[j];
      arr[j] = arr[i];
      arr[i] = tmp;
    }
  }
}
for(int i=0;i<arr.length;i++)
{
    out+=arr[i].toLowerCase()+" ";
}
 return out;
}

public static String stopwords_new(String s)
{
   
    String out = "";
//s=s.trim().replaceAll("\\s+", " ");
String[] words = s.split(" ");

for(int i=0;i<words.length;i++)
{
    wordsList1.add(cleanString(words[i]).toLowerCase().trim());
}
ArrayList<String> arr = new ArrayList<String>(Arrays.asList(stopWordsofwordnet));
//for(int i=0;i<wordsList1.size();i++)
//{
  //  System.out.println("checking...."+wordsList1.get(i));
//}
//for (int i = 0; i <wordsList1.size(); i++) {
//	System.out.println(arr.contains(wordsList1.get(i)));
//if (arr.contains(wordsList1.get(i))) 
//{
//	//System.out.println("matched= "+stopWordsofwordnet[j]);
//        //System.out.println("i,j= "+i+","+j);
//        wordsList1.remove(wordsList1.get(i));
//}
//
//}
//System.out.println(wordsList1+">>>");
ArrayList<String> remove = new ArrayList<>();
Iterator<String> itr = wordsList1.iterator();
while(itr.hasNext()){
	String g = itr.next();
	if(arr.contains(g)){
		remove.add(g);
	}
}
//System.out.println("///"+remove);
wordsList1.removeAll(remove);
//System.out.println(wordsList1);
    if(wordsList1.size()>1)
    {
        for (String str : wordsList1) {
//System.out.print(str+" ");
out+=str+" ";
}
    }
    else
    {
       String hout = wordsList1.toString();
        out = hout.substring(1, hout.length()-1);
    }
    

wordsList1.clear();
return out;
}

public void update_list(ArrayList arr,int i)
{
    flag = true;
    arr.remove(i);
    StopWords.size = arr.size();
}

public static String cleanString(String data){
	String resultString = data.replaceAll("[^\\p{L}\\p{Nd}]+", "");
	return resultString;
}
}