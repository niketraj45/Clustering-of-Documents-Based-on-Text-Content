package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Term_document_Matrix {


static double[] my_tf(String[] doc, String term)
{
    double n[] = new double[doc.length];
    double val=0;
   	for(int i=0;i<doc.length;i++)
        {
                String[] tmp = doc[i].split(" ");
                for(int j=0;j<tmp.length;j++)
                {
                    if(term.equalsIgnoreCase(tmp[j]))
                    {
                        val++;
                    }
                }
            n[i] = val;
            val = 0;
        }
        return n;
}


static double[] my_idf(ArrayList docs, String term)
{
   	double n = 0;
        double[] td = new double[docs.size()];
        for(int i=0;i<docs.size();i++)
        {
            if(docs.get(i).toString().contains(term))
            {
                n++;
            }
            if(n==0)
            {
                n=0;
                td[i] = n;
            }
            else
            {
            td[i] = Math.log10(docs.size()/n);
            }
            n=0;
        }
   	return td;
}

public static double[] tf_idf(double[] a,double[] b)
{
    double[] out = new double[a.length];
    
    for(int i=0;i<a.length;i++)
    {
        out[i] = a[i]*b[i];
    }
    return out;
}

public static double tf(List<String> doc, String term) 
{
    double result = 0;
    for (String word : doc) 
    {
    	String[] W = word.split("-");
       if (W[0].contains(term))
              result++;
     }
    return result;
}

public static double idf(List<List<String>> docs, String term)
{
    double n = 0;
    for (List<String> doc : docs) 
    {
        for (String word : doc) 
        {
            if (term.equalsIgnoreCase(word)) 
            {
                n++;
                break;
            }
        }
    }
    double val= Math.log10(docs.size() / n);
    if(val==0)
    {
        val=1;
    }
    
    return val;
}

public static double tfIdf(List<String> doc, List<List<String>> docs, String term) 
{
    return tf(doc, term) * idf(docs, term);
}

public static double[][] transposeMatrix(double [][] m)
{
        double[][] temp = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;

}

public static double[][] multiply(double[][] a, double[][] b) 
{
       int rowsInA = a.length;
       int columnsInA = a[0].length; // same as rows in B
       int columnsInB = b[0].length;
       
       double[][] c = new double[rowsInA][columnsInB];
       for (int i = 0; i < rowsInA; i++) {
           for (int j = 0; j < columnsInB; j++) 
           {
               for (int k = 0; k < columnsInA; k++) 
               {
                   c[i][j] = c[i][j] + a[i][k] * b[k][j];
               }
           }
       }
       return c;
   }


}
