<template>
  <div class="formulario">
    <h1>{{titulo}}</h1>
    <form @submit.prevent="cambiarInici()">
      <div class="form-group" v-if="registro">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" v-model="nombre" class="form-control" required />
      </div>
      <div class="form-group" v-if="registro">
        <label for="apellidos">Apellidos:</label>
        <input type="text" id="apellidos" v-model="apellidos" class="form-control" required />
      </div>
      <div class="form-group" v-if="registro">
        <label for="telefono">Teléfono:</label>
        <input type="tel" id="telefono" v-model="telefono" class="form-control" required />
      </div>
      <div class="form-group">
        <label for="username">Correo electrónico:</label>
        <input type="email" id="email" v-model="email" class="form-control" required />
      </div>
      <div class="form-group">
        <label for="password">Contraseña:</label>
        <input type="password" id="password" v-model="password" class="form-control" required />
      </div>
      <div class="form-group" v-if="registro">
        <label for="password">Confirma la contraseña:</label>
        <input type="password" id="password" v-model="password2" class="form-control" required />
      </div>
      <div>
        <button type="submit" class="btn btn-primary" @click="confirmarInicioSesion()" v-if="!registro">Iniciar sesión</button>
        <button type="submit" class="btn btn-primary" @click="cambiarInici()">Registrarse</button>
      </div>
      <p v-if="registro" @click="cambiarInici()" class="sicuenta">Tengo una cuenta</p>
      <div class="error-message" v-if="errorMessage">{{ errorMessage }}</div>
    </form>
  </div>
</template>
  
<script>
export default {
  data() {
    return {
      listaClientes: [],
      errorMessage: null,
      registro: false,
      titulo: "Iniciar sesión",
      nombre:"",
      apellidos:"",
      telefono:"",
      email: "",
      password: "",
      password2: ""
    };
  },
  methods: {
    cambiarInici(){
      if (this.registro) {
        this.confirmarResgistroSesion();
      }else {
        this.registro=true;
        this.errorMessage = null;
        this.titulo = "Resgistrarse";
        this.nombre = "";
        this.apellidos = "";
        this.telefono ="";
        this.email = ""
        this.password = "";
        this.password2 = "";
      }
    },
    confirmarInicioSesion(){
      this.errorMessage = "";
      let log = false;
      for (let i = 0; i < this.listaClientes.length; i++) {
        if (this.listaClientes[i].email === this.email && this.listaClientes[i].password === this.password) {
          log = true;
        }
      }
      if (log) {
        this.emitirLogin();
      }else {
        this.errorMessage = "Error al iniciar sesion";
        this.password = "";
      }
    },
    emitirLogin(){
      this.$emit("usuarioLogeado" , this.email);
    },
    confirmarResgistroSesion(){
      let registrar = true;

      for (let i = 0; i < this.listaClientes.length; i++) {
        if (this.listaClientes[i].email === this.email) {
            this.errorMessage = "Este correo ya tiene una cuenta";
            this.registro = false,
            this.titulo = "Iniciar sesión";
            this.nombre = "";
            this.apellidos = "";
            this.telefono ="";
            this.password = "";
            this.password2 = "";
            registrar = false;
        }
      }

      if (this.password !== this.password2) {
        this.errorMessage = "No coinciden las contraseñas";
        this.password = "";
        this.password2 ="";
        registrar = false;
      }

      if (registrar) {
        let cliente = {
          nombre: this.nombre,
          apellidos: this.apellidos,
          telefono: this.telefono,
          email: this.email,
          password: this.password
        }
        
        fetch('http://localhost:8080/tiendaTattoos/clientes', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(cliente)
        })
        .then(response => response.json())
        .then(data => console.log('Success:', data))
        .catch((error) => console.error('Error:', error));

        this.registro = false,
        this.titulo = "Iniciar sesión";
        this.nombre = "";
        this.apellidos = "";
        this.telefono ="";
        this.password2 = "";
        this.errorMessage = "Resgistrado Correctamente Inicie sesión";
        this.listarClientes();
      }
    },
    listarClientes() {
      fetch('http://localhost:8080/tiendaTattoos/clientes')
        .then(response => response.json())
        .then(json => this.listaClientes = json);
        this.errorMessage = "";
    },
  },
  created(){
       this.listarClientes();
  }
};
</script>
  
<style scoped>
.formulario {
  padding: 2%;
  background-color: rgb(248, 212, 197);
  text-align: center;
  margin: 5% auto 17.9%;
  width: 20%;
  border-radius: 18px;
}

.sicuenta{
  cursor: pointer;
}

.formulario input, select, textarea{
  background-color: rgb(245, 193, 178);
  border: 1px solid rgb(248, 174, 154);
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
  padding: 3% 5%;
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