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

package com.liferay.assettrending.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AssetTrendingEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTrendingEntry
 * @generated
 */
@ProviderType
public class AssetTrendingEntryWrapper implements AssetTrendingEntry,
	ModelWrapper<AssetTrendingEntry> {
	public AssetTrendingEntryWrapper(AssetTrendingEntry assetTrendingEntry) {
		_assetTrendingEntry = assetTrendingEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return AssetTrendingEntry.class;
	}

	@Override
	public String getModelClassName() {
		return AssetTrendingEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("assetTrendingEntryId", getAssetTrendingEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("assetEntryId", getAssetEntryId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("commentCount", getCommentCount());
		attributes.put("payload", getPayload());
		attributes.put("priority", getPriority());
		attributes.put("ratingScore", getRatingScore());
		attributes.put("trendingScore", getTrendingScore());
		attributes.put("viewCount", getViewCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long assetTrendingEntryId = (Long)attributes.get("assetTrendingEntryId");

		if (assetTrendingEntryId != null) {
			setAssetTrendingEntryId(assetTrendingEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long assetEntryId = (Long)attributes.get("assetEntryId");

		if (assetEntryId != null) {
			setAssetEntryId(assetEntryId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Integer commentCount = (Integer)attributes.get("commentCount");

		if (commentCount != null) {
			setCommentCount(commentCount);
		}

		String payload = (String)attributes.get("payload");

		if (payload != null) {
			setPayload(payload);
		}

		Double priority = (Double)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Double ratingScore = (Double)attributes.get("ratingScore");

		if (ratingScore != null) {
			setRatingScore(ratingScore);
		}

		Double trendingScore = (Double)attributes.get("trendingScore");

		if (trendingScore != null) {
			setTrendingScore(trendingScore);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new AssetTrendingEntryWrapper((AssetTrendingEntry)_assetTrendingEntry.clone());
	}

	@Override
	public int compareTo(AssetTrendingEntry assetTrendingEntry) {
		return _assetTrendingEntry.compareTo(assetTrendingEntry);
	}

	/**
	* Returns the asset entry ID of this asset trending entry.
	*
	* @return the asset entry ID of this asset trending entry
	*/
	@Override
	public long getAssetEntryId() {
		return _assetTrendingEntry.getAssetEntryId();
	}

	/**
	* Returns the asset trending entry ID of this asset trending entry.
	*
	* @return the asset trending entry ID of this asset trending entry
	*/
	@Override
	public long getAssetTrendingEntryId() {
		return _assetTrendingEntry.getAssetTrendingEntryId();
	}

	/**
	* Returns the fully qualified class name of this asset trending entry.
	*
	* @return the fully qualified class name of this asset trending entry
	*/
	@Override
	public java.lang.String getClassName() {
		return _assetTrendingEntry.getClassName();
	}

	/**
	* Returns the class name ID of this asset trending entry.
	*
	* @return the class name ID of this asset trending entry
	*/
	@Override
	public long getClassNameId() {
		return _assetTrendingEntry.getClassNameId();
	}

	/**
	* Returns the class p k of this asset trending entry.
	*
	* @return the class p k of this asset trending entry
	*/
	@Override
	public long getClassPK() {
		return _assetTrendingEntry.getClassPK();
	}

	/**
	* Returns the comment count of this asset trending entry.
	*
	* @return the comment count of this asset trending entry
	*/
	@Override
	public int getCommentCount() {
		return _assetTrendingEntry.getCommentCount();
	}

	/**
	* Returns the company ID of this asset trending entry.
	*
	* @return the company ID of this asset trending entry
	*/
	@Override
	public long getCompanyId() {
		return _assetTrendingEntry.getCompanyId();
	}

	/**
	* Returns the create date of this asset trending entry.
	*
	* @return the create date of this asset trending entry
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _assetTrendingEntry.getCreateDate();
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _assetTrendingEntry.getExpandoBridge();
	}

	/**
	* Returns the group ID of this asset trending entry.
	*
	* @return the group ID of this asset trending entry
	*/
	@Override
	public long getGroupId() {
		return _assetTrendingEntry.getGroupId();
	}

	/**
	* Returns the modified date of this asset trending entry.
	*
	* @return the modified date of this asset trending entry
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _assetTrendingEntry.getModifiedDate();
	}

	/**
	* Returns the payload of this asset trending entry.
	*
	* @return the payload of this asset trending entry
	*/
	@Override
	public java.lang.String getPayload() {
		return _assetTrendingEntry.getPayload();
	}

	/**
	* Returns the primary key of this asset trending entry.
	*
	* @return the primary key of this asset trending entry
	*/
	@Override
	public long getPrimaryKey() {
		return _assetTrendingEntry.getPrimaryKey();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _assetTrendingEntry.getPrimaryKeyObj();
	}

	/**
	* Returns the priority of this asset trending entry.
	*
	* @return the priority of this asset trending entry
	*/
	@Override
	public double getPriority() {
		return _assetTrendingEntry.getPriority();
	}

	/**
	* Returns the rating score of this asset trending entry.
	*
	* @return the rating score of this asset trending entry
	*/
	@Override
	public double getRatingScore() {
		return _assetTrendingEntry.getRatingScore();
	}

	/**
	* Returns the trending score of this asset trending entry.
	*
	* @return the trending score of this asset trending entry
	*/
	@Override
	public double getTrendingScore() {
		return _assetTrendingEntry.getTrendingScore();
	}

	/**
	* Returns the view count of this asset trending entry.
	*
	* @return the view count of this asset trending entry
	*/
	@Override
	public int getViewCount() {
		return _assetTrendingEntry.getViewCount();
	}

	@Override
	public int hashCode() {
		return _assetTrendingEntry.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _assetTrendingEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _assetTrendingEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _assetTrendingEntry.isNew();
	}

	@Override
	public void persist() {
		_assetTrendingEntry.persist();
	}

	/**
	* Sets the asset entry ID of this asset trending entry.
	*
	* @param assetEntryId the asset entry ID of this asset trending entry
	*/
	@Override
	public void setAssetEntryId(long assetEntryId) {
		_assetTrendingEntry.setAssetEntryId(assetEntryId);
	}

	/**
	* Sets the asset trending entry ID of this asset trending entry.
	*
	* @param assetTrendingEntryId the asset trending entry ID of this asset trending entry
	*/
	@Override
	public void setAssetTrendingEntryId(long assetTrendingEntryId) {
		_assetTrendingEntry.setAssetTrendingEntryId(assetTrendingEntryId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_assetTrendingEntry.setCachedModel(cachedModel);
	}

	@Override
	public void setClassName(java.lang.String className) {
		_assetTrendingEntry.setClassName(className);
	}

	/**
	* Sets the class name ID of this asset trending entry.
	*
	* @param classNameId the class name ID of this asset trending entry
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_assetTrendingEntry.setClassNameId(classNameId);
	}

	/**
	* Sets the class p k of this asset trending entry.
	*
	* @param classPK the class p k of this asset trending entry
	*/
	@Override
	public void setClassPK(long classPK) {
		_assetTrendingEntry.setClassPK(classPK);
	}

	/**
	* Sets the comment count of this asset trending entry.
	*
	* @param commentCount the comment count of this asset trending entry
	*/
	@Override
	public void setCommentCount(int commentCount) {
		_assetTrendingEntry.setCommentCount(commentCount);
	}

	/**
	* Sets the company ID of this asset trending entry.
	*
	* @param companyId the company ID of this asset trending entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_assetTrendingEntry.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this asset trending entry.
	*
	* @param createDate the create date of this asset trending entry
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_assetTrendingEntry.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_assetTrendingEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_assetTrendingEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_assetTrendingEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this asset trending entry.
	*
	* @param groupId the group ID of this asset trending entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_assetTrendingEntry.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this asset trending entry.
	*
	* @param modifiedDate the modified date of this asset trending entry
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_assetTrendingEntry.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_assetTrendingEntry.setNew(n);
	}

	/**
	* Sets the payload of this asset trending entry.
	*
	* @param payload the payload of this asset trending entry
	*/
	@Override
	public void setPayload(java.lang.String payload) {
		_assetTrendingEntry.setPayload(payload);
	}

	/**
	* Sets the primary key of this asset trending entry.
	*
	* @param primaryKey the primary key of this asset trending entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_assetTrendingEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_assetTrendingEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the priority of this asset trending entry.
	*
	* @param priority the priority of this asset trending entry
	*/
	@Override
	public void setPriority(double priority) {
		_assetTrendingEntry.setPriority(priority);
	}

	/**
	* Sets the rating score of this asset trending entry.
	*
	* @param ratingScore the rating score of this asset trending entry
	*/
	@Override
	public void setRatingScore(double ratingScore) {
		_assetTrendingEntry.setRatingScore(ratingScore);
	}

	/**
	* Sets the trending score of this asset trending entry.
	*
	* @param trendingScore the trending score of this asset trending entry
	*/
	@Override
	public void setTrendingScore(double trendingScore) {
		_assetTrendingEntry.setTrendingScore(trendingScore);
	}

	/**
	* Sets the view count of this asset trending entry.
	*
	* @param viewCount the view count of this asset trending entry
	*/
	@Override
	public void setViewCount(int viewCount) {
		_assetTrendingEntry.setViewCount(viewCount);
	}

	@Override
	public com.liferay.portal.model.CacheModel<AssetTrendingEntry> toCacheModel() {
		return _assetTrendingEntry.toCacheModel();
	}

	@Override
	public AssetTrendingEntry toEscapedModel() {
		return new AssetTrendingEntryWrapper(_assetTrendingEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _assetTrendingEntry.toString();
	}

	@Override
	public AssetTrendingEntry toUnescapedModel() {
		return new AssetTrendingEntryWrapper(_assetTrendingEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _assetTrendingEntry.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssetTrendingEntryWrapper)) {
			return false;
		}

		AssetTrendingEntryWrapper assetTrendingEntryWrapper = (AssetTrendingEntryWrapper)obj;

		if (Validator.equals(_assetTrendingEntry,
					assetTrendingEntryWrapper._assetTrendingEntry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public AssetTrendingEntry getWrappedAssetTrendingEntry() {
		return _assetTrendingEntry;
	}

	@Override
	public AssetTrendingEntry getWrappedModel() {
		return _assetTrendingEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _assetTrendingEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _assetTrendingEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_assetTrendingEntry.resetOriginalValues();
	}

	private final AssetTrendingEntry _assetTrendingEntry;
}