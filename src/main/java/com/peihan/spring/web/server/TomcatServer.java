package com.peihan.spring.web.server;

import com.peihan.spring.web.servlet.DispatcherServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @author:peihan.Z
 * @date:2019/7/6 15:08
 * @description: Tomcat��������ʼ����������õ� DispatcherServlet
 */
public class TomcatServer {
    private Tomcat tomcat;
    private String[] args;

    public TomcatServer(String[] args) {
        this.args = args;
    }

    public void startServer() throws LifecycleException {
        tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.start();

        // new һ����׼�� context ���������÷���·����
        // ͬʱΪ context �����������ڼ�������
        Context context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());
        // �½�һ�� DispatcherServlet ��������������Լ�д�� Servlet �ӿڵ�ʵ���࣬
        // Ȼ��ʹ�� `Tomcat.addServlet()` ����Ϊ context ����ָ�����ֵ� Servlet ����
        // ������Ϊ֧���첽��
        DispatcherServlet servlet = new DispatcherServlet();
        Tomcat.addServlet(context, "dispatcherServlet", servlet)
                .setAsyncSupported(true);

        // Tomcat ���е��̶߳����ػ��̣߳�
        // ���ĳһʱ�����е��̶߳����ػ��̣߳��� JVM ���˳���
        // ��ˣ���ҪΪ tomcat �½�һ�����ػ��߳������ִ�
        // ���������� shutdown ��
        context.addServletMappingDecoded("/", "dispatcherServlet");

        tomcat.getHost().addChild(context);

        Thread tomcatAwaitThread = new Thread("tomcat_await_thread") {
            @Override
            public void run() {
                TomcatServer.this.tomcat.getServer().await();
            }
        };

        tomcatAwaitThread.setDaemon(false);
        tomcatAwaitThread.start();
    }
}
