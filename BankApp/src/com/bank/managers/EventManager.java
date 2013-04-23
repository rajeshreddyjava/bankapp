package com.hibernate.managers;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.domain.Event;
import com.hibernate.domain.Person;
import com.hibernate.util.HibernateUtil;

public class EventManager {
	public static void main(String[] args) {
		EventManager mgr = new EventManager();
		//if (args[0].equals("store")) {
			//mgr.createAndStoreEvent("Birthday", new Date());
			
			//for (Object obj : mgr.listEvents()){
			//	Event event = (Event)obj;
			//	System.out.println(event.getTitle() + "|" + event.getDate());
				
			//}
			//mgr.createAndStorePerson("Raj", "Katipally", 25);
			mgr.addPersonToEvent(7, 6);
			mgr.addEventToPerson(5, 6);
			
		//mgr.addEmailAddressToPerson(6,"rkatipally@aarp.org");
		//}
		HibernateUtil.getSessionFactory().close();
	}

	private void createAndStoreEvent(String title, Date theDate) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		session.save(theEvent);
		session.getTransaction().commit();
	}
	
	public List listEvents(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List results = session.createQuery("from Event").list();
		session.getTransaction().commit();
		return results;
		
	}
	
	private void createAndStorePerson(String firstName, String lastName, float age){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAge(age);
		session.save(person);
		session.getTransaction().commit();
	}
	
	public void addEventToPerson(long personId, long eventId){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Person aPerson = (Person) session.load(Person.class, personId);// Please refer to session.get()
		Event aEvent = (Event)session.load(Event.class, eventId);
		aPerson.addToEvent(aEvent);
		session.getTransaction().commit();
	}
	public void addPersonToEvent(long personId, long eventId){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Person aPerson = (Person) session.load(Person.class, personId);// Please refer to session.get()
		Event aEvent = (Event)session.load(Event.class, eventId);
		aEvent.getParticipants().add(aPerson);
		session.getTransaction().commit();
	}
	
	public void addEmailAddressToPerson(long personId, String emailAddress){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Person aPerson = (Person)session.load(Person.class, personId);
		aPerson.getEmailAddresses().add(emailAddress);
		session.getTransaction().commit();
	}

}
