package com.cloud.badminton.framework.webSocket.constants;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/3 17:11
 */
public class WebSocketConstants {
    /* ReadContentType 读取的类型 */
    public final static int TEXT = 0;
    public final static int FILE = 1;

    /* ReadStatus 是否已读*/
    public final static int MESSAGE = 0;
    public final static int HAS_READ = 1;

    /* 好友请求状态 */
    public final static int ACCEPT = 2;
    public final static int REJECT = 1;
    public final static int DEFAULT = 0;
}
