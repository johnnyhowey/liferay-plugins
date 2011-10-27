/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.so.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MemberRequest service. Represents a row in the &quot;SO_MemberRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.so.model.impl.MemberRequestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.so.model.impl.MemberRequestImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberRequest
 * @see com.liferay.so.model.impl.MemberRequestImpl
 * @see com.liferay.so.model.impl.MemberRequestModelImpl
 * @generated
 */
public interface MemberRequestModel extends BaseModel<MemberRequest>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a member request model instance should use the {@link MemberRequest} interface instead.
	 */

	/**
	 * Returns the primary key of this member request.
	 *
	 * @return the primary key of this member request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this member request.
	 *
	 * @param primaryKey the primary key of this member request
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the member request ID of this member request.
	 *
	 * @return the member request ID of this member request
	 */
	public long getMemberRequestId();

	/**
	 * Sets the member request ID of this member request.
	 *
	 * @param memberRequestId the member request ID of this member request
	 */
	public void setMemberRequestId(long memberRequestId);

	/**
	 * Returns the group ID of this member request.
	 *
	 * @return the group ID of this member request
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this member request.
	 *
	 * @param groupId the group ID of this member request
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this member request.
	 *
	 * @return the company ID of this member request
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this member request.
	 *
	 * @param companyId the company ID of this member request
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this member request.
	 *
	 * @return the user ID of this member request
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this member request.
	 *
	 * @param userId the user ID of this member request
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this member request.
	 *
	 * @return the user uuid of this member request
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this member request.
	 *
	 * @param userUuid the user uuid of this member request
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this member request.
	 *
	 * @return the user name of this member request
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this member request.
	 *
	 * @param userName the user name of this member request
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this member request.
	 *
	 * @return the create date of this member request
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this member request.
	 *
	 * @param createDate the create date of this member request
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this member request.
	 *
	 * @return the modified date of this member request
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this member request.
	 *
	 * @param modifiedDate the modified date of this member request
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the key of this member request.
	 *
	 * @return the key of this member request
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this member request.
	 *
	 * @param key the key of this member request
	 */
	public void setKey(String key);

	/**
	 * Returns the receiver user ID of this member request.
	 *
	 * @return the receiver user ID of this member request
	 */
	public long getReceiverUserId();

	/**
	 * Sets the receiver user ID of this member request.
	 *
	 * @param receiverUserId the receiver user ID of this member request
	 */
	public void setReceiverUserId(long receiverUserId);

	/**
	 * Returns the receiver user uuid of this member request.
	 *
	 * @return the receiver user uuid of this member request
	 * @throws SystemException if a system exception occurred
	 */
	public String getReceiverUserUuid() throws SystemException;

	/**
	 * Sets the receiver user uuid of this member request.
	 *
	 * @param receiverUserUuid the receiver user uuid of this member request
	 */
	public void setReceiverUserUuid(String receiverUserUuid);

	/**
	 * Returns the invited role ID of this member request.
	 *
	 * @return the invited role ID of this member request
	 */
	public long getInvitedRoleId();

	/**
	 * Sets the invited role ID of this member request.
	 *
	 * @param invitedRoleId the invited role ID of this member request
	 */
	public void setInvitedRoleId(long invitedRoleId);

	/**
	 * Returns the invited team ID of this member request.
	 *
	 * @return the invited team ID of this member request
	 */
	public long getInvitedTeamId();

	/**
	 * Sets the invited team ID of this member request.
	 *
	 * @param invitedTeamId the invited team ID of this member request
	 */
	public void setInvitedTeamId(long invitedTeamId);

	/**
	 * Returns the status of this member request.
	 *
	 * @return the status of this member request
	 */
	public int getStatus();

	/**
	 * Sets the status of this member request.
	 *
	 * @param status the status of this member request
	 */
	public void setStatus(int status);

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

	public int compareTo(MemberRequest memberRequest);

	public int hashCode();

	public CacheModel<MemberRequest> toCacheModel();

	public MemberRequest toEscapedModel();

	public String toString();

	public String toXmlString();
}