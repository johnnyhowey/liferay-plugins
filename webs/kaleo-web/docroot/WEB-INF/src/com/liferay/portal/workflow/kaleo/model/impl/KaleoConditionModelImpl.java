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

package com.liferay.portal.workflow.kaleo.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.model.KaleoConditionModel;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the KaleoCondition service. Represents a row in the &quot;KaleoCondition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.workflow.kaleo.model.KaleoConditionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoConditionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoConditionImpl
 * @see com.liferay.portal.workflow.kaleo.model.KaleoCondition
 * @see com.liferay.portal.workflow.kaleo.model.KaleoConditionModel
 * @generated
 */
public class KaleoConditionModelImpl extends BaseModelImpl<KaleoCondition>
	implements KaleoConditionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo condition model instance should use the {@link com.liferay.portal.workflow.kaleo.model.KaleoCondition} interface instead.
	 */
	public static final String TABLE_NAME = "KaleoCondition";
	public static final Object[][] TABLE_COLUMNS = {
			{ "kaleoConditionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "kaleoDefinitionId", Types.BIGINT },
			{ "kaleoNodeId", Types.BIGINT },
			{ "script", Types.CLOB },
			{ "scriptLanguage", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table KaleoCondition (kaleoConditionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoDefinitionId LONG,kaleoNodeId LONG,script TEXT null,scriptLanguage VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table KaleoCondition";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoCondition.kaleoConditionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoCondition.kaleoConditionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoCondition"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoCondition"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoCondition"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long KALEODEFINITIONID_COLUMN_BITMASK = 2L;
	public static long KALEONODEID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoCondition"));

	public KaleoConditionModelImpl() {
	}

	public long getPrimaryKey() {
		return _kaleoConditionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setKaleoConditionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_kaleoConditionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return KaleoCondition.class;
	}

	public String getModelClassName() {
		return KaleoCondition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kaleoConditionId", getKaleoConditionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kaleoDefinitionId", getKaleoDefinitionId());
		attributes.put("kaleoNodeId", getKaleoNodeId());
		attributes.put("script", getScript());
		attributes.put("scriptLanguage", getScriptLanguage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kaleoConditionId = (Long)attributes.get("kaleoConditionId");

		if (kaleoConditionId != null) {
			setKaleoConditionId(kaleoConditionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long kaleoDefinitionId = (Long)attributes.get("kaleoDefinitionId");

		if (kaleoDefinitionId != null) {
			setKaleoDefinitionId(kaleoDefinitionId);
		}

		Long kaleoNodeId = (Long)attributes.get("kaleoNodeId");

		if (kaleoNodeId != null) {
			setKaleoNodeId(kaleoNodeId);
		}

		String script = (String)attributes.get("script");

		if (script != null) {
			setScript(script);
		}

		String scriptLanguage = (String)attributes.get("scriptLanguage");

		if (scriptLanguage != null) {
			setScriptLanguage(scriptLanguage);
		}
	}

	public long getKaleoConditionId() {
		return _kaleoConditionId;
	}

	public void setKaleoConditionId(long kaleoConditionId) {
		_columnBitmask = -1L;

		_kaleoConditionId = kaleoConditionId;
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
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}

	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_columnBitmask |= KALEODEFINITIONID_COLUMN_BITMASK;

		if (!_setOriginalKaleoDefinitionId) {
			_setOriginalKaleoDefinitionId = true;

			_originalKaleoDefinitionId = _kaleoDefinitionId;
		}

		_kaleoDefinitionId = kaleoDefinitionId;
	}

	public long getOriginalKaleoDefinitionId() {
		return _originalKaleoDefinitionId;
	}

	public long getKaleoNodeId() {
		return _kaleoNodeId;
	}

	public void setKaleoNodeId(long kaleoNodeId) {
		_columnBitmask |= KALEONODEID_COLUMN_BITMASK;

		if (!_setOriginalKaleoNodeId) {
			_setOriginalKaleoNodeId = true;

			_originalKaleoNodeId = _kaleoNodeId;
		}

		_kaleoNodeId = kaleoNodeId;
	}

	public long getOriginalKaleoNodeId() {
		return _originalKaleoNodeId;
	}

	public String getScript() {
		if (_script == null) {
			return StringPool.BLANK;
		}
		else {
			return _script;
		}
	}

	public void setScript(String script) {
		_script = script;
	}

	public String getScriptLanguage() {
		if (_scriptLanguage == null) {
			return StringPool.BLANK;
		}
		else {
			return _scriptLanguage;
		}
	}

	public void setScriptLanguage(String scriptLanguage) {
		_scriptLanguage = scriptLanguage;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			KaleoCondition.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KaleoCondition toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KaleoCondition)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	public KaleoCondition toUnescapedModel() {
		return (KaleoCondition)this;
	}

	@Override
	public Object clone() {
		KaleoConditionImpl kaleoConditionImpl = new KaleoConditionImpl();

		kaleoConditionImpl.setKaleoConditionId(getKaleoConditionId());
		kaleoConditionImpl.setGroupId(getGroupId());
		kaleoConditionImpl.setCompanyId(getCompanyId());
		kaleoConditionImpl.setUserId(getUserId());
		kaleoConditionImpl.setUserName(getUserName());
		kaleoConditionImpl.setCreateDate(getCreateDate());
		kaleoConditionImpl.setModifiedDate(getModifiedDate());
		kaleoConditionImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoConditionImpl.setKaleoNodeId(getKaleoNodeId());
		kaleoConditionImpl.setScript(getScript());
		kaleoConditionImpl.setScriptLanguage(getScriptLanguage());

		kaleoConditionImpl.resetOriginalValues();

		return kaleoConditionImpl;
	}

	public int compareTo(KaleoCondition kaleoCondition) {
		int value = 0;

		if (getKaleoConditionId() < kaleoCondition.getKaleoConditionId()) {
			value = -1;
		}
		else if (getKaleoConditionId() > kaleoCondition.getKaleoConditionId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof KaleoCondition)) {
			return false;
		}

		KaleoCondition kaleoCondition = (KaleoCondition)obj;

		long primaryKey = kaleoCondition.getPrimaryKey();

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
		KaleoConditionModelImpl kaleoConditionModelImpl = this;

		kaleoConditionModelImpl._originalCompanyId = kaleoConditionModelImpl._companyId;

		kaleoConditionModelImpl._setOriginalCompanyId = false;

		kaleoConditionModelImpl._originalKaleoDefinitionId = kaleoConditionModelImpl._kaleoDefinitionId;

		kaleoConditionModelImpl._setOriginalKaleoDefinitionId = false;

		kaleoConditionModelImpl._originalKaleoNodeId = kaleoConditionModelImpl._kaleoNodeId;

		kaleoConditionModelImpl._setOriginalKaleoNodeId = false;

		kaleoConditionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KaleoCondition> toCacheModel() {
		KaleoConditionCacheModel kaleoConditionCacheModel = new KaleoConditionCacheModel();

		kaleoConditionCacheModel.kaleoConditionId = getKaleoConditionId();

		kaleoConditionCacheModel.groupId = getGroupId();

		kaleoConditionCacheModel.companyId = getCompanyId();

		kaleoConditionCacheModel.userId = getUserId();

		kaleoConditionCacheModel.userName = getUserName();

		String userName = kaleoConditionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoConditionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoConditionCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoConditionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoConditionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoConditionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoConditionCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoConditionCacheModel.kaleoNodeId = getKaleoNodeId();

		kaleoConditionCacheModel.script = getScript();

		String script = kaleoConditionCacheModel.script;

		if ((script != null) && (script.length() == 0)) {
			kaleoConditionCacheModel.script = null;
		}

		kaleoConditionCacheModel.scriptLanguage = getScriptLanguage();

		String scriptLanguage = kaleoConditionCacheModel.scriptLanguage;

		if ((scriptLanguage != null) && (scriptLanguage.length() == 0)) {
			kaleoConditionCacheModel.scriptLanguage = null;
		}

		return kaleoConditionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{kaleoConditionId=");
		sb.append(getKaleoConditionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", kaleoDefinitionId=");
		sb.append(getKaleoDefinitionId());
		sb.append(", kaleoNodeId=");
		sb.append(getKaleoNodeId());
		sb.append(", script=");
		sb.append(getScript());
		sb.append(", scriptLanguage=");
		sb.append(getScriptLanguage());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.workflow.kaleo.model.KaleoCondition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoConditionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoConditionId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>kaleoDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoNodeId</column-name><column-value><![CDATA[");
		sb.append(getKaleoNodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>script</column-name><column-value><![CDATA[");
		sb.append(getScript());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scriptLanguage</column-name><column-value><![CDATA[");
		sb.append(getScriptLanguage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KaleoCondition.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			KaleoCondition.class
		};
	private long _kaleoConditionId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _kaleoDefinitionId;
	private long _originalKaleoDefinitionId;
	private boolean _setOriginalKaleoDefinitionId;
	private long _kaleoNodeId;
	private long _originalKaleoNodeId;
	private boolean _setOriginalKaleoNodeId;
	private String _script;
	private String _scriptLanguage;
	private long _columnBitmask;
	private KaleoCondition _escapedModel;
}