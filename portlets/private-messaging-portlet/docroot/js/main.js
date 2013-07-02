AUI.add(
	'liferay-plugin-privatemessaging',
	function(A) {
		Liferay.PrivateMessaging = {
			init: function(params) {
				var instance = this;

				instance.namespace = params.namespace;

				instance.checkAll = A.one('#' + instance.namespace + 'checkAll');
				instance.userThreadsSearchContainer = A.one('#' + instance.namespace + 'userThreadsSearchContainer');

				instance.privateMessagingContainer = A.one('#p_p_id' + params.namespace + ' .private-messaging-container');

				if (instance.privateMessagingContainer) {
					instance._assignEvents();
				}
			},

			_assignEvents: function() {
				var instance = this;

				instance.privateMessagingContainer.delegate(
					'click',
					function(event) {
						var checkBox = event.target;

						var  privateMessages = instance.privateMessagingContainer.all('input[type=checkbox]');

						privateMessages.set('checked', checkBox.get('checked'));
					},
					'.check-all'
				);

				instance.privateMessagingContainer.delegate(
					'click',
					function(event) {
						var checkBox = event.target;

						Liferay.Util.updateCheckboxValue(checkBox);

						Liferay.Util.checkAllBox(
							instance.userThreadsSearchContainer,
							instance.namespace + 'mbThreadCheckbox',
							instance.checkAll
						);
					},
					'.results-row input[type=checkbox]'
				);
			}
		};
	},
	'',
	{
		requires: ['aui-base']
	}
);