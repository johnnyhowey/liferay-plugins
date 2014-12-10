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

package com.liferay.assettrending.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.assettrending.model.AssetTrendingEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AssetTrendingEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AssetTrendingEntry
 * @generated
 */
@ProviderType
public class AssetTrendingEntryCacheModel implements CacheModel<AssetTrendingEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{assetTrendingEntryId=");
		sb.append(assetTrendingEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", assetEntryId=");
		sb.append(assetEntryId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", commentCount=");
		sb.append(commentCount);
		sb.append(", payload=");
		sb.append(payload);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", ratingScore=");
		sb.append(ratingScore);
		sb.append(", trendingScore=");
		sb.append(trendingScore);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AssetTrendingEntry toEntityModel() {
		AssetTrendingEntryImpl assetTrendingEntryImpl = new AssetTrendingEntryImpl();

		assetTrendingEntryImpl.setAssetTrendingEntryId(assetTrendingEntryId);
		assetTrendingEntryImpl.setGroupId(groupId);
		assetTrendingEntryImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			assetTrendingEntryImpl.setCreateDate(null);
		}
		else {
			assetTrendingEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			assetTrendingEntryImpl.setModifiedDate(null);
		}
		else {
			assetTrendingEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		assetTrendingEntryImpl.setAssetEntryId(assetEntryId);
		assetTrendingEntryImpl.setClassNameId(classNameId);
		assetTrendingEntryImpl.setClassPK(classPK);
		assetTrendingEntryImpl.setCommentCount(commentCount);

		if (payload == null) {
			assetTrendingEntryImpl.setPayload(StringPool.BLANK);
		}
		else {
			assetTrendingEntryImpl.setPayload(payload);
		}

		assetTrendingEntryImpl.setPriority(priority);
		assetTrendingEntryImpl.setRatingScore(ratingScore);
		assetTrendingEntryImpl.setTrendingScore(trendingScore);
		assetTrendingEntryImpl.setViewCount(viewCount);

		assetTrendingEntryImpl.resetOriginalValues();

		return assetTrendingEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		assetTrendingEntryId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		assetEntryId = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		commentCount = objectInput.readInt();
		payload = objectInput.readUTF();
		priority = objectInput.readDouble();
		ratingScore = objectInput.readDouble();
		trendingScore = objectInput.readDouble();
		viewCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(assetTrendingEntryId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(assetEntryId);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);
		objectOutput.writeInt(commentCount);

		if (payload == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(payload);
		}

		objectOutput.writeDouble(priority);
		objectOutput.writeDouble(ratingScore);
		objectOutput.writeDouble(trendingScore);
		objectOutput.writeInt(viewCount);
	}

	public long assetTrendingEntryId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long assetEntryId;
	public long classNameId;
	public long classPK;
	public int commentCount;
	public String payload;
	public double priority;
	public double ratingScore;
	public double trendingScore;
	public int viewCount;
}