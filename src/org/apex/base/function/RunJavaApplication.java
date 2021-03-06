/*
 * RunJavaApplication.java
 * Created on 23 June, 2007, 1:55 PM
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
package org.apex.base.function;

import org.apex.base.data.Tool;

/**
 * A processor to run a Java application.
 * <p>
 * It runs the currently displayed Java class as application.
 * @author Mrityunjoy Saha
 * @version 1.0
 * @since Apex 1.0
 */
public class RunJavaApplication extends JavaToolProcessor {

    /**
     * Creates a new instance of RunJavaApplication.
     * @param tool The tool to be processed.
     */
    public RunJavaApplication(Tool tool) {
        super(tool);
    }

    public String[] getBaseCommand() {
        return new String[]{"java"};
    }

    @Override
    public String[] getResources() {
        String retValue = super.getResources()[0];
        if (!retValue.equals("")) {
            if (retValue.indexOf(".") != -1) {
                retValue = retValue.substring(0, retValue.lastIndexOf("."));
            }
        }
        return new String[]{retValue};
    }
}
