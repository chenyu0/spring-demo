package com.yolo.utils;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.*;


public class ConstUtil {
    public ConstUtil() {
    }

    private static void makeConst(Set<String> importName, List<Map> constants, String constNames, Map constant) {
        if (constant != null && constant.size() > 0) {
            Iterator it = constant.keySet().iterator();

            while (it.hasNext()) {
                Object name = it.next();
                Object obj = constant.get(name);
                String constName = constNames + "_" + name;
                if (obj instanceof Map) {
                    makeConst(importName, constants, constName, (Map) obj);
                } else {
                    Map ct = new HashMap();
                    ct.put("constType", name.getClass().getSimpleName());
                    ct.put("constName", constName);
                    if (name instanceof String) {
                        ct.put("constValue", "\"" + name + "\"");
                    } else {
                        ct.put("constValue", name);
                    }

                    constants.add(ct);
                }
            }
        }

    }

    public static void makeConst(String classPath, Class clazz) {
        try {
            Map root = new HashMap();
            root.put("package", clazz.getPackage().getName());
            root.put("className", clazz.getSimpleName().replaceAll("Const", "Dict"));
            Set<String> importSet = new HashSet();
            root.put("imports", importSet);
            List<Map> constants = new ArrayList();
            Field[] fields = clazz.getDeclaredFields();
            Field[] var6 = fields;
            int var7 = fields.length;

            for (int var8 = 0; var8 < var7; ++var8) {
                Field field = var6[var8];
                field.setAccessible(true);
                if (Map.class.isAssignableFrom(field.getType())) {
                    Object obj = field.get(clazz.newInstance());
                    makeConst(importSet, constants, field.getName(), (Map) obj);
                }
            }

            root.put("constants", constants);
            FileOutputStream output = new FileOutputStream(classPath + "/" + root.get("className") + ".java");
            output.write(FtlUtil.getFtl("templates/const_type.ftl", root).getBytes());
            output.flush();
            output.close();
        } catch (Exception var11) {
            var11.printStackTrace();
        }

    }
}
