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
User user2 = null;

user2 = (User)request.getAttribute("view_user.jsp-user");

%>

<c:if test="<%= user.getUserId() != user2.getUserId() %>">


	<liferay-ui:icon
		image="view"
		label="<%= true %>"
		message="view-profile"
		url="<%= user2.getDisplayURL(themeDisplay) %>"
	/>
</c:if>

<%
boolean viewRelationActions = true;

if (SocialRelationLocalServiceUtil.hasRelation(user2.getUserId(), themeDisplay.getUserId(), SocialRelationConstants.TYPE_UNI_ENEMY)) {
	viewRelationActions = false;
}
else if (SocialRelationLocalServiceUtil.hasRelation(themeDisplay.getUserId(), user2.getUserId(), SocialRelationConstants.TYPE_UNI_ENEMY)) {
	viewRelationActions = false;
}
%>

<c:if test="<%= viewRelationActions %>">
	<c:choose>
		<c:when test="<%= SocialRelationLocalServiceUtil.hasRelation(themeDisplay.getUserId(), user2.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND) %>">
			<portlet:actionURL name="deleteSocialRelation" var="removeFriendURL">
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
				<portlet:param name="type" value="<%= String.valueOf(SocialRelationConstants.TYPE_BI_FRIEND) %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				cssClass="action remove-friend"
				image="../social/remove_friend"
				label="<%= true %>"
				message="remove-as-friend"
				method="get"
				url="<%= removeFriendURL %>"
			/>
		</c:when>
		<c:when test="<%= SocialRequestLocalServiceUtil.hasRequest(themeDisplay.getUserId(), User.class.getName(), themeDisplay.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND, user2.getUserId(), SocialRequestConstants.STATUS_PENDING) %>">
			<liferay-ui:icon
				cssClass="disabled"
				image="../social/friend"
				label="<%= true %>"
				message="friend-requested"
			/>
		</c:when>
		<c:when test="<%= SocialRelationLocalServiceUtil.isRelatable(themeDisplay.getUserId(), user2.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND) %>">
			<portlet:actionURL name="requestSocialRelation" var="addFriendURL">
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
				<portlet:param name="type" value="<%= String.valueOf(SocialRelationConstants.TYPE_BI_FRIEND) %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				cssClass="action add-friend"
				image="../social/add_friend"
				label="<%= true %>"
				message="add-as-friend"
				method="get"
				url="<%= addFriendURL %>"
			/>
		</c:when>
	</c:choose>

	<c:choose>
		<c:when test="<%= SocialRelationLocalServiceUtil.hasRelation(themeDisplay.getUserId(), user2.getUserId(), SocialRelationConstants.TYPE_BI_COWORKER) %>">
			<portlet:actionURL name="deleteSocialRelation" var="removeCoworkerURL">
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
				<portlet:param name="type" value="<%= String.valueOf(SocialRelationConstants.TYPE_BI_COWORKER) %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				cssClass="action remove-coworker"
				image="../social/remove_coworker"
				label="<%= true %>"
				message="remove-as-coworker"
				method="get"
				url="<%= removeCoworkerURL %>"
			/>
		</c:when>
		<c:when test="<%= SocialRequestLocalServiceUtil.hasRequest(themeDisplay.getUserId(), User.class.getName(), themeDisplay.getUserId(), SocialRelationConstants.TYPE_BI_COWORKER, user2.getUserId(), SocialRequestConstants.STATUS_PENDING) %>">
			<liferay-ui:icon
				cssClass="disabled"
				label="<%= true %>"
				image="../social/coworker"
				message="coworker-requested"
			/>
		</c:when>
		<c:when test="<%= SocialRelationLocalServiceUtil.isRelatable(themeDisplay.getUserId(), user2.getUserId(), SocialRelationConstants.TYPE_BI_COWORKER) %>">
			<portlet:actionURL name="requestSocialRelation" var="addCoworkerURL">
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
				<portlet:param name="type" value="<%= String.valueOf(SocialRelationConstants.TYPE_BI_COWORKER) %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				cssClass="action add-coworker"
				image="../social/add_coworker"
				label="<%= true %>"
				message="add-as-coworker"
				method="get"
				url="<%= addCoworkerURL %>"
			/>
		</c:when>
	</c:choose>

	<c:choose>
		<c:when test="<%= SocialRelationLocalServiceUtil.hasRelation(themeDisplay.getUserId(), user2.getUserId(), SocialRelationConstants.TYPE_UNI_FOLLOWER) %>">
			<portlet:actionURL name="deleteSocialRelation" var="unfollowURL">
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
				<portlet:param name="type" value="<%= String.valueOf(SocialRelationConstants.TYPE_UNI_FOLLOWER) %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				cssClass="action unfollow"
				image="../social/unfollow"
				label="<%= true %>"
				message="unfollow"
				method="get"
				url="<%= unfollowURL %>"
			/>
		</c:when>
		<c:when test="<%= SocialRelationLocalServiceUtil.isRelatable(themeDisplay.getUserId(), user2.getUserId(), SocialRelationConstants.TYPE_UNI_FOLLOWER) %>">
			<portlet:actionURL name="addSocialRelation" var="followURL">
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
				<portlet:param name="type" value="<%= String.valueOf(SocialRelationConstants.TYPE_UNI_FOLLOWER) %>" />
			</portlet:actionURL>

			<liferay-ui:icon
				cssClass="action follow"
				image="../social/follow"
				label="<%= true %>"
				message="follow"
				method="get"
				url="<%= followURL %>"
			/>
		</c:when>
	</c:choose>
