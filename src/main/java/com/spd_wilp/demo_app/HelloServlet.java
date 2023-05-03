package com.spd_wilp.demo_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HelloServlet extends HttpServlet {
  public static final Logger log = LoggerFactory.getLogger(HelloServlet.class);

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public void init() throws ServletException {
    super.init();
    log.info("{} initialized!", this.getClass().getName());
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    log.info("req received={}", req);

    out.println("Hello, world from demo-app! Current time: " + getCurrentTimeString());
    out.close();
  }

  private String getCurrentTimeString() {
    Instant now = Instant.now();
    ZonedDateTime zdt = now.atZone(ZoneOffset.UTC);
    return zdt.format(formatter) + " GTM";
  }
}
