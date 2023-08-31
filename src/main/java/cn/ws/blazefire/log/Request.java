package cn.ws.blazefire.log;

public class Request {
    // API标识
    public String apikey;
    // 国家代码
    public String country;
    // 已使用次数
    public int used;
    // 需要条数
    public int cnt;
    // 当前时间戳
    public long t;
    // 签名
    public String sig;
    // ext int
    public int extu1;
    // ext int
    public int extu2;
    // ext int
    public String exts1;
    // ext int
    public String exts2;

    //是否自检
    public int isCheck;
    //是否大号
    public int isBig;
    //是否专业
    public int isAdmin;
}