<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
--%>

<%@ include file="/init.jsp" %>

<%
Group group = GroupLocalServiceUtil.getGroup(layout.getGroupId());

List<Group> groups = new ArrayList<Group>();

if (group.isRegularSite()) {
	groups.add(group);
}
else if (group.isUser() && themeDisplay.isSignedIn()) {
	groups.addAll(user.getMySites());
}
else {
	groups.add(GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST));
}

Calendar displayStartTimeJCal = (Calendar)jCal.clone();

displayStartTimeJCal.set(Calendar.HOUR_OF_DAY, 0);
displayStartTimeJCal.set(Calendar.MINUTE, 0);
displayStartTimeJCal.set(Calendar.SECOND, 0);
displayStartTimeJCal.set(Calendar.MILLISECOND, 0);

long displayEndTime = jCal.getTimeInMillis() + (Time.DAY * maxDaysDisplayed);

List<Long> calendarResourceIds = new ArrayList<Long>();

long classNameId = PortalUtil.getClassNameId(Group.class);

for (Group curGroup : groups) {
	CalendarResource calendarResource = CalendarResourceServiceUtil.fetchCalendarResource(classNameId, curGroup.getGroupId());

	if (calendarResource != null) {
		calendarResourceIds.add(calendarResource.getCalendarResourceId());
	}
}

int[] statuses = {WorkflowConstants.STATUS_APPROVED};

List<CalendarBooking> calendarBookings = CalendarBookingServiceUtil.search(themeDisplay.getCompanyId(), null, null, ArrayUtil.toLongArray(calendarResourceIds), -1, null, displayStartTimeJCal.getTimeInMillis(), displayEndTime, true, statuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

if (calendarBookings.size() > 1) {
	ListUtil.sort(calendarBookings, new CalendarBookingTimeComparator(locale));
}

List<CalendarBooking> todayBookings = new ArrayList<CalendarBooking>();
List<CalendarBooking> upcomingBookings = new ArrayList<CalendarBooking>();

for (CalendarBooking calendarBooking : calendarBookings) {
	if (!calendarBooking.isAllDay() && (calendarBooking.getEndTime() < jCal.getTimeInMillis())) {
		continue;
	}

	Calendar startTimeJCal = Calendar.getInstance(timeZone, locale);

	long startTime = calendarBooking.getStartTime();

	if (calendarBooking.isAllDay()) {
		startTime -= timeZone.getRawOffset();

		if (timeZone.inDaylightTime(new Date(startTime))) {
			startTime -= timeZone.getDSTSavings();
		}
	}

	startTimeJCal.setTimeInMillis(startTime);

	if (startTimeJCal.get(Calendar.DAY_OF_MONTH) <= jCal.get(Calendar.DAY_OF_MONTH)) {
		todayBookings.add(calendarBooking);
	}
	else {
		upcomingBookings.add(calendarBooking);
	}
}
%>

<c:choose>
	<c:when test="<%= todayBookings.isEmpty() && upcomingBookings.isEmpty() %>">
		<liferay-ui:message key="there-are-no-more-events-today" />
	</c:when>
	<c:otherwise>
		<c:if test="<%= !todayBookings.isEmpty() %>">
			<h2><liferay-ui:message key="todays-events" /></h2>

			<div class="today-events">

				<%
				request.setAttribute("view.jsp-events", todayBookings);
				%>

				<liferay-util:include page="/view_events.jsp" servletContext="<%= application %>" />
			</div>
		</c:if>

		<c:if test="<%= !upcomingBookings.isEmpty() %>">
			<h2><liferay-ui:message key="upcoming-events" /></h2>

			<div class="upcoming-events">

				<%
				request.setAttribute("view.jsp-events", upcomingBookings);
				%>

				<liferay-util:include page="/view_events.jsp" servletContext="<%= application %>" />
			</div>
		</c:if>
	</c:otherwise>
</c:choose>