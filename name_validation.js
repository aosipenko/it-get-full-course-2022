class nameValidations {
    static validateName(name) {
        var re = new RegExp("^[A-Za-z]{3,20}$");
        if (re.test(name)) {
            return true;
        }
        return false;
    }

    static validateSurname(name) {
        var re = new RegExp("^[A-Za-z\d]{3,20}$");
        if (re.test(name)) {
            return true;
        }
        return false;
    }

    static validateAmount(value) {
        var re = new RegExp("^[0-9]{1,5}\\.[0-9]{1,2}$");
        if (re.test(value)) {
            console.log("its ok")
            return true;
        }
        console.error("its not ok")
        return false;
    }
}