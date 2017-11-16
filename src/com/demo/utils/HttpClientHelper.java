package com.demo.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * <请求发送帮助类>
 * <功能详细描述>
 * 
 * @author  AndyGong
 * @version  [YOUFULI V300R001C01, 2017年10月10日 下午1:12:31]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class HttpClientHelper {

    public static String post(String url, Map<String, String> head, String body) throws IOException {
        HttpClient client = new HttpClient();
        HttpClientParams clientParams = new HttpClientParams();
        clientParams.setConnectionManagerTimeout(3000);
        clientParams.setContentCharset("UTF-8");
        client.setParams(clientParams);
        PostMethod method = new PostMethod(url);
        if (head != null) {
            Iterator<String> iterator = head.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                method.addRequestHeader(key, head.get(key));
            }
        }
        String result;
        try {
            if (body != null && !"".equals(body)) {
                method.setRequestEntity(new StringRequestEntity(body, "application/json", "UTF-8"));
            }
            client.executeMethod(method);
            result = method.getResponseBodyAsString();
        } catch (IOException e) {
            throw e;
        } finally {
            method.releaseConnection();
        }

        return result;
    }

    /**
     * http post 请求
     *
     * @param url  URL
     * @param head header参数
     * @param body 参数
     * @return 结果，异常后返回null
     */
    public static String post(String url, Map<String, String> head, Map<String, String> body) throws IOException {
        HttpClient client = new HttpClient();
        HttpClientParams clientParams = new HttpClientParams();
        clientParams.setConnectionManagerTimeout(3000);
        clientParams.setContentCharset("UTF-8");
        client.setParams(clientParams);
        PostMethod method = new PostMethod(url);

        // header 参数设置
        if (head != null && head.size() != 0) {
            Iterator<String> iterator = head.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                method.addRequestHeader(key, head.get(key));
            }
        }

        // 传递参数
        if (body != null && body.size() != 0) {
            Iterator<String> iterator = body.keySet().iterator();
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = body.get(key).toString();
                params.add(new NameValuePair(key, value));
            }
            method.addParameters(params.toArray(new NameValuePair[params.size()]));
        }
        String result;
        try {
            client.executeMethod(method);
            result = method.getResponseBodyAsString();
        } catch (IOException e) {
            throw e;
        } finally {
            method.releaseConnection();
        }

        return result;
    }

    /**
     * http get请求
     *
     * @param url  URL
     * @param head head参数
     * @param body 参数
     * @return 结果，异常后返回null
     */
    public static String get(String url, Map<String, String> head, Map<String, String> body) throws IOException {
        HttpClient client = new HttpClient();
        HttpClientParams clientParams = new HttpClientParams();
        clientParams.setConnectionManagerTimeout(3000);
        clientParams.setContentCharset("UTF-8");
        client.setParams(clientParams);

        if (body != null && body.size() != 0) {
            Iterator<String> iterator = body.keySet().iterator();
            String params = "";
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = body.get(key).toString();
                params += "&" + key + "=" + value;
            }

            url = url + "?" + params.substring(1);
            System.out.println(url);
        }

        GetMethod method = new GetMethod(url);
        if (head != null && head.size() != 0) {
            Iterator<String> iterator = head.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                method.addRequestHeader(key, head.get(key));
            }
        }

        String result;
        try {
            client.executeMethod(method);
            result = method.getResponseBodyAsString();
        } catch (IOException e) {
            throw e;
        }
        method.releaseConnection();
        return result;
    }

}
