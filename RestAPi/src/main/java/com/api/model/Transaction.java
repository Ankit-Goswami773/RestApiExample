package com.api.model;

import java.util.Calendar;

public class Transaction {
	
	 public int id;
	    public int userId;
	    public String userName;
	    public String timestamp;
	    public String txnType;
	    public String amount;
	    public Location location;
	    public String ip;
	    
	    
	    public int month() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.parseLong(timestamp));
			int month = calendar.get(Calendar.MONTH) + 1;
			return month;
		}

		public int year() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.parseLong(timestamp));
			return calendar.get(Calendar.YEAR);
		}
		public double parseAmoutn()
		{
			String strAmount =amount;            	
        	strAmount = strAmount.replace("$","");
            strAmount = strAmount.replace(",","");
		double parseDouble = Double.parseDouble(strAmount);
	return parseDouble;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getTxnType() {
			return txnType;
		}
		public void setTxnType(String txnType) {
			this.txnType = txnType;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public Transaction(int id, int userId, String userName, String timestamp, String txnType, String amount,
				Location location, String ip) {
			super();
			this.id = id;
			this.userId = userId;
			this.userName = userName;
			this.timestamp = timestamp;
			this.txnType = txnType;
			this.amount = amount;
			this.location = location;
			this.ip = ip;
		}
		public Transaction() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Transaction [id=" + id + ", userId=" + userId + ", userName=" + userName + ", timestamp="
					+ timestamp + ", txnType=" + txnType + ", amount=" + amount + ", location=" + location + ", ip="
					+ ip + "]";
		}     
	 
	 
}
