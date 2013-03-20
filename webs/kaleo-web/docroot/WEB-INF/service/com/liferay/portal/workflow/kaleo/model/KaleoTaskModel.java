/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.workflow.kaleo.model;

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
 * The base model interface for the KaleoTask service. Represents a row in the &quot;KaleoTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTask
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskImpl
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskModelImpl
 * @generated
 */
public interface KaleoTaskModel extends BaseModel<KaleoTask>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kaleo task model instance should use the {@link KaleoTask} interface instead.
	 */

	/**
	 * Returns the primary key of this kaleo task.
	 *
	 * @return the primary key of this kaleo task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kaleo task.
	 *
	 * @param primaryKey the primary key of this kaleo task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the kaleo task ID of this kaleo task.
	 *
	 * @return the kaleo task ID of this kaleo task
	 */
	public long getKaleoTaskId();

	/**
	 * Sets the kaleo task ID of this kaleo task.
	 *
	 * @param kaleoTaskId the kaleo task ID of this kaleo task
	 */
	public void setKaleoTaskId(long kaleoTaskId);

	/**
	 * Returns the group ID of this kaleo task.
	 *
	 * @return the group ID of this kaleo task
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this kaleo task.
	 *
	 * @param groupId the group ID of this kaleo task
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this kaleo task.
	 *
	 * @return the company ID of this kaleo task
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this kaleo task.
	 *
	 * @param companyId the company ID of this kaleo task
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this kaleo task.
	 *
	 * @return the user ID of this kaleo task
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this kaleo task.
	 *
	 * @param userId the user ID of this kaleo task
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kaleo task.
	 *
	 * @return the user uuid of this kaleo task
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this kaleo task.
	 *
	 * @param userUuid the user uuid of this kaleo task
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kaleo task.
	 *
	 * @return the user name of this kaleo task
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this kaleo task.
	 *
	 * @param userName the user name of this kaleo task
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this kaleo task.
	 *
	 * @return the create date of this kaleo task
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this kaleo task.
	 *
	 * @param createDate the create date of this kaleo task
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kaleo task.
	 *
	 * @return the modified date of this kaleo task
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kaleo task.
	 *
	 * @param modifiedDate the modified date of this kaleo task
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the kaleo definition ID of this kaleo task.
	 *
	 * @return the kaleo definition ID of this kaleo task
	 */
	public long getKaleoDefinitionId();

	/**
	 * Sets the kaleo definition ID of this kaleo task.
	 *
	 * @param kaleoDefinitionId the kaleo definition ID of this kaleo task
	 */
	public void setKaleoDefinitionId(long kaleoDefinitionId);

	/**
	 * Returns the kaleo node ID of this kaleo task.
	 *
	 * @return the kaleo node ID of this kaleo task
	 */
	public long getKaleoNodeId();

	/**
	 * Sets the kaleo node ID of this kaleo task.
	 *
	 * @param kaleoNodeId the kaleo node ID of this kaleo task
	 */
	public void setKaleoNodeId(long kaleoNodeId);

	/**
	 * Returns the name of this kaleo task.
	 *
	 * @return the name of this kaleo task
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this kaleo task.
	 *
	 * @param name the name of this kaleo task
	 */
	public void setName(String name);

	/**
	 * Returns the description of this kaleo task.
	 *
	 * @return the description of this kaleo task
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this kaleo task.
	 *
	 * @param description the description of this kaleo task
	 */
	public void setDescription(String description);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(KaleoTask kaleoTask);

	public int hashCode();

	public CacheModel<KaleoTask> toCacheModel();

	public KaleoTask toEscapedModel();

	public KaleoTask toUnescapedModel();

	public String toString();

	public String toXmlString();
}