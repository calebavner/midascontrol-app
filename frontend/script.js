const btnLogin = document.getElementById('btn-login');
const email = document.getElementById('input-email');
const password = document.getElementById('input-password');

btnLogin.addEventListener('click', (event) => {
    event.preventDefault();

    const login = {
        email: email.value,
        password: password.value
    }

    console.log(login)
})