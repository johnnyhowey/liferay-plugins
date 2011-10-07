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

<%@ include file="/init.jsp" %>

<%
int socialRelationType = ParamUtil.getInteger(request, "socialRelationType", 0);

String name = ParamUtil.getString(request, "name");

LinkedHashMap<String, Object> params = null;

if (socialRelationType != 0) {
	params = new LinkedHashMap<String, Object>();
	params.put("socialRelationType", new Long[] {themeDisplay.getUserId(), new Long(socialRelationType)});
}

List<User> result = UserLocalServiceUtil.search(company.getCompanyId(), name, WorkflowConstants.STATUS_APPROVED, params, 0, 8, new UserLastNameComparator(true));

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setWindowState(WindowState.NORMAL);
%>

<aui:layout cssClass="contacts-search">
	<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
		<div class="contact-group-filter">
			<aui:select label="" name="socialRelationType">
				<aui:option label="all" selected='<%= socialRelationType == 0 %>' value="all" />
				<aui:option label="coworkers" selected='<%= socialRelationType ==  SocialRelationConstants.TYPE_BI_COWORKER %>' value="<%= SocialRelationConstants.TYPE_BI_COWORKER %>" />
				<aui:option label="following" selected='<%= socialRelationType == SocialRelationConstants.TYPE_UNI_FOLLOWER%>' value="<%= SocialRelationConstants.TYPE_UNI_FOLLOWER %>" />
			</aui:select>
		</div>
		<input class="search-input" id="<portlet:namespace />name" name="<portlet:namespace />name" size="30" type="text" value="<%= HtmlUtil.escape(name) %>" />

		<input src="<%= themeDisplay.getPathThemeImages() %>/common/search.png" type="image" value='<liferay-ui:message key="search" />' />
	</form>
</aui:layout>

<aui:layout cssClass="contacts-result-container">
	<aui:column cssClass="contacts-result" first="<%= true %>">

		<%
		for (User user2 : result) {
		%>

			<liferay-portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="viewSummaryURL">
				<portlet:param name="jspPage" value="/contacts_center/view_user.jsp" />
				<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
			</liferay-portlet:renderURL>

			<div class="lfr-contact-grid-item" data-user-url="<%= viewSummaryURL %>">
				<div class="lfr-contact-thumb">
					<img alt="<%= HtmlUtil.escape(user2.getFullName()) %>" src="<%= user2.getPortraitURL(themeDisplay) %>" />
				</div>

				<div class="lfr-contact-info">
					<div class="lfr-contact-name">
						<a><%= HtmlUtil.escape(user2.getFullName()) %></a>
					</div>

					<div class="lfr-contact-job-title">
						<%= HtmlUtil.escape(user2.getJobTitle()) %>
					</div>

					<div class="lfr-contact-extra">
						<%= HtmlUtil.escape(user2.getEmailAddress()) %>
					</div>
				</div>

				<div class="clear"></div>
			</div>

		<%
		}
		%>

	</aui:column>
	<aui:column cssClass="contact-summary-container">
		<liferay-util:include page="/contacts_center/view_user.jsp" servletContext="<%= application %>" />
	</aui:column>
</aui:layout>

<aui:script use="aui-base, aui-io">
	Liferay.Contacts.init(
		{
			contactsResult: '.contacts-portlet .contacts-result-content',
			contactsResultContainer: '.contacts-portlet .contacts-result',
			contactsResultURL: '<portlet:resourceURL id="getContacts"><portlet:param name="portletResource" value="<%= portletResource %>" /></portlet:resourceURL>',
			contactsSearchInput: '#<portlet:namespace />name'
		}
	);

	var contactsResult = A.one('.contacts-portlet .contacts-result-container .contacts-result');

	contactsResult.delegate(
		'click',
		function(event) {
			var uri = event.currentTarget.getAttribute('data-user-url');
			var contactSummary = A.one('.contacts-portlet .contacts-result-container .contact-summary-container-content');

			if (!contactSummary.io) {
				contactSummary.plug(
					A.Plugin.IO,
					{
						autoLoad: false
					}
				);
			}

			contactSummary.io.set('uri', uri);

			contactSummary.io.start();
		},
		'.lfr-contact-grid-item'
	);

	var contactFilterContainer = A.one('.contacts-portlet .contact-group-filter');

	var contactFilterSelect = contactFilterContainer.one('select[name=<portlet:namespace />socialRelationType]');

	contactFilterSelect.on(
		'change',
		function(event) {
			searchInput.set('value', '');

			Liferay.Contacts.init(
				{
					contactsResult: '.contacts-portlet .contacts-result-content',
					contactsResultContainer: '.contacts-portlet .contacts-result',
					contactsResultURL: '<portlet:resourceURL id="getContacts"><portlet:param name="portletResource" value="<%= portletResource %>" /></portlet:resourceURL>',
					contactsSearchInput: '#<portlet:namespace />name'
				}
			);

			Liferay.Contacts.updateContacts();
		}
	);


</aui:script>