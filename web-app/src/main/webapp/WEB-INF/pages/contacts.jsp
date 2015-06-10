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
          <li>
            <a href="weather">Weather Client</a>
          </li>
        </ul>
        <ul class="left">
          <li class="active">
            <a href="contacts">Contacts</a>
          </li>
        </ul>
        </section>
    </nav>

    <div class="row">
	 <div class="large-12 columns">
	   </br>
	   <h1>Contacts</h1>
	   </br>
	 </div>
   	</div>

    <div class="row">
	  <div class="large-6 columns">

        <c:if test="${not empty response}">
          <c:if test="${isSuccessful}">
            <div data-alert class="alert-box success radius">
              ${response}
              <a href="#" class="close">&times;</a>
            </div>
          </c:if>
          <c:if test="${not isSuccessful}">
            <div data-alert class="alert-box alert radius">
              ${response}
              <a href="#" class="close">&times;</a>
            </div>
          </c:if>
        </c:if>

		<h5>Contact Devcon Demo:</h5>
        <hr/>

        <form method="GET" id="contacts-form" name="contacts-form" action="contacts-form-submit" enctype="multipart/form-data">
          <div class="row">
            <div class="large-12 medium-12 columns">
              <label>Name
                <input id="contacts-name" name="contacts-name" value="" type="text" placeholder="Enter your name" required />
              </label>
            </div>
            <div class="large-12 medium-12 columns">
              <label>Email Address
                <input id="contacts-email" name="contacts-email" value="" type="email" placeholder="Enter your email address" required />
              </label>
            </div>
            <div class="large-12 medium-12 columns">
              <label>Subject
              <input id="contacts-subject" name="contacts-subject" value="" type="text" placeholder="Enter subject line" required />
              </label>
            </div>

            <div class="large-12 medium-12 columns">
              <label>Message
                <textarea id="contacts-message" name="contacts-message" value="" type="text" placeholder="Enter your message" required></textarea>
              </label>
            </div>

            <div class="large-12 medium-12 columns">
              <input type="submit" value="Send" class="small button"/><br/>
            </div>
          </div>
        </form>

     </div>

    </div>

    <script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/foundation.min.js" />"></script>
    <script>
      $(document).foundation();
    </script>
  </body>
</html>