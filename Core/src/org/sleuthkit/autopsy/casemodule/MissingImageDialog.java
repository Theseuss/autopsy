/*
 * Autopsy Forensic Browser
 *
 * Copyright 2012-2021 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;
import org.sleuthkit.autopsy.coreutils.DriveUtils;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.guicomponeontutils.JFileChooserFactory;
import org.sleuthkit.datamodel.SleuthkitCase;
import org.sleuthkit.datamodel.TskCoreException;

/**
 * Dialog to allow the examiner to locate an image when it cannot be found.
 */
@SuppressWarnings("PMD.SingularField") // UI widgets cause lots of false positives
class MissingImageDialog extends javax.swing.JDialog {

    private static final Logger logger = Logger.getLogger(MissingImageDialog.class.getName());
    long obj_id;
    SleuthkitCase db;

    private JFileChooser fileChooser;
    private final JFileChooserFactory chooserHelper;

    /**
     * Instantiate a MissingImageDialog.
     * 
     * @param obj_id Object ID of the missing image.
     * @param db     The current SleuthkitCase connected to the database.
     */
    private MissingImageDialog(long obj_id, SleuthkitCase db) {
        super((JFrame) WindowManager.getDefault().getMainWindow(), true);
        this.obj_id = obj_id;
        this.db = db;
        initComponents();
        
        chooserHelper = new JFileChooserFactory();
        selectButton.setEnabled(false);
    }

    /**
     * Client call to create a MissingImageDialog.
     * 
     * @param obj_id Object ID of the missing image.
     * @param db     The current SluethkitCase connected to the database.
     */
    static void makeDialog(long obj_id, SleuthkitCase db) {
        final MissingImageDialog dialog = new MissingImageDialog(obj_id, db);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.cancel();
            }
        });
        dialog.display();
    }

    /**
     * Show the dialog.
     */
    private void display() {
        this.setTitle(NbBundle.getMessage(this.getClass(), "MissingImageDialog.display.title"));
        setLocationRelativeTo(WindowManager.getDefault().getMainWindow());
        this.setVisible(true);
    }

    /**
     * Enables/disables the select button based off the current panel.
     */
    private void updateSelectButton() {

        // Enable this based on whether there is a valid path
        if (!pathNameTextField.getText().isEmpty()) {
            String filePath = pathNameTextField.getText();
            boolean isExist = new File(filePath).isFile() || DriveUtils.driveExists(filePath);
            selectButton.setEnabled(isExist);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        selectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        containerPanel = new javax.swing.JPanel();
        pathNameTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        lbWarning = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        titleSeparator = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(selectButton, org.openide.util.NbBundle.getMessage(MissingImageDialog.class, "MissingImageDialog.selectButton.text")); // NOI18N
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(MissingImageDialog.class, "MissingImageDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pathNameTextField.setText(org.openide.util.NbBundle.getMessage(MissingImageDialog.class, "MissingImageDialog.pathNameTextField.text")); // NOI18N
        pathNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathNameTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(browseButton, org.openide.util.NbBundle.getMessage(MissingImageDialog.class, "MissingImageDialog.browseButton.text")); // NOI18N
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        lbWarning.setFont(lbWarning.getFont().deriveFont(lbWarning.getFont().getStyle() | java.awt.Font.BOLD, lbWarning.getFont().getSize()+1));
        lbWarning.setForeground(new java.awt.Color(244, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(lbWarning, org.openide.util.NbBundle.getMessage(MissingImageDialog.class, "MissingImageDialog.lbWarning.text")); // NOI18N
        lbWarning.setToolTipText(org.openide.util.NbBundle.getMessage(MissingImageDialog.class, "MissingImageDialog.lbWarning.toolTipText")); // NOI18N

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addComponent(pathNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browseButton)
                        .addContainerGap(83, Short.MAX_VALUE))))
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbWarning, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | java.awt.Font.BOLD, titleLabel.getFont().getSize()+1));
        org.openide.awt.Mnemonics.setLocalizedText(titleLabel, org.openide.util.NbBundle.getMessage(MissingImageDialog.class, "MissingImageDialog.titleLabel.text")); // NOI18N

        titleSeparator.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titleSeparator)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel)
                    .addComponent(titleSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        try {
            String newPath = pathNameTextField.getText();
            //TODO handle local files
            db.setImagePaths(obj_id, Arrays.asList(new String[]{newPath}));
            this.dispose();
        } catch (TskCoreException ex) {
            lbWarning.setText(NbBundle.getMessage(this.getClass(), "MissingImageDialog.ErrorSettingImage"));
            logger.log(Level.SEVERE, "Error setting image paths", ex); //NON-NLS
        }
    }//GEN-LAST:event_selectButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void pathNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathNameTextFieldActionPerformed
        updateSelectButton();
    }//GEN-LAST:event_pathNameTextFieldActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed

        if(fileChooser == null) {
            fileChooser = chooserHelper.getChooser();
            fileChooser.setDragEnabled(false);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setMultiSelectionEnabled(false);

            List<FileFilter> fileFiltersList = ImageDSProcessor.getFileFiltersList();
            for (FileFilter fileFilter : fileFiltersList) {
                fileChooser.addChoosableFileFilter(fileFilter);
            }
            fileChooser.setFileFilter(fileFiltersList.get(0));
        }
        
        String oldText = pathNameTextField.getText();
        lbWarning.setText("");
        // set the current directory of the FileChooser if the ImagePath Field is valid
        File currentDir = new File(oldText);
        if (currentDir.exists()) {
            fileChooser.setCurrentDirectory(currentDir);
        }

        int retval = fileChooser.showOpenDialog(this);
        if (retval == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getPath();
            pathNameTextField.setText(path);
        }
        //pcs.firePropertyChange(DataSourceProcessor.DSP_PANEL_EVENT.FOCUS_NEXT.toString(), false, true);

        updateSelectButton();
    }//GEN-LAST:event_browseButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JLabel lbWarning;
    private javax.swing.JTextField pathNameTextField;
    private javax.swing.JButton selectButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JSeparator titleSeparator;
    // End of variables declaration//GEN-END:variables

    /**
     * Verify the user wants to cancel searching for the image.
     */
    void cancel() {
        int ret = JOptionPane.showConfirmDialog(this,
                NbBundle.getMessage(this.getClass(),
                        "MissingImageDialog.confDlg.noFileSel.msg"),
                NbBundle.getMessage(this.getClass(),
                        "MissingImageDialog.confDlg.noFileSel.title"),
                JOptionPane.YES_NO_OPTION);
        if (ret == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }
}
