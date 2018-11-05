package beans;

public class TradingInf {
    //交易Id
    private int tradingId;
    //交易商品Id
    private int tradingGoodsId;
    //交易买家Id
    private int tradingUserId;
    //交易数量
    private int tradingNumber;

    public int getTradingId() {
        return tradingId;
    }

    public void setTradingId(int tradingId) {
        this.tradingId = tradingId;
    }

    public int getTradingGoodsId() {
        return tradingGoodsId;
    }

    public void setTradingGoodsId(int tradingGoodsId) {
        this.tradingGoodsId = tradingGoodsId;
    }

    public int getTradingUserId() {
        return tradingUserId;
    }

    public void setTradingUserId(int tradingUserId) {
        this.tradingUserId = tradingUserId;
    }

    public int getTradingNumber() {
        return tradingNumber;
    }

    public void setTradingNumber(int tradingNumber) {
        this.tradingNumber = tradingNumber;
    }
}