</c:if>

<c:choose>
	<c:when test="<%= SocialRelationLocalServiceUtil.hasRelation(themeDisplay.getUserId(), user2.getUserId(), SocialRelationConstants.TYPE_UNI_ENEMY) %>">
		<portlet:actionURL name="deleteSocialRelation" var="unblockURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
			<portlet:param name="type" value="<%= String.valueOf(SocialRelationConstants.TYPE_UNI_ENEMY) %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			cssClass="action unblock"
			image="../social/unblock"
			label="<%= true %>"
			message="unblock"
			method="get"
			url="<%= unblockURL %>"
		/>
	</c:when>
	<c:when test="<%= SocialRelationLocalServiceUtil.isRelatable(themeDisplay.getUserId(), user2.getUserId(), SocialRelationConstants.TYPE_UNI_ENEMY) %>">
		<portlet:actionURL name="addSocialRelation" var="blockURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
			<portlet:param name="type" value="<%= String.valueOf(SocialRelationConstants.TYPE_UNI_ENEMY) %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			cssClass="action block"
			image="../social/block"
			label="<%= true %>"
			message="block"
			method="get"
			url="<%= blockURL %>"
		/>
	</c:when>
</c:choose>

<c:if test="<%= user.getUserId() == user2.getUserId() %>">
	<liferay-ui:icon
		cssClass="edit-profile"
		image="edit"
		label="<%= true %>"
		message="edit-profile"
		method="get"
		url="javascript:;"
	/>
</c:if>

<portlet:resourceURL id="exportVCard" var="exportURL">
	<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
</portlet:resourceURL>

<liferay-ui:icon
	image="export"
	label="<%= true %>"
	message="export-vcard"
	url="<%= exportURL %>"
/>


	<aui:script use="aui-base,aui-dialog,aui-dialog-iframe">
		<c:if test="<%= user.getUserId() == user2.getUserId() %>">
			var editProfile = A.one('.contacts-portlet .edit-profile');

			if (editProfile) {
				editProfile.on(
					'click',
					function(event) {
						event.preventDefault();

						var url = Liferay.Util.addParams('controlPanelCategory=<%= PortletCategoryKeys.MY %>', '<%= themeDisplay.getURLMyAccount().toString() %>');

						var dialog = new A.Dialog(
							{
								align: {
									node: null,
									points: ['tc', 'tc']
								},
								constrain2view: true,
								modal: true,
								resizable: false,
								title: '<liferay-ui:message key="edit-profile" />',
								width: 950
							}
						).plug(
							A.Plugin.DialogIframe,
							{
								uri: url
							}
						).render();
					}
				);
			}
		</c:if>

		<liferay-portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="viewSummaryURL">
			<portlet:param name="jspPage" value="/contacts_center/view_user.jsp" />
			<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
		</liferay-portlet:renderURL>

		var contactAction = A.one('.contacts-portlet .contact-action-content');

		if (contactAction) {
			contactAction.delegate(
				'click',
				function(event) {
					event.preventDefault();

					A.io.request(
						event.currentTarget.getAttribute('href'),
						{
							on: {
								success: function(event, id, obj) {
									var contactSummary = A.one('.contacts-portlet .contacts-result-container .contact-summary-container-content');

									if (!contactSummary.io) {
										contactSummary.plug(
											A.Plugin.IO,
											{
												autoLoad: false
											}
										);
									}

									contactSummary.io.set('uri', '<%= viewSummaryURL %>');

									contactSummary.io.start();
								}
							}
						}
					);
				},
				'.action a'

			);
		}


	</aui:script>
