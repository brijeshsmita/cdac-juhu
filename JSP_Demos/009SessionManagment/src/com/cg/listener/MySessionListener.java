package com.cg.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    public MySessionListener() {
        // TODO Auto-generated constructor stub
    }
    public void sessionCreated(HttpSessionEvent arg0)  { 
         System.out.println("Session Created at:"+new Date());
    }
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
        System.out.println("Session detroyed at:"+new Date());
    }
	
}
