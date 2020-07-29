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
        <h6 class="m-0 font-weight-bold text-primary">Edytuj użytkownika</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tbody>

                    <tr>
                        <form method="POST">
                            <br/>
                            Nazwa:
                            <br/>
                            <input type="text" name="userName" placeholder="Wpisz imie">
                            <br/>
                            Email:
                            <br/>
                            <input type="text" name="eMail" placeholder="Wpisz email">
                            <br/>
                            Hasło:
                            <br/>
                            <input type="password" name="password" placeholder="Podaj hasło">
                            <br/>
                            <input type="hidden" name="id" value="${user.id}"/>
                            <input type="submit" value="  Zapisz  ">



                        </form>
                    </tr>

                </tbody>
                </thead>
            </table>
        </div>
    </div>
</div>





    <%@ include file="/footer.jsp" %>
