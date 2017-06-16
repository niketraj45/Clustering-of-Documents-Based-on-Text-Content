package com.algorithm;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

import com.database.DBQuery;
import com.impl.Constants;
import com.nlp.Impl.TaggerDemo;

public class LoadDataset extends DBQuery{
private ExtractData extract = null;
private TaggerDemo posTagger = null;

	public LoadDataset() throws SQLException{
		extract = ExtractData.getInstance();
		posTagger = new TaggerDemo();
		trainData();
		start();
	}
	public static void main(String[] args) throws SQLException {
	new LoadDataset();
	}
	
	private void trainData() throws SQLException{
		String dataset_path = System.getProperty(Constants.system_dir);
		dataset_path = dataset_path+File.separator+"Training Dataset";
		String taggerPath = Constants.taggerPath;
		ArrayList<String> document = new ArrayList<String>();
		HashSet<String> terms = new HashSet<String>();
		
		File[] files = new File(dataset_path).listFiles();
		for(File f:files){
			if(f.isDirectory()){
				String type  = f.getName();
				System.out.println("Name = "+type);
				File[] F = f.listFiles();
				for(File f1:F){
			String data = extract.getData(f1,type);
			data = StopWords.sorting(data);
			data = StopWords.stopwords_new(data);
			ArrayList<String> nouns  = LoadDataset.removeRedundantData(posTagger.extractNouns(taggerPath, data));
			String N = convertArrayListToString(nouns);
			document.add(N+"-"+type);
			//System.out.println("niket = "+N+"-"+type);
			String[] n = N.split(" ");
			for(String n1:n){
				terms.add(n1);	
				//System.out.println("yash = "+n1);
			}
					}
				HashSet<String> closedTerms = new HashSet<>();
				Iterator<String> itr = terms.iterator();
				while(itr.hasNext()){
					String term = itr.next();
					if(!term.equalsIgnoreCase("abstract") || !term.equalsIgnoreCase("introduction")){
					double d = Term_document_Matrix.tf(document, term);
					if(d==1 && term.length()>=5){
						closedTerms.add(term);
					}
					}
				}
				if(type.equalsIgnoreCase("cc")){
					closedTerms.add("cloud");
				}
				else if(type.equalsIgnoreCase("nw")){
					closedTerms.add("network");
				}
				else if(type.equalsIgnoreCase("mc")){
					closedTerms.add("mobile");
				}
				else if(type.equalsIgnoreCase("dm")){
						closedTerms.add("mining");
				}
				System.out.println(closedTerms);
				storeData("Train Data", new ArrayList<>(closedTerms), type);
				
				terms.clear();
				document.clear();
				closedTerms.clear();
			}
		}
		
	}
	private void start() throws SQLException{
		ArrayList<String> out = new ArrayList<>();
		
		String type = "";
		String tp = "";
		String temp = "";
		String dataset_path = System.getProperty(Constants.system_dir);
		dataset_path = dataset_path+File.separator+"Dataset";
		String dm_data = getData("Data Mining").toString();
		String nw_data = getData("Networking").toString();
		String mc_data = getData("Mobile Computing").toString();
		String cc_data = getData("Cloud Computing").toString();
		String iot_data = getData("Internet Of Things").toString();
		int dm_count = 0;
		int nw_count = 0;
		int mc_count = 0;
		int cc_count = 0;
		int iot_count = 0;
		String taggerPath = Constants.taggerPath;
		File[] files = new File(dataset_path).listFiles();
		for(File f:files){
			System.out.println("name= "+f.getName());
			String data = extract.getData(f);
			data = StopWords.sorting(data);
			data = StopWords.stopwords_new(data);
			ArrayList<String> nouns  = LoadDataset.removeRedundantData(posTagger.extractNouns(taggerPath, data));
			for(String s:nouns){
				if(s.length()>=5){
				if(dm_data.contains(s.trim())){
					if(temp.equalsIgnoreCase(s.trim())){
						continue;
					}
					
					out.add(s);
					tp = "dm";
					temp = s;
					dm_count++;
				}
				 if(nw_data.contains(s.trim())){
					 if(temp.equalsIgnoreCase(s.trim())){
						 if(tp.equalsIgnoreCase("dm")){
							 dm_count--;
						 }
						 out.remove(temp);
						 continue;
						}
					 out.add(s);
					 tp = "nw";
					temp = s;
					nw_count++;
				}
				 if(mc_data.contains(s.trim())){
					 if(temp.equalsIgnoreCase(s.trim())){
						 if(tp.equalsIgnoreCase("dm")){
							 dm_count--;
						 }
						 if(tp.equalsIgnoreCase("nw")){
							 nw_count--;
						 }
						 out.remove(temp);
						 continue;
						}
					 out.add(s);
					 tp = "mc";
					temp = s;
					mc_count++;
				}
				 if(cc_data.contains(s.trim())){
					 if(temp.equalsIgnoreCase(s.trim())){
						 if(tp.equalsIgnoreCase("dm")){
							 dm_count--;
						 }
						 if(tp.equalsIgnoreCase("nw")){
							 nw_count--;
						 }
						 if(tp.equalsIgnoreCase("mc")){
							 mc_count--;
						 }
						 out.remove(temp);
						 continue;
						}
					 out.add(s);
					 tp = "cc";
					temp = s;
					cc_count++;
				}
				 if(iot_data.contains(s.trim())){
					 if(temp.equalsIgnoreCase(s.trim())){
						 continue;
						}
					 tp = "iot";
					temp = s;
					iot_count++;
				}
				
			}
				
			}
			if(dm_count>nw_count && dm_count>mc_count && dm_count>cc_count && dm_count>iot_count){
				type = "dm";
			}
			else if(nw_count>dm_count && nw_count>mc_count && nw_count>cc_count && nw_count>iot_count){
				type = "nw";
			}
			else if(mc_count>dm_count && mc_count>nw_count && mc_count>cc_count && mc_count>iot_count){
				type = "mc";
			}
			else if(cc_count>dm_count && cc_count>nw_count && cc_count>mc_count && cc_count>iot_count){
				type = "cc";
			}
			else if(iot_count>dm_count && iot_count>nw_count && iot_count>mc_count && iot_count>cc_count){
				type = "iot";
			}
			System.out.println(type+"---"+out);
			storeData(f.getName(), out, type);
			dm_count = 0;
			 nw_count = 0;
			 mc_count = 0;
			 cc_count = 0;
			 iot_count = 0;
			 out.clear();
			 temp = "";
			}
			
	}
	private ArrayList<String> getData(String type) throws SQLException{
		ArrayList<String> out = new ArrayList<String>();
		ResultSet rs = DB_SELECT(null, null, "corpus", "without condition");
		while(rs.next()){
			String d = rs.getString(type);
			out.add(d);
		}
		return out;
	}
	
