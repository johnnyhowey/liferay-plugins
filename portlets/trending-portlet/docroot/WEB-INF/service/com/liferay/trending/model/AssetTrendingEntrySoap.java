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

package com.liferay.trending.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AssetTrendingEntrySoap implements Serializable {
	public static AssetTrendingEntrySoap toSoapModel(AssetTrendingEntry model) {
		AssetTrendingEntrySoap soapModel = new AssetTrendingEntrySoap();

		soapModel.setAssetTrendingEntryId(model.getAssetTrendingEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAssetEntryId(model.getAssetEntryId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setCommentCount(model.getCommentCount());
		soapModel.setPayload(model.getPayload());
		soapModel.setPriority(model.getPriority());
		soapModel.setRatingScore(model.getRatingScore());
		soapModel.setTrendingScore(model.getTrendingScore());
		soapModel.setViewCount(model.getViewCount());

		return soapModel;
	}

	public static AssetTrendingEntrySoap[] toSoapModels(
		AssetTrendingEntry[] models) {
		AssetTrendingEntrySoap[] soapModels = new AssetTrendingEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AssetTrendingEntrySoap[][] toSoapModels(
		AssetTrendingEntry[][] models) {
		AssetTrendingEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AssetTrendingEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AssetTrendingEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AssetTrendingEntrySoap[] toSoapModels(
		List<AssetTrendingEntry> models) {
		List<AssetTrendingEntrySoap> soapModels = new ArrayList<AssetTrendingEntrySoap>(models.size());

		for (AssetTrendingEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AssetTrendingEntrySoap[soapModels.size()]);
	}

	public AssetTrendingEntrySoap() {
	}

	public long getPrimaryKey() {
		return _assetTrendingEntryId;
	}

	public void setPrimaryKey(long pk) {
		setAssetTrendingEntryId(pk);
	}

	public long getAssetTrendingEntryId() {
		return _assetTrendingEntryId;
	}

	public void setAssetTrendingEntryId(long assetTrendingEntryId) {
		_assetTrendingEntryId = assetTrendingEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAssetEntryId() {
		return _assetEntryId;
	}

	public void setAssetEntryId(long assetEntryId) {
		_assetEntryId = assetEntryId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public int getCommentCount() {
		return _commentCount;
	}

	public void setCommentCount(int commentCount) {
		_commentCount = commentCount;
	}

	public String getPayload() {
		return _payload;
	}

	public void setPayload(String payload) {
		_payload = payload;
	}

	public double getPriority() {
		return _priority;
	}

	public void setPriority(double priority) {
		_priority = priority;
	}

	public double getRatingScore() {
		return _ratingScore;
	}

	public void setRatingScore(double ratingScore) {
		_ratingScore = ratingScore;
	}

	public double getTrendingScore() {
		return _trendingScore;
	}

	public void setTrendingScore(double trendingScore) {
		_trendingScore = trendingScore;
	}

	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	private long _assetTrendingEntryId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _assetEntryId;
	private long _classNameId;
	private long _classPK;
	private int _commentCount;
	private String _payload;
	private double _priority;
	private double _ratingScore;
	private double _trendingScore;
	private int _viewCount;
}