package com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.dto.Dataum;
import com.api.dto.Response;
import com.api.model.Payload;
import com.google.gson.Gson;

@Service
public class Check {

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public int getCountries(String s,int p)
	{   
		
		Gson gson = new Gson();
		List<Dataum> list=new ArrayList<Dataum>();
		String Url="https://jsonmock.hackerrank.com/api/countries/search?name="+s;
		 int page=1;
		 int totalpage=1;
		 for(int i=1;i<=totalpage;i++)
		 {
			 String UrlWithPage=Url + "&page=" +  page;
			 System.out.println(UrlWithPage);
		String res = restTemplate.getForObject(UrlWithPage, String.class);
	          Response response = gson.fromJson(res, Response.class);	
	          totalpage=  response.getTotal_pages();
	         
		  for(int j=0;j<response.getData().size();j++)
		  {   
			Dataum dataum = response.getData().get(j);
			list.add(dataum);
			
			
		  }
	          System.out.println(response);
	          page++;
		 }	
		 List<Dataum> valid=new ArrayList<Dataum>();
		 for(int i=0;i<list.size();i++)
		 {
			if(list.get(i).getName().toLowerCase().contains(s) && list.get(i).getPopulation()>p)
			{
	         Dataum dataum = list.get(i);
	         valid.add(dataum);
			}
		 }
		 
	return valid.size();	  
	}
	
}
