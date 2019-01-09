<!DOCTYPE HTML>
<html>
<head>
    <title>job系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="job"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>

    <!-- Bootstrap Core CSS -->
    <link href="/static/css/bootstrap.css" rel='stylesheet' type='text/css'/>

    <!-- Custom CSS -->
    <link href="/static/css/style.css" rel='stylesheet' type='text/css'/>

    <!-- font-awesome icons CSS -->
    <link href="/static/css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome icons CSS-->

    <!-- side nav css file -->
    <link href='/static/css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>
    <!-- //side nav css file -->


    <!--webfonts-->
    <link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext"
          rel="stylesheet">
    <!--//webfonts-->


    <link href="/static/css/custom.css" rel="stylesheet">

</head>
<body class="cbp-spmenu-push">
<div class="main-content">
    <div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
        <!--left-fixed -navigation-->
        <aside class="sidebar-left">
            <nav class="navbar navbar-inverse">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".collapse"
                            aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <h1><a class="navbar-brand" href="javascript:switchMenu('register');"><span
                            class="fa fa-area-chart"></span> Glance<span
                            class="dashboard_text">Design dashboard</span></a></h1>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="sidebar-menu">
                        <li class="header">导航栏</li>
                        <li class="treeview">
                            <a href="/">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <#assign menu_parent_code =0/>
                        <#list response['menus'] as parent>
                            <#if parent_index != 0 && menu_parent_code == 0>
                                <#assign menu_parent_code =0/>
                                </li>
                            </#if>
                            <#if parent['parentCode']?number == 0>
                                <#assign menu_parent_code = parent['menuCode']?number/>
                                <li class="treeview">
                                    <a href="javascript:switchMenu('${parent['menuUrl']}');">
                                        <i class="fa fa-laptop"></i>
                                        <span>${parent['menuName']}</span>
                                        <i id="hasSubMenu_${menu_parent_code}" class="fa fa-angle-left pull-right"></i>
                                    </a>
                                <#assign menuIndex = 0/>
                                <#list response['menus'] as child>
                                    <#if child['parentCode']?number != 0 && child['parentCode'] ==  parent['menuCode']>
                                        <#if menuIndex == 0>
                                            <ul class="treeview-menu">
                                        </#if>

                                        <li><a href="javascript:switchMenu('${child['menuUrl']}');"><i class="fa fa-angle-right"></i> ${child['menuName']}</a></li>
                                        <#assign menuIndex = menuIndex + 1/>
                                    </#if>
                                </#list>
                                <#if menuIndex != 0>
                                    </ul>
                                <#else>
                                    <script type="text/javascript">
                                        document.getElementById("hasSubMenu_${menu_parent_code}").style.display="none";
                                    </script>
                                </#if>
                            </#if>
                        </#list>

                        <li class="header">LABELS</li>
                        <li><a href="#"><i class="fa fa-angle-right text-red"></i> <span>Important</span></a></li>
                        <li><a href="#"><i class="fa fa-angle-right text-yellow"></i> <span>Warning</span></a></li>
                        <li><a href="#"><i class="fa fa-angle-right text-aqua"></i> <span>Information</span></a></li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>
        </aside>
    </div>

    <header class="sticky-header header-section " style="background-color: white">
        <div class="header-left">
            <!--toggle button start-->
            <button id="showLeftPush"><i class="fa fa-bars"></i></button>
            <!--toggle button end-->
            <div class="profile_details_left"><!--notifications of menu start -->
                <ul class="nofitications-dropdown">
                    <li class="dropdown head-dpdn">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
                                class="fa fa-envelope"></i><span class="badge">4</span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="notification_header">
                                    <h3>You have 3 new messages</h3>
                                </div>
                            </li>
                            <li><a href="#">
                                <div class="user_img"><img src="/static/img/1.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor amet</p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>
                            </a></li>
                            <li class="odd"><a href="#">
                                <div class="user_img"><img src="/static/img/4.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor amet </p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>
                            </a></li>
                            <li><a href="#">
                                <div class="user_img"><img src="/static/img/3.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor amet </p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>
                            </a></li>
                            <li><a href="#">
                                <div class="user_img"><img src="/static/img/2.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor amet </p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>
                            </a></li>
                            <li>
                                <div class="notification_bottom">
                                    <a href="#">See all messages</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown head-dpdn">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
                                class="fa fa-bell"></i><span class="badge blue">4</span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="notification_header">
                                    <h3>You have 3 new notification</h3>
                                </div>
                            </li>
                            <li><a href="#">
                                <div class="user_img"><img src="/static/img/4.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor amet</p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>
                            </a></li>
                            <li class="odd"><a href="#">
                                <div class="user_img"><img src="/static/img/1.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor amet </p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>
                            </a></li>
                            <li><a href="#">
                                <div class="user_img"><img src="/static/img/3.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor amet </p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>
                            </a></li>
                            <li><a href="#">
                                <div class="user_img"><img src="/static/img/2.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor amet </p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>
                            </a></li>
                            <li>
                                <div class="notification_bottom">
                                    <a href="#">See all notifications</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown head-dpdn">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
                                class="fa fa-tasks"></i><span class="badge blue1">8</span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="notification_header">
                                    <h3>You have 8 pending task</h3>
                                </div>
                            </li>
                            <li><a href="#">
                                <div class="task-info">
                                    <span class="task-desc">Database update</span><span
                                        class="percentage">40%</span>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="progress progress-striped active">
                                    <div class="bar yellow" style="width:40%;"></div>
                                </div>
                            </a></li>
                            <li><a href="#">
                                <div class="task-info">
                                    <span class="task-desc">Dashboard done</span><span class="percentage">90%</span>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="progress progress-striped active">
                                    <div class="bar green" style="width:90%;"></div>
                                </div>
                            </a></li>
                            <li><a href="#">
                                <div class="task-info">
                                    <span class="task-desc">Mobile App</span><span class="percentage">33%</span>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="progress progress-striped active">
                                    <div class="bar red" style="width: 33%;"></div>
                                </div>
                            </a></li>
                            <li><a href="#">
                                <div class="task-info">
                                    <span class="task-desc">Issues fixed</span><span class="percentage">80%</span>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="progress progress-striped active">
                                    <div class="bar  blue" style="width: 80%;"></div>
                                </div>
                            </a></li>
                            <li>
                                <div class="notification_bottom">
                                    <a href="#">See all pending tasks</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <!--notification menu end -->
            <div class="clearfix"></div>
        </div>
        <div class="header-right">


            <!--search-box-->
            <div class="search-box">
                <form class="input">
                    <input class="sb-search-input input__field--madoka" placeholder="Search..." type="search"
                           id="input-31"/>
                    <label class="input__label" for="input-31">
                        <svg class="graphic" width="100%" height="100%" viewBox="0 0 404 77"
                             preserveAspectRatio="none">
                            <path d="m  0,0l404,0l0,77l-404,0l0,-77z"/>
                        </svg>
                    </label>
                </form>
            </div><!--//end-search-box-->

            <div class="profile_details">
                <ul>
                    <li class="dropdown profile_details_drop">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                            <div class="profile_img">
                                <span class="prfil-img"><img src="/static/img/2.jpg" alt=""> </span>
                                <div class="user-name">
                                    <p>${response['user']['realName']!'admin'}</p>
                                    <span>Administrator</span>
                                </div>
                                <i class="fa fa-angle-down lnr"></i>
                                <i class="fa fa-angle-up lnr"></i>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                        <ul class="dropdown-menu drp-mnu">
                            <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                            <li><a href="#"><i class="fa fa-user"></i> My Account</a></li>
                            <li><a href="#"><i class="fa fa-suitcase"></i> Profile</a></li>
                            <li><a href="#"><i class="fa fa-sign-out"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </header>
    <#-- main content -->
    <div id="page-wrapper">
        <div id="main_content" class="main-page">
            <iframe id="content" align="center" style="padding: 0px; width: 100%; height: 100%;" src=""
                    frameborder="no"></iframe>
        </div>
    </div>
    <!--footer-->
    <div class="footer">
        <p>&copy; 2019 Glance Design Dashboard. All Rights Reserved | Design by <a href="#"
                                                                                   target="_blank">yolo</a></p>
    </div>
    <!--//footer-->
