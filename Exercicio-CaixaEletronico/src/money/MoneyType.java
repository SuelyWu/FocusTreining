package money;

public enum MoneyType {
    N100, N50, N20, N10;

    public int toInt() {
        switch (this) {
            case N100:  return 100;
            case N50:   return 50;
            case N20:   return 20;
            case N10:   return 10;
        }
        return 0;
    }

}
