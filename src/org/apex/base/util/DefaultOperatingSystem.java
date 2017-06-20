/*
 * DefaultOperatingSystem.java 
 * Created on 5 Aug, 2010, 1:00:59 AM
 *
 * Copyright (C) 2010 Mrityunjoy Saha
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
package org.apex.base.util;

/**
 * Representation of default operating system.
 * @author mrityunjoy_saha
 * @version 1.0
 * @since Apex 1.2
 */
class DefaultOperatingSystem extends OperatingSystem {

    /**
     * Line separator.
     */
    private static final String LINE_SEPARTOR = "\n";

    /**
     * Constructs a new instance of {@code DefaultOperatingSystem}.
     */
    public DefaultOperatingSystem() {
    }

    @Override
    public String getLineSeparator() {
        return LINE_SEPARTOR;
    }

    @Override
    public boolean isFilePathCaseSensitive() {
        return false;
    }
}
