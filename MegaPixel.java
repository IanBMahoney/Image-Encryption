package ImageEncryption;

import java.awt.Color;
import static java.lang.Math.*;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class MegaPixel {

    int[] original = {0, 0, 0};
    int[] topRight = new int[3];
    int[] bottomLeft = new int[3];
    int[] bottomRight = new int[3];
    boolean isSet = false;
    int character = 0;   //numerical value of character being dispersed

    
    public void diisperse(int messageLength) {

        bottomRight[2] = original[2];

        if (original[1] + (messageLength / 16384) > 255) {
            bottomRight[1] = abs(original[1] - (messageLength / 16384));
            messageLength %= 16384;
        } else {
            bottomRight[1] = abs(original[1] + (messageLength / 16384));
            messageLength %= 16384;
        }
        if (original[0] + (messageLength / 4096) > 255) {
            bottomRight[0] = abs(original[0] - (messageLength / 4096));
            messageLength %= 4096;
        } else {
            bottomRight[0] = abs(original[0] + (messageLength / 4096));
            messageLength %= 4096;
        }
        if (original[2] + (messageLength / 1024) > 255) {
            bottomLeft[2] = abs(original[2] - (messageLength / 1024));
            messageLength %= 1024;
        } else {
            bottomLeft[2] = abs(original[2] + (messageLength / 1024));
            messageLength %= 1024;
        }
        if (original[1] + (messageLength / 256) > 255) {
            bottomLeft[1] = abs(original[1] - (messageLength / 256));
            messageLength %= 256;
        } else {
            bottomLeft[1] = abs(original[1] + (messageLength / 256));
            messageLength %= 256;
        }
        if (original[0] + (messageLength / 64) > 255) {
            bottomLeft[0] = abs(original[0] - (messageLength / 64));
            messageLength %= 64;
        } else {
            bottomLeft[0] = abs(original[0] + (messageLength / 64));
            messageLength %= 64;
        }
        if (original[2] + (messageLength / 16) > 255) {
            topRight[2] = abs(original[2] - (messageLength / 16));
            messageLength %= 16;
        } else {
            topRight[2] = abs(original[2] + (messageLength / 16));
            messageLength %= 16;
        }
        if (original[1] + (messageLength / 4) > 255) {
            topRight[1] = abs(original[1] - (messageLength / 4));
            messageLength %= 4;
        } else {
            topRight[1] = abs(original[1] + (messageLength / 4));
            messageLength %= 4;
        }
        if (original[0] + messageLength > 255) {
            topRight[0] = abs(original[0] - messageLength);
            messageLength %= 1;
        } else {
            topRight[0] = abs(original[0] + messageLength);
            character %= 1;
            //colors for pixels set by Max

        }
    }
    
    
    public void disperse() {

        bottomRight[2] = original[2];

        if (original[1] + (character / 16384) > 255) {
            bottomRight[1] = original[1] - (character / 16384);
            character %= 16384;
        } else {
            bottomRight[1] = original[1] + (character / 16384);
            character %= 16384;
        }
        if (original[0] + (character / 4096) > 255) {
            bottomRight[0] = original[0] - (character / 4096);
            character %= 4096;
        } else {
            bottomRight[0] = original[0] + (character / 4096);
            character %= 4096;
        }
        if (original[2] + (character / 1024) > 255) {
            bottomLeft[2] = original[2] - (character / 1024);
            character %= 1024;
        } else {
            bottomLeft[2] = original[2] + (character / 1024);
            character %= 1024;
        }
        if (original[1] + (character / 256) > 255) {
            bottomLeft[1] = original[1] - (character / 256);
            character %= 256;
        } else {
            bottomLeft[1] = original[1] + (character / 256);
            character %= 256;
        }
        if (original[0] + (character / 64) > 255) {
            bottomLeft[0] = original[0] - (character / 64);
            character %= 64;
        } else {
            bottomLeft[0] = original[0] + (character / 64);
            character %= 64;
        }
        if (original[2] + (character / 16) > 255) {
            topRight[2] = original[2] - (character / 16);
            character %= 16;
        } else {
            topRight[2] = original[2] + (character / 16);
            character %= 16;
        }
        if (original[1] + (character / 4) > 255) {
            topRight[1] = original[1] - (character / 4);
            character %= 4;
        } else {
            topRight[1] = original[1] + (character / 4);
            character %= 4;
        }
        if (original[0] + character > 255) {
            topRight[0] = original[0] - character;
            character %= 1;
        } else {
            topRight[0] = original[0] + character;
            character %= 1;
            //colors for pixels set by Max

        }
    }

    public void assemble() {
//combines character differences and sets character to be that total

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

    }

}
