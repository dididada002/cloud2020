package com.jt.springcloud.modul.vo;

import java.util.ArrayList;
import java.util.List;

/**
*  Created by chuzhaowei on  2018/9/13
*/
public enum ResultCode {


    SUCCESS(1, "成功"),


    FAILURE(0, "失败"),

    SYSfAIL(0,"系统异常"),

    LOGINFAILE(0,"验证码错误"),

// 1xx Informational


    /**
     * {@code 100 Continue}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.2.1">HTTP/1.1:
     *      Semantics and Content, section 6.2.1</a>
     */
    CONTINUE(100, "继续"),

    /**
     * {@code 101 Switching Protocols}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.2.2">HTTP/1.1:
     *      Semantics and Content, section 6.2.2</a>
     */
    SWITCHING_PROTOCOLS(101, "切换协议"),

    /**
     * {@code 102 Processing}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2518#section-10.1">WebDAV</a>
     */
    PROCESSING(102, "处理"),

    /**
     * {@code 103 Checkpoint}.
     *
     * @see <a href=
     *      "http://code.google.com/p/gears/wiki/ResumableHttpRequestsProposal">A
     *      proposal for supporting resumable POST/PUT HTTP requests in HTTP/1.0</a>
     */
    CHECKPOINT(103, "检查点"),


// 2xx Success


    /**
     * {@code 200 OK}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.1">HTTP/1.1:
     *      Semantics and Content, section 6.3.1</a>
     */
    OK(200, "OK"),

    /**
     * {@code 201 Created}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.2">HTTP/1.1:
     *      Semantics and Content, section 6.3.2</a>
     */
    CREATED(201, "创建"),

    /**
     * {@code 202 Accepted}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.3">HTTP/1.1:
     *      Semantics and Content, section 6.3.3</a>
     */
    ACCEPTED(202, "接受"),

    /**
     * {@code 203 Non-Authoritative Information}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.4">HTTP/1.1:
     *      Semantics and Content, section 6.3.4</a>
     */
    NON_AUTHORITATIVE_INFORMATION(203, "非权威信息"),

    /**
     * {@code 204 No Content}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.5">HTTP/1.1:
     *      Semantics and Content, section 6.3.5</a>
     */
    NO_CONTENT(204, "无内容"),

    /**
     * {@code 205 Reset Content}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.6">HTTP/1.1:
     *      Semantics and Content, section 6.3.6</a>
     */
    RESET_CONTENT(205, "重置内容"),

    /**
     * {@code 206 Partial Content}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7233#section-4.1">HTTP/1.1: Range
     *      Requests, section 4.1</a>
     */
    PARTIAL_CONTENT(206, "部分内容"),

    /**
     * {@code 207 Multi-Status}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-13">WebDAV</a>
     */
    MULTI_STATUS(207, "多状态"),

    /**
     * {@code 208 Already Reported}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc5842#section-7.1">WebDAV Binding
     *      Extensions</a>
     */
    ALREADY_REPORTED(208, "已经报告"),

    /**
     * {@code 226 IM Used}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc3229#section-10.4.1">Delta
     *      encoding in HTTP</a>
     */
    IM_USED(226, "IM 使用"),


// 3xx Redirection


    /**
     * {@code 300 Multiple Choices}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.1">HTTP/1.1:
     *      Semantics and Content, section 6.4.1</a>
     */
    MULTIPLE_CHOICES(300, "多种选择"),

    /**
     * {@code 301 Moved Permanently}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.2">HTTP/1.1:
     *      Semantics and Content, section 6.4.2</a>
     */
    MOVED_PERMANENTLY(301, "永久移动"),

    /**
     * {@code 302 Found}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.3">HTTP/1.1:
     *      Semantics and Content, section 6.4.3</a>
     */
    FOUND(302, "找到"),

    /**
     * {@code 302 Moved Temporarily}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc1945#section-9.3">HTTP/1.0,
     *      section 9.3</a>
     * @deprecated in favor of {@link #FOUND} which will be returned from
     *             {@code HttpStatus.valueOf(302)}
     */
    @Deprecated
    MOVED_TEMPORARILY(302, "Moved Temporarily"),

