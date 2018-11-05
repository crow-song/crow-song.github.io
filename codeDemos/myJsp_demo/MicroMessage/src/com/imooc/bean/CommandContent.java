package com.imooc.bean;

public class CommandContent {
    /**
     *主键
     */
    private String id;
    /**
     * 内容
     */
    private String Content;
    /**
     * 对应指令表主键
     */
    private String CommandId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getCommandId() {
        return CommandId;
    }

    public void setCommandId(String commandId) {
        CommandId = commandId;
    }
}
