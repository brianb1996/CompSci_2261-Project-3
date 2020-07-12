package edu.umsl;
/*
* Brian Bredahl
* CMP SCI 2261
* Project 3 - Base 64
*
* Base64 is one of several encoding schemes used to encode binary data in a text based representation
* (ASCII) using a radix-64 representation. Although there are several other variants among them Base16
* and Base32, it is Base64 which is the most prevalent and popular. The need for Base64 arose during the
* advent of email. During which time folks began to speculate with the possibility of using attachments with
* things like images, videos or other binary data. Since STMP (Simple Mail Transfer Protocol) only supported
* 7-bit ASCII characters within the messages, there was a need to be able to encode this binary data and
* convert it into a format that was universally supported without having to affect the current infrastructure
* of email servers and the SMTP protocol.
*
* For this project, we will be using the org.apache.commons.codec.binary.Base64 class from the Apache
* Commons Codec library.  So you will need to pull that dependency into your pom.xml file.
*
* Create a class that does two things:
*       1.) Decode and print out: SSBsb3ZlIG15IENNUCBTQ0kgMjI2MSBjbGFzcyBzbyBtdWNoLCBJIHdpc2ggSSBjb3VsZCBiZSBqdXN0IGFzIGNvb2wgYXMgbXkgcHJvZmVzc29y
*       2.) Takes in a string and Encodes that string then prints to standard output.
*/

import Base_64_Conversion.Translate64;
import java.util.Scanner;

//This class is used to demonstrate how to implement the Translate64 class and
public class TestBase64Conversion {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        String givenText = "SSBsb3ZlIG15IENNUCBTQ0kgMjI2MSBjbGFzcyBzbyBtdWNoLCBJIHdpc2ggSSBjb3VsZCBiZSBqdXN0IGFzIGNvb2wgYXMgbXkgcHJvZmVzc29y";
        String converted;

        System.out.println("\nHere is the Base 64 text provided: \n" + givenText);
        System.out.println("\nHere is the text converted from Base 64");
        System.out.println(Translate64.from64(givenText));
        System.out.println("\nEnter some text below to convert to Base 64: ");
        converted = Translate64.to64(userInput.nextLine());
        System.out.println("\nHere is the text converted to Base 64:\n" + converted);
    }
}
