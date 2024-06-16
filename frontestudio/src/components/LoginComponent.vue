<template>
  <div class="login-container">
    <h1>Iniciar sesión</h1>
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="username">Nombre de usuario:</label>
        <input type="text" id="username" v-model="username" class="form-control" required />
      </div>
      <div class="form-group">
        <label for="password">Contraseña:</label>
        <input type="password" id="password" v-model="password" class="form-control" required />
      </div>
      <button type="submit" class="btn btn-primary">Iniciar sesión</button>
      <div class="error-message" v-if="errorMessage">{{ errorMessage }}</div>
      <button type="submit" class="btn btn-primary">Registrarse</button>
      <div class="error-message" v-if="errorMessage">{{ errorMessage }}</div>
    </form>
  </div>
</template>
  
<script>
export default {
  data() {
    return {
      username: "",
      password: "",
      errorMessage: null,
    };
  },
  methods: {
    handleSubmit() {
      // Implementar la lógica de login aquí
      // fetch para login
      //       async function handleLogin() {
      //   const username = document.getElementById('username').value;
      //   const password = document.getElementById('password').value;
      //   try {
      //     const response = await fetch('/login', {
      //       method: 'POST',
      //       headers: {
      //         'Content-Type': 'application/json',
      //       },
      //       body: JSON.stringify({
      //         username,
      //         password,
      //       }),
      //     });
      //     if (response.ok) {
      //       const data = await response.json();
      //       // Handle login success
      //       console.log('Login successful!', data);
      //       // Redireccionar a la página principal o realizar otra acción
      //     } else {
      //       const error = await response.json();
      //       // Handle login error
      //       console.error('Login failed:', error);
      //       alert('Error al iniciar sesión: ' + error.message);
      //     }
      //   } catch (error) {
      //     console.error('Error al realizar la petición:', error);
      //     alert('Error de red. Inténtalo de nuevo más tarde.');
      //   }
      // }
    },
  },
};
</script>
  
<style scoped>
.login-container {
  text-align: center;
  margin: 20px auto;
  max-width: 300px;
}

.form-group {
  margin-bottom: 15px;
}

.form-control {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.btn {
  padding: 10px 20px;
  margin: 5%;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.error-message {
  color: red;
  margin-top: 10px;
}
</style>