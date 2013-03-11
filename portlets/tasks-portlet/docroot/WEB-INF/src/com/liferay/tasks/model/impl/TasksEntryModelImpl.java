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

package com.liferay.tasks.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.tasks.model.TasksEntry;
import com.liferay.tasks.model.TasksEntryModel;
import com.liferay.tasks.model.TasksEntrySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TasksEntry service. Represents a row in the &quot;TMS_TasksEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.tasks.model.TasksEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TasksEntryImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see TasksEntryImpl
 * @see com.liferay.tasks.model.TasksEntry
 * @see com.liferay.tasks.model.TasksEntryModel
 * @generated
 */
@JSON(strict = true)
public class TasksEntryModelImpl extends BaseModelImpl<TasksEntry>
	implements TasksEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tasks entry model instance should use the {@link com.liferay.tasks.model.TasksEntry} interface instead.
	 */
	public static final String TABLE_NAME = "TMS_TasksEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tasksEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "priority", Types.INTEGER },
			{ "assigneeUserId", Types.BIGINT },
			{ "resolverUserId", Types.BIGINT },
			{ "dueDate", Types.TIMESTAMP },
			{ "finishDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table TMS_TasksEntry (tasksEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,priority INTEGER,assigneeUserId LONG,resolverUserId LONG,dueDate DATE null,finishDate DATE null,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table TMS_TasksEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY tasksEntry.priority ASC, tasksEntry.dueDate ASC, tasksEntry.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TMS_TasksEntry.priority ASC, TMS_TasksEntry.dueDate ASC, TMS_TasksEntry.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.tasks.model.TasksEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.tasks.model.TasksEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.tasks.model.TasksEntry"),
			true);
	public static long ASSIGNEEUSERID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long RESOLVERUSERID_COLUMN_BITMASK = 4L;
	public static long USERID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TasksEntry toModel(TasksEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TasksEntry model = new TasksEntryImpl();

		model.setTasksEntryId(soapModel.getTasksEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setPriority(soapModel.getPriority());
		model.setAssigneeUserId(soapModel.getAssigneeUserId());
		model.setResolverUserId(soapModel.getResolverUserId());
		model.setDueDate(soapModel.getDueDate());
		model.setFinishDate(soapModel.getFinishDate());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TasksEntry> toModels(TasksEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TasksEntry> models = new ArrayList<TasksEntry>(soapModels.length);

		for (TasksEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.tasks.model.TasksEntry"));

	public TasksEntryModelImpl() {
	}

	public long getPrimaryKey() {
		return _tasksEntryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTasksEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_tasksEntryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return TasksEntry.class;
	}

	public String getModelClassName() {
		return TasksEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tasksEntryId", getTasksEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("priority", getPriority());
		attributes.put("assigneeUserId", getAssigneeUserId());
		attributes.put("resolverUserId", getResolverUserId());
		attributes.put("dueDate", getDueDate());
		attributes.put("finishDate", getFinishDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tasksEntryId = (Long)attributes.get("tasksEntryId");

		if (tasksEntryId != null) {
			setTasksEntryId(tasksEntryId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Long assigneeUserId = (Long)attributes.get("assigneeUserId");

		if (assigneeUserId != null) {
			setAssigneeUserId(assigneeUserId);
		}

		Long resolverUserId = (Long)attributes.get("resolverUserId");

		if (resolverUserId != null) {
			setResolverUserId(resolverUserId);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Date finishDate = (Date)attributes.get("finishDate");

		if (finishDate != null) {
			setFinishDate(finishDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	public long getTasksEntryId() {
		return _tasksEntryId;
	}

	public void setTasksEntryId(long tasksEntryId) {
		_tasksEntryId = tasksEntryId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
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

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_columnBitmask = -1L;

		_priority = priority;
	}

	@JSON
	public long getAssigneeUserId() {
		return _assigneeUserId;
	}

	public void setAssigneeUserId(long assigneeUserId) {
		_columnBitmask |= ASSIGNEEUSERID_COLUMN_BITMASK;

		if (!_setOriginalAssigneeUserId) {
			_setOriginalAssigneeUserId = true;

			_originalAssigneeUserId = _assigneeUserId;
		}

		_assigneeUserId = assigneeUserId;
	}

	public String getAssigneeUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAssigneeUserId(), "uuid",
			_assigneeUserUuid);
	}

	public void setAssigneeUserUuid(String assigneeUserUuid) {
		_assigneeUserUuid = assigneeUserUuid;
	}

	public long getOriginalAssigneeUserId() {
		return _originalAssigneeUserId;
	}

	@JSON
	public long getResolverUserId() {
		return _resolverUserId;
	}

	public void setResolverUserId(long resolverUserId) {
		_columnBitmask |= RESOLVERUSERID_COLUMN_BITMASK;

		if (!_setOriginalResolverUserId) {
			_setOriginalResolverUserId = true;

			_originalResolverUserId = _resolverUserId;
		}

		_resolverUserId = resolverUserId;
	}

	public String getResolverUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getResolverUserId(), "uuid",
			_resolverUserUuid);
	}

	public void setResolverUserUuid(String resolverUserUuid) {
		_resolverUserUuid = resolverUserUuid;
	}

	public long getOriginalResolverUserId() {
		return _originalResolverUserId;
	}

	@JSON
	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_columnBitmask = -1L;

		_dueDate = dueDate;
	}

	@JSON
	public Date getFinishDate() {
		return _finishDate;
	}

	public void setFinishDate(Date finishDate) {
		_finishDate = finishDate;
	}

	@JSON
	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TasksEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TasksEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TasksEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	public TasksEntry toUnescapedModel() {
		return (TasksEntry)this;
	}

	@Override
	public Object clone() {
		TasksEntryImpl tasksEntryImpl = new TasksEntryImpl();

		tasksEntryImpl.setTasksEntryId(getTasksEntryId());
		tasksEntryImpl.setGroupId(getGroupId());
		tasksEntryImpl.setCompanyId(getCompanyId());
		tasksEntryImpl.setUserId(getUserId());
		tasksEntryImpl.setUserName(getUserName());
		tasksEntryImpl.setCreateDate(getCreateDate());
		tasksEntryImpl.setModifiedDate(getModifiedDate());
		tasksEntryImpl.setTitle(getTitle());
		tasksEntryImpl.setPriority(getPriority());
		tasksEntryImpl.setAssigneeUserId(getAssigneeUserId());
		tasksEntryImpl.setResolverUserId(getResolverUserId());
		tasksEntryImpl.setDueDate(getDueDate());
		tasksEntryImpl.setFinishDate(getFinishDate());
		tasksEntryImpl.setStatus(getStatus());

		tasksEntryImpl.resetOriginalValues();

		return tasksEntryImpl;
	}

	public int compareTo(TasksEntry tasksEntry) {
		int value = 0;

		if (getPriority() < tasksEntry.getPriority()) {
			value = -1;
		}
		else if (getPriority() > tasksEntry.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getDueDate(), tasksEntry.getDueDate());

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), tasksEntry.getCreateDate());

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

		TasksEntry tasksEntry = null;

		try {
			tasksEntry = (TasksEntry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tasksEntry.getPrimaryKey();

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
		TasksEntryModelImpl tasksEntryModelImpl = this;

		tasksEntryModelImpl._originalGroupId = tasksEntryModelImpl._groupId;

		tasksEntryModelImpl._setOriginalGroupId = false;

		tasksEntryModelImpl._originalUserId = tasksEntryModelImpl._userId;

		tasksEntryModelImpl._setOriginalUserId = false;

		tasksEntryModelImpl._originalAssigneeUserId = tasksEntryModelImpl._assigneeUserId;

		tasksEntryModelImpl._setOriginalAssigneeUserId = false;

		tasksEntryModelImpl._originalResolverUserId = tasksEntryModelImpl._resolverUserId;

		tasksEntryModelImpl._setOriginalResolverUserId = false;

		tasksEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TasksEntry> toCacheModel() {
		TasksEntryCacheModel tasksEntryCacheModel = new TasksEntryCacheModel();

		tasksEntryCacheModel.tasksEntryId = getTasksEntryId();

		tasksEntryCacheModel.groupId = getGroupId();

		tasksEntryCacheModel.companyId = getCompanyId();

		tasksEntryCacheModel.userId = getUserId();

		tasksEntryCacheModel.userName = getUserName();

		String userName = tasksEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tasksEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tasksEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			tasksEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tasksEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tasksEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		tasksEntryCacheModel.title = getTitle();

		String title = tasksEntryCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			tasksEntryCacheModel.title = null;
		}

		tasksEntryCacheModel.priority = getPriority();

		tasksEntryCacheModel.assigneeUserId = getAssigneeUserId();

		tasksEntryCacheModel.resolverUserId = getResolverUserId();

		Date dueDate = getDueDate();

		if (dueDate != null) {
			tasksEntryCacheModel.dueDate = dueDate.getTime();
		}
		else {
			tasksEntryCacheModel.dueDate = Long.MIN_VALUE;
		}

		Date finishDate = getFinishDate();

		if (finishDate != null) {
			tasksEntryCacheModel.finishDate = finishDate.getTime();
		}
		else {
			tasksEntryCacheModel.finishDate = Long.MIN_VALUE;
		}

		tasksEntryCacheModel.status = getStatus();

		return tasksEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{tasksEntryId=");
		sb.append(getTasksEntryId());
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
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", assigneeUserId=");
		sb.append(getAssigneeUserId());
		sb.append(", resolverUserId=");
		sb.append(getResolverUserId());
		sb.append(", dueDate=");
		sb.append(getDueDate());
		sb.append(", finishDate=");
		sb.append(getFinishDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.tasks.model.TasksEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tasksEntryId</column-name><column-value><![CDATA[");
		sb.append(getTasksEntryId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assigneeUserId</column-name><column-value><![CDATA[");
		sb.append(getAssigneeUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resolverUserId</column-name><column-value><![CDATA[");
		sb.append(getResolverUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dueDate</column-name><column-value><![CDATA[");
		sb.append(getDueDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finishDate</column-name><column-value><![CDATA[");
		sb.append(getFinishDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TasksEntry.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TasksEntry.class
		};
	private long _tasksEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private int _priority;
	private long _assigneeUserId;
	private String _assigneeUserUuid;
	private long _originalAssigneeUserId;
	private boolean _setOriginalAssigneeUserId;
	private long _resolverUserId;
	private String _resolverUserUuid;
	private long _originalResolverUserId;
	private boolean _setOriginalResolverUserId;
	private Date _dueDate;
	private Date _finishDate;
	private int _status;
	private long _columnBitmask;
	private TasksEntry _escapedModel;
}