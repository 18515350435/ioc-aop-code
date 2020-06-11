package com.peihan.spring.starter;

import com.peihan.spring.bean.BeanFactory;
import com.peihan.spring.core.ClassScanner;
import com.peihan.spring.web.handler.HandlerManager;
import com.peihan.spring.web.server.TomcatServer;

import java.util.List;

public class MiniApplication {
    public static void run(Class<?> cls, String[] args) {
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            // ���� tomcat ����
            tomcatServer.startServer();
            // ɨ����
            List<Class<?>> classList = ClassScanner.scannerCLasses(cls.getPackage().getName());
            // ��ʼ�� Bean ����,��ʼ�� AOP������ʹ���� JDK ��̬����
            // Bean������һ�γ�ʼ����ʹ�ô�����Ķ��������� Bean �����еĶ�Ӧ����
            BeanFactory.initBean(classList);
            // Handler ������ʵ�������е�ӳ�䴦���������󶨵���
            HandlerManager.resolveMappingHandler(classList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
