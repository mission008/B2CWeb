package com.cn.shop.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFilter {
	
	//2014.8.31 读过滤器配置文件，把配置文件存放到map中
	
	public static void readType( Map<String, String > flitermap   )
	{
		
			InputStream in= WordFilter.class.getClassLoader().getSystemResourceAsStream("filter.dic");
					
			String text = null;
			
			String key = null;
			
			String value = null;
	
			BufferedReader br = new BufferedReader( new InputStreamReader( in ));
			
			
			//路径问题是个bug
		//	File file = new File( "C:/Users/Administrator/Documents/javaweb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Shop/WEB-INF/classes/filter.dic");
			
			try {
				
				//BufferedReader br = new BufferedReader( new FileReader( file ) );
				
				while( ( text = br.readLine()) != null )
				{
					System.out.println( text );
					
					key = text.substring(0, 2);
					
					System.out.println(key);
					
					value = text.substring(3);
					
					System.out.println( value );
					
					flitermap.put(key, value);
					
					
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	
	//重载读配置文件 获取web/classes/目录下文件
	
	public static void readType( Map<String, String > flitermap , String url   )
	{
		
	
			
		
		
			String text = null;
			
			String key = null;
			
			String value = null;
			

			
			
			//路径问题是个bug
			File file = new File( url );
			
			try {
				
				BufferedReader br = new BufferedReader( new FileReader( file ) );
				
				while( ( text = br.readLine()) != null )
				{
					System.out.println( text );
					
					key = text.substring(0, 2);
					
					System.out.println(key);
					
					value = text.substring(3);
					
					System.out.println( value );
					
					flitermap.put(key, value);
					
					
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	
	//分词与配置文件中的关键字进行匹配，成功返回true
	
	public static boolean  match( String type, String text  )
	{
		

		
		 String  regex =".*"+"("+type+")"+".*";
		
		 Pattern pattern = Pattern.compile(regex); 
		 
	     Matcher matcher = pattern.matcher(text);
	     
	     return matcher.matches() ;
		
	}
	
	//过滤分词，提取关键字，最后把关键字存入keymap中
	public static void filterword( String keyword , Map<String , String > filtermap, Map<String, String > keymap )	
	{
		//1、遍历配置文件进行匹配
		
		for( String key : filtermap.keySet() )
		{
			
			if( match( keyword, filtermap.get(key)))
			{
				
				
				//匹配成功，存入keymap
				keymap.put(key, keyword);
				
				break;
				
				
				
			}
			
		}
		
	}
	

}
