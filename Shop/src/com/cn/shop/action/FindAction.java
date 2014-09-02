package com.cn.shop.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cn.shop.model.Product;
import com.cn.shop.service.ProductService;
import com.cn.shop.util.FenciUtil;
import com.cn.shop.util.WordFilter;
import com.opensymphony.xwork2.ActionSupport;

public class FindAction  extends ActionSupport {
	
	//商品service IOC
	private ProductService productService;
	
	//搜索关键字
	private String keyword;
	
	//搜索结果上篇链表
	
	private List< Product > findlist;
	
	//搜索分页
	
	private int page;
	 
	 private int maxpage;
	
	private HttpServletRequest request;
	
	
	
	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public int getMaxpage() {
		return maxpage;
	}



	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}



	public String getKeyword() {
		return keyword;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	
	

	public ProductService getProductService() {
		return productService;
	}



	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	public List<Product> getFindlist() {
		return findlist;
	}



	public void setFindlist(List<Product> findlist) {
		this.findlist = findlist;
	}



	//商品的搜索
	public String findproduct( )
	{
			if( keyword == null )
			{
				return "restart";
			}
		
			System.out.println("关键字"+keyword);
		
				//分词链表
				List<String> keylist = new ArrayList<String>();
				
				//过滤器配置文件的filtermap
				
				 Map<String,String > filtermap = new HashMap<String ,String >( );
				
				
				//提取关键字的keymap
				 
				 Map<String , String > keymap = new HashMap<String, String >( );
				 
				 //关键字
				 
				 String word = null;
				 
				 //配置文件地址
				 
				 String url  = ServletActionContext.getServletContext().getRealPath("/WEB-INF/classes/filter.dic") ;  
						 
							 
				 System.out.println( url  );
				 
				 
				 
				 
				 try {
					 
					 //1、进行分词
					 FenciUtil.fenci(keyword, keylist  );
					
					for( int i = 0 ; i < keylist.size() ; i++ )
						
					{
						System.out.println( keylist.get(i) );
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//2、读过滤器配置文件 指定配置文件url
				 
				 WordFilter.readType(filtermap , url   );
				 
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
				 
				

				 this.request = ServletActionContext.getRequest();
					
					int maxpage = this.productService.findnum(keymap);
					
					int pageNo  =1;
					
					int pageSize = 5;
					
					if( page >  0 )
					{
						pageNo = page;
					}
					
					
					findlist = this.productService.find(keymap, pageNo, pageSize);
					
					//与list.jsp页面page和  maxpage  重复导致换乱  bug
					
					request.setAttribute("fpage", pageNo);
					
					request.setAttribute("fmaxpage", maxpage);
		
		
					System.out.println( "大小" + findlist.size() );
		
		
		
		

		
					return "success";
	}
	

}
