<div class="jumbotron">
    <div class="container text-center">
      <h1>Welcome to our store!</h1>
      <p>Find the souvenir that you always dream to have.</p>     
    </div>
</div>
<div class="container text-center">
    <div class="row">
        <div class="col-sm-offset-2 col-sm-8">
            <h2 class="lead" >Find right things!</h2>
            <div class="btn-group btn-group-justified" role="group" aria-label="search-buttons">
                <a class="btn btn-info" href="${pageContext.request.contextPath}/producer/search">Search Producers</a>
                <a class="btn btn-info" href="${pageContext.request.contextPath}/souvenir/search">Search Souvernir</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-2 col-sm-4">
            <h2 class="lead" >Work with Producers</h2>
            <div class="btn-group btn-group-justified" role="group" aria-label="search-buttons">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/producer/create">Create Producer</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/producer">View Producers</a>
            </div>
        </div>
        <div class="col-sm-4">
            <h2 class="lead" >Work with Souvenirs</h2>
            <div class="btn-group btn-group-justified" role="group" aria-label="search-buttons">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/producer/create">Create Souvenir</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/souvenir">View Souvenirs</a>
            </div>
        </div>
    </div>     
</div>