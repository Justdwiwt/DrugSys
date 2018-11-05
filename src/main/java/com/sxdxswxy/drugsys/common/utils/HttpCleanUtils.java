package com.sxdxswxy.drugsys.common.utils;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * 定期清理无效的http连接
 *
 * @author Justdwiwt
 */
public class HttpCleanUtils extends Thread {

    private final HttpClientConnectionManager connMgr;
    private Integer waitTime;
    private volatile boolean shutdown;

    public HttpCleanUtils(HttpClientConnectionManager connMgr, Integer waitTime) {
        this.connMgr = connMgr;
        this.waitTime = waitTime;
        this.start();
    }

    /**
     * 关闭失效的连接
     */
    @Override
    public void run() {
        try {
            while (!shutdown)
                synchronized (this) {
                    wait(waitTime);
                    connMgr.closeExpiredConnections();
                }
        } catch (InterruptedException ex) {
            //  TODO 结束
        }
    }

    /**
     * 销毁释放资源
     */
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }

}
