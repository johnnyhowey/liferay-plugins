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
 * The base model interface for the KaleoTaskAssignment service. Represents a row in the &quot;KaleoTaskAssignment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskAssignmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskAssignmentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTaskAssignment
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskAssignmentImpl
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskAssignmentModelImpl
 * @generated
 */
public interface KaleoTaskAssignmentModel extends BaseModel<KaleoTaskAssignment>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kaleo task assignment model instance should use the {@link KaleoTaskAssignment} interface instead.
	 */

	/**
	 * Returns the primary key of this kaleo task assignment.
	 *
	 * @return the primary key of this kaleo task assignment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kaleo task assignment.
	 *
	 * @param primaryKey the primary key of this kaleo task assignment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the kaleo task assignment ID of this kaleo task assignment.
	 *
	 * @return the kaleo task assignment ID of this kaleo task assignment
	 */
	public long getKaleoTaskAssignmentId();

	/**
	 * Sets the kaleo task assignment ID of this kaleo task assignment.
	 *
	 * @param kaleoTaskAssignmentId the kaleo task assignment ID of this kaleo task assignment
	 */
	public void setKaleoTaskAssignmentId(long kaleoTaskAssignmentId);

	/**
	 * Returns the group ID of this kaleo task assignment.
	 *
	 * @return the group ID of this kaleo task assignment
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this kaleo task assignment.
	 *
	 * @param groupId the group ID of this kaleo task assignment
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this kaleo task assignment.
	 *
	 * @return the company ID of this kaleo task assignment
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this kaleo task assignment.
	 *
	 * @param companyId the company ID of this kaleo task assignment
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this kaleo task assignment.
	 *
	 * @return the user ID of this kaleo task assignment
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this kaleo task assignment.
	 *
	 * @param userId the user ID of this kaleo task assignment
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kaleo task assignment.
	 *
	 * @return the user uuid of this kaleo task assignment
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this kaleo task assignment.
	 *
	 * @param userUuid the user uuid of this kaleo task assignment
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kaleo task assignment.
	 *
	 * @return the user name of this kaleo task assignment
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this kaleo task assignment.
	 *
	 * @param userName the user name of this kaleo task assignment
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this kaleo task assignment.
	 *
	 * @return the create date of this kaleo task assignment
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this kaleo task assignment.
	 *
	 * @param createDate the create date of this kaleo task assignment
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kaleo task assignment.
	 *
	 * @return the modified date of this kaleo task assignment
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kaleo task assignment.
	 *
	 * @param modifiedDate the modified date of this kaleo task assignment
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the kaleo class name of this kaleo task assignment.
	 *
	 * @return the kaleo class name of this kaleo task assignment
	 */
	@AutoEscape
	public String getKaleoClassName();

	/**
	 * Sets the kaleo class name of this kaleo task assignment.
	 *
	 * @param kaleoClassName the kaleo class name of this kaleo task assignment
	 */
	public void setKaleoClassName(String kaleoClassName);

	/**
	 * Returns the kaleo class p k of this kaleo task assignment.
	 *
	 * @return the kaleo class p k of this kaleo task assignment
	 */
	public long getKaleoClassPK();

	/**
	 * Sets the kaleo class p k of this kaleo task assignment.
	 *
	 * @param kaleoClassPK the kaleo class p k of this kaleo task assignment
	 */
	public void setKaleoClassPK(long kaleoClassPK);

	/**
	 * Returns the kaleo definition ID of this kaleo task assignment.
	 *
	 * @return the kaleo definition ID of this kaleo task assignment
	 */
	public long getKaleoDefinitionId();

	/**
	 * Sets the kaleo definition ID of this kaleo task assignment.
	 *
	 * @param kaleoDefinitionId the kaleo definition ID of this kaleo task assignment
	 */
	public void setKaleoDefinitionId(long kaleoDefinitionId);

	/**
	 * Returns the kaleo node ID of this kaleo task assignment.
	 *
	 * @return the kaleo node ID of this kaleo task assignment
	 */
	public long getKaleoNodeId();

	/**
	 * Sets the kaleo node ID of this kaleo task assignment.
	 *
	 * @param kaleoNodeId the kaleo node ID of this kaleo task assignment
	 */
	public void setKaleoNodeId(long kaleoNodeId);

	/**
	 * Returns the assignee class name of this kaleo task assignment.
	 *
	 * @return the assignee class name of this kaleo task assignment
	 */
	@AutoEscape
	public String getAssigneeClassName();

	/**
	 * Sets the assignee class name of this kaleo task assignment.
	 *
	 * @param assigneeClassName the assignee class name of this kaleo task assignment
	 */
	public void setAssigneeClassName(String assigneeClassName);

	/**
	 * Returns the assignee class p k of this kaleo task assignment.
	 *
	 * @return the assignee class p k of this kaleo task assignment
	 */
	public long getAssigneeClassPK();

	/**
	 * Sets the assignee class p k of this kaleo task assignment.
	 *
	 * @param assigneeClassPK the assignee class p k of this kaleo task assignment
	 */
	public void setAssigneeClassPK(long assigneeClassPK);

	/**
	 * Returns the assignee action ID of this kaleo task assignment.
	 *
	 * @return the assignee action ID of this kaleo task assignment
	 */
	@AutoEscape
	public String getAssigneeActionId();

	/**
	 * Sets the assignee action ID of this kaleo task assignment.
	 *
	 * @param assigneeActionId the assignee action ID of this kaleo task assignment
	 */
	public void setAssigneeActionId(String assigneeActionId);

	/**
	 * Returns the assignee script of this kaleo task assignment.
	 *
	 * @return the assignee script of this kaleo task assignment
	 */
	@AutoEscape
	public String getAssigneeScript();

	/**
	 * Sets the assignee script of this kaleo task assignment.
	 *
	 * @param assigneeScript the assignee script of this kaleo task assignment
	 */
	public void setAssigneeScript(String assigneeScript);

	/**
	 * Returns the assignee script language of this kaleo task assignment.
	 *
	 * @return the assignee script language of this kaleo task assignment
	 */
	@AutoEscape
	public String getAssigneeScriptLanguage();

	/**
	 * Sets the assignee script language of this kaleo task assignment.
	 *
	 * @param assigneeScriptLanguage the assignee script language of this kaleo task assignment
	 */
	public void setAssigneeScriptLanguage(String assigneeScriptLanguage);

	/**
	 * Returns the assignee script required contexts of this kaleo task assignment.
	 *
	 * @return the assignee script required contexts of this kaleo task assignment
	 */
	@AutoEscape
	public String getAssigneeScriptRequiredContexts();

	/**
	 * Sets the assignee script required contexts of this kaleo task assignment.
	 *
	 * @param assigneeScriptRequiredContexts the assignee script required contexts of this kaleo task assignment
	 */
	public void setAssigneeScriptRequiredContexts(
		String assigneeScriptRequiredContexts);

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

	public int compareTo(KaleoTaskAssignment kaleoTaskAssignment);

	public int hashCode();

	public CacheModel<KaleoTaskAssignment> toCacheModel();

	public KaleoTaskAssignment toEscapedModel();

	public KaleoTaskAssignment toUnescapedModel();

	public String toString();

	public String toXmlString();
}