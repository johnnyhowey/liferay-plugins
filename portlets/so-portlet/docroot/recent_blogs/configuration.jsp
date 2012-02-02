<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

<%@ include file="/recent_blogs/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="recentBlogOrderingAndGroupingPanel" persistState="<%= true %>" title="ordering-and-grouping">
		<aui:fieldset>
			<span class="aui-field-row">
				<aui:select inlineField="<%= true %>" inlineLabel="left" label="order-by" name="preferences--orderByColumn1--">
					<aui:option label="title" selected='<%= orderByColumn1.equals("title") %>' />
					<aui:option label="create-date" selected='<%= orderByColumn1.equals("createDate") %>' value="createDate" />
					<aui:option label="modified-date" selected='<%= orderByColumn1.equals("modifiedDate") %>' value="modifiedDate" />
					<aui:option label="publish-date" selected='<%= orderByColumn1.equals("publishDate") %>' value="publishDate" />
					<aui:option label="expiration-date" selected='<%= orderByColumn1.equals("expirationDate") %>' value="expirationDate" />
					<aui:option label="priority" selected='<%= orderByColumn1.equals("priority") %>'><liferay-ui:message key="priority" /></aui:option>
					<aui:option label="view-count" selected='<%= orderByColumn1.equals("viewCount") %>' value="viewCount" />
					<aui:option label="ratings" selected='<%= orderByColumn1.equals("ratings") %>'><liferay-ui:message key="ratings" /></aui:option>
				</aui:select>

				<aui:select inlineField="<%= true %>" label="" name="preferences--orderByType1--">
					<aui:option label="ascending" selected='<%= orderByType1.equals("ASC") %>' value="ASC" />
					<aui:option label="descending" selected='<%= orderByType1.equals("DESC") %>' value="DESC" />
				</aui:select>
			</span>

			<span class="aui-field-row">
				<aui:select inlineField="<%= true %>" inlineLabel="left" label="and-then-by" name="preferences--orderByColumn2--">
					<aui:option label="title" selected='<%= orderByColumn2.equals("title") %>' />
					<aui:option label="create-date" selected='<%= orderByColumn2.equals("createDate") %>' value="createDate" />
					<aui:option label="modified-date" selected='<%= orderByColumn2.equals("modifiedDate") %>' value="modifiedDate" />
					<aui:option label="publish-date" selected='<%= orderByColumn2.equals("publishDate") %>' value="publishDate" />
					<aui:option label="expiration-date" selected='<%= orderByColumn2.equals("expirationDate") %>' value="expirationDate" />
					<aui:option label="priority" selected='<%= orderByColumn2.equals("priority") %>'><liferay-ui:message key="priority" /></aui:option>
					<aui:option label="view-count" selected='<%= orderByColumn2.equals("viewCount") %>' value="viewCount" />
				</aui:select>

				<aui:select inlineField="<%= true %>" label="" name="preferences--orderByType2--">
					<aui:option label="ascending" selected='<%= orderByType2.equals("ASC") %>' value="ASC" />
					<aui:option label="descending" selected='<%= orderByType2.equals("DESC") %>' value="DESC" />
				</aui:select>
			</span>
		</aui:fieldset>
	</liferay-ui:panel>

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="recentBlogSelectionDisplaySettingsPanel" persistState="<%= true %>" title="display-settings">
		<aui:fieldset cssClass="general-display-settings">
			<aui:select cssClass="hidden-field asset-link-behavior" name="preferences--assetLinkBehavior--">
				<aui:option label="show-full-content" selected='<%= assetLinkBehavior.equals("showFullContent") %>' value="showFullContent" />
				<aui:option label="view-in-a-specific-portlet" selected='<%= assetLinkBehavior.equals("viewInPortlet") %>' value="viewInPortlet" />
			</aui:select>

			<aui:select label="maximum-items-to-display" name="preferences--delta--">

				<%
				int[] deltas = {1, 2, 3, 4, 5, 10, 15, 20, 25, 30, 40, 50, 60, 70, 80, 90, 100};

				for (int currentDelta: deltas) {
				%>

					<aui:option label="<%= currentDelta %>" selected="<%= (delta == currentDelta) %>" />

				<%
				}
				%>

			</aui:select>
		</aui:fieldset>
	</liferay-ui:panel>

	<aui:button-row>
		<aui:button type="submit" value="save" />
	</aui:button-row>
</aui:form>