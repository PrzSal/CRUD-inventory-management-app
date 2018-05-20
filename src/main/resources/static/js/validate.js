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
};