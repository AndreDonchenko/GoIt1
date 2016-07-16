<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>My Tasks</title>
</head>
<body>
<h1>My Tasks</h1>
<h2>My ToDo List</h2>

<%
    final String TASK_MARKER = "Task=";
    final String DEL_MARKER = "DelTask=";
    try {
        session.setAttribute ( TASK_MARKER + request.getParameter ( "task_name" ), request.getParameter ( "category_name" ) );
    } catch (Exception e) {
        throw new RuntimeException ( "Runtime" );
    }

    Enumeration<String> parameterNames = request.getParameterNames ();
    while (parameterNames.hasMoreElements ()) {
        String parameter = parameterNames.nextElement ();
        if (parameter.startsWith ( DEL_MARKER )) {
            session.removeAttribute ( parameter.substring ( DEL_MARKER.length (), parameter.length () ) );
        }
    }
%>

<form action="index.jsp" method="post">
    <table width="100%" border="1" align="center">
        <th>Name</th>
        <th>Category</th>
        <th>Completed</th>
        <%
            Enumeration<String> attributeNames = session.getAttributeNames ();
            if (attributeNames.hasMoreElements ()) {

                while (attributeNames.hasMoreElements ()) {
                    String attribute = attributeNames.nextElement ();
                    if (attribute.startsWith ( TASK_MARKER )) {
                        out.print ( "<tr>" );
                        String value = (String) session.getAttribute ( attribute );
                        out.write ( "<td>" + attribute.substring ( TASK_MARKER.length (), attribute.length () ) + "</td>" );
                        out.write ( "<td>" + value + "</td>" );
                        out.write ( "<td><input type=\"checkbox\" name=\"" + DEL_MARKER + attribute + "\"></td>" );
                        out.print ( "</tr>\n" );
                    }
                }
            }
        %>
    </table>

    <br/>

    <input type="submit" value="Remove completed tasks">
</form>

<h2>Add Task</h2>
<form action="index.jsp" method="post">
    <label for="task_name">Task Name:</label>
    <input type="text" name="task_name" id="task_name">
    <br>
    <br>
    <label for="category_name">Category Name:</label>
    <input type="text" name="category_name" id="category_name">
    <br>
    <br>
    <input type="submit" value="Add task">
</form>

</body>
</html>
