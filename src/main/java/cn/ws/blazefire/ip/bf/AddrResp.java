package cn.ws.blazefire.ip.bf;

import lombok.Data;

import java.util.List;

@Data
public class AddrResp {
    private int status;

    private String proxyHost;

    private String proxyPort;

    private List<Ss5LineResp> list;

    private String msg;
}
