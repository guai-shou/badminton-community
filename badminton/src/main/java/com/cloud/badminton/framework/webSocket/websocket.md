### 第一种方案(使用原生注解)
1. 通信连接在Controller定义 /imServer/{用户ID}
2. 自定义数据结构存储用户会话
3. 向指定用户发送消息, 支持信息持久化


```java
/*message格式*/
public class ChatMessage {
    private Long senderId; // 发送方ID
    private Long recipientId; // 接收方ID
    private String content; // 内容
    private Integer isRead; // 是否已读
    private Integer type; // 发送类型
    private Integer isUndo; // 是否撤销
    private String createTime; // 发送时间
}
```

### 第二种方案(继承TextWebSocketHandler)
1. 使用配置类,配置endpoint与handler之间的关系
2. 重写TextWebSocketHandler里面的几个方式达到和原生注解一样的效果


### 第三种方案
1. 通信连接endpoint /endpoint
2. 订阅主题 /queue 开头
3. 发送消息 /ws/chat



### 聊天记录 已读操作思路
1. 发送方发送信息给接收方
2. 接收方接到信息后, 判断当前窗口是否是发送方
    - 如果是则回复发送方已读记录 继续步骤3
    - 如果不是, 标记小红点
3. 发送方接受已读记录后, 标记信息为已读


