/*
Copyright 2008-2011 Gephi
Authors : Mathieu Bastian
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.preview.types;

import java.awt.Color;

/**
 *
 * @author Mathieu Bastian
 */
public final class DependantOriginalColor {

    public enum Mode {

        PARENT, CUSTOM, ORIGINAL
    };
    private final Color customColor;
    private final Mode mode;

    public DependantOriginalColor(Mode mode) {
        customColor = null;
        this.mode = mode;
    }

    public DependantOriginalColor(Color customColor) {
        this.customColor = customColor;
        this.mode = Mode.CUSTOM;
    }

    public Color getColor(Color parentColor, Color originalColor) {
        if (customColor == null) {
            if (mode.equals(Mode.ORIGINAL) && originalColor != null) {
                return originalColor;
            }
            return parentColor;
        }
        return customColor;
    }
}