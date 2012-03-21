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

package com.liferay.marketplace.util;

import com.liferay.portal.kernel.util.ReleaseInfo;

/**
 * @author Ryan Park
 */
public class MarketplaceConstants {

	public static final String MARKETPLACE_URL_LOGOUT =
		"http://mp.liferay.com/c/portal/logout";

	public static String getPathPurchased() {
		return _MARKETPLACE_PATH_PURCHASED + ReleaseInfo.getBuildNumber();
	}

	public static String getPathStore() {
		return _MARKETPLACE_PATH_STORE + ReleaseInfo.getBuildNumber();
	}

	private static final String _MARKETPLACE_PATH_PURCHASED =
		"/widget/web/guest/mpserver/-/mp_server/purchased/";

	private static final String _MARKETPLACE_PATH_STORE =
		"/widget/web/guest/mpserver/-/mp_server/store/";

}