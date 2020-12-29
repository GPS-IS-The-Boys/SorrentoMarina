<%@ page import="theboys.sorrentomarina.managers.TableTuristaManager" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="theboys.sorrentomarina.models.Turista" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="sm" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    TableTuristaManager tableTuristaManager = new TableTuristaManager((DataSource) request.getServletContext().getAttribute("db"));
    Turista t1 = tableTuristaManager.retriveById(14);
    System.out.println(t1);
    List<Turista> list = tableTuristaManager.retriveAll();
    request.setAttribute("lista", list);
%>

<sm:layout title="Benvenuto" admin="false">
    <h1>
        Hello Sorrento Marina
        <br> Gerardo Iuliano
        Luigi Maiorano

        <c:forEach var="item" items="${lista}">
            <h1> ${item.nome} </h1>
        </c:forEach>
    </h1>
</sm:layout>