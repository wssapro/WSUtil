package cn.ws.tools.InterestRate;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-10-08 18:31
 */
public class InterestNode {
    Double total;
    Double monthlyPaymen;
    Double totalInterest;
    Double totalPaymen;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getMonthlyPaymen() {
        return monthlyPaymen;
    }

    public void setMonthlyPaymen(Double monthlyPaymen) {
        this.monthlyPaymen = monthlyPaymen;
    }

    public Double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(Double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public Double getTotalPaymen() {
        return totalPaymen;
    }

    public void setTotalPaymen(Double totalPaymen) {
        this.totalPaymen = totalPaymen;
    }
}
