package com.globallogic.procamp.lesson10.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public abstract class GenericSuperclass<T, ID> implements Runnable{

    private final Class<T> entityClass;
    private final Class<ID> id;

    public GenericSuperclass() {
//        System.out.println(getClass().getGenericInterfaces());
            ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();

            System.out.println(genericSuperclass);
            Type[] args = genericSuperclass.getActualTypeArguments();
            
            //noinspection unchecked
            this.entityClass = (Class<T>) args[0];
            //noinspection unchecked
            this.id = (Class<ID>) args[1];
    }

    @Override public void run() {
        System.out.println(entityClass);
        System.out.println(id);
    }
}
