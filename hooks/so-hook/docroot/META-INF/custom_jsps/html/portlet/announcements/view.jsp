<%--
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
--%>

<%@ include file="/html/portlet/announcements/init.jsp" %>

<%
themeDisplay.setIncludeServiceJs(true);

String tabs1 = ParamUtil.getString(request, "tabs1", "entries");

String redirect = ParamUtil.getString(request, "redirect");

long entryId = ParamUtil.getLong(request, "entryId");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/announcements/view");
portletURL.setParameter("tabs1", tabs1);
%>

<c:if test="<%= (entryId == 0) && (!portletName.equals(PortletKeys.ALERTS) || (portletName.equals(PortletKeys.ALERTS) && AnnouncementsEntryPermission.contains(permissionChecker, layout, PortletKeys.ALERTS, ActionKeys.ADD_ENTRY)) || AnnouncementsEntryPermission.contains(permissionChecker, layout, portletName, ActionKeys.ADD_ENTRY)) %>">
	<liferay-util:include page="/html/portlet/announcements/tabs1.jsp" />
</c:if>

<c:choose>
	<c:when test="<%= entryId > 0 %>">

		<%
		AnnouncementsEntry entry = AnnouncementsEntryLocalServiceUtil.getEntry(entryId);
		%>

		<%@ include file="/html/portlet/announcements/view_full_entry.so-hook.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("entries") && (entryId == 0) %>'>
		<%@ include file="/html/portlet/announcements/view_entries.so-hook.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("manage-entries") %>'>
		<%@ include file="/html/portlet/announcements/view_manage_entries.so-hook.jspf" %>
	</c:when>
</c:choose>