package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.udemy.controller.ContactController;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

@Component("contactConverter") 
public class ContactConverter {

	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	
	public Contact convertContactModel2Contact(ContactModel contactModel){
		Contact contact = new Contact();
		contact.setFirstName(contactModel.getFirstName());
		contact.setLastName(contactModel.getLastName());
		contact.setTelephone(contactModel.getTelephone());
		contact.setCity(contactModel.getCity());
		contact.setId(contactModel.getId());
		return contact;
	}
	
	public ContactModel convertContact2ContactModel(Contact contact){
		ContactModel contactModel = new ContactModel();
		contactModel.setFirstName(contact.getFirstName());
		contactModel.setLastName(contact.getLastName());
		contactModel.setTelephone(contact.getTelephone());
		contactModel.setCity(contact.getCity());
		contactModel.setId(contact.getId());
		return contactModel;
	}
	
}
