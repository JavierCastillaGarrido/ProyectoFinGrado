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
}

.pagina {
  display: grid;
  grid-template-rows: repeat(7, 1fr);
  gap: 10px;
  width: 100vw;
  height: 100vh;
}

.menu {
  flex: 0 0 auto;
  display: flex;
  flex-direction: row;
  background-color: #3f51b5;
  color: #fff;
}
.objMenu {
  padding: 10px;
  color: #fff;
  text-decoration: none;
  transition: background-color 0.3s;
}
.objMenu:hover {
  background-color: #6573c3;
}
</style>
