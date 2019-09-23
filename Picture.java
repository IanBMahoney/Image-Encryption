package ImageEncryption;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Max
 */
class Picture {
    
    MegaPixel[][] megaPixels;
    BufferedImage image;
    //boolean imageExists = false;
    boolean isEncryption;
    
    public Picture(BufferedImage image, boolean isEncryption) {
        this.image = image;
        
        if (isEncryption) {
            encryptionImageToPicture();
        } else {
            decryptionImageToPicture();
        }
    }
    
    public void decryptionImageToPicture() {
        megaPixels = new MegaPixel[image.getWidth() / 2][image.getHeight() / 2];
        
        for (int i = 0; i < image.getWidth() / 2; i++) {
            for (int j = 0; j < image.getHeight() / 2; j++) {
                megaPixels[i][j] = new MegaPixel();
                megaPixels[i][j].original[0] = (new Color(image.getRGB(i * 2, j * 2))).getRed();
                megaPixels[i][j].original[1] = (new Color(image.getRGB(i * 2, j * 2))).getGreen();
                megaPixels[i][j].original[2] = (new Color(image.getRGB(i * 2, j * 2))).getBlue();
                
                megaPixels[i][j].topRight[0] = (new Color(image.getRGB(i * 2 + 1, j * 2))).getRed();
                megaPixels[i][j].topRight[1] = (new Color(image.getRGB(i * 2 + 1, j * 2))).getGreen();
                megaPixels[i][j].topRight[2] = (new Color(image.getRGB(i * 2 + 1, j * 2))).getBlue();
                
                megaPixels[i][j].bottomLeft[0] = (new Color(image.getRGB(i * 2, j * 2 + 1))).getRed();
                megaPixels[i][j].bottomLeft[1] = (new Color(image.getRGB(i * 2, j * 2 + 1))).getGreen();
                megaPixels[i][j].bottomLeft[2] = (new Color(image.getRGB(i * 2, j * 2 + 1))).getBlue();
                
                megaPixels[i][j].bottomRight[0] = (new Color(image.getRGB(i * 2 + 1, j * 2 + 1))).getRed();
                megaPixels[i][j].bottomRight[1] = (new Color(image.getRGB(i * 2 + 1, j * 2 + 1))).getGreen();
                megaPixels[i][j].bottomRight[2] = (new Color(image.getRGB(i * 2 + 1, j * 2 + 1))).getBlue();
                
            }
        }
    }
    
    public void pictureToImage() {
        try {
            BufferedImage image = new BufferedImage(megaPixels.length * 2, megaPixels[0].length * 2, BufferedImage.TYPE_INT_RGB);
            System.out.println(image.getWidth() + " " + image.getHeight());
            for (int i = 0; i < megaPixels.length; i++) {
                for (int j = 0; j < megaPixels[0].length; j++) {
                    image.setRGB(i * 2, j * 2, (new Color(megaPixels[i][j].original[0], megaPixels[i][j].original[1], megaPixels[i][j].original[2])).getRGB());
                    image.setRGB(i * 2 + 1, j * 2, (new Color(megaPixels[i][j].topRight[0], megaPixels[i][j].topRight[1], megaPixels[i][j].topRight[2])).getRGB());
                    image.setRGB(i * 2, j * 2 + 1, (new Color(megaPixels[i][j].bottomLeft[0], megaPixels[i][j].bottomLeft[1], megaPixels[i][j].bottomLeft[2])).getRGB());
                    image.setRGB(i * 2 + 1, j * 2 + 1, (new Color(megaPixels[i][j].bottomRight[0], megaPixels[i][j].bottomRight[1], megaPixels[i][j].bottomRight[2])).getRGB());
                }
            }
            
            this.image = image;
        } catch (Exception e) {
            
        }
    }
    
    public void encryptionImageToPicture() {
        megaPixels = new MegaPixel[image.getWidth()][image.getHeight()];
        
        for (int j = 0; j < image.getHeight(); j++) {
            for (int i = 0; i < image.getWidth(); i++) {
                megaPixels[i][j] = new MegaPixel();
                megaPixels[i][j].original[0] = (new Color(image.getRGB(i, j))).getRed();
                megaPixels[i][j].original[1] = (new Color(image.getRGB(i, j))).getGreen();
                megaPixels[i][j].original[2] = (new Color(image.getRGB(i, j))).getBlue();//have rgb value set and do conversion on the spot to take up 1/3 of the processing time i think
            }
        }
    }
    
    public MegaPixel[][] getMegaPixels() {
        return this.megaPixels;
    }
    
}
