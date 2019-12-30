package org.thinking.common;

import java.io.Serializable;

public class CommonResult<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String msg;
	public T data;
	public int code = 0;//default 0 success 1 fail
	
	public CommonResult(String msg, int code) {
		super();
		this.msg = msg;
		this.code = code;
	}
	
	public CommonResult(String msg, int code, T data) {
		super();
		this.msg = msg;
		this.code = code;
		this.data = data;
	}

	/**
	 * 返回成功
	 * @return
	 */
	public static CommonResult<?> success(Object data) {
		return new CommonResult<>("success", CommonCode.SUCCESS, data);
	}
	/**
	 * 返回成功
	 * @return
	 */
	public static CommonResult<?> success() {
		return new CommonResult<>("success", CommonCode.SUCCESS);
	}

	/**
	 * 返回失败
	 * @param msg
	 * @return
	 */
	public static CommonResult<?> fail(String msg) {
		return new CommonResult<>(msg, CommonCode.FAIL);
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
