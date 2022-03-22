package org.headstrait.training.service;

import org.headstrait.training.model.Contact;
import org.headstrait.training.model.ContactBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactBookService {

    Set<String> contactBookNames;
    List<ContactBook> contactBooks;

    public ContactBookService(Set<String> contactBookNames) {
        this.contactBookNames = contactBookNames;
        contactBooks = new ArrayList<>();
        for (String contactBookName:
             contactBookNames) {
            ContactBook contactBook = new ContactBook(contactBookName);
            contactBooks.add(contactBook);
        }
    }

    public Set<String> getContactBookNames() {
        return contactBookNames;
    }

    public List<ContactBook> getContactBooks() {
        return contactBooks;
    }

    /**
     *
     * @param name of the contact book to be fetched.
     * @return the contact book
     */
    public ContactBook getContactBookByName(String name){
       if(!contactBooks.isEmpty()) {
               for (ContactBook contactBook : contactBooks) {
                   if (contactBook.getContactBookName().toLowerCase().equals(name.toLowerCase())){
                       return contactBook;
                   }
               }
       }
       return null;
    }

    /**
     *
     * @param contact to the added to the contact book.
     * @param contactBookName name of the contact book
     * @return true if the operation is successful and false if not.
     */
    public boolean addContact(Contact contact, String contactBookName){
        //get the contact book and then add the required contact.
        ContactBook contactBook = getContactBookByName(contactBookName);
        return contactBook.add(contact);
    }

    /**
     *
     * @param fullName name of the contact to be deleted.
     * @param contactBookName name of the contact book.
     * @return true if operation is successful and false if not
     */
    public boolean deleteContact(String fullName, String contactBookName){
        //get the contact book and remove the required contact.
        ContactBook contactBook = getContactBookByName(contactBookName);
        return contactBook.remove(fullName);
    }

    /**
     *
     * @param updatedContact updated contact
     * @param contactBookName name of the contact book
     * @return true if opreation is successful, false if not
     */
    public boolean updateContact(Contact updatedContact, String contactBookName){
        ContactBook contactBook = getContactBookByName(contactBookName);
        return contactBook.updateContactByName(updatedContact, updatedContact.getFullName());
    }


}
