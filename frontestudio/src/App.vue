<template>
  <div class="pagina">
    <div class="menu">
      <nav>
        <router-link to="/" class="objMenu">Home</router-link> |
        <router-link to="/galeria" class="objMenu">Galeria</router-link> |
        <router-link to="/tatuadores" class="objMenu">Tatuadores</router-link> |
        <router-link to="/nosotros" class="objMenu">Sobre Nosotros</router-link>
      </nav>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {},
};
</script>

<style>
body {
  margin: 0;
  background-image: url("assets/fondo.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
}

.pagina {
  height: 100vh;
}

.menu {
    background-color: rgba(51, 51, 51, 0.8);
    padding: 10px 0;
    text-align: center;
    height: 75px;
    font-size: 3em;
}

.menu nav {
    display: inline-block;
}

.objMenu {
    color: white;
    text-decoration: none; 
    margin: 0 15px; 
    font-size: 18px; 
}

.objMenu:hover {
    color: #ff6347;
}
</style>
