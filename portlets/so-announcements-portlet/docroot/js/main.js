AUI().use(
	'aui-base',
	'transition',
	function(A) {
		Liferay.namespace('Announcements');

		Liferay.Announcements = {
			appendPageStart: function(url, id) {
				var node = A.one(id);

				if (node) {
					var start = node.attr('data-start');

					url = url + '&start=' + start;
				}

				return(url);
			},

			appendTogglerState: function(url) {
				var header = A.one('#readEntries .header');

				if (header) {
					var expanded = 'false';

					if (header.hasClass('aui-toggler-header-expanded')) {
						expanded = 'true';
					}

					url = url + '&expanded=' + expanded;
				}

				return(url);
			},

			loadNode: function(node, uri) {
				if (node) {
					if (!node.io) {
						node.plug(
							A.Plugin.IO,
							{
							autoLoad: false
							}
						);
					}

					node.io.set('uri', uri);
					node.io.start();
				}
			},

			toggleEntry: function(event, portletNamespace) {
				var entryId = event.currentTarget.attr('data-entryId');

				var entry = A.one('#' + portletNamespace + entryId);

				var content = entry.one('.entry-content');
				var contentContainer = entry.one('.entry-content-container');
				var control = entry.one('.toggle-entry');

				var contentHeight = '75px';

				if (entry.hasClass('announcement-collapsed')) {
					entry.removeClass('announcement-collapsed');

					contentContainer.setStyle('height', '75px');
					contentContainer.setStyle('maxHeight', 'none');

					contentHeight = content.getComputedStyle('height');

					if (control) {
						control.html(Liferay.Language.get('view-less'));
					}
				}
				else {
					entry.addClass('announcement-collapsed');

					if (control) {
						control.html(Liferay.Language.get('view-more'));
					}
				}

				contentContainer.transition(
					{
						duration: 0.5,
						easing: 'ease-in-out',
						height: contentHeight
					}
				);
			}
		};
	}
);