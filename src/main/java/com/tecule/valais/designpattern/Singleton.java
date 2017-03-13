package com.tecule.valais.designpattern;

public class Singleton {
  /**
   * 定义成静态成员变量，才能被静态方法getInstance()访问.
   */
  private static volatile Singleton instance;
  private String message;

  /**
   * 构造函数设置为私有的，不允许外部通过new的方式创建对象，只能通过类的静态方法getInstance()创建.
   */
  private Singleton() {
    message = "foo";
    System.out.println("create instance once at " + System.currentTimeMillis());
  }

  /**
   * 通过类的静态方法获取实例.
   * 
   * @return instance
   */
  public static Singleton getInstance() {
    // 双重检查的加锁机制，这样只有第一次调用获取实例方法时才会进入同步块
    if (instance == null) {
      // 使用同步块保证在多线程情况下也只创建一个实例
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
