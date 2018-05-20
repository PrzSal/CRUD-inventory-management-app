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