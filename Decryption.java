package ImageEncryption;

import java.awt.image.BufferedImage;
import static java.lang.Math.abs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author  Ian Mahoney, Alex Truman, Max Clausius
 */
public class Decryption {

    Picture picture;
    String password;
    String message;
    int messageLength;
    int hash;

    public Decryption(BufferedImage image, String password, String message) {
        this.picture = new Picture(image, false);
        System.out.println("one");
        this.password = password;
        System.out.println("two");
        calculateMessageLength();
        System.out.println("three");
        calculateHash();
        System.out.println("four");
    }

    public int[] calculatePixelLocation(int index) {
        int[] location = {0, 0};

        location[0] = verifyHash(hash * (index + 1249) * 46091) % picture.getMegaPixels().length;
        location[1] = verifyHash(hash * (index + 2971) * 24859) % picture.getMegaPixels()[0].length;

        return location;
    }

    public String decryptPicture() {

        calculateMessageLength();
        message = "";

        for (int i = 0; i <= messageLength; i++) {
            int[] location = calculatePixelLocation(i);

            while (picture.megaPixels[location[0]][location[1]].isSet) {
                location[0]++;

                if (location[0] >= picture.megaPixels.length) {
                    location[0] = 0;
                    location[1]++;
                }

                if (location[1] >= picture.megaPixels[0].length) {
                    location[1] = 0;

                    for (int j = 0; j < 5; j++) {
                        location[0]++;

                        if (location[0] >= picture.megaPixels.length) {
                            location[0] = 0;
                            location[1]++;

                            if (location[1] >= picture.megaPixels[0].length) {
                                System.out.println("infinite loop error");
                                return null;
                            }
                        }
                    }
                }
            }

            if (i < messageLength) {
                picture.megaPixels[location[0]][location[1]].assemble();
                message += (char) picture.megaPixels[location[0]][location[1]].character;//issue (calling a zero from the MegaPixel Class
                //System.out.println("Character " + message.charAt(i) + " at index " + i + " is at coordinates " + location[0] + ", " + location[1] + " with RGB of ");
                //System.out.println(picture.megaPixels[location[0]][location[1]].original[0] + " " + picture.megaPixels[location[0]][location[1]].original[1] + " " + picture.megaPixels[location[0]][location[1]].original[2]);
               // System.out.println(picture.megaPixels[location[0]][location[1]].topRight[0] + " " + picture.megaPixels[location[0]][location[1]].topRight[1] + " " + picture.megaPixels[location[0]][location[1]].topRight[2]);
                //System.out.println(picture.megaPixels[location[0]][location[1]].bottomLeft[0] + " " + picture.megaPixels[location[0]][location[1]].bottomLeft[1] + " " + picture.megaPixels[location[0]][location[1]].bottomLeft[2]);
                //System.out.println(picture.megaPixels[location[0]][location[1]].bottomRight[0] + " " + picture.megaPixels[location[0]][location[1]].bottomRight[1] + " " + picture.megaPixels[location[0]][location[1]].bottomRight[2]);

            } else {
                if (picture.megaPixels[location[0]][location[1]].character == (char) 0) {
                    System.out.println("password is not correct or image is not encrypted error");
                }
            }

            picture.megaPixels[location[0]][location[1]].isSet = true;
        }

        return message;
        /*
        for (int i = 0; i <= messageLength; i++) {
            int[] location = calculatePixelLocation(i);
            picture.megaPixels[location[0]][location[1]].assemble();
            message += picture.megaPixels[location[0]][location[1]].character;
        }*/
    }

    public void calculateMessageLength() {
        messageLength = 5;
         int[] original = picture.megaPixels[0][0].original;
         int[] topRight = picture.megaPixels[0][0].topRight;
         int[] bottomRight = picture.megaPixels[0][0].bottomRight;
         int[] bottomLeft = picture.megaPixels[0][0].bottomLeft;
         int character = picture.megaPixels[0][0].character;
        if (original[1] + (character / 16384) > 255) {
            character += abs((original[1]-bottomRight[1]) * 16384);
        } else {
            character += abs((bottomRight[1] - original[1]) * 16384);
        }
        if (original[0] + (character / 4096) > 255) {
            character += abs((original[0]-bottomRight[0]) * 4096);
        } else {
            character += abs((bottomRight[0] - original[0]) * 4096);

        }
        if (original[2] + (character / 1024) > 255) {
            character += abs((original[2]-bottomLeft[2]) * 1024);
        } else {
            character += abs((bottomLeft[2] - original[2]) * 1024);
        }
        if (original[1] + (character / 256) > 255) {
            character += abs((original[1]-bottomLeft[1]) * 256);
        } else {
            character += abs((bottomLeft[1] - original[1]) * 256);

        }
        if (original[0] + (character / 64) > 255) {
            character += abs((original[0]-bottomLeft[0]) * 64);
        } else {
            character += abs((bottomLeft[0] - original[0]) * 64);

        }
        if (original[2] + (character / 16) > 255) {
            character += abs((original[2]-topRight[2]) * 16);
        } else {
            character += abs((topRight[2] - original[2]) * 16);
        }
        if (original[1] + (character / 4) > 255) {
            character += abs((original[1]-topRight[1]) * 4);
        } else {
            character += abs((topRight[1] - original[1]) * 4);
        }
        if (original[0] + character > 255) {
            character += abs(original[0]-topRight[0]);
        } else {
            character += abs(topRight[0] - original[0]);
        }
        System.out.println(character);
        messageLength = character;
        
    }

    public void calculateHash() {
        //Start off the creation of the hash with a prime number so that hash replication is scarce
        hash = 869819;

        //Goes through the password, further changing the hash
        for (char character : password.toCharArray()) {
            switch (character % 3) {
                case 0:
                    hash += character;
                    break;
                case 1:
                    hash *= character;
                    break;
                case 2:
                    hash -= character;
                    break;
            }

            switch (character % 5) {
                case 0:
                    hash += character * 193;
                    break;
                case 1:
                    hash += character * 281;
                    break;
                case 2:
                    hash *= character * 521;
                    break;
                case 3:
                    hash *= character * 827;
                    break;
                case 4:
                    hash -= character * 137;
                    break;
            }
        }

        //Incorporates the message length in hash creation
        hash *= messageLength * 161639;

        if (hash < 0) {
            hash *= -1;
        }

        if (messageLength % 10 < 5) {
            hash++;
        }

        //Makes sure that the hash is large enough and not negative
        hash = verifyHash(hash);

        this.hash = hash;
    }

    public int verifyHash(int number) {
        while (number < 1000000) {
            if (number < 0) {
                number *= -1;
            } else if (number == 0) {
                if (message.length() == 0) {
                    number = 250739;
                } else {
                    number = 205739 * message.length();
                }
            } else {
                number += 393103;
            }
        }

        return number;
    }

}
