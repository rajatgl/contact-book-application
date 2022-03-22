package org.headstrait.training.datastore;

import org.headstrait.training.model.Contact;
import org.headstrait.training.model.ContactBook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {
    List<ContactBook> contactBooks;
    List<Contact> contacts;

    public Cache() {
        contactBooks = new ArrayList<>();
    }

    public void add(ContactBook contactBook){
        contactBooks.add(contactBook);
    }

    public void deleteByName(String contactBookName){
        contactBooks = contactBooks
                .stream()
                .filter(contactBook ->
                        contactBook.getContactBookName()
                                .equals(contactBookName))
                .collect(Collectors.toList());
    }

    public void update(Contact contact, String contactBookName){
        contactBooks = contactBooks
                .stream()
                .peek(contactBook -> {
                    if(contactBook.getContactBookName().equals(contactBookName)
                            && contactBook.getContacts().contains(contact)){

                    }
                })
                .collect(Collectors.toList());
    }



}
