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

package com.liferay.assettrending.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class AssetTrendingEntryFinderUtil {
	public static int countAssets(long[] classNameId, java.util.Date createDate) {
		return getFinder().countAssets(classNameId, createDate);
	}

	public static int countAssets(java.lang.String classNameIds,
		java.util.Date createDate) {
		return getFinder().countAssets(classNameIds, createDate);
	}

	public static java.util.List<com.liferay.assettrending.model.AssetTrendingEntry> findAssets(
		long[] classNameId, java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getFinder()
				   .findAssets(classNameId, createDate, start, end,
			orderByComparator);
	}

	public static java.util.List<com.liferay.assettrending.model.AssetTrendingEntry> findAssets(
		java.lang.String classNameIds, java.util.Date createDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getFinder()
				   .findAssets(classNameIds, createDate, start, end,
			orderByComparator);
	}

	public static AssetTrendingEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (AssetTrendingEntryFinder)PortletBeanLocatorUtil.locate(com.liferay.assettrending.service.ClpSerializer.getServletContextName(),
					AssetTrendingEntryFinder.class.getName());

			ReferenceRegistry.registerReference(AssetTrendingEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AssetTrendingEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AssetTrendingEntryFinderUtil.class,
			"_finder");
	}

	private static AssetTrendingEntryFinder _finder;
}