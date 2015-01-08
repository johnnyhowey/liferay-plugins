/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.mail.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Account service. Represents a row in the &quot;Mail_Account&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.mail.model.impl.AccountModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.mail.model.impl.AccountImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Account
 * @see com.liferay.mail.model.impl.AccountImpl
 * @see com.liferay.mail.model.impl.AccountModelImpl
 * @generated
 */
@ProviderType
public interface AccountModel extends AuditedModel, BaseModel<Account> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a account model instance should use the {@link Account} interface instead.
	 */

	/**
	 * Returns the primary key of this account.
	 *
	 * @return the primary key of this account
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this account.
	 *
	 * @param primaryKey the primary key of this account
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the account ID of this account.
	 *
	 * @return the account ID of this account
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this account.
	 *
	 * @param accountId the account ID of this account
	 */
	public void setAccountId(long accountId);

	/**
	 * Returns the company ID of this account.
	 *
	 * @return the company ID of this account
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this account.
	 *
	 * @param companyId the company ID of this account
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this account.
	 *
	 * @return the user ID of this account
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this account.
	 *
	 * @param userId the user ID of this account
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this account.
	 *
	 * @return the user uuid of this account
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this account.
	 *
	 * @param userUuid the user uuid of this account
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this account.
	 *
	 * @return the user name of this account
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this account.
	 *
	 * @param userName the user name of this account
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this account.
	 *
	 * @return the create date of this account
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this account.
	 *
	 * @param createDate the create date of this account
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this account.
	 *
	 * @return the modified date of this account
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this account.
	 *
	 * @param modifiedDate the modified date of this account
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the address of this account.
	 *
	 * @return the address of this account
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this account.
	 *
	 * @param address the address of this account
	 */
	public void setAddress(String address);

	/**
	 * Returns the personal name of this account.
	 *
	 * @return the personal name of this account
	 */
	@AutoEscape
	public String getPersonalName();

	/**
	 * Sets the personal name of this account.
	 *
	 * @param personalName the personal name of this account
	 */
	public void setPersonalName(String personalName);

	/**
	 * Returns the protocol of this account.
	 *
	 * @return the protocol of this account
	 */
	@AutoEscape
	public String getProtocol();

	/**
	 * Sets the protocol of this account.
	 *
	 * @param protocol the protocol of this account
	 */
	public void setProtocol(String protocol);

	/**
	 * Returns the incoming host name of this account.
	 *
	 * @return the incoming host name of this account
	 */
	@AutoEscape
	public String getIncomingHostName();

	/**
	 * Sets the incoming host name of this account.
	 *
	 * @param incomingHostName the incoming host name of this account
	 */
	public void setIncomingHostName(String incomingHostName);

	/**
	 * Returns the incoming port of this account.
	 *
	 * @return the incoming port of this account
	 */
	public int getIncomingPort();

	/**
	 * Sets the incoming port of this account.
	 *
	 * @param incomingPort the incoming port of this account
	 */
	public void setIncomingPort(int incomingPort);

	/**
	 * Returns the incoming secure of this account.
	 *
	 * @return the incoming secure of this account
	 */
	public boolean getIncomingSecure();

	/**
	 * Returns <code>true</code> if this account is incoming secure.
	 *
	 * @return <code>true</code> if this account is incoming secure; <code>false</code> otherwise
	 */
	public boolean isIncomingSecure();

	/**
	 * Sets whether this account is incoming secure.
	 *
	 * @param incomingSecure the incoming secure of this account
	 */
	public void setIncomingSecure(boolean incomingSecure);

	/**
	 * Returns the outgoing host name of this account.
	 *
	 * @return the outgoing host name of this account
	 */
	@AutoEscape
	public String getOutgoingHostName();

	/**
	 * Sets the outgoing host name of this account.
	 *
	 * @param outgoingHostName the outgoing host name of this account
	 */
	public void setOutgoingHostName(String outgoingHostName);

	/**
	 * Returns the outgoing port of this account.
	 *
	 * @return the outgoing port of this account
	 */
	public int getOutgoingPort();

	/**
	 * Sets the outgoing port of this account.
	 *
	 * @param outgoingPort the outgoing port of this account
	 */
	public void setOutgoingPort(int outgoingPort);

	/**
	 * Returns the outgoing secure of this account.
	 *
	 * @return the outgoing secure of this account
	 */
	public boolean getOutgoingSecure();

	/**
	 * Returns <code>true</code> if this account is outgoing secure.
	 *
	 * @return <code>true</code> if this account is outgoing secure; <code>false</code> otherwise
	 */
	public boolean isOutgoingSecure();

	/**
	 * Sets whether this account is outgoing secure.
	 *
	 * @param outgoingSecure the outgoing secure of this account
	 */
	public void setOutgoingSecure(boolean outgoingSecure);

	/**
	 * Returns the login of this account.
	 *
	 * @return the login of this account
	 */
	@AutoEscape
	public String getLogin();

	/**
	 * Sets the login of this account.
	 *
	 * @param login the login of this account
	 */
	public void setLogin(String login);

	/**
	 * Returns the password of this account.
	 *
	 * @return the password of this account
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this account.
	 *
	 * @param password the password of this account
	 */
	public void setPassword(String password);

	/**
	 * Returns the save password of this account.
	 *
	 * @return the save password of this account
	 */
	public boolean getSavePassword();

	/**
	 * Returns <code>true</code> if this account is save password.
	 *
	 * @return <code>true</code> if this account is save password; <code>false</code> otherwise
	 */
	public boolean isSavePassword();

	/**
	 * Sets whether this account is save password.
	 *
	 * @param savePassword the save password of this account
	 */
	public void setSavePassword(boolean savePassword);

	/**
	 * Returns the signature of this account.
	 *
	 * @return the signature of this account
	 */
	@AutoEscape
	public String getSignature();

	/**
	 * Sets the signature of this account.
	 *
	 * @param signature the signature of this account
	 */
	public void setSignature(String signature);

	/**
	 * Returns the use signature of this account.
	 *
	 * @return the use signature of this account
	 */
	public boolean getUseSignature();

	/**
	 * Returns <code>true</code> if this account is use signature.
	 *
	 * @return <code>true</code> if this account is use signature; <code>false</code> otherwise
	 */
	public boolean isUseSignature();

	/**
	 * Sets whether this account is use signature.
	 *
	 * @param useSignature the use signature of this account
	 */
	public void setUseSignature(boolean useSignature);

	/**
	 * Returns the folder prefix of this account.
	 *
	 * @return the folder prefix of this account
	 */
	@AutoEscape
	public String getFolderPrefix();

	/**
	 * Sets the folder prefix of this account.
	 *
	 * @param folderPrefix the folder prefix of this account
	 */
	public void setFolderPrefix(String folderPrefix);

	/**
	 * Returns the inbox folder ID of this account.
	 *
	 * @return the inbox folder ID of this account
	 */
	public long getInboxFolderId();

	/**
	 * Sets the inbox folder ID of this account.
	 *
	 * @param inboxFolderId the inbox folder ID of this account
	 */
	public void setInboxFolderId(long inboxFolderId);

	/**
	 * Returns the draft folder ID of this account.
	 *
	 * @return the draft folder ID of this account
	 */
	public long getDraftFolderId();

	/**
	 * Sets the draft folder ID of this account.
	 *
	 * @param draftFolderId the draft folder ID of this account
	 */
	public void setDraftFolderId(long draftFolderId);

	/**
	 * Returns the sent folder ID of this account.
	 *
	 * @return the sent folder ID of this account
	 */
	public long getSentFolderId();

	/**
	 * Sets the sent folder ID of this account.
	 *
	 * @param sentFolderId the sent folder ID of this account
	 */
	public void setSentFolderId(long sentFolderId);

	/**
	 * Returns the trash folder ID of this account.
	 *
	 * @return the trash folder ID of this account
	 */
	public long getTrashFolderId();

	/**
	 * Sets the trash folder ID of this account.
	 *
	 * @param trashFolderId the trash folder ID of this account
	 */
	public void setTrashFolderId(long trashFolderId);

	/**
	 * Returns the default sender of this account.
	 *
	 * @return the default sender of this account
	 */
	public boolean getDefaultSender();

	/**
	 * Returns <code>true</code> if this account is default sender.
	 *
	 * @return <code>true</code> if this account is default sender; <code>false</code> otherwise
	 */
	public boolean isDefaultSender();

	/**
	 * Sets whether this account is default sender.
	 *
	 * @param defaultSender the default sender of this account
	 */
	public void setDefaultSender(boolean defaultSender);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.liferay.mail.model.Account account);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.mail.model.Account> toCacheModel();

	@Override
	public com.liferay.mail.model.Account toEscapedModel();

	@Override
	public com.liferay.mail.model.Account toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}