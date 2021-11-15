package com.api.model;

import java.util.List;

public class Payload {

	 public Integer page;
	    public int per_page;
	    public int total;
	    public int total_pages;
	    public List<Transaction> data;
		public Integer getPage() {
			return page;
		}
		public void setPage(Integer page) {
			this.page = page;
		}
		public int getPer_page() {
			return per_page;
		}
		public void setPer_page(int per_page) {
			this.per_page = per_page;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public int getTotal_pages() {
			return total_pages;
		}
		public void setTotal_pages(int total_pages) {
			this.total_pages = total_pages;
		}
		public List<Transaction> getData() {
			return data;
		}
		public void setData(List<Transaction> data) {
			this.data = data;
		}
		public Payload(Integer page, int per_page, int total, int total_pages, List<Transaction> data) {
			super();
			this.page = page;
			this.per_page = per_page;
			this.total = total;
			this.total_pages = total_pages;
			this.data = data;
		}
		public Payload() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "JsonResPayload [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
					+ total_pages + ", data=" + data + "]";
		} 
	    
	    
	    
}
