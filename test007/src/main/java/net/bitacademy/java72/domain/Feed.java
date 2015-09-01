package net.bitacademy.java72.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 값을 실어 나르는 클래스(Data Transfer Object)
 * => 값을 표현하는 클래스
 * => 특정 업무 영역의 데이터를 표현한다고 해서 Business Domain Object라고도 한다.
 * => 줄여서 Domain Object 객체라고 한다.
 * 
 * Serializable 인터페이스
 * => 클래스의 데이터를 바이트 배열로 직렬화할 수 있음을 표시할 때 사용.
 * => 메서드가 없다. 단지 JVM에게 직렬화를 허용한다고 표시하는 용도로 사용한다.
 */
public class Feed implements Serializable {
  /*
   * 질력화될 때 데이터의 버전 정보도 함께 저장된다. 나중에 바이트 배열을 다시 객체로 복원할 때, 버전을 검사하는 데 사용한다.
   */
  private static final long serialVersionUID = 1L;

  protected int    no;
  protected String writer;
  protected String content;
  protected Date   createDate;
  protected String publicScope;
  protected String likeMsg;
  protected int    mno;
  protected String attachFile1;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCreateDate() {
    int time = (int) (new Date().getTime() - createDate.getTime()) / 1000;
    //System.out.println(time);

    String timePrint = "";

    if (time > (60 * 60 * 24)) {
      timePrint += time / (60 * 60 * 24) +"일 전";
    } else if (time > (60 * 60)) {
      timePrint += (time / (60 * 60)) + "시간 전";
    } else {
      timePrint += "방금";
    }
    
    System.out.println(timePrint);

    return timePrint;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getPublicScope() {
    return publicScope;
  }

  public void setPublicScope(String publicScope) {
    this.publicScope = publicScope;
  }

  public String getLikeMsg() {
    return likeMsg;
  }

  public void setLikeMsg(String likeMsg) {
    this.likeMsg = likeMsg;
  }

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }

  public String getAttachFile1() {
    return attachFile1;
  }

  public void setAttachFile1(String attachFile1) {
    this.attachFile1 = attachFile1;
  }

}
