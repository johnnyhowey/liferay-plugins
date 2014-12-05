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

package com.liferay.so.activities.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.so.activities.model.SocialActivity;
import com.liferay.so.activities.model.SocialActivityModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SocialActivity service. Represents a row in the &quot;SO_SocialActivity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.so.activities.model.SocialActivityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SocialActivityImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivityImpl
 * @see com.liferay.so.activities.model.SocialActivity
 * @see com.liferay.so.activities.model.SocialActivityModel
 * @generated
 */
public class SocialActivityModelImpl extends BaseModelImpl<SocialActivity>
	implements SocialActivityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a social activity model instance should use the {@link com.liferay.so.activities.model.SocialActivity} interface instead.
	 */
	public static final String TABLE_NAME = "SO_SocialActivity";
	public static final Object[][] TABLE_COLUMNS = {
			{ "activityId", Types.BIGINT },
			{ "activitySetId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SO_SocialActivity (activityId LONG not null primary key,activitySetId LONG)";
	public static final String TABLE_SQL_DROP = "drop table SO_SocialActivity";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.so.activities.model.SocialActivity"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.so.activities.model.SocialActivity"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.so.activities.model.SocialActivity"),
			true);
	public static long ACTIVITYSETID_COLUMN_BITMASK = 1L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.so.activities.model.SocialActivity"));

	public SocialActivityModelImpl() {
	}

	public long getPrimaryKey() {
		return _activityId;
	}

	public void setPrimaryKey(long primaryKey) {
		setActivityId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_activityId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return SocialActivity.class;
	}

	public String getModelClassName() {
		return SocialActivity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activityId", getActivityId());
		attributes.put("activitySetId", getActivitySetId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		Long activitySetId = (Long)attributes.get("activitySetId");

		if (activitySetId != null) {
			setActivitySetId(activitySetId);
		}
	}

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
	}

	public long getActivitySetId() {
		return _activitySetId;
	}

	public void setActivitySetId(long activitySetId) {
		_columnBitmask |= ACTIVITYSETID_COLUMN_BITMASK;

		if (!_setOriginalActivitySetId) {
			_setOriginalActivitySetId = true;

			_originalActivitySetId = _activitySetId;
		}

		_activitySetId = activitySetId;
	}

	public long getOriginalActivitySetId() {
		return _originalActivitySetId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SocialActivity.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SocialActivity toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SocialActivity)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	public SocialActivity toUnescapedModel() {
		return (SocialActivity)this;
	}

	@Override
	public Object clone() {
		SocialActivityImpl socialActivityImpl = new SocialActivityImpl();

		socialActivityImpl.setActivityId(getActivityId());
		socialActivityImpl.setActivitySetId(getActivitySetId());

		socialActivityImpl.resetOriginalValues();

		return socialActivityImpl;
	}

	public int compareTo(SocialActivity socialActivity) {
		long primaryKey = socialActivity.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialActivity)) {
			return false;
		}

		SocialActivity socialActivity = (SocialActivity)obj;

		long primaryKey = socialActivity.getPrimaryKey();

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
	public void resetOriginalValues() {
		SocialActivityModelImpl socialActivityModelImpl = this;

		socialActivityModelImpl._originalActivitySetId = socialActivityModelImpl._activitySetId;

		socialActivityModelImpl._setOriginalActivitySetId = false;

		socialActivityModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SocialActivity> toCacheModel() {
		SocialActivityCacheModel socialActivityCacheModel = new SocialActivityCacheModel();

		socialActivityCacheModel.activityId = getActivityId();

		socialActivityCacheModel.activitySetId = getActivitySetId();

		return socialActivityCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{activityId=");
		sb.append(getActivityId());
		sb.append(", activitySetId=");
		sb.append(getActivitySetId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.so.activities.model.SocialActivity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>activityId</column-name><column-value><![CDATA[");
		sb.append(getActivityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activitySetId</column-name><column-value><![CDATA[");
		sb.append(getActivitySetId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SocialActivity.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SocialActivity.class
		};
	private long _activityId;
	private long _activitySetId;
	private long _originalActivitySetId;
	private boolean _setOriginalActivitySetId;
	private long _columnBitmask;
	private SocialActivity _escapedModel;
}