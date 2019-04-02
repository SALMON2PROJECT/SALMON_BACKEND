<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 11/2/2018
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
  <%--<head>--%>
    <%--<title>$Title$</title>--%>
  <%--</head>--%>
  <%--<body>--%>
  <%--<form action="/SalmonController_war_exploded/action/tag.do">--%>
   <%--&lt;%&ndash;<form action="action/tag.do">&ndash;%&gt;--%>
    <%--<input type="text" name="pdfCore" width="400">--%>
    <%--&lt;%&ndash;<input type="text" name="title">&ndash;%&gt;--%>
       <%--<p>SALMON BACKEND</p>--%>
    <%--<input type="submit" value="getText" >--%>
  <%--</form>--%>
  <%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>


<body>
<form action="http://localhost:8080/SalmonController_war_exploded/action/initialTags.do">
    <input type="text" name="pdfCore">
    <input type="text" name="title">
    <input type="text" name="tag1">
    <input type="text" name="tag2">
    <input type="submit">
</form>
<%--<form action="http://localhost:8080/SalmonController_war_exploded/action/getAnnotation.do">--%>
    <%--<input type="text" name="pdfCore">--%>
    <%--<input type="submit">--%>
<%--</form>--%>

<form action="http://localhost:8080/SalmonController_war_exploded/action/getCollections.do">
    <input type="submit" value="collection">
</form>
<form action="http://localhost:8080/SalmonController_war_exploded/action/">

</form>
<%--<%response.sendRedirect("//localhost:3000/");%>--%>
</body>
</html>
