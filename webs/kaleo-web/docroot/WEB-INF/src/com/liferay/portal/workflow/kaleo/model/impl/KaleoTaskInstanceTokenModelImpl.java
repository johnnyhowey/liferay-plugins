/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceTokenModel;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the KaleoTaskInstanceToken service. Represents a row in the &quot;KaleoTaskInstanceToken&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceTokenModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoTaskInstanceTokenImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTaskInstanceTokenImpl
 * @see com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken
 * @see com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceTokenModel
 * @generated
 */
public class KaleoTaskInstanceTokenModelImpl extends BaseModelImpl<KaleoTaskInstanceToken>
	implements KaleoTaskInstanceTokenModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo task instance token model instance should use the {@link com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken} interface instead.
	 */
	public static final String TABLE_NAME = "KaleoTaskInstanceToken";
	public static final Object[][] TABLE_COLUMNS = {
			{ "kaleoTaskInstanceTokenId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "kaleoDefinitionId", Types.BIGINT },
			{ "kaleoInstanceId", Types.BIGINT },
			{ "kaleoInstanceTokenId", Types.BIGINT },
			{ "kaleoTaskId", Types.BIGINT },
			{ "kaleoTaskName", Types.VARCHAR },
			{ "className", Types.VARCHAR },
			{ "classPK", Types.BIGINT },
			{ "completionUserId", Types.BIGINT },
			{ "completed", Types.BOOLEAN },
			{ "completionDate", Types.TIMESTAMP },
			{ "dueDate", Types.TIMESTAMP },
			{ "workflowContext", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table KaleoTaskInstanceToken (kaleoTaskInstanceTokenId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoDefinitionId LONG,kaleoInstanceId LONG,kaleoInstanceTokenId LONG,kaleoTaskId LONG,kaleoTaskName VARCHAR(200) null,className VARCHAR(200) null,classPK LONG,completionUserId LONG,completed BOOLEAN,completionDate DATE null,dueDate DATE null,workflowContext TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table KaleoTaskInstanceToken";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoTaskInstanceToken.kaleoTaskInstanceTokenId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoTaskInstanceToken.kaleoTaskInstanceTokenId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long KALEODEFINITIONID_COLUMN_BITMASK = 2L;
	public static long KALEOINSTANCEID_COLUMN_BITMASK = 4L;
	public static long KALEOTASKID_COLUMN_BITMASK = 8L;
	public static long KALEOTASKINSTANCETOKENID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken"));

	public KaleoTaskInstanceTokenModelImpl() {
	}

	public long getPrimaryKey() {
		return _kaleoTaskInstanceTokenId;
	}

	public void setPrimaryKey(long primaryKey) {
		setKaleoTaskInstanceTokenId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_kaleoTaskInstanceTokenId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return KaleoTaskInstanceToken.class;
	}

	public String getModelClassName() {
		return KaleoTaskInstanceToken.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kaleoTaskInstanceTokenId", getKaleoTaskInstanceTokenId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kaleoDefinitionId", getKaleoDefinitionId());
		attributes.put("kaleoInstanceId", getKaleoInstanceId());
		attributes.put("kaleoInstanceTokenId", getKaleoInstanceTokenId());
		attributes.put("kaleoTaskId", getKaleoTaskId());
		attributes.put("kaleoTaskName", getKaleoTaskName());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("completionUserId", getCompletionUserId());
		attributes.put("completed", getCompleted());
		attributes.put("completionDate", getCompletionDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("workflowContext", getWorkflowContext());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kaleoTaskInstanceTokenId = (Long)attributes.get(
				"kaleoTaskInstanceTokenId");

		if (kaleoTaskInstanceTokenId != null) {
			setKaleoTaskInstanceTokenId(kaleoTaskInstanceTokenId);
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

		Long kaleoInstanceId = (Long)attributes.get("kaleoInstanceId");

		if (kaleoInstanceId != null) {
			setKaleoInstanceId(kaleoInstanceId);
		}

		Long kaleoInstanceTokenId = (Long)attributes.get("kaleoInstanceTokenId");

		if (kaleoInstanceTokenId != null) {
			setKaleoInstanceTokenId(kaleoInstanceTokenId);
		}

		Long kaleoTaskId = (Long)attributes.get("kaleoTaskId");

		if (kaleoTaskId != null) {
			setKaleoTaskId(kaleoTaskId);
		}

		String kaleoTaskName = (String)attributes.get("kaleoTaskName");

		if (kaleoTaskName != null) {
			setKaleoTaskName(kaleoTaskName);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long completionUserId = (Long)attributes.get("completionUserId");

		if (completionUserId != null) {
			setCompletionUserId(completionUserId);
		}

		Boolean completed = (Boolean)attributes.get("completed");

		if (completed != null) {
			setCompleted(completed);
		}

		Date completionDate = (Date)attributes.get("completionDate");

		if (completionDate != null) {
			setCompletionDate(completionDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		String workflowContext = (String)attributes.get("workflowContext");

		if (workflowContext != null) {
			setWorkflowContext(workflowContext);
		}
	}

	public long getKaleoTaskInstanceTokenId() {
		return _kaleoTaskInstanceTokenId;
	}

	public void setKaleoTaskInstanceTokenId(long kaleoTaskInstanceTokenId) {
		_columnBitmask = -1L;

		_kaleoTaskInstanceTokenId = kaleoTaskInstanceTokenId;
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

	public long getKaleoInstanceId() {
		return _kaleoInstanceId;
	}

	public void setKaleoInstanceId(long kaleoInstanceId) {
		_columnBitmask |= KALEOINSTANCEID_COLUMN_BITMASK;

		if (!_setOriginalKaleoInstanceId) {
			_setOriginalKaleoInstanceId = true;

			_originalKaleoInstanceId = _kaleoInstanceId;
		}

		_kaleoInstanceId = kaleoInstanceId;
	}

	public long getOriginalKaleoInstanceId() {
		return _originalKaleoInstanceId;
	}

	public long getKaleoInstanceTokenId() {
		return _kaleoInstanceTokenId;
	}

	public void setKaleoInstanceTokenId(long kaleoInstanceTokenId) {
		_kaleoInstanceTokenId = kaleoInstanceTokenId;
	}

	public long getKaleoTaskId() {
		return _kaleoTaskId;
	}

	public void setKaleoTaskId(long kaleoTaskId) {
		_columnBitmask |= KALEOTASKID_COLUMN_BITMASK;

		if (!_setOriginalKaleoTaskId) {
			_setOriginalKaleoTaskId = true;

			_originalKaleoTaskId = _kaleoTaskId;
		}

		_kaleoTaskId = kaleoTaskId;
	}

	public long getOriginalKaleoTaskId() {
		return _originalKaleoTaskId;
	}

	public String getKaleoTaskName() {
		if (_kaleoTaskName == null) {
			return StringPool.BLANK;
		}
		else {
			return _kaleoTaskName;
		}
	}

	public void setKaleoTaskName(String kaleoTaskName) {
		_kaleoTaskName = kaleoTaskName;
	}

	public String getClassName() {
		if (_className == null) {
			return StringPool.BLANK;
		}
		else {
			return _className;
		}
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public long getCompletionUserId() {
		return _completionUserId;
	}

	public void setCompletionUserId(long completionUserId) {
		_completionUserId = completionUserId;
	}

	public String getCompletionUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCompletionUserId(), "uuid",
			_completionUserUuid);
	}

	public void setCompletionUserUuid(String completionUserUuid) {
		_completionUserUuid = completionUserUuid;
	}

	public boolean getCompleted() {
		return _completed;
	}

	public boolean isCompleted() {
		return _completed;
	}

	public void setCompleted(boolean completed) {
		_completed = completed;
	}

	public Date getCompletionDate() {
		return _completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		_completionDate = completionDate;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public String getWorkflowContext() {
		if (_workflowContext == null) {
			return StringPool.BLANK;
		}
		else {
			return _workflowContext;
		}
	}

	public void setWorkflowContext(String workflowContext) {
		_workflowContext = workflowContext;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			KaleoTaskInstanceToken.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KaleoTaskInstanceToken toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KaleoTaskInstanceToken)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KaleoTaskInstanceTokenImpl kaleoTaskInstanceTokenImpl = new KaleoTaskInstanceTokenImpl();

		kaleoTaskInstanceTokenImpl.setKaleoTaskInstanceTokenId(getKaleoTaskInstanceTokenId());
		kaleoTaskInstanceTokenImpl.setGroupId(getGroupId());
		kaleoTaskInstanceTokenImpl.setCompanyId(getCompanyId());
		kaleoTaskInstanceTokenImpl.setUserId(getUserId());
		kaleoTaskInstanceTokenImpl.setUserName(getUserName());
		kaleoTaskInstanceTokenImpl.setCreateDate(getCreateDate());
		kaleoTaskInstanceTokenImpl.setModifiedDate(getModifiedDate());
		kaleoTaskInstanceTokenImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoTaskInstanceTokenImpl.setKaleoInstanceId(getKaleoInstanceId());
		kaleoTaskInstanceTokenImpl.setKaleoInstanceTokenId(getKaleoInstanceTokenId());
		kaleoTaskInstanceTokenImpl.setKaleoTaskId(getKaleoTaskId());
		kaleoTaskInstanceTokenImpl.setKaleoTaskName(getKaleoTaskName());
		kaleoTaskInstanceTokenImpl.setClassName(getClassName());
		kaleoTaskInstanceTokenImpl.setClassPK(getClassPK());
		kaleoTaskInstanceTokenImpl.setCompletionUserId(getCompletionUserId());
		kaleoTaskInstanceTokenImpl.setCompleted(getCompleted());
		kaleoTaskInstanceTokenImpl.setCompletionDate(getCompletionDate());
		kaleoTaskInstanceTokenImpl.setDueDate(getDueDate());
		kaleoTaskInstanceTokenImpl.setWorkflowContext(getWorkflowContext());

		kaleoTaskInstanceTokenImpl.resetOriginalValues();

		return kaleoTaskInstanceTokenImpl;
	}

	public int compareTo(KaleoTaskInstanceToken kaleoTaskInstanceToken) {
		int value = 0;

		if (getKaleoTaskInstanceTokenId() < kaleoTaskInstanceToken.getKaleoTaskInstanceTokenId()) {
			value = -1;
		}
		else if (getKaleoTaskInstanceTokenId() > kaleoTaskInstanceToken.getKaleoTaskInstanceTokenId()) {
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
		if (obj == null) {
			return false;
		}

		KaleoTaskInstanceToken kaleoTaskInstanceToken = null;

		try {
			kaleoTaskInstanceToken = (KaleoTaskInstanceToken)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = kaleoTaskInstanceToken.getPrimaryKey();

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
		KaleoTaskInstanceTokenModelImpl kaleoTaskInstanceTokenModelImpl = this;

		kaleoTaskInstanceTokenModelImpl._originalCompanyId = kaleoTaskInstanceTokenModelImpl._companyId;

		kaleoTaskInstanceTokenModelImpl._setOriginalCompanyId = false;

		kaleoTaskInstanceTokenModelImpl._originalKaleoDefinitionId = kaleoTaskInstanceTokenModelImpl._kaleoDefinitionId;

		kaleoTaskInstanceTokenModelImpl._setOriginalKaleoDefinitionId = false;

		kaleoTaskInstanceTokenModelImpl._originalKaleoInstanceId = kaleoTaskInstanceTokenModelImpl._kaleoInstanceId;

		kaleoTaskInstanceTokenModelImpl._setOriginalKaleoInstanceId = false;

		kaleoTaskInstanceTokenModelImpl._originalKaleoTaskId = kaleoTaskInstanceTokenModelImpl._kaleoTaskId;

		kaleoTaskInstanceTokenModelImpl._setOriginalKaleoTaskId = false;

		kaleoTaskInstanceTokenModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KaleoTaskInstanceToken> toCacheModel() {
		KaleoTaskInstanceTokenCacheModel kaleoTaskInstanceTokenCacheModel = new KaleoTaskInstanceTokenCacheModel();

		kaleoTaskInstanceTokenCacheModel.kaleoTaskInstanceTokenId = getKaleoTaskInstanceTokenId();

		kaleoTaskInstanceTokenCacheModel.groupId = getGroupId();

		kaleoTaskInstanceTokenCacheModel.companyId = getCompanyId();

		kaleoTaskInstanceTokenCacheModel.userId = getUserId();

		kaleoTaskInstanceTokenCacheModel.userName = getUserName();

		String userName = kaleoTaskInstanceTokenCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoTaskInstanceTokenCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoTaskInstanceTokenCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoTaskInstanceTokenCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoTaskInstanceTokenCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoTaskInstanceTokenCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoTaskInstanceTokenCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoTaskInstanceTokenCacheModel.kaleoInstanceId = getKaleoInstanceId();

		kaleoTaskInstanceTokenCacheModel.kaleoInstanceTokenId = getKaleoInstanceTokenId();

		kaleoTaskInstanceTokenCacheModel.kaleoTaskId = getKaleoTaskId();

		kaleoTaskInstanceTokenCacheModel.kaleoTaskName = getKaleoTaskName();

		String kaleoTaskName = kaleoTaskInstanceTokenCacheModel.kaleoTaskName;

		if ((kaleoTaskName != null) && (kaleoTaskName.length() == 0)) {
			kaleoTaskInstanceTokenCacheModel.kaleoTaskName = null;
		}

		kaleoTaskInstanceTokenCacheModel.className = getClassName();

		String className = kaleoTaskInstanceTokenCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			kaleoTaskInstanceTokenCacheModel.className = null;
		}

		kaleoTaskInstanceTokenCacheModel.classPK = getClassPK();

		kaleoTaskInstanceTokenCacheModel.completionUserId = getCompletionUserId();

		kaleoTaskInstanceTokenCacheModel.completed = getCompleted();

		Date completionDate = getCompletionDate();

		if (completionDate != null) {
			kaleoTaskInstanceTokenCacheModel.completionDate = completionDate.getTime();
		}
		else {
			kaleoTaskInstanceTokenCacheModel.completionDate = Long.MIN_VALUE;
		}

		Date dueDate = getDueDate();

		if (dueDate != null) {
			kaleoTaskInstanceTokenCacheModel.dueDate = dueDate.getTime();
		}
		else {
			kaleoTaskInstanceTokenCacheModel.dueDate = Long.MIN_VALUE;
		}

		kaleoTaskInstanceTokenCacheModel.workflowContext = getWorkflowContext();

		String workflowContext = kaleoTaskInstanceTokenCacheModel.workflowContext;

		if ((workflowContext != null) && (workflowContext.length() == 0)) {
			kaleoTaskInstanceTokenCacheModel.workflowContext = null;
		}

		return kaleoTaskInstanceTokenCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{kaleoTaskInstanceTokenId=");
		sb.append(getKaleoTaskInstanceTokenId());
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
		sb.append(", kaleoInstanceId=");
		sb.append(getKaleoInstanceId());
		sb.append(", kaleoInstanceTokenId=");
		sb.append(getKaleoInstanceTokenId());
		sb.append(", kaleoTaskId=");
		sb.append(getKaleoTaskId());
		sb.append(", kaleoTaskName=");
		sb.append(getKaleoTaskName());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", completionUserId=");
		sb.append(getCompletionUserId());
		sb.append(", completed=");
		sb.append(getCompleted());
		sb.append(", completionDate=");
		sb.append(getCompletionDate());
		sb.append(", dueDate=");
		sb.append(getDueDate());
		sb.append(", workflowContext=");
		sb.append(getWorkflowContext());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoTaskInstanceTokenId</column-name><column-value><![CDATA[");
		sb.append(getKaleoTaskInstanceTokenId());
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
			"<column><column-name>kaleoInstanceId</column-name><column-value><![CDATA[");
		sb.append(getKaleoInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoInstanceTokenId</column-name><column-value><![CDATA[");
		sb.append(getKaleoInstanceTokenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoTaskId</column-name><column-value><![CDATA[");
		sb.append(getKaleoTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoTaskName</column-name><column-value><![CDATA[");
		sb.append(getKaleoTaskName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completionUserId</column-name><column-value><![CDATA[");
		sb.append(getCompletionUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completed</column-name><column-value><![CDATA[");
		sb.append(getCompleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completionDate</column-name><column-value><![CDATA[");
		sb.append(getCompletionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dueDate</column-name><column-value><![CDATA[");
		sb.append(getDueDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowContext</column-name><column-value><![CDATA[");
		sb.append(getWorkflowContext());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KaleoTaskInstanceToken.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			KaleoTaskInstanceToken.class
		};
	private long _kaleoTaskInstanceTokenId;
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
	private long _kaleoInstanceId;
	private long _originalKaleoInstanceId;
	private boolean _setOriginalKaleoInstanceId;
	private long _kaleoInstanceTokenId;
	private long _kaleoTaskId;
	private long _originalKaleoTaskId;
	private boolean _setOriginalKaleoTaskId;
	private String _kaleoTaskName;
	private String _className;
	private long _classPK;
	private long _completionUserId;
	private String _completionUserUuid;
	private boolean _completed;
	private Date _completionDate;
	private Date _dueDate;
	private String _workflowContext;
	private long _columnBitmask;
	private KaleoTaskInstanceToken _escapedModel;
}