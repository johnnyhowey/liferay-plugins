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

package com.liferay.knowledgebase.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the KBComment service. Represents a row in the &quot;KBComment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.knowledgebase.model.impl.KBCommentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.knowledgebase.model.impl.KBCommentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KBComment
 * @see com.liferay.knowledgebase.model.impl.KBCommentImpl
 * @see com.liferay.knowledgebase.model.impl.KBCommentModelImpl
 * @generated
 */
public interface KBCommentModel extends AttachedModel, BaseModel<KBComment>,
	GroupedModel, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a k b comment model instance should use the {@link KBComment} interface instead.
	 */

	/**
	 * Returns the primary key of this k b comment.
	 *
	 * @return the primary key of this k b comment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this k b comment.
	 *
	 * @param primaryKey the primary key of this k b comment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this k b comment.
	 *
	 * @return the uuid of this k b comment
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this k b comment.
	 *
	 * @param uuid the uuid of this k b comment
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the kb comment ID of this k b comment.
	 *
	 * @return the kb comment ID of this k b comment
	 */
	public long getKbCommentId();

	/**
	 * Sets the kb comment ID of this k b comment.
	 *
	 * @param kbCommentId the kb comment ID of this k b comment
	 */
	public void setKbCommentId(long kbCommentId);

	/**
	 * Returns the group ID of this k b comment.
	 *
	 * @return the group ID of this k b comment
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this k b comment.
	 *
	 * @param groupId the group ID of this k b comment
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this k b comment.
	 *
	 * @return the company ID of this k b comment
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this k b comment.
	 *
	 * @param companyId the company ID of this k b comment
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this k b comment.
	 *
	 * @return the user ID of this k b comment
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this k b comment.
	 *
	 * @param userId the user ID of this k b comment
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this k b comment.
	 *
	 * @return the user uuid of this k b comment
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this k b comment.
	 *
	 * @param userUuid the user uuid of this k b comment
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this k b comment.
	 *
	 * @return the user name of this k b comment
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this k b comment.
	 *
	 * @param userName the user name of this k b comment
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this k b comment.
	 *
	 * @return the create date of this k b comment
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this k b comment.
	 *
	 * @param createDate the create date of this k b comment
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this k b comment.
	 *
	 * @return the modified date of this k b comment
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this k b comment.
	 *
	 * @param modifiedDate the modified date of this k b comment
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this k b comment.
	 *
	 * @return the fully qualified class name of this k b comment
	 */
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this k b comment.
	 *
	 * @return the class name ID of this k b comment
	 */
	public long getClassNameId();

	/**
	 * Sets the class name ID of this k b comment.
	 *
	 * @param classNameId the class name ID of this k b comment
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this k b comment.
	 *
	 * @return the class p k of this k b comment
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this k b comment.
	 *
	 * @param classPK the class p k of this k b comment
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the content of this k b comment.
	 *
	 * @return the content of this k b comment
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this k b comment.
	 *
	 * @param content the content of this k b comment
	 */
	public void setContent(String content);

	/**
	 * Returns the helpful of this k b comment.
	 *
	 * @return the helpful of this k b comment
	 */
	public boolean getHelpful();

	/**
	 * Returns <code>true</code> if this k b comment is helpful.
	 *
	 * @return <code>true</code> if this k b comment is helpful; <code>false</code> otherwise
	 */
	public boolean isHelpful();

	/**
	 * Sets whether this k b comment is helpful.
	 *
	 * @param helpful the helpful of this k b comment
	 */
	public void setHelpful(boolean helpful);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(KBComment kbComment);

	public int hashCode();

	public CacheModel<KBComment> toCacheModel();

	public KBComment toEscapedModel();

	public KBComment toUnescapedModel();

	public String toString();

	public String toXmlString();
}