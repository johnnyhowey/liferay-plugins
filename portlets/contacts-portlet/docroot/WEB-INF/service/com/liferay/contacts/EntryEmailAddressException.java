/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.contacts;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryEmailAddressException extends PortalException {

	public static final int EMPTY = 1;
	public static final int NOT_EMAIL = 2;

	public EntryEmailAddressException() {
		super();
	}

	public EntryEmailAddressException(String msg) {
		super(msg);
	}

	public EntryEmailAddressException(int type) {
		_type = type;
	}

	public EntryEmailAddressException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryEmailAddressException(Throwable cause) {
		super(cause);
	}

	public int getType() {
		return _type;
	}

	private int _type;

}