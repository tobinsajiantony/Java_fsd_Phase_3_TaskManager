package com.example.TaskManager.models;

public class Message {
   private boolean valid;
   private String data;
   private int id;


public Message(boolean valid, String data) {
	   this.valid = valid;
	   this.data = data;
	   
   }
   
   public Message(boolean valid, String data, int id) {
	   this.valid = valid;
	   this.data = data;
	   this.id = id;
   }

public boolean isValid() {
	return valid;
}

public void setValid(boolean valid) {
	this.valid = valid;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
   
   
}
