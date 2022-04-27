package com.scratch.driver;

import com.scratch.address_book.AddressBookEntryProto;
import com.scratch.contact.ContactProto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ContactWriter {
    public static void main(String[] args) throws IOException {
        ContactProto.Contact contact = ContactProto.Contact.newBuilder()
                .addPhones(
                        ContactProto.Contact.PhoneNumber.newBuilder()
                                .setNumber("324445356")
                                .setType(ContactProto.Contact.PhoneType.MOBILE)
                                .build()
                )
                .build();

        System.out.println("CONTACT WRITER DATA: \n" + contact);

        FileInputStream fis = new FileInputStream("D:\\ProtobufWorkspace\\AddressBook\\src\\main\\resources\\demo.txt");

        AddressBookEntryProto.AddressBookEntry book = AddressBookEntryProto.AddressBookEntry.parseDelimitedFrom(fis);
        System.out.println("object read from file: " + book);
        fis.close();


        if (book == null) {
            System.out.println("file empty creating new object");
            book = AddressBookEntryProto.AddressBookEntry.newBuilder()
                    .setContact(contact)
                    .build();
        }
        else {
            book = book.newBuilder(book)
                    .setContact(contact)
                    .build();
        }
        System.out.println("file content: \n" + book);

        FileOutputStream fos = new FileOutputStream("D:\\ProtobufWorkspace\\AddressBook\\src\\main\\resources\\demo.txt");
        book.writeDelimitedTo(fos);
        fos.close();
    }
}
