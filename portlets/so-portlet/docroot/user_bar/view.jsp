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

<%@ include file="/user_bar/init.jsp" %>

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
		<img alt="Social Office Logo" src="<%= request.getContextPath() + "/user_bar/images/so_logo.png" %>" height="32" width="32" />
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
		<li><a class="config-icon" href="javascript:;" id="userBarConfig"><img alt="Configuration Icon" src="<%= request.getContextPath() + "/user_bar/images/cog.png" %>" height="15" width="15" /><span class="aui-helper-hidden">Configuration</span></a></li>
	</ul>
</nav>

</liferay-util:html-top>

<aui:script use="aui-base event">
	var userBar = A.one('#user-bar');
	var user_menus = userBar.all('.has-menu .child-menu');

	var notificationButton = userBar.one('.user-notification-events-icon');
	var notifications = userBar.one('.user-notification-events');
	var notificationEvents = notifications.all('user-notification-event-content');

console.log(notifications);

	if (notificationButton) {
		notificationButton.on(
			'click',
			function (event) {
				event.preventDefault()
				event.stopPropagation();

				notifications.toggleClass('aui-overlaycontext-hidden');
			}
		);

		notifications.delegate(
			'click',
			function(event) {
				event.stopPropagation();

				var portletURL = event.currentTarget.getAttribute('data-portletUrl');

				if (portletURL) {
					window.location = portletURL;
				}
			},
			'.user-notification-event-content'
		);
	}
</aui:script>