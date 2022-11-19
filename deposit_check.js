class depositCheck {
    static deposit_check(amount) {
        if (amount >= 10000.05 || amount < 500.0) {
            return false;
        }
        return true;
    }

    static deposit_round(amount) {
        var roundDownValue = Math.round(amount * 100) % 5;
        if (roundDownValue > 0) {
            return (Math.round(amount * 100) - roundDownValue) / 100;
        } else {
            return amount;
        }
    }
}
