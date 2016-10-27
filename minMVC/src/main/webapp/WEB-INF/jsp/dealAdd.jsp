<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/> 
<title>Insert title here</title>
</head>
<body>

    <h1> index request is success!!</h1>

   <%
       request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
     %>
      <%--  <%  
        String strURL = request.getParameter("first");  
        String strRequest = (String)request.getAttribute("strRequest");  
        String strSession = (String)request.getSession().getAttribute("strSession");  
          
        %>  
        <p>  
            URL中取得的属性值为：<%=strURL%>  
        </p>        
        <p>  
            request中取得的属性值为：<%=strRequest%>  
        </p>  
        <p>  
            session中取得的属性值为：<%=strSession%>  
        </p>   --%>

   <%=(String)request.getAttribute("ok")%>  

</body>
</html>