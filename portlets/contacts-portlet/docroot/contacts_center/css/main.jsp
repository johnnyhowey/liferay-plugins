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
<!--  -->
<%@ include file="/css_init.jsp" %>

.contacts-portlet .contact-group-filter  {
	font-size: 14px;
	padding: 5px 8px;

	select {
		height: 24px;
	}
}

.contacts-portlet .contacts-search {

	.contacts-search-content {
		height: 28px;
		padding: 5px 0;
		position: relative;

		.search-input {
			left: 5px;
			position: absolute;
			right: 5px;
		}
	}
}

.contacts-portlet {

	.aui-column-content, .aui-column-content-center {
		padding: 0;
	}

	.contacts-result {
		height: 500px;
		overflow-y: scroll;

		.lfr-contact-grid-item {
			cursor: pointer;
			display: block;
			height: 35px;
			overflow: hidden;
			padding: 5px;
			white-space: nowrap;

			.clear {
				clear: both;
			}

			.lfr-contact-thumb {
				float: left;
			}

			.lfr-contact-thumb img {
				width: 35px;
			}

			.lfr-contact-info {
				margin-left: 40px;
				font-size: 1em;

				.lfr-contact-name {
					font-weight: bold;
				}

				.lfr-contact-extra {
					color: #777;
				}
			}
		}

		.lfr-contact-grid-item:hover {
			background-color: #E8EFF4;
		}

		.more-results {
			background-color: #E8EFF4;
			border: 1px solid #CCC;
			margin: 5px;
			padding: 2px;
			text-align: center;
		}


		.empty {
			background: url(<%= themeImagesPath %>/messages/alert.png) no-repeat 0 50%;
			margin: 5px;
			padding-left: 25px;
		}

		.lastNameAnchor {
			background: #E8EFF4;
			border-top: 1px solid #CCC;
			border-bottom: 1px solid #CCC;
			margin-bottom: 5px;
		}

		.lastNameAnchor a {
			font-weight: bold;
			margin: 0 5px;
		}
	}

	.contacts-home {
		padding: 5px;
	}

	.contacts-summary {
		padding: 10px;

		.lfr-contact-grid-item {
			display: block;
			white-space: nowrap;

			.clear {
				clear: both;
			}

			.lfr-contact-thumb {
				float: left;
			}

			.lfr-contact-thumb img {
				width: 80px;
			}

			.lfr-contact-info {
				font-size: 1.4em;
				margin-left: 85px;


				.lfr-contact-name {
					font-size: 1.2em;
					font-weight: bold;
				}

				.lfr-contact-extra {
					color: #777;
				}
			}
		}

		.lfr-asset-metadata {
			margin-bottom: 5px;
		}

		.contact-action-content {
			background-color: #E8EFF4;
			font-size: 1em;
			margin-bottom: 5px;
			padding: 5px 0;

			span {
				padding:0 5px 0 0;
			}
		}
	}

	.contacts-center-home {
		padding: 10px;

		.contacts-count {
			font-weight: bold;
			margin: 5px 0;
		}

		.contacts-center-introduction {
			margin: 5px 0;
		}
	}

}





.lfr-user-profile-preferences {
	margin-left: 20px;
}

.contacts-portlet .export-group {
	margin-top: 1em;
}

.contacts-portlet .lfr-user-grid {
	list-style: none;
	margin: 0;
}

.contacts-portlet .lfr-user-grid-item {
	display: inline-block;
	height: 50px;
	margin: 0 5px 5px 0;
	position: relative;
	width: 50px;
}

.contacts-portlet .lfr-user-grid-item.hover {
	z-index: 99;
}

.contacts-portlet .lfr-user-grid-item .lfr-user-thumb {
	background: #C8C9CA;
	border: 1px solid #C8C9CA;
	height: 50px;
	width: 50px;
}

.contacts-portlet .lfr-user-grid-item a {
	clip: rect(0 50px 50px 0);
	position: absolute;
}

.contacts-portlet .lfr-user-grid-item img {
	position: relative;
	width: 50px;
}

.contacts-portlet .lfr-user-grid-item.hover img {
	z-index: 100;
}

.contacts-portlet .lfr-user-grid-item .lfr-user-info {
	background: #D7F1FF;
	border: 1px solid #88C5D9;
	display: none;
	left: -5px;
	min-height: 50px;
	padding: 5px 5px 5px 60px;
	position: absolute;
	top: -5px;
	width: 175px;
}

.ie .contacts-portlet .lfr-user-grid-item .lfr-user-info {
	height: 50px;
}

.contacts-portlet .lfr-user-grid-item.hover .lfr-user-info {
	display: block;
}

.contacts-portlet .lfr-user-portrait {
	float: left;
	height: 50px;
	margin: 0 .5em .5em 0;
	overflow: hidden;
}

.contacts-portlet .lfr-user-portrait img {
	width: 50px;
}

