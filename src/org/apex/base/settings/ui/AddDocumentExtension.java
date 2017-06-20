/*
 * AddDocumentExtension.java
 * Created on 15 October, 2007, 2:11 AM 
 *
 * Copyright (C) 2008 Mrityunjoy Saha
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.apex.base.settings.ui;

import org.apex.base.data.AlphaNumericFilter;
import org.apex.base.settings.DocumentTypesConfiguration;
import org.apex.base.settings.InvalidSettingsParameterException;
import org.apex.base.settings.SettingsMessageManager;
import org.apex.base.settings.ui.text.UIConfigurationUtility;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.text.AbstractDocument;
import org.apex.base.data.IDocumentType;

/**
 * A form to add document extensions. To add a document extension, for the selected
 * document type an extension needs to be entered by user. 
 * @author Mrityunjoy Saha
 * @version 1.0
 * @since Apex 1.0
 */
public class AddDocumentExtension extends DocumentExtensionChangeSupport {

    /**
     * Creates new form {@code AddDocumentExtension} using specified document types
     * configuration, selected document type and a list where all available extensions 
     * for selected document type are displayed.
     * @param docTypesConfig Document types configuration.
     * @param selectedDocumentType Selected document type.
     * @param extensionsList A list where to display document extensions.
     */
    public AddDocumentExtension(
            DocumentTypesConfiguration docTypesConfig,
            IDocumentType selectedDocumentType,
            JList extensionsList) {
        super(docTypesConfig, selectedDocumentType, extensionsList);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        docExtension = new javax.swing.JTextField();
        ((AbstractDocument)this.docExtension.getDocument()).setDocumentFilter(new AlphaNumericFilter(15));
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        docType = new javax.swing.JLabel();

        jLabel1.setText("Document Type:");

        jLabel2.setText("Document Extension:");

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        docType.setText(getSelectedDocumentType().toString());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(docType, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(docExtension, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(docType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(docExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            // Display warning in case nothing has been entered as extension or
            // extension is a duplicate one.
            String extension = this.docExtension.getText();
            Vector<String> selectedDocExtensions =
                    getSelectedDocumentExtensions();
            validateDocumentExtension(extension);
            selectedDocExtensions.add(this.docExtension.getText().trim().toLowerCase());
            this.extensionsList.setModel(UIConfigurationUtility.getListModel(selectedDocExtensions));
            this.extensionsList.setSelectedIndex(0);
            closeWindow();
        } catch (InvalidSettingsParameterException ex) {
            SettingsMessageManager.showErrorMessage(this,
                    ex.getErrorCode(),
                    ex.getPlaceHolders());
            this.docExtension.requestFocus();
            this.docExtension.selectAll();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        closeWindow();
    }//GEN-LAST:event_cancelButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField docExtension;
    private javax.swing.JLabel docType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
