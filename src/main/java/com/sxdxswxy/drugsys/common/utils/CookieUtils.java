package com.sxdxswxy.drugsys.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Cookie工具类
 *
 * @author Justdwiwt
 */
public class CookieUtils {

    private static final Logger logger = LoggerFactory.getLogger(CookieUtils.class);

    /**
     * 获取Cookie的值
     * <p>不编码</p>
     *
     * @param request    servlet request
     * @param cookieName String name
     * @return cookie value
     * @see #getCookieValue(HttpServletRequest, String, boolean)
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        return getCookieValue(request, cookieName, false);
    }

    /**
     * 获取Cookie的值
     *
     * @param request    servlet request
     * @param cookieName String name
     * @return cookie value
     */
    private static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null)
            return null;
        String retValue = null;
        try {
            for (Cookie aCookieList : cookieList)
                if (aCookieList.getName().equals(cookieName)) {
                    if (isDecoder)
                        retValue = URLDecoder.decode(aCookieList.getValue(), "UTF-8");
                    else
                        retValue = aCookieList.getValue();
                    break;
                }
        } catch (UnsupportedEncodingException e) {
            logger.error("Cookie Decode Error.", e);
        }
        return retValue;
    }

    /**
     * 获取Cookie的值
     *
     * @param request    servlet request
     * @param cookieName String name
     * @return cookie value
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (Cookie aCookieList : cookieList)
                if (aCookieList.getName().equals(cookieName)) {
                    retValue = URLDecoder.decode(aCookieList.getValue(), encodeString);
                    break;
                }
        } catch (UnsupportedEncodingException e) {
            logger.error("Cookie Decode Error.", e);
        }
        return retValue;
    }

    /**
     * 设置Cookie的值
     * <p>默认浏览器关闭即失效</p>
     * <p>不编码</p>
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response,
                                 String cookieName, String cookieValue) {
        setCookie(request, response, cookieName, cookieValue, -1);
    }

    /**
     * 设置Cookie的值
     * <p>在指定时间内生效</p>
     * <p>不编码</p>
     */
    private static void setCookie(HttpServletRequest request, HttpServletResponse response,
                                  String cookieName, String cookieValue, int cookieMaxage) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, false);
    }

    /**
     * 设置Cookie的值
     * <p>不设置生效时间</p>
     * <p>编码</p>
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response,
                                 String cookieName, String cookieValue, boolean isEncode) {
        setCookie(request, response, cookieName, cookieValue, -1, isEncode);
    }

    /**
     * 设置Cookie的值
     * <p>在指定时间内生效</p>
     * <p>编码</p>
     */
    private static void setCookie(HttpServletRequest request, HttpServletResponse response,
                                  String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode);
    }

    /**
     * 设置Cookie的值
     * <p>在指定时间内生效</p>
     * <p>指定编码</p>
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response,
                                 String cookieName, String cookieValue, int cookieMaxage, String encodeString) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString);
    }

    /**
     * 删除Cookie和cookie
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response,
                                    String cookieName) {
        doSetCookie(request, response, cookieName, "", -1, false);
    }

    /**
     * 设置Cookie的值
     * <p>在指定时间内生效</p>
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    @SuppressWarnings({"FinalPrivateMethod", "FinalStaticMethod"})
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
                                          String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        try {
            if (cookieValue == null)
                cookieValue = "";
            else if (isEncode)
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0)
                cookie.setMaxAge(cookieMaxage);
            // 设置域名的cookie
            if (null != request)
                //cookie.setDomain(getDomainName(request));		引发无法设置cookie
                cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            logger.error("Cookie Encode Error.", e);
        }
    }

    /**
     * 设置Cookie的值
     * <p>在指定时间内生效</p>
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    @SuppressWarnings({"FinalPrivateMethod", "FinalStaticMethod"})
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
                                          String cookieName, String cookieValue, int cookieMaxage, String encodeString) {
        try {
            if (cookieValue == null)
                cookieValue = "";
            else cookieValue = URLEncoder.encode(cookieValue, encodeString);
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0)
                cookie.setMaxAge(cookieMaxage);
            if (null != request)// 设置域名的cookie
                cookie.setDomain(getDomainName(request));
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            logger.error("Cookie Encode Error.", e);
        }
    }

    /**
     * 获取cookie的域名
     */
    @SuppressWarnings({"FinalPrivateMethod", "FinalStaticMethod", "ConstantConditions", "RegExpRedundantEscape"})
    private static final String getDomainName(HttpServletRequest request) {
        String domainName = null;
        String serverName = request.getRequestURL().toString();
        if (serverName == null || serverName.equals(""))
            domainName = "";
        else {
            serverName = serverName.toLowerCase();
            serverName = serverName.substring(7);
            final int end = serverName.indexOf("/");
            serverName = serverName.substring(0, end);
            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            // www.xxx.com.cn
            if (len > 3)
                domainName = "." + domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
            else // xxx.com or xxx.cn
                if (len <= 3 && len > 1)
                    domainName = "." + domains[len - 2] + "." + domains[len - 1];
                else
                    domainName = serverName;
        }
        if (domainName != null && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }

}
