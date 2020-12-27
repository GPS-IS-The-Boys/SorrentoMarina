<%@ page import="theboys.sorrentomarina.managers.TableTuristaManager" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="theboys.sorrentomarina.models.Turista" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="theboys.sorrentomarina.managers.TablePrenotazioneManager" %>
<%@ page import="theboys.sorrentomarina.models.Lido" %>
<%@taglib prefix="sm" tagdir = "/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    TablePrenotazioneManager t = new TablePrenotazioneManager((DataSource) request.getServletContext().getAttribute("db"));
    System.out.println("Posti disponibili= "+t.ombrelloniDisponibili("2020-06-08","2020-06-22",new Lido(1,"nome","indirizzo","34897808","email","",18,4,4,1)));


%>

<sm:layout  title="Benvenuto" admin="false">
    <h1>
        Hello Sorrento Marina
        <br> Gerardo Iuliano
        Luigi Maiorano

        <c:forEach var="item" items="${lista}" >
            <h1> ${item.nome} </h1>
        </c:forEach>
    </h1>
</sm:layout>