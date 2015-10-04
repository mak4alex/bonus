<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" 
                    data-toggle="collapse" data-target="#navbar" 
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Souvenir Store</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">  
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" 
                       data-toggle="dropdown" role="button" 
                       aria-haspopup="true" aria-expanded="false">Producer <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="${pageContext.request.contextPath}/producer/create">Add new Producer</a></li>
                      <li><a href="${pageContext.request.contextPath}/producer">List Producers</a></li>              
                      <li role="separator" class="divider"></li>                  
                      <li><a href="${pageContext.request.contextPath}/producer/search">Search Producers</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" 
                       data-toggle="dropdown" role="button" 
                       aria-haspopup="true" aria-expanded="false">Souvenir <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="${pageContext.request.contextPath}/souvenir/create">Add new Souvenir</a></li>
                      <li><a href="${pageContext.request.contextPath}/souvenir">List Souvenir</a></li>              
                      <li role="separator" class="divider"></li>                  
                      <li><a href="${pageContext.request.contextPath}/souvenir/search">Search Souvenirs</a></li>
                    </ul>
                </li>              
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>