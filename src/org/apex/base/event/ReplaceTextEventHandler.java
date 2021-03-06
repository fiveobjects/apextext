/*
 * ReplaceTextEventHandler.java
 * Created on 6 June, 2007, 12:29 AM
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
package org.apex.base.event;

import org.apex.base.data.UIDataModel;
import org.apex.base.search.SearchTextUtility;

/**
 * An event handler to replace a single matching text.
 * @author Mrityunjoy Saha
 * @version 1.0
 * @since Apex 1.0
 */
public class ReplaceTextEventHandler extends UIEventHandler {

    /**
     * Creates a new instance of {@code ReplaceTextEventHandler}.
     */
    public ReplaceTextEventHandler() {
    }

    /**
     * Replaces the next matching text.
     * @param dataModel The replace data model.
     * @see SearchTextUtility#replace(EditorContext) 
     */
    public void execute(UIDataModel dataModel) {
        new Thread() {

            @Override
            public void run() {
                SearchTextUtility.replace(getContext());
            }
        }.start();
    }
}
