package com.cn.shop.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class UpLoadUtil {
	
	private static final int BUFFER_SIZE = 16 * 1024;  
	
	 private static void copy(File src, File dst) {  
	      try {  
	    	  		InputStream in = null;  
	    	  		OutputStream out = null;  
	    	  		try {  
	    	  			in = new BufferedInputStream(new FileInputStream(src),  
	    	  					BUFFER_SIZE);  
	    	  			out = new BufferedOutputStream(new FileOutputStream(dst),  
	    	  					BUFFER_SIZE);  
	    	  			byte[] buffer = new byte[BUFFER_SIZE];  
	    	  			while (in.read(buffer) > 0) {  
	    	  				out.write(buffer);  
	    	  			}  
	    	  		} finally {  
	               if (null != in) {  
	                 in.close();  
	               }  
	                if (null != out) {  
	                    out.close();  
	                }  
	           }  
	       } catch (Exception e) {  
          e.printStackTrace();  
          
	       }  
	    }  

  private static String getExtention(String fileName) {  
	        int pos = fileName.lastIndexOf(".");  
	       return fileName.substring(pos);  
	    }  
  
 
     public static String upload( File src ) {  
          if (src  == null)  
              return ""; 
          
          String tempName = new Date().getTime() +  getExtention( src.getName() );
          
          
          File imageFile = new File(ServletActionContext.getServletContext()  //得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)  
        
                      .getRealPath("UploadImages")     
                      + "/" + tempName );   
              
          System.out.println(imageFile.getAbsolutePath()  );
          
          copy( src , imageFile);  //把图片写入到上面设置的路径里  
          
          //2014.9.2 返回文件名
 
         // return  imageFile.getAbsolutePath() ;  
          
          //修改客户端显示图片bug 使用相对地址  直接返回文件名 mysql存储的文件名
          
          return tempName ;
          
          
      }  
    
   
 

}
