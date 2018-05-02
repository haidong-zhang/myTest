package com.haidong.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Student {
	    private int id;  
	    private String name;
	    private String email;  
	    private List<String> address;  
	    public void setAddress(List<String> address) {
			this.address = address;
		}

		private Birthday birthday;  
	    private Date registDate;  
	      
	    public Date getRegistDate() {  
	        return registDate;  
	    }  
	  
	    public void setRegistDate(Date registDate) {  
	        this.registDate = registDate;  
	    }  
	  
	    public int getId() {  
	        return id;  
	    }  
	  
	    public void setId(int id) {  
	        this.id = id;  
	    }  
	  
	    public String getName() {  
	        return name;  
	    }  
	  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	  
	    public String getEmail() {  
	        return email;  
	    }  
	  
	    public void setEmail(String email) {  
	        this.email = email;  
	    }  
	  
	    public Birthday getBirthday() {  
	        return birthday;  
	    }  
	  
	    public void setBirthday(Birthday birthday) {  
	        this.birthday = birthday;  
	    }  
	  
	    // getter¡¢setter  
	    public String toString() {  
	        return this.name + "#" + this.id + "#" + this.address + "#"  
	                + this.birthday + "#" + this.email;  
	    }  
	}  
