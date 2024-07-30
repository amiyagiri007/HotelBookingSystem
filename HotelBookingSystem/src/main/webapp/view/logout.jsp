<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.userdetails.User" %>

<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    boolean isLoggedIn = (auth != null && auth.isAuthenticated() && !(auth.getPrincipal() instanceof String));
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>

<%
    if (isLoggedIn) {
%>
    <!-- Show logout button if user is logged in -->
    <form id="logoutForm" action="/perform_logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Logout</button>
    </form>
<%
    } else {
%>
    <!-- Redirect to home page if user is not logged in -->
    <script>
        window.location.href = '/home';
    </script>
<%
    }
%>

</body>
</html>
