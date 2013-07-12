<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

<%
String category = ParamUtil.getString(request, "category");

portletURL.setParameter("category", category);
%>

<div class="row">
	<div class="span3">
		<div class="alert-container"></div>

		<div class="category-nav well">
			<%@ include file="/app_manager/categories.jspf" %>
		</div>
	</div>

	<div class="apps span9">
		<h3>
			<c:choose>
				<c:when test="<%= Validator.isNull(category) %>">
					<liferay-ui:message key="all-apps" />
				</c:when>
				<c:otherwise>
					<%= category %>
				</c:otherwise>
			</c:choose>
		</h3>

		<%
		List<App> apps = null;

		if (Validator.isNotNull(category)) {
			apps = AppLocalServiceUtil.getApps(category);
		}
		else {
			apps = AppLocalServiceUtil.getInstalledApps();
		}

		for (App app : apps) {
			String[] contextNames = app.getContextNames();

			List<LayoutTemplate> layoutTemplates = new ArrayList<LayoutTemplate>();
			List<Portlet> portlets = new ArrayList<Portlet>();
			List<Theme> themes = new ArrayList<Theme>();

			for (String contextName : contextNames) {
				ServletContext servletContext = ServletContextPool.get(contextName);

				List<LayoutTemplate> servletContextLayoutTemplates = (List<LayoutTemplate>)servletContext.getAttribute(WebKeys.PLUGIN_LAYOUT_TEMPLATES);

				if (servletContextLayoutTemplates != null) {
					layoutTemplates.addAll(servletContextLayoutTemplates);

					Iterator<LayoutTemplate> itr = layoutTemplates.iterator();

					while (itr.hasNext()) {
						LayoutTemplate layoutTemplate = itr.next();

						if (layoutTemplate.isStandard()) {
							itr.remove();
						}
					}
				}

				List<Portlet> servletContextPortlets = (List<Portlet>)servletContext.getAttribute(WebKeys.PLUGIN_PORTLETS);

				if (servletContextPortlets != null) {
					portlets.addAll(servletContextPortlets);

					Iterator<Portlet> itr = portlets.iterator();

					while (itr.hasNext()) {
						Portlet portlet = itr.next();

						String curPortletId = portlet.getPortletId();

						if (curPortletId.equals(PortletKeys.PORTAL)) {
							itr.remove();
						}
						else if (portlet.isSystem()) {
							itr.remove();
						}
					}
				}

				List<Theme> servletContextThemes = (List<Theme>)servletContext.getAttribute(WebKeys.PLUGIN_THEMES);

				if (servletContextThemes != null) {
					themes.addAll(servletContextThemes);
				}
			}

			List plugins = new ArrayList(layoutTemplates.size() + portlets.size() + themes.size());

			plugins.addAll(layoutTemplates);
			plugins.addAll(portlets);
			plugins.addAll(themes);

			plugins = ListUtil.sort(plugins, new PluginComparator(application, locale));
		%>

			<div class="app">
				<div class="icon">
					<c:if test="<%= Validator.isNotNull(app.getIconURL()) %>">
						<img src="<%= app.getIconURL() %>" />
					</c:if>
				</div>

				<div class="info">
					<div class="title">
						<%= app.getTitle() %>
					</div>

					<div class="description">
						<%= app.getDescription() %>
					</div>

					<div class="plugins well">
						<c:choose>
							<c:when test="<%= !plugins.isEmpty() %>">
								<ul class="summary">
									<li class="switch">
										<i class="icon-chevron-right"></i>
									</li>

									<li>
										<liferay-ui:message key="this-app-contains" />
									</li>

									<c:if test="<%= !layoutTemplates.isEmpty() %>">
										<li>
											<%= layoutTemplates.size() %> <liferay-ui:message key='<%= layoutTemplates.size() == 1 ? "layout-template" : "layout-templates" %>' />
										</li>
									</c:if>

									<c:if test="<%= !portlets.isEmpty() %>">
										<li>
											<%= portlets.size() %> <liferay-ui:message key='<%= portlets.size() == 1 ? "portlet" : "portlets" %>' />
										</li>
									</c:if>

									<c:if test="<%= !themes.isEmpty() %>">
										<li>
											<%= themes.size() %> <liferay-ui:message key='<%= themes.size() == 1 ? "theme" : "themes" %>' />
										</li>
									</c:if>
								</ul>

								<div class="plugin-list">
									<%@ include file="/app_manager/plugins.jspf" %>
								</div>
							</c:when>
							<c:otherwise>
								<liferay-ui:message key="there-are-no-configurable-plugins-for-this-app" />
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<c:if test='<%= !ArrayUtil.contains(contextNames, PortalUtil.getPathContext()) && !ArrayUtil.contains(contextNames, "marketplace-portlet") %>'>
					<div class="app-actions">
						<liferay-ui:icon-menu>
							<liferay-portlet:actionURL name="updatePluginSettings" var="activateURL">
								<portlet:param name="contextNames" value="<%= StringUtil.merge(app.getContextNames()) %>" />
								<portlet:param name="active" value="<%= String.valueOf(true) %>" />
							</liferay-portlet:actionURL>

							<liferay-ui:icon
								image="activate"
								url="<%= activateURL %>"
							/>

							<liferay-portlet:actionURL name="updatePluginSettings" var="deactivateURL">
								<portlet:param name="contextNames" value="<%= StringUtil.merge(app.getContextNames()) %>" />
								<portlet:param name="active" value="<%= String.valueOf(false) %>" />
							</liferay-portlet:actionURL>

							<liferay-ui:icon
								image="deactivate"
								url="<%= deactivateURL %>"
							/>

							<liferay-portlet:actionURL name="uninstallApp" var="uninstallURL">
								<portlet:param name="remoteAppId" value="<%= String.valueOf(app.getRemoteAppId()) %>" />
								<portlet:param name="contextNames" value="<%= StringUtil.merge(app.getContextNames()) %>" />
								<portlet:param name="activate" value="<%= String.valueOf(false) %>" />
							</liferay-portlet:actionURL>

							<liferay-ui:icon-delete
								confirmation="are-you-sure-you-want-to-uninstall-this"
								message="uninstall"
								url="<%= uninstallURL %>"
							/>
						</liferay-ui:icon-menu>
					</div>
				</c:if>
			</div>

		<%
		}
		%>

	</div>
