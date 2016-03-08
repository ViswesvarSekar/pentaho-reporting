/*
 * This program is free software; you can redistribute it and/or modify it under the
 *  terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 *  Foundation.
 *
 *  You should have received a copy of the GNU Lesser General Public License along with this
 *  program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 *  or from the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.
 *
 *  Copyright (c) 2006 - 2015 Pentaho Corporation..  All rights reserved.
 */

package org.pentaho.reporting.designer.core.editor.drilldown;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pentaho.reporting.libraries.base.util.ObjectUtilities;
import org.pentaho.reporting.libraries.base.util.ResourceBundleSupport;

import java.util.Locale;
import java.util.MissingResourceException;

/**
 * I18n for drill down dialogs.
 *
 * @author Aleksandr Kozlov
 */
public class Messages {

  private static final Log logger = LogFactory.getLog( Messages.class );

  private static ResourceBundleSupport bundle =
      new ResourceBundleSupport( Locale.getDefault(),
          "org.pentaho.reporting.designer.core.editor.drilldown.messages", //NON-NLS
          ObjectUtilities.getClassLoader( Messages.class ) );

  /**
   * Formats the message stored in the resource bundle (using a MessageFormat).
   *
   * @param key    the resourcebundle key.
   * @param param1 the parameter for the message.
   * @return the formated string.
   */
  public static String getString( final String key, final Object... param1 ) {
    try {
      return bundle.formatMessage( key, param1 );
    } catch ( MissingResourceException e ) {
      logger.warn( "Missing localization: " + key, e ); //NON-NLS
      return '!' + key + '!';
    }
  }
}