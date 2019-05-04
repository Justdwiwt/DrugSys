package com.sxdxswxy.drugsys.common.log;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sxdxswxy.drugsys.common.system.SysLogVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class TopLogAspect {

//    @Value("${top.system.code}")
//    private String systemCode;

//    @Reference
//    private SysLogService sysLogService;

    /**
     * 定义切点
     */
    @Pointcut("execution (* com.sxdxswxy.drugsys.controller..*.*(..))")
    public void controllerAspect() {
    }


    /**
     * 前置通知，用于拦截Controller层记录用户的操作
     */
    @Around(value = "controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Long startTime = System.currentTimeMillis();
//        SysLogVO sysLog = getSysLog(pjp);
        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Exception e) {
            log.error("异常信息:", e);
        } finally {
            Long endTime = System.currentTimeMillis();
            Long totalTime = endTime - startTime;
            log.debug("耗时统计：{}", totalTime);
            //日志记录
//            sysLog.setTotalTime(totalTime.toString());
//            sysLog.setRespTime(DateUtil.parseDateToStr(new Date(), DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
//            log.debug("记录信息：{}", sysLog.toString());
//            if (sysLog.getLogLevel() != null && sysLog.getLogLevel() != 0) {
//                sysLogService.addSystemLog(sysLog);
//            }
        }
        return object;
    }

//    private SysLogVO getSysLog(ProceedingJoinPoint pjp) {
//        SysLogVO sysLog = new SysLogVO();
//        try {
//            sysLog.setReqTime(DateUtil.parseDateToStr(new Date(), DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            HttpSession session = request.getSession();
//            //读取session中的用户
//            ActiveUser user = (ActiveUser) session.getAttribute(GlobalConstants.USER_SESSION_KEY);
//            //请求的IP
//            String ip = request.getRemoteAddr();
//            String targetName = pjp.getTarget().getClass().getName();
//            String methodName = pjp.getSignature().getName();
//            Object[] arguments = pjp.getArgs();
//            Class targetClass = Class.forName(targetName);
//            Method[] methods = targetClass.getMethods();
//            String params = "";
//            if (pjp.getArgs() != null && pjp.getArgs().length > 0) {
//                params = Arrays.toString(pjp.getArgs());
//            }
//            String description = "";
//            String module = "";
//            String methodNm = "";
//            int level = 0;
//            for (Method method : methods) {
//                if (method.getName().equals(methodName)) {
//                    Class[] clazzs = method.getParameterTypes();
//                    if (clazzs.length == arguments.length) {
//                        TopLog annotation = method.getAnnotation(TopLog.class);
//                        if (annotation != null) {
//                            description = method.getAnnotation(TopLog.class).description();
//                            module = method.getAnnotation(TopLog.class).module();
//                            methodNm = method.getAnnotation(TopLog.class).methods();
//                            level = method.getAnnotation(TopLog.class).level();
//                            break;
//                        }
//                    }
//                }
//            }
//            sysLog.setIp(ip);
//            sysLog.setOperLocation(targetName + "." + methodName + "(" + params + ")");
//            sysLog.setOperDescription(description);
//            sysLog.setOperMethod(methodNm);
//            sysLog.setOperModule(module);
//            if (user != null) {
//                sysLog.setUserName(user.getUserName());
//                sysLog.setRealName(user.getRealName());
//                sysLog.setUserId(user.getUserId());
//            }
//            sysLog.setLogLevel(level <= 4 && level > 0 ? level : 0);
//            sysLog.setSysCode(systemCode);
//            //*========控制台输出=========*//
//            log.debug("请求方法:{}", targetName + "." + methodName + "(" + params + ")");
//            log.debug("模块描述:{}，模块名称：{}，模块方法：{}", description, module, methodNm);
//            log.debug("请求IP：{}，请求人：{}", ip, sysLog.getUserName());
//        } catch (Exception e) {
//            log.error("通用日志处理的异常信息:", e);
//        }
//        return sysLog;
//    }

}
