package com.scratch.driver;

import com.scratch.address_book.AddressBookEntryProto;
import com.scratch.person.PersonProto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersonWriter {
    public static void main(String[] args) throws IOException {

        PersonProto.Person person = PersonProto.Person.newBuilder()
                .setName("john")
                .setEmail("john@Doe.com")
                .setAddress(
                        PersonProto.Person.Address.newBuilder()
                                .setDoorNo(13)
                                .addStreet("Plaza street")
                                .setCity("Chennai")
                                .build()
                )
                .build();

        System.out.println("DATA OF THE PERSON WRITER: \n" + person);

        FileInputStream fis = new FileInputStream("D:\\ProtobufWorkspace\\AddressBook\\src\\main\\resources\\demo.txt");
        AddressBookEntryProto.AddressBookEntry book = AddressBookEntryProto.AddressBookEntry.parseDelimitedFrom(fis);
        System.out.println(book);
        fis.close();

        if (book==null) {
            System.out.println("file empty creating new object");
            book = book.newBuilder()
                    .setPerson(person)
                    .build();
        }
        else {
            book = book.newBuilder(book)
                    .setPerson(person)
                    .build();
        }
        System.out.println("file content: \n" + book);

        FileOutputStream fos = new FileOutputStream("D:\\ProtobufWorkspace\\AddressBook\\src\\main\\resources\\demo.txt");
        book.writeDelimitedTo(fos);
        fos.close();
    }
}
