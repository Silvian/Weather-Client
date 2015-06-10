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

  	<nav class="top-bar" data-topbar role="navigation">
	  <section class="top-bar-section">
		<!-- Left Nav Section -->
		<ul class="left">
		  <li class="active">
			<a href="weather">Weather Client</a>
		  </li>
		</ul>
		<ul class="left">
		  <li>
			<a href="contacts">Contacts</a>
		  </li>
		</ul>
	  </section>
	</nav>

    <div class="row">
	 <div class="large-12 columns">
	   </br>
	   <h1>Welcome to Weather Client</h1>
	   </br>
	 </div>
   	</div>

    <div class="row">
	  <div class="large-12 columns">
		  <h5>${city}</h5>
		   <hr/>
	  </div>
	</div>

	<div class="row">
	  <div class="large-12 columns">
		<div class="panel">

		<table id="weather-results">
		  <thead>
			<tr>
			  <th width="200">Date</th>
			  <th width="350">Description</th>
			  <th width="150">Temperature Lowest</th>
			  <th width="150">Temperature Highest</th>
			</tr>
		  </thead>
		  <tbody>

		  	<c:forEach items="${weatherDataModelList}" var="weatherDataModel">
			  <tr>
                <td>${weatherDataModel.date}</td>
                <td>${weatherDataModel.description}</td>
                <td>${weatherDataModel.lowTemp}</td>
                <td>${weatherDataModel.highTemp}</td>
                </tr>
            </c:forEach>

		  </tbody>
		</table>

		</div>
	  </div>
	</div>

    <div class="row">

    <hr />

	  <h5>US city zip code:</h5>
	  <form method="GET" id="zip-form" name="zip-form" action="get-weather-data" enctype="multipart/form-data">
		<div class="row">
		  <div class="large-6 medium-6 columns">
			<input id="zip-code" name="zip-code" value="" type="text" placeholder="Enter a US city zip code" required pattern="[0-9]+"/>
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