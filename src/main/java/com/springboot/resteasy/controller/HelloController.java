package com.springboot.resteasy.controller;

import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

/**
 * @Description:
 * @Auther: zrblog
 * @CreateTime: 2019-07-27 09:52
 * @Version:v1.0
 */

@RestController
@Path("/")
public class HelloController{
    @GET
    @Path(value = "/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public BaseResult sayHello(@PathParam(value = "id")String id){
        return BaseResult.successResult(id);
    }

    static class BaseResult implements Serializable {
        private Integer code;
        private String msg;
        private Object object;

        public BaseResult(Integer code, String msg){
            this.code = code;
            this.msg = msg;
        }
        public BaseResult(Integer code, String msg, Object object){
            this.code = code;
            this.msg = msg;
            this.object = object;
        }

        public static BaseResult successResult(Object obj){
            return new BaseResult(200, "success",obj);
        }

        public static BaseResult failureResult(Object obj){
            return new BaseResult(500, "failure", obj);
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }
    }
}
