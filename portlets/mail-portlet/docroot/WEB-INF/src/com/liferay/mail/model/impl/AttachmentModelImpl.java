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

package com.liferay.mail.model.impl;

import com.liferay.mail.model.Attachment;
import com.liferay.mail.model.AttachmentModel;

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
 * The base model implementation for the Attachment service. Represents a row in the &quot;Mail_Attachment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.mail.model.AttachmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AttachmentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentImpl
 * @see com.liferay.mail.model.Attachment
 * @see com.liferay.mail.model.AttachmentModel
 * @generated
 */
public class AttachmentModelImpl extends BaseModelImpl<Attachment>
	implements AttachmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a attachment model instance should use the {@link com.liferay.mail.model.Attachment} interface instead.
	 */
	public static final String TABLE_NAME = "Mail_Attachment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "attachmentId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "accountId", Types.BIGINT },
			{ "folderId", Types.BIGINT },
			{ "messageId", Types.BIGINT },
			{ "contentPath", Types.VARCHAR },
			{ "fileName", Types.VARCHAR },
			{ "size_", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Mail_Attachment (attachmentId LONG not null primary key,companyId LONG,userId LONG,accountId LONG,folderId LONG,messageId LONG,contentPath VARCHAR(75) null,fileName VARCHAR(75) null,size_ LONG)";
	public static final String TABLE_SQL_DROP = "drop table Mail_Attachment";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.mail.model.Attachment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.mail.model.Attachment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.mail.model.Attachment"),
			true);
	public static long MESSAGEID_COLUMN_BITMASK = 1L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.mail.model.Attachment"));

	public AttachmentModelImpl() {
	}

	public long getPrimaryKey() {
		return _attachmentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAttachmentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_attachmentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Attachment.class;
	}

	public String getModelClassName() {
		return Attachment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("accountId", getAccountId());
		attributes.put("folderId", getFolderId());
		attributes.put("messageId", getMessageId());
		attributes.put("contentPath", getContentPath());
		attributes.put("fileName", getFileName());
		attributes.put("size", getSize());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		String contentPath = (String)attributes.get("contentPath");

		if (contentPath != null) {
			setContentPath(contentPath);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Long size = (Long)attributes.get("size");

		if (size != null) {
			setSize(size);
		}
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_columnBitmask |= MESSAGEID_COLUMN_BITMASK;

		if (!_setOriginalMessageId) {
			_setOriginalMessageId = true;

			_originalMessageId = _messageId;
		}

		_messageId = messageId;
	}

	public long getOriginalMessageId() {
		return _originalMessageId;
	}

	public String getContentPath() {
		if (_contentPath == null) {
			return StringPool.BLANK;
		}
		else {
			return _contentPath;
		}
	}

	public void setContentPath(String contentPath) {
		_contentPath = contentPath;
	}

	public String getFileName() {
		if (_fileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileName;
		}
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public long getSize() {
		return _size;
	}

	public void setSize(long size) {
		_size = size;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Attachment toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Attachment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Attachment.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		AttachmentImpl attachmentImpl = new AttachmentImpl();

		attachmentImpl.setAttachmentId(getAttachmentId());
		attachmentImpl.setCompanyId(getCompanyId());
		attachmentImpl.setUserId(getUserId());
		attachmentImpl.setAccountId(getAccountId());
		attachmentImpl.setFolderId(getFolderId());
		attachmentImpl.setMessageId(getMessageId());
		attachmentImpl.setContentPath(getContentPath());
		attachmentImpl.setFileName(getFileName());
		attachmentImpl.setSize(getSize());

		attachmentImpl.resetOriginalValues();

		return attachmentImpl;
	}

	public int compareTo(Attachment attachment) {
		long primaryKey = attachment.getPrimaryKey();

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
		if (obj == null) {
			return false;
		}

		Attachment attachment = null;

		try {
			attachment = (Attachment)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = attachment.getPrimaryKey();

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
		AttachmentModelImpl attachmentModelImpl = this;

		attachmentModelImpl._originalMessageId = attachmentModelImpl._messageId;

		attachmentModelImpl._setOriginalMessageId = false;

		attachmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Attachment> toCacheModel() {
		AttachmentCacheModel attachmentCacheModel = new AttachmentCacheModel();

		attachmentCacheModel.attachmentId = getAttachmentId();

		attachmentCacheModel.companyId = getCompanyId();

		attachmentCacheModel.userId = getUserId();

		attachmentCacheModel.accountId = getAccountId();

		attachmentCacheModel.folderId = getFolderId();

		attachmentCacheModel.messageId = getMessageId();

		attachmentCacheModel.contentPath = getContentPath();

		String contentPath = attachmentCacheModel.contentPath;

		if ((contentPath != null) && (contentPath.length() == 0)) {
			attachmentCacheModel.contentPath = null;
		}

		attachmentCacheModel.fileName = getFileName();

		String fileName = attachmentCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			attachmentCacheModel.fileName = null;
		}

		attachmentCacheModel.size = getSize();

		return attachmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{attachmentId=");
		sb.append(getAttachmentId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", accountId=");
		sb.append(getAccountId());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", contentPath=");
		sb.append(getContentPath());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", size=");
		sb.append(getSize());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.mail.model.Attachment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>attachmentId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentId());
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
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentPath</column-name><column-value><![CDATA[");
		sb.append(getContentPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Attachment.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Attachment.class
		};
	private long _attachmentId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _accountId;
	private long _folderId;
	private long _messageId;
	private long _originalMessageId;
	private boolean _setOriginalMessageId;
	private String _contentPath;
	private String _fileName;
	private long _size;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private Attachment _escapedModelProxy;
}