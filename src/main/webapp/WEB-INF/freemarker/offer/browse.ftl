<html lang="en">
<head>
    <meta charset="utf-8">
    <title>View An Offer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="../../../twu/static/css/bootstrap.css" rel="stylesheet">
    <link href="../../../twu/static/css/swapper/swapper.css" rel="stylesheet">
    <link href="../../../twu/static/css/bootstrap-responsive.css" rel="stylesheet">

    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
</head>
<body>

<div class="container navbar-wrapper">

    <div class="navbar navbar-inverse">
        <div class="navbar-inner">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">FeedMyCat</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">Create Offer</a></li>
                    <li><a href="#contact">Browse Offer</a></li>
                    <li><a href="#contact">About</a></li>
                </ul>
                <ul class="nav pull-right">
                    <li><a href="#">Welcome, ${username}</a></li>
                </ul>
            </div>
        </div>
    </div>

</div>

<div id="myCarousel">
    <div class="carousel-inner header">
        <div class="active pos-1 header-image">
            <img src="../../../twu/static/img/DetailPage.jpg"/>
        </div>
    </div>
</div>

<div class="main-container">
    <div id="sidebar-left">
    </div>
    <div id="sidebar-right">
    </div>
    <div class="display-an-offer">
             <h1>Browse Offers</h1>
             <ol>
             <#assign i=0>
             <#list allOffers as offer>
                 <li><a href="viewAnOfferFromBrowse?offerId=${offer.getId()}" id="offer${i+1}">${offer.getTitle()}</a></li>
             </#list>
             </ol>
    </div>
    <div style="clear:both"></div>
    <footer>
        <div align="center">Copyright © 2012 ThoughtWorks Corporation, TWU-29, Swapper Team, All Rights Reserved</div>
    </footer>
</body>
</html>