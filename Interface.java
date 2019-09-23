package ImageEncryption;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Interface extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    boolean encrypting = true;
    BufferedImage image = null;
    File file;

    public Interface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputPanel = new javax.swing.JPanel();
        chooseImageButton = new javax.swing.JLabel();
        saveLocationButton = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        encryptingButton = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        outputPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        dragLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(750, 575));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputPanel.setBackground(new java.awt.Color(41, 41, 41));
        inputPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        chooseImageButton.setBackground(new java.awt.Color(41, 41, 41));
        chooseImageButton.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        chooseImageButton.setForeground(new java.awt.Color(102, 102, 255));
        chooseImageButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseImageButton.setText("Choose Image");
        chooseImageButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        chooseImageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseImageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseImageButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseImageButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chooseImageButtonMouseReleased(evt);
            }
        });

        saveLocationButton.setBackground(new java.awt.Color(41, 41, 41));
        saveLocationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        saveLocationButton.setForeground(new java.awt.Color(102, 102, 255));
        saveLocationButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saveLocationButton.setText("Save Destination");
        saveLocationButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveLocationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveLocationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveLocationButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveLocationButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saveLocationButtonMouseReleased(evt);
            }
        });

        imageLabel.setBackground(new java.awt.Color(41, 41, 41));
        imageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        encryptingButton.setBackground(new java.awt.Color(41, 41, 41));
        encryptingButton.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        encryptingButton.setForeground(new java.awt.Color(102, 102, 255));
        encryptingButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        encryptingButton.setText("Mode: Encryption");
        encryptingButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        encryptingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        encryptingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encryptingButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                encryptingButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                encryptingButtonMouseReleased(evt);
            }
        });

        passwordTextField.setBackground(new java.awt.Color(51, 51, 51));
        passwordTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        passwordTextField.setForeground(new java.awt.Color(102, 102, 255));
        passwordTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Password:");

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                        .addComponent(chooseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveLocationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addComponent(encryptingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addComponent(encryptingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chooseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveLocationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        inputPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chooseImageButton, saveLocationButton});

        getContentPane().add(inputPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 730, 180));

        outputPanel.setBackground(new java.awt.Color(41, 41, 41));
        outputPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        messageTextArea.setBackground(new java.awt.Color(51, 51, 51));
        messageTextArea.setColumns(20);
        messageTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        messageTextArea.setForeground(new java.awt.Color(255, 255, 255));
        messageTextArea.setRows(5);
        messageTextArea.setToolTipText("");
        messageTextArea.setWrapStyleWord(true);
        messageTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        messageTextArea.setCaretColor(new java.awt.Color(51, 51, 255));
        messageTextArea.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(messageTextArea);

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outputPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(outputPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 730, 270));

        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 20, 30));

        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        getContentPane().add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 20, 30));

        dragLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragLabelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                dragLabelMouseMoved(evt);
            }
        });
        dragLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragLabelMousePressed(evt);
            }
        });
        getContentPane().add(dragLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 20));

        submitButton.setBackground(new java.awt.Color(41, 41, 41));
        submitButton.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        submitButton.setForeground(new java.awt.Color(102, 102, 255));
        submitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submitButton.setText("Encrypt");
        submitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                submitButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                submitButtonMouseReleased(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 730, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageEncryption/Untitled.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void dragLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragLabelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_dragLabelMousePressed

    private void dragLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragLabelMouseMoved
        // Kill Ian for making this method
    }//GEN-LAST:event_dragLabelMouseMoved

    private void dragLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragLabelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_dragLabelMouseDragged

    private void chooseImageButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseImageButtonMousePressed
        chooseImageButton.setBorder(BorderFactory.createLoweredBevelBorder());
    }//GEN-LAST:event_chooseImageButtonMousePressed

    private void chooseImageButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseImageButtonMouseReleased
        chooseImageButton.setBorder(BorderFactory.createRaisedBevelBorder());
    }//GEN-LAST:event_chooseImageButtonMouseReleased

    private void saveLocationButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveLocationButtonMousePressed
        if (encrypting) {
            saveLocationButton.setBorder(BorderFactory.createLoweredBevelBorder());
        }
    }//GEN-LAST:event_saveLocationButtonMousePressed

    private void saveLocationButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveLocationButtonMouseReleased
        if (encrypting) {
            saveLocationButton.setBorder(BorderFactory.createRaisedBevelBorder());
        }
    }//GEN-LAST:event_saveLocationButtonMouseReleased

    private void encryptingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encryptingButtonMousePressed
        encryptingButton.setBorder(BorderFactory.createLoweredBevelBorder());
    }//GEN-LAST:event_encryptingButtonMousePressed

    private void encryptingButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encryptingButtonMouseReleased
        encryptingButton.setBorder(BorderFactory.createRaisedBevelBorder());
    }//GEN-LAST:event_encryptingButtonMouseReleased

    private void encryptingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encryptingButtonMouseClicked
        encrypting = !encrypting;

        if (encrypting) {
            encryptingButton.setText("Mode: Encryption");
            submitButton.setText("Encrypt");
            saveLocationButton.setBorder(BorderFactory.createRaisedBevelBorder());
            saveLocationButton.setForeground(new Color(102, 102, 255));
            messageTextArea.setEditable(true);
            messageTextArea.setFocusable(true);
        } else {
            encryptingButton.setText("Mode: Decryption");
            submitButton.setText("Decrypt");
            saveLocationButton.setBorder(BorderFactory.createLoweredBevelBorder());
            saveLocationButton.setForeground(new Color(51, 51, 51));
            messageTextArea.setEditable(false);
            messageTextArea.setFocusable(false);
            messageTextArea.setText("");
        }
    }//GEN-LAST:event_encryptingButtonMouseClicked

    private void chooseImageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseImageButtonMouseClicked
        //if (encrypting) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG files (*.png)", "png");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setFileFilter(filter);

        if (fileChooser.showOpenDialog(inputPanel) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                image = ImageIO.read(file);
                imageLabel.setIcon(new ImageIcon(image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //}
    }//GEN-LAST:event_chooseImageButtonMouseClicked

    private void saveLocationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveLocationButtonMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        if (encrypting) {
            if (fileChooser.showSaveDialog(inputPanel) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                String fileName = file.getAbsolutePath();

                if ((!fileName.endsWith(".png"))) {
                    file = new File(fileName + ".png");
                }

                if (file.getAbsoluteFile().exists()) {
                    Object[] button = {"Yes", "Cancel Save"};
                    int n = JOptionPane.showOptionDialog(inputPanel,
                            "This File Already Exists,"
                            + " Are you sure you want to write over it?",
                            "WARNING",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, //do not use a custom Icon
                            button, //the titles of buttons
                            button[1]); //default button title

                    if (n == 1) {
                        JOptionPane.showMessageDialog(inputPanel,
                                "The action was canceled.",
                                "Action Canceled",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }
        }
    }//GEN-LAST:event_saveLocationButtonMouseClicked

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        if (encrypting && file == null) {
            System.out.println("stupid select the file location");
        }
        if (encrypting) {
            Encryption encryption = new Encryption(image, String.valueOf(passwordTextField.getPassword()), messageTextArea.getText());
            image = encryption.encryptPicture();

            try {
                ImageIO.write(image, "PNG", file);
            } catch (Exception e) {

            }
        } else {
            Decryption decryption = new Decryption(image, String.valueOf(passwordTextField.getPassword()), messageTextArea.getText());
            messageTextArea.setText(decryption.decryptPicture());
        }

        System.out.println("rawr xd");
    }//GEN-LAST:event_submitButtonMouseClicked

    private void submitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMousePressed
        submitButton.setBorder(BorderFactory.createLoweredBevelBorder());
    }//GEN-LAST:event_submitButtonMousePressed

    private void submitButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseReleased
        submitButton.setBorder(BorderFactory.createRaisedBevelBorder());
    }//GEN-LAST:event_submitButtonMouseReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chooseImageButton;
    private javax.swing.JLabel close;
    private javax.swing.JLabel dragLabel;
    private javax.swing.JLabel encryptingButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JLabel minimize;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel saveLocationButton;
    private javax.swing.JLabel submitButton;
    // End of variables declaration//GEN-END:variables
}