	public static ArrayList<String> removeRedundantData(ArrayList<String> data)
	{
		LinkedHashSet<String> set = new LinkedHashSet<String>(data);
		return new ArrayList<String>(set);
	}
	
	public static String convertArrayListToString(ArrayList<String> data)
	{
		String out = "";
		Iterator<String> itr = data.iterator();
		while(itr.hasNext()){
			out+=itr.next()+" ";
		}
		out = out.substring(0, out.lastIndexOf(" "));
		return out;
	}
	
	private int storeData(String documentName,ArrayList<String> terms,String type) throws SQLException{
		String [] data = new String[6];
		switch (type) {
		case "cc":
			data[0] = documentName;
			data[1] = null;
			data[2] = null;
			data[3] = null;
			data[4] = terms.toString();
			data[5] = null;
			break;
		case "dm":
			data[0] = documentName;
			data[1] = terms.toString();
			data[2] = null;
			data[3] = null;
			data[4] = null;
			data[5] = null;
			break;
		case "mc":
			data[0] = documentName;
			data[1] = null;
			data[2] = null;
			data[3] = terms.toString();
			data[4] = null;
			data[5] = null;
			break;
		case "nw":
			data[0] = documentName;
			data[1] = null;
			data[2] = terms.toString();
			data[3] = null;
			data[4] = null;
			data[5] = null;
	break;
		case "iot":
			data[0] = documentName;
			data[1] = null;
			data[2] = null;
			data[3] = null;
			data[4] = null;
			data[5] = terms.toString();
	break;
		default:
			break;
		}
		int i = DB_INSERT(data, "corpus");
		return i;
	}


	
	/*public ArrayList<String> getdocumentName(String type){
		String get_data = "";
		if(type.equalsIgnoreCase("")){
	    	   get_data = "dm";
	       }
	       else if(type.equalsIgnoreCase("")){
	    	   get_data = "nw";
	       }
	       else if(type.equalsIgnoreCase("")){
	    	   get_data = "mc";
	       }
	       else if(type.equalsIgnoreCase("")){
	    	   get_data = "cc";
	       }
	       else if(type.equalsIgnoreCase("")){
	    	   get_data = "iot";
	}
		String path = Constants.projectPath;
		
	}*/
}
