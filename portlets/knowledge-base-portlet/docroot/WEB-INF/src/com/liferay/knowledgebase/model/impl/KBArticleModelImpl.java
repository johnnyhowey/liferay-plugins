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

package com.liferay.knowledgebase.model.impl;

import com.liferay.knowledgebase.model.KBArticle;
import com.liferay.knowledgebase.model.KBArticleModel;
import com.liferay.knowledgebase.model.KBArticleSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the KBArticle service. Represents a row in the &quot;KBArticle&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.knowledgebase.model.KBArticleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KBArticleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KBArticleImpl
 * @see com.liferay.knowledgebase.model.KBArticle
 * @see com.liferay.knowledgebase.model.KBArticleModel
 * @generated
 */
@JSON(strict = true)
public class KBArticleModelImpl extends BaseModelImpl<KBArticle>
	implements KBArticleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a k b article model instance should use the {@link com.liferay.knowledgebase.model.KBArticle} interface instead.
	 */
	public static final String TABLE_NAME = "KBArticle";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "kbArticleId", Types.BIGINT },
			{ "resourcePrimKey", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "rootResourcePrimKey", Types.BIGINT },
			{ "parentResourcePrimKey", Types.BIGINT },
			{ "version", Types.INTEGER },
			{ "title", Types.VARCHAR },
			{ "content", Types.CLOB },
			{ "description", Types.VARCHAR },
			{ "priority", Types.DOUBLE },
			{ "sections", Types.VARCHAR },
			{ "viewCount", Types.INTEGER },
			{ "latest", Types.BOOLEAN },
			{ "main", Types.BOOLEAN },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table KBArticle (uuid_ VARCHAR(75) null,kbArticleId LONG not null primary key,resourcePrimKey LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,rootResourcePrimKey LONG,parentResourcePrimKey LONG,version INTEGER,title STRING null,content TEXT null,description STRING null,priority DOUBLE,sections STRING null,viewCount INTEGER,latest BOOLEAN,main BOOLEAN,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table KBArticle";
	public static final String ORDER_BY_JPQL = " ORDER BY kbArticle.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY KBArticle.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.knowledgebase.model.KBArticle"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.knowledgebase.model.KBArticle"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.knowledgebase.model.KBArticle"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long LATEST_COLUMN_BITMASK = 4L;
	public static long MAIN_COLUMN_BITMASK = 8L;
	public static long PARENTRESOURCEPRIMKEY_COLUMN_BITMASK = 16L;
	public static long RESOURCEPRIMKEY_COLUMN_BITMASK = 32L;
	public static long SECTIONS_COLUMN_BITMASK = 64L;
	public static long STATUS_COLUMN_BITMASK = 128L;
	public static long UUID_COLUMN_BITMASK = 256L;
	public static long VERSION_COLUMN_BITMASK = 512L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static KBArticle toModel(KBArticleSoap soapModel) {
		KBArticle model = new KBArticleImpl();

		model.setUuid(soapModel.getUuid());
		model.setKbArticleId(soapModel.getKbArticleId());
		model.setResourcePrimKey(soapModel.getResourcePrimKey());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setRootResourcePrimKey(soapModel.getRootResourcePrimKey());
		model.setParentResourcePrimKey(soapModel.getParentResourcePrimKey());
		model.setVersion(soapModel.getVersion());
		model.setTitle(soapModel.getTitle());
		model.setContent(soapModel.getContent());
		model.setDescription(soapModel.getDescription());
		model.setPriority(soapModel.getPriority());
		model.setSections(soapModel.getSections());
		model.setViewCount(soapModel.getViewCount());
		model.setLatest(soapModel.getLatest());
		model.setMain(soapModel.getMain());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<KBArticle> toModels(KBArticleSoap[] soapModels) {
		List<KBArticle> models = new ArrayList<KBArticle>(soapModels.length);

		for (KBArticleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.knowledgebase.model.KBArticle"));

	public KBArticleModelImpl() {
	}

	public long getPrimaryKey() {
		return _kbArticleId;
	}

	public void setPrimaryKey(long primaryKey) {
		setKbArticleId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_kbArticleId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return KBArticle.class;
	}

	public String getModelClassName() {
		return KBArticle.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("kbArticleId", getKbArticleId());
		attributes.put("resourcePrimKey", getResourcePrimKey());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rootResourcePrimKey", getRootResourcePrimKey());
		attributes.put("parentResourcePrimKey", getParentResourcePrimKey());
		attributes.put("version", getVersion());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("description", getDescription());
		attributes.put("priority", getPriority());
		attributes.put("sections", getSections());
		attributes.put("viewCount", getViewCount());
		attributes.put("latest", getLatest());
		attributes.put("main", getMain());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long kbArticleId = (Long)attributes.get("kbArticleId");

		if (kbArticleId != null) {
			setKbArticleId(kbArticleId);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
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

		Long rootResourcePrimKey = (Long)attributes.get("rootResourcePrimKey");

		if (rootResourcePrimKey != null) {
			setRootResourcePrimKey(rootResourcePrimKey);
		}

		Long parentResourcePrimKey = (Long)attributes.get(
				"parentResourcePrimKey");

		if (parentResourcePrimKey != null) {
			setParentResourcePrimKey(parentResourcePrimKey);
		}

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double priority = (Double)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		String sections = (String)attributes.get("sections");

		if (sections != null) {
			setSections(sections);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Boolean latest = (Boolean)attributes.get("latest");

		if (latest != null) {
			setLatest(latest);
		}

		Boolean main = (Boolean)attributes.get("main");

		if (main != null) {
			setMain(main);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getKbArticleId() {
		return _kbArticleId;
	}

	public void setKbArticleId(long kbArticleId) {
		_kbArticleId = kbArticleId;
	}

	@JSON
	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_columnBitmask |= RESOURCEPRIMKEY_COLUMN_BITMASK;

		if (!_setOriginalResourcePrimKey) {
			_setOriginalResourcePrimKey = true;

			_originalResourcePrimKey = _resourcePrimKey;
		}

		_resourcePrimKey = resourcePrimKey;
	}

	public boolean isResourceMain() {
		return true;
	}

	public long getOriginalResourcePrimKey() {
		return _originalResourcePrimKey;
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

	@JSON
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
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	public long getRootResourcePrimKey() {
		return _rootResourcePrimKey;
	}

	public void setRootResourcePrimKey(long rootResourcePrimKey) {
		_rootResourcePrimKey = rootResourcePrimKey;
	}

	@JSON
	public long getParentResourcePrimKey() {
		return _parentResourcePrimKey;
	}

	public void setParentResourcePrimKey(long parentResourcePrimKey) {
		_columnBitmask |= PARENTRESOURCEPRIMKEY_COLUMN_BITMASK;

		if (!_setOriginalParentResourcePrimKey) {
			_setOriginalParentResourcePrimKey = true;

			_originalParentResourcePrimKey = _parentResourcePrimKey;
		}

		_parentResourcePrimKey = parentResourcePrimKey;
	}

	public long getOriginalParentResourcePrimKey() {
		return _originalParentResourcePrimKey;
	}

	@JSON
	public int getVersion() {
		return _version;
	}

	public void setVersion(int version) {
		_columnBitmask |= VERSION_COLUMN_BITMASK;

		if (!_setOriginalVersion) {
			_setOriginalVersion = true;

			_originalVersion = _version;
		}

		_version = version;
	}

	public int getOriginalVersion() {
		return _originalVersion;
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
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	public void setContent(String content) {
		_content = content;
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public double getPriority() {
		return _priority;
	}

	public void setPriority(double priority) {
		_priority = priority;
	}

	@JSON
	public String getSections() {
		if (_sections == null) {
			return StringPool.BLANK;
		}
		else {
			return _sections;
		}
	}

	public void setSections(String sections) {
		_columnBitmask |= SECTIONS_COLUMN_BITMASK;

		if (_originalSections == null) {
			_originalSections = _sections;
		}

		_sections = sections;
	}

	public String getOriginalSections() {
		return GetterUtil.getString(_originalSections);
	}

	@JSON
	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	@JSON
	public boolean getLatest() {
		return _latest;
	}

	public boolean isLatest() {
		return _latest;
	}

	public void setLatest(boolean latest) {
		_columnBitmask |= LATEST_COLUMN_BITMASK;

		if (!_setOriginalLatest) {
			_setOriginalLatest = true;

			_originalLatest = _latest;
		}

		_latest = latest;
	}

	public boolean getOriginalLatest() {
		return _originalLatest;
	}

	@JSON
	public boolean getMain() {
		return _main;
	}

	public boolean isMain() {
		return _main;
	}

	public void setMain(boolean main) {
		_columnBitmask |= MAIN_COLUMN_BITMASK;

		if (!_setOriginalMain) {
			_setOriginalMain = true;

			_originalMain = _main;
		}

		_main = main;
	}

	public boolean getOriginalMain() {
		return _originalMain;
	}

	@JSON
	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@JSON
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	/**
	 * @deprecated {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if ((getStatus() == WorkflowConstants.STATUS_DRAFT) ||
				(getStatus() == WorkflowConstants.STATUS_DRAFT_FROM_APPROVED)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public KBArticle toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (KBArticle)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					KBArticle.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		KBArticleImpl kbArticleImpl = new KBArticleImpl();

		kbArticleImpl.setUuid(getUuid());
		kbArticleImpl.setKbArticleId(getKbArticleId());
		kbArticleImpl.setResourcePrimKey(getResourcePrimKey());
		kbArticleImpl.setGroupId(getGroupId());
		kbArticleImpl.setCompanyId(getCompanyId());
		kbArticleImpl.setUserId(getUserId());
		kbArticleImpl.setUserName(getUserName());
		kbArticleImpl.setCreateDate(getCreateDate());
		kbArticleImpl.setModifiedDate(getModifiedDate());
		kbArticleImpl.setRootResourcePrimKey(getRootResourcePrimKey());
		kbArticleImpl.setParentResourcePrimKey(getParentResourcePrimKey());
		kbArticleImpl.setVersion(getVersion());
		kbArticleImpl.setTitle(getTitle());
		kbArticleImpl.setContent(getContent());
		kbArticleImpl.setDescription(getDescription());
		kbArticleImpl.setPriority(getPriority());
		kbArticleImpl.setSections(getSections());
		kbArticleImpl.setViewCount(getViewCount());
		kbArticleImpl.setLatest(getLatest());
		kbArticleImpl.setMain(getMain());
		kbArticleImpl.setStatus(getStatus());
		kbArticleImpl.setStatusByUserId(getStatusByUserId());
		kbArticleImpl.setStatusByUserName(getStatusByUserName());
		kbArticleImpl.setStatusDate(getStatusDate());

		kbArticleImpl.resetOriginalValues();

		return kbArticleImpl;
	}

	public int compareTo(KBArticle kbArticle) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				kbArticle.getModifiedDate());

		value = value * -1;

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

		KBArticle kbArticle = null;

		try {
			kbArticle = (KBArticle)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = kbArticle.getPrimaryKey();

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
		KBArticleModelImpl kbArticleModelImpl = this;

		kbArticleModelImpl._originalUuid = kbArticleModelImpl._uuid;

		kbArticleModelImpl._originalResourcePrimKey = kbArticleModelImpl._resourcePrimKey;

		kbArticleModelImpl._setOriginalResourcePrimKey = false;

		kbArticleModelImpl._originalGroupId = kbArticleModelImpl._groupId;

		kbArticleModelImpl._setOriginalGroupId = false;

		kbArticleModelImpl._originalCompanyId = kbArticleModelImpl._companyId;

		kbArticleModelImpl._setOriginalCompanyId = false;

		kbArticleModelImpl._originalParentResourcePrimKey = kbArticleModelImpl._parentResourcePrimKey;

		kbArticleModelImpl._setOriginalParentResourcePrimKey = false;

		kbArticleModelImpl._originalVersion = kbArticleModelImpl._version;

		kbArticleModelImpl._setOriginalVersion = false;

		kbArticleModelImpl._originalSections = kbArticleModelImpl._sections;

		kbArticleModelImpl._originalLatest = kbArticleModelImpl._latest;

		kbArticleModelImpl._setOriginalLatest = false;

		kbArticleModelImpl._originalMain = kbArticleModelImpl._main;

		kbArticleModelImpl._setOriginalMain = false;

		kbArticleModelImpl._originalStatus = kbArticleModelImpl._status;

		kbArticleModelImpl._setOriginalStatus = false;

		kbArticleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KBArticle> toCacheModel() {
		KBArticleCacheModel kbArticleCacheModel = new KBArticleCacheModel();

		kbArticleCacheModel.uuid = getUuid();

		String uuid = kbArticleCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			kbArticleCacheModel.uuid = null;
		}

		kbArticleCacheModel.kbArticleId = getKbArticleId();

		kbArticleCacheModel.resourcePrimKey = getResourcePrimKey();

		kbArticleCacheModel.groupId = getGroupId();

		kbArticleCacheModel.companyId = getCompanyId();

		kbArticleCacheModel.userId = getUserId();

		kbArticleCacheModel.userName = getUserName();

		String userName = kbArticleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kbArticleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kbArticleCacheModel.createDate = createDate.getTime();
		}
		else {
			kbArticleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kbArticleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kbArticleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kbArticleCacheModel.rootResourcePrimKey = getRootResourcePrimKey();

		kbArticleCacheModel.parentResourcePrimKey = getParentResourcePrimKey();

		kbArticleCacheModel.version = getVersion();

		kbArticleCacheModel.title = getTitle();

		String title = kbArticleCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			kbArticleCacheModel.title = null;
		}

		kbArticleCacheModel.content = getContent();

		String content = kbArticleCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			kbArticleCacheModel.content = null;
		}

		kbArticleCacheModel.description = getDescription();

		String description = kbArticleCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kbArticleCacheModel.description = null;
		}

		kbArticleCacheModel.priority = getPriority();

		kbArticleCacheModel.sections = getSections();

		String sections = kbArticleCacheModel.sections;

		if ((sections != null) && (sections.length() == 0)) {
			kbArticleCacheModel.sections = null;
		}

		kbArticleCacheModel.viewCount = getViewCount();

		kbArticleCacheModel.latest = getLatest();

		kbArticleCacheModel.main = getMain();

		kbArticleCacheModel.status = getStatus();

		kbArticleCacheModel.statusByUserId = getStatusByUserId();

		kbArticleCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = kbArticleCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			kbArticleCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			kbArticleCacheModel.statusDate = statusDate.getTime();
		}
		else {
			kbArticleCacheModel.statusDate = Long.MIN_VALUE;
		}

		return kbArticleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", kbArticleId=");
		sb.append(getKbArticleId());
		sb.append(", resourcePrimKey=");
		sb.append(getResourcePrimKey());
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
		sb.append(", rootResourcePrimKey=");
		sb.append(getRootResourcePrimKey());
		sb.append(", parentResourcePrimKey=");
		sb.append(getParentResourcePrimKey());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", sections=");
		sb.append(getSections());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", latest=");
		sb.append(getLatest());
		sb.append(", main=");
		sb.append(getMain());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.liferay.knowledgebase.model.KBArticle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kbArticleId</column-name><column-value><![CDATA[");
		sb.append(getKbArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getResourcePrimKey());
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
			"<column><column-name>rootResourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getRootResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentResourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getParentResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sections</column-name><column-value><![CDATA[");
		sb.append(getSections());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latest</column-name><column-value><![CDATA[");
		sb.append(getLatest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>main</column-name><column-value><![CDATA[");
		sb.append(getMain());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KBArticle.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			KBArticle.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _kbArticleId;
	private long _resourcePrimKey;
	private long _originalResourcePrimKey;
	private boolean _setOriginalResourcePrimKey;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rootResourcePrimKey;
	private long _parentResourcePrimKey;
	private long _originalParentResourcePrimKey;
	private boolean _setOriginalParentResourcePrimKey;
	private int _version;
	private int _originalVersion;
	private boolean _setOriginalVersion;
	private String _title;
	private String _content;
	private String _description;
	private double _priority;
	private String _sections;
	private String _originalSections;
	private int _viewCount;
	private boolean _latest;
	private boolean _originalLatest;
	private boolean _setOriginalLatest;
	private boolean _main;
	private boolean _originalMain;
	private boolean _setOriginalMain;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private KBArticle _escapedModelProxy;
}