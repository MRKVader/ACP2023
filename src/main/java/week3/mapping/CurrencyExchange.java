package week3.mapping;

public class CurrencyExchange {

    private String ccy;
    private String base_ccy;
    private double buy;
    private double sale;

    public CurrencyExchange() {
    }


    public CurrencyExchange(String ccy, String base_ccy, double buy, double sale) {
        this.ccy = ccy;
        this.base_ccy = base_ccy;
        this.buy = buy;
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "DepartmentsPB{" +
                "ccy='" + ccy + '\'' +
                ", base_ccy='" + base_ccy + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}
