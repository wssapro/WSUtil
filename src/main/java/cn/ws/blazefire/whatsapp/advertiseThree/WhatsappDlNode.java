package cn.ws.blazefire.whatsapp.advertiseThree;

import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-04-13 20:01
 */
public class WhatsappDlNode {

    private int type;
    private Integer cd;
    private String importId;
    private List<WhatsappDlTokenNode> list;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getCd() {
        return cd;
    }

    public void setCd(Integer cd) {
        this.cd = cd;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public List<WhatsappDlTokenNode> getList() {
        return list;
    }

    public void setList(List<WhatsappDlTokenNode> list) {
        this.list = list;
    }
}
