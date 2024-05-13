package com.apidemo.productservice.models;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.beans.*;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YourPojoTestUsingBeanDescriptor {
    YourPojo pojo1 = new YourPojo();
    YourPojo pojo2 = new YourPojo();
    @Test
    @Ignore
    public void testYourPojo() throws IntrospectionException {
//        // Create a BeanInfo object for the POJO class you want to test.
//        BeanInfo beanInfo = Introspector.getBeanInfo(YourPojo.class);
//
//        // Get the property descriptors for the POJO class.
//        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//        // Iterate through the property descriptors and test the getter and setter methods for each property.
//        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
//            try {
//                Method getterMethod = propertyDescriptor.getReadMethod();
//                Method setterMethod = propertyDescriptor.getWriteMethod();
//
//                Class<?> dataType = propertyDescriptor.getPropertyType();
//                Object valueToSet = null;
//                if(setterMethod!=null){
//                    if(dataType.isAssignableFrom(String.class)){
//                        valueToSet = "DUMMY_VAL";
//                    }else if(dataType.isAssignableFrom(Integer.class)){
//                        valueToSet = 1;
//                    } else if (dataType.isAssignableFrom(Boolean.class)) {
//                        valueToSet = Boolean.TRUE;
//                    } else if (dataType.isAssignableFrom(Double.class)) {
//                        valueToSet = 100.0d;
//                    }
//                    setterMethod.invoke(pojo1,valueToSet);
//                    setterMethod.invoke(pojo2,valueToSet);
//                }
//                if(getterMethod!=null){
//                    Object obj1 = getterMethod.invoke(pojo1);
//                    Object obj2 = getterMethod.invoke(pojo2);
//                    assertEquals(obj1,obj2);
//                }
//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        }
    }
}