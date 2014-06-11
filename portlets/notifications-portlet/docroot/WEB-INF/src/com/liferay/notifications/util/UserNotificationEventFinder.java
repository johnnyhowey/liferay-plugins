/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.notifications.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.UserNotificationEvent;

import java.util.List;

/**
 * @author Lin Cui
 */
public interface UserNotificationEventFinder {

	public List<UserNotificationEvent>
		getActionableArchivedUserNotificationEvents(
			long userId, boolean actionable, String[] actionableTypes,
			boolean archived, int start, int end)
		throws SystemException;

	public int getActionableArchivedUserNotificationEventsCount(
			long userId, boolean actionable, String[] actionableTypes,
			boolean archived)
		throws SystemException;

}