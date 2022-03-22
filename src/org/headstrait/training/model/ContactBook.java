package org.headstrait.training.model;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
    private final String contactBookName;
    private final List<Contact> contacts;

    public ContactBook(String contactBookName) {
        this.contactBookName = contactBookName;
        contacts = new ArrayList<>();
    }

    public String getContactBookName() {
        return contactBookName;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     * @param contactName Full Name of the contact i.e. space separated first and last names
     * @return true if contactName exist in the list of contacts else false
     */
    public boolean doesExist(String contactName) {
        boolean doesContactExist = false;
        if (!contacts.isEmpty())
            for (Contact contact :
                    contacts) {
                final String FULL_NAME = contact.getFirstname() +
                        " " +
                        contact.getLastname();
                if (FULL_NAME.toLowerCase()
                        .equals(contactName.toLowerCase())) {
                    doesContactExist = true;
                    break;
                }
            }
        return doesContactExist;
    }


    /**
     *
     * @param contact to be added to the list
     * @return true if the operation is success, false if not.
     */
    public boolean add(Contact contact) {
        final String FULL_NAME = contact.getFirstname() + " " + contact.getLastname();
        if (!doesExist(FULL_NAME)){
            contacts.add(contact);
            return true;
        }
        return false;
    }

    /**
     *
     * @param contactName name of the contact to be removed.
     */
    public boolean remove(String contactName) {
        if (!contacts.isEmpty()) {
            if (doesExist(contactName)) {
                for (int i = 0; i < contacts.size(); i++) {
                    String fullName = contacts.get(i).getFirstname() +
                            " " +
                            contacts.get(i).getLastname();
                    if (fullName.toLowerCase()
                            .equals(contactName.toLowerCase())) {
                        contacts.remove(contacts.get(i));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Contact getContactByName(String fullName){
        if(doesExist(fullName)){
            for (Contact contact:
                    contacts) {
                if(contact.getFullName().equals(fullName))
                    return contact;
            }
        }
        return null;
    }

    /**
     *
     * @param contact updated contact
     * @param contactName name of the contact to be replaced
     */
    public boolean updateContactByName(Contact contact, String contactName){
        if(!contacts.isEmpty()){
            if(doesExist(contactName)){
                remove(contactName);
                Contact tempContact = getContactByName(contactName);
                add(contact);
                return true;
            }
        }
        return false;
    }




}
