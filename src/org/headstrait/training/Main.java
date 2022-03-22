package org.headstrait.training;

import org.headstrait.training.model.Contact;
import org.headstrait.training.model.ContactBook;
import org.headstrait.training.model.builder.ContactBuilder;
import org.headstrait.training.service.ContactBookService;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Contact createContact(){
        System.out.println("Enter first name of the contact: ");
        String firstName = scanner.next();
        System.out.println("Enter last name of the contact: ");
        String lastName = scanner.next();
        System.out.println("Enter phone number: ");
        Long phone = scanner.nextLong();
        ContactBuilder contactBuilder = new ContactBuilder(firstName,lastName,phone);

        //optional fields
        System.out.println("Enter the address: ");
        String address = scanner.next();
        System.out.println("Enter the city: ");
        String city = scanner.next();
        System.out.println("Enter the state: ");
        String state = scanner.next();
        System.out.println("Enter the postal code: ");
        Integer zip = scanner.nextInt();
        System.out.println("Enter email: ");
        String email = scanner.next();
        contactBuilder.address(address).city(city).state(state).zip(zip).email(email);

        return contactBuilder.build();

    }
    public static void main(String[] args) {

        HashSet<String> contactBookNames = new HashSet<>();
        boolean loop = true;

        System.out.println("Enter the number of contact books to be created.");
        int count = scanner.nextInt();

        while (count>0){
            System.out.println("Enter a name for contact book.");
            String contactBookName = scanner.next();
            contactBookNames.add(contactBookName);
            count--;
        }

        //initialize the contact book service
        ContactBookService contactBookService = new ContactBookService(contactBookNames);

        while (loop){
            System.out.println("Enter an integer to choose one of the below option: ");
            System.out.print("1: Add a contact\n2: Delete a contact\n3: Update a contact\n"
                    +"4: Create new contact book\\s\n5: Show available contact book\\s\n"
                    +"6: Show all contacts\n7: Exit Application\n");
            int choice = scanner.nextInt();
            String contactBookName;
            ContactBook contactBook;
            switch (choice){
                case 1:
                    System.out.println("Enter contact book name: ");
                    contactBookName = scanner.next();
                    Contact contact = createContact();
                    contactBookService.addContact(contact,contactBookName);
                    System.out.println(contactBookService.getContactBookByName(contactBookName).getContacts());
                    break;
                case 2:
                    System.out.println("Enter contact book name: ");
                    contactBookName = scanner.next();
                    System.out.println("Enter first name of the contact: ");
                    String firstName = scanner.next();
                    System.out.println("Enter last name of the contact: ");
                    String lastName = scanner.next();
                    contactBookService.deleteContact(firstName+" "+lastName ,contactBookName);
                    break;
                case 3:
                    System.out.println("Enter contact book name: ");
                    contactBookName = scanner.next();
                    Contact updatedContact = createContact();
                    contactBookService.updateContact(updatedContact,contactBookName);
                    break;
                case 4:
                    System.out.println("Enter a name for new contact book: ");
                    contactBookName = scanner.next();
                    contactBook = new ContactBook(contactBookName);
                    contactBookService.getContactBooks().add(contactBook);
                    break;
                case 5:
                    System.out.println(contactBookService.getContactBookNames());
                    break;
                case 6:
                    System.out.println("Enter contact book name: ");
                    String name = scanner.next();
                    contactBook = contactBookService.getContactBookByName(name);
                    System.out.println(contactBook.getContacts());
                    break;
                case 7:
                    System.out.println("Exiting the application....");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice. Exiting the application....");
                    loop = false;
            }
        }

    }
}
