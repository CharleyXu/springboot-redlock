package com.xu.redlock.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author CharleyXu Created on 2018/1/8.
 */
public class SmsMessageBean implements Serializable {

  //id
  private Integer smsId;

  //手机号
  private String mobile;

  //类型，1：验证码 2：订单通知
  private Byte type;

  //短信创建时间
  private Date createDate;

  //短信消息处理时间
  private Date processTime;

  //短信状态，1：未发送 2：发送成功 3：发送失败
  private Byte status;

  //短信内容
  private String content;

  public Integer getSmsId() {
    return smsId;
  }

  public SmsMessageBean setSmsId(Integer smsId) {
    this.smsId = smsId;
    return this;
  }

  public String getMobile() {
    return mobile;
  }

  public SmsMessageBean setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public Byte getType() {
    return type;
  }

  public SmsMessageBean setType(Byte type) {
    this.type = type;
    return this;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public SmsMessageBean setCreateDate(Date createDate) {
    this.createDate = createDate;
    return this;
  }

  public Date getProcessTime() {
    return processTime;
  }

  public SmsMessageBean setProcessTime(Date processTime) {
    this.processTime = processTime;
    return this;
  }

  public Byte getStatus() {
    return status;
  }

  public SmsMessageBean setStatus(Byte status) {
    this.status = status;
    return this;
  }

  public String getContent() {
    return content;
  }

  public SmsMessageBean setContent(String content) {
    this.content = content;
    return this;
  }

}
