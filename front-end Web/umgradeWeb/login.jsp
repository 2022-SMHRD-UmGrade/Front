<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Basic Page Info -->
	<meta charset="utf-8">
	<title>로그인</title>

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
	<link rel="stylesheet" type="text/css" href="vendors/styles/style.css">

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag(){dataLayer.push(arguments);}
		gtag('js', new Date());

		gtag('config', 'UA-119386393-1');
	</script>
</head>
<body class="login-page">
	<div class="login-header box-shadow">
		<div class="container-fluid d-flex justify-content-between align-items-center">
			<div class="brand-logo">
				<a href="login.jsp">
					<img src="vendors/images/logo2.png" alt="">
				</a>
			</div>
			<div class="login-menu">
			</div>
		</div>
	</div>
	<div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-6 col-lg-5">
					<img src="vendors/images/umbrellaimg.png" alt="">
				</div>
				<div class="col-md-6 col-lg-7">
					<div class="login-box bg-white box-shadow border-radius-10">
						<div class="login-title text-center">
							<img src="vendors/images/login.png">
						</div>
						<form>
							<div class="input-group custom int-area">
								<input type="text" name="id" id="id" autocomplete="off" required>
								<label for="id">USER NAME</label>
								<div class="input-group-append custom">
									<span class="input-group-text"><i class="icon-copy dw dw-user1"></i></span>
								</div>
							</div>
							<div class="input-group custom int-area">
								<input type="password" name="pw" id="pw" autocomplete="off" required>
								<label for="pw">PASSWORD</label>
								<div class="input-group-append custom">
									<span class="input-group-text"><i class="dw dw-padlock1"></i></span>
								</div>
							</div>
							<div class="row pb-30">
								<div class="col-6">
									<div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input" id="customCheck1" data-color="#A3CBE6">
										<label class="custom-control-label" for="customCheck1" data-color="#999">Remember</label>
									</div>
								</div>
								<div class="col-6">
									<div class="forgot-password"><a href="" data-color="#999">Forgot Password?</a></div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="input-group mb-0">
										<input class="btn-area" type="submit" value="LOGIN" id="btn">
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- js -->
	<script src="vendors/scripts/core.js"></script>
	<script src="vendors/scripts/script.min.js"></script>
	<script src="vendors/scripts/process.js"></script>
	<script src="vendors/scripts/layout-settings.js"></script>
	<script>
        let id = document.querySelector('#id')
        let pw = document.querySelector('#pw')
        let btn = document.querySelector('#btn')
        btn.addEventListener('click', () => {
            if(id.value == "") {
                label = id.nextElementSibling
                label.classList.add('warning')
                setTimeout(() => {
                    label.classList.remove('warning')
                }, 1500)
            } else if(pw.value == "") {
                label = pw.nextElementSibling
                label.classList.add('warning')
                setTimeout(() => {
                    label.classList.remove('warning')
                }, 1500)
            }
        })
    </script>
</body>
</html>