</div>

<script src="webjars/jquery/3.3.1/jquery.js"></script>
<script src="/static/js/modernizr.custom.js"></script>

<!-- Metis Menu -->
<script src="/static/js/metisMenu.min.js"></script>
<script src="/static/js/custom.js"></script>

<!-- Classie --><!-- for toggle left push menu script -->
<script src="/static/js/classie.js"></script>
<script>
    var menuLeft = document.getElementById('cbp-spmenu-s1'),
            showLeftPush = document.getElementById('showLeftPush'),
            body = document.body;

    showLeftPush.onclick = function () {
        classie.toggle(this, 'active');
        classie.toggle(body, 'cbp-spmenu-push-toright');
        classie.toggle(menuLeft, 'cbp-spmenu-open');
        disableOther('showLeftPush');
    };


    function disableOther(button) {
        if (button !== 'showLeftPush') {
            classie.toggle(showLeftPush, 'disabled');
        }
    }
</script>
<!-- //Classie --><!-- //for toggle left push menu script -->

<!--scrolling js-->
<script src="/static/js/jquery.nicescroll.js"></script>
<script src="/static/js/scripts.js"></script>
<!--//scrolling js-->

<!-- side nav js -->
<script src='/static/js/SidebarNav.min.js' type='text/javascript'></script>
<script>
    $('.sidebar-menu').SidebarNav();

    function switchMenu(url) {
        $("#content").attr("src", url);
    }

</script>
<!-- //side nav js -->

<!-- Bootstrap Core JavaScript -->
<script src="/static/js/bootstrap.js"></script>
<!-- //Bootstrap Core JavaScript -->

</body>
</html>