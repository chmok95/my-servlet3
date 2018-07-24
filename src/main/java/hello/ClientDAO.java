package hello;

 
import org.hibernate.HibernateException; 
import org.hibernate.query.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction; 


public class ClientDAO {     
	private Session session;    
	public ClientDAO(Session session) {      this.session = session;    }    
	public Client getClient(String name) {        
		Client client = null;        
			try {
				 @SuppressWarnings("unchecked")
				 Query<Client> query = session.getNamedQuery("findClientByName");            
				 query.setParameter("name", name);            
				 client = (Client) query.uniqueResult();            
				 System.out.println(client);        
				} catch (HibernateException e) {            
					e.printStackTrace();        
				}        
				return client;    
			}    
			public boolean clientExists(String name) {        
				Client client = null;        
				try {            
					@SuppressWarnings("rawtypes")
					Query query = session.getNamedQuery("findClientByName");            
					query.setParameter("name", name);            
					client = (Client) query.uniqueResult();        
					} catch (HibernateException e) {            
						e.printStackTrace();        
						}        
				return client != null;    
				}    
			
			public void addClient(Client client) {        
				Transaction t = null;        
				try {            
					t = session.beginTransaction();            
					session.save(client);            
					t.commit();        
					} catch (HibernateException e) {            
						e.printStackTrace();            
						t.rollback();        
						}    
				}    
			public void deleteStudent(Client client) {        
				Transaction t = null;        
				try {            
					t = session.beginTransaction();           
					session.delete(client);            
					t.commit();        
					} catch (HibernateException e) {            
						e.printStackTrace();            
						t.rollback();        
						}    
				}    
			public void updateClient(Client client) {        
				Transaction t = null;        
				try {            
					t = session.beginTransaction();            
					session.update(client);            
					t.commit();        
					} catch (HibernateException e) {  
						e.printStackTrace();            
						t.rollback();        
						}    
				} 
			}