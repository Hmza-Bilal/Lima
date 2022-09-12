<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <h1>Update Notes</h1>
</head>

<body>
    <form action="updateservlet" method="post">

    <%
    String title = request.getParameter("title");
    String descrip = request.getParameter("descrip");
    String id = request.getParameter("id");
    %>



        Title:   <input type="text" name="title"  value="<%=title %>" required ><br>
        Description:   <input type="text" name="descrip" value="<%=descrip %>" required ><br>
        <input type="hidden" name="id"  value="<%=id %>" required ><br>
     
        <input type="submit" value="Update">
    </form>

</body>

</html>