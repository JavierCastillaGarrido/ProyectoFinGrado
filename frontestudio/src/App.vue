<template>
  <div class="pagina">
    <div id="menu">
      <nav>
        <div class="objMenu">
          <router-link to="/">Home</router-link> 
        </div>
        <div class="objMenu">
          <router-link to="/galeria">Galeria</router-link> 
        </div>
        <div class="objMenu"> 
          <router-link to="/tatuadores">Tatuadores</router-link> 
        </div>
        <div class="objMenu">
          <router-link to="/nosotros">Sobre Nosotros</router-link> 
        </div>
        <div class="objMenu nolinea">
          <router-link to="/login">Login</router-link>
        </div>
      </nav> 
    </div>
    <router-view />
    <div id="footer">
      <div class="copy">
        ©2023-2024 Drawtatoo - Javier - Jorge | Drawtatoo es una empresa de tatuajes | All rights reserved - Todos los derechos reservados
      </div>
      <div class="redes">
        <div>
          <a href="#"><img src="assets/icon-facebook.png" alt="face"></a>
        </div>
        <div>
          <a href="#"><img src="assets/icon-instagram.png" alt="insta"></a>
        </div>
        <div>
          <a href="#"><img src="assets/icon-twitter.png" alt="twt"></a>
        </div>
      </div>
    </div>
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

html, body {
      overflow: auto;
      scrollbar-width: none;
      -ms-overflow-style: none;  
}

html::-webkit-scrollbar, body::-webkit-scrollbar {
  display: none; 
}

body {
  margin: 0;
  background-image: url("assets/fondo.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
}


a{
  text-decoration: none;
}

.pagina {
  height: 100vh;
}

#menu, #footer{
  display: flex;
  flex-direction: column;
  background-color: rgba(51, 51, 51, 0.8);
  align-items: center;
  height: 6vh;
}

nav{
  display: flex;
  flex-direction: row;
  width: 60%;
  margin: auto;
}

.objMenu{
  width: 20%;
  margin: 0;
  padding: 1% 0;
  text-align: center;
  border-right: 2px solid black;
}

.nolinea{
  border: 0;
}

.objMenu a{
  padding: 2% 25%;
  color: white;
  font-size: 20px; 
}

.objMenu a:hover {
  padding: 2% 23%;
  transition: 0.5s;
  color: #fd5437;
  font-size: 21px; 
}

#footer{
  clear: both;
  flex-direction: row;
}

.copy{
  width: 80%;
  color: white;
  font-size: smaller;
  text-align: center;
}

.redes{
  display: flex;
  flex-direction: row;
  margin: auto;
  justify-content: space-between;
}

</style>
