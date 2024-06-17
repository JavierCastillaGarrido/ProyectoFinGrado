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
    <div id="vistas">
      <router-view />
    </div>
    <div id="footer">
      <div class="copy">
        ©2023-2024 Drawtatoo - Javier - Jorge | Drawtatoo es una empresa de tatuajes | All rights reserved - Todos los derechos reservados
      </div>
      <div class="redes">   
          <a href="#"><img src="./assets/icon-facebook.png" alt="face"></a>
          <a href="#"><img src="./assets/icon-instagram.png" alt="insta"></a>
          <a href="#"><img src="./assets/icon-twitter.png" alt="twt"></a>
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
      font-family: 'Times New Roman', Times, serif;
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
  height: 7%;
}

nav{
  display: flex;
  flex-direction: row;
  width: 65%;
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
  padding: 2% 15%;
  color: white;
  font-size: 20px; 
}

.objMenu a:hover {
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
  width: 20%;
  display: flex;
  flex-direction: row;
  
}

.redes a{
  width: 10%;
  margin: 0 2%;
  align-items: center;
}

.redes a img{
  width: 100%;
}

</style>
