package dto;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@javax.persistence.Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name ;
	String email ;
	long mobile ;
	String password ;
	String gender ;
	LocalDate dob ;
	String address ;
	
	
	
	   
	
}
