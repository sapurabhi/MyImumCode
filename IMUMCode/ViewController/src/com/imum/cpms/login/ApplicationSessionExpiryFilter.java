package com.imum.cpms.login;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ApplicationSessionExpiryFilter implements Filter {
private FilterConfig _filterConfig = null;
public void init(FilterConfig filterConfig) throws ServletException {
_filterConfig = filterConfig;
}
public void destroy() {
_filterConfig = null;
}
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
String requestedSession = ((HttpServletRequest)request).getRequestedSessionId();
String currentWebSession = ((HttpServletRequest)request).getSession().getId();
String requestURI =   ((HttpServletRequest)request).getRequestURI();
boolean sessionOk = currentWebSession.equalsIgnoreCase(requestedSession);
// if the requested session is null then this is the first application
// request and "false" is acceptable
if (!sessionOk && requestedSession != null){
// the session has expired or renewed. Redirect request
  ((HttpServletResponse) response).sendRedirect(_filterConfig.getInitParameter("SessionTimeoutRedirect")); }
else{
chain.doFilter(request, response);
}
}
} 
