package com.algorithm;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class ExtractData {
	private Rectangle rect = null;
	private ExtractData(){
		
	}
	
	public static ExtractData getInstance(){
		return new ExtractData();
	}
	public String getData(File file,String type){
		PDDocument document = null;
		String Data = "";
		try{
			 document = PDDocument.load(file);
			document.getClass();
			if (!document.isEncrypted()) {
		        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		        stripper.setSortByPosition(true);
		        stripper.setLineSeparator(" ");
		         rect = new Rectangle( 20, 100, 500, 280 );      
	            stripper.addRegion( "class1", rect );
	            PDPageTree allPages =  document.getDocumentCatalog().getPages();
	            PDPage firstPage = (PDPage)allPages.get( 0 );
	            stripper.extractRegions( firstPage );
	            Data = stripper.getTextForRegion( "class1" );
		    }
			else{
				JOptionPane.showMessageDialog(null, "The document is password protected!!!");
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		finally {
			try {
				document.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("---------------------@@@@@@@@@@@@@@@@@@#################################*************************************************************");
		return Data;
	}
	
	public String getData(File file){
		PDDocument document = null;
		String Data = "";
		try{
			 document = PDDocument.load(file);
			document.getClass();
			if (!document.isEncrypted()) {
		        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		        stripper.setSortByPosition(true);
		        stripper.setLineSeparator(" ");
		         rect = new Rectangle( 20, 100, 800, 600 );      
	            stripper.addRegion( "class1", rect );
	            PDPageTree allPages =  document.getDocumentCatalog().getPages();
	            PDPage firstPage = (PDPage)allPages.get( 0 );
	            stripper.extractRegions( firstPage );
	            Data = stripper.getTextForRegion( "class1" );
		    }
			else{
				JOptionPane.showMessageDialog(null, "The document is password protected!!!");
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		finally {
			try {
				document.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("---------------------@@@@@@@@@@@@@@@@@@#################################*************************************************************");
		return Data;
	}
}