.contacts-portlet .lfr-user-action,
.contacts-portlet .lfr-user-data {
	margin-left: 60px;
}

.contacts-portlet .lfr-user-data-name,
.contacts-portlet .lfr-user-data-title {
	font-size: 1.2em;
}

.contacts-portlet .lfr-user-data-job-title,
.contacts-portlet .lfr-user-data-title a {
	font-weight: bold;
}

.contacts-portlet .lfr-user-data-extra {
	color: #777;
}

.contacts-portlet .lfr-user-action-item a {
	padding: 0 10px 0 20px ;
}

.contacts-portlet .lfr-user-action-confirm a {
	background: url(<%= themeImagesPath %>/common/activate.png) no-repeat;
}

.contacts-portlet .lfr-user-action-ignore a {
	background: url(<%= themeImagesPath %>/common/deactivate.png) no-repeat;
}

.contacts-portlet .lfr-asset-metadata .lfr-asset-coworker {
	background: url(<%= themeImagesPath %>/social/coworker.png) no-repeat;
}

.contacts-portlet .lfr-asset-metadata .lfr-asset-follower {
	background: url(<%= themeImagesPath %>/social/follower.png) no-repeat;
}

.contacts-portlet .lfr-asset-metadata .lfr-asset-following {
	background: url(<%= themeImagesPath %>/social/following.png) no-repeat;
}

.contacts-portlet .lfr-asset-data .lfr-user-data-name {
	color: #777;
	font-size: 1.5em;
	font-weight: bold;
}

.contacts-portlet .section {
	float: left;
	margin: 0 1em 1em 0;
	width: 45%;
}

.contacts-portlet .lfr-user-comments {
	float: none;
	width: 100%;
}

.contacts-portlet .section h3 {
	color: #555;
	background: no-repeat 2px 50%;
	border-bottom: 1px dotted #CCC;
	font-size: 1em;
	margin-top: 0;
	padding: 2px 0 2px 25px;
}

.contacts-portlet .lfr-user-phones h3 {
	background-image: url(<%= themeImagesPath %>/common/telephone.png);
}

.contacts-portlet .lfr-user-email-addresses h3 {
	background-image: url(<%= themeImagesPath %>/mail/unread.png);
}

.contacts-portlet .lfr-user-instant-messenger h3 {
	background-image: url(<%= themeImagesPath %>/common/conversation.png);
}

.contacts-portlet .lfr-user-addresses h3 {
	background-image: url(<%= themeImagesPath %>/dock/home.png);
}

.contacts-portlet .lfr-user-websites h3 {
	background-image: url(<%= themeImagesPath %>/common/history.png);
}

.contacts-portlet .lfr-user-social-network h3 {
	background-image: url(<%= themeImagesPath %>/common/group.png);
}

.contacts-portlet .lfr-user-sms h3 {
	background-image: url(<%= themeImagesPath %>/common/telephone_mobile.png);
}

.contacts-portlet .lfr-user-comments h3 {
	background-image: url(<%= themeImagesPath %>/dock/welcome_message.png);
}

.contacts-portlet .property-list li {
	list-style: none;
	margin-bottom: 1em;
}

.contacts-portlet .property-list dt {
	clear: left;
	font-weight: bold;
	min-width: 5em;
}

.contacts-portlet .property-list dt,
.contacts-portlet .property-list dd {
	float: left;
	line-height: 1.5;
	margin: 0;
}

.contacts-portlet .property-list dd {
	padding-left: 1em;
}

.contacts-portlet .filter-input {
	margin-bottom: 1em;
}

.contacts-portlet .members-container {
	clear: both;
	margin: 1em 0;
}

.contacts-portlet .lfr-members-grid-item {
	float: left;
	height: 50px;
	margin-bottom: 10px;
	max-width: 300px;
	min-width: 200px;
	overflow: hidden;
	width: 25%;
}

.contacts-portlet .lfr-members-grid-item .lfr-members-thumb {
	float: left;
	margin: 0 5px;
}

.contacts-portlet lfr-members-grid-item .lfr-members-thumb a {
	clip: rect(0 50px 50px 0);
	position: absolute;
}

.contacts-portlet .lfr-members-thumb img{
	width: 50px;
}

.contacts-portlet .lfr-members-grid-item .lfr-user-data-info {
	margin-left: 60px;
}

.contacts-portlet .lfr-members-grid-item .lfr-user-data-name {
	font-weight: bold;
}

.contacts-portlet .lfr-members-grid-item .lfr-user-data-name,
.contacts-portlet .lfr-members-grid-item .lfr-user-data-job-title,
.contacts-portlet .lfr-members-grid-item .lfr-user-data-extra {
	white-space: nowrap
}

.contacts-portlet .edit-profile {
	cursor: pointer;
}.contacts-portlet .lfr-panel{
	margin-bottom: 1em;
}

.contacts-portlet .taglib-header {
	margin-bottom: 1em;
}

.contacts-portlet .lfr-search-container {
	margin-top: 1em;
}