package ca.sheridancollege.beans;

import java.io.Serializable;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor 
@AllArgsConstructor 
@Data
public class Book implements Serializable{

	private static final long serialVersionUID = 795920495289985626L;
		private int id;
		private String title;
		private String author;
		private double price;
		private int invQuant;
		private String store;
		private String courses = "Prog_Java Prog_Net Prog_Data";

		
		private String [] stores = {"Oakville", "Mississauga", "Brampton"};
	}

 
