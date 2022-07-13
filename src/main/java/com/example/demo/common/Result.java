package com.example.demo.common;

/*Result类是后端返回给前端结果的包装类，
* 返回结果是json数据，其中的code表示结果是成功还是失败，该处定义0是成功，非0是失败，同时表达各种错误类型；
* msg表示错误的信息
* 因为要查询不同的表数据进行包装返回，所以data使用<T>范型，就可以包含多个表的数据。
*/
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
