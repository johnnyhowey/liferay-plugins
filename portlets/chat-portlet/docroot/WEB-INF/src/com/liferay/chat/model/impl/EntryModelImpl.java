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

package com.liferay.chat.model.impl;

import com.liferay.chat.model.Entry;
import com.liferay.chat.model.EntryModel;

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

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Entry service. Represents a row in the &quot;Chat_Entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.chat.model.EntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntryImpl
 * @see com.liferay.chat.model.Entry
 * @see com.liferay.chat.model.EntryModel
 * @generated
 */
public class EntryModelImpl extends BaseModelImpl<Entry> implements EntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a entry model instance should use the {@link com.liferay.chat.model.Entry} interface instead.
	 */
	public static final String TABLE_NAME = "Chat_Entry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "entryId", Types.BIGINT },
			{ "createDate", Types.BIGINT },
			{ "fromUserId", Types.BIGINT },
			{ "toUserId", Types.BIGINT },
			{ "content", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Chat_Entry (entryId LONG not null primary key,createDate LONG,fromUserId LONG,toUserId LONG,content VARCHAR(1000) null)";
	public static final String TABLE_SQL_DROP = "drop table Chat_Entry";
	public static final String ORDER_BY_JPQL = " ORDER BY entry.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Chat_Entry.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.chat.model.Entry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.chat.model.Entry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.chat.model.Entry"),
			true);
	public static long CONTENT_COLUMN_BITMASK = 1L;
	public static long CREATEDATE_COLUMN_BITMASK = 2L;
	public static long FROMUSERID_COLUMN_BITMASK = 4L;
	public static long TOUSERID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.chat.model.Entry"));

	public EntryModelImpl() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Entry.class;
	}

	public String getModelClassName() {
		return Entry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("createDate", getCreateDate());
		attributes.put("fromUserId", getFromUserId());
		attributes.put("toUserId", getToUserId());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long fromUserId = (Long)attributes.get("fromUserId");

		if (fromUserId != null) {
			setFromUserId(fromUserId);
		}

		Long toUserId = (Long)attributes.get("toUserId");

		if (toUserId != null) {
			setToUserId(toUserId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(long createDate) {
		_columnBitmask = -1L;

		if (!_setOriginalCreateDate) {
			_setOriginalCreateDate = true;

			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public long getOriginalCreateDate() {
		return _originalCreateDate;
	}

	public long getFromUserId() {
		return _fromUserId;
	}

	public void setFromUserId(long fromUserId) {
		_columnBitmask |= FROMUSERID_COLUMN_BITMASK;

		if (!_setOriginalFromUserId) {
			_setOriginalFromUserId = true;

			_originalFromUserId = _fromUserId;
		}

		_fromUserId = fromUserId;
	}

	public String getFromUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getFromUserId(), "uuid", _fromUserUuid);
	}

	public void setFromUserUuid(String fromUserUuid) {
		_fromUserUuid = fromUserUuid;
	}

	public long getOriginalFromUserId() {
		return _originalFromUserId;
	}

	public long getToUserId() {
		return _toUserId;
	}

	public void setToUserId(long toUserId) {
		_columnBitmask |= TOUSERID_COLUMN_BITMASK;

		if (!_setOriginalToUserId) {
			_setOriginalToUserId = true;

			_originalToUserId = _toUserId;
		}

		_toUserId = toUserId;
	}

	public String getToUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getToUserId(), "uuid", _toUserUuid);
	}

	public void setToUserUuid(String toUserUuid) {
		_toUserUuid = toUserUuid;
	}

	public long getOriginalToUserId() {
		return _originalToUserId;
	}

	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	public void setContent(String content) {
		_columnBitmask |= CONTENT_COLUMN_BITMASK;

		if (_originalContent == null) {
			_originalContent = _content;
		}

		_content = content;
	}

	public String getOriginalContent() {
		return GetterUtil.getString(_originalContent);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Entry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Entry toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Entry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		EntryImpl entryImpl = new EntryImpl();

		entryImpl.setEntryId(getEntryId());
		entryImpl.setCreateDate(getCreateDate());
		entryImpl.setFromUserId(getFromUserId());
		entryImpl.setToUserId(getToUserId());
		entryImpl.setContent(getContent());

		entryImpl.resetOriginalValues();

		return entryImpl;
	}

	public int compareTo(Entry entry) {
		int value = 0;

		if (getCreateDate() < entry.getCreateDate()) {
			value = -1;
		}
		else if (getCreateDate() > entry.getCreateDate()) {
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
		if (obj == null) {
			return false;
		}

		Entry entry = null;

		try {
			entry = (Entry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = entry.getPrimaryKey();

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
		EntryModelImpl entryModelImpl = this;

		entryModelImpl._originalCreateDate = entryModelImpl._createDate;

		entryModelImpl._setOriginalCreateDate = false;

		entryModelImpl._originalFromUserId = entryModelImpl._fromUserId;

		entryModelImpl._setOriginalFromUserId = false;

		entryModelImpl._originalToUserId = entryModelImpl._toUserId;

		entryModelImpl._setOriginalToUserId = false;

		entryModelImpl._originalContent = entryModelImpl._content;

		entryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Entry> toCacheModel() {
		EntryCacheModel entryCacheModel = new EntryCacheModel();

		entryCacheModel.entryId = getEntryId();

		entryCacheModel.createDate = getCreateDate();

		entryCacheModel.fromUserId = getFromUserId();

		entryCacheModel.toUserId = getToUserId();

		entryCacheModel.content = getContent();

		String content = entryCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			entryCacheModel.content = null;
		}

		return entryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", fromUserId=");
		sb.append(getFromUserId());
		sb.append(", toUserId=");
		sb.append(getToUserId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.chat.model.Entry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromUserId</column-name><column-value><![CDATA[");
		sb.append(getFromUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toUserId</column-name><column-value><![CDATA[");
		sb.append(getToUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Entry.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Entry.class
		};
	private long _entryId;
	private long _createDate;
	private long _originalCreateDate;
	private boolean _setOriginalCreateDate;
	private long _fromUserId;
	private String _fromUserUuid;
	private long _originalFromUserId;
	private boolean _setOriginalFromUserId;
	private long _toUserId;
	private String _toUserUuid;
	private long _originalToUserId;
	private boolean _setOriginalToUserId;
	private String _content;
	private String _originalContent;
	private long _columnBitmask;
	private Entry _escapedModelProxy;
}