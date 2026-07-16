document.addEventListener("DOMContentLoaded", function () {

    const email = document.getElementById("email");
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirmPassword");

    const registerButton = document.getElementById("registerButton");

    const successMessage = document.getElementById("successMessage");
    const errorMessage = document.getElementById("errorMessage");

    registerButton.addEventListener("click", function () {

        successMessage.innerText = "";
        errorMessage.innerText = "";

        const emailValue = email.value.trim();
        const passwordValue = password.value;
        const confirmPasswordValue = confirmPassword.value;

        // Empty Email
        if (emailValue === "") {
            errorMessage.innerText = "Email is required";
            return;
        }

        // Invalid Email Format
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailRegex.test(emailValue)) {
            errorMessage.innerText = "Invalid email format";
            return;
        }

        // Existing Email
        if (emailValue.toLowerCase() === "existinguser@example.com") {
            errorMessage.innerText = "Email already exists";
            return;
        }

        // Empty Password
        if (passwordValue === "") {
            errorMessage.innerText = "Password is required";
            return;
        }

        // Password Length
        if (passwordValue.length < 8) {
            errorMessage.innerText = "Password must be at least 8 characters";
            return;
        }

        // Uppercase
        if (!/[A-Z]/.test(passwordValue)) {
            errorMessage.innerText =
                "Password must contain at least one uppercase character";
            return;
        }

        // Lowercase
        if (!/[a-z]/.test(passwordValue)) {
            errorMessage.innerText =
                "Password must contain at least one lowercase character";
            return;
        }

        // Special Character
        if (!/[!@#$%^&*(),.?":{}|<>]/.test(passwordValue)) {
            errorMessage.innerText =
                "Password must contain at least one special character";
            return;
        }

        // Confirm Password
        if (passwordValue !== confirmPasswordValue) {
            errorMessage.innerText = "Passwords do not match";
            return;
        }

        // Registration Success
        successMessage.innerText = "Registration Successful";

    });

});