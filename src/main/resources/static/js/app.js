var statusName = "true";
var statusSurname = "true";
var statusEmail = "true";

function validateFirstName(ev) {
    var firstName = ev.target.value;
    var errorBox = this.parentElement.nextElementSibling;

    if(!validator.longerThan(3, firstName)){
        this.classList.add("error-border");
        errorBox.textContent = "First name should be longer than 3";
        statusName = "false";
    } else {
        this.classList.remove("error-border");
        errorBox.textContent = "";
        statusName = "true";
    }
}

function validateSurname(ev) {
    var surname = ev.target.value;
    var errorBox = this.parentElement.nextElementSibling;

    if(!validator.longerThan(3, surname)){
        this.classList.add("error-border");
        errorBox.textContent = "Surname should be longer than 3";
        statusSurname = "false";
    } else {
        this.classList.remove("error-border");
        errorBox.textContent = "";
        statusSurname = "true";
    }
}

function validateEmail(ev) {
    var email = ev.target.value;
    var errorBox = this.parentElement.nextElementSibling;
    if(!validator.mailWithSpecialCharAt(email)){
        this.classList.add("error-border");
        errorBox.textContent = "Email should be @";
        statusEmail = "false";
    } else {
        this.classList.remove("error-border");
        errorBox.textContent = "";
        statusEmail = "true";
    }
    if(!validator.mailWithSpecialCharDot(email)){
        this.classList.add("error-border");
        errorBox.textContent = "Email should be . after @";
        statusEmail = "false";
    } else {
        this.classList.remove("error-border");
        errorBox.textContent = "";
        statusEmail = "true";
    }
}

function validateForm() {

    if (statusName == "false" || statusSurname == "false" || statusEmail == "false") {
        alert("All field must be correct");
        return false;
    }
}
document.getElementsByName("name")[0].addEventListener("change", validateFirstName);
document.getElementsByName("surname")[0].addEventListener("change", validateSurname);
document.getElementsByName("email")[0].addEventListener("change", validateEmail);