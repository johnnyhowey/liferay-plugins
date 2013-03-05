AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/
	'event',

	function(A) {
		var body = A.getBody();
		var userBar = A.one('#user-bar');
		var toggleDockbar = userBar.one('#toggleDockbar');
		var user_menus = userBar.all('.has-menu .child-menu');

		var notificationButton = userBar.one('.user-notification-events-icon');
		var notifications = userBar.one('.user-notification-events');

		if (notificationButton) {
			notificationButton.on(
				'click',
				function (event) {
					event.preventDefault()
					event.stopPropagation();
					notifications.toggleClass('aui-overlaycontext-hidden');
				}
			);

			notifications.on(
				'click',
				function () {
					event.stopPropagation();
				}
			);
		}

		if (toggleDockbar) {
			toggleDockbar.on(
				'click',
				function(event) {
					body.toggleClass('show-dockbar');

					A.io.request(
						themeDisplay.getPathMain() + '/portal/session_click',
						{
							data: {
								'show-dockbar': body.hasClass('show-dockbar')
							},
							on: {
								success: function() {
									window.location = '';
								}
							}
						}
					);
				}
			);
		}

		// Site Search
		var dashboardNav = userBar.one('#dashboardNav');
		var searchInput = userBar.one('.search input');

		var sitesResultContainer = userBar.one('.so-portlet-sites .portlet-content');

		searchInput.attr('value', lang.defaultGoTo);

		searchInput.on('focus', function (event) {
			if (event.target.get('value') == lang.defaultGoTo) {
				event.target.attr('value', '');
			}

			if (!sitesResultContainer.hasClass('search-focus')) {
				sitesResultContainer.addClass('search-focus');

				dashboardNav.setStyle('position','static');
			}
		});

		sitesResultContainer.on('click', function(event){
			event.stopPropagation();
		});

		body.on(['click',], function(event) {
			if (sitesResultContainer.hasClass('search-focus')) {
				sitesResultContainer.removeClass('search-focus');
				dashboardNav.setStyle('position','relative');
			}

			if (searchInput.get('value') == '') {
				searchInput.attr('value', lang.defaultGoTo);
			}

			if (pageSearch.hasClass('focus')) {
				pageSearch.removeClass('focus');
			}

			if (!notifications.hasClass('aui-overlaycontext-hidden')) {
				notifications.addClass('aui-overlaycontext-hidden');
			}
		});

		var pageSearch = A.one('#page-search');

		if (pageSearch) {
			var keywords = pageSearch.one('input[name=_3_keywords]'),
				pageSearchForm = pageSearch.one('form'),
				searchHelpers = {
					a: pageSearch.one('select[name=_3_groupId]'),
					b: pageSearch.one('input[type=image]')
				},
				searchText = lang.search + '...';

			function addSearchText () {
				if (keywords.get('value') == '') {
					keywords.attr('value', searchText);
				} else if (keywords.get('value') == searchText) {
					keywords.attr('value', '');
				}
			};

			addSearchText();

			var s = A.Node.create('<div class="search-controls"></div>');

			s.append(searchHelpers.a);
			s.append(searchHelpers.b);

			pageSearchForm.append(s);

			pageSearch.on(
				'click',
				function(event) {
					event.stopPropagation();

					addSearchText();

					if (!pageSearch.hasClass('focus')) {
						pageSearch.addClass('focus');
					}
				}
			);

			keywords.on(
				'blur',
				function (event) {
					addSearchText();
				}
			);
		}

		var messageBoard = A.one('.portlet-message-boards');

		if (messageBoard) {
			var toggleEditControls = function (node) {
				node.each(
					function(n) {
						n.on(
							['mouseenter', 'mouseleave']
							, function(event) {
									var t = 10000;

								if (event.type == 'mouseenter') {
									n.addClass('controls-visible');

									setTimeout(
										function() {
											if (n.hasClass('controls-visible')) {
												n.removeClass('controls-visible');
											}
									}, t);
								} else if (event.type == 'mouseleave') {
									n.removeClass('controls-visible');
								}
							}
						);
					}
				);
			};

			var threads = messageBoard.all('.message-container');

			toggleEditControls(threads);
		}

		var memberButton = A.one('#memberButton');

		if (memberButton) {
			memberButton.on(
				'click',
				function(event) {
					event.preventDefault();

					A.io.request(
						event.target.get('href'),
						{
							method: 'POST',
							on: {
								success: function(event, id, obj) {
									window.location = '';
								}
							}
						}
					);
				}
			);
		}

	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);