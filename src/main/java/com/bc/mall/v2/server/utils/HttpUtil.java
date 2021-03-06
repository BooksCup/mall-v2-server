package com.bc.mall.v2.server.utils;

import com.bc.mall.v2.server.cons.Constant;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类
 *
 * @author zhou
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * get请求
     *
     * @param url url
     * @return 服务器返回
     */
    public static String doGet(String url) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            // 发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 读取服务器返回过来的json字符串数据
                String result = EntityUtils.toString(response.getEntity());
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post请求(用于key-value格式的参数)
     *
     * @param url    url
     * @param params 请求参数
     * @return 服务器返回
     */
    public static String doPost(String url, Map<String, String> params) {
        BufferedReader in;
        try {
            // 定义HttpClient  
            HttpClient client = HttpClientBuilder.create().build();
            // 实例化HTTP方法
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));

            // 设置参数
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            for (Iterator iterator = params.keySet().iterator(); iterator.hasNext(); ) {
                String name = (String) iterator.next();
                String value = String.valueOf(params.get(name));
                nameValuePairs.add(new BasicNameValuePair(name, value));
            }
            request.setEntity(new UrlEncodedFormEntity(nameValuePairs, StandardCharsets.UTF_8));

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code == HttpStatus.SC_OK) {
                // 请求成功
                in = new BufferedReader(new InputStreamReader(response.getEntity()
                        .getContent(), "utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String separator = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + separator);
                }
                in.close();
                return sb.toString();
            } else {
                logger.info("statusCode: " + code);
                return null;
            }
        } catch (Exception e) {
            logger.error("[doPost] error, msg: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * post请求（用于请求json格式的参数）
     *
     * @param url    url
     * @param params 参数
     * @return 服务器返回
     */
    public static String doPost(String url, String params) throws Exception {
        // 创建httpPost
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int statusCode = status.getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            } else {
                logger.info("statusCode: " + statusCode + ", url: " + url);
            }
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 发送HTTP请求
     *
     * @param requestUrl    请求URL
     * @param requestMethod 请求方法
     * @param output        输出
     * @return 服务器返回
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String output) {
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);
            if (null != output) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(output.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            connection.disconnect();
            return buffer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    /**
     * 获取IP地址
     *
     * @param request 请求
     * @return IP地址
     */
    public static String getIp(HttpServletRequest request) {
        // 获取请求ip地址
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || Constant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || Constant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || Constant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf(Constant.SYMBOL_COMMA) != -1) {
            String[] ips = ip.split(Constant.SYMBOL_COMMA);
            ip = ips[0].trim();
        }
        return ip;
    }
}