package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.model.Payload;
import com.api.model.Transaction;
import com.api.service.AssignmentService;
import com.api.service.Check;
import com.api.service.HomeService;
import com.api.service.ServiceClass;
import com.google.gson.Gson;

@RestController
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HomeService service;

	@Autowired
	private ServiceClass serviceClass;

	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired
	private Check check;

	@GetMapping("/countries")
	public int getCountries(@RequestParam(name = "s") String s, @RequestParam(name = "p") int p) {
		return check.getCountries(s, p);
	}
}
/*
 * @GetMapping("/transaction") public List<Integer>
 * Transaction(@RequestParam(name = "uid") int uid,
 * 
 * @RequestParam(name = "txnType") String txnType,
 * 
 * @RequestParam(name = "monthYear") String monthYear){
 * 
 * return this.service.Transaction( uid, txnType, monthYear); }
 * 
 * @GetMapping("/bank") public List<Integer> getTransaction(@RequestParam(name =
 * "uid") int uid,
 * 
 * @RequestParam(name = "txnType") String txnType,
 * 
 * @RequestParam(name = "monthYear") String monthYear){
 * 
 * return this.serviceClass.getTransaction( uid, txnType, monthYear); }
 * 
 * }
 */
/*
 * String Url = "https://jsonmock.hackerrank.com/api/transactions/search?";
 * 
 * List<Transaction> listAllObj = new ArrayList<Transaction>(); for(int
 * i=0;i<totalPageCount;i++) { String UrlWithPage=Url + "&page=" + page;
 * System.out.println(UrlWithPage); Gson gson = new Gson(); String res=
 * restTemplate.getForObject(UrlWithPage,String.class); System.out.println(res);
 * Payload PayloadObj =gson.fromJson(res, Payload.class);
 * 
 * if(PayloadObj != null && PayloadObj.data!=null){ totalPageCount =
 * PayloadObj.getTotal_pages(); System.out.println(totalPageCount);
 * 
 * for(int j=0;j<PayloadObj.data.size();j++){ Transaction txn =
 * PayloadObj.data.get(j); listAllObj.add(txn); } System.out.println(page); }
 * page++; System.out.println(page); System.out.println(listAllObj);
 * 
 * for(int record=0;record<listAllObj.size();record++){ Transaction txn =
 * listAllObj.get(record); System.out.println(txn.txnType + " : " + txn.amount);
 * } /* return new ResponseEntity<Object>(res,HttpStatus.OK);
 */
// return listAllObj;

//	}
// return null;
//	}
//}
