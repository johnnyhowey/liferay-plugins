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

package com.liferay.asset.sharing.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class AssetSharingEntryFinderUtil {
	public static int countAssetEntriesByUserId(long userId,
		long[] classNameIds, java.util.Map<java.lang.Long, long[]> sharedTos) {
		return getFinder()
				   .countAssetEntriesByUserId(userId, classNameIds, sharedTos);
	}

	public static java.util.List<java.lang.Object[]> findAssetEntriesByUserId(
		long userId, long[] classNameIds,
		java.util.Map<java.lang.Long, long[]> sharedTos, int start, int end) {
		return getFinder()
				   .findAssetEntriesByUserId(userId, classNameIds, sharedTos,
			start, end);
	}

	public static AssetSharingEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (AssetSharingEntryFinder)PortletBeanLocatorUtil.locate(com.liferay.asset.sharing.service.ClpSerializer.getServletContextName(),
					AssetSharingEntryFinder.class.getName());

			ReferenceRegistry.registerReference(AssetSharingEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AssetSharingEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AssetSharingEntryFinderUtil.class,
			"_finder");
	}

	private static AssetSharingEntryFinder _finder;
}