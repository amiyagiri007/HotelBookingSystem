// form-validation.js

document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('signupForm');
    
    form.addEventListener('submit', function(event) {
        let isValid = true;
        
        // Validate Full Name
        const name = document.getElementById('name');
        if (name.value.trim() === '') {
            isValid = false;
            name.classList.add('is-invalid');
        } else {
            name.classList.remove('is-invalid');
        }
        
        // Validate Email
        const email = document.getElementById('email');
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailPattern.test(email.value.trim())) {
            isValid = false;
            email.classList.add('is-invalid');
        } else {
            email.classList.remove('is-invalid');
        }
        
        // Validate Password
        const password = document.getElementById('password');
        if (password.value.trim().length < 6) {
            isValid = false;
            password.classList.add('is-invalid');
        } else {
            password.classList.remove('is-invalid');
        }
        
        // Validate Checkbox
        const checkbox = document.getElementById('checkbox1');
        if (!checkbox.checked) {
            isValid = false;
            checkbox.classList.add('is-invalid');
        } else {
            checkbox.classList.remove('is-invalid');
        }
        
        // Prevent form submission if any field is invalid
        if (!isValid) {
            event.preventDefault();
        }
    });
});
