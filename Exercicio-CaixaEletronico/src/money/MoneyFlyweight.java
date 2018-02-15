package money;

import java.util.HashMap;
import java.util.Map;

public class MoneyFlyweight {

    private final Map<MoneyType, Money> existMoneyMap = new HashMap<>();

    public Money getMoney(MoneyType moneyType) {
        Money money = existMoneyMap.get(moneyType);
        if (money == null) {
            money = new Money(moneyType);
            existMoneyMap.put(moneyType, money);
        }
        return money;
    }
}
