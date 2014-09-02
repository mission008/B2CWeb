package com.cn.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.cn.shop.util.FenciUtil;
import com.cn.shop.util.WordFilter;



public class Keyword {
	
	@Test
	
	public void fenci( )
	{
		String text = "性感的衣服好看男鞋子红色帽子";
		
		
		//分词链表
		List<String> keylist = new ArrayList<String>();
		
		//过滤器配置文件的filtermap
		
		 Map<String,String > filtermap = new HashMap<String ,String >( );
		
		
		//提取关键字的keymap
		 
		 Map<String , String > keymap = new HashMap<String, String >( );
		 
		 //关键字
		 
		 String word = null;
		 
		 
		 
		 try {
			 
			 //1、进行分词
			 FenciUtil.fenci(text, keylist  );
			
			for( int i = 0 ; i < keylist.size() ; i++ )
				
			{
				System.out.println( keylist.get(i) );
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//2、读过滤器配置文件
		 
		 WordFilter.readType(filtermap);
		 
		 for( String key : filtermap.keySet() )
		 {
			 
			 System.out.println("key" + key + "value" + filtermap.get(key));
		 }
		 
		 //3、提取关键字
		 
		 for( int i = 0 ; i < keylist.size(); i++ )
		 {
			 //获取关键字
			 word = keylist.get(i);
			 
			 //提取关键字
			 
			 WordFilter.filterword(word, filtermap, keymap);
			 
			 
			 
		 }
		 
		 //最后查看 keymap
		 
		 System.out.println("=====================");
		 
		 for( String key : keymap.keySet() )
		 {
			 
			 System.out.println("key" + key + "value" + keymap.get(key));
		 }
		 
		
	}

}
