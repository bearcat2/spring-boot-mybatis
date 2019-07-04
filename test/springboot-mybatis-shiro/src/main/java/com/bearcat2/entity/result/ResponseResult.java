package com.bearcat2.entity.result;

import com.bearcat2.util.IStatusMessage;

import java.io.Serializable;

/**
 * @项目名称： wyait-manage
 * @类名称： ResponseResult
 * @类描述： 前端请求响应结果,code:编码,message:描述,obj对象，可以是单个数据对象，数据列表或者PageInfo
 * @创建时间： 2018年1月4日10:57:24
 * @version:
 */
public class ResponseResult implements Serializable {
	
	private static final long serialVersionUID = 7285065610386199394L;

	/** 响应码 0 响应成功,非0失败 */
	private String code;

	/** 响应消息,系统发生错误时为对应的错误消息 */
	private String msg;

	/** 响应数据 */
	private Object data;

	/** 数据总数 */
	private Long count;

	
	public ResponseResult() {
		this.code = IStatusMessage.SystemStatus.SUCCESS.getCode();
		this.msg = IStatusMessage.SystemStatus.SUCCESS.getMessage();
	}
	
	public ResponseResult(IStatusMessage statusMessage){
		this.code = statusMessage.getCode();
		this.msg = statusMessage.getMessage();
		
	}

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ResponseResult{" +
				"code='" + code + '\'' +
				", msg='" + msg + '\'' +
				", data=" + data +
				", count=" + count +
				'}';
	}
}
