package Base_64_Conversion;

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

import org.apache.commons.codec.binary.Base64;

//  The Translate 64 class is used to convert Strings and bytes, from and into Base 64,
//  which are then returned as a string. The class accepts input through the from64 and to64
//  methods. The from64 methods take input and convert the input from Base 64 into standard
//  text. The to64 methods take input and convert input from standard text to Base 64.

public class Translate64 {
    // The constructor was made private so that no objects of the Translate class could be created
    private Translate64() {}
    //from64 - accepts byte array in Base 64 as argument, returns String in Standard English
    public static String from64(byte[] octet){
        if (Base64.isBase64(octet)) {
            return byteToString(Base64.decodeBase64(octet));
        }
        return null;
    }
    //from64 - accepts string in Base 64 as argument, returns String in Standard English
    public static String from64(String fromUser) {
        if (!(fromUser.isEmpty())) {
            // byteToString accepts an array of bytes as its argument and converts it to a String
            // Base64.decodeBase64() accepts a string in Base64 as an argument and returns it as a array of bytes
            return byteToString(Base64.decodeBase64(fromUser));
        }
        return null;
    }
    //to64 - accepts a string in Standard English and returns a String in Base 64
    public static String to64(String fromUser){
        // if the string is not empty and is compatible with Base 64
        if(!(fromUser.isEmpty()) && Base64.isBase64(fromUser)){
            //byteCode stores the reference to the array of bytes returned from stringToByte
            //the to64 method that accepts an array of bytes in called and the byteCode is passed to the method
            byte[] byteCode = stringToByte(fromUser);
            return to64(byteCode);
        }
        return "Error: The text you entered is not compatible with Base 64";

    }
    //to64 - accepts a array of bytes a argument and returns a string in Base 64
    public static String to64(byte[] octet){
        // if the array of bytes is compatible with Base 64
        if (Base64.isBase64(octet)) {
            // calls on byteToString to convert the array of bytes to a String
            //Base64.encodeBase64() accepts a array of bytes and returns a array of bytes in Base 64
            return byteToString(Base64.encodeBase64(octet));
        }
        return null;
    }
    //stringToByte - accepts a string its argument and converts it to a array of bytes
    private static byte[] stringToByte(String input){
        if(!(input.isEmpty())){
            byte[] byteCode = new byte[input.length()];
            for(int i = 0; i < input.length(); i++){
                byteCode[i] = (byte)(input.charAt(i));
            }
            return byteCode;
        }
        return null;
    }
    //byteToString - accepts a array of bytes as its argument and converts tha array into a String.
    private static String byteToString(byte[] byteCode){
        return new String(byteCode);
    }
}

