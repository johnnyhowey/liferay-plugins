AUI().use(
	'aui-base',
	'aui-io-plugin-deprecated',
	function(A) {
		Liferay.namespace('Notifications');

		Liferay.Notifications = {
			dismissNotifications: function(event, markAllAsRead, fullviewUri, dockbarUri) {
				event.preventDefault();

				var dismissNotifications = A.one('.dismiss-notifications');

				var dockbarUserNotifications = A.one('.dockbar-user-notifications');
				var dockbarUserNotificationsCount = dockbarUserNotifications.one('.user-notifications-count');
				var dockbarUserNotificationsList = dockbarUserNotifications.one('.dropdown-menu');

				var loadingRow = A.Node.create('<div class="loading-animation"></div>');

				var row;

				var sidebarUserNotifications = A.one('.user-notifications-sidebar');

				var userNotificationsList = A.one('.user-notifications-list-container .user-notifications-list');

				var refreshNotificationsResult = function(notificationsList, uri) {
					if (notificationsList) {
						if (!notificationsList.io) {
							notificationsList.plug(
								A.Plugin.IO,
								{
									autoLoad: false
								}
							);
						}

						notificationsList.io.set('uri', uri);
						notificationsList.io.start();
					}
				}

				var updateNotificationsCount = function(newUserNotificationsCount, unreadUserNotificationsCount) {
					if (dockbarUserNotifications) {
						if (dockbarUserNotificationsCount) {
							dockbarUserNotificationsCount.toggleClass('alert', (newUserNotificationsCount > 0));

							dockbarUserNotificationsCount.setHTML(unreadUserNotificationsCount);
						}
					}

					if (sidebarUserNotifications) {
						var sidebarUnreadCount = sidebarUserNotifications.one('.count');

						if (sidebarUnreadCount) {
							sidebarUnreadCount.setHTML(unreadUserNotificationsCount);
						}
					}
				};

				if (!markAllAsRead) {
					row = event.currentTarget.ancestor('.user-notification');
					row.hide().placeAfter(loadingRow);
				}

				A.io.request(
					event.currentTarget.attr('href'),
					{
						on: {
							success: function(event) {
								var response = this.get('responseData');

								if (response.success) {
									updateNotificationsCount(response["newUserNotificationsCount"], response["unreadUserNotificationsCount"]);

									if (!markAllAsRead) {
										loadingRow.remove();
										row.remove();
									}

									if (fullviewUri) {
										refreshNotificationsResult(userNotificationsList, fullviewUri);
									}

									if (dockbarUri) {
										refreshNotificationsResult(dockbarUserNotificationsList, dockbarUri);
									}
								}
							}
						},
						dataType: 'json'
					}
				);
			},

			viewNotification: function(event) {
				var instance = this;

				var currentTarget = event.currentTarget;

				var openDialog = currentTarget.attr('data-openDialog');

				var uri = currentTarget.attr('data-href');

				if (uri) {
					var markAsReadURL = currentTarget.attr('data-markAsReadURL');

					if (markAsReadURL) {
						A.io.request(
							markAsReadURL,
							{
								after: {
									success: function(event, id, obj) {
										var responseData = this.get('responseData');

										if (responseData.success) {
											var userNotification = currentTarget.ancestor('.user-notification');

											if (userNotification) {
												userNotification.removeClass('unread');

												var read = userNotification.one('.content .read');

												if (read) {
													read.setHTML(Liferay.Language.get('read'));
												}

												instance._redirect(uri, openDialog);
											}
										}
									}
								},
								dataType: 'json'
							}
						);
					}
					else {
						var userNotification = currentTarget.ancestor('.user-notification');

						if (userNotification) {
							instance._redirect(uri, openDialog);
						}
					}
				}
			},

			_redirect: function(uri, openDialog) {
				if (openDialog === "false") {
					var topWindow = Liferay.Util.getTop();

					topWindow.location.href = uri;
				}
				else {
					Liferay.Util.openWindow(
						{
							id: 'notificationsWindow',
							uri: uri
						}
					);
				}
			}
		};
	}
);