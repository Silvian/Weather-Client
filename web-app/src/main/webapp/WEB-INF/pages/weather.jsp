<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Weather | Client</title>
    <link href="<c:url value="/resources/css/foundation.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
  </head>
  <body>

    <div class="row">
      <div class="large-12 columns">
        <h1>Welcome to Weather Client</h1>
      </div>
    </div>

    <div class="row">
      <div class="large-12 columns">
      	<div class="panel">
	        <h3>We&rsquo;re stoked you want to try Foundation! </h3>
	        <p>To get going, this file (index.html) includes some basic styles you can modify, play around with, or totally destroy to get going.</p>
	        <p>Once you've exhausted the fun in this document, you should check out:</p>
	        <div class="row">
	        	<div class="large-4 medium-4 columns">
	    		<p><a href="http://foundation.zurb.com/docs">Foundation Documentation</a><br />Everything you need to know about using the framework.</p>
	    	</div>
	        	<div class="large-4 medium-4 columns">
	        		<p><a href="http://github.com/zurb/foundation">Foundation on Github</a><br />Latest code, issue reports, feature requests and more.</p>
	        	</div>
	        	<div class="large-4 medium-4 columns">
	        		<p><a href="http://twitter.com/foundationzurb">@foundationzurb</a><br />Ping us on Twitter if you have questions. If you build something with this we'd love to see it (and send you a totally boss sticker).</p>
	        	</div>
					</div>
      	</div>
      </div>
    </div>

    <div class="row">

		<hr />

		<h5>Enter a US city zip code:</h5>
		<form method="GET" id="zip-form" name="zip-form" action="get-weather-data" enctype="multipart/form-data">
		  <div class="row">
			<div class="large-6 medium-6 columns">
			  <input id="zip-code" name="zip-code" value="" type="text" placeholder="Enter city zip code" />
			</div>
			<div class="large-6 medium-6 columns">
				<input type="submit" value="Get Weather Data" class="small button"/><br/>
			</div>
		  </div>
		</form>
     </div>

    <script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/foundation.min.js" />"></script>
    <script>
      $(document).foundation();
    </script>
  </body>
</html>