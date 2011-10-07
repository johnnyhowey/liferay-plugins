AUI().add(
	'liferay-contacts-result',
	function(A) {
		var ContactsResult = A.Base.create(
			'contactsResult',
			A.Base,
			[A.AutoCompleteBase],
			{
				initializer: function(config) {
					this._listNode = A.one(config.listNode);

					this._bindUIACBase();
					this._syncUIACBase();
				}
			}
		);

		Liferay.namespace('Contacts');

		Liferay.ContactsResult = ContactsResult;
	},
	'',
	{
		requires: ['aui-base', 'autocomplete-base']
	}
);

AUI().use(
	'aui-base',
	'aui-dialog',
	'aui-io-plugin',
	'datasource-io',
	'json-parse',
	'liferay-contacts-result',
	function(A) {
		Liferay.namespace('Contacts');

		Liferay.Contacts = {
			init: function(config) {
				var instance = this;

				console.log("creating list");

				console.log(config);

				instance._createContactList(config);

				console.log("list created");
			},

			createDataSource: function(url) {
				return new A.DataSource.IO(
					{
						ioConfig: {
							method: "post"
						},
						on: {
							request: function(event) {
								var contactFilterContainer = A.one('.contacts-portlet .contact-group-filter');

								var socialRelationType = 0;

								if (contactFilterContainer) {
									socialRelationType = contactFilterContainer.one('select').get('value');
								}

								var data = event.request;

								event.cfg.data = {
									end: data.end || 0,
									keywords: data.keywords || '',
									socialRelationType: data.socialRelationType || socialRelationType,
									start: data.start || 0,
								}
							}
						},
						source: url
					}
				)
			},

			updateContacts: function() {
				var instance = this;

				if (instance._contactList) {
					instance._contactList.sendRequest();
				}
			},

			_createContactList: function(config) {
				var instance = this;

				var contactsResultContainer = config.contactsResultContainer;

				var contactsResult = config.contactsResult;
				var contactsResultURL = config.contactsResultURL;
				var contactsSearchInput = config.contactsSearchInput;

				var contactsResult = new Liferay.ContactsResult(
					{
						requestTemplate: function(query) {
							return {
								keywords: query
							}
						},

						inputNode: contactsSearchInput,
						listNode: contactsResult,
						minQueryLength: 0,
						source: instance.createDataSource(contactsResultURL)
					}
				);

				contactsResult.on('results', instance._updateContactsResult);

				instance._contactList = contactsResult;
			},

			_updateContactsResult: function(event) {
				var instance = this;

				console.log('reading response');
				console.log(event.data.responseText);

				var data = A.JSON.parse(event.data.responseText);

				var results = data.users;
				var count = data.count;

				var buffer = [];

				console.log(results);

				if (results.length == 0) {
					buffer.push(
						'<div class="empty">' + Liferay.Language.get('there-are-no-results') + '</div>'
					);
				}
				else {
					var userTemplate =
						'<div class="lfr-contact-grid-item" data-user-url="{viewSummaryURL}">' +
							'<div class="lfr-contact-thumb">' +
								'<img alt="{userFullName}" src="{userPortraitURL}" />' +
							'</div>' +
							'<div class="lfr-contact-info">' +
								'<div class="lfr-contact-name">' +
									'<a>{userFullName}</a>' +
								'</div>' +
								'<div class="lfr-contact-job-title">' +
									'{jobTitle}' +
								'</div>' +
								'<div class="lfr-contact-extra">' +
									'{emailAddress}' +
								'</div>' +
							'</div>' +
							'<div class="clear"></div>' +
						'</div>';

					buffer.push(
						A.Array.map(
							results,
							function(result) {
								return A.Lang.sub(
									userTemplate,
									{
										emailAddress: (result.emailAddress ? result.emailAddress : ''),
										jobTitle: (result.jobTitle ? result.jobTitle : ''),
										userFullName: (result.userFullName ? result.userFullName : ''),
										userPortraitURL: (result.userPortraitURL ? result.userPortraitURL : ''),
										viewSummaryURL: (result.viewSummaryURL ? result.viewSummaryURL : '')
									}
								);
							}
						).join('')
					);

					if (count > results.length) {
						buffer.push(
							'<li class="more">' +
								'<a href="javascript:;">' + Liferay.Language.get('view-all') + ' (' + count + ')' + '</a>' +
							'</li>'
						);
					}
				}

				instance._listNode.html(buffer.join(''));
			}
		};
	}
);