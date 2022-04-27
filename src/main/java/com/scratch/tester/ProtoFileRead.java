package com.scratch.tester;

import com.scratch.address_book.AddressBookEntryProto;

import java.io.FileInputStream;
import java.io.IOException;

public class ProtoFileRead {
    public static void main(String[] args) throws IOException {
        AddressBookEntryProto.AddressBookEntry book = AddressBookEntryProto.AddressBookEntry.parseDelimitedFrom(new FileInputStream("D:\\ProtobufWorkspace\\AddressBook\\src\\main\\resources\\demo.txt"));
        System.out.println(book);
    }
}
