package hello;

import java.io.Serializable; 
import java.util.Set; 
import javax.persistence.*; 
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity 
@Table(name = ("client")) 
@NamedQuery(name="findClientByName",   
					query="select s from Client s where s.name = :name")
public class Client implements Serializable {    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id    
	@GenericGenerator(name="auto_inc", strategy = "increment")    
	@GeneratedValue(generator="auto_inc") 
	@Column(name = "id")    
	private Long id;    
	
	@Column(name = "name")    
	private String name;
	

	@Column(name = "phone")    
	private int phone;  
	
	public Client() {    }    
	public Client(String name) {        
		this.name = name;    
	}
	public Client(Long id, String name) {        
		this.id = id;        
		this.name = name;    
	}   
	public Long getId() {        
		return id;   
	}    
	protected void setId(Long id) {        
		this.id = id;    
	}    
	public String getName() {        
		return name;    
	}    
	public void setTitle(String name) {        
		this.name = name;   
	}      
	
	
	@Override    
	public String toString() {        
		return "Client{" + "id=" + id + ", name=" + name + ", phone=" + phone + '}';    
	} 
}

