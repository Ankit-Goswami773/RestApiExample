package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.model.Payload;
import com.api.model.Transaction;
import com.google.gson.Gson;

@Service
public class ServiceClass {

	
	 @Autowired
	private RestTemplate restTemplate; 
	
	public List getTransaction(int uid, String txnType, String monthYear)
	{  
		
		int month = 0;
		Gson gson=new Gson();
		List<Transaction> list=new ArrayList<Transaction>();
		 String Url = "https://jsonmock.hackerrank.com/api/transactions/search?userId=";
		if(uid>0)
		{
			Url=Url+uid;
		}
		 int page=1;
		 int totalpage=1;
		 for(int i=1;i<=totalpage;i++)
		 {
			 String UrlWithPage=Url + "&page=" + page;
		 String response = restTemplate.getForObject(UrlWithPage,String.class);
		Payload payload = gson.fromJson(response,Payload.class);
		 totalpage=payload.getTotal_pages();
				
            for(int j=0;j<payload.data.size();j++){
                Transaction txn = payload.data.get(j);
                list.add(txn);
       }    
			
		 page++;
		 }
		
      if(txnType!="" && monthYear!="") {
    int	month1=Integer.parseInt(monthYear.substring(0,2));
    int	year=Integer.parseInt(monthYear.substring(3));
     double average = list.stream().filter(s->(s.txnType.equals("debit") && (s.month()== month1  && s.year()== year)))
     .map(data->data.parseAmoutn()).collect(Collectors.toList()).stream().mapToDouble(a->a).average().orElse(0.0);	
    	
  List<Integer> valid = list.stream().filter(s->(s.txnType.equals("debit") && (s.month()== month1  && s.year()== year) && (s.parseAmoutn()>average)))
  .map(a->a.getId()).collect(Collectors.toList());
     
     return valid;
      }
     else
     {
    	 if(txnType=="" && monthYear=="")
    	 {
    	
  return  list.stream().filter(s->s.txnType.equals("debit")).map(a->a.getId()).collect(Collectors.toList());	
    	
    	 }
    	 
     if(txnType!="" ) {
  
 double average = list.stream().filter(s->(s.txnType.equals(txnType)))
      .map(data->data.parseAmoutn()).collect(Collectors.toList()).stream().mapToDouble(a->a).average().orElse(0.0);	
    	    	
List<Integer> valid = list.stream().filter(s->(s.txnType.equals(txnType)  && (s.parseAmoutn()>average)))
   .map(a->a.getId()).collect(Collectors.toList());
    	     
     
     return valid;
     }
    
      } 
		 
		 
		 
		 return null;
	}
	
}
