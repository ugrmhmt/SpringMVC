<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
<%@ include file="../master/header.jsp" %>
<title>Kullan�c� Listesi</title>
</head>
<body>
	<%@ include file="../master/nav.jsp" %>
    <div class="container">
      <div class="row">
         <%@ include file="../master/leftmenu.jsp" %>
        <div class="col-md-8">
        <div class="card mb-4">
            <div class="card-body">
              <h2 class="card-title">Kullan�c�lar</h2>
				<table class="table table-striped" id="katList">
				  <thead>
				    <tr>
				      <th scope="col">Ad�</th>
				      <th scope="col">Soyad�</th>
				      <th scope="col">Email</th>
				      <th scope="col">��lemler</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="temp" items="${kullanici}">
				  	<tr>
				  		<td>${temp.ad}</td>
				  		<td>${temp.soyad}</td>
				  		<td>${temp.email}</td>
				  		<td>
				  			<a href="${pageContext.request.contextPath}/kullanici/edit?id=${temp.id}" class="btn btn-info" role="button">D�zenleme</a> 
				  			<a href="${pageContext.request.contextPath}/kullanici/delete?id=${temp.id}" class="btn btn-danger" role="button">Silme</a>
				  		</td>
				  	</tr>
				  </c:forEach>
				  </tbody>
				</table>
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->

    </div>
<%@ include file="../master/footer.jsp" %>
