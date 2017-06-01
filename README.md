CLUSTERING OF DOCUMENTS BASED ON TEXT CONTENT

PROJECT ID:2017/ 13CS495/PW099

TEAM MEMBERS 
Niket Raj - 1PI13CS100
S Bhaskar -1PI13CS128
Shreyash Patil-1PI13CS155
GUIDE: Prof.V.R.Badri Prasad

Description:
Project submitted for the completion of the degree “Bachelor Of Engineering” to the department of Computer Science and Engineering, PES Institute of Technology in May 2017.

Overview:
The main aim of the project is to dwell and reflect on the solutions to literature survey people ,who have to sort or classifly a large set of documents according to their interest or domainwise.This also involves collection of different domains dataset(research papers documents) such as networking ,data mining, Cloud Computing .

The Project is structured in the following

--] SourceCode
	TextMining
		src
			(Default package)
				Controller.java
			com.algorithm
				ExtractData.java
				LoadDataset.java
				StopWords.java
				TermDocumentMatrix.java
			com.database
				DBConnection.java
				DBFormat.java
				DBQuery.java	
			com.implementation
				Connector.java
				Constants.java
				PropertyImpl.java
			com.nlp
				TaggerDemo.java
				Constants.java
				PropertyImpl.java
		UI
			index.jsp
			search.jsp
			result.jsp
			result1.jsp
		Libraries
			Mysql-connector-java-5.1.6-bin.jar
			Pdfbox-app-2.0.4.jar
			Stanford-postagger-3.7.0.jar
		config.properties


		
Key highlights:-
We have trained with 500 documents for 5 domains with 100 each .
NLP postagger Tool is important tool in our project.
Our dataset was grouped into 5 clusters.
We generated most occurring document for each of the clusters.
Using these,we generated corpus for each cluster.


Prerequisite:-
Eclipse IDE Mars
JDK 8
Tomcat Server 7.0
MySQL Server
Navicat Lite for MySQL
Web Browser


Usage of the System:-
Install Eclipse IDE and Java 1.8 to your PC or Laptop.
Install MySQL server, Navicat Lite for MySQL and Tomcat Server to your PC or Laptop.
Create Database table for the Dataset.
Import the project code to Eclipse IDE.
Launch the application and Train the System.
Store the Input Documents in the "Dataset" folder.
Click Search Data and Choose the domain from the dropdown.
After clicking Search button you will get a list of documents of selected domain.