    /**
     * {@code 303 See Other}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.4">HTTP/1.1:
     *      Semantics and Content, section 6.4.4</a>
     */
    SEE_OTHER(303, "见其他"),

    /**
     * {@code 304 Not Modified}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7232#section-4.1">HTTP/1.1:
     *      Conditional Requests, section 4.1</a>
     */
    NOT_MODIFIED(304, "未修改"),

    /**
     * {@code 305 Use Proxy}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.5">HTTP/1.1:
     *      Semantics and Content, section 6.4.5</a>
     * @deprecated due to security concerns regarding in-band configuration of a
     *             proxy
     */
    @Deprecated
    USE_PROXY(305, "使用代理"),

    /**
     * {@code 307 Temporary Redirect}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.7">HTTP/1.1:
     *      Semantics and Content, section 6.4.7</a>
     */
    TEMPORARY_REDIRECT(307, "临时重定向"),

    /**
     * {@code 308 Permanent Redirect}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7238">RFC 7238</a>
     */
    PERMANENT_REDIRECT(308, "永久重定向"),


// --- 4xx Client Error ---


    /**
     * {@code 400 Bad Request}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.1">HTTP/1.1:
     *      Semantics and Content, section 6.5.1</a>
     */
    BAD_REQUEST(400, "错误请求"),

    /**
     * {@code 401 Unauthorized}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7235#section-3.1">HTTP/1.1:
     *      Authentication, section 3.1</a>
     */
    UNAUTHORIZED(401, "未经授权"),

    /**
     * {@code 402 Payment Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.2">HTTP/1.1:
     *      Semantics and Content, section 6.5.2</a>
     */
    PAYMENT_REQUIRED(402, "需要付款"),

    /**
     * {@code 403 Forbidden}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.3">HTTP/1.1:
     *      Semantics and Content, section 6.5.3</a>
     */
    FORBIDDEN(403, "禁止"),

    /**
     * {@code 404 Not Found}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.4">HTTP/1.1:
     *      Semantics and Content, section 6.5.4</a>
     */
    NOT_FOUND(404, "未找到"),

    /**
     * {@code 405 Method Not Allowed}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.5">HTTP/1.1:
     *      Semantics and Content, section 6.5.5</a>
     */
    METHOD_NOT_ALLOWED(405, "方法不允许"),

    /**
     * {@code 406 Not Acceptable}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.6">HTTP/1.1:
     *      Semantics and Content, section 6.5.6</a>
     */
    NOT_ACCEPTABLE(406, "不可接受"),
    /**
     * {@code 407 Proxy Authentication Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7235#section-3.2">HTTP/1.1:
     *      Authentication, section 3.2</a>
     */
    PROXY_AUTHENTICATION_REQUIRED(407, "需要代理验证"),

    /**
     * {@code 408 Request Timeout}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.7">HTTP/1.1:
     *      Semantics and Content, section 6.5.7</a>
     */
    REQUEST_TIMEOUT(408, "请求超时"),

    /**
     * {@code 409 Conflict}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.8">HTTP/1.1:
     *      Semantics and Content, section 6.5.8</a>
     */
    CONFLICT(409, "冲突"),

    /**
     * {@code 410 Gone}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.9">HTTP/1.1:
     *      Semantics and Content, section 6.5.9</a>
     */
    GONE(410, "走了"),

    /**
     * {@code 411 Length Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.10">HTTP/1.1:
     *      Semantics and Content, section 6.5.10</a>
     */
    LENGTH_REQUIRED(411, "所需长度"),

    /**
     * {@code 412 Precondition failed}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7232#section-4.2">HTTP/1.1:
     *      Conditional Requests, section 4.2</a>
     */
    PRECONDITION_FAILED(412, "先决条件失败"),

    /**
     * {@code 413 Payload Too Large}.
     *
     * @since 4.1
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.11">HTTP/1.1:
     *      Semantics and Content, section 6.5.11</a>
     */
    PAYLOAD_TOO_LARGE(413, "请求实体太大"),

