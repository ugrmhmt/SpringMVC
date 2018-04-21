<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
<%@ include file="../master/header.jsp" %>
<title>Kullanýcý Ekleme </title>
   <style>
      .error {
         color: #ff0000;
      }

      .errorblock {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
      }
   </style>
</head>
<body>
	<%@ include file="../master/nav.jsp" %>
    <div class="container">
      <div class="row">
         <%@ include file="../master/leftmenu.jsp" %>
        <div class="col-md-8">
        <div class="card mb-4">
            <div class="card-body">
              <h2 class="card-title">Kullanýcý Ýþlemleri</h2>
           		 <form:form modelAttribute="kullanici" action="add" method="POST">
					<form:errors path = "*" cssClass = "alert alert-danger" element = "div" />
					<div class="row">
					 <div class="col-md-6">
						  <div class="form-group">
						    <label for="exampleInputEmail1">Kullanýcý Adý</label>
						    <form:input type="hidden" path="id" class="form-control"></form:input>	
						    <form:input type="text" path="ad" class="form-control"></form:input>				    
						  </div>
						  <div class="form-group">
						    <label for="exampleInputEmail1">Kullanýcý Soyadý</label>
						    <form:input type="text" path="soyad" class="form-control"></form:input>				    
						  </div>
						  <div class="form-group">
						    <label for="exampleInputEmail1">Email</label>
						    <form:input type="text" path="email" class="form-control"></form:input>				    
						  </div>
					  </div>
					 </div>
					  <button type="submit" class="btn btn-primary">Kaydet</button>
				  </form:form> 
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->

    </div>
<%@ include file="../master/footer.jsp" %>
