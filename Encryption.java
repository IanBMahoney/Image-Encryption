package ImageEncryption;

import java.awt.image.BufferedImage;

public class Encryption {
    
    Picture picture;
    String password;
    String message;
    int hash;
    BufferedImage image;
    
    public Encryption(BufferedImage image, String password, String message) {
        this.picture = new Picture(image, true);
        this.password = password;
        this.message = message;
        
//        while (message.length() != 10000) {
//            message += " ";
//        }
        
        calculateHash();
    }
    
    public int[] calculatePixelLocation(int index) {
        int[] location = {0, 0};
        
        location[0] = verifyHash(hash * (index + 1249) * 46091) % picture.getMegaPixels().length;
        location[1] = verifyHash(hash * (index + 2971) * 24859) % picture.getMegaPixels()[0].length;
        
        return location;
    }
    
    public int calculateDummyCharacterValue(int i, int j) {
        return verifyHash((double) hash * (i + 3229) * (j + 2269)) % 100;
        //return verifyHash(hash * (i + 271) * (j + 239)) % 100;
    }
    
    public BufferedImage encryptPicture() {
        message = message.replaceAll(Character.toString((char) 0), "");
        
        for (int i = 0; i <= message.length(); i++) {
            int[] location = calculatePixelLocation(i);
            
            
            
            while (picture.megaPixels[location[0]][location[1]].isSet) {
                location[0]++;
                
                if (location[0] >= picture.megaPixels.length) {
                    location[0] = 0;
                    location[1]++;
                }
                
                if (location[1] >= picture.megaPixels[0].length) {
                    location[1] = 0;
                    
                    for (int j = 0; j < 2; j++) {
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
            
            if (i < message.length()) {
                picture.megaPixels[location[0]][location[1]].character = message.charAt(i);
            } else {
                picture.megaPixels[location[0]][location[1]].character = 0;
            }
            
            if (i < message.length()) {
                System.out.println("Character " + message.charAt(i) + " at index " + i + " is at coordinates " + location[0] + ", " + location[1] + " with RGB of ");
                System.out.println(picture.megaPixels[location[0]][location[1]].original[0] + " " + picture.megaPixels[location[0]][location[1]].original[1] + " " + picture.megaPixels[location[0]][location[1]].original[2]);
                System.out.println(picture.megaPixels[location[0]][location[1]].topRight[0] + " " + picture.megaPixels[location[0]][location[1]].topRight[1] + " " + picture.megaPixels[location[0]][location[1]].topRight[2]);
                System.out.println(picture.megaPixels[location[0]][location[1]].bottomLeft[0] + " " + picture.megaPixels[location[0]][location[1]].bottomLeft[1] + " " + picture.megaPixels[location[0]][location[1]].bottomLeft[2]);
                System.out.println(picture.megaPixels[location[0]][location[1]].bottomRight[0] + " " + picture.megaPixels[location[0]][location[1]].bottomRight[1] + " " + picture.megaPixels[location[0]][location[1]].bottomRight[2]);
                
                
            }
            
            picture.megaPixels[location[0]][location[1]].isSet = true;
        }
        System.out.println("TWO");
        
        
        for (int i = 0; i < picture.getMegaPixels().length; i++) {
            
            
            for (int j = 0; j < picture.getMegaPixels()[0].length; j++) {
                
                
                if (!picture.megaPixels[i][j].isSet) {
                    picture.megaPixels[i][j].character = calculateDummyCharacterValue(i, j);
                }
                
                picture.megaPixels[i][j].disperse();
                
            }
        }
        
        
        picture.megaPixels[0][0].diisperse(message.length());
        
        
        
        
        
        
        
        
        
        
        
        System.out.println("THREE");
        picture.pictureToImage();
        System.out.println("FOUR");
        return picture.image;
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
        hash *= message.length() * 161639;
        
        if (hash < 0) {
            hash *= -1;
        }
        
        if (message.length() % 10 < 5) {
            hash++;
        }
        
        //Makes sure that the hash is large enough and not negative
        hash = verifyHash(hash);
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
    
    public int verifyHash(double number) {
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
        
        return (int) number;
    }
    
}
