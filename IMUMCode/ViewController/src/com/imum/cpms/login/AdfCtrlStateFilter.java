package com.imum.cpms.login;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class AdfCtrlStateFilter implements Filter{
  private FilterConfig _filterConfig = null;

     public void init(FilterConfig filterConfig) throws ServletException {
         _filterConfig = filterConfig;
     }

     public void destroy() {
         _filterConfig = null;
     }

     /**
      *
      * @param _request
      * @param response
      * @param chain
      * @throws IOException
      * @throws ServletException
      */
      public void doFilter(ServletRequest _request, ServletResponse response, FilterChain chain) throws IOException,
                  ServletException {

              HttpServletRequest request = (HttpServletRequest)_request;

              Map ctrlStateMap = (Map)request.getSession().getAttribute("ctrl-state-map");
              if (ctrlStateMap == null) {
                  ctrlStateMap = new HashMap();
                  request.getSession().setAttribute("ctrl-state-map", ctrlStateMap);
              }

              String ctrlState = request.getParameter("_adf.ctrl-state");
              String windowIdRequest = request.getParameter("Adf-Window-Id");

              String windowIdSession = (String)ctrlStateMap.get(ctrlState);

              if (windowIdRequest != null && windowIdSession != null && !windowIdRequest.equals(windowIdSession)) {
                  // this means there was another window in the same session with the same control state.
                  // rewrite the URL so the ctrl-state is removed altogether
                  String requestURI = request.getRequestURI();
                  String queryString = request.getQueryString();
                  queryString = StringUtils.replace(queryString, "_adf.ctrl-state=" + ctrlState, "");
                  ((HttpServletResponse)response).sendRedirect(requestURI + "?" + queryString);
                  return;
              }

              // otherwise make sure we store the window id for our control state
              if (ctrlState != null && windowIdRequest != null) {
                  ctrlStateMap.put(ctrlState, windowIdRequest);
              }

              chain.doFilter(request, response);
          }
}
