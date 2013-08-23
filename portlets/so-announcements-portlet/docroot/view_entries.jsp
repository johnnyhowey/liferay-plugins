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
boolean readEntries = ParamUtil.getBoolean(request, "readEntries", Boolean.TRUE);

int flagValue = AnnouncementsFlagConstants.NOT_HIDDEN;;

if (readEntries) {
	flagValue = AnnouncementsFlagConstants.HIDDEN;
}

LinkedHashMap<Long, long[]> scopes = new LinkedHashMap<Long, long[]>();

if (customizeAnnouncementsDisplayed) {
	long[] selectedScopeGroupIdsArray = GetterUtil.getLongValues(StringUtil.split(selectedScopeGroupIds));
	long[] selectedScopeOrganizationIdsArray = GetterUtil.getLongValues(StringUtil.split(selectedScopeGroupIds));
	long[] selectedScopeRoleIdsArray = GetterUtil.getLongValues(StringUtil.split(selectedScopeGroupIds));
	long[] selectedScopeUserGroupIdsArray = GetterUtil.getLongValues(StringUtil.split(selectedScopeGroupIds));

	if (selectedScopeGroupIdsArray.length != 0) {
		scopes.put(PortalUtil.getClassNameId(Group.class.getName()), selectedScopeGroupIdsArray);
	}

	if (selectedScopeOrganizationIdsArray.length != 0) {
		scopes.put(PortalUtil.getClassNameId(Organization.class.getName()), selectedScopeOrganizationIdsArray);
	}

	if (selectedScopeRoleIdsArray.length != 0) {
		scopes.put(PortalUtil.getClassNameId(Role.class.getName()), selectedScopeRoleIdsArray);
	}

	if (selectedScopeUserGroupIdsArray.length != 0) {
		scopes.put(PortalUtil.getClassNameId(UserGroup.class.getName()), selectedScopeUserGroupIdsArray);
	}
}
else {
	scopes = AnnouncementsUtil.getAnnouncementScopes(user.getUserId());
}

scopes.put(new Long(0), new long[] {0});

int start = ParamUtil.getInteger(request, "start", 0);

int end = ParamUtil.getInteger(request, "end", start + pageDelta);

int total = AnnouncementsEntryLocalServiceUtil.getEntriesCount(user.getUserId(), scopes, portletName.equals(PortletKeys.ALERTS), flagValue);

if ((start >= total) && (start != 0)) {
	start -= pageDelta;

	end = start + pageDelta;
}

List<AnnouncementsEntry> results = AnnouncementsEntryLocalServiceUtil.getEntries(user.getUserId(), scopes, portletName.equals(PortletKeys.ALERTS), flagValue, start, end);
%>

<c:choose>
	<c:when test="<%= readEntries %>">
		<c:if test="<%= themeDisplay.isSignedIn() && !results.isEmpty() %>">
			<div class="read-entries" data-start="<%= start %>" id="readEntries">
				<div class="header">
					<span><%= LanguageUtil.get(pageContext, "read-entries") %></span>
				</div>

				<%
				boolean expanded = ParamUtil.getBoolean(request, "expanded", Boolean.FALSE);
				%>

				<div class="content aui-toggler-content aui-toggler-content-<%= expanded ? "expanded" : "collapsed" %>">
					<%@ include file="/entry_iterator.jspf" %>
				</div>
			</div>

			<aui:script>
				AUI().ready(
					'aui-toggler',
					function(A) {
						new A.Toggler(
							{
								animated: true,
								container: '#readEntries',
								content: '#readEntries .content',
								expanded: <%= expanded %>,
								header: '#readEntries .header',
								transition: {
									duration: 0.5,
									easing: 'ease-in-out'
								}
							}
						);
					}
				);
			</aui:script>
		</c:if>
	</c:when>
	<c:otherwise>
		<div class="unread-entries" data-start="<%= start %>" id="unreadEntries">
			<%@ include file="/entry_iterator.jspf" %>
		</div>
	</c:otherwise>
</c:choose>

<aui:script use="aui-base">
	<c:choose>
		<c:when test="<%= readEntries %>">
			var container = A.one('#readEntriesContainer');
		</c:when>
		<c:otherwise>
			var container = AUI().one('#unreadEntriesContainer');
		</c:otherwise>
	</c:choose>

	container.delegate(
		'click',
		function(event) {
			event.preventDefault();

			if (container) {
				var navURL = '';
				var navLink = event.currentTarget;

				var navParent = navLink.ancestor();

				if (navParent.hasClass('left-nav')) {
					<portlet:renderURL var="previousURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="mvcPath" value="/view_entries.jsp" />
						<portlet:param name="end" value="<%= String.valueOf(end - pageDelta) %>" />
						<portlet:param name="readEntries" value='<%= readEntries ? "true" : "false" %>' />
						<portlet:param name="start" value="<%= String.valueOf(start - pageDelta) %>" />
					</portlet:renderURL>

					navURL = '<%= previousURL %>';
				}
				else {
					<portlet:renderURL var="nextURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="mvcPath" value="/view_entries.jsp" />
						<portlet:param name="end" value="<%= String.valueOf(end + pageDelta) %>" />
						<portlet:param name="readEntries" value='<%= readEntries ? "true" : "false" %>' />
						<portlet:param name="start" value="<%= String.valueOf(start + pageDelta) %>" />
					</portlet:renderURL>

					navURL = '<%= nextURL %>';
				}

				<c:if test="<%= readEntries %>">
					navURL = Liferay.Announcements.appendTogglerState(navURL);
				</c:if>

				Liferay.Announcements.loadNode(container, navURL);
			}
		},
		'.navigation span a'
	);
</aui:script>