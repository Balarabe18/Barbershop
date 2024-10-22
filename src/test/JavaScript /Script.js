document.getElementById('signUpLink').addEventListener('click', function(e) {
    e.preventDefault();
    document.querySelector('.form-box.login').classList.remove('active');
    document.querySelector('.form-box.register').classList.add('active');
});

document.getElementById('signInLink').addEventListener('click', function(e) {
    e.preventDefault();
    document.querySelector('.form-box.register').classList.remove('active');
    document.querySelector('.form-box.login').classList.add('active');
});

document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    let isValid = true;

    // Clear previous errors
    document.querySelectorAll('.error').forEach(error => error.textContent = '');

    // Validate email
    const email = document.getElementById('loginEmail').value;
    if (email.trim() === '') {
        document.getElementById('loginEmailError').textContent = 'Email is required';
        isValid = false;
    } else if (!validateEmail(email)) {
        document.getElementById('loginEmailError').textContent = 'Invalid email format';
        isValid = false;
    }

    // Validate password
    const password = document.getElementById('loginPassword').value;
    if (password.trim() === '') {
        document.getElementById('loginPasswordError').textContent = 'Password is required';
        isValid = false;
    }

    if (isValid) {
        alert('Login successful!');
        // Here you can add code to send the form data to the server
    }
});

document.getElementById('signupForm').addEventListener('submit', function(e) {
    e.preventDefault();

    let isValid = true;

    // Clear previous errors
    document.querySelectorAll('.error').forEach(error => error.textContent = '');

    // Validate name
    const name = document.getElementById('name').value;
    if (name.trim() === '') {
        document.getElementById('nameError').textContent = 'Name is required';
        isValid = false;
    }

    // Validate email
    const email = document.getElementById('signupEmail').value;
    if (email.trim() === '') {
        document.getElementById('signupEmailError').textContent = 'Email is required';
        isValid = false;
    } else if (!validateEmail(email)) {
        document.getElementById('signupEmailError').textContent = 'Invalid email format';
        isValid = false;
    }

    // Vali
