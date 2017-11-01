package com.demo.service;

import com.demo.pojo.OperLog;

/**
 * 
 * <操作日志类>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01, 2017年7月25日 下午11:24:46]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface IOperLogService {
    void add(OperLog log);

    void success(int type, String content, String remark);

    void fail(int type, String content, String remark);
}
