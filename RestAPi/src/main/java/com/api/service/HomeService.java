package com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.model.Payload;
import com.api.model.Transaction;
import com.google.gson.Gson;
import java.util.*;
@Service
public class HomeService {

	@Autowired
	private RestTemplate restTemplate;
	
	public  List<Integer> Transaction(int uid, String txnType, String monthYear)
	{
		 List<Integer> validlist = new ArrayList<Integer>();
		  List<Transaction> list = new ArrayList<Transaction>();
		int page=1;
		int totalPageCount=1;
		 int count = 0;
			Double sum = 0.0;
	        Double avg = 0.0;
	        String amt="0";
		 String Url = "https://jsonmock.hackerrank.com/api/transactions/search?userId=";
		 if(uid > 0){
			 Url = Url + uid;                      
	        } 
	//	 System.out.println(Url);
		 
		 int month = 0;
	        int year = 0;
	        String strMon = monthYear.substring(1,3);   
            String strYear = monthYear.substring(4,8);
        //    System.out.println(strMon);
        //    System.out.println(strYear);
            try{
            month = Integer.parseInt(strMon);
            year = Integer.parseInt(strYear);
      //      System.out.println(month);
        //    System.out.println(year);
            }
            catch(Exception e)
            {
            System.out.println("Error to convert");
            }
        
		  for(int i=0;i<totalPageCount;i++) {	  
		String UrlWithPage=Url + "&page=" + page;
	//	System.out.println(UrlWithPage);
		  Gson gson = new Gson(); 
		String res=  restTemplate.getForObject(UrlWithPage,String.class);
			//	System.out.println(res);
				Payload PayloadObj =gson.fromJson(res, Payload.class);
				
			 if(PayloadObj != null && PayloadObj.data!=null){
		        totalPageCount = PayloadObj.getTotal_pages();
		       //      System.out.println(totalPageCount);
		           
		             for(int j=0;j<PayloadObj.data.size();j++){
		                 Transaction txn = PayloadObj.data.get(j);
		                 list.add(txn);
		        }    
		     //   	 System.out.println(page);
				 }
				page++;
			//	 System.out.println(page);
			//	 System.out.println(list); 
		  }
				 for(int record=0;record<list.size();record++){
			            Transaction txn = list.get(record); 
			    //        System.out.println(txn);
			      //      System.out.println(txn.txnType + " : " + txn.amount);
			        
		if(txn.txnType.equals("debit"))	
		{
			count++;
			amt = txn.amount;
			amt=amt.replace("$","");
			amt=amt.replace(",","");
			sum = sum + Double.parseDouble(amt);		
		
		//	 System.out.println("amt"+amt);
       // 	 System.out.println("count"+count);
       // 	 System.out.println("sum"+sum);
		}		 
		
	}
			//	 System.out.println(count);	
			//	 System.out.println(sum);
		        	avg = sum / count;
		        	 System.out.println("amt"+amt);
		        	 System.out.println("count"+count);
		        	 System.out.println("sum"+sum);
		       	 System.out.println("avg"+avg);
				 /*
		    return new ResponseEntity<Object>(res,HttpStatus.OK); */ 
		    
		            for(int k=0;k<list.size();k++){
		              Transaction txn = list.get(k);

		                boolean isValid = false;
		                
		                  
		                String strAmount = txn.amount;            	
		            	strAmount = strAmount.replace("$","");
		                strAmount = strAmount.replace(",","");
		                
		                try {
		                	Double amount = Double.parseDouble(strAmount);
		                	if(amount > avg) {
		                	isValid = true;
		                	}else {
		                		isValid = false;
		                	}
		                	
		                }catch(Exception e) {
		                	e.printStackTrace();
		                }
		               
		          
		                // ----------------  time filter ---------------------------------
		                String strTimestamp = null;
		                
		                if(txn.timestamp != null) {
		                   
		                        strTimestamp = txn.timestamp;    
		                        Long stamp = new Long(strTimestamp);
		                        
		                        
		                        Calendar cal = Calendar.getInstance();
		                        cal.setTimeInMillis(stamp);
		                        int txnYear = cal.get(Calendar.YEAR);
		                        int txnMonth = cal.get(Calendar.MONTH);
		                        txnMonth = txnMonth + 1;
		             //           System.out.println(txnYear);
		            //            System.out.println("mnth"+txnMonth);
		                        if(month != 0 && year != 0) {
		                            if(txnYear == year&& txnMonth ==month) {
		                                isValid = true;
		                        
		                            }else {
		                                isValid = false;
		                            }
		                            
		                        }else {
		                            isValid = true;
		                        } 
		                    
		                }
		                if(isValid==true) {
		                	validlist.add(txn.id);    
		                }
		                
  
		            }
		            return validlist;     
		        	
	
	}
	
}
