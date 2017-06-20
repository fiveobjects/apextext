/*
 * ReplacePanel.java
 * Created on December 20, 2007, 3:36 PM
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
package org.apex.base.search.ui;

import org.apex.base.constant.MenuConstants;
import org.apex.base.core.EditorBase;
import org.apex.base.core.MenuManager;
import org.apex.base.data.EditorContext;
import org.apex.base.data.InputParams;
import org.apex.base.data.OutputParams;
import org.apex.base.event.FindTextEventHandler;
import org.apex.base.event.ReplaceAllTextEventHandler;
import org.apex.base.event.ReplaceTextEventHandler;
import org.apex.base.search.SearchTextModel;
import org.apex.base.ui.text.UIDialogModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import org.apex.base.util.DocumentData;

/**
 * A replace text form. User can change replace preferences in this from and search/replace
 * text in currently displayed editor.
 * @author Mrityunjoy Saha
 * @version 1.0
 * @since Apex 1.0
 */
public class ReplacePanel extends javax.swing.JPanel implements UIDialogModel {

    /**
     * A find text event handler.
     */
    private FindTextEventHandler findEvent;
    /**
     * A replace text event handler.
     */
    private ReplaceTextEventHandler replaceEvent;
    /**
     * A replace all text event handler.
     */
    private ReplaceAllTextEventHandler replaceAllEvent;
    /**
     * The search data model.
     */
    private SearchTextModel model;

    /**
     * Creates a new instance of {@code ReplacePanel} using specified search data model.
     * @param model The search data model.
     */
    public ReplacePanel(SearchTextModel model) {
        this.model = model;
        findEvent = new FindTextEventHandler();
        replaceEvent = new ReplaceTextEventHandler();
        replaceAllEvent = new ReplaceAllTextEventHandler();
        initComponents();
        // @TODO Help button is temporarily invisible - remove following line in later version.
        this.helpB.setVisible(false);
        this.searchKey.getEditor().getEditorComponent().addKeyListener(
                new SearchTextKeyListener());
        applyModel();
    }