</div>

<aui:script use="anim,aui-base,aui-io,aui-url">
	var marketplacePortlet = A.one('.marketplace-portlet');

	marketplacePortlet.delegate(
		'click',
		function(event) {
			var targetNode = event.currentTarget;

			var pluginsContainer = targetNode.ancestor('.plugins');

			var pluginSwitch = pluginsContainer.one('.switch i');
			var pluginList = pluginsContainer.one('.plugin-list');

			if (pluginsContainer.hasClass('active')) {
				pluginsContainer.removeClass('active');

				pluginSwitch.setAttribute('class', 'icon-chevron-right');
			}
			else {
				pluginsContainer.addClass('active');

				pluginSwitch.setAttribute('class', 'icon-chevron-down');
			}
		},
		'ul.summary'
	);

	var showMessage = function(message) {
		marketplacePortlet.one('.alert-container').prepend(message);

		setTimeout(
			function() {
				new A.Anim(
					{
						node: message,
						on: {
							end: function() {
								var node = this.get('node');

								node.get('parentNode').removeChild(node);
							}
						},
						to: {
							opacity: 0
						}
					}
				).run();
			},
			2000
		);
	};

	marketplacePortlet.delegate(
		'click',
		function(event) {
			event.preventDefault();

			var actionButton = event.currentTarget;

			if (actionButton.hasClass('disabled')) {
				return;
			}

			actionButton.addClass('disabled');

			var url = new A.Url(actionButton.getAttribute('href'));

			if (actionButton.hasClass('activate')) {
				url.setParameter('<portlet:namespace />active', true);
			}
			else if (actionButton.hasClass('deactivate')) {
				url.setParameter('<portlet:namespace />active', false);
			}

			A.io.request(
				url.toString(),
				{
					after: {
						complete: function(event, id, obj) {
							actionButton.removeClass('disabled');
						}
					},
					method: 'post',
					on: {
						failure: function(event, id, obj) {
							showMessage(
								A.Node.create(
									'<div class="alert alert-error">' +
										'<i class="icon-minus-sign"></i> <liferay-ui:message key="an-unexpected-error-occurred" />' +
									'</div>'
								)
							);
						},
						success: function(event, id, obj) {
							if (actionButton.hasClass('activate')) {
								actionButton.setAttribute('class', 'btn btn-mini btn-success deactivate');

								actionButton.html('<liferay-ui:message key="active" />');
							}
							else if (actionButton.hasClass('deactivate')) {
								actionButton.setAttribute('class', 'btn btn-mini btn-danger activate');

								actionButton.html('<liferay-ui:message key="inactive" />');
							}

							showMessage(
								A.Node.create(
									'<div class="alert alert-success">' +
										'<i class="icon-ok"></i> <liferay-ui:message key="your-request-completed-successfully" />' +
									'</div>'
								)
							);
						}
					}
				}
			);
		},
		'.plugin-actions .btn'
	);
</aui:script>