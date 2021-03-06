/*
 * ViewDocumentPropertiesMenu.java
 * Created on 2 Nov, 2007, 1:31:43 AM
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
package org.apex.base.menu;

import org.apex.base.component.DocumentTabComponent;
import org.apex.base.data.AbstractDocument;
import org.apex.base.data.InputParams;
import org.apex.base.data.OutputParams;
import org.apex.base.ui.DocumentPropertiesView;
import java.awt.Point;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * A menu target to display properties of a document in a dialog window.
 * @author Mrityunjoy Saha
 * @version 1.0
 * @since Apex 1.0
 */
public class ViewDocumentPropertiesMenu extends SimplePanelDialogMenu {

    /**
     * The dialog window size.
     */
    private static final Point WINDOW_SIZE = new Point(350, 340);

    /**
     * Creates a new instance of {@code ViewDocumentPropertiesMenu}.
     */
    public ViewDocumentPropertiesMenu() {
        panel = new DocumentPropertiesView();
    }

    /**
     * Initializes the view {@code DocumentPropertiesView} with selected document.
     * @param in Input parameters.
     * @param out Output parameters.
     */
    protected void preProcess(InputParams in, OutputParams out) {
        // Check whether a different tab other than current document is selected
        Object source = in.get("ACTION_SOURCE");
        if (source instanceof JMenuItem &&
                ((JMenuItem) source).getParent() instanceof JPopupMenu &&
                ((JPopupMenu) ((JMenuItem) source).getParent()).getInvoker() instanceof DocumentTabComponent) {
            DocumentTabComponent tabComp =
                    (DocumentTabComponent) ((JPopupMenu) ((JMenuItem) source).
                    getParent()).getInvoker();
            AbstractDocument file = tabComp.getDocument();
            if (file != null) {
                ((DocumentPropertiesView) panel).initialize(file);
            } else {
                ((DocumentPropertiesView) panel).initialize(getContext().
                        getEditorProperties().
                        getCurrentDocument());
            }
        } else {
            ((DocumentPropertiesView) panel).initialize(getContext().
                    getEditorProperties().
                    getCurrentDocument());
        }
    }

    public String getTitle() {
        return "Document Properties";
    }

    /**
     * Sets the container dialog window to view and then make the dialog visible.
     * @param in Input parameters.
     * @param out Output parameters.
     */
    @Override
    protected void postProcess(InputParams in, OutputParams out) {
        ((DocumentPropertiesView) this.panel).setContainerWindow(dialog);
        super.postProcess(in, out);
    }

    @Override
    public Point windowSize() {
        return WINDOW_SIZE;
    }
}
