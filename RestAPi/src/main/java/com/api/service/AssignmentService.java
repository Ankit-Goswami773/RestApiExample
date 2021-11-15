package com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.dto.Dataum;
import com.api.dto.Response;
import com.google.gson.Gson;

@Service
public class AssignmentService {

	@Autowired
	private RestTemplate restTemplate;

	public int getCountries(String s, int p) {
		Gson gson = new Gson();
		String url = "https://jsonmock.hackerrank.com/api/countries/search?name=" + s;

		String res = restTemplate.getForObject(url, String.class);
		Response response = gson.fromJson(res, Response.class);
		List<Response> responses = new ArrayList<>();
		responses.add(response);
		Integer total_Pages = response.getTotal_pages();

		for (int i = 2; i < total_Pages; i++) {
			System.out.println("loop");
			String UrlWithPage = url + "&page=" + i;

			String res1 = restTemplate.getForObject(UrlWithPage, String.class);

			Response responseNext = gson.fromJson(res, Response.class);
			responses.add(responseNext);

		}

		int count = (int) responses.stream().flatMap(r -> r.getData().stream())
				.filter(a -> a.getName().toLowerCase().contains(s) && (a.getPopulation() > p)).count();
		System.out.println("count" + count);

		return count;

	}

}
