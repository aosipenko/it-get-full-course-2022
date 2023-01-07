package org.prog.poly;

public class OverloadDemo {

  public static void main(String... args) {
    OverloadDemo demo = new OverloadDemo();

    demo.makeHttpRequest();
    demo.makeHttpRequest("Post");
    demo.makeHttpRequest("Delete", "https://facebook.com");
  }

  public void makeHttpRequest() {
    makeHttpRequest("GET");
  }

  public void makeHttpRequest(String requestType) {
    makeHttpRequest(requestType, "https://google.com/");
  }

  public void makeHttpRequest(String asdasd, int i) {
    makeHttpRequest(asdasd, "https://google.com/");
  }

  public void makeHttpRequest(int i, String asdasd) {
    makeHttpRequest(asdasd, "https://google.com/");
  }

  public void makeHttpRequest(String requestType, String url) {
    System.out.println("Making " + requestType + " request to " + url);
  }
}
