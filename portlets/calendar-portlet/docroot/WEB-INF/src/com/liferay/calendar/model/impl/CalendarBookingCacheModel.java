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

package com.liferay.calendar.model.impl;

import com.liferay.calendar.model.CalendarBooking;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CalendarBooking in entity cache.
 *
 * @author Eduardo Lundgren
 * @see CalendarBooking
 * @generated
 */
public class CalendarBookingCacheModel implements CacheModel<CalendarBooking>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", calendarBookingId=");
		sb.append(calendarBookingId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", calendarId=");
		sb.append(calendarId);
		sb.append(", calendarResourceId=");
		sb.append(calendarResourceId);
		sb.append(", parentCalendarBookingId=");
		sb.append(parentCalendarBookingId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", location=");
		sb.append(location);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", allDay=");
		sb.append(allDay);
		sb.append(", recurrence=");
		sb.append(recurrence);
		sb.append(", firstReminder=");
		sb.append(firstReminder);
		sb.append(", firstReminderType=");
		sb.append(firstReminderType);
		sb.append(", secondReminder=");
		sb.append(secondReminder);
		sb.append(", secondReminderType=");
		sb.append(secondReminderType);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	public CalendarBooking toEntityModel() {
		CalendarBookingImpl calendarBookingImpl = new CalendarBookingImpl();

		if (uuid == null) {
			calendarBookingImpl.setUuid(StringPool.BLANK);
		}
		else {
			calendarBookingImpl.setUuid(uuid);
		}

		calendarBookingImpl.setCalendarBookingId(calendarBookingId);
		calendarBookingImpl.setGroupId(groupId);
		calendarBookingImpl.setCompanyId(companyId);
		calendarBookingImpl.setUserId(userId);

		if (userName == null) {
			calendarBookingImpl.setUserName(StringPool.BLANK);
		}
		else {
			calendarBookingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			calendarBookingImpl.setCreateDate(null);
		}
		else {
			calendarBookingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			calendarBookingImpl.setModifiedDate(null);
		}
		else {
			calendarBookingImpl.setModifiedDate(new Date(modifiedDate));
		}

		calendarBookingImpl.setCalendarId(calendarId);
		calendarBookingImpl.setCalendarResourceId(calendarResourceId);
		calendarBookingImpl.setParentCalendarBookingId(parentCalendarBookingId);

		if (title == null) {
			calendarBookingImpl.setTitle(StringPool.BLANK);
		}
		else {
			calendarBookingImpl.setTitle(title);
		}

		if (description == null) {
			calendarBookingImpl.setDescription(StringPool.BLANK);
		}
		else {
			calendarBookingImpl.setDescription(description);
		}

		if (location == null) {
			calendarBookingImpl.setLocation(StringPool.BLANK);
		}
		else {
			calendarBookingImpl.setLocation(location);
		}

		calendarBookingImpl.setStartDate(startDate);
		calendarBookingImpl.setEndDate(endDate);
		calendarBookingImpl.setAllDay(allDay);

		if (recurrence == null) {
			calendarBookingImpl.setRecurrence(StringPool.BLANK);
		}
		else {
			calendarBookingImpl.setRecurrence(recurrence);
		}

		calendarBookingImpl.setFirstReminder(firstReminder);

		if (firstReminderType == null) {
			calendarBookingImpl.setFirstReminderType(StringPool.BLANK);
		}
		else {
			calendarBookingImpl.setFirstReminderType(firstReminderType);
		}

		calendarBookingImpl.setSecondReminder(secondReminder);

		if (secondReminderType == null) {
			calendarBookingImpl.setSecondReminderType(StringPool.BLANK);
		}
		else {
			calendarBookingImpl.setSecondReminderType(secondReminderType);
		}

		calendarBookingImpl.setStatus(status);
		calendarBookingImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			calendarBookingImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			calendarBookingImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			calendarBookingImpl.setStatusDate(null);
		}
		else {
			calendarBookingImpl.setStatusDate(new Date(statusDate));
		}

		calendarBookingImpl.resetOriginalValues();

		return calendarBookingImpl;
	}

	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		calendarBookingId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		calendarId = objectInput.readLong();
		calendarResourceId = objectInput.readLong();
		parentCalendarBookingId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		location = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		allDay = objectInput.readBoolean();
		recurrence = objectInput.readUTF();
		firstReminder = objectInput.readLong();
		firstReminderType = objectInput.readUTF();
		secondReminder = objectInput.readLong();
		secondReminderType = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(calendarBookingId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(calendarId);
		objectOutput.writeLong(calendarResourceId);
		objectOutput.writeLong(parentCalendarBookingId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeBoolean(allDay);

		if (recurrence == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(recurrence);
		}

		objectOutput.writeLong(firstReminder);

		if (firstReminderType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstReminderType);
		}

		objectOutput.writeLong(secondReminder);

		if (secondReminderType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secondReminderType);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long calendarBookingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long calendarId;
	public long calendarResourceId;
	public long parentCalendarBookingId;
	public String title;
	public String description;
	public String location;
	public long startDate;
	public long endDate;
	public boolean allDay;
	public String recurrence;
	public long firstReminder;
	public String firstReminderType;
	public long secondReminder;
	public String secondReminderType;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}