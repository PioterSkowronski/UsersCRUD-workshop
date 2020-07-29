<%--
  Created by IntelliJ IDEA.
  User: pioter
  Date: 24.07.2020
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
    <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników </a>
</div>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Dodaj użytkownika</h6>
        <div class="card-body">
            <div class="table-responsive">
            </div>
        </div>

    <form method="POST">
        <br/>
        Nazwa:
        <br/>
        <input type="text" name="userName">
        <br/>
        Email:
        <br/>
        <input type="text" name="eMail">
        <br/>
        Hasło:
        <br/>
        <input type="text" name="password">
        <br/>
        <button type="submit">
            <a " class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Zapisz </a>
        </button>




    </form>

</div>

<%@ include file="/footer.jsp" %>
