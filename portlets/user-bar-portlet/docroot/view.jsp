<%
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="javax.portlet.PortletPreferences" %><%@
page import="java.util.List" %><%@
page import="java.util.Locale" %>

<%@ page import="com.liferay.portal.model.Group" %><%@
page import="com.liferay.portal.model.Layout" %><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil" %><%@
page import="com.liferay.portal.service.LayoutLocalServiceUtil" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-util:html-top>
<%
	PortletPreferences prefs = renderRequest.getPreferences();

	Group mySite = user.getGroup();
	String mySiteURL = mySite.getPathFriendlyURL(true,themeDisplay) + "/" + user.getScreenName();
	String mySitePublicURL = mySite.getPathFriendlyURL(false,themeDisplay) + "/" + user.getScreenName();

	List < Layout > myLayouts = LayoutLocalServiceUtil.getLayouts(mySite.getGroupId(), true);

%>

<nav id="user-bar">
	<a href="<%= mySiteURL %>" id="so_logo">
		<img alt="Social Office Logo" src="<%= request.getContextPath() + "/images/so_logo.png" %>" height="32" width="32" />
	</a>

	<ul id="dashboardNav">

<%
	for (Layout curLayout : myLayouts) {
		if (curLayout.isRootLayout() && !curLayout.isHidden()) {

			String friendlyURL = mySiteURL + curLayout.getFriendlyURL();
			String layoutName = curLayout.getName(themeDisplay.getLocale(), true);

			String curLayoutIsSelected = "";

			if (curLayout.getPlid() == layout.getPlid()) {
				curLayoutIsSelected = " class=\"selected\"";
			}

%>

<li<%= curLayoutIsSelected %>><a href="<%= friendlyURL %>"><%= layoutName %></a></li>

<%
		}
	}
%>

	</ul>

	<ul class="user-menu">
		<li class="notifications-menu has-submenu" id="notificationsMenu">
			<liferay-portlet:runtime portletName="7_WAR_soportlet" />
		</li>
		<li class="user-info"><a href="<%= mySitePublicURL %>"><span class="avatar"><img src="<%= HtmlUtil.escape(user.getPortraitURL(themeDisplay)) %>" alt="<%= user.getFullName() %>"></span><span class="full-name"><%= user.getFullName() %></span></a></li>
		<li><a class="config-icon" href="javascript:;" id="userBarConfig"><img alt="Configuration Icon" src="<%= request.getContextPath() + "/images/cog.png" %>" height="15" width="15" /><span class="aui-helper-hidden">Configuration</span></a></li>
	</ul>
</nav>

</liferay-util:html-top>