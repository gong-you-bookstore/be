package com.bookstore.sharedBook.common;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {
    public <T> SingleResult<T> getSingleResult(T data){
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setData(list);
        setSuccessResult(result);
        return result;
    }

    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    public CommonResult getSimpleResult(boolean isSuccess){
        CommonResult result = new CommonResult();
        result.setSuccess(isSuccess);
        if (isSuccess){
            result.setCode(CommonResponse.SUCCESS.getCode());
            result.setMsg(CommonResponse.SUCCESS.getMsg());
        }else{
            result.setCode(CommonResponse.FAIL.getCode());
            result.setMsg(CommonResponse.FAIL.getMsg());
        }
        return result;
    }
}
