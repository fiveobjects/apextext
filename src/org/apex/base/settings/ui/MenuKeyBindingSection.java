/*
 * MenuKeyBindingSection.java
 * Created on 12 July, 2007, 1:21 AM 
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

import org.apex.base.component.TextEditor;
import org.apex.base.core.EditorBase;
import org.apex.base.data.ActionTarget;
import org.apex.base.data.TreeModel;
import org.apex.base.data.MenuTreeSelectionModel;
import org.apex.base.data.MenuNode;
import org.apex.base.settings.InvalidSettingsParameterException;
import org.apex.base.settings.MenuConfiguration;
import org.apex.base.settings.SettingsMessageManager;
import org.apex.base.util.MenuUtil;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultTreeModel;
import org.apex.base.constant.MenuConstants;

/**
 * A form to add or update menu-key bindings.
 * @author Mrityunjoy Saha
 * @version 1.1
 * @since Apex 1.0
 */
public class MenuKeyBindingSection extends javax.swing.JPanel {

    /**
     * Menu configuration.
     */
    private MenuConfiguration menuConfig;
    /**
     * The currently selected menu node.
     */
    private MenuNode currentNode;
    /**
     * The mapping between keystrokes and default action names.
     */
    private HashMap<KeyStroke, String> defaultKeyMap;
    /**
     * The mapping between keystrokes and menu Ids.
     */
    private HashMap<KeyStroke, String> menuKeyMap;

    /**
     * Creates new form {@code MenuKeyBindingSection} using menu configuration.
     * @param menuConfig The menu configuration.
     */
    public MenuKeyBindingSection(MenuConfiguration menuConfig) {
        this.menuConfig = menuConfig;
        initComponents();
        this.setPreferredSize(ConfigurationPage.DEFAULT_SIZE);
        menus.getSelectionModel().setSelectionMode(
                MenuTreeSelectionModel.SINGLE_TREE_SELECTION);
        // By default select the root menu
        this.menus.setSelectionRow(0);
        setDefaultKeyMap();
    }

