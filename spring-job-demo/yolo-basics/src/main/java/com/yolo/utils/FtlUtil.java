package com.yolo.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;


public class FtlUtil {
    private static Logger logger = LoggerFactory.getLogger(FtlUtil.class);
    private static ThreadLocal<Configuration> cfgTL = ThreadLocal.withInitial(() -> {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setClassLoaderForTemplateLoading(ConstUtil.class.getClassLoader(), "");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setTemplateUpdateDelayMilliseconds(-1L);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setNumberFormat("0.##########");
        cfg.setTagSyntax(0);
        cfg.setURLEscapingCharset("UTF-8");
        cfg.setLocale(Locale.CHINA);
        cfg.setBooleanFormat("true,false");
        cfg.setDateFormat("yyyy-MM-dd");
        cfg.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
        cfg.setTimeFormat("HH:mm:ss");
        cfg.setWhitespaceStripping(true);
        return cfg;
    });
    private static Configuration cfg;
    private static ThreadLocal<Configuration> parseTL;

    public FtlUtil() {
    }

    public static String parse(String content, Map args) throws RuntimeException {
        try {
            Configuration c = (Configuration) parseTL.get();
            StringTemplateLoader loader = new StringTemplateLoader();
            loader.putTemplate("_code", content);
            c.setTemplateLoader(loader);
            String result = getFtl(c, "_code", args);
            logger.debug("FreeMarker parse result: " + result);
            return result;
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public static String getFtl(String ftl, Map args) throws Exception {
        Template template = cfg.getTemplate(ftl);
        StringWriter writer = new StringWriter();
        BufferedWriter bf = new BufferedWriter(writer);
        template.process(args, bf);
        bf.flush();
        writer.flush();
        String html = writer.toString();
        writer.close();
        bf.close();
        return html;
    }


    public static String getFtl(Configuration config, String ftl, Map args) throws Exception {
        Template template = config.getTemplate(ftl);
        StringWriter writer = new StringWriter();
        BufferedWriter bf = new BufferedWriter(writer);
        template.process(args, bf);
        bf.flush();
        writer.flush();
        String html = writer.toString();
        writer.close();
        bf.close();
        return html;
    }

    static {
        cfg = cfgTL.get();
        parseTL = ThreadLocal.withInitial(() -> {
            Configuration c = (Configuration) cfgTL.get();
            c.setInterpolationSyntax(21);
            c.setTemplateUpdateDelayMilliseconds(0L);
            return c;
        });
    }
}
