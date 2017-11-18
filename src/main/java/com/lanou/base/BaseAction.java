package com.lanou.base;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by dllo on 17/11/9.
 */
public class BaseAction<T, S> extends ActionSupport implements ModelDriven<T> {
    private T model;
    protected S service;

    public BaseAction() {
        Class<? extends BaseAction> clazz = this.getClass();
//        在获取父类的泛型参数
        ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
//        获取所有泛型集合(因为可能会有多个泛型)
        Type[] typeArguments = type.getActualTypeArguments();
//        就获取到了泛型的class
        Class modelclass = (Class) typeArguments[0];
        try {
//        根据反射创建出泛型的对象
            model = (T) modelclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getModel() {
        return model;
    }

//    向session存放数据
    public void sessionPut(String key, Object value) {
        ActionContext.getContext().getSession().put(key, value);
    }

    public void requestPut(String key, Object value) {
        ServletActionContext.getRequest().setAttribute(key, value);
    }


    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getresponse() {
        return ServletActionContext.getResponse();
    }

    public void setService(S service) {
        this.service = service;
    }

//    方法泛型
//    public <E> List<E> login(Class<E> clazz){
//
//    }
}
