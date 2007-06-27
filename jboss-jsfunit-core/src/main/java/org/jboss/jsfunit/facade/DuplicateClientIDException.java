/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2007, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.jsfunit.facade;

import java.util.Iterator;
import java.util.List;

/**
 * Exception indicates that a reference was made to a JSF component with a
 * client ID suffix that matched more than one component on a page (client side)
 * or in a component tree (server side).
 *
 * The message in this exception will tell you which client IDs matched the ID suffix.
 *
 * @author Stan Silvert
 */
public class DuplicateClientIDException extends RuntimeException
{
   
   /**
    * Create a new DuplicateClientIDException.  
    *
    * @param clientIDSuffix The suffix that matched more than one component.
    * @param clientIDs The list of IDs that matched the clientIDSuffix.
    */
   public DuplicateClientIDException(String clientIDSuffix, List<String> clientIDs)
   {
      super(makeMessage(clientIDSuffix, clientIDs));
   }
   
   private static String makeMessage(String clientIDSuffix, List<String> clientIDs)
   {
      String message = clientIDSuffix + " matches more than one JSF component ID.  Use a more specific ID suffix.  Suffix matches: ";
      for (Iterator<String> i = clientIDs.iterator(); i.hasNext();)
      {
         message += i.next();
         if (i.hasNext()) message += ", ";
      }
      
      return message;
   }
}
