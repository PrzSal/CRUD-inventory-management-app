validator = {
    longerThan: function (length, string) {
        return string.length > length;
    },

    mailWithSpecialCharAt: function (email) {
        var result = false;
        for (var i = 0; i < email.length; i++) {
            if (email.charAt(i) === '@') {
                result = true;
            }
        }
        return result;
    },

    mailWithSpecialCharDot: function (email) {
        var resultMail = false;
        var indexApp = 0;
        for (var i = 0; i < email.length; i++) {
            if (email.charAt(i) === '@') {
                resultMail = true;
                indexApp = i;
            }
        }
        if (resultMail === true) {
            var resultDot = false;
            for (var i = 0; i < email.length; i++) {
                if (email.charAt(i) === '.' && i > indexApp + 1) {
                    resultDot = true;
                }
            }
        }
        return resultDot;
    },
};