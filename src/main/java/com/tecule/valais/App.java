package com.tecule.valais;

import com.tecule.valais.designpattern.Singleton;

public class App {
  public static void main(String[] args) {
    Singleton s = Singleton.getInstance();
    System.out.println(s.getMessage());

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    Singleton s2 = Singleton.getInstance();
    System.out.println(s2.getMessage());
    

    System.out.println("finish");
  }
}