    /**
     *  Applies the search data model to this form.
     */
    private void applyModel() {
        this.searchKey.setSelectedItem(this.model.getSearchKey());
        this.replaceKey.setSelectedItem(this.model.getReplaceKey());
        this.caseSensitive.setSelected(this.model.isCaseSensitive());
        this.wholeWord.setSelected(this.model.isWholeWord());
        this.highlightSearch.setSelected(this.model.isHighlightSearch());
        this.wrapSearch.setSelected(this.model.isWrapSearch());
        this.backwardSearch.setSelected(this.model.isBackwardSearch());
        this.incrementalSearch.setSelected(this.model.isIncrementalSearch());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        replaceKey = new javax.swing.JComboBox();
        caseSensitive = new javax.swing.JCheckBox();
        wholeWord = new javax.swing.JCheckBox();
        wrapSearch = new javax.swing.JCheckBox();
        backwardSearch = new javax.swing.JCheckBox();
        highlightSearch = new javax.swing.JCheckBox();
        incrementalSearch = new javax.swing.JCheckBox();
        findB = new javax.swing.JButton();
        replaceB = new javax.swing.JButton();
        replaceAllB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        searchKey = new javax.swing.JComboBox();
        closeB = new javax.swing.JButton();
        helpB = new javax.swing.JButton();

        jLabel1.setText("Find What:");

        replaceKey.setEditable(true);
        replaceKey.setModel(getReplaceKeyListModel());
        replaceKey.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                replaceKeyItemStateChanged(evt);
            }
        });

        caseSensitive.setText("Match Case");
        caseSensitive.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        caseSensitive.setMargin(new java.awt.Insets(0, 0, 0, 0));
        caseSensitive.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                caseSensitiveItemStateChanged(evt);
            }
        });

        wholeWord.setText("Whole Words");
        wholeWord.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        wholeWord.setMargin(new java.awt.Insets(0, 0, 0, 0));
        wholeWord.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                wholeWordItemStateChanged(evt);
            }
        });

        wrapSearch.setText("Wrap Around");
        wrapSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        wrapSearch.setMargin(new java.awt.Insets(0, 0, 0, 0));
        wrapSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                wrapSearchItemStateChanged(evt);
            }
        });

        backwardSearch.setText("Search Backwards");
        backwardSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        backwardSearch.setMargin(new java.awt.Insets(0, 0, 0, 0));
        backwardSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                backwardSearchItemStateChanged(evt);
            }
        });

        highlightSearch.setText("Highlight Results");
        highlightSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        highlightSearch.setMargin(new java.awt.Insets(0, 0, 0, 0));
        highlightSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                highlightSearchItemStateChanged(evt);
            }
        });

        incrementalSearch.setText("Incremental Search");
        incrementalSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        incrementalSearch.setMargin(new java.awt.Insets(0, 0, 0, 0));
        incrementalSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                incrementalSearchItemStateChanged(evt);
            }
        });

        findB.setText("Find");
        findB.setFocusable(false);
        findB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findHandler(evt);
            }
        });

        replaceB.setText("Replace");
        replaceB.setFocusable(false);
        replaceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceHandler(evt);
            }
        });

        replaceAllB.setText("Replace All");
        replaceAllB.setFocusable(false);
        replaceAllB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceAllHandler(evt);
            }
        });

        jLabel2.setText("Replace With:");

        searchKey.setEditable(true);
        searchKey.setModel(getSearchKeyListModel());
        searchKey.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchKeyItemStateChanged(evt);
            }
        });

        closeB.setText("Close");
        closeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeHandler(evt);
            }
        });

        helpB.setText("Help");
        helpB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpHandler(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(replaceKey, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchKey, javax.swing.GroupLayout.Alignment.LEADING, 0, 243, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caseSensitive)
                            .addComponent(wholeWord)
                            .addComponent(highlightSearch))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incrementalSearch)
                            .addComponent(backwardSearch)
                            .addComponent(wrapSearch))))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(replaceB, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(replaceAllB)
                    .addComponent(closeB, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpB, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findB, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findB))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(replaceKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(replaceB)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caseSensitive)
                            .addComponent(wrapSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wholeWord)
                            .addComponent(backwardSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(highlightSearch)
                            .addComponent(incrementalSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(replaceAllB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpB)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void replaceKeyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_replaceKeyItemStateChanged
        this.model.setReplaceKey((String) this.replaceKey.getSelectedItem());
    }//GEN-LAST:event_replaceKeyItemStateChanged

    private void caseSensitiveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_caseSensitiveItemStateChanged
        this.model.setCaseSensitive(caseSensitive.isSelected());
    }//GEN-LAST:event_caseSensitiveItemStateChanged

    private void wholeWordItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_wholeWordItemStateChanged
        this.model.setWholeWord(wholeWord.isSelected());
    }//GEN-LAST:event_wholeWordItemStateChanged

    private void wrapSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_wrapSearchItemStateChanged
        this.model.setWrapSearch(wrapSearch.isSelected());
    }//GEN-LAST:event_wrapSearchItemStateChanged

    private void backwardSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_backwardSearchItemStateChanged
        this.model.setBackwardSearch(backwardSearch.isSelected());
    }//GEN-LAST:event_backwardSearchItemStateChanged

    private void highlightSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_highlightSearchItemStateChanged
        this.model.setHighlightSearch(highlightSearch.isSelected());
    }//GEN-LAST:event_highlightSearchItemStateChanged

    private void incrementalSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_incrementalSearchItemStateChanged
        this.model.setIncrementalSearch(incrementalSearch.isSelected());
    }//GEN-LAST:event_incrementalSearchItemStateChanged

    private void findHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findHandler
        findEvent.execute(model);
}//GEN-LAST:event_findHandler

    private void replaceHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceHandler
        this.model.setReplaceKey((String) this.replaceKey.getEditor().getItem());
        this.replaceB.setEnabled(false);
        replaceEvent.execute(model);
        this.replaceB.setEnabled(true);
}//GEN-LAST:event_replaceHandler

    private void replaceAllHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceAllHandler
        this.model.setReplaceKey((String) this.replaceKey.getEditor().getItem());
        this.replaceAllB.setEnabled(false);
        replaceAllEvent.execute(model);
        this.replaceAllB.setEnabled(true);
}//GEN-LAST:event_replaceAllHandler

    private void searchKeyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchKeyItemStateChanged
        this.model.setSearchKey((String) this.searchKey.getSelectedItem());
    }//GEN-LAST:event_searchKeyItemStateChanged

    private void closeHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeHandler
        getContainerWindow().setVisible(false);
}//GEN-LAST:event_closeHandler

    private void helpHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpHandler
        // Replace Help button pressed, linking to main help window.
        MenuManager.getMenuById(MenuConstants.HELP).processMenu(
                new InputParams(),
                new OutputParams());
}//GEN-LAST:event_helpHandler
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox backwardSearch;
    private javax.swing.JCheckBox caseSensitive;
    private javax.swing.JButton closeB;
    private javax.swing.JButton findB;
    private javax.swing.JButton helpB;
    private javax.swing.JCheckBox highlightSearch;
    private javax.swing.JCheckBox incrementalSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton replaceAllB;
    private javax.swing.JButton replaceB;
    private javax.swing.JComboBox replaceKey;
    private javax.swing.JComboBox searchKey;
    private javax.swing.JCheckBox wholeWord;
    private javax.swing.JCheckBox wrapSearch;
    // End of variables declaration//GEN-END:variables
    /**
     * The container dialog window.
     */
    private JDialog containerWindow;

    public EditorContext getContext() {
        return EditorBase.getContext();
    }

    /**
     * Returns the data model for search key dropdown. It gets the list
     * of search keys from search data model.
     * @return The data model for search key dropdown.
     */
    public ComboBoxModel getSearchKeyListModel() {
        return new DefaultComboBoxModel(model.getSearchKeys());
    }

    /**
     *  Returns the data model for replace key dropdown. It gets the list
     * of replace keys from search data model.
     * @return The data model for search key dropdown.
     */
    public ComboBoxModel getReplaceKeyListModel() {
        return new DefaultComboBoxModel(model.getReplaceKeys());
    }

    public JDialog getContainerWindow() {
        return containerWindow;
    }

    public void setContainerWindow(JDialog containerWindow) {
        this.containerWindow = containerWindow;
        applyModel();
        if (!DocumentData.isSelectedTextMultiLine(getContext())) {
            String selectedText = getContext().getEditorProperties().
                    getCurrentDocument().getEditor().
                    getSelectedText();
            this.searchKey.getEditor().setItem(selectedText);
            this.model.setSearchKey(selectedText);
        }
        selectSearchText();
    }

    /**
     * Selects the text in 'Search Text' field.
     */
    private void selectSearchText() {
        if (this.searchKey.getEditor().getItem() != null) {
            this.searchKey.getEditor().selectAll();
        }
    }

    /**
     * A key listener for 'search text' field. It is useful for incremental search.
     */
    protected class SearchTextKeyListener extends KeyAdapter {

        /**
         * Invoked when a key has been released.
         * @param e The key event.
         */
        @Override
        public void keyReleased(KeyEvent e) {
            model.setSearchKey((String) searchKey.getEditor().getItem());
            if (model.isIncrementalSearch()) {
                findEvent.execute(model);
            }
        }
    }
}
