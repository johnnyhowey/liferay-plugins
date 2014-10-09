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

package com.liferay.trending.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.trending.model.AssetTrendingEntry;
import com.liferay.trending.model.AssetTrendingEntryModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the AssetTrendingEntry service. Represents a row in the &quot;AssetTrendingEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.trending.model.AssetTrendingEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetTrendingEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTrendingEntryImpl
 * @see com.liferay.trending.model.AssetTrendingEntry
 * @see com.liferay.trending.model.AssetTrendingEntryModel
 * @generated
 */
@ProviderType
public class AssetTrendingEntryModelImpl extends BaseModelImpl<AssetTrendingEntry>
	implements AssetTrendingEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset trending entry model instance should use the {@link com.liferay.trending.model.AssetTrendingEntry} interface instead.
	 */
	public static final String TABLE_NAME = "AssetTrendingEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "assetTrendingEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "assetEntryId", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "commentCount", Types.INTEGER },
			{ "payload", Types.VARCHAR },
			{ "priority", Types.DOUBLE },
			{ "ratingScore", Types.DOUBLE },
			{ "trendingScore", Types.DOUBLE },
			{ "viewCount", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table AssetTrendingEntry (assetTrendingEntryId LONG not null primary key,groupId LONG,companyId LONG,createDate DATE null,modifiedDate DATE null,assetEntryId LONG,classNameId LONG,classPK LONG,commentCount INTEGER,payload VARCHAR(75) null,priority DOUBLE,ratingScore DOUBLE,trendingScore DOUBLE,viewCount INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table AssetTrendingEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY assetTrendingEntry.viewCount DESC";
	public static final String ORDER_BY_SQL = " ORDER BY AssetTrendingEntry.viewCount DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.trending.model.AssetTrendingEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.trending.model.AssetTrendingEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.trending.model.AssetTrendingEntry"),
			true);
	public static final long ASSETENTRYID_COLUMN_BITMASK = 1L;
	public static final long CLASSNAMEID_COLUMN_BITMASK = 2L;
	public static final long CLASSPK_COLUMN_BITMASK = 4L;
	public static final long VIEWCOUNT_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.trending.model.AssetTrendingEntry"));

	public AssetTrendingEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _assetTrendingEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAssetTrendingEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assetTrendingEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public long getAssetTrendingEntryId() {
		return _assetTrendingEntryId;
	}

	@Override
	public void setAssetTrendingEntryId(long assetTrendingEntryId) {
		_assetTrendingEntryId = assetTrendingEntryId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getAssetEntryId() {
		return _assetEntryId;
	}

	@Override
	public void setAssetEntryId(long assetEntryId) {
		_columnBitmask |= ASSETENTRYID_COLUMN_BITMASK;

		if (!_setOriginalAssetEntryId) {
			_setOriginalAssetEntryId = true;

			_originalAssetEntryId = _assetEntryId;
		}

		_assetEntryId = assetEntryId;
	}

	public long getOriginalAssetEntryId() {
		return _originalAssetEntryId;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@Override
	public int getCommentCount() {
		return _commentCount;
	}

	@Override
	public void setCommentCount(int commentCount) {
		_commentCount = commentCount;
	}

	@Override
	public String getPayload() {
		if (_payload == null) {
			return StringPool.BLANK;
		}
		else {
			return _payload;
		}
	}

	@Override
	public void setPayload(String payload) {
		_payload = payload;
	}

	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		_priority = priority;
	}

	@Override
	public double getRatingScore() {
		return _ratingScore;
	}

	@Override
	public void setRatingScore(double ratingScore) {
		_ratingScore = ratingScore;
	}

	@Override
	public double getTrendingScore() {
		return _trendingScore;
	}

	@Override
	public void setTrendingScore(double trendingScore) {
		_trendingScore = trendingScore;
	}

	@Override
	public int getViewCount() {
		return _viewCount;
	}

	@Override
	public void setViewCount(int viewCount) {
		_columnBitmask = -1L;

		_viewCount = viewCount;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AssetTrendingEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AssetTrendingEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AssetTrendingEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AssetTrendingEntryImpl assetTrendingEntryImpl = new AssetTrendingEntryImpl();

		assetTrendingEntryImpl.setAssetTrendingEntryId(getAssetTrendingEntryId());
		assetTrendingEntryImpl.setGroupId(getGroupId());
		assetTrendingEntryImpl.setCompanyId(getCompanyId());
		assetTrendingEntryImpl.setCreateDate(getCreateDate());
		assetTrendingEntryImpl.setModifiedDate(getModifiedDate());
		assetTrendingEntryImpl.setAssetEntryId(getAssetEntryId());
		assetTrendingEntryImpl.setClassNameId(getClassNameId());
		assetTrendingEntryImpl.setClassPK(getClassPK());
		assetTrendingEntryImpl.setCommentCount(getCommentCount());
		assetTrendingEntryImpl.setPayload(getPayload());
		assetTrendingEntryImpl.setPriority(getPriority());
		assetTrendingEntryImpl.setRatingScore(getRatingScore());
		assetTrendingEntryImpl.setTrendingScore(getTrendingScore());
		assetTrendingEntryImpl.setViewCount(getViewCount());

		assetTrendingEntryImpl.resetOriginalValues();

		return assetTrendingEntryImpl;
	}

	@Override
	public int compareTo(AssetTrendingEntry assetTrendingEntry) {
		int value = 0;

		if (getViewCount() < assetTrendingEntry.getViewCount()) {
			value = -1;
		}
		else if (getViewCount() > assetTrendingEntry.getViewCount()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssetTrendingEntry)) {
			return false;
		}

		AssetTrendingEntry assetTrendingEntry = (AssetTrendingEntry)obj;

		long primaryKey = assetTrendingEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		AssetTrendingEntryModelImpl assetTrendingEntryModelImpl = this;

		assetTrendingEntryModelImpl._originalAssetEntryId = assetTrendingEntryModelImpl._assetEntryId;

		assetTrendingEntryModelImpl._setOriginalAssetEntryId = false;

		assetTrendingEntryModelImpl._originalClassNameId = assetTrendingEntryModelImpl._classNameId;

		assetTrendingEntryModelImpl._setOriginalClassNameId = false;

		assetTrendingEntryModelImpl._originalClassPK = assetTrendingEntryModelImpl._classPK;

		assetTrendingEntryModelImpl._setOriginalClassPK = false;

		assetTrendingEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AssetTrendingEntry> toCacheModel() {
		AssetTrendingEntryCacheModel assetTrendingEntryCacheModel = new AssetTrendingEntryCacheModel();

		assetTrendingEntryCacheModel.assetTrendingEntryId = getAssetTrendingEntryId();

		assetTrendingEntryCacheModel.groupId = getGroupId();

		assetTrendingEntryCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			assetTrendingEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			assetTrendingEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			assetTrendingEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			assetTrendingEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		assetTrendingEntryCacheModel.assetEntryId = getAssetEntryId();

		assetTrendingEntryCacheModel.classNameId = getClassNameId();

		assetTrendingEntryCacheModel.classPK = getClassPK();

		assetTrendingEntryCacheModel.commentCount = getCommentCount();

		assetTrendingEntryCacheModel.payload = getPayload();

		String payload = assetTrendingEntryCacheModel.payload;

		if ((payload != null) && (payload.length() == 0)) {
			assetTrendingEntryCacheModel.payload = null;
		}

		assetTrendingEntryCacheModel.priority = getPriority();

		assetTrendingEntryCacheModel.ratingScore = getRatingScore();

		assetTrendingEntryCacheModel.trendingScore = getTrendingScore();

		assetTrendingEntryCacheModel.viewCount = getViewCount();

		return assetTrendingEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{assetTrendingEntryId=");
		sb.append(getAssetTrendingEntryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", assetEntryId=");
		sb.append(getAssetEntryId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", commentCount=");
		sb.append(getCommentCount());
		sb.append(", payload=");
		sb.append(getPayload());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", ratingScore=");
		sb.append(getRatingScore());
		sb.append(", trendingScore=");
		sb.append(getTrendingScore());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.trending.model.AssetTrendingEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>assetTrendingEntryId</column-name><column-value><![CDATA[");
		sb.append(getAssetTrendingEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetEntryId</column-name><column-value><![CDATA[");
		sb.append(getAssetEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commentCount</column-name><column-value><![CDATA[");
		sb.append(getCommentCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payload</column-name><column-value><![CDATA[");
		sb.append(getPayload());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingScore</column-name><column-value><![CDATA[");
		sb.append(getRatingScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trendingScore</column-name><column-value><![CDATA[");
		sb.append(getTrendingScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = AssetTrendingEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			AssetTrendingEntry.class
		};
	private long _assetTrendingEntryId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _assetEntryId;
	private long _originalAssetEntryId;
	private boolean _setOriginalAssetEntryId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private int _commentCount;
	private String _payload;
	private double _priority;
	private double _ratingScore;
	private double _trendingScore;
	private int _viewCount;
	private long _columnBitmask;
	private AssetTrendingEntry _escapedModel;
}