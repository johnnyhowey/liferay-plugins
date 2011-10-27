<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

<%@ include file="/html/portlet/sites_admin/init.jsp" %>

<%
LinkedHashMap groupParams = new LinkedHashMap();

groupParams.put("site", Boolean.TRUE);

Group group = themeDisplay.getScopeGroup();

String userFullName = StringPool.BLANK;

if (group.isUser()) {
	groupParams.put("usersGroups", new Long(group.getClassPK()));

	userFullName = PortalUtil.getUserName(group.getClassPK(), group.getDescriptiveName());
}
else {
	groupParams.put("usersGroups", new Long(themeDisplay.getUserId()));

	userFullName = PortalUtil.getUserName(themeDisplay.getUserId(), "you");
}

groupParams.put("active", Boolean.TRUE);

if (group.isUser() && (themeDisplay.getUserId() != group.getClassPK())) {
	List<Integer> types = new ArrayList<Integer>();

	types.add(GroupConstants.TYPE_SITE_OPEN);
	types.add(GroupConstants.TYPE_SITE_RESTRICTED);

	groupParams.put("types", types);
}

List<Group> results = GroupLocalServiceUtil.search(company.getCompanyId(), null, null, groupParams, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>

<c:choose>
	<c:when test="<%= !results.isEmpty() %>">
		<%
		for (Group currGroup : results) {
			PortletURL groupURL = renderResponse.createActionURL();

			groupURL.setWindowState(WindowState.NORMAL);

			groupURL.setParameter("struts_action", "/sites_admin/page");
			groupURL.setParameter("redirect", currentURL);
			groupURL.setParameter("groupId", String.valueOf(group.getGroupId()));
			groupURL.setParameter("privateLayout", Boolean.FALSE.toString());
		%>

			<div><a href="<%= groupURL %>"><%= currGroup.getDescriptiveName() %></a></div>

		<%
		}
		%>
	</c:when>
	<c:otherwise>
		<div class="empty">
			<liferay-ui:message arguments="<%= userFullName %>" key="x-does-not-belong-to-any-sites" />
		</div>
	</c:otherwise>
</c:choose>