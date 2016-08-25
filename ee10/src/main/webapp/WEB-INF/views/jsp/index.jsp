<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 30.07.2016
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Restaurant. Now: ${currentTime} </h1>
<h2>Для приложения ресторан добавить REST API, который будет позволять: </h2>
<a href="/menu"> - Получить список всех меню (только названия меню без блюд в них)</a>
<br>
<a href="/menu/12"> - По ID получить меню со списком блюд в этом меню</a>
<br>
<a href="/menu/name/Salads"> - Найти меню по имени</a>
<br>
<a href="/orders"> - Получить список всех заказов</a>
<br>
<a href="/orders/open"> - Получить список только открытых заказов</a>
<br>
<a href="/orders/closed"> - Получить список только закрытых заказов </a>
<br>
<a href="/orders/2"> - Получить заказ по ID</a>
<br>
<a href="/employee"> - Получить список всех сотрудников (только имена и фамилии)</a>
<br>
<a href="/employee/57"> - Получить сотрудника по ID </a>
<br>
<a href="/employee/name/Andre,"> - Найти сотрудника/сотрудников по имени</a>
<br>
<a href="/employee/name/,Sidorov"> - Найти сотрудника/сотрудников по фамилии</a>
<br>
<a href="/employee/name/Iron,Felix"> - Найти сотрудника/сотрудников по имени и фамилии</a>
<br>


</body>
</html>
