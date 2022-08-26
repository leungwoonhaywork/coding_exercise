package org.example.start;

import org.example.function.*;

public class Factory {
    public static ShowData getChoice(int choice) throws Exception {
        switch (choice) {
            case 1:
                return new ShowAllTransactions();
            case 2:
                return new ShowTotalOutgoing();
            case 3:
                return new ShowMonthlyAverage();
            case 4:
                return new ShowHighestSpend();
            case 5:
                return new ShowLowestSpend();
            default:
                throw new Exception();

        }
    }
}
