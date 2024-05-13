package com.apidemo.productservice.models;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YourPojoTest {
    private YourPojo obj;
    @SuppressWarnings("unchecked")
    @Test
    @Ignore
    public void testYourPojo(){
//        try {
//            obj = (YourPojo.class).getDeclaredConstructor().newInstance();
//            Field[] fields = YourPojo.class.getDeclaredFields();
//            for(Field field : fields){
//
//                String fieldName = field.getName();
//                String name = StringUtils.capitalize(fieldName);
//                String getter = "get" + name;
//                String setter = "set" + name;
//
//                Object valueToSet = null;
//                Class<?> dataType = field.getType();
//                if (dataType.isAssignableFrom(String.class)) {
//                    valueToSet = "str";
//                } else if (dataType.isAssignableFrom(Long.class) || dataType.isAssignableFrom(long.class)) {
//                    valueToSet = Long.valueOf("1");
//                } else if (dataType.isAssignableFrom(Integer.class) || dataType.isAssignableFrom(int.class)) {
//                    valueToSet = Integer.valueOf("1");
//                } else if (dataType.isAssignableFrom(Double.class) || dataType.isAssignableFrom(double.class)) {
//                    valueToSet = Double.valueOf("1.0");
//                } else if (dataType.isAssignableFrom(Date.class)) {
//                    valueToSet = new Date();
//                } else if (dataType.isAssignableFrom(Boolean.class)) {
//                    valueToSet = Boolean.FALSE;
//                }
//                Method getterMethod = YourPojo.class.getMethod(getter);
//                Method setterMethod = YourPojo.class.getMethod(setter, getterMethod.getReturnType());
//                setterMethod.invoke(obj, valueToSet);
//                Object result = getterMethod.invoke(obj);
//                assertEquals(result, valueToSet);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}