/* Copyright (c) 2015 Adam Marcionek, All Rights Reserved
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.  
 */
package com.sun.jna.platform.win32;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Ported from LMShare.h.
 * Windows SDK 7.1
 * @author amarcionek[at]seven10storage.com
 */
public interface LMShare extends StdCallLibrary {

    //
    // Share types (shi1_type and shi2_type fields).
    //

    /**
     * Disk Drive.
     */
    int STYPE_DISKTREE = 0;

    /**
     * Print Queue.
     */
    int STYPE_PRINTQ = 1;

    /**
     * Communication device.
     */
    int STYPE_DEVICE = 2;

    /**
     * Interprocess communication (IPC).
     */
    int STYPE_IPC = 3;

    /**
     * A temporary share.
     */
    int STYPE_TEMPORARY = 0x40000000;

    /**
     * Special share reserved for interprocess communication (IPC$) or remote administration of the server (ADMIN$).
     * Can also refer to administrative shares such as C$, D$, E$, and so forth. For more information, see the network share functions.
     */
    int STYPE_SPECIAL = 0x80000000;

    /**
     * Contains information about the shared resource, including name of the resource, type and permissions, number of connections, and other pertinent information.
     */
    public static class SHARE_INFO_2  extends Structure {
        public SHARE_INFO_2() {
            super();
        }

        public SHARE_INFO_2(Pointer memory) {
            super(memory);
            read();
        }

        /**
         * Pointer to a Unicode string specifying the name of a shared resource. Calls to the NetShareSetInfo function ignore this member.
         */
        public WString shi2_netname;

        /**
         * A combination of values that specify the type of share. Calls to the NetShareSetInfo function ignore this member.
         * One of the following values may be specified. You can isolate these values by using the STYPE_MASK value.
         * STYPE_DISKTREE, STYPE_PRINTQ, STYPE_DEVICE, STYPE_IPC, STYPE_TEMPORARY, STYPE_SPECIAL
         */
        public int shi2_type;

        /**
         * Pointer to a Unicode string specifying an optional comment about the shared resource.
         */
        public WString shi2_remark;

        /**
         * Specifies a DWORD value that indicates the shared resource's permissions for servers running with share-level security.
         * This member is ignored on a server running user-level security. This member can be any of the following values.
         * Calls to the NetShareSetInfo function ignore this member. Note that Windows does not support share-level security.
         * For more information about controlling access to securable objects, see Access Control, Privileges, and Securable Objects.
         * NOTE: Bit masks are defined in LmAccess.Java
         */
        public int shi2_permissions;

        /**
         * Specifies a DWORD value that indicates the maximum number of concurrent connections that the shared resource can accommodate.
         * The number of connections is unlimited if the value specified in this member is -1.
         */
        public int shi2_max_uses;

        /**
         * Specifies a DWORD value that indicates the number of current connections to the resource. Calls to the NetShareSetInfo function ignore this member.
         */
        public int shi2_current_uses;

        /**
         * Pointer to a Unicode string that contains the local path for the shared resource. For disks, this member is the path being shared.
         * For print queues, this member is the name of the print queue being shared. Calls to the NetShareSetInfo function ignore this member.
         */
        public WString shi2_path;

        /**
         * Pointer to a Unicode string that specifies the share's password (when the server is running with share-level security). If the server is
         * running with user-level security, this member is ignored. Note that Windows does not support share-level security.
         * This member can be no longer than SHPWLEN+1 bytes (including a terminating null character). Calls to the NetShareSetInfo function ignore this member.
         */
        public WString shi2_passwd;
        
        protected List getFieldOrder() {
            return Arrays.asList(new String[] { "shi2_netname",
                                                "shi2_type",
                                                "shi2_remark",
                                                "shi2_permissions",
                                                "shi2_max_uses",
                                                "shi2_current_uses",
                                                "shi2_path",
                                                "shi2_passwd" });
        }
    }

    /**
     * Contains information about the shared resource, including name of the resource, type and permissions, number of connections, and other pertinent information.
     */
    public static class SHARE_INFO_502 extends Structure {
        public SHARE_INFO_502() {
            super();
        }

        public SHARE_INFO_502(Pointer memory) {
            super(memory);
            read();
        }

        /**
         * Pointer to a Unicode string specifying the name of a shared resource. Calls to the NetShareSetInfo function ignore this member.
         */
        public WString shi502_netname;

        /**
         * A combination of values that specify the type of share. Calls to the NetShareSetInfo function ignore this member.
         * One of the following values may be specified. You can isolate these values by using the STYPE_MASK value.
         * STYPE_DISKTREE, STYPE_PRINTQ, STYPE_DEVICE, STYPE_IPC, STYPE_TEMPORARY, STYPE_SPECIAL
         */
        public int shi502_type;

        /**
         * Pointer to a Unicode string specifying an optional comment about the shared resource.
         */
        public WString shi502_remark;

        /**
         * Specifies a DWORD value that indicates the shared resource's permissions for servers running with share-level security.
         * This member is ignored on a server running user-level security. This member can be any of the following values.
         * Calls to the NetShareSetInfo function ignore this member. Note that Windows does not support share-level security.
         * For more information about controlling access to securable objects, see Access Control, Privileges, and Securable Objects.
         * NOTE: Bit masks are defined in LmAccess.Java
         */
        public int shi502_permissions;

        /**
         * Specifies a DWORD value that indicates the maximum number of concurrent connections that the shared resource can accommodate.
         * The number of connections is unlimited if the value specified in this member is -1.
         */
        public int shi502_max_uses;

        /**
         * Specifies a DWORD value that indicates the number of current connections to the resource. Calls to the NetShareSetInfo function ignore this member.
         */
        public int shi502_current_uses;

        /**
         * Pointer to a Unicode string that contains the local path for the shared resource. For disks, this member is the path being shared.
         * For print queues, this member is the name of the print queue being shared. Calls to the NetShareSetInfo function ignore this member.
         */
        public WString shi502_path;

        /**
         * Pointer to a Unicode string that specifies the share's password (when the server is running with share-level security). If the server is
         * running with user-level security, this member is ignored. Note that Windows does not support share-level security.
         * This member can be no longer than SHPWLEN+1 bytes (including a terminating null character). Calls to the NetShareSetInfo function ignore this member.
         */
        public WString shi502_passwd;

        /**
         * Reserved; must be zero. Calls to the NetShareSetInfo function ignore this member.
         */
        public int shi502_reserved;

        /**
         * Specifies the SECURITY_DESCRIPTOR associated with this share.
         */
        public Pointer shi502_security_descriptor;

        protected List getFieldOrder() {
            return Arrays.asList(new String[] { "shi502_netname",
                                                "shi502_type",
                                                "shi502_remark",
                                                "shi502_permissions",
                                                "shi502_max_uses",
                                                "shi502_current_uses",
                                                "shi502_path",
                                                "shi502_passwd",
                                                "shi502_reserved",
                                                "shi502_security_descriptor" });
        }
    }    
}
