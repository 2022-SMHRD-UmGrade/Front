<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Basic Page Info -->
	<meta charset="utf-8">
	<title>우산조회</title>

	<!-- Site favicon -->
	<link rel="apple-touch-icon" sizes="180x180" href="vendors/images/umbrella180x180.png">
	<link rel="icon" type="image/png" sizes="32x32" href="vendors/images/umbrella32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="vendors/images/umbrella16x16.png">

	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="vendors/styles/core.css">
	<link rel="stylesheet" type="text/css" href="vendors/styles/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="src/plugins/datatables/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" type="text/css" href="src/plugins/datatables/css/responsive.bootstrap4.min.css">
	<link rel="stylesheet" type="text/css" href="src/plugins/sweetalert2/sweetalert2.css">
	<link rel="stylesheet" type="text/css" href="vendors/styles/style.css">

	<style>
		.datatable-nosort::after, .datatable-nosort::before {
			content: unset !important;
		}
	</style>
</head>
<body>
	<!-- Header Start -->
	<div class="header">
		<div class="header-left">
			<div class="menu-icon dw dw-menu"></div>
			<div class="search-toggle-icon dw dw-search2" data-toggle="header_search"></div>
			<div class="header-search">
				<form>
					<div class="form-group mb-0">
						<i class="dw dw-search2 search-icon"></i>
						<input type="text" class="form-control search-input" placeholder="Search Here">
						<div class="dropdown">
							<a class="dropdown-toggle no-arrow" href="#" role="button" data-toggle="dropdown">
								<i class="ion-arrow-down-c"></i>
							</a>
							<div class="dropdown-menu dropdown-menu-right">
								<div class="form-group row">
									<label class="col-sm-12 col-md-2 col-form-label">From</label>
									<div class="col-sm-12 col-md-10">
										<input class="form-control form-control-sm form-control-line" type="text">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-12 col-md-2 col-form-label">To</label>
									<div class="col-sm-12 col-md-10">
										<input class="form-control form-control-sm form-control-line" type="text">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-12 col-md-2 col-form-label">Subject</label>
									<div class="col-sm-12 col-md-10">
										<input class="form-control form-control-sm form-control-line" type="text">
									</div>
								</div>
								<div class="text-right">
									<button class="btn btn-primary">Search</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="header-right">
			<div class="dashboard-setting user-notification">
				<div class="dropdown">
					<a class="dropdown-toggle no-arrow" href="javascript:;" data-toggle="right-sidebar">
						<i class="dw dw-settings2"></i>
					</a>
				</div>
			</div>
			<div class="user-notification">
				<div class="dropdown">
					<a class="dropdown-toggle no-arrow" href="#" role="button" data-toggle="dropdown">
						<i class="icon-copy dw dw-notification"></i>
						<span class="badge notification-active"></span>
					</a>
					<div class="dropdown-menu dropdown-menu-right">
						<div class="notification-list mx-h-350 customscroll">
							<ul>
								<li>
									<a href="#" class="alert alert-dismissible fade show" role="alert">
										<img src="vendors/images/kuromi1.jpg" alt="">
										<h3>💜</h3>
										<p>빛을 잃어가는 마음과는 달리</p>
										<p>채워지는 도시의 별은 하나둘씩 늘어가고</p>
										<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</a>
								</li>
								<li>
									<a href="#" class="alert alert-dismissible fade show" role="alert">
										<img src="vendors/images/kuromi2.jpg" alt="">
										<h3>💜</h3>
										<p>자리를 찾아가는 퍼즐처럼</p>
										<p>맞춰지는 세상 속을 벗어나고만 싶어</p>
										<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</a>
								</li>
								<li>
									<a href="#" class="alert alert-dismissible fade show" role="alert">
										<img src="vendors/images/kuromi3.jpg" alt="">
										<h3>💜</h3>
										<p>날 향한 시선에 감추기만 했던</p>
										<p>마음의 목소리를 소리 내 외치면</p>	
										<p>스치는 바람을 따라 더없이 가벼워진 마음은</p>	
										<p>내 안의 나를 깨우게 해</p>
										<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>	
									</a>
								</li>
								<li>
									<a href="#" class="alert alert-dismissible fade show" role="alert">
										<img src="vendors/images/kuromi4.jpg" alt="">
										<h3>💜</h3>
										<p>잿빛 세상을 등지고 이 도시를 달려봐</p>
										<p>내 맘 가는 대로 가로질러 가볼래 날 위해</p>	
										<p>그곳이 어디든 날개를 펼치고 I'm flying</p>	
										<p>저 쏟아지듯 펼쳐진 길 위로</p>	
										<p>내 모든 걸 던져</p>
										<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>	
									</a>
								</li>
								<li>
									<a href="#" class="alert alert-dismissible fade show" role="alert">
										<img src="vendors/images/kuromi5.jpg" alt="">
										<h3>💜</h3>
										<p>Run run run higher, fly fly fly higher</p>
										<p>I, I find myself 다시 빛나는 나를 봐</p>
										<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>	
									</a>
								</li>
								<li>
									<a href="#" class="alert alert-dismissible fade show" role="alert">
										<img src="vendors/images/sanrio.jpg" alt="">
										<h3>💜</h3>
										<p>Run run run higher, fly fly fly fly higher</p>
										<p>이 어둠 속 눈을 감고</p>	
										<p>다시 꿈을 꿔</p>
										<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>	
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="user-info-dropdown">
				<div class="dropdown">
					<a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown">
						<span class="user-icon">
							<img src="vendors/images/kuromi3.jpg" alt="">
						</span>
						<span class="user-name">쿠로미💜</span>
					</a>
					<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
						<a class="dropdown-item" href="profile.jsp"><i class="dw dw-user1"></i> Profile</a>
						<a class="dropdown-item" href="faq.jsp"><i class="dw dw-help"></i> Help</a>
						<a class="dropdown-item" href="login.jsp"><i class="dw dw-logout"></i> Log Out</a>
					</div>
				</div>
			</div>
			<div class="github-link">
				<a href="https://github.com/2022-SMHRD-UmGrade" target="_blank"><img src="vendors/images/github.svg" alt=""></a>
			</div>
		</div>
	</div>

	<!-- layouts settings -->
	<div class="right-sidebar">
		<div class="sidebar-title">
			<h3 class="weight-600 font-16 text-blue">
				Layout Settings
				<span class="btn-block font-weight-400 font-12">User Interface Settings</span>
			</h3>
			<div class="close-sidebar" data-toggle="right-sidebar-close">
				<i class="icon-copy ion-close-round"></i>
			</div>
		</div>
		<div class="right-sidebar-body customscroll">
			<div class="right-sidebar-body-content">
				<h4 class="weight-600 font-18 pb-10">Header Background</h4>
				<div class="sidebar-btn-group pb-30 mb-10">
					<a href="javascript:void(0);" class="btn btn-outline-primary header-white active">Light</a>
					<a href="javascript:void(0);" class="btn btn-outline-primary header-dark">Dark</a>
				</div>

				<h4 class="weight-600 font-18 pb-10">Sidebar Background</h4>
				<div class="sidebar-btn-group pb-30 mb-10">
					<a href="javascript:void(0);" class="btn btn-outline-primary sidebar-light active">Light</a>
					<a href="javascript:void(0);" class="btn btn-outline-primary sidebar-dark">Dark</a>
				</div>

				<h4 class="weight-600 font-18 pb-10">Background Color</h4>
				<div class="sidebar-btn-group pb-30 mb-10">
					<a href="javascript:void(0);" class="btn btn-outline-primary bgcolor-light active ">Light</a>
					<a href="javascript:void(0);" class="btn btn-outline-primary bgcolor-dark">Dark</a>
				</div>

				<h4 class="weight-600 font-18 pb-10">Menu Dropdown Icon</h4>
				<div class="sidebar-radio-group pb-10 mb-10">
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="sidebaricon-1" name="menu-dropdown-icon" class="custom-control-input" value="icon-style-1" checked="">
						<label class="custom-control-label" for="sidebaricon-1"><i class="fa fa-angle-down"></i></label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="sidebaricon-2" name="menu-dropdown-icon" class="custom-control-input" value="icon-style-2">
						<label class="custom-control-label" for="sidebaricon-2"><i class="ion-plus-round"></i></label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="sidebaricon-3" name="menu-dropdown-icon" class="custom-control-input" value="icon-style-3">
						<label class="custom-control-label" for="sidebaricon-3"><i class="fa fa-angle-double-right"></i></label>
					</div>
				</div>

				<h4 class="weight-600 font-18 pb-10">Menu List Icon</h4>
				<div class="sidebar-radio-group pb-30 mb-10">
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="sidebariconlist-1" name="menu-list-icon" class="custom-control-input" value="icon-list-style-1" checked="">
						<label class="custom-control-label" for="sidebariconlist-1"><i class="ion-minus-round"></i></label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="sidebariconlist-2" name="menu-list-icon" class="custom-control-input" value="icon-list-style-2">
						<label class="custom-control-label" for="sidebariconlist-2"><i class="fa fa-circle-o" aria-hidden="true"></i></label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="sidebariconlist-3" name="menu-list-icon" class="custom-control-input" value="icon-list-style-3">
						<label class="custom-control-label" for="sidebariconlist-3"><i class="dw dw-check"></i></label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="sidebariconlist-4" name="menu-list-icon" class="custom-control-input" value="icon-list-style-4" checked="">
						<label class="custom-control-label" for="sidebariconlist-4"><i class="icon-copy dw dw-next-2"></i></label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="sidebariconlist-5" name="menu-list-icon" class="custom-control-input" value="icon-list-style-5">
						<label class="custom-control-label" for="sidebariconlist-5"><i class="dw dw-fast-forward-1"></i></label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="sidebariconlist-6" name="menu-list-icon" class="custom-control-input" value="icon-list-style-6">
						<label class="custom-control-label" for="sidebariconlist-6"><i class="dw dw-next"></i></label>
					</div>
				</div>

				<div class="reset-options pt-30 text-center">
					<button class="btn btn-danger" id="reset-settings">Reset Settings</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End -->


	<!-- Sidebar Start -->
	<div class="left-side-bar">
		<div class="brand-logo">
			<a href="home.jsp">
				<img src="vendors/images/logo2.png" alt="" class="dark-logo">
				<img src="vendors/images/logo1.png" alt="" class="light-logo">
			</a>
			<div class="close-sidebar" data-toggle="left-sidebar-close">
				<i class="ion-close-round"></i>
			</div>
		</div>
		<div class="menu-block customscroll">
			<div class="sidebar-menu">
				<ul id="accordion-menu">
					<li class="dropdown">
						<a href="home.jsp" class="dropdown-toggle no-arrow">
							<span class="micon dw dw-house-1"></span><span class="mtext">Home</span>
						</a>
					</li>
					<li class="dropdown">
						<a href="javascript:;" class="dropdown-toggle">
							<span class="micon dw dw-user"></span><span class="mtext">회원관리</span>
						</a>
						<ul class="submenu">
							<li><a href="userTable.jsp">회원조회</a></li>
							<li><a href="managerRegister.jsp">관리자등록</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="javascript:;" class="dropdown-toggle">
							<span class="micon dw dw-umbrella"></span><span class="mtext">우산관리</span>
						</a>
						<ul class="submenu">
							<li><a href="umTable.jsp">우산조회</a></li>
						</ul>
					</li>
					<li>
					<li class="dropdown">
						<a href="javascript:;" class="dropdown-toggle">
							<span class="micon dw dw-box-1"></span><span class="mtext">보관함관리</span>
						</a>
						<ul class="submenu">
							<li><a href="umBoxTable.jsp">보관함조회</a></li>
						</ul>
					</li>
					<li>
						<a href="qna.jsp" class="dropdown-toggle no-arrow">
							<span class="micon dw dw dw-question-1"></span><span class="mtext">질의응답</span>
						</a>
					</li>
					<li>
						<a href="calendar.jsp" class="dropdown-toggle no-arrow">
							<span class="micon dw dw-calendar1"></span><span class="mtext">달력</span>
						</a>
					</li>
					<li>
						<div class="dropdown-divider"></div>
					</li>
					<li>
						<div class="sidebar-small-cap">Extra</div>
					</li>
					<li>
						<a href="javascript:;" class="dropdown-toggle">
							<span class="micon dw dw-edit-2"></span><span class="mtext">Documentation</span>
						</a>
						<ul class="submenu">
							<li><a href="introduction.html">Introduction</a></li>
							<li><a href="getting-started.html">Getting Started</a></li>
							<li><a href="color-settings.html">Color Settings</a></li>
							<li><a href="third-party-plugins.html">Third Party Plugins</a></li>
						</ul>
					</li>
					<!-- 서비스 메인 페이지로 이동 -->
					
					<li>
						<a href="#" target="_blank" class="dropdown-toggle no-arrow">
							<span class="icon-copy dw dw-umbrella"></span>
							<span class="mtext">UM Grade <span class="icon-copy dw dw-umbrella"></span></span>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="mobile-menu-overlay"></div>
	<!-- Sidebar End -->

	<div class="main-container">
		<div class="pd-ltr-20 xs-pd-20-10">
			<div class="min-height-200px">
				<div class="page-header">
					<div class="row">
						<div class="col-md-6 col-sm-12">
							<div class="title">
								<h4>우산조회</h4>
							</div>
							<nav aria-label="breadcrumb" role="navigation">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="#">우산관리</a></li>
									<li class="breadcrumb-item active" aria-current="page">우산조회</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
				
				<!-- Export Datatable start -->
				<div class="card-box mb-30">
					<div class="pd-20">
						<h4 data-color="#A3CBE6">우산조회</h4>
					</div>
					<div class="col-sm-12 text-right">
						<a href="task-add" data-toggle="modal" data-target="#task-add" class="bg-light-blue btn text-blue weight-500"><i class="ion-plus-round"></i> Add</a>
						<button class="bg-light-red btn text-red-50 weight-500"><i class="icon-copy ion-trash-b">Delete</i></button>
					</div>
					<div class="pb-20">
						<table class="table stripe hover data-table-export-checkbox nowrap text-center">
							<thead>
								<tr>
									<th><div class="dt-checkbox">
										<input type="checkbox" name="select_all" value="1" id="example-select-all">
										<span class="dt-checkbox-label"></span>
									</div>
									</th>
									<th class="table-plus">순번</th>
									<th>RFID</th>
									<th>종류</th>
									<th>상태</th>
									<th>파손여부</th>
									<th>보관함위치</th>
									<th class="datatable-nosort">Action</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td></td>
									<td class="table-plus">1</td>
									<td>225.04.50.70</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손안됨</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item" id="sa-warning2"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">2</td>
									<td>125.04.55.70</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손안됨</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">3</td>
									<td>205.01.50.45</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">4</td>
									<td>205.14.00.70</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손안됨</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">5</td>
									<td>225.04.30.70</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손안됨</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">6</td>
									<td>245.04.50.70</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">7</td>
									<td>223.04.50.70</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">8</td>
									<td>235.04.50.70</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손안됨</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">9</td>
									<td>25.04.50.70</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손안됨</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">10</td>
									<td>265.04.56.70</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">11</td>
									<td>125.04.50.79</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손안됨</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td class="table-plus">12</td>
									<td>225.04.50.74</td>
									<td>일반우산</td>
									<td>상태</td>
									<td>파손안됨</td>
									<td>1</td>
									<td>
										<div class="dropdown">
											<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
												<i class="dw dw-more"></i>
											</a>
											<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
												<a class="dropdown-item" href="umDetails.jsp"><i class="dw dw-eye"></i>상세보기</a>
												<button class="dropdown-item"><i class="dw dw-delete-3"></i>삭제</button>
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- add task popup start 우산추가 -->
				<div class="modal fade customscroll" id="task-add" tabindex="-1" role="dialog">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLongTitle">우산추가</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Close Modal">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body pd-0">
								<div class="task-list-form">
									<ul>
										<li>
											<form>
												<div class="form-group row">
													<label class="col-md-4">우산종류</label>
													<div class="col-md-8">
														<select class="selectpicker form-control" data-style="btn-outline-primary" data-selected-text-format="count" data-count-selected-text= "{0} people selected">
															<option>일반우산</option>
															<option>어린이우산</option>
															<option>우양산</option>
														</select>
													</div>
												</div>
												<div class="form-group row mb-0">
													<label class="col-md-4">RFID</label>
													<div class="col-md-8">
														<input type="text" class="form-control">
													</div>
												</div>
											</form>
										</li>										
									</ul>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="sa-success2">Add</button>
								<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				<!-- add task popup End -->
			</div>
			<div class="footer-wrap pd-20 mb-20 card-box">
				지능형 IoT융합 SW전문가과정 실전프로젝트 <a href="https://github.com/2022-SMHRD-UmGrade" target="_blank">UmGrade</a>
			</div>
		</div>
	</div>
	<!-- js -->
	<script src="vendors/scripts/core.js"></script>
	<script src="vendors/scripts/script.min.js"></script>
	<script src="vendors/scripts/process.js"></script>
	<script src="vendors/scripts/layout-settings.js"></script>
	<script src="src/plugins/datatables/js/jquery.dataTables.min.js"></script>
	<script src="src/plugins/datatables/js/dataTables.bootstrap4.min.js"></script>
	<script src="src/plugins/datatables/js/dataTables.responsive.min.js"></script>
	<script src="src/plugins/datatables/js/responsive.bootstrap4.min.js"></script>
	<!-- buttons for Export datatable -->
	<script src="src/plugins/datatables/js/dataTables.buttons.min.js"></script>
	<script src="src/plugins/datatables/js/buttons.bootstrap4.min.js"></script>
	<script src="src/plugins/datatables/js/buttons.print.min.js"></script>
	<script src="src/plugins/datatables/js/buttons.html5.min.js"></script>
	<script src="src/plugins/datatables/js/buttons.flash.min.js"></script>
	<script src="src/plugins/datatables/js/pdfmake.min.js"></script>
	<script src="src/plugins/datatables/js/vfs_fonts.js"></script>
	<!-- Datatable Setting js -->
	<script src="vendors/scripts/datatable-setting.js"></script></body>
	<!-- add sweet alert js & css in footer -->
	<script src="src/plugins/sweetalert2/sweetalert2.all.js"></script>
	<script src="src/plugins/sweetalert2/sweet-alert.init.js"></script>
</html>