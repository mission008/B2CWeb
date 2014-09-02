package com.cn.shop.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class FenciUtil {

	//分词字符串   保存字符串数组
	public static void fenci( String  text, List<String>  keylist ) throws IOException
	{
		  
		   String keyword = null;
	         
	        //创建分词对象  
	        Analyzer anal=new IKAnalyzer(true);       
	        StringReader reader=new StringReader(text);  
	        //分词  
	        TokenStream ts=anal.tokenStream("", reader);  
	        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);  
	       //遍历分词数据  
	        while(ts.incrementToken()){  
	           // System.out.print(term.toString()+"|");  
	        	
	        	keyword =""+ term.toString();
	        	
	        	keylist.add(keyword);
	        	
	       }  
	       reader.close(); 
		
		
		
	}
}