    /**
     * {@code 413 Request Entity Too Large}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2616#section-10.4.14">HTTP/1.1,
     *      section 10.4.14</a>
     * @deprecated in favor of {@link #PAYLOAD_TOO_LARGE} which will be returned
     *             from {@code HttpStatus.valueOf(413)}
     */
    @Deprecated
    REQUEST_ENTITY_TOO_LARGE(413, "请求实体太大"),

    /**
     * {@code 414 URI Too Long}.
     *
     * @since 4.1
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.12">HTTP/1.1:
     *      Semantics and Content, section 6.5.12</a>
     */
    URI_TOO_LONG(414, "请求URI太长"),

    /**
     * {@code 414 Request-URI Too Long}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2616#section-10.4.15">HTTP/1.1,
     *      section 10.4.15</a>
     * @deprecated in favor of {@link #URI_TOO_LONG} which will be returned from
     *             {@code HttpStatus.valueOf(414)}
     */
    @Deprecated
    REQUEST_URI_TOO_LONG(414, "请求URI太长"),

    /**
     * {@code 415 Unsupported Media Type}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.13">HTTP/1.1:
     *      Semantics and Content, section 6.5.13</a>
     */
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),

    /**
     * {@code 416 Requested Range Not Satisfiable}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7233#section-4.4">HTTP/1.1: Range
     *      Requests, section 4.4</a>
     */
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "请求范围不满足"),

    /**
     * {@code 417 Expectation Failed}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.14">HTTP/1.1:
     *      Semantics and Content, section 6.5.14</a>
     */
    EXPECTATION_FAILED(417, "期望失败"),

    /**
     * {@code 418 I'm a teapot}.
     *
     * @see <a href=
     *      "http://tools.ietf.org/html/rfc2324#section-2.3.2">HTCPCP/1.0</a>
     */
    I_AM_A_TEAPOT(418, "我是茶壶"),

    /**
     * @deprecated See <a href=
     *             "http://tools.ietf.org/rfcdiff?difftype=--hwdiff&url2=draft-ietf-webdav-protocol-06.txt">WebDAV
     *             Draft Changes</a>
     */
    @Deprecated
    INSUFFICIENT_SPACE_ON_RESOURCE(419, "资源空间不足"),

    /**
     * @deprecated See <a href=
     *             "http://tools.ietf.org/rfcdiff?difftype=--hwdiff&url2=draft-ietf-webdav-protocol-06.txt">WebDAV
     *             Draft Changes</a>
     */
    @Deprecated
    METHOD_FAILURE(420, "方法失效"),

    /**
     * @deprecated See <a href=
     *             "http://tools.ietf.org/rfcdiff?difftype=--hwdiff&url2=draft-ietf-webdav-protocol-06.txt">WebDAV
     *             Draft Changes</a>
     */
    @Deprecated
    DESTINATION_LOCKED(421, "目的地锁定"),

    /**
     * {@code 422 Unprocessable Entity}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.2">WebDAV</a>
     */
    UNPROCESSABLE_ENTITY(422, "无法处理的实体"),

    /**
     * {@code 423 Locked}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.3">WebDAV</a>
     */
    LOCKED(423, "锁定的"),

    /**
     * {@code 424 Failed Dependency}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.4">WebDAV</a>
     */
    FAILED_DEPENDENCY(424, "依赖失败"),

    /**
     * {@code 426 Upgrade Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2817#section-6">Upgrading to TLS
     *      Within HTTP/1.1</a>
     */
    UPGRADE_REQUIRED(426, "需要升级"),

    /**
     * {@code 428 Precondition Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc6585#section-3">Additional HTTP
     *      Status Codes</a>
     */
    PRECONDITION_REQUIRED(428, "要求先决条件"),

    /**
     * {@code 429 Too Many Requests}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc6585#section-4">Additional HTTP
     *      Status Codes</a>
     */
    TOO_MANY_REQUESTS(429, "请求太多"),

    /**
     * {@code 431 Request Header Fields Too Large}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc6585#section-5">Additional HTTP
     *      Status Codes</a>
     */
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "请求头字段太大"),

    /**
     * {@code 451 Unavailable For Legal Reasons}.
     *
     * @see <a href=
     *      "https://tools.ietf.org/html/draft-ietf-httpbis-legally-restricted-status-04">
     *      An HTTP Status Code to Report Legal Obstacles</a>
     * @since 4.3
     */
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "因法律原因无法获得"),


