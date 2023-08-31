package cn.ws.tools.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-05-26 21:34
 */
public class ExcelUtil extends AnalysisEventListener<Map<Integer, String>> {

    @Override
    public void invoke(Map<Integer, String> o, AnalysisContext analysisContext) {
        analysisContext.readWorkbookHolder().setIgnoreEmptyRow(false);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return false;
    }
}
