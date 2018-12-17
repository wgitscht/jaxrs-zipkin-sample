package net.gitschthaler.listener;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import brave.Tracing;
import brave.servlet.TracingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

import java.io.IOException;
import java.util.EnumSet;


@WebListener
public class BaseContextListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(BaseContextListener.class);
    Sender sender = OkHttpSender.create("http://127.0.0.1:9411/api/v2/spans");
    AsyncReporter<Span> spanReporter = AsyncReporter.create(sender);
    Tracing tracing = Tracing.newBuilder()
            .localServiceName("jaxrs-sample-services")
            .spanReporter(spanReporter).build();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent
                .getServletContext()
                .addFilter("tracingFilter", TracingFilter.create(tracing))
                .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/api/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            tracing.close();
            spanReporter.close();
            sender.close();
        } catch (IOException e) {
            // do something
        }
    }
}