// --- 5xx Server Error ---


    /**
     * {@code 500 Internal Server Error}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.1">HTTP/1.1:
     *      Semantics and Content, section 6.6.1</a>
     */
    INTERNAL_SERVER_ERROR(500, "内部服务器错误"),

    /**
     * {@code 501 Not Implemented}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.2">HTTP/1.1:
     *      Semantics and Content, section 6.6.2</a>
     */
    NOT_IMPLEMENTED(501, "未实施"),

    /**
     * {@code 502 Bad Gateway}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.3">HTTP/1.1:
     *      Semantics and Content, section 6.6.3</a>
     */
    BAD_GATEWAY(502, "错误网关"),

    /**
     * {@code 503 Service Unavailable}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.4">HTTP/1.1:
     *      Semantics and Content, section 6.6.4</a>
     */
    SERVICE_UNAVAILABLE(503, "服务不可用"),

    /**
     * {@code 504 Gateway Timeout}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.5">HTTP/1.1:
     *      Semantics and Content, section 6.6.5</a>
     */
    GATEWAY_TIMEOUT(504, "网关超时"),

    /**
     * {@code 505 HTTP Version Not Supported}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.6">HTTP/1.1:
     *      Semantics and Content, section 6.6.6</a>
     */
    HTTP_VERSION_NOT_SUPPORTED(505, "不支持HTTP版本"),

    /**
     * {@code 506 Variant Also Negotiates}
     *
     * @see <a href="http://tools.ietf.org/html/rfc2295#section-8.1">Transparent
     *      Content Negotiation</a>
     */
    VARIANT_ALSO_NEGOTIATES(506, "变型也谈判"),

    /**
     * {@code 507 Insufficient Storage}
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.5">WebDAV</a>
     */
    INSUFFICIENT_STORAGE(507, "存储不足"),

    /**
     * {@code 508 Loop Detected}
     *
     * @see <a href="http://tools.ietf.org/html/rfc5842#section-7.2">WebDAV Binding
     *      Extensions</a>
     */
    LOOP_DETECTED(508, "回路检测"),

    /**
     * {@code 509 Bandwidth Limit Exceeded}
     */
    BANDWIDTH_LIMIT_EXCEEDED(509, "超出带宽限制"),

    /**
     * {@code 510 Not Extended}
     *
     * @see <a href="http://tools.ietf.org/html/rfc2774#section-7">HTTP Extension
     *      Framework</a>
     */
    NOT_EXTENDED(510, "未扩展"),

    /**
     * {@code 511 Network Authentication Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc6585#section-6">Additional HTTP
     *      Status Codes</a>
     */
    NETWORK_AUTHENTICATION_REQUIRED(511, "需要网络认证");


    /**
     * 编码
     */
    private Integer code;


    /**
     * 消息
     */
    private String message;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer code() {
        return this.code;
    }


    public String message() {
        return this.message;
    }


    public static Integer getCode(String name) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.code;
            }
        }
        return null;
    }


    public static String getMessage(String name) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.message;
            }
        }
        return name;
    }


    @Override
    public String toString() {
        return this.name();
    }


    /**
     * 测试编码重复
     *
     * @param args
     */
    public static void main(String[] args) {
        ResultCode[] ResultCodes = ResultCode.values();
        List<Integer> list = new ArrayList<Integer>();
        for (ResultCode resultCode : ResultCodes) {
            if (list.contains(resultCode.code)) {
                System.out.println("编码重复：" + resultCode.code);
            } else {
                list.add(resultCode.code());
            }
        }
    }


}