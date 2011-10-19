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
	float: left;
	width: 30%;

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

	.clear {
		clear: both;
	}

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

	.my-contacts {
		.lfr-contact-grid-item {
			display: block;
			height: 35px;
			overflow: hidden;
			padding: 5px;
			white-space: nowrap;

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
	}

	.contacts-home {
		padding: 5px;
	}

	.contacts-center-home h3.header-title{
		margin: 0px;
	}

	.contacts-profile {
		padding: 10px;
	}

	.lfr-contact-grid-item {
		display: block;
		white-space: nowrap;

		.lfr-contact-thumb {
			float: left;
		}

		.lfr-contact-thumb img {
			width: 80px;
		}

		.lfr-contact-info {
			font-size: 1.4em;
			margin-left: 85px;

			&.no-icon {
				margin-left: 0;
			}

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

	.contacts-action-content {
		font-size: 1em;
		margin-bottom: 5px;
		padding: 5px 0;

		span {
			padding:0 5px 0 0;
		}
	}

	.lfr-user-info-container {
		min-height: 10px;
		margin-bottom: 10px;
	}

	.section {
		border-bottom: 1px solid #CCC;
	}

	.section h3 {
		color: #888;
		float: left;
		font-size: 1em;
		margin-top: 0;
		text-align: right;
		width: 100px;
	}

	.section ul {
		margin-left: 105px;
	}

	.property-type {
		font-weight: bold;
	}

	.user-information-title {
		color: #E96825;
		font-size: 18px;
		font-weight: bold;
		text-align: right;
		width: 110px;
	}

	.lfr-user-comments {
		float: none;
		width: 100%;
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

.contacts-portlet .lfr-user-action-confirm a {
	background: url(<%= themeImagesPath %>/common/activate.png) no-repeat;
}

.contacts-portlet .lfr-user-action-ignore a {
	background: url(<%= themeImagesPath %>/common/deactivate.png) no-repeat;
}

.contacts-portlet .lfr-asset-metadata .lfr-asset-coworker {
	background: url(<%= themeImagesPath %>/social/coworker.png) no-repeat;
	padding: 0 20px
}

.contacts-portlet .lfr-asset-metadata .lfr-asset-follower {
	background: url(<%= themeImagesPath %>/social/follower.png) no-repeat;
	padding: 0 20px
}

.contacts-portlet .lfr-asset-metadata .lfr-asset-following {
	background: url(<%= themeImagesPath %>/social/following.png) no-repeat;
	padding: 0 20px
}

.contacts-portlet .property-list li {
	list-style: none;
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
}

.contacts-portlet .lfr-panel{
	margin-bottom: 1em;
}

.contacts-portlet .taglib-header {
	margin-bottom: 1em;
}

.contacts-portlet .lfr-search-container {
	margin-top: 1em;
}