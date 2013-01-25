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

package com.liferay.so.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SocialActivityGrouping service. Represents a row in the &quot;SO_SocialActivityGrouping&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.so.model.impl.SocialActivityGroupingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.so.model.impl.SocialActivityGroupingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivityGrouping
 * @see com.liferay.so.model.impl.SocialActivityGroupingImpl
 * @see com.liferay.so.model.impl.SocialActivityGroupingModelImpl
 * @generated
 */
public interface SocialActivityGroupingModel extends AttachedModel,
	BaseModel<SocialActivityGrouping> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a social activity grouping model instance should use the {@link SocialActivityGrouping} interface instead.
	 */

	/**
	 * Returns the primary key of this social activity grouping.
	 *
	 * @return the primary key of this social activity grouping
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this social activity grouping.
	 *
	 * @param primaryKey the primary key of this social activity grouping
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the activity grouping ID of this social activity grouping.
	 *
	 * @return the activity grouping ID of this social activity grouping
	 */
	public long getActivityGroupingId();

	/**
	 * Sets the activity grouping ID of this social activity grouping.
	 *
	 * @param activityGroupingId the activity grouping ID of this social activity grouping
	 */
	public void setActivityGroupingId(long activityGroupingId);

	/**
	 * Returns the group ID of this social activity grouping.
	 *
	 * @return the group ID of this social activity grouping
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this social activity grouping.
	 *
	 * @param groupId the group ID of this social activity grouping
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this social activity grouping.
	 *
	 * @return the company ID of this social activity grouping
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this social activity grouping.
	 *
	 * @param companyId the company ID of this social activity grouping
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this social activity grouping.
	 *
	 * @return the user ID of this social activity grouping
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this social activity grouping.
	 *
	 * @param userId the user ID of this social activity grouping
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this social activity grouping.
	 *
	 * @return the user uuid of this social activity grouping
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this social activity grouping.
	 *
	 * @param userUuid the user uuid of this social activity grouping
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this social activity grouping.
	 *
	 * @return the create date of this social activity grouping
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this social activity grouping.
	 *
	 * @param createDate the create date of this social activity grouping
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this social activity grouping.
	 *
	 * @return the modified date of this social activity grouping
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this social activity grouping.
	 *
	 * @param modifiedDate the modified date of this social activity grouping
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this social activity grouping.
	 *
	 * @return the fully qualified class name of this social activity grouping
	 */
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this social activity grouping.
	 *
	 * @return the class name ID of this social activity grouping
	 */
	public long getClassNameId();

	/**
	 * Sets the class name ID of this social activity grouping.
	 *
	 * @param classNameId the class name ID of this social activity grouping
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this social activity grouping.
	 *
	 * @return the class p k of this social activity grouping
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this social activity grouping.
	 *
	 * @param classPK the class p k of this social activity grouping
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the type of this social activity grouping.
	 *
	 * @return the type of this social activity grouping
	 */
	public int getType();

	/**
	 * Sets the type of this social activity grouping.
	 *
	 * @param type the type of this social activity grouping
	 */
	public void setType(int type);

	/**
	 * Returns the activity IDs of this social activity grouping.
	 *
	 * @return the activity IDs of this social activity grouping
	 */
	@AutoEscape
	public String getActivityIds();

	/**
	 * Sets the activity IDs of this social activity grouping.
	 *
	 * @param activityIds the activity IDs of this social activity grouping
	 */
	public void setActivityIds(String activityIds);

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

	public int compareTo(SocialActivityGrouping socialActivityGrouping);

	public int hashCode();

	public CacheModel<SocialActivityGrouping> toCacheModel();

	public SocialActivityGrouping toEscapedModel();

	public SocialActivityGrouping toUnescapedModel();

	public String toString();

	public String toXmlString();
}