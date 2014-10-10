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

package com.liferay.assettrending.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.assettrending.NoSuchEntryException;
import com.liferay.assettrending.model.AssetTrendingEntry;
import com.liferay.assettrending.service.base.AssetTrendingEntryLocalServiceBaseImpl;
import com.liferay.assettrending.util.AssetTrendingUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

/**
 * @author Lin Cui
 */
@ProviderType
public class AssetTrendingEntryLocalServiceImpl
	extends AssetTrendingEntryLocalServiceBaseImpl {

	public AssetTrendingEntry addAssetTrendingEntry(
		long groupId, long companyId, Date createDate, Date modifiedDate,
		long assetEntryId, long classNameId, long classPK, int commentCount,
		double priority, double ratingScore, int viewCount) {

		long entryId = CounterLocalServiceUtil.increment();

		AssetTrendingEntry trendingAssetEntry =
			assetTrendingEntryPersistence.create(entryId);

		trendingAssetEntry.setGroupId(groupId);
		trendingAssetEntry.setCompanyId(companyId);
		trendingAssetEntry.setCreateDate(createDate);
		trendingAssetEntry.setModifiedDate(modifiedDate);
		trendingAssetEntry.setAssetEntryId(assetEntryId);
		trendingAssetEntry.setClassNameId(classNameId);
		trendingAssetEntry.setClassPK(classPK);
		trendingAssetEntry.setCommentCount(commentCount);
		trendingAssetEntry.setPriority(priority);
		trendingAssetEntry.setRatingScore(ratingScore);
		trendingAssetEntry.setViewCount(viewCount);
		trendingAssetEntry.setPayload(AssetTrendingUtil.getInitPayload());

		assetTrendingEntryPersistence.update(trendingAssetEntry);

		return trendingAssetEntry;
	}

	public AssetTrendingEntry deleteAssetTrendingEntry(
		long classNameId, long classPK) {

		AssetTrendingEntry trendingAssetEntry = getAssetTrendingEntry(
			classNameId, classPK);

		assetTrendingEntryPersistence.remove(trendingAssetEntry);

		return trendingAssetEntry;
	}

	public List<AssetTrendingEntry> getAssetTrendingEntries(
			String classNameIds, Date createDate, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException {

		return assetTrendingEntryFinder.findAssets(
			classNameIds, createDate, start, end, orderByComparator);
	}

	public int getAssetTrendingEntriesCount(
			String classNameIds, Date createDate)
		throws PortalException {

		return assetTrendingEntryFinder.countAssets(classNameIds, createDate);
	}

	public AssetTrendingEntry getAssetTrendingEntry(long assetEntryId) {
		AssetTrendingEntry assetTrendingEntry = null;

		try {
			assetTrendingEntry =
				assetTrendingEntryPersistence.findByAssetEntryId(assetEntryId);
		}
		catch (NoSuchEntryException nsee) {
			return null;
		}

		return assetTrendingEntry;
	}

	public AssetTrendingEntry getAssetTrendingEntry(
		long classNameId, long classPK) {

		AssetTrendingEntry assetTrendingEntry = null;

		try {
			assetTrendingEntry = assetTrendingEntryPersistence.findByC_C(
				classNameId, classPK);
		}
		catch (NoSuchEntryException nsee) {
			return null;
		}

		return assetTrendingEntry;
	}

	public AssetTrendingEntry updateAssetTrendingEntry(
		AssetTrendingEntry assetTrendingEntry, double trendingScore) {

		if (assetTrendingEntry == null) {
			return null;
		}

		assetTrendingEntry.setModifiedDate(new Date());
		assetTrendingEntry.setTrendingScore(trendingScore);

		assetTrendingEntryPersistence.update(assetTrendingEntry);

		return assetTrendingEntry;
	}

	public AssetTrendingEntry updateAssetTrendingEntry(
		long groupId, long companyId, Date createDate, Date modifiedDate,
		long assetEntryId, long classNameId, long classPK, int commentCount,
		double priority, double ratingScore, int viewCount) {

		AssetTrendingEntry assetTrendingEntry = getAssetTrendingEntry(
			classNameId, classPK);

		if (assetTrendingEntry == null) {
			return addAssetTrendingEntry(
				groupId, companyId, createDate, modifiedDate, assetEntryId,
				classNameId, classPK, commentCount, priority, ratingScore,
				viewCount);
		}

		assetTrendingEntry.setModifiedDate(new Date());
		assetTrendingEntry.setCommentCount(commentCount);
		assetTrendingEntry.setPriority(priority);
		assetTrendingEntry.setRatingScore(ratingScore);
		assetTrendingEntry.setViewCount(viewCount);

		assetTrendingEntryPersistence.update(assetTrendingEntry);

		return assetTrendingEntry;
	}

	public AssetTrendingEntry updateAssetTrendingEntry(
		long classNameId, long classPK, double ratingScore) {

		AssetTrendingEntry assetTrendingEntry = getAssetTrendingEntry(
			classNameId, classPK);

		if (assetTrendingEntry == null) {
			return null;
		}

		assetTrendingEntry.setModifiedDate(new Date());
		assetTrendingEntry.setRatingScore(ratingScore);

		assetTrendingEntryPersistence.update(assetTrendingEntry);

		return assetTrendingEntry;
	}

}