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