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

import com.liferay.assettrending.service.AssetTrendingEntryLocalServiceUtil;
import com.liferay.assettrending.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class AssetTrendingEntryClp extends BaseModelImpl<AssetTrendingEntry>
	implements AssetTrendingEntry {
	public AssetTrendingEntryClp() {
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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getAssetTrendingEntryId() {
		return _assetTrendingEntryId;
	}

	@Override
	public void setAssetTrendingEntryId(long assetTrendingEntryId) {
		_assetTrendingEntryId = assetTrendingEntryId;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAssetTrendingEntryId",
						long.class);

				method.invoke(_assetTrendingEntryRemoteModel,
					assetTrendingEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_assetTrendingEntryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_assetTrendingEntryRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_assetTrendingEntryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_assetTrendingEntryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssetEntryId() {
		return _assetEntryId;
	}

	@Override
	public void setAssetEntryId(long assetEntryId) {
		_assetEntryId = assetEntryId;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAssetEntryId", long.class);

				method.invoke(_assetTrendingEntryRemoteModel, assetEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		_classNameId = classNameId;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_assetTrendingEntryRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_assetTrendingEntryRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCommentCount() {
		return _commentCount;
	}

	@Override
	public void setCommentCount(int commentCount) {
		_commentCount = commentCount;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCommentCount", int.class);

				method.invoke(_assetTrendingEntryRemoteModel, commentCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPayload() {
		return _payload;
	}

	@Override
	public void setPayload(String payload) {
		_payload = payload;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setPayload", String.class);

				method.invoke(_assetTrendingEntryRemoteModel, payload);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		_priority = priority;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setPriority", double.class);

				method.invoke(_assetTrendingEntryRemoteModel, priority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getRatingScore() {
		return _ratingScore;
	}

	@Override
	public void setRatingScore(double ratingScore) {
		_ratingScore = ratingScore;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setRatingScore", double.class);

				method.invoke(_assetTrendingEntryRemoteModel, ratingScore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTrendingScore() {
		return _trendingScore;
	}

	@Override
	public void setTrendingScore(double trendingScore) {
		_trendingScore = trendingScore;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setTrendingScore", double.class);

				method.invoke(_assetTrendingEntryRemoteModel, trendingScore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getViewCount() {
		return _viewCount;
	}

	@Override
	public void setViewCount(int viewCount) {
		_viewCount = viewCount;

		if (_assetTrendingEntryRemoteModel != null) {
			try {
				Class<?> clazz = _assetTrendingEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setViewCount", int.class);

				method.invoke(_assetTrendingEntryRemoteModel, viewCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAssetTrendingEntryRemoteModel() {
		return _assetTrendingEntryRemoteModel;
	}

	public void setAssetTrendingEntryRemoteModel(
		BaseModel<?> assetTrendingEntryRemoteModel) {
		_assetTrendingEntryRemoteModel = assetTrendingEntryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _assetTrendingEntryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_assetTrendingEntryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			AssetTrendingEntryLocalServiceUtil.addAssetTrendingEntry(this);
		}
		else {
			AssetTrendingEntryLocalServiceUtil.updateAssetTrendingEntry(this);
		}
	}

	@Override
	public AssetTrendingEntry toEscapedModel() {
		return (AssetTrendingEntry)ProxyUtil.newProxyInstance(AssetTrendingEntry.class.getClassLoader(),
			new Class[] { AssetTrendingEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AssetTrendingEntryClp clone = new AssetTrendingEntryClp();

		clone.setAssetTrendingEntryId(getAssetTrendingEntryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAssetEntryId(getAssetEntryId());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());
		clone.setCommentCount(getCommentCount());
		clone.setPayload(getPayload());
		clone.setPriority(getPriority());
		clone.setRatingScore(getRatingScore());
		clone.setTrendingScore(getTrendingScore());
		clone.setViewCount(getViewCount());

		return clone;
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

		if (!(obj instanceof AssetTrendingEntryClp)) {
			return false;
		}

		AssetTrendingEntryClp assetTrendingEntry = (AssetTrendingEntryClp)obj;

		long primaryKey = assetTrendingEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
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
		sb.append("com.liferay.assettrending.model.AssetTrendingEntry");
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
	private BaseModel<?> _assetTrendingEntryRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.assettrending.service.ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}