    /**
     * Sets the default key map for a text editor.
     */
    private void setDefaultKeyMap() {
        this.defaultKeyMap = new HashMap<KeyStroke, String>();
        InputMap inMap = null;
        if (EditorBase.getContext().getEditorProperties().getCurrentDocument()
                != null) {
            inMap = EditorBase.getContext().getEditorProperties().
                    getCurrentDocument().getEditor().
                    getInputMap();
        } else {
            // TODO Change this later. Do not hard code the editor type.
            TextEditor editArea = new TextEditor();
            editArea.addListeners();
            inMap = editArea.getInputMap();
            editArea = null;
        }
        KeyStroke[] keys = inMap.allKeys();
        for (int iCount = 0; iCount < keys.length; iCount++) {
            defaultKeyMap.put(keys[iCount], inMap.get(keys[iCount]).toString());
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menusPane = new javax.swing.JScrollPane();
        menus = new javax.swing.JTree();
        jPanel12 = new javax.swing.JPanel();
        shortcut = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        menus.setModel(getMenuModel());
        menus.setSelectionModel(getMenuSelectionModel());
        menus.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                menusValueChanged(evt);
            }
        });
        menusPane.setViewportView(menus);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Shortcut", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 204))); // NOI18N

        shortcut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcutKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                shortcutKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shortcut, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(shortcut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Menus:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menusPane, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menusPane, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void menusValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_menusValueChanged
        if (menus.getSelectionPath() == null) {
            return;
        }
        MenuNode info = (MenuNode) menus.getSelectionPath().
                getLastPathComponent();
        this.currentNode = info;
        if (info.getType().isActionRequired() && (info.getParent() != null && !((MenuNode) info.
                getParent()).getId().equalsIgnoreCase(MenuConstants.RECENT_FILES))) {
            KeyStroke shortcutKey = info.getAccelerator();
            if (shortcutKey != null) {
                shortcut.setText(MenuUtil.getDisplayableAcceleratorText(
                        shortcutKey));
            } else {
                shortcut.setText("");
            }
            this.shortcut.setEnabled(true);
            this.shortcut.requestFocus();
        } else {
            this.shortcut.setText("");
            this.shortcut.setEnabled(false);
            this.menus.requestFocus();
        }
    }//GEN-LAST:event_menusValueChanged

    private void shortcutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shortcutKeyPressed
        String acceleratorText = "";
        int modifiers = evt.getModifiers();
        int keyCode = evt.getKeyCode();
        if (modifiers == 0) {
            if (keyCode == KeyEvent.VK_UP) {
                this.menus.setSelectionRow(this.menus.getSelectionRows()[0] - 1);
                return;
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                this.menus.setSelectionRow(this.menus.getSelectionRows()[0] + 1);
                return;
            }
            if (this.shortcut.getText() != null
                    && !this.shortcut.getText().trim().equals("") && keyCode
                    == KeyEvent.VK_BACK_SPACE) {
                this.shortcut.setText("");
                assignKeyStroke(null);
                return;
            }
            if (Character.isLetterOrDigit(evt.getKeyChar())) {
                return;
            }
        }
        if (modifiers > 0) {
            acceleratorText = KeyEvent.getKeyModifiersText(modifiers);
            acceleratorText += "+";
        }
        if (!(keyCode == KeyEvent.VK_CONTROL || keyCode == KeyEvent.VK_ALT
                || keyCode == KeyEvent.VK_SHIFT)) {
            if (keyCode != 0) {
                acceleratorText += KeyEvent.getKeyText(keyCode);
            } else {
                acceleratorText += evt.getKeyChar();
            }
        }
        this.shortcut.setText(acceleratorText);
        if (!acceleratorText.endsWith("+")) {
            assignKeyStroke(KeyStroke.getKeyStroke(keyCode, modifiers));
        }

    }//GEN-LAST:event_shortcutKeyPressed

    /**
     * It validates a given keystroke and then assigns the same to currently selected
     * menu.
     * @param stroke The keystroke.
     */
    private void assignKeyStroke(KeyStroke stroke) {
        try {
            if (stroke != null) {
                validateAccelerator(stroke);
                // Change the current display
                getCurrentNode().setAccelerator(stroke);
                ((DefaultTreeModel) this.menus.getModel()).reload(
                        getCurrentNode());
                // Change the key binding
                this.menuConfig.getMenuKeyBindings().getMenuKeyBindings().put(getCurrentNode().
                        getId(), stroke.toString());
                // Update menu-key binding map
                this.menuKeyMap.put(stroke, getCurrentNode().getName());
            } else {
                // Update menu-key binding map
                this.menuKeyMap.remove(getCurrentNode().getAccelerator());
                // Change the current display
                getCurrentNode().setAccelerator((KeyStroke) null);
                ((DefaultTreeModel) this.menus.getModel()).reload(
                        getCurrentNode());

                // Change the key binding
                this.menuConfig.getMenuKeyBindings().getMenuKeyBindings().put(getCurrentNode().
                        getId(), null);
            }
        } catch (InvalidSettingsParameterException ispe) {
            SettingsMessageManager.showErrorMessage(this, ispe.getErrorCode(),
                    ispe.getPlaceHolders());
            this.shortcut.setText("");
        }
    }

    private void shortcutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shortcutKeyTyped
        evt.consume();
    }//GEN-LAST:event_shortcutKeyTyped

    /*
     * @TODO - Add TAB button beside shortcut text field as user can't
     * select TAB button from keyboard. When this button is pressed append TAB in existing shortcut.
     * 1. In case shortcut is disabled this button also will be disabled.
     * 2. In case shortcut is empty TAB will be inserted in the shortcut text field.
     * 3. Shortcut key assignment to menu works on key press on shortcut key text field. In
     * case tab button is pressed on key press event won't be generated and still shortcut
     * key assignment must function.
     */
    /**
     * Returns the data model for menus.
     * @return The data model for menus.
     */
    private TreeModel getMenuModel() {
        MenuNode allMenus = this.menuConfig.getAllAvailableMenus();
        setMenuKeyMap(allMenus);
        return new TreeModel(allMenus);
    }

    /**
     * Returns the data model for menu tree selection.
     * @return The data model for menu tree selection.
     */
    private MenuTreeSelectionModel getMenuSelectionModel() {
        return new MenuTreeSelectionModel();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JTree menus;
    private javax.swing.JScrollPane menusPane;
    private javax.swing.JTextField shortcut;
    // End of variables declaration//GEN-END:variables

    /**
     * Prepares a map of menus and their accelerators.
     * @param allMenus The root menu node.
     */
    private void setMenuKeyMap(MenuNode allMenus) {
        this.menuKeyMap = new HashMap<KeyStroke, String>();
        parseMenusRecursively(allMenus);
    }

    /**
     * Parses menus recursively and gets accelerator information of each menu.
     * @param srcNode The root menu node.
     * @return {@code true} if parse is successful; otherwise returns {@code false}.
     */
    private boolean parseMenusRecursively(
            MenuNode srcNode) {
        Enumeration menuBundle = srcNode.children();
        while (menuBundle.hasMoreElements()) {
            MenuNode menu =
                    (MenuNode) menuBundle.nextElement();
            if (menu.getAccelerator() != null) {
                this.menuKeyMap.put(menu.getAccelerator(), menu.getName());
            }
            if (menu.getChildCount() > 0) {
                if (parseMenusRecursively(menu)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the currently selected menu node.
     * @return The currently selected menu node.
     * @see #setCurrentNode(org.apex.base.data.MenuNode)
     */
    public MenuNode getCurrentNode() {
        return currentNode;
    }

    /**
     * Sets the current menu node.
     * @param currentNode A menu node.
     * @see #getCurrentNode()
     */
    public void setCurrentNode(MenuNode currentNode) {
        this.currentNode = currentNode;
    }

    /**
     * Validates the given keystroke to be assigned to a menu.
     * It does following validations while assigning a keystroke to a menu:
     * <ul>
     *  <li> Check whether it is already assigned to a peer menu.
     *  <li> Check whether it is part of restricted keystroke list.
     *  <li> Lastly check whether this menu is capable to get a restricted
     *          keystroke and that same keystroke we are trying to assign now.
     * </ul>
     * @param stroke The keystroke to be assigned.
     * @throws InvalidSettingsParameterException
     */
    private void validateAccelerator(KeyStroke stroke) throws
            InvalidSettingsParameterException {
        if (this.menuKeyMap != null && this.menuKeyMap.containsKey(stroke) && !getCurrentNode().
                getName().equalsIgnoreCase(this.menuKeyMap.get(stroke))) {
            throw new InvalidSettingsParameterException(
                    "KeyStroke already assigned to a peer menu.",
                    1014, "MENU='" + this.menuKeyMap.get(stroke) + "'");
        }
        if (this.defaultKeyMap != null && this.defaultKeyMap.containsKey(stroke)) {
            if (getCurrentNode().getTargetType().equals(
                    ActionTarget.BUILT_IN_ACTION) && this.defaultKeyMap.get(
                    stroke).
                    equals(getCurrentNode().getTarget())) {
                // It is allowed.
            } else {
                throw new InvalidSettingsParameterException(
                        "KeyStroke reserved for dedicated action.",
                        1015, "ACTION='" + this.defaultKeyMap.get(stroke) + "'");
            }
        }
    }
}
